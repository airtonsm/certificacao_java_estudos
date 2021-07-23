//File using HashMap.
//It is used because it allows very fast access the data stored. "No matter" how much data is there.
//public interface Iterator

//For MenuManager Class

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/////////

import java.util.Vector;

//https://docs.oracle.com/javase/8/docs/api/java/util/Map.html
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

//https://docs.oracle.com/javase/7/docs/api/java/util/Set.html
import java.util.Set;


public class CollectionsHashMap{
	
	//https://docs.oracle.com/javase/8/docs/api/java/util/Map.html
	//The order can not be constant over time
	//Pay attenion in the load factor
	//<k><v> Can be a pair of any types

	//Variable can be from type of interfaces, but these variables can point only to objects that implements that interfaces 
	public static Map<String, String> statesCapitalCyties = new HashMap<>();
	public static String [] keys = {"Ceara","Roraima","Rondonia","Mato Grosso do Sul","Tocantins","Alagoas","Sergipe"};
	public static String [] values = {"Fortaleza","Boa Vista","Porto Velho","Campo Grande","Palmas","Maceio","Aracaju"};	
	
	public static void main(String [] args){
		//Exibt Menu
		String [] options = {"[1] - putAndGet()",
							 "[2] - removingAnItem()", 
							 "[3] - removeAll()", 
							 "[4] - printSize()", 
							 "[5] - keySetAndValues()",
							 "[6] - putIfAbsent()",
							 "[7] - printAllUsingEntry()"};
		
		MenuManager_.Menu_ menu = new MenuManager_.Menu_(options);
		MenuManager_ menuManager = new MenuManager_(menu, MenuManager_.MENU_TYPE_HIGHLIGHT_CURSOR);
		
		switch (menuManager.ShowMenu(10)){
			case 1: 
				putAndGet(statesCapitalCyties);
				break;
			case 2:
				removeAnItem("Mato Grosso do Sul", "Porto Alegre");
				break;
			case 3:
				removeAll(statesCapitalCyties, keys, values);
				break;
			case 4:
				printSize(statesCapitalCyties);
				break;
			case 5:
				keySetAndValues(statesCapitalCyties, keys, values);
				break;
			case 6:
				putIfAbsent(statesCapitalCyties, keys, values);
				break;
			case 7:
				printAllUsingEntry(statesCapitalCyties, keys, values);
				break;	
		
		}
	} 

	public static void putAndGet(Map<String, String> mphm){
		
		//REPLACE the old pair if it already exists this KEY, and return the old key
		mphm.put("Alagoas","Maceio");
		mphm.put("Sergipe","Aracaju");
		
		System.out.println("Capital de Alagoas " + mphm.get("Alagoas"));
		System.out.println("Capital de Sergipe " + mphm.get("Sergipe"));
				
	}
	
	public static void removeAnItem(String key, String value){
		
		System.out.println(	"statesCapitalCyties.put("+key+","+value+"): " 	+ statesCapitalCyties.put(key,value));
		System.out.println(	"statesCapitalCyties.get("+key+"): "  			+ statesCapitalCyties.get(key));
		System.out.println(	"statesCapitalCyties.remove("+key+"): " 		+ statesCapitalCyties.remove(key));
		System.out.println(	"statesCapitalCyties.get("+key+"): "	 		+ statesCapitalCyties.get(key));
	}
	
	public static void removeAll(Map<String, String> hm, String [] keys, String [] values){
		
		//adding
		chargeMap(hm, keys, values);
		
		System.out.println("\n");
		
		//printing
		printAll(hm, keys);
		
		System.out.println("\n");
		
		//clearing
		hm.clear();
		
		System.out.println("\n");
		
		//try to print all again
		printAll(hm, keys);
		
		//adding
		chargeMap(hm, keys, values);

		System.out.println("\n");

		//try to print all again
		printAll(hm, keys);
	}
	
	public static void printAll(Map<String,String> hm, String [] keys){
		
		for(String key : keys){
			//println() call to String
			System.out.println("keys: " + key + " | values: " + hm.get(key));
		}
	}
	
	public static Map<String, String> chargeMap(Map<String, String> mphm, String [] keys, String [] values){		
		int i=0;
		for(String key : keys){
			mphm.put(key,values[i]);
			i++;
		}
		return mphm;
	}
	
	public static void printSize(Map<String,String> hm){
		System.out.println("The size is: " + hm.size());
		chargeMap(hm, keys, values);
		System.out.println("After chargeMap(), the size is: " + hm.size());
		hm.clear();
		System.out.println("After clear(), the size is: " + hm.size());
		
	}
	
	public static void keySetAndValues(Map<String, String> hm, String [] keys, String [] values){
		
		chargeMap(hm, keys, values);
		
		System.out.println("\n");
		System.out.println("Printing only keys");
		
		for(String key : hm.keySet()){
			System.out.println(key);
		}
		
		System.out.println("\n");
		System.out.println("Printing only values");
		
		for(String value : hm.values()){
			System.out.println(value);
		}
	}
	
	public static void putIfAbsent(Map <String,String> hm, String [] keys,String [] values){
		
		//Cone without cloning keys and values
		hm=chargeMap(hm,keys,values);
		Map<String, String> hmClone = (HashMap<String,String>)((HashMap<String,String>)hm).clone();
		System.out.println(hmClone.get(keys[1]));//Must return null cause keys/values are not cloned
			
		System.out.println("Map01:");	
		printAll(hm,keys);
		System.out.println("");
		
		//try to replace value. Can't work, must return the existent value
		int i = 0;
		System.out.println("Existent k/v:		" + keys[i] +"/"+hm.get(keys[i]));
		hm.putIfAbsent(keys[i],"AnyNewValue");
		System.out.println("After hm.putIfAbsent("+keys[i]+",\"AnyNewValue\"), no change is peformed:	"+ keys[i] +"/"+ hm.get(keys[i]));
		
		
		System.out.println("");
		//Now it will work because the key[i] has a null value
		hm.put(keys[i], null);
		System.out.println("Existent k/v: " + keys[i] +"/"+hm.get(keys[i]));
		hm.putIfAbsent(keys[i],"AnyNewValue");
		System.out.println("After hm.putIfAbsent("+keys[i]+",\"AnyNewValue\"), change is peformed cause value was null:	"+ keys[i] +"/"+ hm.get(keys[i]));
		
	}

	public static void printAllUsingEntry(Map <String, String> mphm, String [] keys, String [] values){
		
		//charging HashMap		
		HashMap<String,String> hm = (HashMap<String,String>) chargeMap(mphm, keys,values);
				
		//Will print all entries(pair kv) using the interface Map.Entry
		//https://docs.oracle.com/javase/7/docs/api/java/util/Set.html
		Set<Map.Entry<String, String>> setOfEntries = hm.entrySet();
		
		for(Map.Entry<String, String> entry : setOfEntries){
			
			System.out.println("Key: " + entry.getKey() + " | Value: " + entry.getValue());
			
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
