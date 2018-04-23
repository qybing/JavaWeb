package com.jovan.mytest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.jovan.bean.Student;
import com.jovan.dao.StudentDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class MapperTest {

    @Autowired
    StudentDao studentDao;

    //查询
    @Test
    public void test1() {
        System.out.println(studentDao);
        List<Student> students = studentDao.selectAllStudent();
        for (Student student : students) {
            System.out.println(student.getName()+"   "+student.getAge());
        }
    }

    //插入
    @Test
    public void test2() {
//        System.out.println(studentDao);
        Student stu = new Student();
        stu.setName("王五");
        stu.setAge(12);
        studentDao.insertStudent(stu);
    }

    //插入
    @Test
    public void test3() {
//        System.out.println(studentDao);
        Student stu = new Student();
        Integer id =2;
        studentDao.deleteStudentById(id);
    }

    //修改
    @Test
    public void test4() {
//        System.out.println(studentDao);
        Student stu = new Student();
        stu.setName("张三");
        stu.setAge(15);
        studentDao.updataStudent(stu);
    }
}
