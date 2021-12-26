package com.demo.nestedClass;

public class NestedClassDemo {
	
	public static void main(String[] args) {
		Outer out = new Outer();
		Outer.InnerClass inner = out.new InnerClass();
	}
}
