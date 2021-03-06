package Polymorphism;

import java.awt.Color;
import java.awt.Graphics;

public class Polymorph {
    private int x;
    private int y;
    private int width;
    private int height;
    
    Polymorph(int x, int y, int width, int height){
   	 this.setX(x);
   	 this.setY(y);
   	 this.setWidth(width);
   	 this.setHeight(height);
    }
    
    public void update(){
    	
    }
    
    public void draw(Graphics g){
   	 g.setColor(Color.BLUE);
   	 g.fillRect(getX(), getY(), width, height);
    }

	int getX() {
		return x;
	}

	void setX(int x) {
		this.x = x;
	}

	int getY() {
		return y;
	}

	void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
