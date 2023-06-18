package com.example.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Student;

@SpringBootTest
public class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepo;

	@Test
	public void save() {
		Student student = new Student(1006L, "Kshitij", "BSC", 80.0);
		studentRepo.save(student);
		Student actualResult = studentRepo.getStudentById(1006L);
		assertThat(actualResult).usingRecursiveComparison().isEqualTo(student);
	}

	@Test
	public void getStudentById() {
		Student expectedResult = new Student(1003L, "Pranav", "MSC", 70.0);
		Student actualResult = studentRepo.getStudentById(1003L);
		assertThat(actualResult).usingRecursiveComparison().isEqualTo(expectedResult);
	}

	@Test
	public void deleteStudentTest() {
		studentRepo.deleteStudentById(1003L);
		Student expectedResult = studentRepo.getStudentById(1003L);
		assertNull(expectedResult);
	}

	@Test
	public void updateStudent() {
		Student student = new Student(1005L, "Kailash", "MS", 99.0);
		studentRepo.updateStudent(student);
		Student actualResult = studentRepo.getStudentById(1005L);
		assertThat(actualResult.getId()).isEqualTo(1005L);
		assertThat(actualResult.getName()).isEqualTo("Kailash");
		assertThat(actualResult.getCourse()).isEqualTo("MS");
		assertThat(actualResult.getPercentage()).isEqualTo(99.0);
	}

	@AfterEach
	public void tearDown() {
		System.out.println("Removing data from the database!");
		studentRepo.deleteAll();
	}

	@BeforeEach
	public void setUp() {
		Student student1 = new Student(1001L, "Anant", "MSC", 90.0);
		Student student2 = new Student(1002L, "Suyog", "BSC", 80.0);
		Student student3 = new Student(1003L, "Pranav", "MSC", 70.0);
		Student student4 = new Student(1004L, "Shubham", "BSC", 65.0);
		Student student5 = new Student(1005L, "Rakshit", "MSC", 50.0);

		studentRepo.save(student1);
		studentRepo.save(student2);
		studentRepo.save(student3);
		studentRepo.save(student4);
		studentRepo.save(student5);
	}
}
