package Snek;
import java.util.*;
import java.awt.Point;
import java.awt.Rectangle;

public class Food {
	public Point food;
	public int x;
	public int y;
	public static Random r = new Random();
	
	public Food(){
		this.x = r.nextInt(700);
		this.y = r.nextInt(600);
		this.food = new Point(this.x, this.y);
		this.x = this.x / 20 * 20;
		this.y = this.y / 20 * 20;
	}
}
