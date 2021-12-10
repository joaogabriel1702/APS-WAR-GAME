package aps.project;

import java.util.List;

public class GameRound {
	private Player actualPlayer;
	private Player next;
	private boolean canAttack;
	private int attackerArmies;
	private int defenderArmies;
	private int attackerLosses;
	private int defenderLosses;
	private int attackerDice;
	private int defenderDice;
	
	private int[] attackerRolls;
	private int[] defenderRolls;

	private final Dice dices;
	private final List<Player> players;
	private int jogadorAtual;

	public GameRound(Dice dice, List<Player> players) {
		this.dices = dice;
		this.players = players;
		this.jogadorAtual = 0;
	}

	public List<Player> getJogadores() {
		return players;
	}

	public boolean beginRound() {
		if (dices != null && players.size() >= 3)
			return true;
		throw new Exception ("");
	}

	public void terminarRodada() {
		if (jogadorAtual == this.players.size() - 1) {
			this.jogadorAtual = 0;
		} else {
			this.jogadorAtual += 1;
		}
	}

	public Player pegarJogadorAtual() {
		return this.players.get(this.jogadorAtual);
	}
}

	

	public Player getNext() {
		return next;
	}

	public void setNext(Player next) {
		this.next = next;
	}


	public Player getActualPlayer() {
		return actualPlayer;
	}


	public void setActualPlayer(Player actualPlayer) {
		this.actualPlayer = actualPlayer;
	}

}
