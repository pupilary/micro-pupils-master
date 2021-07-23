package com.pupils.provider.controller;

import com.pupils.provider.query.CategoryQuery;
import com.pupils.provider.service.CategoryService;
import com.pupils.provider.vo.CategoryVo;
import com.pupils.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author takesi
 */
@RestController
@RequestMapping(value = "/category")
public class CategoryController extends BaseController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/tree")
    public List<CategoryVo> tree(CategoryQuery categoryQuery) {
        return null;
    }

}
