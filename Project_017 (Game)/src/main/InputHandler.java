package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class InputHandler implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {
	
	private Window main;
	
	public boolean[] key = new boolean[65565];
	public int mousex = 0;
	public int mousey = 0;
	public boolean mousepressed = false;
	
	public InputHandler(Window main) {
		this.main = main;
	}
	public void mouseClicked(MouseEvent e) {
		mousex = e.getX();
		mousey = e.getY();
	}
	public void mousePressed(MouseEvent e) {
		mousex = e.getX();
		mousey = e.getY();
		mousepressed = true;
	}
	public void mouseReleased(MouseEvent e) {
		mousex = e.getX();
		mousey = e.getY();
		mousepressed = false;
	}
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode > 0 && keyCode < key.length) {
			key[keyCode] = true;
		}
	}
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode > 0 && keyCode < key.length) {
			key[keyCode] = false;
		}
	}
	public void keyTyped(KeyEvent e) {}
	public void mouseDragged(MouseEvent e) {
		mousex = e.getX();
		mousey = e.getY();
	}
	public void mouseMoved(MouseEvent e) {
		mousex = e.getX();
		mousey = e.getY();	
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseWheelMoved(MouseWheelEvent e) {
		float increment = e.getWheelRotation();	
	}
}
