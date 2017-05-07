package com.himanshuanand.Dao;

import com.himanshuanand.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Created by himanshuanand on 5/7/17.
 */
@Repository("mysql")
public class MySqlStudentDaoImpl implements StudentDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class StudentRowMapper implements RowMapper<Student> {

        @Override
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setName(resultSet.getString("name"));
            student.setCourse(resultSet.getString("course"));
            return student;
        }
    }

    @Override
    public Collection<Student> getAllStudents() {
        final String sql = "SELECT id, name, course FROM students";
        return jdbcTemplate.query(sql,new StudentRowMapper());
    }

    @Override
    public Student getStudentById(int id) {
        final String sql = "SELECT id, name, course FROM students where id = ?";
        return jdbcTemplate.queryForObject(sql,new StudentRowMapper(),id);
    }

    @Override
    public void removeStudentById(int id) {
        final String sql = "DELETE FROM students where id = ?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void updateStudent(Student student) {
        final String sql = "UPDATE students SET name = ?,course = ? where id = ?";
        final int id = student.getId();
        final String name = student.getName();
        final String course = student.getCourse();
        jdbcTemplate.update(sql, new Object[]{name,course,id});
    }

    @Override
    public void insertStudent(Student student) {
        final String sql = "INSERT INTO students (name , course) VALUES (?,?)";
        final String name = student.getName();
        final String course = student.getCourse();
        jdbcTemplate.update(sql, new Object[]{name,course});
    }
}
