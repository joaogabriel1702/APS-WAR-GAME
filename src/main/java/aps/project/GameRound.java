package aps.project;

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

	protected void attack(Country countryA, Country countryB) {
		
		countryA = board.getCountryByName(countryAName);
		countryB = board.getCountryByName(countryBName);
		
		if (canAttack == true || isAI == true) {
		
			if (!currentPlayer.equals(countryB.getOccupant())) {
			// Check if countryB is occupied by an opponent
				if (board.checkAdjacency(countryA.getName(), countryB.getName()) == true) {
				// Check if countryA is adjacent to countryB
				
					dice = new Dice();
					
					// Set default values
					attackerLosses = 0;
					defenderLosses = 0;
					attackerDice = 1;
					defenderDice = 1;
					isInt = false;
					
					if (isAI == true) {
						rng = new Random();
						if (countryA.getArmies() <= 3) {
							attackerDice = 1;
						} else {
							attackerDice = rng.nextInt(2) + 1;
						}
					} else {
					// If current player is Human
						try {
						// Attacker chooses how many dice to roll
							
							attackerDice = Integer.parseInt(JOptionPane.showInputDialog(countryA.getOccupant().getName() + ", you are attacking " + countryAName + " from " + countryBName + "! How many dice will you roll?"));
							
							if (attackerDice < 1 || attackerDice > 3 || attackerDice >= countryA.getArmies()) {
								throw new IllegalArgumentException();
							}
							isInt = true;
							
						} catch (NumberFormatException e) {
							// Error: attacker inputs non-integer
							System.out.println("Commander, please take this seriously. We are at war.");
							
						} catch (IllegalArgumentException e) {
							// Error: attacker inputs invalid number of dice
							System.out.println("Roll 1,2 or 3 dice. You must have at least one more army in your country than the number of dice you roll.");
						}
					}
					if (isInt == true || currentPlayer.getAI() == true) {
						attackerRolls = dice.roll(attackerDice);
						isInt = false;							
						if (countryB.getOccupant().getAI() == true) {
						// If the current player is AI
							rng = new Random();
							if (countryB.getArmies() <= 1) {
								defenderDice = 1;
							} else {
								defenderDice = rng.nextInt(1) + 1;
							}
						} else {
						// If current player is Human
							while(isInt == false) {
								try {
								// Defender chooses how many dice to roll after attacker
									defenderDice = Integer.parseInt(JOptionPane.showInputDialog(countryB.getOccupant().getName() + ", you are defending " + countryBName + " from " + countryA.getOccupant().getName() + "! How many dice will you roll?"));
									
									if (defenderDice < 1 || defenderDice > 2 || defenderDice > countryA.getArmies()) {
										throw new IllegalArgumentException();
									}
									isInt = true;
									
								} catch (NumberFormatException e) { 
									// Error: defender inputs non-integer
									System.out.println("Commander, please take this seriously. We are at war.");
									
								} catch (IllegalArgumentException e) {
									// Error: defender inputs invalid number of dice
									System.out.println("Roll either 1 or 2 dice. To roll 2 dice, you must have at least 2 armies on your country.");
								}
							}
						}
						if (isInt == true || countryB.getOccupant().getAI() == true) {
							defenderRolls = dice.roll(defenderDice);
							// Rolls arrays have been ordered in descending order. Index 0 = highest pair
							if (attackerRolls[0] > defenderRolls[0]) {
								defenderLosses++;
							}
							else if (attackerRolls[0] < defenderRolls[0]) {
								attackerLosses++;
							}
							// Index 1 = second highest pair
							if (attackerDice > 1 && defenderDice > 1) {
							
								if (attackerRolls[1] > defenderRolls[1]) {
									defenderLosses++;
									
								} else if (attackerRolls[1] < defenderRolls[1]) {
									attackerLosses++;
								}
							}
							// Calculate losses
							System.out.println("<COMBAT REPORT>");
							countryA.decrementArmies(attackerLosses);
							countryB.decrementArmies(defenderLosses);
							
							// If defending country loses all armies
							if (countryB.getArmies() < 1) {
							
								System.out.println("WORLD NEWS: " + countryA.getOccupant().getName() + " has defeated all of " + countryB.getOccupant().getName() + "'s armies in " + countryBName + " and has occupied the country!");
								
								// Remove country from defender's list of occupied territories and adds to attacker's list
								countryB.getOccupant().removeCountry(countryBName);
								countryA.getOccupant().addCountry(countryB);

								// Check if defender is eliminated from game
								if (countryB.getOccupant().getOwnedCountries().size() == 0)	{
									
									System.out.println("WORLD NEWS: " + countryB.getOccupant().getName() + " has surrendered to " + currentPlayer.getName() + " after his last military defeat at " + countryBName + ". " + currentPlayer.getName() + " has issued an execution, with " + countryB.getOccupant().getName() + " charged as a war criminal.");
									
									players.remove(countryB.getOccupant().getIndex());
								}
								// Set country occupant to attacker
								countryB.setOccupant(countryA.getOccupant());
								countryA.decrementArmies(1);
								countryB.incrementArmies(1);
								
								if(isAI == false) {
									setChanged();
									notifyObservers("countryA");
								}
							}
							canReinforce = false;
						}
					}
				} else {
					System.out.println("Commander, " + countryAName + " is not adjacent to " + countryBName + ".");
				}
			} else {
				System.out.println("Commander, you cannot attack your own territories.");
			}
		} else {
			System.out.println("Commander, our forces are not prepared to launch an attack right now.");
		}
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
