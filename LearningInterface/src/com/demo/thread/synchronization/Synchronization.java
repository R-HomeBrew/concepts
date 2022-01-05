package com.demo.thread.synchronization;

class Database {
	
	private String name;
	private int size;
	
	public Database(String nm) {
		this.name = nm;
		this.size = 10;
	}

	public  int  getSize() {
		return size;
	}

	public  void setSize(int size) {
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + size;
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
		Database other = (Database) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (size != other.size)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Database [name=" + name + ", size=" + size + "]";
	}
}

class ConnectionService implements Runnable{

	private Database db;
	
	private int sleep;
	
	public ConnectionService(Database dbObj, int halt) {
		this.db = dbObj;
		this.sleep = halt;
	}
	
	@Override
	public void run() {
		System.out.println("Starting thread execution "+Thread.currentThread().getName());
		try {
			
			if(Thread.currentThread().isInterrupted()) {
				System.out.println("MyThread.run() has been interrupted");
				throw new InterruptedException(Thread.currentThread().getName()+" has been interrrupted");
			}
			while(this.db.getSize() < 1000) {
				// increment size after sleep
				System.out.println("Before boost "+this.db.getSize());
				this.db.setSize(this.db.getSize()+100);
				Thread.sleep(sleep);
			}
			
		} catch(InterruptedException e) {
			System.err.println("Failed Thread Execution "+Thread.currentThread().getName()+ " message "+e.getMessage());
			
		} catch (Exception e) {
			System.err.println("Failed Thread Execution "+Thread.currentThread().getName()+ " message "+e.getMessage());
			
		}
		System.out.println("Ending thread execution "+Thread.currentThread().getName()+" result "+this.db.toString());
		
	}
	
}

class GarbageConnectionService implements Runnable{

	private Database db;
	
	private int sleep;
	
	public GarbageConnectionService(Database dbObj, int halt) {
		this.db = dbObj;
		this.sleep = halt;
	}
	
	@Override
	public void run() {
		System.out.println("Starting thread execution "+Thread.currentThread().getName());
		try {
			
			if(Thread.currentThread().isInterrupted()) {
				System.out.println("MyThread.run() has been interrupted");
				throw new InterruptedException(Thread.currentThread().getName()+" has been interrrupted");
			}
			while(this.db.getSize() < 1000) {
				// increment size after sleep
				System.out.println("Before garbage "+this.db.getSize());
				this.db.setSize(this.db.getSize()-100);
				Thread.sleep(sleep);
			}
			
		} catch(InterruptedException e) {
			System.err.println("Failed Thread Execution "+Thread.currentThread().getName()+ " message "+e.getMessage());
			
		} catch (Exception e) {
			System.err.println("Failed Thread Execution "+Thread.currentThread().getName()+ " message "+e.getMessage());
			
		}
		System.out.println("Ending thread execution "+Thread.currentThread().getName()+" result "+this.db.toString());
		
	}
	
}


public class Synchronization {
		
	
public static void main(String[] args) {
	Database db1 = new Database("MySQL");
	Database db2 = new Database("Oracle");
	
	
	ConnectionService conn1 = new ConnectionService(db1, 500);
	GarbageConnectionService conn2 = new GarbageConnectionService(db1, 1000);
	
	Thread thread1 = new Thread(conn1, "Thread 1");
	Thread thread2 = new Thread(conn2, "Thread 2");
	thread1.start();
	thread2.start();
}
	
	
	
}
