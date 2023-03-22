package salle2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class CustomizedButton extends JButton{
	Color background=new Color(197,157,98);
	
	public CustomizedButton(String str) {
		super(str);
		setContentAreaFilled(false);
		setBackground(background);
	}
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2=(Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(background);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 5, 5);
		g2.fillRoundRect(2, 2, getWidth()-4, getHeight()-4, 5, 5);
		super.paintComponent(g);
	}
	public void setColor(Color color) {
		background=color;
		setBackground(color);
	}
	
}
