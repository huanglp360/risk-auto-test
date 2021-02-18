package com.bytest.autotest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * <h3>risk-auto-test</h3>
 * <p>橘子分期</p>
 *
 * @author : hh
 * @date : 2020-05-19 10:42
 **/
@Slf4j
@Controller
public class JuzifenqiController {
    @RequestMapping(value = "jzfq",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ModelAndView three(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/jzfq");
        return  modelAndView;
    }

}
