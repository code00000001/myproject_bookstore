package com.bookstore.service.impl;

import com.bookstore.mapper.ProductCategoryMapper;
import com.bookstore.pojo.ProductCategory;
import com.bookstore.pojo.ProductCategoryExample;
import com.bookstore.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.EasyUITree;
import pojo.ResponseJsonResult;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryMapper productCategoryMapper;
    @Override
    public List<EasyUITree> findProductCategoryByParentId(Short parentId) {
        ProductCategoryExample example = new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<ProductCategory> productCategoryList = productCategoryMapper.selectByExample(example);
        List<EasyUITree> easyUITrees = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            EasyUITree easyUITree = new EasyUITree();
            easyUITree.setId(productCategory.getId());
            easyUITree.setText(productCategory.getName());
            easyUITree.setState(productCategory.getParentId() == 0?"closed":"open");
            easyUITrees.add(easyUITree);
        }
        return easyUITrees;
    }

    @Override
    public ResponseJsonResult addCategory(Short parentId, String name) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(parentId);
        productCategory.setName(name);
        productCategoryMapper.insert(productCategory);
        ResponseJsonResult responseJsonResult = new ResponseJsonResult();
        responseJsonResult.setMsg(productCategory.getId()+"");
        return responseJsonResult;
    }
}
