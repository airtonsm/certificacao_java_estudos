//To play with class Point

import java.awt.Point;
import javax.swing.JFrame;
import java.awt.Dimension;


public class Point_ {
	
	public static String[] args1;
	public static int option;

	public static void main(String [] args){
		args1 = args;
		
		try{
			option =  Integer.parseInt((args[0]));
		}catch(NumberFormatException e){
			System.out.println("Throw NumberFormatException. Wrong Arguments");
		}catch(IndexOutOfBoundsException e){
			System.out.println("Throw IndexOutOfBoundsException. Wrong Arguments");
		}finally{
			System.out.println("Finally. Close");
		}
	
		
		
	switch(option){
		case 1:	
			JFrame jFrame = new JFrame("Window in movement");
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	

			jFrame.setSize(new Dimension(200,200));
			
			
				
			jFrame.setVisible(true);
			
			for(int i = 1; i<=100 ; i+=5){
				//https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html#sleep(long)
				
				try{
					//Sleep  throws an exception, so I have to catch this
					Thread.sleep(1000);
				}catch(Exception e){
						
				}
				
				jFrame.setLocation(new Point(10,i));
			}
			
			break;
	}
	}
}
