package Snek;
import java.util.*;
import java.awt.Rectangle;

public class Food {
	public Rectangle food;
	public int x;
	public int y;
	public int width;
	public int height;
	public static Random r = new Random();
	
	public Food(){
		this.x = 0;
		this.y = 0;
		this.width = 10;
		this.height = 10;
		this.food = new Rectangle(this.x, this.y, this.width, this.height);
		this.x = this.x / 20 * 20;
		this.y = this.y / 20 * 20;
	}
}
