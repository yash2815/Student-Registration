package com.project.student.registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.student.registration.entity.Student;
import com.project.student.registration.exception.StudentNotFoundException;
import com.project.student.registration.object.CustomObject;
import com.project.student.registration.service.StudentService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class StudentController {

	@Autowired
	private StudentService service;
	
	
	@PostMapping("/addstudent")
	public ResponseEntity<CustomObject<Student>>addStudent(@RequestBody Student student)
	{

	    String successMessage = service.addStudent(student);
	    CustomObject<Student> response = new CustomObject<>(); 
	    response.setStatusCode(HttpStatus.OK.value());
	    response.setData(student);
	    response.setResponseMessage(successMessage);
	    return ResponseEntity.ok(response);
	}
	

	@GetMapping("/allstudents")
	public ResponseEntity<CustomObject<List<Student>>> getAllStudent() throws StudentNotFoundException
	{
		try {
			List<Student> lst = service.getAllStudent();
			CustomObject<List<Student>> response = new CustomObject<>();
			response.setStatusCode(HttpStatus.OK.value());
			response.setData(lst);
			response.setResponseMessage("Data Retrieved Successfully");
			return ResponseEntity.ok(response);
		}catch(StudentNotFoundException e) {
			CustomObject<List<Student>> response = new CustomObject<>();
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			response.setData(null);
			response.setResponseMessage(e.getMessage());
			return ResponseEntity.ok(response);
		}
	}
	
	@DeleteMapping("/deletestudent/{rollNo}")
	public ResponseEntity<CustomObject<Student>> deleteStudent(@PathVariable int rollNo) throws StudentNotFoundException
	{
//		return service.deleteStudent(rollNo);
		try {
			String successMessage = service.deleteStudent(rollNo);
		    CustomObject<Student> response = new CustomObject<>(); 
		    response.setStatusCode(HttpStatus.OK.value());
		    response.setData(null);
		    response.setResponseMessage(successMessage);
		    return ResponseEntity.ok(response);
		}catch(StudentNotFoundException e) {
			CustomObject<Student> response = new CustomObject<>();
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			response.setData(null);
			response.setResponseMessage(e.getMessage());
			return ResponseEntity.ok(response);
		}
	}
	
	@PutMapping("/modifystudent")
	public ResponseEntity<CustomObject<Student>> modifyStudent(@RequestBody Student student) throws StudentNotFoundException
	{
		try {
			String successMessage = service.modifyStudent(student);
		    CustomObject<Student> response = new CustomObject<>(); 
		    response.setStatusCode(HttpStatus.OK.value());
		    response.setData(student);
		    response.setResponseMessage(successMessage);
		    return ResponseEntity.ok(response);
		}catch(StudentNotFoundException e) {
			CustomObject<Student> response = new CustomObject<>();
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			response.setData(null);
			response.setResponseMessage(e.getMessage());
			return ResponseEntity.ok(response);
		}
		
	}
	
	@GetMapping("/getstudent/{rollNo}")
	public ResponseEntity<CustomObject<Student>> getOneStudent(@PathVariable int rollNo) throws StudentNotFoundException
	{
		try {
			Student obj = service.getOneStudent(rollNo);
		    CustomObject<Student> response = new CustomObject<>(); 
		    response.setStatusCode(HttpStatus.OK.value());
		    response.setData(obj);
		    response.setResponseMessage("Data Retrieved Successfully");
		    return ResponseEntity.ok(response);
		}catch(StudentNotFoundException e) {
			CustomObject<Student> response = new CustomObject<>();
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			response.setData(null);
			response.setResponseMessage(e.getMessage());
			return ResponseEntity.ok(response);
		}
	}
}
