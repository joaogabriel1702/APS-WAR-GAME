package aps.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Player {

	private int armies;

	private String name;

	private ArrayList<Country> countriesHeld;
	
	public Player(String name) {

		this.name = name;
		this.armies = 0;
		countriesHeld = new ArrayList<Country>();
	}
	public Player(String name, int armies) {

		this.name = name;
		this.armies = armies;
		countriesHeld = new ArrayList<Country>();
	}

	public String getName() {
		return name;
	}

	
	public int getArmies() {
		return armies;
	}


	public void decrementArmies(int numArmies) {

		armies = armies - numArmies;
		System.out.println(name + " has " + armies + " reinforcements remaining.");
	}

	public void incrementArmies(int numArmies) {

		armies = armies + numArmies;
		System.out.println(name + " has gained " + numArmies + " reinforcements. Total available: " + armies);
	}


	public void addCountry(Country country) {

		countriesHeld.add(country);
	}


	public void addCountry(List<Country> countriesList) {
		this.countriesHeld.addAll(countriesList);
	}

	public void removeCountry(Country countryName) {
		countriesHeld.remove(countryName);
	}

}
