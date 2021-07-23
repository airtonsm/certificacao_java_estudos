package teste001_commandLineParameter;

public class ComandLineParameterTest{
	
	public static String response = "End of file";
	
	public static void main(String[] argumentos){
		
		try{
			if(Integer.parseInt(argumentos[0]) == 1){
				System.out.println("Você entrou argumento 1");
		
			}
			if(Integer.parseInt(argumentos[0]) == 2){
				System.out.println("Você entrou argumento 2");
		
			}
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e);
			System.out.println("Throw ArrayIndexOutOfBoundsException. Gerou um erro! Você não entrou nenhum argumento");
		}


		System.out.println(response); 
	}

}