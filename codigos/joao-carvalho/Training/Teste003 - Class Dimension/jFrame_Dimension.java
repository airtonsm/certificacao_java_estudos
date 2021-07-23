/*This code explore the use of the class, dimensions*/
/*java.awt,Dimension*/
/* public class Dimension extends Dimension2D implements Serializable*/

//Usable links
//https://docs.oracle.com/javase/7/docs/api/java/awt/Dimension.html

//Encapsulate Width and Height

package class_dimension;
import java.awt.Dimension;
import javax.swing.JFrame;


public class jFrame_Dimension extends JFrame{
	
	public static void main(String [] args){
		/*Instantiating this class, setting the name of the window.*/
		jFrame_Dimension frame = new jFrame_Dimension();		
	}
	
	public jFrame_Dimension(){
		/*Tell the window to not hide when click on X, but actually
		close*/
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		/*method Iherited from java.awt.window.*/
		Dimension dim = new Dimension(500,500);
		setSize(dim);
		
		/*Method Iherited from java.awt.Frame*/
		setTitle("Nome da Janela");
		
		//Method Iherited from java.awt.Window
		setVisible(true);
	}
}