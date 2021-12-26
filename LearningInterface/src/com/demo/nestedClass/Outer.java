package com.demo.nestedClass;

public final class Outer {
	
	private String name = "outer";
	
	public Outer() {
		System.out.println(this.name);
		InnerClass inner = new InnerClass();
		System.out.println(InnerClass.no);
	}
	
	class InnerClass {
		
		private String name = "inner"; 
		
		public final static int no = 1;
		
		public InnerClass() {
			System.out.println(Outer.this.name);
			System.out.println(this.name);
		}
		
		/*
		 * public final static void display() { // error not allowed.
		 * 
		 * }
		 */
	}
	
	public static void main(String[] args) {
		Outer out = new Outer();
		System.out.println(Outer.InnerClass.no);
		InnerClass inner = out.new InnerClass();
		
	}

}
