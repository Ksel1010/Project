package salle2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

@SuppressWarnings("serial")
public class SettingsPane extends JPanel{
	private CustomizedButton back;
	private JSpinner starterPrice;
	private JSpinner main_coursePrice;
	private JSpinner dessertPrice;
	public CustomizedButton getBack() {
		return back;
	}
	public SettingsPane() {
		super();
		setLayout(new BorderLayout());
		Color backGround=new  Color(197,157,98);
		JPanel header=new JPanel();
		header.setLayout(new BorderLayout());
		header.setBackground(backGround);
		back=new CustomizedButton("🔙");
		back.setBackground(backGround);
		header.add(back,BorderLayout.WEST);
		this.add(header,BorderLayout.NORTH);
		JPanel center=new JPanel();
		center.setLayout(new GridBagLayout());
		center.setBackground(backGround);
		// creating a constraint that will organize different boxes
		GridBagConstraints constraints = new GridBagConstraints(); 
		constraints.insets=new Insets(15,0,15,30);
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.ipadx=50;
		constraints.ipady=50;
		center.add(new JLabel("Starter"),constraints);
		constraints.gridx=1;
		constraints.ipadx=10;
		constraints.ipady=10;
		starterPrice=new JSpinner();
		starterPrice.setValue(Integer.valueOf("7"));
		center.add(starterPrice, constraints);
		constraints.gridx=2;
		constraints.ipadx=0;
		constraints.ipady=0;
		center.add(new JLabel("€"), constraints);
		constraints.gridx=0;
		constraints.gridy=1;
		constraints.ipadx=50;
		constraints.ipady=50;
		center.add(new JLabel("Main Course"),constraints);
		constraints.gridx=1;
		constraints.ipadx=10;
		constraints.ipady=10;
		main_coursePrice=new JSpinner();
		main_coursePrice.setValue(Integer.valueOf("15"));
		center.add(main_coursePrice, constraints);
		constraints.gridx=2;
		constraints.ipadx=0;
		constraints.ipady=0;
		center.add(new JLabel("€"), constraints);
		constraints.gridx=0;
		constraints.gridy=2;
		constraints.ipadx=50;
		constraints.ipady=50;
		center.add(new JLabel("Dessert"),constraints);
		constraints.gridx=1;
		constraints.ipadx=10;
		constraints.ipady=10;
		dessertPrice=new JSpinner();
		dessertPrice.setValue(Integer.valueOf("7"));
		center.add(dessertPrice, constraints);
		constraints.gridx=2;
		constraints.ipadx=0;
		constraints.ipady=0;
		center.add(new JLabel("€"), constraints);
		

		add(center,BorderLayout.CENTER);
	}
	
	public int getStarterPrice() {
		return (Integer) starterPrice.getValue();
	}
	public int getMain_coursePrice() {
		return (Integer) main_coursePrice.getValue();
	}
	public int getDessertPrice() {
		return (Integer) dessertPrice.getValue();
	}
	public JButton getButton() {
		return back;
	}
	
}
