//File using java.lang.Iterator
//public interface Iterator

//For MenuManager Class

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/////////
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

public class CollectionsVector{
	
	public static void main(String [] args){
		//Exibt Menu
		String [] options = {"[1] - usingVerctorCollection()", "[2] - Create and Show Random Matrix"};
		
		MenuManager_.Menu_ menu = new MenuManager_.Menu_(options);
		MenuManager_ menuManager = new MenuManager_(menu, MenuManager_.MENU_TYPE_HIGHLIGHT_CURSOR);
		
		switch (menuManager.ShowMenu(10)){
			case 1: 
				usingVerctorCollection1();
				break;
			case 2:
				Matrix.generateRandanMatrix(10,10,20,10).showMatrix();
				break;
			
		
		}
	} 

	public static void usingVerctorCollection1(){
		
		//Creating Matrix 1
		Vector<Vector<Integer>> choseLines = new Vector<Vector<Integer>>();
		Vector<Integer> vector1 = new Vector<Integer>();vector1.add(1);vector1.add(6);vector1.add(9);
		Vector<Integer> vector2 = new Vector<Integer>();vector2.add(2);vector2.add(1);vector2.add(5);
		Vector<Integer> vector3 = new Vector<Integer>();vector3.add(3);vector3.add(0);vector3.add(3);
		choseLines.add(vector1);
		choseLines.add(vector2);
		choseLines.add(vector3);
		Matrix matrix1 = new Matrix("The chose name", choseLines);

		matrix1.showMatrix();
		System.out.println("\n Transpose");
		matrix1.getTranspose().showMatrix();
	}
}
//https://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html
//Any Objetc to create a collection of


class Matrix{
	
	//Instance variables
	private String name;
	private Vector<Vector<Integer>> lines;//Vector of Vectors of Integers. arrays[] do not work
	
	//GETTERS AND SETTERS
	public Vector<Vector<Integer>> getLines(){
		return this.lines;
	}
	
	//CONSTRUCTOR
	public Matrix(String name, Vector<Vector<Integer>> lines){
		this.name = name;
		this.lines = lines;
	}
	
	//Just to initialize the instance variables
	public Matrix(){
		this.lines = new Vector<Vector<Integer>>();
	}
	
	
	
	public boolean isIdenity(){
		boolean response = true; //initially
		
		int numberOfLines = howMuchLines();
		int numberOfColumns = howMuchColumns();
		
		//labeling the outer loop
		outerloop:
		for(int il = 0; il<numberOfLines ; il++){
			/*The element of the line that has the
			 *same index of the line must be 1
			 *Otherwise, it is no a identity matrix*/
			if(lines.get(il).get(il) == 1){
				/*Verify the positions the must be zero*/	
				for(int ic = 0; ic<numberOfColumns ; ic++){
					/*If this element is the 1 element*/
					if(ic == il) continue;
					if(lines.get(il).get(ic) != 0 ){
						response = false;
						break outerloop;
					}
				}
			}else{
				response = false;
				break ;
			}
		}
		
		return response;
	}
	
	public int howMuchLines(){
		return this.lines.size();
	}
	
	public int howMuchColumns(){
		//https://docs.oracle.com/javase/8/docs/api/java/util/Vector.html#size--
		return this.lines.get(0).size();
	}
	
	public boolean isSquare(){
		//Ternary Operator
		return howMuchColumns() == howMuchLines()?true:false;
	}
	
	/**Return true if the line could be added*/
	public boolean addLineAtEnd(Vector<Integer> newLine){
		if(this.lines != null){
			//if there is line in this matrix
			if(this.lines.size() != 0){
				//If the new line does not has the same length
				if(this.lines.get(0).size() == newLine.size()){
					this.lines.add(newLine);
					return true;
				//if the line didn't matched the line size
				}else return false;
			//if ther is no line in this matrix
			}else{
				this.lines.add(newLine);
				return true;
			}	
		}
		//if lines wasn't initialized
		return false;
	}
	
	
	//Transpose lines
	public Matrix getTranspose(){
		
		Matrix transposeMatrix = new Matrix();
		
		int numberOfColumns = this.howMuchColumns();
		int numberOfLines = this.howMuchLines();
		
		for(int ic = 0; ic<numberOfColumns ; ic++){
			Vector<Integer> newline = new Vector<>();
			
			for(int il = 0; il<numberOfLines; il++){
				newline.add(this.lines.get(il).get(ic));	
			}
			transposeMatrix.addLineAtEnd(newline);
		}
		
		return transposeMatrix;
	}
	
	/**Generate a matrix with @lineOrder lines and @columnOrder columns and the generated elements are within the range of @elementDownBound and @elementUpBound */
	public static Matrix generateRandanMatrix(int lineOrder,int columnOrder,int elementDownBound, int elementUpBound){
		
		Matrix matrix = new Matrix();
		
		for(int il=0; il<lineOrder; il++){
			matrix.getLines().add(new Vector<Integer>());
			for(int ic = 0; ic < columnOrder ; ic++){
				//https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ThreadLocalRandom.html#nextInt-int-int-
				matrix.getLines().get(il).add(ThreadLocalRandom.current().nextInt(elementUpBound, elementDownBound));
			}
		}
		return matrix;
	}
	
	public void showMatrix(){
		int numberOfLines = this.howMuchLines();
		int numberOfColumns = this.howMuchColumns();
		
		for(int il = 0 ; il<numberOfLines ; il++){
			for(int ic = 0; ic<numberOfColumns ; ic++ ){
				//Printf do not break line after printing the its arguments
				System.out.printf(lines.get(il).get(ic) + " ");
			}
			System.out.println('\n');
		}
	}
	
}




//For using JFrame Menu
/**This class will represent a menu manager for a choosing option on prompt*/
class MenuManager_ {
	
	/**The menu the will managed*/
	MenuManager_.Menu_ menu;	
	
	/**1 - Options highlighted with a cursor*/
	private int typeOfMenu;
	public static final int MENU_TYPE_HIGHLIGHT_CURSOR = 1;
	
	/**An integer value that indicates what option is highlighted*/
	public static int optionFocused;
	private static final String cursor = "<<<<<<<<<<";
	protected boolean userPressEnter = false;
	
	//GETTERS AND SETTERS
	
	public int getOptionsFocused(){ 		return this.optionFocused; 	}
	public void setOptionsFocused(int optionFocused){ 		this.optionFocused = optionFocused; 	}
	

	//CONSTRUCTORS
	
	public MenuManager_(Menu_ menu, int typeOfMenu){
		this.menu = menu;
		this.typeOfMenu = typeOfMenu;
		//initially
		setOptionsFocused(1);
	}

	//METHODS
	
	/*Show the options to screen and collect user option
	 *@clearScreen : if true, the screen is cleared before show menu*/
	public int ShowMenu(int secondsWait){
		MenuManager_.JFrameMenu jFrameMenu = new MenuManager_.JFrameMenu(this.menu, 1);
		
		int option = jFrameMenu.collect(secondsWait);//this will run in another thread
		
		jFrameMenu.dispose();
		
		return option;
	}		
	
	//NESTED CLASSES
	
	
	/**JComponent to listen the key press an tell the class running in commanline*/
	//protected only superclass can access
	private static class JFrameMenu extends JFrame implements KeyListener{
		private JTextArea jTextAreaMenu;
		private String [] OptionsTexts;
		private int optionFocused;
		private int optionSelected;
		private boolean pickedUp;
		
		
		//CONSTRUCTOR
		public JFrameMenu(MenuManager_.Menu_ menu, int optionInitiallyFocused){
			jTextAreaMenu = new JTextArea();
			jTextAreaMenu.setFocusable(false);
			
			this.add(jTextAreaMenu);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.optionFocused = optionInitiallyFocused;
			this.pickedUp = false;
			
			this.OptionsTexts = menu.getStringsOfOptions();
			
			setJTextAreaMenu(OptionsTexts);
			
			this.setMinimumSize(new Dimension(500,500));
			addKeyListener(this);
		}
		
		public void setJTextAreaMenu(String[] OptionsTexts){
			this.jTextAreaMenu.setText("");
			
			for(int i=0 ; i < OptionsTexts.length ; i++){
				
				this.jTextAreaMenu.setText(this.jTextAreaMenu.getText() + "\n" + OptionsTexts[i]);
				
				if(i+1 == this.optionFocused){
					this.jTextAreaMenu.setText(this.jTextAreaMenu.getText() + "  "+MenuManager_.cursor);
				}
			}	
		}
		
		/**Change the focus in the menu and 
		 *return the number of the new option focused
		 *return -1 if it has reached the first option*/
		public int changeFocusUp(){
			
			//Update cursor position only if it hasn't reached the top
			if(optionFocused!=1)
				optionFocused--;
			setJTextAreaMenu(this.OptionsTexts);
			return optionFocused;
		}

		/**Change the focus in the menu and 
		 *return the number of the new option focused
		 *return -1 if it has reached the final option*/
		public int changeFocusDown(){
			//Update cursor position only if it hasn't reached the end
			if(optionFocused!=OptionsTexts.length)
				optionFocused++;
			setJTextAreaMenu(this.OptionsTexts);
			return optionFocused;
		}
		
		//Return the selected option number
		public int collect(int secondsForWait){
			
			this.show();
			
			//Change the title of the JFrame to update the time the user has to pickup an option
			for(int i = secondsForWait; i!=0; i--){
				
				//If the user typed ENTER, stop count down and return the option for the caller
				if(pickedUp == true ) break;
				
				try{Thread.sleep(1000);}catch(InterruptedException e){optionSelected = optionFocused;}
				this.setTitle("Pick up an option within " + i + " seconds");
				
			}
			this.setVisible(false);
			
			optionSelected = optionFocused;
			
			return optionSelected;
		}
		
		
		//https://docs.oracle.com/javase/7/docs/api/java/awt/event/KeyEvent.html
		public void keyTyped(KeyEvent keyEvent){	
		}
		public void keyPressed(KeyEvent keyEvent){
			if(keyEvent.getKeyCode() == KeyEvent.VK_UP){
				this.changeFocusUp();
			}else if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN){
				this.changeFocusDown();
			}else if(keyEvent.getKeyCode() == KeyEvent.VK_ENTER){
				pickedUp = true;
			}
		}
		public void keyReleased(KeyEvent keyEvent){
		}
		
	}	
	
	public static class  Menu_{
	
		 
		private int optionChose;
		private String [] StringsOfOptions;
		
		//GETTERS and SETTERS
		public int getOptionChose(){ 		return this.optionChose; 	}
		public void setOptionChose(int optionChose){ 		this.optionChose = optionChose; 	}
		
		public String [] getStringsOfOptions(){ 		return this.StringsOfOptions; 	}
		public void setStringsOfOptions(String[] StringsOfOptions){ 		this.StringsOfOptions = StringsOfOptions; 	}

		
		//CONSTRUCTOR
		/**This contructor create a simple menu class from a vector of strings*/
		public Menu_(String [] StringsOfOptions){
			this.StringsOfOptions = StringsOfOptions;
			
		}

	}
}
