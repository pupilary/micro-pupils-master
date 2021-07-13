package com.pupils.provider.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pupils.provider.model.domain.Column;
import com.pupils.provider.model.vo.ColumnVo;

import java.util.List;

/**
 * @author takesi
 * @date 2021-07-12
 */
public interface GeneratorColumnService extends IService<Column> {

    /**
     * getListByTableName
     *
     * @param tableName tableName
     * @return columnVo
     */
    List<ColumnVo> getListByTableName(String tableName);

}
