package aps.project;

import java.util.ArrayList;

public class Country {
	private int army;
	private String name;
	private String ownerId;
	private ArrayList<Country> countriesFrontier;
	
	public Country(String countryName, ArrayList<Country> countriesFrontie){
		this.name = countryName;
		this.countriesFrontier = new ArrayList<Country>();
		this.countriesFrontier = countriesFrontie;
		
	}
	public boolean isNeighbour(String otherCountryName) {
		if(!name.equalsIgnoreCase(otherCountryName)) {
			for(Country c : countriesFrontier) {
				if(c.getName().equals(otherCountryName)) {
					return true;
				}
			}
		}		
		return false;
	}
	
	public boolean isNeighbour(Country other) {
		for(Country c : countriesFrontier) {
			if(c.getName().equals(other.getName())) {
				return true;
			}
		}
		return false;
	}
	
	public int getArmy() {
		return army;
	}
	public void setArmy(int army) {
		this.army = army;
	}
	public String getName() {
		return name;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public ArrayList<Country> getCountriesFrontier() {
		return countriesFrontier;
	}
	
}
