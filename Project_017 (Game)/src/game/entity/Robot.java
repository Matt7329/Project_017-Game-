package game.entity;

import game.world.World;

public class Robot extends Entity{

	Entity target;
	int range = 50;
	int damage = 2;
	
	public Robot(World world) {
		super(world);
	}

	public void setTarget(Entity target) {
		this.target = target;
	}
	
	public void update() {
		if(target != null) 
			chaseTarget(target);
	}

	private void chaseTarget(Entity target) {
		if(target == null) return;		
		double dx = target.x - x;
		double dy = target.y - y;
		if(Math.hypot(dx, dy) > range) {		
			double angle = Math.atan2(dy, dx);
			float vx = (float) (speed * Math.cos(angle));
			float vy = (float) (speed * Math.sin(angle));
			requestMove(vx, vy);
		}else {
			attack(target);
		}
	}

	private void attack(Entity target) {
		target.hp -= damage;
	}
}
