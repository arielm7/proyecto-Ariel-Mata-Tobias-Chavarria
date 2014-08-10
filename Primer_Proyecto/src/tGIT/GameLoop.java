package tGIT;
import javax.swing.JFrame;


public class GameLoop extends JFrame {
	
	GameLoop(){
		this.setTitle("Crazy Defender");
		this.setBounds(200,200,600,500);
		this.setVisible(true);
		
		
	}
	
	public static void main(String arg[]){
		
		GameLoop ventana= new GameLoop();
	}
	

}
