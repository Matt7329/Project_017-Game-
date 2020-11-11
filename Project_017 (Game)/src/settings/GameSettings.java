package settings;

import java.io.Serializable;

public class GameSettings implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5681163487694747448L;
	
	public enum DisplayMode{WINDOWED, FULLSCREEN, BORDERLESS}
	public enum ShowInfo{OFF, FRAMERATE, FRAMERATE_PING, FULL}
	
	public int width;
	public int height;
	public DisplayMode displaymode;
	public ShowInfo showinfo;
	public Crosshair crosshair = new Crosshair();
	public KeyBindings keybinds;
	
	public void load() {
		try {
			
			
			
		}catch(Exception e) {}
	}
}
