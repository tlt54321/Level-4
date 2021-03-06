package Polymorphism;

import java.util.Random;

public class CircleMorph extends Polymorph{
	private int radius;
	private int counter;

	CircleMorph(int x, int y, int width, int height, int radius) {
		super(x, y, width, height);
		this.setRadius(radius);
	}
	
	public int getRadius() {
		return radius;
	}


	public void setRadius(int radius) {
		this.radius = radius;
	}



	@Override
	public void update(){
	    int x = getX();
	    int y = getY();
	    setX(x + (int)(radius * Math.cos(Math.toRadians(counter))));
	    setY(y + (int)(radius * Math.sin(Math.toRadians(counter))));
	    counter++;
	}
	
}
