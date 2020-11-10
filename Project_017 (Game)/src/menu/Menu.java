package menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import game.Game;
import main.InputHandler;
import main.Window;
import settings.GameSettings;
import state.Screen;
import state.State;
import store.Store;

public class Menu implements Screen{
	
	private Window window;
	private GameSettings gs;
	
	public Menu(Window window) {
		this.window = window;
		(gs = new GameSettings()).load();
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Store.ss.width, Store.ss.height);
		
		g.setFont(new Font("Calibri", Font.BOLD, 72)); 
		g.setColor(Color.WHITE);
		g.drawString("PRESS SPACEBAR TO START", 550, 800);
	}

	@Override
	public void key(InputHandler in) {
		if(in.key[KeyEvent.VK_F1]) {
			System.exit(0);
		}
		if(in.key[KeyEvent.VK_SPACE]) {
			GameStart();
		}
	}
	
	public void GameStart() {
		window.addScreen(State.GAME, new Game(gs, window));
		window.setScreen(State.GAME);
	}
}
