package com.murali.Test.DAOLayer;

import java.util.List;

import com.murali.Test.dto.Student;

public interface TestDAO {

	boolean saveStudent(Student student);
	
	boolean updateStudent(Student student);
	
	List<Student> findStudents();
	
	boolean deleteStudent(int no);

	Student getStudent(int no);
	
}
