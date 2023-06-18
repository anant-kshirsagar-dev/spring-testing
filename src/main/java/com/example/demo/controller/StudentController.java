package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@PostMapping("/add")
	public void addStudent(@RequestBody Student student) {
		studentService.save(student);
		System.out.println("Student added successfully! Id: " + student.getId());
	}

	@GetMapping("/get/{id}")
	public Student getStudentById(@PathVariable Long id) {
		return studentService.getStudentById(id);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		System.out.println("Student removed successfully! Id: " + id);
	}

	@PostMapping("/update")
	public void updateStudent(@RequestBody Student student) {
		studentService.updateStudent(student);
		System.out.println("Student updated successfully! Id: " + student.getId());
	}
}
