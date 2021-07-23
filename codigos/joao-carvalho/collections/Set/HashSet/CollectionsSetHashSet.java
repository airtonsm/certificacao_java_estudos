//File using HashMap.
//It is used because it allows very fast access the data stored. 
//"No matter" how much data is there.
//No guarantees of the order of the elements whenever I access it
//public interface Iterator
//See SetImplementations https://docs.oracle.com/javase/tutorial/collections/implementations/set.html

//For MenuManager Class

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/////////

import java.util.Vector;

//https://docs.oracle.com/javase/7/docs/api/java/util/Set.html
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Arrays;


public class CollectionsSetHashSet{
	
	//Does not store 2 objects that are equal
	public static Set<String> SetOfStrings; 
	public static String [] capitalCities = {"Fortaleza","Boa Vista","Porto Velho","Campo Grande","Palmas","Maceio","Aracaju"};	
	public static String [] capitalCitiesEnumerated = {"[1]Fortaleza","[2]Boa Vista","[3]Porto Velho","[4]Campo Grande","[5]Palmas","[6]Maceio","[7]Aracaju"};	
	
	public static Set<Integer> SetOfInteger; 
	public static Integer [] ArrNumeric1 = {1,2,3,4,5,6,7,8,9,10};	
	public static Integer [] ArrNumeric2 = {7,8,9,10,11,12,13,14,15};	
	
	public static void main(String [] args){
		//Exibt Menu
		String [] options = {"[1] - addAndPrint()",
							 "[2] - UnionIntersectionDiference()"};
		
		MenuManager_.Menu_ menu = new MenuManager_.Menu_(options);
		MenuManager_ menuManager = new MenuManager_(menu, MenuManager_.MENU_TYPE_HIGHLIGHT_CURSOR);
		
		switch (menuManager.ShowMenu(10)){
			case 1: 
				PrintSet(getLoadedHashSet(capitalCities));
				break;
			case 2: 
				showUnion(ArrNumeric1, ArrNumeric2);
				break;
		}
		
	} 
	
	
	public static void PrintSet(Set<String> SetOfStrings){
		
		//Trying to add duplicate
		//getting an iterator from this collection
		Iterator<String> iterator = SetOfStrings.iterator();
		
		if(iterator.hasNext())
			//must print false
			System.out.println(SetOfStrings.add(iterator.next()));
		
		//Print all without duplicates	
		System.out.println(SetOfStrings);
	}
	
	/*Here a told I was returning a type, so I can return any objects
	that implements Set interface*/
	public static Set<String> getLoadedHashSet(String [] strings){
		
		HashSet<String> hashSet = new HashSet<String>();
		
		for(String s : strings){
			hashSet.add(s); 
		}
		
		return hashSet;
	}
	
	public static void showUnion(Integer[]arr1, Integer[]arr2){
		
		Set<Integer> set1 =  new HashSet<Integer>();
		Set<Integer> set2 =  new HashSet<Integer>();
		
		//setting the initial capacity to 64;
		//as I add() elements and it overpass 64(if the load factor is 1) or 32(if the load factor is 0.5),
		//other hash table is created and element copied from one to another
		
		Set<Integer> union = new HashSet<Integer>(64);
		Set<Integer> intersection = new HashSet<Integer>();
		Set<Integer> difference = new HashSet<Integer>();
		
		//https://docs.oracle.com/javase/8/docs/api/java/util/Set.html#addAll-java.util.Collection-
		//https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html#asList-T...-
		set1.addAll(Arrays.asList(arr1));
		set2.addAll(Arrays.asList(arr2));
		
		System.out.println("Set1: "+set1);
		System.out.println("Set2: "+set2);
		
		union.addAll(set2);
		union.addAll(set1);
		
		intersection.addAll(set1);
		intersection.retainAll(set2);
		
		difference.addAll(set1);
		difference.removeAll(set2);
		
		System.out.println("Union Set1 u Set2: "+ union);
		System.out.println("Intersection Set1 n Set2: "+ intersection);
		System.out.println("Difference Set1 - Set2: "+ difference);
		
		
		
	}

	public static void showIterateOrder(){
		
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
		
		//Whenever the user type any key, the count down will be renewed
		private int currentSecondsWait;
		private int secondsWait;
		
		
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
		public int collect(int secondsForWaitParameter){
			
			secondsWait = secondsForWaitParameter;
			//Whenever the user type any key, the count down will be renewed
			currentSecondsWait = secondsForWaitParameter;
			this.show();
			
			//Change the title of the JFrame to update the time the user has to pickup an option
			//Whenever the user type any key, the count down will be renewed
			while(currentSecondsWait!=-1){
				
				//If the user typed ENTER, stop count down and return the option for the caller
				if(pickedUp == true ) break;
				
				try{Thread.sleep(1000);}catch(InterruptedException e){optionSelected = optionFocused;}
				this.setTitle("Pick up an option within " + currentSecondsWait + " seconds");
				currentSecondsWait--;
			};
			this.setVisible(false);
			
			optionSelected = optionFocused;
			
			return optionSelected;
		}
		
		
		//https://docs.oracle.com/javase/7/docs/api/java/awt/event/KeyEvent.html
		public void keyTyped(KeyEvent keyEvent){	
		}
		public void keyPressed(KeyEvent keyEvent){
			//Whenever the user type any key, the count down will be renewed
			currentSecondsWait=secondsWait;
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
