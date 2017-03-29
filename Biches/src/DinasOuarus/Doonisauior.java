package DinasOuarus;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Doonisauior extends JPanel implements ActionListener, KeyListener {
	private static final long serialVersionUID = 1L;
	public static JFrame jf = new JFrame();
	public Timer tm = new Timer(5, this);
	public Timer scoring = new Timer (70, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			score++;
		}
	});
	public Random r = new Random();
	public Timer scoreTm = new Timer(5, this);
	public static Rectangle c1 = new Rectangle(800, 520, 40, 60);
	public static Rectangle player = new Rectangle(200, 540, 20, 40);
	public static int playerVelY = 0, cactusVel = 2, temp = 0, score = 0;

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(player.x, player.y, player.width, player.height);
		g.setColor(Color.GREEN);
		g.fillRect(c1.x, c1.y, c1.width, c1.height);
		g.setColor(Color.BLACK);
		g.drawString("Score: "+score, 10, 10);
		if (player.intersects(c1))
			exit(tm, scoring);
	}

	public Doonisauior(){
		tm.start();
		scoring.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}

	public static void main(String[] args) {
		Doonisauior e = new Doonisauior();
		jf.setSize(800, 600);
		jf.setTitle("Dinsuarsiour");
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(e);
		jf.validate();
	}

	@Override
	public void keyTyped(KeyEvent e) {


	}

	@Override
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		if (c == KeyEvent.VK_UP && player.y == 540)
			playerVelY = 4;
		if (c == KeyEvent.VK_DOWN && player.y == 540)
			player.y = 560;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		playerVelY = 0;
		if (player.y == 560)
			player.y = 540;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		player.y += 2 - playerVelY;
		c1.x -= cactusVel;
		repaint();
		if (player.y > 540){
			if (player.y > 560)
				player.y = 560;
			else
				player.y = 540;
			repaint();
		}
		if (c1.x < 0){
			c1.x = 800;
			if (r.nextBoolean()){
				c1.height = 20;
				if (r.nextBoolean()){
					c1.y = 530;
					c1.width = 25;
				}
				else{
					c1.y = 550;
					c1.width = 25;
				}
			}
			else{
				if (r.nextBoolean()){
					c1.y = 500;
					c1.height = 80;
				}
				else{
					c1.y = 520;
					c1.height = 60;
				}
				if (r.nextBoolean())
					c1.width = 55;
				else
					c1.width = 40;
				repaint();
			}
			if (player.y < 350)
				playerVelY = 0;
		}
	}
	public static void exit(Timer tm, Timer scoreTm){
		tm.stop();
		scoreTm.stop();
		try {
			Thread.sleep(3000);
			player.y = 540;
			c1.x = 800;
			score = 0;
			tm.start();
			scoreTm.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
