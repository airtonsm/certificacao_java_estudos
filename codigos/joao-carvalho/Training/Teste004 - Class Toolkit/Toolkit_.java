//Code for study the abstract Toolkit class
//A class for several use cases
//Has native implementations. More precise results

//https://docs.oracle.com/javase/7/docs/api/java/awt/Toolkit.html
import java.awt.Toolkit;

public class Toolkit_{
	
	public static String [] arguments;
	
	public static void main(String [] args){
		arguments = args;
		int arg = 0;
		try{
			arg = Integer.parseInt(args[0]);
		}catch(Exception e){
			System.out.println("Error when parsing arguments");
			System.out.println(e);		
		}
		
		switch(arg){
			//Printing screen size
			case 1:
				System.out.println(
					//https://docs.oracle.com/javase/7/docs/api/java/awt/Toolkit.html#getDefaultToolkit()
					//https://docs.oracle.com/javase/7/docs/api/java/awt/Toolkit.html#getScreenSize()
					Toolkit.getDefaultToolkit().getScreenSize()
				);
				
			break;
		}
	}
}

