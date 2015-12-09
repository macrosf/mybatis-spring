package com.mybatis3.services;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mybatis3.domain.Address;
import com.mybatis3.domain.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class StudentServiceTest {
	//@Autowired
	private StudentService studentService;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@Test
	public void testCreatStudent() {
		
		Address address = new Address(5, "Quaker Ridge Rd.", "Bethel", "Brooklyn", "06801", "USA"); 
		Student stud = new Student(); 
		long ts = System.currentTimeMillis(); 
		stud.setName("stud_" + ts); 
		stud.setEmail("stud_" + ts + "@gmail.com"); 
		stud.setAddress(address); 
		Student student = studentService.createStudent(stud); 
		assertNotNull(student); 
		assertEquals("stud_" + ts, student.getName()); 
		assertEquals("stud_" + ts + "@gmail.com", student.getEmail()); 
		System.err.println("CreatedStudent: " + student); 
}

	@Test(expected = DataAccessException.class) 
	public void testCreateStudentForException() {
		 Address address = new Address(0, "Quaker Ridge Rd.", "Bethel", "Brooklyn", "06801", "USA"); 
		Student stud = new Student(); 
		long ts = System.currentTimeMillis(); 
		stud.setName("Timothy"); 
		stud.setEmail("stud_" + ts + "@gmail.com"); 
		stud.setAddress(address); 
		studentService.createStudent(stud); 
		fail("You should not reach here"); 
	}
}
