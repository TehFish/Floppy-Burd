package Snek;

import java.awt.Point;
import java.awt.Rectangle;

public class Head {
	public Point head;
	public int x;
	public int y;

	public Head(){
		this.x = 0;
		this.y = 0;
		this.head = new Point(this.x, this.y);
	}
	public Head(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
	}
}

