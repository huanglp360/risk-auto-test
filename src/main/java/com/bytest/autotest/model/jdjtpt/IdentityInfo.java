package com.bytest.autotest.model.jdjtpt;

import lombok.Data;

/**
 * <h3>risk-auto-test</h3>
 * <p></p>
 *
 * @author : hh
 * @date : 2020-09-15 11:27
 **/
@Data
public class IdentityInfo {
    //身份证正面照
    String frontPhoto;
    //身份证反面
    String reversePhoto;
    //身份证识别结果:1
    String photoMatchLv;
    //人脸照片
    String facePhoto;
    //人脸识别结果
    String facePhotoMatchLv;
    //个人征信授权书
    String creditReportPDF;


}
