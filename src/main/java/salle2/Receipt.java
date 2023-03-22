package salle2;

import java.util.ArrayList;
import java.util.Arrays;

public class Receipt {
	private Order order;
	private int total=0;
	private int starterPrice;
	private int main_coursePrice;
	private int dessertPrice;
	
	public Receipt() {
		order=new Order();
	}

	public void setStarterPrice(int starterPrice) {
		this.starterPrice = starterPrice;
	}

	public void setMain_coursePrice(int main_coursePrice) {
		this.main_coursePrice = main_coursePrice;
	}

	public void setDessertPrice(int dessertPrice) {
		this.dessertPrice = dessertPrice;
	}
	
	public void addOrder(Order ord) {
		ArrayList<Plat> temporaryS=order.getStarters();
		temporaryS.addAll(ord.getStarters());
		order.setStarters( temporaryS);
		ArrayList<Plat>temporaryM=order.getMain_courses();
		temporaryM.addAll(ord.getMain_courses());
		order.setMain_courses(temporaryM);
		ArrayList<Plat> temporaryD=order.getDesserts();
		temporaryD.addAll(ord.getDesserts());
		order.setDesserts(temporaryD);
	}
	public void print() {
		String str="******************************************************"+System.lineSeparator();
		ArrayList<ArrayList<Plat>> liste =new ArrayList(Arrays.asList(order.getStarters(),order.getMain_courses(),order.getDesserts()));
		for (ArrayList<Plat > al:liste) {
			for(Plat pl : al) {
				int price=0;
				if(pl instanceof Starter) {
					price=starterPrice*pl.getQty();
				}
				if(pl instanceof Main_course) {
					price=main_coursePrice*pl.getQty();
				}
				if(pl instanceof Dessert) {
					price=dessertPrice*pl.getQty();
				}
				total+=price;
				str+=pl.getQty()+"		"+pl.getDescription()+"		"+Integer.toString(price)+"€"+System.lineSeparator();
			}
		}
		str+="total: 	"+total+"€ 		dont TVA: "+ total/5.0+"€ (20%)"+System.lineSeparator()+"******************************************************";
		System.out.println(str);
	}
	public void clear() {
		order=new Order();
		total=0;
	}
	public int getTotal() {
		return total;
	}
}
