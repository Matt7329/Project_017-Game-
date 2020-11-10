package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import main.InputHandler;
import main.Window;
import settings.GameSettings;
import state.Screen;
import store.Store;

public class Game implements Screen{
	
	private GameSettings gs;
	private Window window;
	
	public Game(GameSettings gs, Window window) {
		this.window = window;
		this.gs = gs;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, Store.ss.width, Store.ss.height);
		
		g.setColor(Color.GREEN);
		g.drawString(""+window.gh.framerate, 50, 100);
	}

	@Override
	public void key(InputHandler in) {
		if(in.key[KeyEvent.VK_F1]) {
			System.exit(0);
		}
	}
}
