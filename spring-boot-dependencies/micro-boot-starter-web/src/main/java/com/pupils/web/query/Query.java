package com.pupils.web.query;

import java.io.Serializable;

/**
 * @author takesi
 * @date 2021-07-12
 */
public class Query implements Serializable {

    private int pageNo;

    private int pageSize;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
