package com.pupils.provider.controller;

import com.pupils.provider.query.CategoryQuery;
import com.pupils.provider.service.CategoryService;
import com.pupils.web.controller.BaseController;
import com.pupils.web.metadata.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author takesi
 */
@RestController
@RequestMapping(value = "/category")
public class CategoryController extends BaseController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/tree")
    public PageInfo tree(CategoryQuery categoryQuery) {
        return categoryService.listWithTree(categoryQuery);
    }

}
