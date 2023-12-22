package com.yedam.student.mapper;

import java.util.List;

import com.yedam.student.vo.Student;

public interface StudentMapper {
	// CRUD
	List<Student> studentList();
	int addStudent(Student std); // #{studentNo} Student 필드명
	int remStudent(String sno); // #{sno} Student 필드명
}
