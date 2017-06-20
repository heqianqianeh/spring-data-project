package com.hqq.repository;

import com.hqq.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * EmployeeJpaSpecificationRepository
 * Created by heqianqian on 2017/6/20.
 */
public interface EmployeeJpaSpecificationRepository
        extends JpaRepository<Employee, Integer>,
        JpaSpecificationExecutor<Employee> {
}
