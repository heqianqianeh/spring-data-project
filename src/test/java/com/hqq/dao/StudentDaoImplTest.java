package com.hqq.dao;

import com.hqq.entity.Student;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * StudentDaoImplTest
 * Created by heqianqian on 2017/6/17.
 */
public class StudentDaoImplTest {

    private StudentDao studentDao = new StudentDaoImpl();

    @Test
    public void testGetStudent() throws Exception {
        Student student = studentDao.getStudent(1);
        System.out.println(student);
    }

    @Test
    public void testListStudent() throws Exception {
        List<Student> students = studentDao.listStudent();
        System.out.println(students);
    }
}