package Snek;

	import java.awt.Color;
	import java.awt.Graphics;
	import java.awt.Point;
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
		public static ArrayList<Point> body = new ArrayList<Point>();
		int velX = 0, velY = 10;
		public static char direction = 'd';
		public Head h = new Head();
		public Food f = new Food();

		@SuppressWarnings("deprecation")
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.setColor(Color.GREEN);
			g.fillRect(h.head.x, h.head.y, 10, 10);
			g.setColor(Color.RED);
			g.fillRect(f.food.x, f.food.y, 10, 10);
			g.setColor(Color.GREEN);
			switch (direction){
			case 'u':
				body.add(new Point(h.head.x, h.head.y + 5));
				break;
			case 'd':
				body.add(new Point(h.head.x, h.head.y - 5));
				break;
			case 'r':
				body.add(new Point(h.head.x - 5, h.head.y));
				break;
			case 'l':
				body.add(new Point(h.head.x + 5, h.head.y));
				break;
			}
			if (!h.head.equals(f.food)){
				body.remove(0);
			}
			if (h.head.equals(f.food)){
				f.food.x = Food.r.nextInt(700);
				f.food.y = Food.r.nextInt(600);
				f.food.x = f.food.x / 20 * 20;
				f.food.y = f.food.y / 20 * 20;
			}	
			for (Point j : body){
				g.fillRect(j.x, j. y, 10, 10);
					if (h.head.equals(j) && j != body.get(0)){
						System.out.println("HI");
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


