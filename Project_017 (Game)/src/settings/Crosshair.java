package settings;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Crosshair {

	public enum CrosshairType{DEFAULT, STATIC, CLASSIC, CUSTOM}

	int thickness = 2;
	int length = 10;
	int gap = 6;
	int red = 220;
	int green = 230;
	int blue = 255;
	int alpha = 240;
	boolean t_style = false;
	boolean centre_dot = false;
    public int x = length + gap;
    public int y = length + gap;
    
	public BufferedImage getImage() {
		BufferedImage bufferedImage = new BufferedImage(2 * x, 2 * y, BufferedImage.TYPE_INT_ARGB); 
	    Graphics g = bufferedImage.getGraphics();
	    
		g.setColor(new Color(red, green, blue));
		
		g.fillRect(0, y - thickness/2, length, thickness);
		g.fillRect(x + gap, y - thickness/2, length, thickness);
		g.fillRect(x - thickness/2, y + gap, thickness, length);
		if(!t_style) {
			g.fillRect(x - thickness/2, 0, thickness, length);
		}
		if(centre_dot) {
			g.fillOval(x - thickness/2, y - thickness/2, thickness, thickness);
		}
		
	    g.dispose();
		return bufferedImage;
	}
}
