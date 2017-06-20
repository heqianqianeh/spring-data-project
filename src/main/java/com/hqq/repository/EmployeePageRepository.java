package com.hqq.repository;

import com.hqq.entity.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * EmployeePageRepository
 * Created by heqianqian on 2017/6/20.
 */
public interface EmployeePageRepository extends PagingAndSortingRepository<Employee, Integer> {
}
