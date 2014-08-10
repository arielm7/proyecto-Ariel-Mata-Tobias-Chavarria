package tGIT;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;


public class GameLoop extends JFrame implements Runnable {
	
	int width = 300, heigth = 250 , posX=20, posY=20;;
	boolean entrar;
	Thread threadPrin;
	
	GameLoop(){
		this.setTitle("Crazy Defender");
		this.setBounds(200,200,width,heigth);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.addWindowListener(new WindowEvents(this));
		this.addKeyListener(new KeyEvents(this));
		this.addMouseListener(new MouseEvents(this));
		this.addMouseMotionListener(new MouseMotion(this));

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
			catch (InterruptedException e) {e.printStackTrace();}
			}
		
		System.exit(0);
		
	}
	
	
	public void endGame(){
		entrar=false;
	}
	
	private void update(){
		
	}
	
	private void render(){
		Graphics g;
		
		g = this.getGraphics();
		
		if (g!= null){
		g.setColor(Color.cyan);
		g.fillRect(0, 0, width, heigth);
		g.setColor(Color.black);
		g.drawString("Crazy Defender", 110,100);
		g.drawRect(posX, posY, 30, 30);
		g.fillRect(posX, posY, 30, 30);
		
		Toolkit.getDefaultToolkit();
		g.dispose(); }
		
		
	}
	
	public static void main(String arg[]){
		
		GameLoop ventana= new GameLoop();
	}

	public void changePos(int xpos, int ypos) {
		this.posX= xpos;
		this.posY= ypos;
		
		
	}


	
	

}
