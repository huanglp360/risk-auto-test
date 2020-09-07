package com.bytest.autotest.model;

import com.bytest.autotest.model.juzifenqi.DataPO;
import lombok.ToString;

@ToString
public class RequestData {
    private CommPO comm;
    private DataPO data;

    public CommPO getComm() {
        return comm;
    }

    public void setComm(CommPO comm) {
        this.comm = comm;
    }

    public DataPO getData() {
        return data;
    }

    public void setData(DataPO data) {
        this.data = data;
    }
}
