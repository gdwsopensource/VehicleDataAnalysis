/*
 * File Name：PortalController.java
 *
 * Copyrighe：copyright@2017 GZSW Company. All Rights Reserved
 *
 * Create Time: 2017年6月23日 上午11:17:18
 */
package com.gdws.vehicle.controller;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

/**
 *
 * @author lcc (nplcclin@gmail.com)
 * @version 1.0, 2017年6月23日 上午11:17:18
 */
@Controller
public class PortalController {
    @RequestMapping("index")
    String frequentBusines() {
        return "index/index";
    }
    
    
    @RequestMapping("behavior-analysis")
    String behaviorAnalysis() {
        return "behavior-analysis";
    }
    
    @RequestMapping("behavior-prediction")
    String behaviorPrediction() {
        return "behavior-prediction";
    }
    
//    @RequestMapping("mv")
//    ModelAndView test() {
//        ModelAndView mv = new ModelAndView();
//        
//        return mv;
//    }
}

