package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.StudentMapper;
import com.example.model.CourseModel;
import com.example.model.StudentModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentServiceDatabase implements StudentService
{
    @Autowired
    private StudentMapper studentMapper;
    
    @Override
    public List<CourseModel> selectAllCourses() {
    	List<CourseModel> sese = studentMapper.selectAllCourses();
    	for(int i = 0; i < sese.size();i++) {
    		System.out.println(sese.get(i).getIdCourse() + " dan " + sese.get(i).getName() + " dan " + sese.get(i).getCredits());
    	}
    	return studentMapper.selectAllCourses();
    }


    @Override
    public StudentModel selectStudent (String npm)
    {
        log.info ("select student with npm {}", npm);
        return studentMapper.selectStudent (npm);
    }
    
    @Override
	public CourseModel selectCourse(String idCourse) {
    	log.info("select course with id_course {}", idCourse);
		return studentMapper.selectCourse(idCourse);
	}

    @Override
    public List<StudentModel> selectAllStudents ()
    {
        log.info ("select all students");
        return studentMapper.selectAllStudents ();
    }


    @Override
    public void addStudent (StudentModel student)
    {
        studentMapper.addStudent (student);
    }


    @Override
    public void deleteStudent (String npm)
    {
    	log.info ("student " + npm + " deleted");
    	studentMapper.deleteStudent(npm);
    }
    
    @Override
    public void updateStudent (StudentModel student)
    {
    	log.info ("student " + student.getNpm() + " updated");
    	studentMapper.updateStudent(student);;
    }

}
