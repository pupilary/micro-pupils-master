package com.pupils.provider.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pupils.provider.model.domain.Table;
import com.pupils.provider.model.query.TableQuery;
import com.pupils.provider.model.vo.TableVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author takesi
 * @date 2021-07-10
 */
@Mapper
public interface MySqlTableMapper extends com.baomidou.mybatisplus.core.mapper.BaseMapper<Table> {

    /**
     * queryList
     *
     * @param query query
     * @param page  page
     * @return list
     */
    IPage<TableVo> queryTables(@Param("query") TableQuery query, IPage<TableVo> page);

    /**
     * queryTable
     *
     * @param tableName tableName
     * @return map
     */
    TableVo queryTable(@Param("tableName") String tableName);

}
