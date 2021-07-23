import java.util.*;

public class ForEach{
	
	//First argument is for choosing the method for test the For Each structure
	public static void main(String []arguments){
		
		//Collection for applying for each over
		ArrayList<String> stringArrayList = new ArrayList<>();
		
		//Can throuw exceptions on wrong arguments
		try{
			switch(Integer.valueOf(arguments[0])){
				case 1:			
					System.out.println("Option 1(List Words): ");
					
					//length is a field of an array the determines its size
					for(int i=1; i < arguments.length ; i++){
						stringArrayList.add(arguments[i]);
					}
					
					//Using a Collection at foreach, ArrayList
					int i = 1;
					for(String a : stringArrayList){
						if(a != arguments[0])
							System.out.println(i +": "+ a);
						i++;
					}
					break;
				
				case 2:
					//Method for jumping out of the program
					System.out.println("Exit application");
					System.exit(0);
		}
				
		}catch(NumberFormatException nfe ){
			System.out.println(nfe);
			System.out.println("Throw NumberFormatException. Wrong Arguments!");
		}catch(ArrayIndexOutOfBoundsException aioob ){
			System.out.println(aioob);
			System.out.println("Throw ArrayIndexOutOfBoundsException. Insert Arguments!");
		}
	}
}