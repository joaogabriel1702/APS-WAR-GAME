package aps.project;

public class BattleResult {
	private String playerWinner = "Defense";
	
	public void rollDices() {
		
		Dice diceAttack = new Dice();
        diceAttack.Roll();
        
        Dice diceDefense = new Dice();
        diceDefense.Roll();
        
        if(diceAttack.getDice() > diceDefense.getDice()) {
        	playerWinner = "Attack";
        	
        }
		
	}
	
	public String getBattleResult() {
		return playerWinner;
	}

}
