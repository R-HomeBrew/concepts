package com.demo.nestedClass;

import com.demo.nestedClass.Outer.InnerClass;

public class OuterStaticNested {

	private String name = "outer";
	private static String suranme = "surname";
	
	public OuterStaticNested() {
		System.out.println(this.name);
		InnerClass inner = new InnerClass();
		System.out.println(InnerClass.no);
	}
	
	public static class InnerClass {
		
		private String name = "inner"; 
		
		public final static int no = 1;
		
		public InnerClass() {
			// error, no access to member of outer : System.out.println(Outer.this.name);
			System.out.println(OuterStaticNested.suranme);
			System.out.println(this.name);
		}
		
		public final static void display() {
		}
	}
	
	public static void main(String[] args) {
		OuterStaticNested out = new OuterStaticNested();
		System.out.println(OuterStaticNested.InnerClass.no);
		OuterStaticNested.InnerClass inner = new OuterStaticNested.InnerClass();
		
		
	}
	
}
