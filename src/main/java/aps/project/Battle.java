package aps.project;

public class Battle {
	private Player attackPlayer; 
	private Player defensePlayer;
	

	public void battle(GamePlayAttack attack, GamePlayDefense defense) {
		
		
		for(int i = 1; i > attack.numberarmy; i++) {
			BattleResult battle = new BattleResult();
		}
		
	}
	
	public void moveArmy(Player player, int quantity) {
		
	}
	public Player attack(Map map, Country attackerCountry, Country defensorCountry, Player attacker, Player defensor) {
			if(attacker.getName().equals(defensor.getName())) {
				throw new Exception ("Not possible attack yourself");
			}
			if(!attackerCountry.isNeighbour(defensorCountry)) {
				throw new Exception ("No adjancey found!");
			}
			Dice dice = new Dice ();
			int[] atackResult, defendResult;
			if(attackerCountry.getArmy() > 2) {
				atackResult = dice.roll(3);
			} else if (attackerCountry.getArmy() == 2) {
				atackResult = dice.roll(2);
			}else {
				atackResult = dice.roll(1);
			}
			if(defensorCountry.getArmy() > 2) {
				defendResult = dice.roll(3);
			} else if (defensorCountry.getArmy() == 2) {
				defendResult = dice.roll(2);
			}else {
				defendResult = dice.roll(1);
			}
			
			

			Player winner = this.battleResult(atackResult, defendResult, attacker, defensor);
			
			System.out.println("Winner: " + winner.getName());

			return winner;
		}


		private Player battleResult(int[] atackResult, int[] defendResult, Player attacker,
				Player defensor) {
			int attVictories = 0;
			int defVictories = 0;

			for (int i = 0; i < 3; i++) {
				if (atackResult[i] > defendResult[i]) {
					attVictories = attVictories + 1;
				} else {
					defVictories = defVictories + 1;
				}
			}

			return attVictories > defVictories ? attacker : defensor;
		}

	
	
	
	
}
