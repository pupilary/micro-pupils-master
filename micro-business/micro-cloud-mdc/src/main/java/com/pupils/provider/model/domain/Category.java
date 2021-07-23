package com.pupils.provider.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pupils.mybatis.model.BaseEntity;

import java.util.Date;

/**
 * 分类信息
 */
@TableName(value = "pms_category")
public class Category extends BaseEntity {

    /**
     * 分类名称
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 图标
     */
    @TableField(value = "icon")
    private String icon;

    /**
     * 层级
     */
    @TableField(value = "`level`")
    private Integer level;

    /**
     * 父级id
     */
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 排序
     */
    @TableField(value = "sort")
    private Integer sort;

    /**
     * 计量单位
     */
    @TableField(value = "unit")
    private String unit;

    /**
     * 状态（0 - 不显示，1 - 显示）
     */
    @TableField(value = "`status`")
    private Byte status;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_ICON = "icon";

    public static final String COL_LEVEL = "level";

    public static final String COL_PARENT_ID = "parent_id";

    public static final String COL_SORT = "sort";

    public static final String COL_UNIT = "unit";

    public static final String COL_STATUS = "status";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_VERSION = "version";

    /**
     * 获取分类名称
     *
     * @return name - 分类名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置分类名称
     *
     * @param name 分类名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取图标
     *
     * @return icon - 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置图标
     *
     * @param icon 图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取层级
     *
     * @return level - 层级
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置层级
     *
     * @param level 层级
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获取父级id
     *
     * @return parent_id - 父级id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父级id
     *
     * @param parentId 父级id
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取计量单位
     *
     * @return unit - 计量单位
     */
    public String getUnit() {
        return unit;
    }

    /**
     * 设置计量单位
     *
     * @param unit 计量单位
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * 获取状态（0 - 不显示，1 - 显示）
     *
     * @return status - 状态（0 - 不显示，1 - 显示）
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置状态（0 - 不显示，1 - 显示）
     *
     * @param status 状态（0 - 不显示，1 - 显示）
     */
    public void setStatus(Byte status) {
        this.status = status;
    }
}