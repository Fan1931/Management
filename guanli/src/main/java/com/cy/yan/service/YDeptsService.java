package com.cy.yan.service;

import com.cy.common.vo.Node;
import com.cy.yan.entity.YDepts;

import java.util.List;
import java.util.Map;

public interface YDeptsService {

    YDepts queryById(Integer id);

    YDepts update(YDepts yDepts);

    boolean deleteById(Integer id);

    List<Map<String,Object>> findObjects();

    int save(YDepts entity);

    List<Node> findZTreeNodes();
}
