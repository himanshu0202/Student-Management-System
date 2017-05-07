package com.himanshuanand.Dao;

import com.himanshuanand.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by himanshuanand on 5/4/17.
 */
@Repository
@Qualifier("StudentDaoImpl")
public class StudentDaoImpl implements StudentDao {

    private static Map<Integer,Student> students;

    static {
        students = new HashMap<Integer, Student>(){
            {
                put(1,new Student(1,"Himanshu","Computer Science"));
                put(2,new Student(2,"Alexis","Industrial Production"));
                put(3,new Student(3,"Amanda","Computer Engineering"));
            }
        };
    }

    public Collection<Student> getAllStudents(){
        return this.students.values();
    }

    public Student getStudentById(int id){
        return this.students.get(id);
    }

    public void removeStudentById(int id) {
        this.getAllStudents().remove(id);
    }

    public void updateStudent(Student student){
        Student s = students.get(student.getId());
        s.setCourse(student.getCourse());
        s.setName(student.getName());
    }

    public void insertStudent(Student student) {
        this.students.put(student.getId(),student);
    }
}
