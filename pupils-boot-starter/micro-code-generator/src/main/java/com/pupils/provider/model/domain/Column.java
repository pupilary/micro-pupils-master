package com.pupils.provider.model.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author takesi
 * @date 2021-07-10
 */
@Data
public class Column implements Serializable {

    /**
     * 列名
     */
    private String columnName;

    /**
     * 列名类型
     */
    private String dataType;

    /**
     * 列名备注
     */
    private String comments;

    /**
     * 属性名称（第一个字母大写）
     */
    private String upperAttrName;

    /**
     * 属性名称（第一个字母小写）
     */
    private String lowerAttrName;

    /**
     * 属性类型
     */
    private String attrType;

    /**
     * auto_increment
     */
    private String extra;
}
