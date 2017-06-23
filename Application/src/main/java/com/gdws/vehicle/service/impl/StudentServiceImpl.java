/*
 * File Name：StudentServiceImpl.java
 *
 * Copyrighe：copyright@2017 GZSW Company. All Rights Reserved
 *
 * Create Time: 2017年6月23日 下午2:31:00
 */
package com.gdws.vehicle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.gdws.vehicle.mapper.StudentMapper;
import com.gdws.vehicle.model.StudentModel;
import com.gdws.vehicle.service.StudentService;

/**
 *
 * @author lcc (nplcclin@gmail.com)
 * @version 1.0, 2017年6月23日 下午2:31:00
 */
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentMapper mapper;
    
    @Override
    public JSONObject getStudentList(int stuGender) {
        JSONObject obj = new JSONObject();
        obj.put("code", 200);
        obj.put("message", "success");
        obj.put("data", mapper.getStudent(stuGender));
        return obj;
    }

    @Override
    public boolean addStudent(int stuNum, String stuName, int stuGender,
            int stuAge) {
        StudentModel sm = new StudentModel();
        sm.setStuAge(stuAge);
        sm.setStuGender(stuGender);
        sm.setStuNum(stuNum);
        sm.setStuName(stuName);
        try {
            mapper.addStudent(sm);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}

