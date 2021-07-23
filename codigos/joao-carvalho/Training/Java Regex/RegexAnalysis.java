/*Playing with regex string and the regex api*/

package api_regex;

import java.util.regex.*;

public class RegexAnalysis{
	
	//Regex that define the format of an email
	private static final String EMAIL_REGEX_PATTERN = "[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+";

	//Regex that define the format of a password
	private static final String PASSWORD_REGEX_PATTERN = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}";

	//private static final String ASCII_PONCTUATION_REGEX_PATTERN = "[!#$%&'()*+,\-./:;<=>?@[\\\]^_`{|}~]";
		
	public static void main(String []Args) throws ArrayIndexOutOfBoundsException{
		
		try{
			switch(Integer.valueOf(Args[0])){
				case 1: 
					isEmailRight(Args[1]); 
					break;
				case 2: 
					isPasswordRight(Args[1]); 
					break;	
				default: 
					System.out.println("Wrong arguments");
			}
		}catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Throw ArrayIndexOutOfBoundsException. Digite todos os argumentos! ");
		}catch	(Exception e){
			System.out.println("Throw Exception Digite argumentos no formato correto! ");
		}
	}
	
	/**Verify if the email match the email format*/
	public static boolean isEmail(String email){
			System.out.println(Pattern.matches(EMAIL_REGEX_PATTERN,email));
			return Pattern.matches(EMAIL_REGEX_PATTERN,email);
	}
	
	/**Verify if the password match the password format*/
	public static boolean isPasswordRight(String password){
			//System.out.println(Pattern.matches(PASSWORD_REGEX_PATTERN,password));
			//System.out.println(password);
			return Pattern.matches(PASSWORD_REGEX_PATTERN,password);
	}
	
}