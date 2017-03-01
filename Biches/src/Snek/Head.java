package Snek;

import java.awt.Rectangle;

public class Head {
	public Rectangle head;
	public int x;
	public int y;
	public int width;
	public int height;

	public Head(){
		this.x = 0;
		this.y = 0;
		this.width = 10;
		this.height = 10;
		this.head = new Rectangle(this.x, this.y, this.width, this.height);
	}
	public Head(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
}

