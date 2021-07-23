package com.pupils.provider.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author takesi
 */
@Data
public class CategoryVo implements Serializable {

    private Long id;

    private String name;

    private String icon;

    private Integer level;

    private Integer sort;

    private String unit;

    private Boolean status;

    private Date createTime;

    private Date updateTime;

    private List<CategoryVo> children;

}
