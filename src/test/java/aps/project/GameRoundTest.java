package aps.project;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameRoundTest {
	GamePlayStrategy gamePlay;
	
	private Dice dices;
	private List<Player> Playeres;


	@Before
	void setup() {
		this.dices = new Dice();

	}


	@Test
	public void testDice() {
		final int maior = 6;
		final int menor = 1;
		int [] random = dices.roll(1);
		assertTrue(maior >= random[1]);
		assertTrue(menor <= random[1]);
	}

	@Test
	public void testCantAttackYourself() {

	}


	@Test
	public void test01NotNeighbour() {
		
	}

	@Test
	void makeBattle() {

	}




}
