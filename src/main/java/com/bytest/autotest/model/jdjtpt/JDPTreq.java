package com.bytest.autotest.model.jdjtpt;

import lombok.Data;

/**
 * <h3>tool</h3>
 * <p></p>
 *
 * @author : hh
 * @date : 2020-09-15 11:04
 **/
@Data
public class JDPTreq {
    String requestNo;
    String txCode;
    String version;
    String channelCode;
    String requestTime;
    RequestData requestData;
    String sysSign;

}
