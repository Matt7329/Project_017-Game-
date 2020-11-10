package main;

import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

public class GraphicsHandler extends Thread{

	private Window main;
	private BufferStrategy bs;
	
	public int framerate = 0;
	public int repaints = 0;
	
	public enum Mode{REPAINT, LIMITED, UNLIMITED}
	public float max_framerate = 120;
	public Mode mode = Mode.LIMITED;
	
	public GraphicsHandler(Window main, BufferStrategy bs) {
		this.main = main;
		this.bs = bs;
	}
	
	public void run(){
		double unprocessedSeconds = 0;
		long previousTime = System.nanoTime();
		while (true) {
			switch(mode) {
			case REPAINT: 		
				break;
			case LIMITED: 
				double secondsPerTick = 1.0 / max_framerate;
				long currentTime = System.nanoTime();
				long passedTime = currentTime - previousTime;
				previousTime = currentTime;
				unprocessedSeconds += passedTime / 1000000000.0;
				while (unprocessedSeconds > secondsPerTick) {
					unprocessedSeconds -= secondsPerTick;
					repaint();
				}
				break;
			case UNLIMITED:
				repaint();
				break;
			default:
				throw new RuntimeException("Unknown state: " + mode);
			}
		}
	}
	public void repaint() {
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		main.render(g);
		
		if (g != null)
			g.dispose();

		bs.show();
		repaints++;
	}
}
