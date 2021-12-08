package aps.project;

public class GameBoardSingleton {
	private static GameBoardSingleton instance;
	private Map gameMap;
	private GameBoardSingleton() {
		gameMap = new Map();
	}

	public static GameBoardSingleton GetInstance() {
		if (instance == null) {
			instance = new GameBoardSingleton();
		}
		return instance;
	}
	
	public void ResetInstance() {
		instance = null;
	}
	
}
