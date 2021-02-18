package com.bytest.autotest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <h3>risk-auto-test</h3>
 * <p>乐信</p>
 *
 * @author : hh
 * @date : 2020-05-03 20:50
 **/
@Controller
public class LexinController {
    @RequestMapping("lexin")
    public String testdata(){
        return "/lexin";
    }


}
