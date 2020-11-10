package state;

import java.awt.Graphics2D;

import main.InputHandler;

public interface Screen {
	void update();
    void draw(Graphics2D g);
    void key(InputHandler in);
}
