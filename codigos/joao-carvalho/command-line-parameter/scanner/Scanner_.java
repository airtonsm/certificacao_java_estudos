//Code for playing with class Scanner
//from java.util.Scanner
//Scanner uses regular expressions parse primitive types and strings

//https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html
import java.util.Scanner;
import java.util.regex.Pattern;

public class Scanner_{

	//for calling the arguments out of the main methods
	public static String[] args1;
		
	//--------------------------------------
	
	public static void main(String [] args){
		args1 = args;
		
		//to get the option from the argument
		int option = 0;
		
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
			//Getting input and printing on console
			case 1:
				option1();				
				break;
			case 2:
				option2();
				break;
			case 3:
				option3();
					break;
		}
	}
	
	//What is static can be saw only from what is static
	public static void option1(){
		
			//https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html#Scanner(java.io.InputStream)
			Scanner scanner = new Scanner(System.in);
			
			if(scanner.hasNext()){
				//next() https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html#next()
				String input = scanner.next();
				
				System.out.println("Printing your input until encouter a space caracter: "+input);
			}else{
				System.out.println("It has no input");
			}
	}	
	public static void option2(){
		
			//https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html#Scanner(java.io.InputStream)
			Scanner scanner = new Scanner(System.in);
			
			if(scanner.hasNext()){
				//next() https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html#next()
				String input = scanner.next();
				
				System.out.println("Printing your input until encouter a space caracter: "+input);
				System.out.println("Printing (with nextLine()) the rest of the line after calling next(): "+scanner.nextLine());
			}else{
				System.out.println("It has no input");
			}
	}
	public static void option3(){
		
			//https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html#Scanner(java.io.InputStream)
			Scanner scanner = new Scanner(System.in);
			
			if(scanner.hasNext()){
				
				//pattern to verify if string is email
				String pattern = "[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+";
				
				
				//findInLine() https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html#findInLine(java.lang.String)
				String input = scanner.findInLine(Pattern.compile(pattern));
				
				System.out.println("Printing part the input that matches the pattern - Using scanner.findInLine(Patter.compile()): retur null if not encoutered: "+input);
			}else{
				System.out.println("It has no input");
			}
	}
}