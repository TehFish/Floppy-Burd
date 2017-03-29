package EndlessRunner;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.*;

public class OftzikMcOftzikFace extends JPanel implements ActionListener, KeyListener{

	private static final long serialVersionUID = 1L;
	public static JFrame jf = new JFrame();
	public Timer tm = new Timer(5, this);
	public Timer scoreTm = new Timer(1000,new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			score++;
			dist -= 5;
		}
	} );
	public static int carVel = 2, pX = 200, score = 0, dist = 500, check;
	public static Rectangle player = new Rectangle(203, 500, 45, 50); 
	public static Rectangle car1 = new Rectangle(203, 800, 45, 50); 
	public static Rectangle car2 = new Rectangle(253, 800, 45, 50); 
	public static Rectangle car3 = new Rectangle(303, 400, 45, 50); 
	public static Rectangle car4 = new Rectangle(353, 400, 45, 50); 
	public static Rectangle point = new Rectangle(220, 0, 10, 10);
	public static Random r = new Random();

	public OftzikMcOftzikFace(){
		tm.start();
		scoreTm.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillRect(player.x, player.y, player.width, player.height);
		g.setColor(Color.BLACK);
		g.drawLine(200, 0, 200, 800);
		g.drawLine(250, 0, 250, 800);
		g.drawLine(300, 0, 300, 800);
		g.drawLine(350, 0, 350, 800);
		g.drawLine(400, 0, 400, 800);
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 200, 800);
		g.fillRect(401, 0, 200, 800);
		g.setColor(Color.RED);
		g.fillRect(car1.x, car1.y, car1.width, car1.height);
		g.fillRect(car2.x, car2.y, car2.width, car2.height);
		g.fillRect(car3.x, car3.y, car3.width, car3.height);
		g.fillRect(car4.x, car4.y, car4.width, car4.height);
		g.setColor(Color.ORANGE);
		g.fillRect(point.x, point.y, point.width, point.height);
		if (point.intersects(player))
			createPoint();
		g.setColor(Color.BLACK);
		g.drawString("Score: "+score, 10, 10);
		if (car1.intersects(player) || car2.intersects(player) || car3.intersects(player) || car4.intersects(player)){
			exit(tm, scoreTm);
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

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int c = e.getKeyCode();
		if (c == KeyEvent.VK_LEFT)
			player.x -= 50;
		if (c == KeyEvent.VK_RIGHT)
			player.x += 50;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (player.x > 350){
			player.x = 353;
			repaint();
		}
		if (player.x < 200){
			player.x = 203;
			repaint();
		}
		car1.y += carVel;
		car2.y += carVel;
		car3.y += carVel;
		car4.y += carVel;
		point.y += 1;
		repaint();
		if (dist < 200){
			dist = 500;
			carVel++;
		}
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
	public static void exit(Timer tm, Timer scoreTm){
		tm.stop();
		scoreTm.stop();
		try {
			Thread.sleep(3000);
			player.x = 203;
			car1.y = 800;
			car2.y = 800;
			car3.y = 400;
			car4.y = 400;
			score = 0;
			tm.start();
			scoreTm.start();
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
