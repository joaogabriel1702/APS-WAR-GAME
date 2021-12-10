package aps.project;

public class BattleResult {
	private String playerWinner = "Defense";
	
	public void rollDices() {
		
		Dice diceAttack = new Dice();
        diceAttack.roll();
        
        Dice diceDefense = new Dice();
        diceDefense.roll();
        
        if(diceAttack.getDice() > diceDefense.getDice()) {
        	playerWinner = "Attack";
        	
        }
		
	}
	
	public String getBattleResult() {
		return playerWinner;
	}

}
