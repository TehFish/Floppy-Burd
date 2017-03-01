package Snek;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Snake extends JPanel implements ActionListener, KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static JFrame jf = new JFrame();
	Timer tm = new Timer(100, this);
	public static ArrayList<Rectangle> body = new ArrayList<Rectangle>();
	int velX = 0, velY = 10;
	public static char direction = 'd';
	public Head h = new Head();
	public Food f = new Food();

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.GREEN);
		g.fillRect(h.head.x, h.head.y, h.head.width, h.head.height);
		g.setColor(Color.RED);
		g.fillRect(f.food.x, f.food.y, f.food.width, f.food.height);
		g.setColor(Color.GREEN);
		body.add(new Rectangle(h.head.x, h.head.y, h.head.width, h.head.height));
		if (!h.head.intersects(f.food)){
			body.remove(0);
		}
		if (h.head.intersects(f.food)){
			f.food.x = Food.r.nextInt(700);
			f.food.y = Food.r.nextInt(600);
			f.food.x = f.food.x / 20 * 20;
			f.food.y = f.food.y / 20 * 20;
		}	
		for (Rectangle j : body){
			g.fillRect(j.x, j. y, j.width, j.height);
		}	
	}

	public Snake(){
		tm.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		if (c == KeyEvent.VK_UP && direction != 'd'){
			velY = -10;
			velX = 0;
			direction = 'u';
		}
		else if (c == KeyEvent.VK_DOWN && direction != 'u'){
			velY = 10;
			velX = 0;
			direction = 'd';
		}
		else if (c == KeyEvent.VK_LEFT && direction != 'r'){
			velY = 0;
			velX = -10;
			direction = 'l';
		}
		else if (c == KeyEvent.VK_RIGHT && direction != 'l'){
			velY = 0;
			velX = 10;
			direction = 'r';
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (h.head.x < 0){
			h.head.x = 0;
			repaint();
		}
		if (h.head.x > 790){
			h.head.x = 790;
			repaint();
		}
		if (h.head.y < 0){
			h.head.y = 0;
			repaint();
		}
		if (h.head.y > 700){
			h.head.y = 700;
			repaint();
		}
		h.head.x += velX;
		h.head.y += velY;
		repaint();
	}
	public static void main(String[] args) {
		Snake s = new Snake();
		jf.setSize(800, 700);
		jf.setTitle("Snek");
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(s);
		jf.validate();
	}
}
