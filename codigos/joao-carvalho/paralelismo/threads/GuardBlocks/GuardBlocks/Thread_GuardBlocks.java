//This application will show how guards blocks works

class MessageServer{
	
	private String message;

	/**True if the consumer should wait for the producer to send message
	 **False if the producer should wait for the consumer to retrieve the last sent message*/
	private boolean empty;
	
	/*Threads often have to coordinate their actions.
	*The block of code inside thid method will help the threads wait based on a condition(state of this object).
	*Allow synchronized work*/
	public synchronized void putMessage(String message){
		
		//The thread executing this methods own this object monitor
		//Will wait(and release monitor) only if there is no data yet
		while(!empty){
			
			//At this point the thread release the monitor, and other thread(that will retrive) will get the monitor
			//wait until a Object.notifyAll be called
			try{wait();}catch(Exception e){}
			/*After the put methods notifyAll, this thread will be awake and 
			**will verify if its conditions has being attended*/			
		}
		
		//Deliver data to the server
		this.message = message;
		
		//Wake other threads waiting for this monitor
		notifyAll();
		//jump out the method and release the monitor for the retrieve methodd
	}
	
	
	/*Threads often have to coordinate their actions.
	*The block of code inside thid method will help the threads 
	wait based on a condition(state of this object).
	*Allow synchronized work.
	*This method is synchronized so only when the thread is owning
	this object monitor, that thread can acess this method*/
	public synchronized String retriveMessage(){
		
		while(empty){
			try{wait();}catch(Exception e){}
		}
		
		return this.message;
		notifyAll();
	}
}

