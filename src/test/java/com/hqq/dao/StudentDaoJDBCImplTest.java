package com.hqq.dao;

import com.hqq.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * StudentDaoJDBCImplTest
 * Created by heqianqian on 2017/6/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml"})
public class StudentDaoJDBCImplTest {

    @Resource
    private StudentDao studentDao;

    @Test
    public void listStudent() throws Exception {
        List<Student> students = studentDao.listStudent();
        System.out.println(students);
    }

    @Test
    public void getStudent() throws Exception {
        Student student = studentDao.getStudent(2);
        System.out.println(student);
    }
}