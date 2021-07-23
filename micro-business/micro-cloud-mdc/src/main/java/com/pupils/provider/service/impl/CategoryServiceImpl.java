package com.pupils.provider.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pupils.provider.mapper.CategoryMapper;
import com.pupils.provider.model.domain.Category;
import com.pupils.provider.model.enums.CategoryLevel;
import com.pupils.provider.query.CategoryQuery;
import com.pupils.provider.service.CategoryService;
import com.pupils.provider.vo.CategoryVo;
import com.pupils.web.metadata.PageInfo;
import org.springframework.stereotype.Service;

/**
 * @author takesi
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Override
    public PageInfo queryCategory(CategoryQuery categoryQuery) {
        IPage<CategoryVo> page = new Page<>(categoryQuery.getCurrent(), categoryQuery.getPageSize());

        if (categoryQuery.getLevel() == null) {
            categoryQuery.setLevel(CategoryLevel.DEFAULT.getValue());
        }
        return null;
    }
}
