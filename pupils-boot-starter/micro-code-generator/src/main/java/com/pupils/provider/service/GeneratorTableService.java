package com.pupils.provider.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pupils.provider.model.domain.Table;
import com.pupils.provider.model.query.TableQuery;
import com.pupils.provider.model.vo.TableVo;

/**
 * @author takesi
 * @date 2021-07-11
 */
public interface GeneratorTableService extends IService<Table> {

    /**
     * queryList
     *
     * @param query query
     * @return page
     */
    IPage<TableVo> queryList(TableQuery query);

    /**
     * generatorCode
     *
     * @param tableNames tableNames
     * @return byte
     */
    byte[] generatorCode(String[] tableNames);
}
