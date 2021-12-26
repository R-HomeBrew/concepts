package com.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.model.CollegeStudent;

public class DoubleColon {
	
	
	private String _name;
	
	public DoubleColon(String name) {
		this._name = name;
	}
	
	public static void display(String message) {
		System.out.println("Hello "+message);
	}
	
	public void setName(String name) {
		this._name = name;
	}
	
	public static void main(String[] args) {
		
		// Object
		DoubleColon obj = new DoubleColon("Romil");
		
		List<String> list = new ArrayList<String>();
        list.add("Geeks");
        list.add("For");
        list.add("GEEKS");
        
        
        list.forEach(DoubleColon::display);
        list.forEach(obj::setName);
        
        List<CollegeStudent> students = new ArrayList<CollegeStudent>();
        students = Arrays.asList(new CollegeStudent[] {
        		new CollegeStudent("Romil"),
        		new CollegeStudent("Stephen")
        });
		
        students.forEach(CollegeStudent::setStudent);

		
	}
}
