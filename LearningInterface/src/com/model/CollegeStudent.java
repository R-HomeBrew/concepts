package com.model;

import java.util.ArrayList;
import java.util.List;

public class CollegeStudent  {

	private String name;
	
	public static List<CollegeStudent> students = new ArrayList<CollegeStudent>();
	
	public CollegeStudent(String nm) {
		this.name = nm;
	}

	public static CollegeStudent getStudent() {
		return CollegeStudent.students.get(1);
	}

	public static void setStudent(CollegeStudent std) {
		System.out.println("Hello "+std.toString());
		CollegeStudent.students.add(std);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CollegeStudent other = (CollegeStudent) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CollegeStudent [name=" + name + "]";
	}
	
	
}
