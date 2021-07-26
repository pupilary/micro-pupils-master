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
    public PageInfo listWithTree(CategoryQuery categoryQuery) {
        IPage<Category> page = new Page<>(categoryQuery.getCurrent(), categoryQuery.getPageSize());

        if (categoryQuery.getLevel() == null) {
            categoryQuery.setLevel(CategoryLevel.DEFAULT.getValue());
        }
        IPage<Category> result = baseMapper.queryCategoryWithPage(page, categoryQuery);
        // parent category list
        List<Category> records = result.getRecords();
        List<CategoryVo> data = this.buildTree(records, categoryQuery.getStatus());
        return PageInfo.builder()
                .setCurrent(result.getCurrent())
                .setSize(result.getSize())
                .setPages(result.getPages())
                .setTotal(result.getTotal())
                .setData(data)
                .build();
    }

    @Override
    public List<Category> listByParentIds(List<Long> parentIds, boolean status) {
        return baseMapper.queryCategoryInParentIdAndByStatus(parentIds, status);
    }

    private List<CategoryVo> buildTree(List<Category> parents, Boolean status) {
        List<Long> parentIds = parents.stream()
                .map(Category::getId)
                .collect(Collectors.toList());
        List<Category> allChildren = baseMapper.queryCategoryInParentIdAndByStatus(parentIds, status);

        return parents.stream()
                .map(item -> {
                    CategoryVo categoryVo = new CategoryVo();
                    categoryVo.setChildren(this.getChildren(item, allChildren, status));
                    return categoryVo;
                })
                .sorted(Comparator.comparingInt(CategoryVo::getSort))
                .collect(Collectors.toList());
    }

    private List<CategoryVo> getChildren(Category parent, List<Category> allChildren, boolean status) {
        List<Long> parentIds = allChildren.stream()
                .map(Category::getId)
                .collect(Collectors.toList());

        List<Category> nextAllChildren = this.listByParentIds(parentIds, status);

        return allChildren.stream()
                .filter(child -> parent.getId().equals(child.getParentId()))
                .map(child -> {
                    CategoryVo categoryVo = new CategoryVo();
                    BeanUtils.copyProperties(child, categoryVo);
                    categoryVo.setChildren(this.getChildren(child, nextAllChildren, status));
                    return categoryVo;
                })
                .sorted(Comparator.comparingInt(CategoryVo::getSort))
                .collect(Collectors.toList());
    }
}
