package salle2;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class Plat {
	private int id;
	//only consider the description field while deserializing
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String description;
	private int qty;
	
	public Plat() {
		
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public Plat(String description,int id) {
		this(id);
		this.description=description;
	}
	
	public Plat(int id2) {
		id=id2;
		qty=1;
	}
	@Override
	public String toString() {
		return description +"          qty:"+qty;
	}
	public void addOne() {
		// TODO Auto-generated method stub
		qty++;
	}
	
}

