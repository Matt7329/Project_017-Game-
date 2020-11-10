package main;

public class TimeHandler extends Thread{

	private Window main;
	public double tickrate = 60;
	public double time = 0;
	
	public TimeHandler(Window main, double tickrate) {
		this.main = main;
		this.tickrate = tickrate;
	}
	public void run(){
		double unprocessedSeconds = 0;
		long previousTime = System.nanoTime();
		while (true) {
			double secondsPerTick = 1.0 / tickrate;
			long currentTime = System.nanoTime();
			long passedTime = currentTime - previousTime;
			previousTime = currentTime;
			unprocessedSeconds += passedTime / 1000000000.0;
			while (unprocessedSeconds > secondsPerTick) {
				unprocessedSeconds -= secondsPerTick;
				time += secondsPerTick;
				main.tick();
				main.key();		
				if(time % 1 == 0) {
					main.gh.framerate = main.gh.repaints;
					main.gh.repaints = 0;
				}
			}
		}
	}
}
