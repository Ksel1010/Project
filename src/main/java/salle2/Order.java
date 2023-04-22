package salle2;

import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(value = { "empty" })
public class Order {
	private HashMap<String , ArrayList<Plat>> commandes;
	//in order to delete the last added meal, we should keep a trace of the sequenc ein which we added them
	private ArrayList<Plat> lastAddedMeals=new ArrayList<>();
	private long id;
		
	public long getId() {
		return id;
	}

	public void setTimestamp(long xxx) {
		this.id = xxx;
	}

	public Order() {
		commandes=new HashMap<String, ArrayList<Plat>>();
		commandes.put("starters", new ArrayList<Plat>());
		commandes.put("main_courses", new ArrayList<Plat>());
		commandes.put("desserts", new ArrayList<Plat>());
	}

	public void add(Plat plat) {
		String type=plat.getClass().getSimpleName();
		Plat plate=searchById(type, plat.getId());
		// create a temporary arraylist in order to refresh the list of courses
		ArrayList<Plat> miseAjour=new ArrayList<Plat>();
		if(type.equals("Starter")) {
			lastAddedMeals.add(new Starter(plat.getId()));
			if(plate==null) {
				miseAjour=commandes.get("starters");
				miseAjour.add(new Starter(plat.getDescription(),plat.getId()));
				commandes.put("starters", miseAjour);
			}
			else {
				miseAjour=commandes.get("starters");
				miseAjour.remove(plate);
				plate.addOne();
				miseAjour.add(plate);
				commandes.put("starters",miseAjour);
			}
		}
		if(type.equals("Main_course")) {
			//same for main_course
			lastAddedMeals.add(new Main_course(plat.getId()));
			if(plate==null) {
				miseAjour=commandes.get("main_courses");
				miseAjour.add(new Main_course(plat.getDescription(),plat.getId()));
				commandes.put("main_courses",miseAjour);
			}
			else {
				miseAjour=commandes.get("main_courses");
				miseAjour.remove(plate);
				plate.addOne();
				miseAjour.add(plate);
				commandes.put("main_courses",miseAjour);
			}
		}
			//the same for  desserts
		if(type.equals("Dessert")) {
			lastAddedMeals.add(new Dessert(plat.getId()));
			if(plate==null) {
				miseAjour=commandes.get("desserts");
				miseAjour.add(new Dessert(plat.getDescription(),plat.getId()));
				commandes.put("desserts",miseAjour);
			}
			else {
				miseAjour=commandes.get("desserts");
				miseAjour.remove(plate);
				plate.addOne();
				miseAjour.add(plate);
				commandes.put("desserts",miseAjour);
			}
		}
	}
	
	

	@Override
	public String toString() {
		return "Order [commandes=" + commandes + ", lastAddedMeals=" + lastAddedMeals + "]";
	}

	private Plat searchById(String type,int id) {
		Plat plat=null;
		if(type.equals("Starter")){
			for(Plat p :commandes.get("starters")) {
				if (p.getId()==id){
					plat=p;
				}
			}
		}
		if(type.equals("Main_course")) {
			for(Plat p : commandes.get("main_courses")) {
				if (p.getId()==id){
					plat=p;
				}
			}
		}
		if(type.equals("Dessert")) {
			for(Plat p :commandes.get("desserts")) {
				if (p.getId()==id){
					plat=p;
				}
			}
		}
		return plat;
	}

	public ArrayList<Plat> getStarters() {
		
		return commandes.get("starters");
	}
	public ArrayList<Plat> getMain_courses() {
			
			return commandes.get("main_courses");
		}
	public ArrayList<Plat> getDesserts() {
		
		return commandes.get("desserts");
	}

	public void deleteLast() {
		// only works if the list is not empty
		if(lastAddedMeals.size()!=0) {	
			Plat lastMeal=lastAddedMeals.get(lastAddedMeals.size()-1);
			if(lastMeal.getClass().getSimpleName().equals("Starter")) {
				Plat toDelete=searchById("Starter", lastMeal.getId());
				commandes.get("starters").remove(toDelete);
				if(toDelete.getQty()!=1) {
					toDelete.setQty(toDelete.getQty()-1);
					ArrayList<Plat> replacement=commandes.get("starters");
					replacement.add(toDelete);
					commandes.put("starters",replacement);;
				}
				
			}
			if(lastMeal.getClass().getSimpleName().equals("Main_course")) {
				Plat toDelete=searchById("Main_course", lastMeal.getId());
				commandes.get("main_courses").remove(toDelete);
				if(toDelete.getQty()!=1) {
					toDelete.setQty(toDelete.getQty()-1);
					ArrayList<Plat> replacement=commandes.get("main_courses");
					replacement.add(toDelete);
					commandes.put("main_courses",replacement);;
				}
				
			}
			if(lastMeal.getClass().getSimpleName().equals("Dessert")) {
				Plat toDelete=searchById("Dessert", lastMeal.getId());
				commandes.get("desserts").remove(toDelete);
				if(toDelete.getQty()!=1) {
					toDelete.setQty(toDelete.getQty()-1);
					ArrayList<Plat> replacement=commandes.get("desserts");
					replacement.add(toDelete);
					commandes.put("desserts",replacement);;
				}
			}
			lastAddedMeals.remove(lastMeal);
			
		}
	}

	public void reinitialize() {
		commandes.put("starters", new ArrayList<Plat>());
		commandes.put("main_courses", new ArrayList<Plat>());
		commandes.put("desserts", new ArrayList<Plat>());
		lastAddedMeals=new ArrayList<Plat>();
	}
	
	public void setStarters(ArrayList<Plat> starters) {
		commandes.put("starters",starters);
	}
	public void setMain_courses(ArrayList<Plat> main_courses) {
		commandes.put("main_courses",main_courses);
	}
	public void setDesserts(ArrayList<Plat> desserts) {
		commandes.put("desserts" , desserts);
	}

	public boolean isEmpty() {

		boolean empty=true;
		if(getStarters().size()!=0 || getMain_courses().size()!=0 || getDesserts().size()!=0) {
			empty=false;
		}
		return empty;
	}
	
}
