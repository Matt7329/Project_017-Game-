package game;

import java.awt.Color;
import java.awt.Graphics2D;

public class Overlay {
	
	private Game game;
	public Overlay(Game game) {
		this.game = game;
	}

	public void draw(Graphics2D g) {
		g.setColor(Color.GREEN);
		g.drawString(""+game.window.gh.framerate, 50, 100);
		g.setColor(Color.WHITE);
		g.drawString("x: "+game.world.getPlayer().getX() + " y: " + game.world.getPlayer().getY(), 50, 150);
		g.drawString("cx: "+game.world.getCamera().x+ " cy: " + game.world.getCamera().y, 50, 170);
		g.drawString("hp: "+game.world.getPlayer().hp, 50, 190);
	}
	
	public void update() {

	}
}
