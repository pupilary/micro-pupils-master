package com.pupils.provider.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pupils.provider.mapper.MySqlTableMapper;
import com.pupils.provider.model.domain.Table;
import com.pupils.provider.model.query.TableQuery;
import com.pupils.provider.model.vo.ColumnVo;
import com.pupils.provider.model.vo.TableVo;
import com.pupils.provider.service.GeneratorColumnService;
import com.pupils.provider.service.GeneratorTableService;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;
import java.util.zip.ZipOutputStream;

/**
 * @author takesi
 * @date 2021-07-11
 */
@Service
public class GeneratorTableServiceImpl extends ServiceImpl<MySqlTableMapper, Table> implements GeneratorTableService {

    private static final Logger logger = LoggerFactory.getLogger(GeneratorTableService.class);

    @Autowired
    private MySqlTableMapper tableMapper;

    @Autowired
    private GeneratorColumnService columnService;

    @Override
    public IPage<TableVo> queryList(TableQuery query) {
        return tableMapper.queryTables(query, new Page<>(query.getPageNo(), query.getPageSize()));
    }

    @Override
    public byte[] generatorCode(String[] tableNames) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);

        for (String tableName : tableNames) {
            TableVo tableVo = tableMapper.queryTable(tableName);
            List<ColumnVo> columnVos = columnService.getListByTableName(tableName);
        }
        // TODO 生成zip下载包
        Consumer<IOException> consumer = e -> logger.error(e.getLocalizedMessage());
        IOUtils.closeQuietly(zip, consumer);
        return outputStream.toByteArray();
    }

}
