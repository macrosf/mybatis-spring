package com.mybatis3.services;

import com.mybatis3.domain.Student;
import com.mybatis3.mappers.StudentMapper;

public class StudentService {

	    private StudentMapper studentMapper; 
	    public void setStudentMapper (StudentMapper studentMapper) 
	    { 
	        this. studentMapper = studentMapper; 
	    } 
	    public Student findStudentById(Integer id) 
	    { 
	        return this.studentMapper.findStudentById(id);  
	    } 
}
