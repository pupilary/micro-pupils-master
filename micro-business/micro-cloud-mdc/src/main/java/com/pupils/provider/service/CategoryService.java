package com.pupils.provider.service;

import com.pupils.provider.model.domain.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pupils.provider.query.CategoryQuery;
import com.pupils.web.metadata.PageInfo;

/**
 * @author takesi
 */
public interface CategoryService extends IService<Category> {

    /**
     * queryCategory
     * @param categoryQuery categoryQuery
     * @return pageInfo
     */
    PageInfo queryCategory(CategoryQuery categoryQuery);

}
