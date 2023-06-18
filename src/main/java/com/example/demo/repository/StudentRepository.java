package com.example.demo.repository;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.demo.model.Student;

@Component
public class StudentRepository {

	private final Map<Long, Student> studentDB;

	public StudentRepository(Map<Long, Student> studentDB) {
		this.studentDB = studentDB;
	}

	public void save(Student student) {
		if (null != student.getId()) {
			studentDB.put(student.getId(), student);
		}
	}

	public Student getStudentById(Long id) {
		Student student = null;
		if (null != id) {
			student = studentDB.get(id);
		}
		return student;
	}

	public void deleteStudentById(Long id) {
		if (null != id) {
			studentDB.remove(id);
		}
	}

	public void updateStudent(Student student) {
		if (null != student) {
			Student existingStudent = studentDB.get(student.getId());
			if (null != existingStudent) {
				studentDB.put(student.getId(), student);
			}
		}
	}

	public void deleteAll() {
		if (!studentDB.isEmpty()) {
			studentDB.clear();
		}
	}
}
