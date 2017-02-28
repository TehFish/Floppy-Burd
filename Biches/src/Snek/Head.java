package Snek;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Head {
	public Rectangle head;
	public Rectangle b;
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
	public void eatFood(Food f, Graphics g){
		if (f.food.intersects(this.head)){
			Snake.body.add(b = new Rectangle(head.x, head.y, head.width, head.height));
			g.drawRect(this.x - 10 * Snake.body.size(), this.y, this.width, this.height);
			g.clearRect(f.food.x, f.food.y, f.food.width, f.food.height);
		}
			
	}
}
