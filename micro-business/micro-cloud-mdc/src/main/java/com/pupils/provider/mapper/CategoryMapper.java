package com.pupils.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pupils.provider.model.domain.Category;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author takesi
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}