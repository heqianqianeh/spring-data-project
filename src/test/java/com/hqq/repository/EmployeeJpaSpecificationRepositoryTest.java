package com.hqq.repository;

import com.hqq.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.persistence.criteria.*;

import static org.junit.Assert.*;

/**
 * EmployeeJpaSpecificationRepositoryTest
 * Created by heqianqian on 2017/6/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-data.xml"})
public class EmployeeJpaSpecificationRepositoryTest {

    @Resource
    private EmployeeJpaSpecificationRepository repository;

    @Test
    public void test() throws Exception {
        Sort.Order order = new Sort.Order(Sort.Direction.ASC, "id");
        Sort sort = new Sort(order);

        Pageable pageable = new PageRequest(0, 10, sort);

        Specification<Employee> employeeSpecifications = new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.gt(root.get("salary"), 5.0);
            }
        };

        Page<Employee> employees = repository.findAll(employeeSpecifications, pageable);

        System.out.println("总页数:" + employees.getTotalPages());
        System.out.println("总元素个数:" + employees.getTotalElements());
        System.out.println("当前页:" + (employees.getNumber() + 1));
        System.out.println("当前页面元素:" + employees.getContent());
        System.out.println("当前页面元素个数:" + employees.getNumberOfElements());

    }
}