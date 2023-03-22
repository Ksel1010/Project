package salle2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Reception extends JPanel{
	private BufferedImage image;
	public Reception() throws IOException {
		super();
		image = ImageIO.read(new File("C:\\Users\\kaiss\\OneDrive\\Bureau\\JAVA2.0\\projet\\Swing1\\salle\\src\\salle2\\TOO_restaurant_Panoramique_vue_Paris_nuit_v2-scaled.jpg"));
		
	}
	//painting method not very impressive (best i could do though)
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image tmp = image.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
	    image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);

	    Graphics2D g2d = image.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
		g.drawImage(image, 0,0, null);
	}
	
}
