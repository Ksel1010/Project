package salle2;

import java.util.Arrays;

public class Menu {
	private Starter[] starters;
	private Main_course[] main_courses;
	private Dessert[] desserts;
	
	
	
	@Override
	public String toString() {
		return "Menu [starters=" + Arrays.toString(starters) + ", main_courses=" + Arrays.toString(main_courses)
				+ ", desserts=" + Arrays.toString(desserts) + "]";
	}
	
	
	
	public Starter[] getStarters() {
		return starters;
	}
	public void setStarters(Starter[] starters) {
		this.starters = starters;
	}
	
	
	public Main_course[] getMain_courses() {
		return main_courses;
	}
	public void setMain_courses(Main_course[] main_courses) {
		this.main_courses = main_courses;
	}
	
	
	public Dessert[] getDesserts() {
		return desserts;
	}
	public void setDesserts(Dessert[] desserts) {
		this.desserts = desserts;
	}


	public void copyEmpty(Menu menu) {
		starters=menu.getStarters();
		for(int i=0;i<menu.getStarters().length;i++) {
			starters[i].setQty(0);
		}
		main_courses=menu.getMain_courses();
		for(int i=0;i<menu.getMain_courses().length;i++) {
			main_courses[i].setQty(0);
		}
		desserts=menu.getDesserts();
		for(int i=0;i<menu.getDesserts().length;i++) {
			desserts[i].setQty(0);
		}
	}

	public Plat searchById(String type,int id) {
		Plat pl=null;
		if (type.equals("Starter")) {
			for (int i=0;i<starters.length;i++) {
				if (starters[i].getId()==id){
					pl=starters[i];
				}
			}
		}
		if(type.equals("Main_course")) {
			for (int i=0;i<main_courses.length;i++) {
				if (main_courses[i].getId()==id){
					pl=main_courses[i];
				}
			} 
		}
		if(type.equals("Dessert")) {
			for (int i=0;i<desserts.length;i++) {
				if (desserts[i].getId()==id){
					pl=desserts[i];
				}
			} 
		}
		return pl;
	}
	
	
	
	
	
	
}
