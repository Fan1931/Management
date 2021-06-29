package com.cy.yan.service.impl;

import com.cy.common.annotation.RequiredLog;
import com.cy.common.exception.ServiceException;
import com.cy.common.vo.Node;
import com.cy.yan.entity.YDepts;
import com.cy.yan.dao.YDeptsDao;
import com.cy.yan.service.YDeptsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service("yDeptsService")
public class YDeptsServiceImpl implements YDeptsService {

    @Resource
    private YDeptsDao yDeptsDao;

    @Override
    public YDepts queryById(Integer id) {
        return this.yDeptsDao.queryById(id);
    }

    @Override
    public YDepts update(YDepts yDepts) {
        this.yDeptsDao.update(yDepts);
        return this.queryById(yDepts.getId());
    }

    @Override
    @RequiredLog("删除部门")
    public boolean deleteById(Integer id) {
        return this.yDeptsDao.deleteById(id) > 0;
    }

    @Override
    public List<Map<String, Object>> findObjects() {
        return yDeptsDao.findObjects();
    }

    @Override
    @RequiredLog("添加部门")
    public int save(YDepts entity) {
        //1.合法验证
        if(entity==null)
            throw new ServiceException("保存对象不能为空");
        //2.保存数据
        int rows=yDeptsDao.insert(entity);
        return rows;
    }

    @Transactional(readOnly=true)//默认为false
    @Override
    public List<Node> findZTreeNodes() {
        return yDeptsDao.findZTreeNodes();
    }

}
