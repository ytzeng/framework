package org.leo.zeng.core.pojo;

@SuppressWarnings("serial")
public class BaseQuery extends BaseObject {
    /** 查询页数 */
    private int page;
    /** 分页限制 */
    private int limit;
    /** 开始位置 */
    private int start;
    /** 结束位置 */
    private int end;

    public BaseQuery() {
        this.page = 0;
        this.limit = 10;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
        setStart();
        setEnd();
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
        setStart();
        setEnd();
    }

    public int getStart() {
        return start;
    }

    public void setStart() {
        this.start = this.page * this.limit;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd() {
        this.end = this.start + this.limit;
    }
}
