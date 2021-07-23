package com.pupils.provider.model.enums;

import com.baomidou.mybatisplus.annotation.IEnum;

/**
 * @author takesi
 */
public enum CategoryLevel implements IEnum<Integer> {

    /**
     * 默认菜单
     */
    DEFAULT {
        @Override
        public Integer getValue() {
            return 0;
        }
    }

}
