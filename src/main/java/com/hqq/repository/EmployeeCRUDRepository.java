package com.hqq.repository;

import com.hqq.entity.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * EmployeeCRUDRepository
 * Created by heqianqian on 2017/6/20.
 */
public interface EmployeeCRUDRepository extends CrudRepository<Employee, Integer> {
}
