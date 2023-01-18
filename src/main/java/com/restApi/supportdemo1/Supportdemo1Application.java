package com.restApi.supportdemo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1")
public class Supportdemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Supportdemo1Application.class, args);
	}

	@GetMapping("/studentDetails")
	public List<StudentDetails> studentDetails() {
		return Arrays.asList(
				new StudentDetails(1L, "John", "Smith", "john@gmail.com"),
				new StudentDetails(2L, "Sachin", "Dave", "sachin@gmail.com"),
				new StudentDetails(3L, "Peter", "Mark", "peter@gmail.com"),
				new StudentDetails(4L, "Martin", "Smith", "martin@gmail.com"),
				new StudentDetails(5L, "Raj", "Patel", "raj@gmail.com"),
				new StudentDetails(6L, "Virat", "Yadav", "virat@gmail.com"),
				new StudentDetails(7L, "Prabhas", "Shirke", "prabhas@gmail.com"),
				new StudentDetails(8L, "Tina", "Kapoor", "tina@gmail.com"),
				new StudentDetails(9L, "Mona", "Sharma", "mona@gmail.com"),
				new StudentDetails(10L, "Rahul", "Varma", "rahul@gmail.com"));
	}

	@PostMapping("/createStudent")
	public ResponseEntity<StudentDetails> createStudent(@RequestBody StudentRequest studentRequest) {
		System.out.println("Student Created " + studentRequest.getId());
		StudentDetails studentDetails = new StudentDetails();

		studentDetails.setId(studentRequest.getId());
		studentDetails.setFirstName(studentRequest.getFirstName());
		studentDetails.setLastName(studentRequest.getLastName());
		studentDetails.setEmail(studentRequest.getEmail());

		return new ResponseEntity<>(studentDetails, HttpStatus.OK);
	}
}
