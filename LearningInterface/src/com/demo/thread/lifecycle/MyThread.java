package com.demo.thread.lifecycle;

import java.util.Arrays;
import java.util.Collection;

/** 
 * Job is to perform the sum of numbers
 * @author RBR2
 *
 */
public class MyThread implements CustomRunnable {
	
	private int sum;

	private int[] values;
	
	private long sleep;
	
	
	private Thread childJoin;
	
	public MyThread() {
		super();
	}
	
	public MyThread(int [] arr, long time){
		super();
		this.values = arr;
		this.sleep = time;
	}
	
	public void setChildJoin(Thread joinable) {
		this.childJoin = joinable;
	}
	
	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	@Override
	public void run() {
		System.out.println("Starting thread execution "+Thread.currentThread().getName());
		try {
			
			if(Thread.currentThread().isInterrupted()) {
				System.out.println("MyThread.run() has been interrupted");
				throw new InterruptedException(Thread.currentThread().getName()+" has been interrrupted");
			}
			int count = 0;
			for(int value : this.values) {
				/*
				 *  This will set the flag true for current context thread: Thread.currentThread().interrupt();
				 *  hence checking whether interrupted or not will generate 
				 *  	- Thread.currentThread().isInterrupted(): Check whether interrupted or not 
				 *  	- API from thread class like sleep will throw exception.
				 */
				
				if(count == 3) {
					//Thread.currentThread().interrupt();
				}
				count ++;
				Thread.sleep(this.sleep);
				this.sum += value;
			}
			if(this.childJoin != null) {
				System.out.println("Joing the "+Thread.currentThread().getName() +" With "+this.childJoin.getName());
				this.childJoin.join();
			}
 
		} catch(InterruptedException e) {
			System.err.println("Failed Thread Execution "+Thread.currentThread().getName()+ " message "+e.getMessage());
			
		} catch (Exception e) {
			System.err.println("Failed Thread Execution "+Thread.currentThread().getName()+ " message "+e.getMessage());
			
		}
		System.out.println("Ending thread execution "+Thread.currentThread().getName()+" result "+this.sum);
		
	}
	
	private void clean () {
		this.sum = 0;
	}

}
