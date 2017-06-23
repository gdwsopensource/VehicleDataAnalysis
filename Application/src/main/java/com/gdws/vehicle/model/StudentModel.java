/*
 * File Name：StudentModel.java
 *
 * Copyrighe：copyright@2017 GZSW Company. All Rights Reserved
 *
 * Create Time: 2017年6月23日 下午2:10:23
 */
package com.gdws.vehicle.model;

/**
 *
 * @author lcc (nplcclin@gmail.com)
 * @version 1.0, 2017年6月23日 下午2:10:23
 */
public class StudentModel {
    private int stuNum;
    private String stuName;
    private int stuGender;
    private int stuAge;
    
    public int getStuNum() {
        return stuNum;
    }
    public void setStuNum(int stuNum) {
        this.stuNum = stuNum;
    }
    public String getStuName() {
        return stuName;
    }
    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
    public int getStuGender() {
        return stuGender;
    }
    public void setStuGender(int stuGender) {
        this.stuGender = stuGender;
    }
    public int getStuAge() {
        return stuAge;
    }
    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }
}

