/*
 * File Name：PortalController.java
 *
 * Copyrighe：copyright@2017 GZSW Company. All Rights Reserved
 *
 * Create Time: 2017年6月23日 上午11:17:18
 */
package com.gdws.vehicle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    
    @RequestMapping("mv")
    ModelAndView test() {
        ModelAndView mv = new ModelAndView();
        
        return mv;
    }
}

