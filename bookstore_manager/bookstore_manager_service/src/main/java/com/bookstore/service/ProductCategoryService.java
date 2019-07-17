package com.bookstore.service;

import pojo.EasyUITree;
import pojo.ResponseJsonResult;

import java.util.List;

public interface ProductCategoryService {
    List<EasyUITree> findProductCategoryByParentId(Short parentId);

    /**
     * 添加菜单
     * @param parentId
     * @param name
     * @return
     */
    ResponseJsonResult addCategory(Short parentId, String name);
}
