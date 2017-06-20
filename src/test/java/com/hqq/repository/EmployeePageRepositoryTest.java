package com.hqq.repository;

import com.hqq.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * EmployeePageRepositoryTest
 * Created by heqianqian on 2017/6/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-data.xml"})
public class EmployeePageRepositoryTest {

    @Resource
    private EmployeePageRepository repository;

    @Test
    public void testPage() throws Exception {
        Pageable pageable = new PageRequest(0,10);
        Page<Employee> employees = repository.findAll(pageable);

        System.out.println("总页数:"+employees.getTotalPages());
        System.out.println("总元素个数:"+employees.getTotalElements());
        System.out.println("当前页:"+(employees.getNumber()+1));
        System.out.println("当前页面元素:"+employees.getContent());
        System.out.println("当前页面元素个数:"+employees.getNumberOfElements());
    }

    @Test
    public void testPageAndSort() throws Exception {

        Sort.Order order = new Sort.Order(Sort.Direction.ASC,"id");
        Sort sort = new Sort(order);

        Pageable pageable = new PageRequest(1,10,sort);
        Page<Employee> employees = repository.findAll(pageable);

        System.out.println("总页数:"+employees.getTotalPages());
        System.out.println("总元素个数:"+employees.getTotalElements());
        System.out.println("当前页:"+(employees.getNumber()+1));
        System.out.println("当前页面元素:"+employees.getContent());
        System.out.println("当前页面元素个数:"+employees.getNumberOfElements());
    }
}