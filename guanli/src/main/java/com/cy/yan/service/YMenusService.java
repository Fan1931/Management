package com.cy.yan.service;

import com.cy.common.vo.Node;
import com.cy.yan.entity.YMenus;

import java.util.List;
import java.util.Map;

/**
 * (YMenus)表服务接口
 *
 * @author if
 * @since 2021-06-08 11:39:43
 */
public interface YMenusService {

    int doDeleteObject(Integer id);

    List<Map<String,Object>> findObjects();

    List<Node> doFindZtreeMenuNodes();

    int saveObject(YMenus entity);

    int updateObject(YMenus entity);

}
