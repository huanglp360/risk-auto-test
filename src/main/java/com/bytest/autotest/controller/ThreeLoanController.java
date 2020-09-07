package com.bytest.autotest.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytest.autotest.model.Request360;
import com.bytest.autotest.service.ThreeBusinessService;
import com.bytest.autotest.util.RSAUntil;
import com.bytest.autotest.util.http.HttpClient4;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * <h3>risk-auto-test</h3>
 * <p>360jieqian</p>
 *
 * @author : hh
 * @date : 2020-05-03 02:43
 **/
@Slf4j
@Controller
public class ThreeLoanController {
    @Autowired
    ThreeBusinessService threeBusinessService;
    @Value("${url}")
    String url;

    @RequestMapping(value = "threeLoan",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ModelAndView three(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/threeLoan");
        return  modelAndView;
    }

    @RequestMapping(value = "/get360req",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String build(){

        Request360 request360 = threeBusinessService.bulidRquest();

        return JSON.toJSONString(request360);
    }

    @RequestMapping(value = "/req360")
    @ResponseBody
    public String request(Request360 req){
        log.info("前端传递的数据为==={}",req.toString());
        String jsonObject = JSONObject.toJSONString(req);
        String data = RSAUntil.encrypt(jsonObject);
        String sign = RSAUntil.sign(data);
        JSONObject reqjson = new JSONObject().fluentPut("sign", sign).fluentPut("data", data);
        String httpresult = HttpClient4.doPost(url,reqjson.toJSONString());
        JSONObject resJson = JSONObject.parseObject(httpresult);
        log.info("获取到的http请求结果转换json={}",resJson.toJSONString());


        String resultdata =resJson.getString("data");

        log.info("后太返回的数据为===={}",RSAUntil.decrypt(resultdata));
        return RSAUntil.decrypt(resultdata);
    }
}
