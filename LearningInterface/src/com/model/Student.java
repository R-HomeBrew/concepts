package com.model;

public class Student implements Comparable<Student> {
	
	private String name;
	private int rollNo;
	
	public Student() {
		super();
		this.name = "";
		this.rollNo = 0;
	}
	
	public Student(String name, int rollNo) {
		super();
		this.name = name;
		this.rollNo = rollNo;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + rollNo;
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
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rollNo != other.rollNo)
			return false;
		
		return true;
	}

	@Override
	public int compareTo(Student input) {
		// return -1 : this is less than input
		// return 0 : they are same
		// return 1: this is greater than input
		/* 
		 * Comparision is based on roll No
		 * 
		 */
		if(input.getRollNo() == 0) return 1;
		
		if(this.rollNo == 0) return -1;
		
		if(this.rollNo == input.rollNo)  return 0;
		
		if(this.rollNo > input.rollNo) return 1;
		
		if(this.rollNo < input.rollNo) return -1;
		
		return 0; // they are same.
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", rollNo=" + rollNo + "]";
	}
}
