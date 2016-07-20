package com.sport.web.controller;

import com.sport.persist.dao.mongo.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by wzm on 2016/7/19.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestDao testDao;

    @RequestMapping("/toidx")
    public String gotoIndex() {
        return "/test/test_index";
    }

    @RequestMapping("showStr")
    @ResponseBody
    public String showStr() {
        return "this is test";
    }

    @RequestMapping("mongo")
    @ResponseBody
    public List<String> mongo() {
        return testDao.find();
    }

}
