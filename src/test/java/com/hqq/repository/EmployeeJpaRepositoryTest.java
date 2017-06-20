package com.hqq.repository;

import com.hqq.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * EmployeeJpaRepositoryTest
 * Created by heqianqian on 2017/6/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-data.xml"})
public class EmployeeJpaRepositoryTest {

    @Resource
    private EmployeeJpaRepository repository;

    @Test
    public void testFindOne() throws Exception {
        Employee one = repository.findOne(99);
        assertEquals("test98", one.getName());
    }

    @Test
    public void testExists() throws Exception {
        assertEquals(true, repository.exists(10));
        assertEquals(false, repository.exists(1000));
    }

    @Test
    public void testPage() throws Exception {
        Pageable pageable = new PageRequest(0,50);
        Page<Employee> all = repository.findAll(pageable);
        assertEquals(2,all.getTotalPages());
    }
}