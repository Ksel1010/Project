package salle2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

// panel de commande à droite de chaque page de table
@SuppressWarnings("serial")
public class CommandPane extends JPanel{
	private JTextArea text;
	private JLabel statu;
	private ArrayList<JButton> buttons=new ArrayList<>();
	public CommandPane() {
		super();
		setLayout(new BorderLayout());
		CustomizedButton cancel=new CustomizedButton("❌");
		cancel.setColor(new Color(192,192,192));
		CustomizedButton back=new CustomizedButton("<-");
		back.setColor(new Color(192,192,192));
		buttons.add(cancel);
		buttons.add(back);
		JPanel header=new JPanel();
		header.setLayout(new BorderLayout());
		header.add(cancel,BorderLayout.EAST);
		header.add(back,BorderLayout.WEST);
		add(header,BorderLayout.NORTH);
		text=new JTextArea("Commande:"+System.getProperty("line.separator" ));
		text.setEditable(false);
		add(text);
		/**in order to set the text dimensions constant we can use the line below**/
		//text.setPreferredSize(new Dimension(200,0));
		
		add(text,BorderLayout.CENTER);
		JPanel footer =new JPanel();
		footer.setLayout(new BorderLayout());
		statu=new JLabel("Start order",SwingConstants.CENTER);
		footer.add(statu,BorderLayout.NORTH);
		JPanel southButtons=new JPanel();
		southButtons.setLayout(new GridLayout(1,2));
		footer.add(southButtons,BorderLayout.CENTER);
		add(footer,BorderLayout.SOUTH);
		CustomizedButton confirm=new CustomizedButton("Confirm");
		confirm.setColor(new Color(192,192,192));
		southButtons.add(confirm);
		buttons.add(confirm);
		southButtons.add(confirm);
		CustomizedButton receipt=new CustomizedButton("Receipt");
		receipt.setColor(new Color(192,192,192));
		southButtons.add(receipt);
		buttons.add(receipt);
	}
	public ArrayList<JButton> getButtons() {
		return buttons;
	}
	public void setWidth(int width) {
		text.setSize(new Dimension(width,text.getHeight()));
	}
	
	public void refreshText(Order commande) {
		String ch="";
		ArrayList<ArrayList<Plat>> liste=new ArrayList(Arrays.asList(commande.getStarters(),commande.getMain_courses(),commande.getDesserts()));
		for(ArrayList<Plat> list: liste) {
			for(Plat pl :list){
				ch+=pl.toString()+System.lineSeparator();
			}
		}
		text.setText("Commande: "+System.getProperty("line.separator" )+ch);
	}
	public void startorder() {
		statu.setText("Start order");
		repaint();
	}
	public void finishOrder() {
		statu.setText("Order in process");
		repaint();
	}
}
