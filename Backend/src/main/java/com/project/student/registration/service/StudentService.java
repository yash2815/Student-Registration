package com.project.student.registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.student.registration.data.StudentData;
import com.project.student.registration.entity.Student;
import com.project.student.registration.exception.StudentNotFoundException;

@Service
public class StudentService {
	
	@Autowired
	private StudentData data;
	
	public String addStudent(Student student)
	{
		data.appendobj(student);
		return "Data Added Successfully";
	}

	public List<Student> getAllStudent() throws StudentNotFoundException
	{

		return data.getStudentList();
	}
	
	public String deleteStudent(int rollNo) throws StudentNotFoundException
	{
		return data.deleteStudent(rollNo);
	}
	
	public String modifyStudent(Student student) throws StudentNotFoundException
	{
		return data.modifyStudent(student);
	}
	
	public Student getOneStudent(int rollNo) throws StudentNotFoundException
	{
		return data.getOneStudent(rollNo);
	}
}
