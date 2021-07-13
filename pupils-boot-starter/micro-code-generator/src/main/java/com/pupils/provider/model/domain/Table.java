package com.pupils.provider.model.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author takesi
 * @date 2021-07-10
 */
@Data
public class Table implements Serializable {

    /**
     * 表名称
     */
    private String tableName;

    /**
     * 表备注
     */
    private String comments;

    /**
     * 表主键
     */
    private Column pk;

    /**
     * 表列名（不包含主键）
     */
    private List<Column> columns;

    /**
     * 类名（第一个字母大写）
     */
    private String upperClassName;

    /**
     * 类名（第一个字母小写）
     */
    private String lowerClassName;

}
