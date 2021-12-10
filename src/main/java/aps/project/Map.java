package aps.project;

import java.util.*;

public class Map {
	private List<Country> countries;

	public Map (List<Country> countryList) throws Exception {
		countries = new ArrayList<Country>();
		if (!countryList.isEmpty()){
			countries = countryList;
		}else {
			throw new Exception("No country found.");
		}
	}
	public List<Country> getCountries() {
		return countries;
	}
	public boolean checkAdjacency(Country first, Country second) {
		if(!first.getName().equals(second)) {
			return first.isNeighbour(second);
		}
		return false;
	}
	public boolean checkAdjacency(Country first, String second) {
		if(!first.getName().equals(second)) {
			return first.isNeighbour(second);
		}
		return false;
	}
}
