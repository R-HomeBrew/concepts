package com.demo.thread.lifecycle;

public class ThreadExecutor {
	
	
	private static int [] arr = new int [] {1,2,3,4,5};
	
	public static void main(String[] args) {
		MyThread oen =  new MyThread(arr, 1000);
		Thread thread_1 = new Thread(oen,"Thread 1");
		
		
		
		Thread thread_2 = new Thread(new MyThread(arr, 2000), "Thread 2");
		
		Thread thread_3 = new Thread(new MyThread(arr, 3000), "Thread 3");
		
		thread_3.start();
		thread_2.start();
		oen.setChildJoin(thread_3);
		thread_1.start();
		
		
	}

}
