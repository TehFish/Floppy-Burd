import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Testing extends JPanel implements ActionListener, KeyListener{
	Timer tm = new Timer(5, this);
	static int x = 0, velX = 0, y = 0, velY = 0, counter;
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 50, 30);
	}
	public Testing(){
		tm.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Testing t = new Testing();
		JFrame frame = new JFrame();
		frame.setSize(640, 400);
		frame.setTitle("Ummmmm");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(t);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		y = y + velY;
		x = x + velX;
		repaint();
		if (x == 125)
			counter++;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int c = e.getKeyCode();
		if (c == KeyEvent.VK_UP){
			velX = 0;
			velY = -2;
		}
		if (c == KeyEvent.VK_DOWN){
			velX = 0;
			velY = 2;
		}
		if (c == KeyEvent.VK_LEFT){
			velX = -2;
			velY = 0;
		}
		if (c == KeyEvent.VK_RIGHT){
			velX = 2;
			velY = 0;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		velX = 0;
		velY = 0;
	}
	
}
