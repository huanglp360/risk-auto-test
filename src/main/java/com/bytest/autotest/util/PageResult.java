package com.bytest.autotest.util;

import com.bytest.autotest.domain.UserInfo;
import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

import java.io.Serializable;
import java.util.List;

/**
 * <h3>risk-auto-test</h3>
 * <p>分页查询</p>
 *
 * @author : hh
 * @date : 2020-05-04 02:28
 **/

public class PageResult implements Serializable {
    /**
     * 分页返回
     *"data": {
     "total": 0,
     "rows": [
     {
     "id": "string",
     "labelname": "string",
     "state": "string",
     "count": 0,
     "recommend": "string"
     }
     ]
     }
     * */
    public Integer total;
    public List<T> T;

    public Integer getTotle() {
        return total;
    }

    public void setTotle(Integer totle) {
        this.total = totle;
    }

    public List<T> getRows() {
        return T;
    }

    public void setRows(List<T> rows) {
        this.T = T;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "totle=" + total +
                ", rows=" + T +
                '}';
    }
}
