package salle2;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelBorder extends JPanel{
	private Color border=Color.black;
	public PanelBorder() {
		super();
		setBorder(BorderFactory.createLineBorder(border));
	}
	public void setBorderColor(Color cl) {
		border=cl;
		repaint();
	}
}
