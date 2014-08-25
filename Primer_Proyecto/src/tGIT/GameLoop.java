package tGIT;



import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JFrame;


@SuppressWarnings("serial")
public class GameLoop extends JFrame implements Runnable,KeyListener{
	
	boolean entrar;
	Thread threadPrin;
	
	private int direccion;    // Direccion del elefante
	private int vidas;    // vidas del elefante
	private int score;   // el puntaje de usuario.
	private final int MIN = -5;    //Limite minimo al generar el numero random. 
	private final int MAX = 6;    //Limite maximo al generar el numero random.
	private static final int WIDTH = 1000;    //Ancho del JFrame
	private static final int HEIGHT = 600;    //Alto del JFrame
	private Image dbImage;	// Imagen a proyectar
	private Image gameover;	// Imagen al finalizar el juego.
	private Graphics dbg;	// Objeto grafico   //Arreglo del archivo divido.
	private long tiempoActual;	//Tiempo de control de la animación
    private Ship nave1;
	private Animacion animaNave;  

	
	
public GameLoop(){
		this.setTitle("Crazy Defender");
		this.setBounds(200,200,WIDTH,HEIGHT);
		this.setResizable(false);
		

		score = 0;
		vidas = 10;    // Le asignamos un valor inicial al vidas
		direccion = 2;    // Direccion hacia la derecha
		int posX = (int) (Math.random() *(WIDTH / 4));    // posicion en x es un cuarto del JFrame
		int posY = (int) (Math.random() *(HEIGHT / 4));    // posicion en y es un cuarto del JFrame
		
		this.addKeyListener(this);
		Image img_nave = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/tGIT/nave.png"));
		
		animaNave = new Animacion();
		animaNave.sumaCuadro(img_nave, 100);
		
		nave1 = new Ship(posY, posY, img_nave);
		threadPrin = new Thread(this);
		threadPrin.start();
		
		
		
	}
	
	public void run() {
		System.out.println("Started");
		entrar=true;
		
		while(entrar){
			update();
			repaint();
			try {Thread.sleep(20);} 
			catch (InterruptedException e) {e.printStackTrace();}
			}
		
		System.exit(0);
		
	}
	
	
	public void endGame(){
		entrar=false;
	}
	
	private void update(){
		//Determina el tiempo que ha transcurrido desde que el JFrame inicio su ejecución
        long tiempoTranscurrido = System.currentTimeMillis() - tiempoActual;
           
        //Guarda el tiempo actual
      	 tiempoActual += tiempoTranscurrido;
      	 
      	 //Actualiza la animación del elefante en base al tiempo transcurrido
      	 animaNave.actualiza(tiempoTranscurrido);
		
		//Actualiza la animación del ratón en base al tiempo transcurrido
        //animRaton.actualiza(tiempoTranscurrido);
		
		score += 5;  // el score se acumula en 5
		switch(direccion){
			case 1: { //se mueve hacia arriba con la flecha arriba.
				nave1.setPosY(nave1.getPosY() - (11 - vidas) * 2);
				break;    	
			}     
			case 2: { //se mueve hacia abajo con la flecha abajo.
				nave1.setPosY(nave1.getPosY() + (11 - vidas) * 2);
				break;    	
			} 
			case 3: { //se mueve hacia izquierda con la flecha izquierda.
				nave1.setPosX(nave1.getPosX() - (11 - vidas) * 2);
				break;    	
			}    
			case 4: { //se mueve hacia derecha con la flecha derecha.
				nave1.setPosX(nave1.getPosX() + (11 - vidas) * 2);
				break;    	
			}	
			case 5: { //se mueve hacia derecha con la flecha derecha.
				nave1.setPosX(nave1.getPosX());
				nave1.setPosY(nave1.getPosY());
				break;    	
			}		
		}
	
		
		
	}
	
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {    //Presiono flecha arriba
			direccion = 1;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {    //Presiono flecha abajo
			direccion = 2;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {    //Presiono flecha izquierda
			direccion = 3;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {    //Presiono flecha derecha
			direccion = 4;
		}
	}
    
    /**
	 * Metodo <I>keyTyped</I> sobrescrito de la interface <code>KeyListener</code>.<P>
	 * En este metodo maneja el evento que se genera al presionar una tecla que no es de accion.
	 * @param e es el <code>evento</code> que se genera en al presionar las teclas.
	 */
    public void keyTyped(KeyEvent e){
    	
    }
    
    /**
	 * Metodo <I>keyReleased</I> sobrescrito de la interface <code>KeyListener</code>.<P>
	 * En este metodo maneja el evento que se genera al soltar la tecla presionada.
	 * @param e es el <code>evento</code> que se genera en al soltar las teclas.
	 */
    public void keyReleased(KeyEvent e){
    	if (e.getKeyCode() == KeyEvent.VK_UP) {    //Presiono flecha arriba
			direccion = 2;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {    //Presiono flecha abajo
			direccion = 2;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {    //Presiono flecha izquierda
			direccion = 2;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {    //Presiono flecha derecha
			direccion = 2;
		}
    	
    }
	
public void paint (Graphics g){
		// Inicializan el DoubleBuffer
		if (dbImage == null) {
			dbImage = createImage(this.getSize().width, this.getSize().height);
			dbg = dbImage.getGraphics ();
			}
	// Actualiza la imagen de fondo.
	dbg.setColor(getBackground ());
    dbg.fillRect(0, 0, this.getSize().width, this.getSize().height);
	// Actualiza el Foreground.
	dbg.setColor(getForeground());
	paint1(dbg);
	// Dibuja la imagen actualizada
    g.drawImage(dbImage, 0, 0, this);
		
		
	}
	
	
	public void paint1 (Graphics g){
    	if (vidas>0) {
    		g.setColor(Color.yellow);
    		g.fillRect(0, 0, WIDTH, HEIGHT);
    		if (nave1!=null) {
    			
	    				g.drawImage(animaNave.getImagen(), nave1.getPosX(),nave1.getPosY(), this);
	    				//g.drawImage(animRaton.getImagen(), raton[i].getPosX(),raton[i].getPosY(), this);
	    				g.setColor(Color.black);
	    				g.setFont(new Font("Serif", Font.BOLD, 18));
	    				g.drawString("| " + vidas + " | "  + score + " |", 50, 50);
    			}
    		}
    	else {
    			//Da un mensaje mientras se carga el dibujo	
    			g.drawString("No se cargo la imagen..",20,20);
 
    	}

    }
	
	public static void main(String arg[]){
		
	
		GameLoop game = new GameLoop();
    	game.setSize(WIDTH, HEIGHT);
    	game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	game.setVisible(true);
	}

	
	

	


	
	

}
