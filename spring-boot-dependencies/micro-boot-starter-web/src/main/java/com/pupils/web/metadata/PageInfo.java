package com.pupils.web.metadata;

import lombok.Getter;

import java.io.Serializable;
import java.util.List;

/**
 * @author takesi
 * @date 2021-07-10
 */
@Getter
public class PageInfo implements Serializable {

    /**
     * 总记录数
     */
    private final long total;

    /**
     * 每页记录数
     */
    private final long size;

    /**
     * 当前页数
     */
    private final long current;

    /**
     * 总页数
     */
    private final long pages;

    private final List<?> data;

    private PageInfo(Builder builder) {
        this.total = builder.total;
        this.size = builder.size;
        this.current = builder.current;
        this.pages = builder.pages;
        this.data = builder.data;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        /**
         * 总记录数
         */
        private long total;

        /**
         * 每页记录数
         */
        private long size;

        /**
         * 当前页数
         */
        private long current;

        /**
         * 总页数
         */
        private long pages;

        private List<?> data;

        public Builder setTotal(long total) {
            this.total = total;
            return this;
        }

        public Builder setSize(long size) {
            this.size = size;
            return this;
        }

        public Builder setCurrent(long current) {
            this.current = current;
            return this;
        }

        public Builder setPages(long pages) {
            this.pages = pages;
            return this;
        }

        public Builder setData(List<?> data) {
            this.data = data;
            return this;
        }

        public PageInfo build() {
            return new PageInfo(this);
        }
    }

}
