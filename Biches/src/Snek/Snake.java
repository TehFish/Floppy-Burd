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
	Timer tm = new Timer(200, this);
	public static ArrayList<Rectangle> body = new ArrayList<Rectangle>();
	int velX = 0, velY = 20;
	char direction = 'd';
	public Head h = new Head();
	public Food f = new Food();
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.GREEN);
		g.fillRect(h.x, h.y, h.width, h.height);
		g.setColor(Color.RED);
		g.fillRect(f.x, f.y, f.width, f.height);
		g.setColor(Color.GREEN);
		for (Rectangle i : body){
			if (f.food.intersects(h.head)){
				Snake.body.add(new Rectangle(h.x, h.y, h.width, h.height));
				g.fillRect(i.x - 10 * body.size(), i.y, i.width, i.height);
				g.clearRect(f.food.x, f.food.y, f.food.width, f.food.height);
			}
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
		if (c == KeyEvent.VK_UP){
			velY = -20;
			velX = 0;
		}
		if (c == KeyEvent.VK_DOWN){
			velY = 20;
			velX = 0;
		}
		if (c == KeyEvent.VK_LEFT){
			velY = 0;
			velX = -20;
		}
		if (c == KeyEvent.VK_RIGHT){
			velY = 0;
			velX = 20;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (h.x < 0){
			h.x = 0;
			repaint();
		}
		if (h.x > 790){
			h.x = 790;
			repaint();
		}
		if (h.y < 0){
			h.y = 0;
			repaint();
		}
		if (h.y > 700){
			h.y = 700;
			repaint();
		}
		h.x += velX;
		h.y += velY;
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
