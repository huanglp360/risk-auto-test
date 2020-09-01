package com.bytest.autotest.model.juzifenqi;

import lombok.Data;

import java.util.List;

/**
 * <h3>tool</h3>
 * <p>借款实体类</p>
 *
 * @author : hh
 * @date : 2020-04-07 00:53
 **/
@Data
public class LoanData {
    private String busNumber;

    private String custName;

    private String prodSubNo;

    private String idType;

    private String idNo;

    private String mobNo;

    private String callbackUrl;

    private String bankCardNo;

    private String guaranteedCompany;

    private List<ImgNameList> imgNameList;
}
