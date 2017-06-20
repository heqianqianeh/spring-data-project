package com.hqq.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by heqianqian on 2017/6/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-data.xml"})
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService service;

    @Test
    public void update() throws Exception {
        service.update(1, 9999999d);
    }

}