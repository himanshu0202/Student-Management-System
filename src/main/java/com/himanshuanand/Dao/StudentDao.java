package com.himanshuanand.Dao;

import com.himanshuanand.Entity.Student;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by himanshuanand on 5/4/17.
 */
public interface StudentDao {
    @GetMapping
    Collection<Student> getAllStudents();

    @GetMapping(value = "/{id}")
    Student getStudentById(@PathVariable("id") int id);

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    void removeStudentById(@PathVariable("id") int id);

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    void updateStudent(@RequestBody Student student);

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    void insertStudent(@RequestBody Student student);
}
