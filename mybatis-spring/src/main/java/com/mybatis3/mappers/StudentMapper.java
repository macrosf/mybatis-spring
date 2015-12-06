package com.mybatis3.mappers;

import org.apache.ibatis.annotations.Select;

import com.mybatis3.domain.Student;
public interface StudentMapper {

	    @Select("select stud_id as studId, name, email, phone from students where stud_id=#{id}") 
	    Student findStudentById(Integer id);

}
