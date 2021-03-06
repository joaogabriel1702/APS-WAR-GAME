package aps.project;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Dice {

	private int roll;
	private int[] diceArray;
	private Random die;

	public Dice() {

	}

	public int[] roll(int numberOfDice) {

		diceArray = new int[numberOfDice];

		for (int i = 0; i < diceArray.length; i++) {
			die = new Random();
			roll = die.nextInt(5) + 1;
			diceArray[i] = roll;
		}

		Arrays.sort(diceArray);
		Collections.reverse(Arrays.asList(diceArray));

		return diceArray;
	}
}
