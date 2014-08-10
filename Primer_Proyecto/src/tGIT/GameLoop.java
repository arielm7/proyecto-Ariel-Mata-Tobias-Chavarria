package tGIT;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;


public class GameLoop extends JFrame implements Runnable {
	
	int width = 600, heigth = 500;
	boolean entrar;
	Thread threadPrin;
	
	GameLoop(){
		this.setTitle("Crazy Defender");
		this.setBounds(200,200,width,heigth);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.addWindowListener(new WindowEvents(this));
		
		
		
		
		threadPrin = new Thread(this);
		
		threadPrin.start();
		
		
		
	}
	
	public void run() {
		System.out.println("Started");
		entrar=true;
		while(entrar){
			update();
			render();
			try {Thread.sleep(20);} 
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
	}
	
	private void update(){
		
	}
	
	private void render(){
		Graphics g;
		g = this.getGraphics();
		g.setColor(Color.cyan);
		g.fillRect(0, 0, width, heigth);
		g.setColor(Color.black);
		g.drawString("Crazy Defender", 200,100);
		
		Toolkit.getDefaultToolkit();
		g.dispose();
		
		
	}
	
	public static void main(String arg[]){
		
		GameLoop ventana= new GameLoop();
	}


	
	

}
