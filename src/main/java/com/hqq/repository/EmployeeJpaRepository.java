package com.hqq.repository;

import com.hqq.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * EmployeeJpaRepository
 * Created by heqianqian on 2017/6/20.
 */
public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer> {
}
