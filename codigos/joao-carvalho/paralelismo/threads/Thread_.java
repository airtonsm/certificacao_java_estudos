//Code for playing with class Thread
//from java.lang.Thread

//https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html
import java.lang.Thread;
//https://docs.oracle.com/javase/7/docs/api/java/lang/Runtime.html
import java.lang.Runnable;

import java.lang.InterruptedException;

//Iterate forward a number executing some task on each cycle
public class Thread_{
	
	
	public static void main(String [] args){
		
		switch(1){
			case 1:
				//access the synchronized method of an object without thread conflict
				syncAcess();
				break;
			case 2: 
				//access a assynchronized method of an object causing thread conflict
				notSyncAcess();
				break;
			case 3:
				partiallySyncAcess();
				break;
			case 4:
				testInterruption();
				break;
		}	
	
	}
	
	public static void syncAcess(){
		
		SyncEntireMethods synchronizedMethod;
		synchronizedMethod = new SyncEntireMethods();
		
		Thread thread_1 = new Thread(
			 
			new Runnable(){
				public void run(){
					synchronizedMethod.countDownSync(1000);
				}
			},
			"Thread 1"
		);
		thread_1.start();	
		
		Thread thread_2 = new Thread(
			 
			new Runnable(){
				public void run(){
					synchronizedMethod.countDownSync2(1000);
				}
			},
			"Thread 2"
		);
		thread_2.start();
	
		
	
	
	
		try{
		thread_1.join();
		thread_2.join();
		}catch(Exception e){
			System.out.println("InterruptedException - if any thread has interrupted the current thread. The interrupted status of the current thread is cleared when this exception is thrown.");
		}
		
		
		System.out.println("CountDown finished");
	}
	
	public static void notSyncAcess(){

		SyncEntireMethods synchronizedMethod;

		synchronizedMethod = new SyncEntireMethods();
		
		Thread thread_1 = new Thread(
			 
			new Runnable(){
				public void run(){
					//accessing assyncronized method
					synchronizedMethod.countDownNotSync(1000);
				}
			},
			"Thread 1"
		);
		thread_1.start();	
		
		Thread thread_2 = new Thread(
			 
			new Runnable(){
				public void run(){
					synchronizedMethod.countDownNotSync(1000);
				}
			},
			"Thread 2"
		);
		thread_2.start();
	
		
	
	
	
		try{
		thread_1.join();
		thread_2.join();
		}catch(Exception e){
			System.out.println("InterruptedException - if any thread has interrupted the current thread. The interrupted status of the current thread is cleared when this exception is thrown.");
		}
		
		
		System.out.println("CountDown finished");
	}
	
	public static void partiallySyncAcess(){

		SyncEntireMethods synchronizedMethod;

		synchronizedMethod = new SyncEntireMethods();
		
		Thread thread_1 = new Thread(
			 
			new Runnable(){
				public void run(){
					//accessing assyncronized method
					synchronizedMethod.countDownPartiallySync(1000);
				}
			},
			"Thread 1"
		);
		thread_1.start();	
		
		Thread thread_2 = new Thread(
			 
			new Runnable(){
				public void run(){
					synchronizedMethod.countDownPartiallySync(1000);
				}
			},
			"Thread 2"
		);
		thread_2.start();
	
		
	
	
	
		try{
		thread_1.join();
		thread_2.join();
		}catch(Exception e){
			System.out.println("InterruptedException - if any thread has interrupted the current thread. The interrupted status of the current thread is cleared when this exception is thrown.");
		}
		
		
		System.out.println("CountDown finished");
	}
	
	public static void testInterruption(){
		Thread thread = new Thread(new ClassImplementsRunnable(), "NameOfThisThreadObject");
		//call run method of the Runnable in another thread of execution
		{
			thread.start();
			//I think it does not take actually 1 second because my computer isn't multicore
			try{Thread.sleep(1000);}
			catch(InterruptedException e){
				System.out.println("sleep() method returned an InterruptedException");
			}
			thread.interrupt();
		}
	}
}
	



class SyncEntireMethods{
	
	/* if an object is visible to more than one thread, all reads
	or writes to that object's variables are done through synchronized methods.*/
	
	//Using synchronized means this method can be run by one thread 
	//at time for this object
	public synchronized void  countDownSync(int Count){
		for(int i=0 ; i<=Count ; i++){
			System.out.println(i);
		}
			
	}
	
	/*Two synchronized methods cannot be executed at the same time
	 *even by different threads*/
	public synchronized void  countDownSync2(int Count){
		for(int i=0 ; i<=Count ; i++){
			System.out.println(i);
		}		
	}
	
	public void  countDownNotSync(int Count){
		for(int i=0 ; i<=Count ; i++){
			System.out.println(i);
		}		
	}
	
	//part of this method's block is synchronized
	public void countDownPartiallySync(int Count){
		
		
		/*Block synchronized. When a thread A reach this point, if a thread B is executing this, 
		*so, the thread A must wait until the thread B get finished because the thread B own the intrinsic lock
		*(or monitor) of this object(every object has one)*/
		//The parameter "this" is a monitor
		synchronized (this){
			for(int i=5000 ; i<=5500 ; i++){
			System.out.println(i);
			}
		} 
		
		//block not synchronized. While the thread a get here, will be executing in paralel with
		//the thread A that starts the previous block when thread B finished it
		for(int i=0 ; i<=Count ; i++){
			System.out.println(i);
		}
	}
}

class ClassImplementsRunnable implements Runnable {
		
		public void run(){
			//Here is the business logic of the this class
			//What this class is intend to perform
			
			performFirstTask();
			runSleep(5000);
		}
		
		/**If while running this method,this thread receives a interrupt
		**this method will stop a throw the interrupt exception*/
		public void performFirstTask(){
			
			System.out.println("peformFisrtTask");
			
			for(int i=0;i<=10000;i++){
				System.out.println(i);
				/*I check if thread was interrupted in order to not shutdown
				 *immediately, finshing the current computation properly.
				 *The interrupt status(an internal flag) is cleared after static boolean interrupted() is called; It is suppose
				 * that the thread will treat the current interruption when calling this method.
				 *The interrupt status(an internal flag) is NOT cleared after isInterrupted() is called.*/
				if(Thread.currentThread().isInterrupted()){
					System.out.println("peformFisrtTask() check to isInterrupted() return true");
					break;
				}
			}
			
		}
		
		public void runSleep(int i){
			try{
				/*I can call sleep just to check if this thread was interrupt
				 *once this method is suppose to thrown an InterruptException
				 *if this thread has true for isInterrupted*/
				/*By convention, any method that exits by throwing an
				 *InterruptedException clears interrupt status when it does so*/
				Thread.sleep(i);
			}catch(InterruptedException e){
				System.out.println("The sleep() method was interrupted");
			}	
		}
}