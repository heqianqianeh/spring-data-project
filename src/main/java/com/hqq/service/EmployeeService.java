package com.hqq.service;

import com.hqq.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * EmployeeService
 * Created by heqianqian on 2017/6/20.
 */
@Service
public class EmployeeService {

    @Resource
    private EmployeeRepository repository;

    @Transactional
    public void update(Integer id,Double salary){
        repository.update(id,salary);
    }
}
