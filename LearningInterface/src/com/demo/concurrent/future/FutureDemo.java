package com.demo.concurrent.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

class RunnableImpl implements Runnable {

	@Override
	public void run() {
		try {
			while(true) {
				Thread.sleep(1000);
				System.out.println("Hello Runnable");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}


class Callable implements java.util.concurrent.Callable<String> {

	@Override
	public String call() throws Exception {
		try {
			Thread.sleep(2000);
			System.out.println("Hello Callable");
		} catch (Exception e) {
			return "Hello Exception";
		}
		return "Hello Callable";
	}
	
}


class CustomExecutor extends Thread {
	
	private List<FutureTask<String>> tasks = new ArrayList<FutureTask<String>>();
	
	public CustomExecutor(FutureTask<String> task) {
		tasks.add(task);
	}
	
	@Override
	public void run() {
		System.out.println("Running executor");
		tasks.stream().forEach(task -> {
			System.out.println("Running task "+task.toString());
			task.run();
		});
		System.out.println("ending executor");
	}
	
}

public class FutureDemo {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		RunnableImpl taskRun = new RunnableImpl();
		String result = "";
		FutureTask<String> tasksRunnable = new FutureTask<String>(taskRun,result);
		
		CustomExecutor executor = new CustomExecutor(tasksRunnable);
		executor.start();
		
		
		
		int count = 0;
		while(true) {
			if(count == 6) break;
			
			Thread.sleep(500);
			
			System.out.println("Main "+count+" Result "+ tasksRunnable.get());
			System.out.println("Main "+count+" Result "+ tasksRunnable.isCancelled());
			
			System.out.println("Main "+count+" Result "+ tasksRunnable.isDone());
			
			if(count == 4) {
				tasksRunnable.cancel(true);
			}
			
		}
		
	}
	

}
