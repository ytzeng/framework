package org.leo.zeng.core.pojo;

import java.util.List;

/**
 * 分页查询结果类
 */
@SuppressWarnings("serial")
public class Paging<T extends BaseObject> extends BaseObject {
    /** 查询页数 */
    private int page;
    /** 分页限制 */
    private int limit;
    /** 总记录数 */
    private int records;
    /** 列表数据 */
    private List<T> data;
    /** 总页数 */
    private int total;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getRecords() {
        return records;
    }

    public void setRecords(int records) {
        this.records = records;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getTotal() {
        if (records % limit == 0) {
            this.total = records / limit;
        } else {
            this.total = records / limit + 1;
        }
        return total;
    }

}
