package com.hqq.repository;

import com.hqq.entity.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * EmployeeRepository
 * Created by heqianqian on 2017/6/17.
 */
//@org.springframework.stereotype.Repository
//public interface EmployeeRepository extends Repository<Employee, Integer> {
@RepositoryDefinition(domainClass = Employee.class, idClass = Integer.class)
public interface EmployeeRepository {
    Employee findByName(String name);

    List<Employee> findByNameEndingWithAndSalaryLessThan(String name, Double salary);

    List<Employee> findByNameIn(List<String> names);

    @Query(value = "select o from Employee o where id=(select max(id) from Employee t1)")
    Employee findByMaxId();

    @Query("select o from Employee o where name = ?1 and id = ?2")
    Employee findByParams1(String name, Integer id);

    @Query("select o from Employee o where o.name=:name and o.id=:id")
    Employee findByParams2(@Param("name") String name, @Param("id") Integer id);

    @Query("select o from Employee o where o.name like %:name%")
    List<Employee> findByNameLike(@Param("name") String name);

    @Query(nativeQuery = true, value = "select count(*) from employee")
    long getCount();

    @Modifying
    @Query("update Employee e set e.salary =:salary where e.id=:id")
    void update(@Param("id") Integer id, @Param("salary") Double salary);

}
