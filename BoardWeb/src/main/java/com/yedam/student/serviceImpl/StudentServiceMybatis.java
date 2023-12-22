package com.yedam.student.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.common.DataSource;
import com.yedam.student.mapper.StudentMapper;
import com.yedam.student.service.StudentService;
import com.yedam.student.vo.Student;

public class StudentServiceMybatis implements StudentService {
	// JDBC vs Mybatis
	SqlSessionFactory factory = DataSource.getInstance();
	SqlSession session = factory.openSession(true);
	// SqlSession session = DataSource.getInstance().openSession();
	
	StudentMapper mapper = session.getMapper(StudentMapper.class);
	
	@Override
	public List<Student> studentList() {
		return mapper.studentList();
	}

	@Override
	public boolean addStudent(Student std) {
		return mapper.addStudent(std) == 1; // 입력한 데이터의 건수가 1건이 맞으면 true, 아니면 false
	}

	@Override
	public boolean modStudent(String sno, int escore, int mscore) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remStudent(String sno) {
		return mapper.remStudent(sno) == 1;
	}

	@Override
	public Student getStudent(String sno) {
		// TODO Auto-generated method stub
		return null;
	}

}
