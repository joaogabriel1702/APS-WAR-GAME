package aps.project;

public class GamePlayAttack implements GamePlayStrategy{
	
	Dice dice;
	public int numberarmy = 3;
	int attackerdice;

	public void MakeGamePlay(Country countryorigin, Country countrynext) {
		
	}
	
	public int AttackDice() {
		return attackerdice = dice.getDice();
	}
	

}
