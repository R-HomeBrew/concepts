package com.demo.thread.lifecycle;

public class ThreadLife extends Thread {

	@Override
	public void run() {
		System.out.println("Hello Thread ");
		while(true) {
			try {
				Thread.sleep(2000);
				System.out.println("Running");
				System.out.println("Running"+Thread.currentThread().getThreadGroup().getParent().getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		ThreadLife thread = new ThreadLife();

		thread.start();
		
		
		System.out.println(Thread.currentThread().getThreadGroup().activeCount());
		System.out.println(Thread.currentThread().getThreadGroup().getName());
		System.out.println(Thread.currentThread().getThreadGroup().getParent().getParent().getName());
		
	}
}
