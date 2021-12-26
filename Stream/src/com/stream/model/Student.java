package com.stream.model;

public class Student extends Person {
	
	private int rollNumber;

	public Student() {
		super();
	}

	public Student(String name, int rollNumber) {
		super(name);
		this.rollNumber = rollNumber;
	}
	
	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", getName()=" + getName() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + rollNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (rollNumber != other.rollNumber)
			return false;
		return true;
	}
}
