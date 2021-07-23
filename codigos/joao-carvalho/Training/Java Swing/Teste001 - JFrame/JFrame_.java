//Studing classe JFrame
//javax.swing.JFrame extends java.awt.Frame

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Point;


public class JFrame_ extends JFrame{
	
	public static String [] args_;
	
	public static void main(String []args){
		
		args_ = args;
		
		try{
			JFrame_ frame = new JFrame_(Integer.parseInt((args[0])));
		}catch(NumberFormatException e){
			System.out.println("Throw NumberFormatException. Wrong Arguments");
		}catch(IndexOutOfBoundsException e){
			System.out.println("Throw IndexOutOfBoundsException. Wrong Arguments");
		}finally{
			System.out.println("Finally. Close");
		}
	}
	
	//Constructor to play with JFrame several features
	public JFrame_(int setting){
		switch(setting){
			case 1:
				
				setStandardSettings(this);
				setSize(new Dimension(200,200));				
				setTitle("JFrame setting 1");
				
				//https://docs.oracle.com/javase/7/docs/api/java/awt/Window.html#setSize(int,%20int)				jFrame.setSize(500,500);
				setVisible(true);//or show(); 
				break;
			
			//Testing setMinimumSize
			case 2:
			
				setStandardSettings(this);
			
				setTitle("JFrame setting 2");
				
				//https://docs.oracle.com/javase/7/docs/api/java/awt/Window.html#setMinimumSize(java.awt.Dimension)
				setMinimumSize(new Dimension(600,600));
				
				//https://docs.oracle.com/javase/7/docs/api/java/awt/Window.html#setSize(java.awt.Dimension)
				//Won't be set as the mimimum size was set
				setSize(new Dimension(100,200));
				
				setVisible(true);
			break;
			
			//Testing pack() method
			case 3:
			
				setStandardSettings(this);
			
				setTitle("JFrame setting 3");
				
				//https://docs.oracle.com/javase/7/docs/api/java/awt/Window.html#setMinimumSize(java.awt.Dimension)
				setMinimumSize(new Dimension(600,600));
				
				//https://docs.oracle.com/javase/7/docs/api/java/awt/Window.html#setSize(java.awt.Dimension)
				//Won't be set as the mimimum size was set
				setSize(new Dimension(100,200));
				
				//https://docs.oracle.com/javase/7/docs/api/java/awt/Window.html#pack()
				pack();
				setVisible(true);
				
			break;
			
			//Testing setLocation and Class Point
			case 4:
			
				setStandardSettings(this);
			
				setTitle("JFrame setting 4");
				
				//https://docs.oracle.com/javase/7/docs/api/java/awt/Window.html#setMinimumSize(java.awt.Dimension)
				setMinimumSize(new Dimension(600,600));
				
				//https://docs.oracle.com/javase/7/docs/api/java/awt/Window.html#setSize(java.awt.Dimension)
				//Won't be set as the mimimum size was set
				setSize(new Dimension(100,200));
				
				//https://docs.oracle.com/javase/7/docs/api/java/awt/Window.html#pack()
				pack();
				
				//https://docs.oracle.com/javase/7/docs/api/java/awt/Window.html#setLocation(java.awt.Point)
				//https://docs.oracle.com/javase/7/docs/api/java/awt/Point.html
				try{
				setLocation(new Point(Integer.parseInt(args_[1]), Integer.parseInt(args_[2])));
				}catch(Exception e){
					System.out.println("When typng for, type x and y location");
				}
				setVisible(true);
				break;
			
			//Centering JFrame on Screen
			case 5:
			
				setStandardSettings(this);
			
				setTitle("JFrame setting 5");
				
				//https://docs.oracle.com/javase/7/docs/api/java/awt/Window.html#setMinimumSize(java.awt.Dimension)
				setMinimumSize(new Dimension(600,600));
				
				//https://docs.oracle.com/javase/7/docs/api/java/awt/Window.html#setLocationRelativeTo(java.awt.Component)
				//centering at the screen
				setLocationRelativeTo(null);
				
				setVisible(true);
				break;
				
			//PLaying with look and feel	
			case 6:
				
				//https://docs.oracle.com/javase/7/docs/api/javax/swing/JFrame.html#setDefaultLookAndFeelDecorated(boolean)
				//set this before create the jframe
				this.setDefaultLookAndFeelDecorated(false);
				
				JFrame jframe = new JFrame("JFrame setting 6");
				jframe.setStandardSettings();
				jframe.setSize(new Dimension(200,200));				
								
				//https://docs.oracle.com/javase/7/docs/api/java/awt/Window.html#setSize(int,%20int)				jFrame.setSize(500,500);
				jframe.setVisible(true);//or show();
				
				break;
			
			//Playing with ImageIcon	
			case 7:
				
				//https://docs.oracle.com/javase/7/docs/api/javax/swing/JFrame.html#setDefaultLookAndFeelDecorated(boolean)
				//set this before create the jframe
				this.setDefaultLookAndFeelDecorated(false);
				
				JFrame jframe = new JFrame("JFrame setting 7");
				jframe.setStandardSettings();
				jframe.setSize(new Dimension(200,200));
				
				//https://docs.oracle.com/javase/7/docs/api/javax/swing/ImageIcon.html
				//https://docs.oracle.com/javase/7/docs/api/javax/swing/ImageIcon.html#getImage()
				ImageIcon imageIcon = new ImageIcon(imgURL).getImage();
				
				
				
				//https://docs.oracle.com/javase/7/docs/api/java/awt/Window.html#setSize(int,%20int)				jFrame.setSize(500,500);
				jframe.setVisible(true);//or show();
				
				break;
		}		
	}
	
	public void setStandardSettings(JFrame jframe){
		//https://docs.oracle.com/javase/7/docs/api/javax/swing/JFrame.html#setDefaultCloseOperation(int)
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}