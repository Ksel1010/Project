package salle2;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class LabelBorder extends JLabel{
	private Color border=Color.black;
	private Plat pl=null;
	public LabelBorder() {
		super();
		setUp();
	}
	public LabelBorder(String str) {
		super(str, SwingConstants.CENTER);
		setUp();
	}
	public LabelBorder(Plat pl) {
		super(Integer.toString(pl.getQty()), SwingConstants.CENTER);
		this.pl=pl;
		setUp();
	}
	private void setUp() {
		this.setBorder(BorderFactory.createLineBorder(border));
		this.setToolTipText(getText());
	}
	public void setBorderColor(Color cl) {
		border=cl;
		repaint();
	}
	public void refresh() {
		if (pl!=null) {
			setText(Integer.toString(pl.getQty()));
		}
	}
}
