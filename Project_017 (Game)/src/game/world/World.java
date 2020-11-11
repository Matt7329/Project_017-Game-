package game.world;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import game.Game;
import game.entity.Entity;
import game.entity.Player;
import game.entity.Robot;

public class World {

	ArrayList<Entity> entities = new ArrayList<>();
	Player player;
	Camera camera;
	
	public Game game;
	
	public World(Game game) {
		this.game = game;
		camera = new Camera(this);
		player = new Player(this);
		player.setLocation(0, 0);
		player.setSize(30, 30);
		entities.add(player);
		
		for(int i = 0; i < 1000; i++) {
			Robot e = new Robot(this);
			int x = (int)(Math.random() * 10000 - 5000);
			int y = (int)(Math.random() * 10000 - 5000);
			e.setLocation(x, y);
			e.setSize(30, 30);
			e.setTarget(player);
			entities.add(e);
		}
		
		camera.attachTo(player);
	}
	
	public void draw(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, game.window.getWidth(), game.window.getHeight());
		
		for(Entity e : new ArrayList<Entity>(entities)) {
			if(e.hasDraw() && !e.Cull(camera.getCullBounds()))
				e.draw(g);
		}
	}
	
	public void update() {
		for(Entity e : new ArrayList<Entity>(entities)) {
			if(e.hasUpdate())
				e.update();
		}
		camera.update();
	}
	
	public ArrayList<Entity> getEntities(){
		return entities;
	}
	
	public Player getPlayer() {
		return player;
	}

	public Camera getCamera() {
		return camera;
	}
	
	public int getScreenX(float x) {
		return (int) (x - camera.cam_offset_x - camera.x);
	}
	public int getScreenY(float y) {
		return (int) (y - camera.cam_offset_y - camera.y);
	}
	public float getWorldX(int x) {
		return camera.x - x + camera.cam_offset_x;
	}
	public float getWorldY(int y) {
		return camera.y - y + camera.cam_offset_y;
	}
}
