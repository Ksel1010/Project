package salle2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class TablesPane extends JPanel{
	private int nbTables;
	private CustomizedButton home;
	private CustomizedButton stats;
	private CustomizedButton settings;
	private ArrayList<JButton> buttons=new ArrayList<JButton>();
	
	public TablesPane(int nb) {
		super();
		nbTables=nb;		
		Color backGround=new  Color(197,157,98);
		setLayout(new BorderLayout());JPanel header=new JPanel();
		header.setLayout(new BorderLayout());
		home=new CustomizedButton("🏠");
		settings=new CustomizedButton("⚙️");
		stats=new CustomizedButton("Statistics");
		JPanel headerRight=new JPanel();
		headerRight.add(settings,BorderLayout.CENTER);
		headerRight.setBackground(backGround);
		header.add(headerRight, BorderLayout.EAST);
		JPanel headerLeft=new JPanel();
		headerLeft.setBackground(backGround);
		headerLeft.add(home,BorderLayout.CENTER);
		header.add(headerLeft,BorderLayout.WEST);
		JPanel headCenter=new JPanel();
		headCenter.add(stats, BorderLayout.CENTER);
		headCenter.setBackground(backGround);
		header.add(headCenter, BorderLayout.CENTER);
		add(header,BorderLayout.NORTH);
		
		JPanel centerPane=new JPanel();
		centerPane.setLayout(new GridLayout(0, 3,100,80));
		for(int i=1;i<=nbTables;i++) {
			buttons.add(new JButton(Integer.toString(i)));
			centerPane.add(buttons.get(i-1));
		}
		repaint();
		buttons.add(home);
		buttons.add(settings);
		buttons.add(stats);
		add(centerPane,BorderLayout.CENTER);
		//choosing colors
		header.setBackground(backGround);
		centerPane.setBackground(backGround);
	}

	public ArrayList<JButton> getButtons() {
		return buttons;
	}
	
	
}
