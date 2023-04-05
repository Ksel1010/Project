package salle2;

import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;

import javax.swing.AbstractAction;
import javax.swing.JButton;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@SuppressWarnings("serial")
public class Controller extends AbstractAction{
	private Frame myFrame;
	
	public Controller(Frame frame) {
		myFrame=frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//case of a jbutton
		if (e.getSource().getClass().getSimpleName().equals("JButton")) {
			JButton button=(JButton)e.getSource();

			// case of a button to chose the table
			if(isInteger(button.getText())) {
				int i=Integer.valueOf(button.getText());
				myFrame.setService(i-1);
			}
		}
		//case customizedButton
		if (e.getSource().getClass().getSimpleName().equals("CustomizedButton")) {
				CustomizedButton Cbutton=(CustomizedButton)e.getSource();
				switch(Cbutton.getText()) {
					case "🔙":
						myFrame.setTablesPane();
						break;
					case "🏠":
						myFrame.setReception();
						break;
					case "⚙️":
						myFrame.setSettings();
						break;
					case "<-":
						ServicePane service=(ServicePane)myFrame.getContentPane();
						int index=myFrame.getServices().indexOf(service);
						Order order=myFrame.getOrders().get(index);
						order.deleteLast();
						service.getCommandPanel().refreshText(order);
						break;
					case "❌":
						service=(ServicePane)myFrame.getContentPane();
						index=myFrame.getServices().indexOf(service);
						order=myFrame.getOrders().get(index);
						order.reinitialize();
						service.getCommandPanel().refreshText(order);
						break;
					case "Confirm":
						Timestamp instant= Timestamp.from(Instant.now());
						long xxx=instant.getTime();
						service=(ServicePane)myFrame.getContentPane();
						index=myFrame.getServices().indexOf(service);
						order=myFrame.getOrders().get(index);
						order.setTimestamp(xxx);
						if(order.isEmpty()==false) {
							try {
							FileWriter file = new FileWriter("order_"+xxx+".json");
							ObjectMapper mapper=new ObjectMapper();
							mapper.enable(SerializationFeature.INDENT_OUTPUT);
							String str=mapper.writeValueAsString(order);
							myFrame.getReceipts().get(index).addOrder(order);
							myFrame.getStatisticPane().addOrder(order);
							myFrame.getStatisticPane().refreshQty();
							order.reinitialize();
							service.getCommandPanel().refreshText(order);
							service.getCommandPanel().finishOrder();
							file.write(str);
							file.close();
							
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
						break;
					case "Receipt":
						service=(ServicePane)myFrame.getContentPane();
						service.getCommandPanel().startorder();
						index=myFrame.getServices().indexOf(service);
						Receipt receipt=myFrame.getReceipts().get(index);
						receipt.setStarterPrice(myFrame.getSettings().getStarterPrice());
						receipt.setMain_coursePrice(myFrame.getSettings().getMain_coursePrice());
						receipt.setDessertPrice(myFrame.getSettings().getDessertPrice());
						receipt.print();
						myFrame.getStatisticPane().refreshTotal(receipt.getTotal());
						receipt.clear();
						break;
					case "Statistics":
						myFrame.setStatisticPanel();
						break;
						
					}
			}
		
		//case of buttonPlat
		if (e.getSource().getClass().getSimpleName().equals("ButtonPlat")) {
			ButtonPlat btn=(ButtonPlat) e.getSource();
			Plat plat=btn.getPlat();
			ServicePane service=(ServicePane)myFrame.getContentPane();
			int index=myFrame.getServices().indexOf(service);
			Order order=myFrame.getOrders().get(index);
			order.add(plat);
			service.getCommandPanel().refreshText(order);
		}	
	}
	
	
	private boolean isInteger(String s) {
		 try {
		        @SuppressWarnings("unused")
				double d = Double.parseDouble(s);
		    } catch (NumberFormatException nfe) {
		        return false;
		    }
		    return true;
	}
}
