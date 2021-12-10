package aps.project;

import java.util.List;

public class PlayerConstructor {
	private final Player player;

    public PlayerConstructor(String name) {
        this.player = new Player(name);
    }

    public static PlayerConstructor builder(String name) {
        return new PlayerConstructor(name);
    }


    public PlayerConstructor addTerritorios(List<Country> countries) {
        this.player.addCountry(countries);
        return this;
    }

}

