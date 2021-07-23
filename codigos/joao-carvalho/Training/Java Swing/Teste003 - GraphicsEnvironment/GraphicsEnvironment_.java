/*Working with 
	*GraphicsEnvironment
	*GraphicsDevice		 
	*GraphicsConfiguration*/ 

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Point;

import java.awt.GraphicsEnvironment;
import java.awt.GraphicsDevice;
import java.awt.GraphicsConfiguration;
import java.awt.Rectangle;



public class GraphicsEnvironment_{
	
	public static void main(String [] args){
		//https://docs.oracle.com/javase/7/docs/api/java/awt/GraphicsEnvironment.html
		GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		
		//https://docs.oracle.com/javase/7/docs/api/java/awt/GraphicsDevice.html
		GraphicsDevice[] graphicsDevices = graphicsEnvironment.getScreenDevices();
		
		//Individual GraphicDevice
		GraphicsDevice graphicsDevice = graphicsDevices[0];
			
		GraphicsConfiguration[] graphicsConfiguration = graphicsDevice.getConfigurations();
		
		
		int argument = 0;
		try{		
			argument = 	Integer.parseInt(args[0]);
		}catch(Exception e){
			System.out.println("Error when catching arguments");
		}
		
		
		switch(argument){				
			
			//Show screen bounds
			case 1:			
				//https://docs.oracle.com/javase/7/docs/api/java/awt/Rectangle.html
				Rectangle screenBounds = graphicsConfiguration[0].getBounds();
				System.out.println(screenBounds.toString());
				break;
		}
	}
}