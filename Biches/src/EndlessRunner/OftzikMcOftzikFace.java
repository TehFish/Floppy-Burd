package EndlessRunner;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class OftzikMcOftzikFace extends JPanel implements ActionListener, KeyListener{

	private static final long serialVersionUID = 1L;
	public static JFrame jf = new JFrame();
	public Timer tm = new Timer(5, this);
	public Timer scoreTm = new Timer(1000,new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			score++;
		}
	} );
	public Timer speed = new Timer(70, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			carVel += 0.001;
		}
	});
	public static int pX = 200, score = 0, dist = 500, check;
	public static double carVel = 2;
	public static Rectangle player = new Rectangle(211, 500, 28, 50); 
	public static Rectangle car1 = new Rectangle(203, 800, 45, 45); 
	public static Rectangle car2 = new Rectangle(253, 800, 45, 45); 
	public static Rectangle car3 = new Rectangle(303, 400, 45, 45); 
	public static Rectangle car4 = new Rectangle(353, 400, 45, 45); 
	public static Rectangle point = new Rectangle(220, 0, 10, 10);
	public static Random r = new Random();

	public OftzikMcOftzikFace(){
		tm.start();
		scoreTm.start();
		speed.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		ImageIcon img = new ImageIcon("//Users//galbalaban//Desktop//JavaFiles//car.png");
		ImageIcon playerImg = new ImageIcon("//Users//galbalaban//Desktop//JavaFiles//greencar.png");
		g2.setColor(Color.BLUE);
		playerImg.paintIcon(this, g2, player.x, player.y);
		g2.setColor(Color.BLACK);
		g2.drawLine(200, 0, 200, 800);
		g2.drawLine(250, 0, 250, 800);
		g2.drawLine(300, 0, 300, 800);
		g2.drawLine(350, 0, 350, 800);
		g2.drawLine(400, 0, 400, 800);
		g2.setColor(new Color(0, 150, 0));
		g2.fillRect(0, 0, 200, 800);
		g2.fillRect(401, 0, 200, 800);
		g2.setColor(Color.RED);
		img.paintIcon(this, g2, car1.x, car1.y);
		img.paintIcon(this, g2, car2.x, car2.y);
		img.paintIcon(this, g2, car3.x, car3.y);
		img.paintIcon(this, g2, car4.x, car4.y);
		
		/**
		g2.setColor(Color.YELLOW);
		g2.fillRect(car1.x + 30, car1.y + 40, 10, 10);
		g2.fillRect(car1.x + 5, car1.y + 40, 10, 10);
		g2.fillRect(car2.x + 30, car2.y + 40, 10, 10);
		g2.fillRect(car2.x + 5, car2.y + 40, 10, 10);
		g2.fillRect(car3.x + 30, car3.y + 40, 10, 10);
		g2.fillRect(car3.x + 5, car3.y + 40, 10, 10);
		g2.fillRect(car4.x + 30, car4.y + 40, 10, 10);
		g2.fillRect(car4.x + 5, car4.y + 40, 10, 10);
		g2.setColor(Color.DARK_GRAY);
		g2.fillRect(car1.x - 3, car1.y + 5, 7, 15);
		g2.fillRect(car1.x - 3, car1.y + 30, 7, 15);
		g2.fillRect(car1.x + 42, car1.y + 5, 7, 15);
		g2.fillRect(car1.x + 42, car1.y + 30, 7, 15);
		g2.fillRect(car2.x - 3, car2.y + 5, 7, 15);
		g2.fillRect(car2.x - 3, car2.y + 30, 7, 15);
		g2.fillRect(car2.x + 42, car2.y + 5, 7, 15);
		g2.fillRect(car2.x + 42, car2.y + 30, 7, 15);
		g2.fillRect(car3.x - 3, car3.y + 5, 7, 15);
		g2.fillRect(car3.x - 3, car3.y + 30, 7, 15);
		g2.fillRect(car3.x + 42, car3.y + 5, 7, 15);
		g2.fillRect(car3.x + 42, car3.y + 30, 7, 15);
		g2.fillRect(car4.x - 3, car4.y + 5, 7, 15);
		g2.fillRect(car4.x - 3, car4.y + 30, 7, 15);
		g2.fillRect(car4.x + 42, car4.y + 5, 7, 15);
		g2.fillRect(car4.x + 42, car4.y + 30, 7, 15);
		**/
		
		g2.setColor(Color.ORANGE);
		g2.fill(point);
		if (point.intersects(player))
			createPoint();
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("Ariel", Font.PLAIN, 30));
		g2.drawString("Score: "+score, 250, 100);
		if (car1.intersects(player) || car2.intersects(player) || car3.intersects(player) || car4.intersects(player)){
			exit(tm, scoreTm, speed);
		}
	}

	public static void main(String[] args) {
		OftzikMcOftzikFace e = new OftzikMcOftzikFace();
		jf.setSize(600, 800);
		jf.setTitle("EndLessShit");
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(e);
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		if (c == KeyEvent.VK_LEFT)
			player.x -= 50;
		if (c == KeyEvent.VK_RIGHT)
			player.x += 50;
	}

	@Override
	public void keyReleased(KeyEvent e) {
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (player.x > 350){
			player.x = 361;
			repaint();
		}
		if (player.x < 200){
			player.x = 211;
			repaint();
		}
		car1.y += carVel;
		car2.y += carVel;
		car3.y += carVel;
		car4.y += carVel;
		point.y += 1;
		repaint();

		if (car1.y > 800){
			car1.y = r.nextInt(dist) * -1;
			repaint();
		}
		if (car2.y > 800){
			car2.y = r.nextInt(dist) * -1;
			repaint();
		}
		if (car3.y > 800){
			car3.y = r.nextInt(dist) * -1;
			repaint();
		}
		if (car4.y > 800){
			car4.y = r.nextInt(dist) * -1;
			repaint();
		}
		if (point.y > 800){
			point.y = 0;
			repaint();
		}
	}
	public static void exit(Timer tm, Timer scoreTm, Timer speed){
		tm.stop();
		scoreTm.stop();
		speed.stop();
		try {
			Thread.sleep(3000);
			player.x = 211;
			carVel = 2;
			car1.y = 800;
			car2.y = 800;
			car3.y = 400;
			car4.y = 400;
			score = 0;
			tm.start();
			scoreTm.start();
			speed.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void createPoint(){
		point.y = 0;
		check = r.nextInt(3);
		if (check == 0)
			point.x = 220;
		else if (check == 1)
			point.x = 270;
		else if (check == 2)
			point.x = 320;
		else
			point.x = 370;
		score += 10;
	}
}
