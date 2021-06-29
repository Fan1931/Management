package com.cy.yan.service.impl;

import com.cy.common.annotation.RequiredLog;
import com.cy.common.exception.ServiceException;
import com.cy.common.vo.Node;
import com.cy.yan.dao.YRoleMenusDao;
import com.cy.yan.entity.YMenus;
import com.cy.yan.dao.YMenusDao;
import com.cy.yan.service.YMenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (YMenus)表服务实现类
 *
 * @author if
 * @since 2021-06-08 11:39:43
 */
@Service("yMenusService")
public class YMenusServiceImpl implements YMenusService {
    @Resource
    private YMenusDao yMenusDao;
    @Autowired
    private YRoleMenusDao yRoleMenusDao;

    @Override
    @RequiredLog("删除权限")
    public int doDeleteObject(Integer id) {
        //1.验证参数有效性
        if(id==null||id<1)
            throw new IllegalArgumentException("id值不正确");
        //2.判定菜单是否有子菜单
        int childCount=yMenusDao.getChildCount(id);
        if(childCount>0)
            throw new ServiceException("请先删除子权限");
        //3.删除菜单自身信息
        int rows=yMenusDao.deleteObject(id);
        if(rows==0)
            throw new ServiceException("权限可能已经不存在");
        //4.删除菜单关系数据
        yRoleMenusDao.deleteObjectsByMenuId(id);
        return rows;
    }

    @Override
    public List<Map<String, Object>> findObjects() {
        List<Map<String, Object>> list = yMenusDao.findObjects();
        if(list==null||list.size()==0)
            throw new ServiceException("没有对应数据");
        return list;
    }

    @Override
    public List<Node> doFindZtreeMenuNodes() {
        return yMenusDao.findZtreeMenuNodes();
    }

    @Override
    @RequiredLog("添加权限")
    public int saveObject(YMenus entity) {
        //1.进行参数校验
        if(entity==null)
            throw new IllegalArgumentException("保存对象不能为空");
        if(StringUtils.isEmpty(entity.getName()))
            throw new IllegalArgumentException("权限名不能为空");
        if(StringUtils.isEmpty(entity.getPermission()))
            throw new IllegalArgumentException("权限标识不能为空");
        //....
        //2.将对象写入到数据库
        int rows=0;
        try {
            rows=yMenusDao.insertObject(entity);
        }catch(Throwable e) {
            e.printStackTrace();
            throw new ServiceException("save error");
        }
        return rows;
    }

    @Override
    @RequiredLog("修改权限")
    public int updateObject(YMenus entity) {
        //1.进行参数校验
        if(entity==null)
            throw new IllegalArgumentException("保存对象不能为空");
        if(StringUtils.isEmpty(entity.getName()))
            throw new IllegalArgumentException("权限名不能为空");
        if(StringUtils.isEmpty(entity.getPermission()))
            throw new IllegalArgumentException("权限标识不能为空");
        //....
        //2.将对象写入到数据库
        int rows=0;
        try {
            rows=yMenusDao.updateObject(entity);
        }catch(Throwable e) {
            e.printStackTrace();
            throw new ServiceException("update error");
        }
        return rows;
    }
}
