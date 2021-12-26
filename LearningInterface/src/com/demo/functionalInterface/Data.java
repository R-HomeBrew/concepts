package com.demo.functionalInterface;


public class Data {
	
	private int salary;
	private double shares;
	
	public Data(int salary, double shares) {
		super();
		this.salary = salary;
		this.shares = shares;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public double getShares() {
		return shares;
	}

	public void setShares(double shares) {
		this.shares = shares;
	}

	@Override
	public String toString() {
		return "Data [salary=" + salary + ", shares=" + shares + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + salary;
		long temp;
		temp = Double.doubleToLongBits(shares);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Data other = (Data) obj;
		if (salary != other.salary)
			return false;
		if (Double.doubleToLongBits(shares) != Double.doubleToLongBits(other.shares))
			return false;
		return true;
	}
}
