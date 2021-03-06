package com.mybatis3.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.mybatis3.domain.Student;
public interface StudentMapper {

	    @Select("select stud_id as studId, name, email, phone from students where stud_id=#{id}") 
	    Student findStudentById(Integer id);

		//@Insert("insert into students(name,email,addr_id, phone) values(#{name},#{email},#{address.addrId},#{phone})")
	    @Insert("insert into students(name,email,addr_id) values(#{name},#{email},#{address.addrId})")
		@Options(useGeneratedKeys=true, keyProperty="studId")
		void insertStudent(Student student);

}
