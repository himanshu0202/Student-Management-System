package com.himanshuanand.Controller;

import com.himanshuanand.Dao.StudentDao;
import com.himanshuanand.Entity.Student;
import com.himanshuanand.Service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by himanshuanand on 5/4/17.
 */
@RestController
@RequestMapping("/students")
public class StudentControllerImpl implements StudentDao {

    @Autowired
    private StudentServiceImpl studentServiceImpl;

    @Override
    @GetMapping
    public Collection<Student> getAllStudents(){
        return studentServiceImpl.getAllStudents();
    }

    @Override
    @GetMapping(value = "/{id}")
    public Student getStudentById(@PathVariable("id") int id){
        return studentServiceImpl.getStudentById(id);
    }

    @Override
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void removeStudentById(@PathVariable("id") int id){
        studentServiceImpl.removeStudentById(id);
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateStudent(@RequestBody Student student){
        studentServiceImpl.updateStudent(student);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertStudent(@RequestBody Student student){
        studentServiceImpl.insertStudent(student);
    }
}
