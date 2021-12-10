package aps.project;

import java.util.*;

public class GameBoardSingleton {
	private static GameBoardSingleton instance;
	private Map gameMap;
	private Country country1, country2, country3;
	private ArrayList<String> country1Frontier, country2Frontier, country3Frontier ;
	private GameBoardSingleton() {
		List<Country> countries = new ArrayList<Country>();
		countries = this.createMap();
		try {
			gameMap = new Map(countries);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public static GameBoardSingleton getInstance() {
		if (instance == null) {
			instance = new GameBoardSingleton();
		}
		return instance;
	}
	
	public void ResetInstance() {
		instance = null;
	}
	private ArrayList<Country> createMap(){
		country1Frontier = new  ArrayList<String>();
		country1Frontier.add("Argentina");
		country1 = new Country ("Brasil", country1Frontier);
		country2Frontier = new  ArrayList<String>();
		country2Frontier.add("Brasil");
		country2 = new Country ("Argentina", country2Frontier);
		country3Frontier = new  ArrayList<String>();
		country3Frontier.add("Paraguai");
		country3 = new Country ("Chile", country3Frontier);
		ArrayList<Country> countries = new ArrayList<Country>();
		countries.add(country1);
		countries.add(country2);
		countries.add(country3);
		return countries;
	}

	public Map getGameMap() {
		return gameMap;
	}
}
