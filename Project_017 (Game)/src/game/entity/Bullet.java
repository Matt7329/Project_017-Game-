package game.entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import game.world.World;

public class Bullet extends Entity{

	private double dx;
	private double dy;
	private double angle;
	int t = 0;
	
	public Bullet(World world, double angle) {
		super(world);
		this.angle = angle;
		dx = Math.cos(angle);
		dy = Math.sin(angle);
	}

	public void draw(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.rotate(angle, getScreenX(), getScreenY());
		g.fillRect(getScreenX(), getScreenY(), width, height);
		g.rotate(-angle, getScreenX(), getScreenY());
	}
	
	public void update() {
		t++;
		x += speed * dx;
		y += speed * dy;
		
		for(Entity e : new ArrayList<Entity>(world.getEntities())) {
			if(e.getClass() != Player.class && e.getClass() != Bullet.class) {
				double xDif = y - e.getCY();
				double yDif = x - e.getCX();
				double distanceSquared = xDif * xDif + yDif * yDif;
				if(distanceSquared < (width/2 + e.width) * (width/2 + e.width)) {
					world.destroy(e);
					world.destroy(this);
				}
			}
		}
		
		if(t > 30)
			world.destroy(this);
	}
}
