package com.bytest.autotest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * <h3>risk-auto-test</h3>
 * <p>全量测试</p>
 *
 * @author : hh
 * @date : 2020-08-28 11:40
 **/
@Slf4j
@Controller
public class Alltest {

    @RequestMapping(value = "alltest",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView alltest(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("alltest");

        return modelAndView;
    }
}
