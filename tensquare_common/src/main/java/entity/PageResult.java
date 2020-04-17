package entity;

import java.util.List;

/**
 * @program: com.tensquare
 * @author: liumq
 * @create: 2020-04-17 23:43
 **/
public class PageResult<T> {
    private Long total;
    private List<T> rows;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public PageResult() {
    }

    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }
}
