package com.bytest.autotest.controller;

import com.bytest.autotest.innerService.TesterService;
import com.bytest.autotest.util.DataUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

/**
 * <h3>risk-auto-test</h3>
 * <p>登陆</p>
 *
 * @author : hh
 * @date : 2020-05-01 22:45
 **/
@Slf4j
@Controller
public class LoginController {
    @Autowired
    TesterService testerService;


    @GetMapping("/login")
    @ResponseBody
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping("/check")
    @ResponseBody
    public Map Check(@RequestParam("username")String username,@RequestParam("password")String password){

        Map map = testerService.check(username,password);
        if (CollectionUtils.isEmpty(map)){
            map.put("username","no");
            log.info("获取到的数据为：{},登陆不成功",map);
        }else {
            log.info("获取到的数据为：{},登陆成功!!",map);
        }

        return map;
    }

    @RequestMapping("/index")
    public String index(){

        return "index";
    }

    @RequestMapping("/nav")
    @ResponseBody
    public String nav() throws FileNotFoundException {

        //return easyuiNavService.getNavListOpen();
        File tree = ResourceUtils.getFile("/home/auto-test/tree.json");
        if (!tree.exists()){
            return DataUtils.txt2String(System.getProperty("user.dir") + "/data/tree.json");
        }
        //return DataUtils.txt2String(System.getProperty("user.dir") + "/data/tree.json");
        return DataUtils.txt2String(tree.getAbsolutePath());

        //return DataUtils.txt2String(tree.getAbsolutePath());
    }

//    @RequestMapping("/nav")
//    @ResponseBody
//    public String nav(String id){
//
//        return easyuiNavService.getNavListClosed(id);
//    }

}
