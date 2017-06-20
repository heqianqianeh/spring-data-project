package com.hqq.dao;

import com.hqq.entity.Student;

import java.util.List;

/**
 * StudentDao
 * Created by heqianqian on 2017/6/17.
 */
public interface StudentDao {


    Student getStudent(int id);

    List<Student> listStudent();

}
