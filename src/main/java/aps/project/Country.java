package aps.project;

import java.util.*;

public class Country {
	private int army;
	private String name;
	private String ownerId;
	private List<String> countriesFrontier;

	public Country(String countryName, List<String> countriesFrontie) {
		this.name = countryName;
		this.countriesFrontier = new ArrayList<String>();
		this.countriesFrontier = countriesFrontie;

	}

	public boolean isNeighbour(String otherCountryName) {
		if (!name.equalsIgnoreCase(otherCountryName)) {
			for (String c : countriesFrontier) {
				if (c.equalsIgnoreCase(otherCountryName)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isNeighbour(Country other) {
		if (!name.equalsIgnoreCase(other.getName())) {
			for (String c : countriesFrontier) {
				if (c.equalsIgnoreCase(other.getName())) {
					return true;
				}
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

	public List<String> getCountriesFrontier() {
		return countriesFrontier;
	}

}
