package com.sport.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wzm on 2016/7/19.
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/toidx")
    public String gotoIndex() {
        return "/test/test_index";
    }

    @RequestMapping("showStr")
    @ResponseBody
    public String showStr() {
        return "this is test";
    }

}
