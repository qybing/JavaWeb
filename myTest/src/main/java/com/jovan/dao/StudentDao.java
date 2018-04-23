package com.jovan.dao;

import com.jovan.bean.Student;

import java.util.List;

public interface StudentDao {

    List<Student> selectAllStudent();
    Student selectStudentById(Integer id);
    void insertStudent(Student student);
    void updataStudent(Student student);
    void deleteStudentById(Integer id);

}
