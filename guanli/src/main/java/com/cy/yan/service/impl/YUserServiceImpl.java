package com.cy.yan.service.impl;

import com.cy.common.annotation.RequiredLog;
import com.cy.common.exception.ServiceException;
import com.cy.common.util.PageUtil;
import com.cy.common.vo.PageObject;
import com.cy.yan.dao.YUserDao;
import com.cy.yan.dao.YUserRoleDao;
import com.cy.yan.entity.YUser;
import com.cy.yan.service.YUserService;
import com.cy.yan.vo.YUserDept;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * (YUser)表服务实现类
 *
 * @author if
 * @since 2021-06-02 18:06:20
 */
@RequiresPermissions("user:*")
@Service("yUserService")
public class YUserServiceImpl implements YUserService {

    @Autowired
    private YUserDao yUserDao;

    @Autowired
    private YUserRoleDao yUserRoleDao;

    @Override
    public boolean deleteById(Integer id) {
        return this.yUserDao.deleteById(id) > 0;
    }


    @Transactional(propagation= Propagation.REQUIRES_NEW)//并不是没有事务,相当于是使用了中乐观锁机制
    @Override
    public PageObject<YUserDept> findPageObjects(String username, Integer pageCurrent) {
        //1.判定参数有效性
        if(pageCurrent==null||pageCurrent<1)
            throw new IllegalArgumentException("当前页码值不正确");
        //2.查询总记录数
        int rowCount=yUserDao.getRowCount(username);
        if(rowCount==0)
            throw new ServiceException("没有找到对应记录");
        //3.查询当前页记录信息
        int pageSize=3;
        int startIndex=(pageCurrent-1)*pageSize;
        List<YUserDept> records=yUserDao.findPageObjects(username, startIndex, pageSize);
        //4.封装数据并返回
        return PageUtil.newInstance(pageCurrent, rowCount, pageSize, records);
    }

    @RequiresPermissions("y:*")
    @RequiredLog("禁用启用")
    @Override
    public int validById(Integer id, Integer valid, String modifiedUser) {
        if(id==null||id<1)
            throw new IllegalArgumentException("id值无效");
        if(valid!=1&&valid!=0)
            throw new IllegalArgumentException("状态值无效");
        int rows=yUserDao.validById(id, valid, modifiedUser);
        if(rows==0)
            throw new ServiceException("记录可能已经不存在");
        return rows;
    }

    @Override
    public Map<String, Object> findObjectById(Integer id) {
        //1.参数校验
        if(id==null||id<1)
            throw new IllegalArgumentException("参数值无效");
        //2.基于用户id获取用户以及对应的部门信息
        YUserDept user=yUserDao.findObjectById(id);
        if(user==null)
            throw new ServiceException("记录可能已经不存在");
        //3.基于用户id获取用户对应的角色信息
        List<Integer> roleIds=yUserRoleDao.findRoleIdsByUserId(id);
        //4.对如上两次查询结果进行封装
        Map<String,Object> map=new HashMap<>();
        map.put("user", user);
        map.put("roleIds", roleIds);
        return map;
    }

    @Transactional
    @Override
//    @RequiredLog("创建用户")
    public int saveObject(YUser entity, Integer[] roleIds) {
        //1.参数校验
        if(entity==null)
            throw new IllegalArgumentException("保存对象不能为空");
        if(StringUtils.isEmpty(entity.getUsername()))
            throw new IllegalArgumentException("用户名不能为空");
        if (entity.getUsername().length() < 2)
            throw new IllegalArgumentException("用户名至少为两位");
        if(StringUtils.isEmpty(entity.getPassword()))
            throw new IllegalArgumentException("密码不能为空");
        if (entity.getPassword().length() < 6)
            throw new IllegalArgumentException("密码格式有误，最少六位密码");
//        if (!entity.getDeptId().equals(1)) {
//            throw new IllegalArgumentException("班级代码错误");
//        }
        if(roleIds==null||roleIds.length==0)
            throw new IllegalArgumentException("必须为用户分配角色");
        //...
        //2.对密码进行加密
        String salt= UUID.randomUUID().toString();
        SimpleHash sh=new SimpleHash(
                "MD5",//algorithmName加密算法
                entity.getPassword(),//source 被加密的对象
                salt, //salt 盐值
                1);//hashIterations 加密
        entity.setSalt(salt);
        entity.setPassword(sh.toHex());
        //3.保存用户自身信息
        int rows=yUserDao.insertObject(entity);
        //4.保存用户与角色关系数据
        int urows=yUserRoleDao.insertObjects(entity.getId(), roleIds);
        if(urows<=0)
            throw new ServiceException("关系数据保存失败");
        //5.返回结果
        return rows;
    }

    @Override
    @RequiredLog("删除用户")
    public int deleteObjectById(Integer id) {
        if(id==null||id<1)
            throw new IllegalArgumentException("参数值无效");
        int row = yUserDao.deleteById(id);
        int urow = yUserRoleDao.deleteObjectsByUserId(id);
        if(urow<=0)
            throw new ServiceException("删除失败");
        return row;
    }

    @Override
    @RequiredLog("修改用户")
    public int updateObject(YUser entity, Integer[] roleIds) {
        //1.参数校验
        if(entity==null)
            throw new IllegalArgumentException("保存对象不能为空");
        if(StringUtils.isEmpty(entity.getUsername()))
            throw new IllegalArgumentException("用户名不能为空");
        if(roleIds==null||roleIds.length==0)
            throw new IllegalArgumentException("必须为用户分配角色");
        //2.更新用户自身信息
        int rows=yUserDao.updateObject(entity);
        if(rows==0)
            throw new ServiceException("记录可能已经不存在");
        //4.保存用户与角色关系数据
        yUserRoleDao.deleteObjectsByUserId(entity.getId());
        yUserRoleDao.insertObjects(entity.getId(), roleIds);
        //5.返回结果
        return rows;
    }

    @Override
    @RequiredLog("修改密码")
    public int updatePassword(String password, String newPassword, String cfgPassword) {

        //long t1=System.currentTimeMillis();
        //1.判定新密码与密码确认是否相同
        if(StringUtils.isEmpty(newPassword))
            throw new IllegalArgumentException("新密码不能为空");
        if(StringUtils.isEmpty(cfgPassword))
            throw new IllegalArgumentException("确认密码不能为空");
        if(!newPassword.equals(cfgPassword))
            throw new IllegalArgumentException("两次输入的密码不相等");
        //2.判定原密码是否正确
        if(StringUtils.isEmpty(password))
            throw new IllegalArgumentException("原密码不能为空");
        //获取登陆用户
        YUser user=(YUser) SecurityUtils.getSubject().getPrincipal();
        SimpleHash sh=new SimpleHash("MD5", password, user.getSalt(), 1);
        if(!user.getPassword().equals(sh.toHex()))
            throw new IllegalArgumentException("原密码不正确");
        //3.对新密码进行加密
        String salt=UUID.randomUUID().toString();
        sh=new SimpleHash("MD5",newPassword,salt, 1);
        //4.将新密码加密以后的结果更新到数据库
        int rows=yUserDao.updatePassword(sh.toHex(), salt,user.getId());
        if(rows==0)
            throw new ServiceException("修改失败");
        //long t2=System.currentTimeMillis();
        //System.out.println("t2-t1="+(t2-t1));
        return rows;
    }

    @Override
    public boolean userNameIsOk(String username) {
        YUser user = yUserDao.findByUsername(username);
        if (user != null) {
            return true;
        }
        return false;
    }


    @Override
    public boolean doNameOK(String username) {
        YUser user = yUserDao.findByUsername(username);
        if (user != null) {
            return true;
        }
        return false;
    }

}
