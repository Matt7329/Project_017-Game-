package main;

import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import menu.Menu;
import state.Screen;
import state.State;

public class Window {

	public JFrame f;
	public InputHandler in;
	public TimeHandler th;
	public GraphicsHandler gh;
	
    Map<State, Screen> screens = new HashMap<>();
    Screen screen;
    
	public Window() {
		f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    f.setLocationRelativeTo(null);
	    f.setUndecorated(true);
	    f.setVisible(true);
	    f.createBufferStrategy(3);
	    
	    addScreen(State.MENU, new Menu(this));
		setScreen(State.MENU);
		
	    in = new InputHandler(this);
	    f.addMouseListener(in);
	    f.addMouseMotionListener(in);
	    f.addKeyListener(in);
	    f.addMouseWheelListener(in);
	    (gh = new GraphicsHandler(this, f.getBufferStrategy())).start();
	    (th = new TimeHandler(this, 64)).start();
	}
	
	public void tick() {
        screen.update();
	}
	
	public void render(Graphics2D g) {
        screen.draw(g);
	}
	
	public void key() {
		screen.key(in);
	}

	public void addScreen(State state, Screen screen){
        screens.put(state, screen);
    }
	public void setScreen(State state){
		screen = screens.get(state);
    }
	
	public static void main(String[] args) {
		new Window();
	}

}
