package com.sport.web.controller;

import com.sport.persist.gen.dao.db.model.SportType;
import com.sport.service.SportTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wzm on 2016/7/19.
 */
@Controller
@RequestMapping("/sportType")
public class SportTypeController {
    @Autowired
    private SportTypeService sportTypeService;

    @RequestMapping("/add")
    @ResponseBody
    public int add(String name, String code) throws Exception {
        SportType type = new SportType();
        type.setName(name);
        type.setCode(code);
        try {
            return sportTypeService.insert(type);
        } catch (Exception e) {
            throw e;
        }
    }
}
