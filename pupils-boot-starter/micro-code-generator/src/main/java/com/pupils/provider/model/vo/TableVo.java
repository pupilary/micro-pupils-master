package com.pupils.provider.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author takesi
 * @date 2021-07-11
 */
@Data
public class TableVo implements Serializable {

    private String tableName;
    private String engine;
    private String tableComment;
    private Date createTime;

}
