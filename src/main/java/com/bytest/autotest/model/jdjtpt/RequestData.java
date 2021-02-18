package com.bytest.autotest.model.jdjtpt;

import lombok.Data;

/**
 * <h3>tool</h3>
 * <p></p>
 *
 * @author : hh
 * @date : 2020-09-15 11:05
 **/
@Data
public class RequestData {
    String applyNo;
    String applyTime;
    String businessType;
    JDuserInfo userInfo;
}
