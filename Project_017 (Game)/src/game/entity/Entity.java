package game.entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import game.world.World;

public class Entity {

	float x = 0;
	float y = 0;
	float speed = 5;
	
	public int hp = 2000;
	int maxhp = hp;
	int width = 0;
	int height = 0;

	boolean visible = true;
	boolean hasUpdate = true;
	boolean hasDraw = true;
	
	protected World world;
	
	public Entity(World world) {
		this.world = world;
	}
	
	public void setLocation(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void setSize(int width, int height) {	
		this.width = width;
		this.height = height;
	}
	
	public void draw(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillOval(getScreenX(), getScreenY(), width, height);
	}
	
	public void update() {

	}

	public void requestMove(float dx, float dy) {
		x += dx;
		y += dy;
	}
	
	public int getScreenX() {
		return world.getScreenX(x);
	}
	
	public int getScreenY() {
		return world.getScreenY(y);
	}

	public int getScreenCX() {
		return world.getScreenX(x) + width / 2;
	}
	
	public int getScreenCY() {
		return world.getScreenY(y) + height / 2;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public float getCX() {
		return x + width / 2;
	}
	
	public float getCY() {
		return y + height / 2;
	}
	
	public boolean isVisible() {
		return visible;
	}
	
	public boolean hasUpdate() {
		return hasUpdate;
	}
	
	public boolean hasDraw() {
		return hasDraw;
	}

	public float getSpeed() {
		return speed;
	}

	public boolean Cull(Rectangle bounds) {
		int x = getScreenX();
		int y = getScreenY();
		return x > bounds.getMaxX() || x + width < bounds.getMinX() || y > bounds.getMaxY() || y + height < bounds.getMinY();
	}
}
