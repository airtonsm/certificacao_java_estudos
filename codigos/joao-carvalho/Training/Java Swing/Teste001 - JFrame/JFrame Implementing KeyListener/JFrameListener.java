import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class JFrameListener extends JFrame implements KeyListener{
	
	public static  JFrameListener JFrameListener;
	public static int logNumber;
	
	public static void main(String [] args){
		JFrameListener = new JFrameListener();
		logNumber = 0;
	}
	
	public JFrameListener(){
		setTitle("No Key pressed");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		addKeyListener(this);//THIS METHOD MUST BE CALLED
	}
	
	
	
	//https://docs.oracle.com/javase/7/docs/api/java/awt/event/KeyEvent.html
	public void keyTyped(KeyEvent keyEvent){
		System.out.println(
			"Log " +
			(logNumber++) +
			": called keyType() :         " +
			String.valueOf(keyEvent.getKeyChar()) +
			"   "+
			String.valueOf(keyEvent.getKeyCode())
		);
	}
		
	public void keyPressed(KeyEvent keyEvent){
		System.out.println(
			"Log " +
			(logNumber++) +
			": called keyPressed() :  " +
			String.valueOf(keyEvent.getKeyChar()) +
			"   "+
			String.valueOf(keyEvent.getKeyCode())
		);
	}
	public void keyReleased(KeyEvent keyEvent){
		System.out.println(
			"Log " +
			(logNumber++) +
			": called keyReleased() : " +
			String.valueOf(keyEvent.getKeyChar()) +
			"   "+
			String.valueOf(keyEvent.getKeyCode())
		);
	}
	
	
}