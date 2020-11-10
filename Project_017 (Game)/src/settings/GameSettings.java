package settings;

import java.io.Serializable;

public class GameSettings implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5681163487694747448L;
	
	public enum DisplayMode{WINDOWED, FULLSCREEN, BORDERLESS}
	public enum CrosshairType{DEFAULT, STATIC, CLASSIC, CUSTOM}
	public enum ShowInfo{OFF, FRAMERATE, FRAMERATE_PING, FULL}
	
	public int width;
	public int height;
	public DisplayMode displaymode;
	public CrosshairType crosshairtype;
	public ShowInfo showinfo;
	public CustomCrosshair crosshair;
	public KeyBindings keybinds;
	
	public void load() {
		try {
			
			
			
		}catch(Exception e) {}
	}
}
