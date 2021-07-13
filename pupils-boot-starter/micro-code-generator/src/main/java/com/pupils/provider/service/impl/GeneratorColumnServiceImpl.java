package com.pupils.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pupils.provider.mapper.MySqlColumnMapper;
import com.pupils.provider.model.domain.Column;
import com.pupils.provider.model.vo.ColumnVo;
import com.pupils.provider.service.GeneratorColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author takesi
 * @date 2021-07-12
 */
@Service
public class GeneratorColumnServiceImpl extends ServiceImpl<MySqlColumnMapper, Column> implements GeneratorColumnService {

    @Autowired
    private MySqlColumnMapper columnMapper;

    @Override
    public List<ColumnVo> getListByTableName(String tableName) {
        return columnMapper.queryColumns(tableName);
    }
}
