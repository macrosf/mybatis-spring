package com.mybatis3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mybatis3.domain.Address;
import com.mybatis3.domain.Student;
import com.mybatis3.mappers.AddressMapper;
import com.mybatis3.mappers.StudentMapper;

//@Service
//@Transactional
public class StudentService {
	//@Autowired
    private StudentMapper studentMapper; 
	//@Autowired
    private AddressMapper addressMapper;
    
    public void setStudentMapper (StudentMapper studentMapper) 
    { 
        this. studentMapper = studentMapper; 
    } 
    
    public void setAddressMapper (AddressMapper addressMapper) 
    { 
        this. addressMapper = addressMapper; 
    } 
    
    public Student findStudentById(Integer id) 
    { 
        return this.studentMapper.findStudentById(id);  
    }
    
	public Student createStudent(Student student) {
		Address address = student.getAddress();
		if(address != null){
			addressMapper.insertAddress(address);
		}
		if(student.getName()==null || student.getName().trim().length()==0){
			throw new RuntimeException("Student Name should not be null");
		}
		studentMapper.insertStudent(student);
		return student;
	}
}
