package com.hqq.repository;

import com.hqq.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * EmployeeCRUDRepositoryTest
 * Created by heqianqian on 2017/6/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-data.xml"})
public class EmployeeCRUDRepositoryTest {

    @Resource
    private EmployeeCRUDRepository repository;

    @Test
    public void testSave() throws Exception {
        List<Employee> employeeList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Employee employee = new Employee();
            employee.setName("test" + i);
            employee.setSalary(Double.valueOf(i));
            employeeList.add(employee);
        }
        repository.save(employeeList);
    }

}