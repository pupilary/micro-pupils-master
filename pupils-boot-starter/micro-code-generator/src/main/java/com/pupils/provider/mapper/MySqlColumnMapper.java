package com.pupils.provider.mapper;

import com.pupils.provider.model.domain.Column;
import com.pupils.provider.model.vo.ColumnVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author takesi
 * @date 2021-07-10
 */
@Mapper
public interface MySqlColumnMapper extends com.baomidou.mybatisplus.core.mapper.BaseMapper<Column> {

    /**
     * queryColumns
     *
     * @param tableName tableName
     * @return list
     */
    List<ColumnVo> queryColumns(@Param("tableName") String tableName);

}
