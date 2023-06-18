package com.example.demo.service;

import org.springframework.stereotype.Component;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Component
public class StudentService {

	private final StudentRepository studentRepo;

	public StudentService(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}

	public void save(Student student) {
		studentRepo.save(student);
	}

	public Student getStudentById(Long id) {
		return studentRepo.getStudentById(id);
	}

	public void deleteStudentById(Long id) {
		studentRepo.deleteStudentById(id);
		System.out.println("Student [" + id + "] removed!");
	}

	public void updateStudent(Student student) {
		studentRepo.updateStudent(student);
		System.out.println("Student [" + student.getId() + "] updated!");
	}

}
