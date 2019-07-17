package com.bookstore.controller;

import com.bookstore.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.EasyUITree;
import pojo.ResponseJsonResult;

import java.util.List;

/**
 * 商品分类管理控制器
 */
@Controller
@RequestMapping("/product_category")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;
    /**
     * 根据parentId返回数据列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITree> getProductCategoryByParentId(@RequestParam(value = "id",defaultValue = "0")Short parentId){
        List<EasyUITree> easyUITrees = productCategoryService.findProductCategoryByParentId(parentId);
        return easyUITrees;
    }


    /**
     * 添加分类
     */
    @RequestMapping("/add")
    @ResponseBody
    public ResponseJsonResult addCategory(Short parentId, String name) {
        ResponseJsonResult responseJsonResult = productCategoryService.addCategory(parentId, name);
        return responseJsonResult;
    }
}
