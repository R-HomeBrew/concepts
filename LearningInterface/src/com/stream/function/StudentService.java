package com.stream.function;

import com.stream.model.Student;

public interface StudentService <T extends Student> {

	String STATUS = "LEARNING";
	
	default String getStatus () {
		return StudentService.STATUS;
	}
	
	boolean doAdmission(T student);
	T getStudent();
	boolean removeStudent(T student); 
}
