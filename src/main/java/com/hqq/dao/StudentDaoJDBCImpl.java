package com.hqq.dao;

import com.hqq.entity.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * StudentDaoJDBCImpl
 * Created by heqianqian on 2017/6/17.
 */
@Component
public class StudentDaoJDBCImpl implements StudentDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public Student getStudent(int id) {
        final String sql = "select id,name,age from student where id = ?";
        final Student[] student = new Student[1];
        jdbcTemplate.query(sql, new Object[]{id}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                student[0] = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age")
                );
            }
        });
        return student[0];
    }

    @Override
    public List<Student> listStudent() {
        final List<Student> students = new ArrayList<>();
        String sql = "select id,name,age from student";
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age")
                );
                students.add(student);
            }
        });
        return students;
    }
}
