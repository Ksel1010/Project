package salle2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class ServicePane extends JPanel{
	@SuppressWarnings("unused")
	private Menu menu;
	private ArrayList<JButton> buttons=new ArrayList<>();
	private CommandPane commandPanel;
	
	public ServicePane(Menu menu, int i) {
		this(menu);
		JLabel text=new JLabel("Table numéro "+Integer.toString(i),SwingConstants.CENTER);
		BorderLayout layout = (BorderLayout) getLayout();
		JPanel header = (JPanel) layout.getLayoutComponent(BorderLayout.NORTH);
		header.add(text,BorderLayout.CENTER);
	}
	
	public ServicePane(Menu menu) {
		super();
		this.menu=menu;
		Color backGround=new  Color(197,157,98);
		setLayout(new BorderLayout());
		//creating the head buttons : back and home
		JPanel header=new JPanel();
		header.setBackground(backGround);
		header.setLayout(new BorderLayout());
		JPanel left=new JPanel();
		left.setBackground(backGround);
		JPanel leftButtons=new JPanel();
		leftButtons.setBackground(backGround);
		leftButtons.setLayout(new GridLayout(0,2,5,5));
		CustomizedButton home=new CustomizedButton("🏠");
		CustomizedButton back=new CustomizedButton("🔙");
		buttons.add(home);
		buttons.add(back);
		leftButtons.add(back);
		leftButtons.add(home);
		left.add(leftButtons,BorderLayout.CENTER);
		header.add(left, BorderLayout.WEST);
		add(header,BorderLayout.NORTH);
		// creating the center buttons
		JPanel center=new JPanel();
		center.setBackground(backGround);
		center.setLayout(new GridLayout(0,1,15,15));
		JPanel startersButtons=new JPanel();
		startersButtons.setBackground(backGround);
		startersButtons.setLayout(new GridLayout(1,0,10,10));
		
		JPanel mainButtons=new JPanel();
		mainButtons.setLayout(new GridLayout(1,0,10,10));
		mainButtons.setBackground(backGround);
		
		JPanel dessertButtons=new JPanel();
		dessertButtons.setLayout(new GridLayout(1,0,10,10));
		dessertButtons.setBackground(backGround);
	
		center.add(startersButtons);
		center.add(mainButtons);
		center.add(dessertButtons);
		
		for(Starter pl:menu.getStarters()) {
			buttons.add(new ButtonPlat(pl));
			startersButtons.add(buttons.get(buttons.size()-1));
		}
		for (Main_course pl:menu.getMain_courses()) {
			buttons.add(new ButtonPlat(pl));
			mainButtons.add(buttons.get(buttons.size()-1));
		}
		for(Dessert pl : menu.getDesserts()) {
			buttons.add(new ButtonPlat(pl));
			dessertButtons.add(buttons.get(buttons.size()-1));
		}
		
		add(center,BorderLayout.CENTER);
		commandPanel=new CommandPane();
		commandPanel.setWidth(this.getWidth()/3);
		add(commandPanel,BorderLayout.EAST);
		buttons.addAll(commandPanel.getButtons());
	}

	public CommandPane getCommandPanel() {
		return commandPanel;
	}

	public ArrayList<JButton> getButtons() {
		return buttons;
		
	}

	
	
}
