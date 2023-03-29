package salle2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main {

	public static void main(String[] args) throws IOException {
		Frame salle=new Frame("menu.json");
		salle.setVisible(true);
	/*
		JFrame frame=new JFrame();
		JPanel panel=new JPanel();
		frame.setContentPane(panel);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JDialog jop=new JDialog();
				jop.setVisible(true);
			}
		});
		frame.setVisible(true);
	*/
	}

}
