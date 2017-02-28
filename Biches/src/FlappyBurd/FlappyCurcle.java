package FlappyBurd;
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

public class FlappyCurcle extends JPanel implements ActionListener, KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static Rectangle block = new Rectangle(300, 250, 20, 20);
	public static Rectangle rec = new Rectangle(0, 0, 25, 0);
	public static JFrame jf = new JFrame();
	Timer tm = new Timer(15, this);
	public static int recVelX = 10, pointCounter = 0, blockVelY = 0, highScore = 0;
	static Random r = new Random();
	static boolean check = r.nextBoolean(), exit = false;

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillRect(block.x, block.y, block.width, block.height);
		g.setColor(Color.RED);
		g.fillRect(rec.x, rec.y, rec.width, rec.height);
		g.drawString("Score: "+pointCounter, 10, 10);
		if (rec.intersects(block))
			exit(g, tm);
	}
	public FlappyCurcle(){
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
		if (c == KeyEvent.VK_UP)
			blockVelY = -9;
		if (c == KeyEvent.VK_DOWN)
			blockVelY = 9;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		blockVelY = 0;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (block.y < 0){
			block.y = 0;
			repaint();
		}
		if (block.y > 460){
			block.y = 460;
			repaint();
		}
		block.y += blockVelY;
		repaint();

		if (rec.x == 250)
			pointCounter++;
		if (rec.x < 0){
			rec.x = 970;
			if (pointCounter % 10 == 0)
				recVelX++;
			rec.height = r.nextInt(200) + 250;
			if (check){
				rec.y = 0;
				check = r.nextBoolean();
			}
			else{
				rec.y = 500 - rec.height;
				check = r.nextBoolean();
			}

			repaint();
		}

		rec.x -= recVelX;
		repaint();
	}
	public static void exit(Graphics g, Timer tm){
		tm.stop();
		try {
			Thread.sleep(3000);
			rec.x = 970;
			pointCounter = 0;
			recVelX = 10;
			tm.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		FlappyCurcle p = new FlappyCurcle();
		jf.setSize(1000, 500);
		jf.setTitle("Flappy Sqoure");
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(p);
		jf.validate();
	}
}
