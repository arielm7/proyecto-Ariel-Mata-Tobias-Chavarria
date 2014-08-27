package tGIT;


import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;




public class Ship {
	
	private int posX;    //posicion en x.       
	private int posY;	//posicion en y.
	private ImageIcon icono;    //icono.
	
	/**
	 * Metodo constructor usado para crear el objeto
	 * @param posX es la <code>posicion en x</code> del objeto.
	 * @param posY es la <code>posicion en y</code> del objeto.
	 * @param image es la <code>imagen</code> del objeto.
	 */
	public Ship(int posX, int posY ,Image image) {
		this.posX=posX;
		this.posY=posY;
		icono = new ImageIcon(image);
	}
	
	/**
	 * Metodo modificador usado para cambiar la posicion en x del objeto 
	
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}
	
	/**
	 * Metodo de acceso que regresa la posicion en x del objeto 
	
	 */
	public int getPosX() {
		return posX;
	}
	
	/**
	 * Metodo modificador usado para cambiar la posicion en y del objeto 
	
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	/**
	 * Metodo de acceso que regresa la posicion en y del objeto 
	
	 */
	public int getPosY() {
		return posY;
	}
	
	/**
	 * Metodo modificador usado para cambiar el icono del objeto 
	 
	 */
	public void setImageIcon(ImageIcon icono) {
		this.icono = icono;
	}
	
	/**
	 * Metodo de acceso que regresa el icono del objeto 
	
	 */
	public ImageIcon getImageIcon() {
		return icono;
	}
	
	/**
	 * Metodo de acceso que regresa el ancho del icono 
	
	 */
	public int getAncho() {
		return icono.getIconWidth();
	}
	
	/**
	 * Metodo de acceso que regresa el alto del icono 
	
	 */
	public int getAlto() {
		return icono.getIconHeight();
	}
	
	/**
	 * Metodo de acceso que regresa la imagen del icono 
	
	 */
	public Image getImagenI() {
		return icono.getImage();
	}
	
	/**
	 * Metodo de acceso que regresa un nuevo rectangulo
	
	 */
	public Rectangle getPerimetro(){
		return new Rectangle(getPosX(),getPosY(),getAncho(),getAlto());
	}
	
	/**
	 * Revisa si el objeto Ship intersecta a otra ship
	 
	 */
	public boolean intersecta(Ship obj){
		return getPerimetro().intersects(obj.getPerimetro());
	}
	
}