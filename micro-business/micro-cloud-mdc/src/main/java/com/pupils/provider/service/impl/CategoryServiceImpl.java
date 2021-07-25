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
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author takesi
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Override
    public PageInfo queryCategory(CategoryQuery categoryQuery) {
        IPage<Category> page = new Page<>(categoryQuery.getCurrent(), categoryQuery.getPageSize());

        if (categoryQuery.getLevel() == null) {
            categoryQuery.setLevel(CategoryLevel.DEFAULT.getValue());
        }
        IPage<Category> result = baseMapper.queryCategoryWithPage(page, categoryQuery);
        List<Category> records = result.getRecords();
        List<CategoryVo> data = records.stream()
                .map(item -> {
                    CategoryVo categoryVo = new CategoryVo();
                    BeanUtils.copyProperties(item, categoryVo);
                    categoryVo.setChildren(this.buildTree(records, item, categoryVo, categoryQuery.getStatus()));
                    return categoryVo;
                })
                .sorted(Comparator.comparingInt(CategoryVo::getSort))
                .collect(Collectors.toList());
        return PageInfo.builder()
                .setCurrent(result.getCurrent())
                .setSize(result.getSize())
                .setPages(result.getPages())
                .setTotal(result.getTotal())
                .setData(data)
                .build();
    }

    private List<CategoryVo> buildTree(List<Category> records, Category current, CategoryVo record, Boolean status) {
        records.stream()
                .forEach(item -> {
                    if (item.getId().equals(current.getParentId())) {

                    }
                });
        return null;
    }
}
