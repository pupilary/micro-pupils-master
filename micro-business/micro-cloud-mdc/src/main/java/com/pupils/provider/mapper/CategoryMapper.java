package com.pupils.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pupils.provider.model.domain.Category;
import com.pupils.provider.query.CategoryQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author takesi
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

    /**
     * queryCategoryWithPage
     *
     * @param page  page
     * @param query query
     * @return page
     */
    IPage<Category> queryCategoryWithPage(@Param("page") IPage<Category> page, @Param("query") CategoryQuery query);

    /**
     * queryCategoryByParentId
     *
     * @param parentId parentId
     * @param status   status
     * @return list
     */
    List<Category> queryCategoryByParentId(@Param("parentId") Long parentId, @Param("status") Boolean status);

}