/*
 * File Name：StudentService.java
 *
 * Copyrighe：copyright@2017 GZSW Company. All Rights Reserved
 *
 * Create Time: 2017年6月23日 下午2:30:40
 */
package com.gdws.vehicle.service;

import com.alibaba.fastjson.JSONObject;

/**
 *
 * @author lcc (nplcclin@gmail.com)
 * @version 1.0, 2017年6月23日 下午2:30:40
 */
public interface StudentService {
    public JSONObject getStudentList(int stuGender);
    public boolean addStudent(int stuNum, String stuName, 
            int stuGender, int stuAge);
}

