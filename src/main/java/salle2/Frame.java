package salle2;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;


@SuppressWarnings("serial")
public class Frame extends JFrame{
	private Controller controller;
	private Menu menu;
	private SettingsPane settings;
	private TablesPane tables;
	private Reception reception;
	private ArrayList<ServicePane> services=new ArrayList<>();
	private ArrayList<Order> orders=new ArrayList<>();
	private ArrayList<Receipt> receipts=new ArrayList<Receipt>();
	private StatisticPane statisticPane;
	private int nbTables=6;
	
	
	public Frame(String file) throws IOException {
		super("La salle");
		readMenu(new File(file));
		controller=new Controller(this);
		this.setUpAndDisplay(file);
	}

	private void setUpAndDisplay(String file) throws StreamReadException, DatabindException, IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(800,400));
		/**if we want the application to display over all of the screen please use the line below**/
//		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		//initializing the different pages
		reception=new Reception();
		statisticPane=new StatisticPane(menu);
		statisticPane.addListeners(controller);
		settings=new SettingsPane();
		tables=new TablesPane(nbTables);
		
		//adding differnet listeners to the components
		reception.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setContentPane(tables);
				setVisible(true);
			}
		});
		tables.getButtons().forEach((JButton) -> {
            JButton.addActionListener(controller);
        });
		for(int i=1;i<=nbTables;i++) {
			orders.add(new Order());
			receipts.add(new Receipt());
			services.add(new ServicePane(menu,i));
			services.get(i-1).getButtons().forEach((JButton) -> {
	            JButton.addActionListener(controller);
	        });
		}
		settings.getButton().addActionListener(controller);
		setContentPane(reception);
	}
	
	
	

	

	public ArrayList<ServicePane> getServices() {
		return services;
	}

	private void readMenu(File file) throws StreamReadException, DatabindException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		menu = mapper.readValue(file, Menu.class);
	}

	public SettingsPane getSettings() {
		return settings;
	}

	public Container getTablesPane() {
		return tables;
	}

	public void setService(int i) {
		setContentPane(services.get(i));
		setVisible(true);
	}

	

	public void setReception() {
		setContentPane(reception);
		setVisible(true);
	}

	public void setTablesPane() {
		setContentPane(tables);
		setVisible(true);
	}

	public void setSettings() {
		setContentPane(settings);
		setVisible(true);
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public ArrayList<Receipt> getReceipts() {
		return receipts;
	}

	public void setStatisticPanel() {
		// TODO Auto-generated method stub
		setContentPane(statisticPane);
		setVisible(true);
	}

	public StatisticPane getStatisticPane() {
		return statisticPane;
	}

}
