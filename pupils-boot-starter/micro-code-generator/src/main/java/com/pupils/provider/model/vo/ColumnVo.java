package com.pupils.provider.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author takesi
 * @date 2021-07-10
 */
@Data
public class ColumnVo implements Serializable {

    private String columnName, dataType, columnComment, columnKey, extra;
}
