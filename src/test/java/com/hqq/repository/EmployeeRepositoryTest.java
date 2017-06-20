package com.hqq.repository;

import com.hqq.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * EmployeeRepositoryTest
 * Created by heqianqian on 2017/6/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-data.xml"})
public class EmployeeRepositoryTest {

    @Resource
    private EmployeeRepository repository;

    @Test
    public void testFindByName() throws Exception {
        Employee jack = repository.findByName("jack");
        System.out.println(jack);
        assertEquals(100, jack.getSalary().intValue());
    }

    @Test
    public void testFindNameInBySalaryLessThan() throws Exception {
        List<Employee> nameInBySalaryLessThan = repository.findByNameEndingWithAndSalaryLessThan("e", 2200.0);
        System.out.println(nameInBySalaryLessThan);
    }

    @Test
    public void testFindByNameIn() throws Exception {
        List<String> names = Arrays.asList("tom", "luce", "jack");
        List<Employee> byNameIn = repository.findByNameIn(names);
        System.out.println(byNameIn);
    }

    @Test
    public void testFindByMaxId() throws Exception {
        Employee byMaxId = repository.findByMaxId();
        System.out.println(byMaxId);
    }

    @Test
    public void testFindByParams1() throws Exception {
        Employee jack = repository.findByParams1("jack", 1);
        assertNotNull(jack);
        System.out.println(jack);
    }

    @Test
    public void testFindByParams2() throws Exception {
        Employee rose = repository.findByParams2("rose", 2);
        assertNotNull(rose);
        System.out.println(rose);
    }

    @Test
    public void testFindByNameLike() throws Exception {
        List<Employee> test = repository.findByNameLike("test");
        System.out.println(test);
    }

    @Test
    public void testGetCount() throws Exception {
        long count = repository.getCount();
        System.out.println(count);
    }
}