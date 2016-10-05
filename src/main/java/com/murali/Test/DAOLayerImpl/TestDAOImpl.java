package com.murali.Test.DAOLayerImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.murali.Test.DAOLayer.TestDAO;
import com.murali.Test.dto.Student;

@Repository
public class TestDAOImpl implements TestDAO {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public boolean saveStudent(Student student) {
		System.out.println(":::::dao");
		boolean flag=false;
		System.out.println(mongoTemplate.collectionExists(Student.class));
		if(mongoTemplate.collectionExists(Student.class)){
			mongoTemplate.createCollection(Student.class);
		}else{
			System.out.println(":::::LLLLL");
		}
		student.setUUID(UUID.randomUUID().toString());
		mongoTemplate.save(student, "student");
		System.out.println("::::::::::::::::::::::::::::::::::::::::::ddd");
		flag=true;
		return flag;
	}

	@Override
	public boolean updateStudent(Student student) {
		boolean flag=false;
		System.out.println(student);
		//mongoTemplate.insert(student, "student");
		flag=true;
		return flag;
	}

	@Override
	public List<Student> findStudents() {
		List<Student> students =mongoTemplate.findAll(Student.class);
		return students;
	}

	@Override
	public boolean deleteStudent(int no) {
		boolean flag=false;
		Query query=new Query();
		query.addCriteria(Criteria.where("_id").is(no+""));
		mongoTemplate.findAndRemove(query, Student.class);
		flag=true;
		return flag;
	}

	@Override
	public Student getStudent(int no) {
		System.out.println(no);
		Query query=new Query();
		query.addCriteria(Criteria.where("_id").is(no+""));
		Student student =	mongoTemplate.findOne(query, Student.class);
		System.out.println(student);
		return student;
	}
}
