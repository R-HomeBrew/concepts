package com.demo.nestedClass;

interface Math {
	
	int add(int x, int y);
}

public class InterfaceImpl {

	
	public static void main(String[] args) {
		
		// Inline extend of abstract class
		Thread thread = new Thread("Printer") {
			@Override
		    public void run() {
				
				try {
					Thread.currentThread().sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("Hello Thread "+Thread.currentThread().getName());
		    }
		};
		
		thread.run(); //synchronous while start asynchronous
		
		// inline implementation of interface
		Math cal = new Math() {
			@Override
			public int add(int x, int y) {
				return x+y;
			}
		};
		
		System.out.println(cal.add(10, 20));
		
	}
	
}
