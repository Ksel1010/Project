package salle2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class StatisticPane extends JPanel{
	private CustomizedButton back;
	private Menu menuStatistics=new Menu();
	private JLabel total;
	private int totalEuros=0;
	private ArrayList<LabelBorder> qtyLabels=new ArrayList();
	
	public StatisticPane(Menu menu) {
		super();
		menuStatistics.copyEmpty(menu);
		Color backGround=new  Color(197,157,98);
		setLayout(new BorderLayout());
		JPanel header= new JPanel();
		header.setBackground(backGround);
		header.setLayout(new BorderLayout());
		back=new CustomizedButton("🔙");
		header.add(back,BorderLayout.WEST);
		add(header,BorderLayout.NORTH);
		JPanel center=new JPanel();
		center.setBackground(backGround);
		center.setLayout(new BorderLayout());
		total=new JLabel("Total :  "+totalEuros+" €",SwingConstants.CENTER);
		total.setBackground(backGround);
		center.add(total,BorderLayout.NORTH);
		JPanel table = new JPanel();
		table.setBackground(backGround);
		table.setLayout(new GridLayout(0,2,0,0));
		table.add(new LabelBorder("Starters"));
		PanelBorder startersTable=new PanelBorder();
		startersTable.setBackground(backGround);
		table.add(startersTable);
		table.add(new LabelBorder("Main Course"));
		PanelBorder main_CourseTable=new PanelBorder();
		table.add(main_CourseTable);
		table.add(new LabelBorder("Desserts"));
		main_CourseTable.setBackground(backGround);
		PanelBorder dessertsTable=new PanelBorder();
		dessertsTable.setBackground(backGround);
		table.add(dessertsTable);
		startersTable.setLayout(new GridLayout(menuStatistics.getStarters().length,2));
		
		for(int i=0;i<menuStatistics.getStarters().length;i++) {
			startersTable.add(new LabelBorder(menuStatistics.getStarters()[i].getDescription()));
			qtyLabels.add(new LabelBorder(menuStatistics.getStarters()[i]));
			startersTable.add(qtyLabels.get(i));
		}
		main_CourseTable.setLayout(new GridLayout(menuStatistics.getMain_courses().length,2));
		for(int i=0;i<menuStatistics.getMain_courses().length;i++) {
			main_CourseTable.add(new LabelBorder(menuStatistics.getMain_courses()[i].getDescription()));
			qtyLabels.add(new LabelBorder(menuStatistics.getMain_courses()[i]));
			main_CourseTable.add(qtyLabels.get(qtyLabels.size()-1));
		}
		dessertsTable.setLayout(new GridLayout(menuStatistics.getDesserts().length,2));
		for(int i=0;i<menuStatistics.getDesserts().length;i++) {
			dessertsTable.add(new LabelBorder(menuStatistics.getDesserts()[i].getDescription()));
			qtyLabels.add(new LabelBorder(menuStatistics.getDesserts()[i]));
			dessertsTable.add(qtyLabels.get(qtyLabels.size()-1));
		}
		center.add(table);
		add(center);
		
		

		

		
		
	}
	public void refreshTotal(int lastReceipe) {
		totalEuros+=lastReceipe;
		total.setText("Total :  "+totalEuros+" €");
	}

	public void addListeners(AbstractAction controller) {
		// TODO Auto-generated method stub
		back.addActionListener(controller);
	}
	public void addOrder(Order order) {
		Plat pl=null;
		for (int i=0; i<order.getStarters().size();i++) {
			pl=menuStatistics.searchById("Starter", order.getStarters().get(i).getId());
			pl.setQty(pl.getQty()+order.getStarters().get(i).getQty());
		}
		for (int i=0; i<order.getMain_courses().size();i++) {
			pl=menuStatistics.searchById("Main_course", order.getMain_courses().get(i).getId());
			pl.setQty(pl.getQty()+order.getMain_courses().get(i).getQty());
		}
		for (int i=0; i<order.getDesserts().size();i++) {
			pl=menuStatistics.searchById("Dessert", order.getDesserts().get(i).getId());
			pl.setQty(pl.getQty()+order.getDesserts().get(i).getQty());
		}
		repaint();
	}
	public void refreshQty() {
		for (LabelBorder l:qtyLabels) {
			l.refresh();
		}
	}
}
