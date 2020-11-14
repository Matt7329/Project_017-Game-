package game.entity;

import java.awt.Color;
import java.awt.Graphics2D;

import game.world.World;

public class Player extends Entity{
	
	private boolean canattack = true;
	private int t = 0;
	
	public Player(World world) {
		super(world);
	}

	public void draw(Graphics2D g) {
		g.setColor(new Color(255, 0, 0, 60));
		g.drawLine(getScreenCX(), getScreenCY(), world.game.getMouseX(), world.game.getMouseY());
		
		g.setColor(Color.BLUE);
		g.fillOval(getScreenX(), getScreenY(), width, height);
	}
	
	public void update() {
		if(!canattack) {
			t++;
		}
		if(t > 4) {
			canattack = true;
		}
	}

	public void attack(int mousex, int mousey) {
		if(canattack) {
			double d = 1.0 / 8.0;
			double deviation = Math.random() * d - d/2;
			double dx = mousex - getScreenCX();
			double dy = mousey - getScreenCY();	
			double angle = Math.atan2(dy, dx) + deviation;
			
			Bullet b = new Bullet(world, angle);
			b.setLocation(getCX(), getCY());
			b.setSize(50, 1);
			b.speed = 50;
			world.add(b);
			t = 0;
			canattack = false;
		}
	}
}
