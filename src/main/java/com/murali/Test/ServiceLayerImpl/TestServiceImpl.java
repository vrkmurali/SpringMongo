package com.murali.Test.ServiceLayerImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murali.Test.DAOLayer.TestDAO;
import com.murali.Test.ServiceLayer.TestService;
import com.murali.Test.dto.Student;

@Service
public class TestServiceImpl implements TestService{
	@Autowired
	private TestDAO testDAO;
	
	@Override
	public boolean saveStudent(Student student) {
		System.out.println(":::::service");
		boolean flag=testDAO.saveStudent(student);
		return flag;
	}

	@Override
	public boolean updateStudent(Student student) {
		boolean flag=testDAO.updateStudent(student);
		return flag;
	}

	@Override
	public List<Student> findStudents() {
		return testDAO.findStudents();
	}

	@Override
	public boolean deleteStudent(int no) {
		boolean flag=testDAO.deleteStudent(no);
		return flag;
	}

	@Override
	public Student getStudent(int no) {
		System.out.println(no);
		Student student = testDAO.getStudent(no);
		return student;
	}
}
