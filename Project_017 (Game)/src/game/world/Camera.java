package game.world;

import java.awt.Rectangle;

import game.entity.Entity;

public class Camera {

	public float speed = 5;
	public float x = 0;
	public float y = 0;
	
	public int cam_offset_x;
	public int cam_offset_y;
	
	public int cull_x_max;
	public int cull_x_min;
	public int cull_y_max;
	public int cull_y_min;
	
	World world;
	Entity entity;
	
	public Camera(World world) {
		this.world = world;
		cam_offset_x  = -world.game.window.getWidth()/2;
		cam_offset_y  = -world.game.window.getHeight()/2;
		cull_x_max = world.game.window.getWidth();
		cull_x_min = 0;
		cull_y_max = world.game.window.getHeight();
		cull_y_min = 0;
	}

	public void move(int dx, int dy) {
		if(entity != null) {
			entity.requestMove(dx, dy);
		}
		x += dx;
		y += dy;
	}
	
	public void update() {
		if(entity != null) {
			x = entity.getX();
			y = entity.getY();
		}
	}
	
	public void attachTo(Entity entity) {
		this.entity = entity;
		if(entity != null) {
			x = entity.getX();
			y = entity.getY();
			speed = entity.getSpeed();
		}
	}
	
	public boolean Cull (int x_screen, int y_screen, int width, int height) {
		return x_screen > cull_x_max || 
				x_screen+width < cull_x_min || 
				y_screen > cull_y_max || 
				y_screen+height < cull_y_min;
	}

	public Rectangle getCullBounds() {
		return new Rectangle(cull_x_min, cull_y_min, cull_x_max - cull_x_min, cull_y_max - cull_x_min);
	}

}
