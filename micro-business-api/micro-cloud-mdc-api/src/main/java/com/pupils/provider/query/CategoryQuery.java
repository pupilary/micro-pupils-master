package com.pupils.provider.query;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author takesi
 */
@Data
public class CategoryQuery implements Serializable {

    private Integer current;

    private Integer pageSize;

    private String name;

    private Integer level;

    private Boolean status;

    private List<Date> createTime;

    private List<Date> updateTime;

}
