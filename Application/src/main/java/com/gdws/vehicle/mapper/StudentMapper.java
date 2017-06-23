/*
 * File Name：StudentMapper.java
 *
 * Copyrighe：copyright@2017 GZSW Company. All Rights Reserved
 *
 * Create Time: 2017年6月23日 下午2:13:09
 */
package com.gdws.vehicle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gdws.vehicle.model.StudentModel;

/**
 *
 * @author lcc (nplcclin@gmail.com)
 * @version 1.0, 2017年6月23日 下午2:13:09
 */
public interface StudentMapper {
    public List<StudentModel> getStudent(@Param("stuGender") int stuGender);
    public void addStudent(@Param("student") StudentModel student);
}

