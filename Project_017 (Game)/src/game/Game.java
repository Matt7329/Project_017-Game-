package game;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import game.entity.Player;
import game.world.Camera;
import game.world.World;
import main.InputHandler;
import main.Window;
import settings.Crosshair;
import settings.GameSettings;
import state.Screen;

public class Game implements Screen{
	
	public GameSettings gs;
	public Window window;	
	public World world;
	public Overlay overlay;
	
	public Game(GameSettings gs, Window window) {
		this.window = window;
		this.gs = gs;
		window.f.setCursor(window.f.getToolkit().createCustomCursor(gs.crosshair.getImage(), new Point(gs.crosshair.x, gs.crosshair.y), null));
		overlay = new Overlay(this);
		world = new World(this);
	}

	@Override
	public void update() {
		world.update();
		overlay.update();
	}

	@Override
	public void draw(Graphics2D g) {
		world.draw(g);
		overlay.draw(g);
	}

	@Override
	public void key(InputHandler in) {
		if(in.key[KeyEvent.VK_F1]) {
			System.exit(0);
		}	
		int dx = 0;
		int dy = 0;
		Player player = world.getPlayer();
		Camera camera = world.getCamera();
		if(in.key[KeyEvent.VK_W]) {
			dy -= camera.speed;
		}
		if(in.key[KeyEvent.VK_A]) {
			dx -= camera.speed;
		}
		if(in.key[KeyEvent.VK_S]) {
			dy += camera.speed;
		}
		if(in.key[KeyEvent.VK_D]) {
			dx += camera.speed;
		}
		camera.move(dx, dy);
		if(in.mousepressed) {
			player.attack(in.mousex, in.mousey);
		}
	}

	public Crosshair getCrosshair() {
		return gs.crosshair;
	}

	public int getMouseX() {
		return window.in.mousex;
	}
	
	public int getMouseY() {
		return window.in.mousey;
	}
}
