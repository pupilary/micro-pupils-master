package com.pupils.provider.service;

import com.pupils.provider.model.domain.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pupils.provider.query.CategoryQuery;
import com.pupils.web.metadata.PageInfo;

import java.util.List;

/**
 * @author takesi
 */
public interface CategoryService extends IService<Category> {

    /**
     * listWithTree
     *
     * @param categoryQuery categoryQuery
     * @return pageInfo
     */
    PageInfo listWithTree(CategoryQuery categoryQuery);

    /**
     * listByParentIds
     *
     * @param parentIds parentIds
     * @param status    status
     * @return children list
     */
    List<Category> listByParentIds(List<Long> parentIds, boolean status);

}
