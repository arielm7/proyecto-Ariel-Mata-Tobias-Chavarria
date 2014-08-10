package tGIT;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotion implements MouseMotionListener {
	
	GameLoop game;
	
	MouseMotion(GameLoop passgame){
		this.game= passgame;
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent event) {
		game.changePos(event.getX(),event.getY());
		
	}

}
