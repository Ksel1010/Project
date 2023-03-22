package salle2;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class ButtonPlat extends JButton{
	private Plat plat;
	
	public ButtonPlat(Plat pl) {
		super(pl.getDescription());
		plat=pl;
		this.setToolTipText(this.getText());
		
	}
	
	public String getType() {
		return plat.getClass().getSimpleName();
	}
	public Plat getPlat() {
		return plat;
	}
}
