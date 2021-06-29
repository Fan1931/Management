package com.cy.yan.service.impl;

import com.cy.common.annotation.RequiredLog;
import com.cy.common.exception.ServiceException;
import com.cy.common.util.PageUtil;
import com.cy.common.vo.CheckBox;
import com.cy.common.vo.PageObject;
import com.cy.yan.dao.YRoleMenusDao;
import com.cy.yan.dao.YUserRoleDao;
import com.cy.yan.vo.YRoleMenus;
import com.cy.yan.entity.YRoles;
import com.cy.yan.dao.YRolesDao;
import com.cy.yan.service.YRolesService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * (YRoles)表服务实现类
 *
 * @author if
 * @since 2021-06-02 18:06:19
 */
@Service("yRolesService")
@RequiresPermissions("role:*")
public class YRolesServiceImpl implements YRolesService {
    @Resource
    private YRolesDao yRolesDao;

    @Autowired
    private YRoleMenusDao yRoleMenusDao;

    @Autowired
    private YUserRoleDao yUserRoleDao;

    @Override
    public PageObject<YRoles> doFindPageObjects(String name, Integer pageCurrent) {
        //1.判定pageCurrent参数合法性
        if(pageCurrent==null||pageCurrent<1)
            throw new IllegalArgumentException("当前页码值不正确");
        //2.查询日志总记录数,并进行判定
        int rowCount=yRolesDao.getRowCount(name);
        if(rowCount==0)
            throw new ServiceException("没有找到对应记录");
        //3.查询当前页日志记录
        int pageSize=3;
        int startIndex=(pageCurrent-1)*pageSize;
        List<YRoles> records= yRolesDao.findPageObjects(name, startIndex, pageSize);
        //4.对查询结果进行封装并返回
        PageObject<YRoles> po = PageUtil.newInstance(pageCurrent, rowCount, pageSize, records);
        return po;
    }

    @Override
    public YRoleMenus doFindObjectById(Integer id) {
        if(id==null||id<1)
            throw new IllegalArgumentException("id值无效");
        YRoleMenus rm=yRolesDao.findObjectById(id);
        if(rm==null)
            throw new ServiceException("没有对应记录");
        return rm;
    }

    @Override
    @RequiredLog("添加角色")
    public int saveObject(YRoles entity, Integer[] menuIds) {
        //1.参数有效性校验
        if(entity==null)
            throw new IllegalArgumentException("保存对象不能为空");
        if(StringUtils.isEmpty(entity.getName()))
            throw new IllegalArgumentException("角色名不能为空");
        if(menuIds==null||menuIds.length==0)
            throw new IllegalArgumentException("必须为角色分配资源");
        //2.保存角色自身信息
        int rows=yRolesDao.insertObject(entity);
        //3.保存角色菜单关系数据
        yRoleMenusDao.insertObjects(entity.getId(), menuIds);
        //4.返回结果
        return rows;
    }

    @Override
    @RequiredLog("修改角色")
    public int updateObject(YRoles entity, Integer[] menuIds) {
        //1.参数有效性校验
        if(entity==null)
            throw new IllegalArgumentException("保存对象不能为空");
        if(StringUtils.isEmpty(entity.getName()))
            throw new IllegalArgumentException("角色名不能为空");
        if(menuIds==null||menuIds.length==0)
            throw new IllegalArgumentException("必须为角色分配资源");
        //2.保存角色自身信息
        int rows=yRolesDao.update(entity);
        //3.保存角色菜单关系数据
        yRoleMenusDao.deleteObjectsByRoleId(entity.getId());
        yRoleMenusDao.insertObjects(entity.getId(), menuIds);
        //4.返回结果
        return rows;
    }

    @Override
    @RequiredLog("删除角色")
    public int deleteObject(Integer id) {
        if(id==null||id<1)
            throw new IllegalArgumentException("id值不正确");
        int rows=yRolesDao.deleteById(id);
        if(rows==0)
            throw new ServiceException("记录可能已经不存在");
        yRoleMenusDao.deleteObjectsByRoleId(id);
        yUserRoleDao.deleteObjectsByRoleId(id);
        return 0;
    }

    @Override
    public List<CheckBox> findObjects() {
        return yRolesDao.findObjects();
    }
}
