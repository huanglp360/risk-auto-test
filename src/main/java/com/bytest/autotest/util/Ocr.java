package com.bytest.autotest.util;

import com.baidu.aip.ocr.AipOcr;
import com.bytest.autotest.domain.UserInfo;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Ocr {
    public static String APP_ID = "16518470";
    public static String API_KEY = "vkq4NOrPyGseBZ6wFRjvro3o";
    public static String SECRET_KEY = "EGqlUMvGSFRc6Wbu56u5Uegxm9CGlet9";

    private static int count=0;

    public static UserInfo read(String path, String id_side) throws IOException {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("detect_direction", "true");//检测身份证朝向true检测，flase 不检测
        options.put("detect_risk", "false");//是否开启身份证风险类型(身份证复印件、临时身份证、身份证翻拍、修改过的身份证)功能，默认不开启，即：false。可选值:true-开启；false-不开启
        //String idCardSide = "front";//front：身份证含照片的一面；back：身份证带国徽的一面

        if(count<500){
            AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
            client.setConnectionTimeoutInMillis(2000);
            client.setSocketTimeoutInMillis(60000);

            JSONObject res = client.idcard(path,id_side,options);
            //获取图片二进制数组
//            BufferedImage bufferedImage = ImageIO.read(new File(path));
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            ImageIO.write(bufferedImage,"jpg",baos);
//            byte[] bytes = baos.toByteArray();
//            // 参数为本地图片二进制数
//            res = client.idcard(bytes, idCardSide, options);
            count++;
            if(id_side.equals("front")){
                JSONObject jsonObject= res.getJSONObject("words_result");
                Map<String,String> map = new HashMap<String, String>();
                for (String str:jsonObject.keySet()) {
                    //JSONObject js= (JSONObject) req.get(str);
                    JSONObject js= jsonObject.getJSONObject(str);
                    map.put(str,String.valueOf(js.get("words")));
                }

                UserInfo idInfo = new UserInfo();
                idInfo.setId_No(map.get("公民身份号码"));
                idInfo.setName(map.get("姓名"));
                idInfo.setAddress(map.get("住址"));
                idInfo.setBirth(map.get("出生"));
                idInfo.setSex(map.get("性别"));
                idInfo.setClan(map.get("民族"));
                return idInfo;
            }else{
                return null;
            }

        }else {
            return null;
        }
    }
}
