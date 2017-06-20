/*
 * File Name：ApplicationController.java
 *
 * Copyrighe：copyright@2017 GZSW Company. All Rights Reserved
 *
 * Create Time: 2017年6月20日 下午6:13:49
 */
package com.gdws.vehicle.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

/**
 *
 * @author lcc (nplcclin@gmail.com)
 * @version 1.0, 2017年6月20日 下午6:13:49
 */
@RestController
public class ApplicationController {
    @RequestMapping(value = {"testUser"}, method = RequestMethod.GET)
    public JSONObject getUser(@RequestParam String user) {
        JSONObject obj = new JSONObject();
        obj.put("code", 200);
        obj.put("user", user);
        return obj;
    }
}

