package com.demo.functionalInterface;

public class Income {

	private long income;

	public Income(long income) {
		super();
		this.income = income;
	}

	public long getIncome() {
		return income;
	}

	public void setIncome(long income) {
		this.income = income;
	}

	@Override
	public String toString() {
		return "Income [income=" + income + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (income ^ (income >>> 32));
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
		Income other = (Income) obj;
		if (income != other.income)
			return false;
		return true;
	}
}
