package game.entity;

import java.awt.Color;
import java.awt.Graphics2D;

import game.world.World;

public class Player extends Entity{

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
		
	}
}
