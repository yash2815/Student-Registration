package com.project.student.registration.data;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.project.student.registration.entity.Student;
import com.project.student.registration.exception.StudentNotFoundException;

@Component
public class StudentData {
	
	Logger logger = LoggerFactory.getLogger(StudentData.class);
	
	private List<Student> studentList = new ArrayList<Student>();
	


	public List<Student> getStudentList() throws StudentNotFoundException
	{

		if(studentList.size()!=0) {
			return studentList;
		}else {
			throw new StudentNotFoundException("Student List is Empty!");
		}
		
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	public void appendobj(Student obj)
	{
		studentList.add(obj);
		logger.info("Data Added Successfully");
	}
	
	public String deleteStudent(int rollNo) throws StudentNotFoundException
	{
		List<Student> lst = getStudentList();
		for(Student obj:lst)
		{
			if(obj.getRollNo()==rollNo)
			{
				lst.remove(obj);
				setStudentList(lst);
				logger.info("Data Deleted Successfully");
				return "Data Deleted Successfully.";
			}
		}
		logger.error("Invalid Student RollNo.");
		throw new StudentNotFoundException("Invalid Student RollNo.");
	}
	
	public String modifyStudent(Student student) throws StudentNotFoundException
	{
		int roll = student.getRollNo();
		String temp = deleteStudent(roll);
		appendobj(student);
		logger.info("Data Modified Successfully");
		return "Data Modified Successfully";
	}
	
	public Student getOneStudent(int rollNo)throws StudentNotFoundException
	{
		List<Student> lst = getStudentList();
		for(Student obj:lst)
		{
			if(obj.getRollNo()==rollNo)
			{
				return obj;
			}
		}
		logger.error("Invalid Student RollNo.");
		throw new StudentNotFoundException("Invalid Student RollNo.");
	}
}
