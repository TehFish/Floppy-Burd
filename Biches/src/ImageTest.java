import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageTest extends JPanel{

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		ImageIcon img = new ImageIcon("//Users//galbalaban//Desktop//JavaFiles//car.png");
		img.paintIcon(this, g, 100, 100);
	}
	
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		ImageTest i = new ImageTest();
		jf.setSize(500, 500);
		jf.setVisible(true);
		jf.setTitle("idk");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(i);
		jf.validate();

	}

}
