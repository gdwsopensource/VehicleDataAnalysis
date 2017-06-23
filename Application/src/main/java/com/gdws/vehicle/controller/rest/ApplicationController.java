/*
 * File Name：ApplicationController.java
 *
 * Copyrighe：copyright@2017 GZSW Company. All Rights Reserved
 *
 * Create Time: 2017年6月20日 下午6:13:49
 */
package com.gdws.vehicle.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.gdws.vehicle.service.StudentService;

/**
 *
 * @author lcc (nplcclin@gmail.com)
 * @version 1.0, 2017年6月20日 下午6:13:49
 */
@RestController
public class ApplicationController {
    @Autowired
    private StudentService service;
    @RequestMapping(value = {"testUser"}, method = RequestMethod.GET)
    public JSONObject getUser(@RequestParam String user) {
        JSONObject obj = new JSONObject();
        obj.put("code", 200);
        obj.put("user", user);
        return obj;
    }
    
    /**
     * http://127.0.0.1:8082/getStudentList?stuGender=0 
     */
    @RequestMapping(value = {"getStudentList"}, method = RequestMethod.GET)
    public JSONObject getStudentList(@RequestParam int stuGender) {
        return service.getStudentList(stuGender);
    }
    
    /**
     * http://127.0.0.1:8082/addStudent?stuGender=0&stuNum=127&stuName=%E8%B5%B5%E5%85%AD&stuAge=31
     */
    @RequestMapping(value = {"addStudent"}, method = RequestMethod.GET)
    public boolean addStudent(@RequestParam int stuNum, @RequestParam String stuName, 
            @RequestParam int stuGender, @RequestParam int stuAge) {
        return service.addStudent(stuNum, stuName, stuGender, stuAge);
    }
}

