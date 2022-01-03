import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class combatMechanics{

	private String statusCondition;
	private int health;
	private int sp;
	characterStats statsRef;
	ArrayList<Integer>fighterStats;
	ArrayList<Integer>healerStats;
	ArrayList<Integer>wizardStats;
	ArrayList<Integer>rogueStats;
	ArrayList<String>itemBag;
	ArrayList<String>fighterSkills;
	ArrayList<Integer>badStats;
	boolean inCombat;
	private int numCharacters;
	private int numEnemies;
	private int PlayerHP;
	private int FoeHP;
	private int PlayerSP;
	private int FoeSP;
	private int PlayerAtk;
	private int PlayerMagAtk;
	private Scanner theScan;


	/*public combatMechanics(characterStats statsGo) {
		this.statsRef = statsGo;
		statusCondition = "neutral";
		health = 100;
		sp = 100;
		ArrayList<Integer> fighterStats = statsRef.getFightStats();
		ArrayList<String> itemBag = statsRef.getInventory();
		ArrayList<String> fighterSkills = statsRef.getFightSkills();
		inCombat = true;
	}
	*/

	public combatMechanics(SaveFile x, Scanner sc) {
		this.theScan = sc;
		this.statsRef = new characterStats();
		this.statusCondition = "neutral";
		this.health = 100;
		this.sp = 100;
		this.inCombat = true;
		this.numCharacters = 1;
		this.numEnemies = 1;
		//this.fighterStats = statsRef.getFightStats();
		//this.itemBag = statsRef.getInventory();
		//this.badStats = statsRef.getEnemyStats();
		this.fighterStats = x.getFighterStats();
		this.badStats = new ArrayList<Integer>();
		this.itemBag = new ArrayList<String>();
		
		this.badStats.add(1000);
		this.badStats.add(100);
		this.badStats.add(1000);
		this.badStats.add(1000);
		this.badStats.add(1000);
		this.badStats.add(1000);
		this.badStats.add(1000);
		this.badStats.add(1000);
		
		this.itemBag.add("healPotion");
		this.itemBag.add("atkPotion");
		
		this.PlayerHP = this.fighterStats.get(0);
		this.FoeHP = this.badStats.get(0);
		this.PlayerSP = this.fighterStats.get(1);
		this.FoeSP = this.badStats.get(1);
		this.PlayerAtk = fighterStats.get(2);
		this.PlayerMagAtk = fighterStats.get(3);
	}
	

	public boolean StillFighting() {
		System.out.println("You are in combat.");
		return inCombat;
	}


	/**
	 * Describes the accuracy mechanic of the game.
	 * @param fighterStats 
	 */
	public void accuracyHit(ArrayList<Integer>whoseStats) {
		//int hitRate = whoseStats.indexOf(7);
		//if character chooses to attack on their turn
		//use hit rate to see if hit or miss; if miss- skip turn, no damage dealt.
		//if (fighter attacks) {
		//check their accuracy stat: stat = odds of landing the hit. }
	}

	/**
	 * this class describes the poison status mechanic.
	 */
	public void poisoned(ArrayList<Integer>whoseStats) {
		int healthDrop = whoseStats.indexOf(0);
		if (statusCondition == "poisoned") {
			System.out.println("the character has been poisoned.");
			healthDrop = (healthDrop - (healthDrop/10));
		}
	}

	/**
	 * this class describes the defeated status mechanic.
	 */
	public void defeated(ArrayList<Integer>whoseStats) {
		int healthDown = whoseStats.indexOf(0);
		if (healthDown == 0) {
			System.out.println("The character has been defeated.");
			//Character cannot act;
			//Character cannot be attacked;
		}
	}

	/**
	 * This class describes the blinded status mechanic.
	 */
	public void blinded(ArrayList<Integer>whoseStats) {
		int accuracy = whoseStats.indexOf(7);
		if (statusCondition == "blinded") {
			System.out.println("The character has been blinded.");
			accuracy = (accuracy/2);
		}
	}

	/**
	 * This class describes the slowed down status mechanic.
	 */
	public void Debuffed(ArrayList<Integer>whoseStats) {
		int defense = whoseStats.indexOf(4);
		int magicDef = whoseStats.indexOf(5);
		if (statusCondition == "weakened") {
			System.out.println("The character has been weakened.");
			defense = (defense/2);
			magicDef = (magicDef/2);
		}
	}

	/** 
	 * This returns the status condition changes that happen to characters during combat.
	 * @return current Status condition of the characters involved
	 */
	public String inflictedStatus(ArrayList<String>whoseSkills) {
		//during combat:

		if(health == 0){
			statusCondition = "defeated";
		}
		if(whoseSkills.contains("poison")) {
			statusCondition = "poisoned";
		}
		if(whoseSkills.contains("blind")) {
			statusCondition = "blinded";
		}
		if (whoseSkills.contains("weaken")) {
			statusCondition = "weakened";
		}
		return statusCondition;
	}

	/**
	 * this class neutralizes the status conditions that the characters
	 * have after combat, revives defeated characters, and restores their SP.
	 * @return statusCondition of the fighter after being restored
	 */
	public String recoverStatus(ArrayList<Integer>whoseStats) {
		//after combat, if enemies' health == 0:

		int health = whoseStats.indexOf(0);

		if (health == 0) {
			System.out.println("The character has been revived.");
			health = 1;
			System.out.println("The character has been cured.");
			statusCondition = "neutral";
		}
		if (statusCondition != "neutral") {
			System.out.println("The character has been cured.");
			statusCondition = "neutral";
		}
		if (sp < 100) {
			sp = 100;
			System.out.println("Character's SP has been restored.");
		}
		return statusCondition;
	}

	/**
	 * Compares the speed stats of all characters. The character or enemy with
	 * the highest speed stat goes first, with the lowest speed stat going last.
	 */
	public int turnOrder() {
		System.out.println("Let's see who's fastest.");
		int speed = fighterStats.get(6);
		int badSpeed = badStats.get(6);

		//int[] teamSpeed = {fighterStats.indexOf(6)}; //healerStats.indexOf(6), wizardStats.indexOf(6), rogueStats.indexOf(6)};
		//int [] foeSpeed = {foe1Stats.indexOf(6)}; //foe1stats.indexOf(6), foe2stats.indexOf(6), foe3stats.indexOf(6), foe4stats.indexOf(6)};

		//ArrayList<Integer> numFighters = new ArrayList<Integer>();
		//numFighters.add(speed);
		//numFighters.add(badSpeed);
		//Collections.sort(numFighters);
		


		//int fastestUnit = numFighters.get(0);
		//for (int i = 0; i < numFighters.size(); i++) {
			/*if (numFighters.get(i) > fastestUnit) {
				fastestUnit = numFighters.get(i);
				System.out.println(fastestUnit + "'s turn order is " + i);
			}
			*/
			
			
			//if (fastestUnit == fighterStats.get(6)) { //|| fastestUnit == healerStats.indexOf(6) || fastestUnit == wizardStats.indexOf(6) || fastestUnit == rogueStats.indexOf(6)) {
			if(speed > badSpeed) {
				System.out.println("You are going first.");
				System.out.print("\n");
				playersTurn();
				
			}
			//if (fastestUnit == badStats.get(6)) { //|| fastestUnit == foe2stats.indexOf(6) || fastestUnit == foe3stats.indexOf(6) || fastestUnit == foe4stats.indexOf(6)) {
			if(badSpeed > speed) {	
				System.out.println("The foe strikes first.");
				System.out.print("\n");
				foesTurn();
			}
		//}
		return -1;
	}
	//retrieves the speed values of all characters (characters will be chosen from an array).
	//find the highest speed stat and the character with that stat
	//that character will go first
	//repeat the process, going for the next highest speed stat.
	//stop and begin combat when last character's speed and turn order is established.
	// (Could include queue).

	/**
	 * Indicates how many combatants are still able to fight.
	 */
	public void charactersLeft() {
		System.out.println("How many characters left?");
		//int characterHealth = fighterStats.get(0);
		//int enemyHealth = badStats.get(0);
		int numCharacters = 1;
		int numEnemies = 1;
		//if(characterHealth == 0) {
		if(this.PlayerHP <= 0) {
			System.out.println("A character has been defeated!");
			numCharacters = numCharacters - 1;
			combatEnding();
		}

		//if(enemyHealth == 0) {
		if(this.FoeHP <= 0) {
			System.out.println("An enemy has been defeated!");
			numEnemies = numEnemies - 1;
			combatEnding();
		}

	}

	/**
	 * Returns a text indicating if the player won or lost, and acts accordingly to both scenarios. 
	 * @return Victory or Game Over, if player wins or loses in combat.
	 */
	public void combatEnding() {
		System.out.println("The characters have left combat.");
		this.inCombat = false;
	}

	public int resultsHere() {
		System.out.println("Combat has ended.");
		if (numEnemies == 0) {
			System.out.println("Victory!");
			//leave fight scene and go to the labyrinth navigation scene.
			return 1;
		}
		if (numCharacters == 0) {
			System.out.println("Game Over!");
			//leave fight scene and go to last save point or save file selection.
			return 0;
		}
		return -1;
	}

	/**
	 * This class describes the character using a combat skill from
	 * their combatSkills list during their turn while in combat.
	 * Combat Skills will subtract SP from the characters that use their skills.
	 * @return
	 */
	public String useCombatSkills(String skill) {
		System.out.println("You are using a skill.");
		//int SP = this.PlayerSP;
		int spCost = 20; //spCost = cost to use skill
		//during character's turn:
		if (fighterSkills.contains(skill) && this.PlayerSP > spCost) {
			this.PlayerSP = this.PlayerSP - spCost;
			//use skill and activate its effects on foe or specified target.
		}
		return "used" + skill;
		//end character's turn
	}


	/**
	 * describes the player's turn and options.
	 */
	public void playersTurn() {
		System.out.println("What will you do?");
		//int goodHP = fighterStats.get(0);
		//int goodSP = fighterStats.get(1);
		//int foeHP = badStats.get(0);
		int damage = (fighterStats.get(2) - badStats.get(4));
		if (damage <= 0) {
			damage = 0;
		}
		//int charAtk = fighterStats.get(2);
		//int charMag = fighterStats.get(3);
		System.out.println("Hero HP: " + this.PlayerHP);
		System.out.println("Hero SP: " + this.PlayerSP);
		System.out.println("Hero ATK: " + this.PlayerAtk);
		System.out.println("Hero MagATK: " + this.PlayerMagAtk);
		System.out.println("Foe HP: " + this.FoeHP);
		System.out.println("Foe SP: " + this.FoeSP);
		Scanner newScanner = this.theScan;
		System.out.println("What will you do? attack? item? skill?");
		String option = newScanner.nextLine();

		if (option.equals("attack")) {
			this.FoeHP = this.FoeHP - damage;
			System.out.println("You attacked. Foe took " + damage + " damage.");
			System.out.print("\n" + "\n");
			if(this.FoeHP <= 0) {
				this.inCombat = false;
				numEnemies = 0;
			}
			
			else {
				foesTurn();
			}
			
		}

		else if (option.equals("item")) {
			if (this.itemBag == null) {
				System.out.println("You have no items. What now?");
				System.out.print("\n" + "\n");
				playersTurn();
			}
			for (int i = 0; i < itemBag.size();i++) {
				System.out.println(itemBag.get(i));
			}
			option = newScanner.nextLine();

			if (itemBag.contains("healPotion") && option.equals("healPotion")){
				this.PlayerHP = this.PlayerHP + 10;
				System.out.println("You used a healing potion." + " HP now: " + this.PlayerHP);
				System.out.print("\n" + "\n");
				foesTurn();
			}
			if (itemBag.contains("atkPotion") && option.equals("atkPotion")) {
				this.PlayerMagAtk = this.PlayerMagAtk + 4;
				this.PlayerAtk = this.PlayerAtk + 4;
				System.out.println("You used an attack potion. Attack and magic attack increased by 4.");
				System.out.print("\n" + "\n");
				foesTurn();
			}
			
			//scanner.close();
		}

		else if (option.equals("skill")) {
			if (this.PlayerSP == 0) {
				System.out.println("You have no SP. What now?");
				playersTurn();
			}
			System.out.println("Use which skill?");
			for (int i = 0; i < fighterSkills.size(); i++) {
				System.out.println(fighterSkills.get(i));
			}
			option = this.theScan.nextLine();
			useCombatSkills(option); //should use parameter to specify which skill to use.
			foesTurn();
		}
		
		else {
			playersTurnErrorCatcher();
		}
	}
	
	public void playersTurnErrorCatcher() {
		//System.out.println("What will you do?");
		//int goodHP = fighterStats.get(0);
		//int goodSP = fighterStats.get(1);
		//int foeHP = badStats.get(0);
		int damage = (fighterStats.get(2) - badStats.get(4));
		if (damage <= 0) {
			damage = 0;
		}
		//int charAtk = fighterStats.get(2);
		//int charMag = fighterStats.get(3);
		//System.out.println("Hero HP: " + this.PlayerHP);
		//System.out.println("Hero SP: " + this.PlayerSP);
		//System.out.println("Hero ATK: " + this.PlayerAtk);
		//System.out.println("Hero MagATK: " + this.PlayerMagAtk);
		//System.out.println("Foe HP: " + this.FoeHP);
		//System.out.println("Foe SP: " + this.FoeSP);
		Scanner newScanner = this.theScan;
		//System.out.println("What will you do? attack? item? skill?");
		String option = newScanner.nextLine();

		if (option.equals("attack")) {
			this.FoeHP = this.FoeHP - damage;
			System.out.println("You attacked. Foe took " + damage + " damage.");
			System.out.print("\n" + "\n");
			if(this.FoeHP <= 0) {
				this.inCombat = false;
				numEnemies = 0;
			}
			
			else {
				foesTurn();
			}
			
		}

		else if (option.equals("item")) {
			if (this.itemBag == null) {
				System.out.println("You have no items. What now?");
				System.out.print("\n" + "\n");
				playersTurn();
			}
			for (int i = 0; i < itemBag.size();i++) {
				System.out.println(itemBag.get(i));
			}
			option = newScanner.nextLine();

			if (itemBag.contains("healPotion") && option.equals("healPotion")){
				this.PlayerHP = this.PlayerHP + 10;
				System.out.println("You used a healing potion." + "HP now: " + this.PlayerHP);
				System.out.print("\n" + "\n");
				foesTurn();
			}
			if (itemBag.contains("atkPotion") && option.equals("atkPotion")) {
				this.PlayerMagAtk = this.PlayerMagAtk + 4;
				this.PlayerAtk = this.PlayerAtk + 4;
				System.out.println("You used an attack potion. Attack and magic attack increased by 4.");
				System.out.print("\n" + "\n");
				foesTurn();
			}
			
			//scanner.close();
		}

		else if (option.equals("skill")) {
			if (this.PlayerSP == 0) {
				System.out.println("You have no SP. What now?");
				playersTurn();
			}
			System.out.println("Use which skill?");
			for (int i = 0; i < fighterSkills.size(); i++) {
				System.out.println(fighterSkills.get(i));
			}
			option = this.theScan.nextLine();
			useCombatSkills(option); //should use parameter to specify which skill to use.
			foesTurn();
		}
		
		else {
			playersTurnErrorCatcher();
		}
	}

	/**
	 * describes the foe's turn and actions.
	 */
	public void foesTurn() {
		System.out.println("The foe strikes!");
		/*int foeHP = badStats.get(0);
		int foeSP = badStats.get(1);
		int targetHP = fighterStats.get(0);
		*/
		System.out.println("Hero HP: " + this.PlayerHP);
		System.out.println("Hero SP: " + this.PlayerSP);
		System.out.println("Hero ATK: " + this.PlayerAtk);
		System.out.println("Hero MagATK: " + this.PlayerMagAtk);
		System.out.println("Foe HP: " + this.FoeHP);
		System.out.println("Foe SP: " + this.FoeSP);
		int damage = (badStats.get(2) - fighterStats.get(4));
		if(damage <= 0) {
			damage = 0;
		}
		String[]foeChoice = {"attack", "item", "skill"};
		Random choices = new Random();
		int foeCheck = (int)Math.floor(Math.random() * foeChoice.length);
		if (foeCheck == 0) {
			this.PlayerHP = this.PlayerHP - damage;
			System.out.println("The Foe attacked. You took " + damage + " damage.");
			System.out.print("\n" + "\n");
			if(this.PlayerHP <= 0) {
				this.inCombat = false;
				this.numCharacters = 0;
			}
			
			else {
				playersTurn();
			}
		}
		if (foeCheck == 1) {
			this.FoeHP = this.FoeHP + 50;
			System.out.println("Enemy drank a healing potion. HP + 50.");
			System.out.print("\n" + "\n");
			playersTurn();
			//use item
		}
		if (foeCheck == 2) {
			//use skill
			if(this.FoeSP <= 0) {
				System.out.println("Foe has no SP");
				foesTurn();
			}
			else {
				this.PlayerHP = this.PlayerHP - (this.PlayerHP/2);
				this.FoeSP = this.FoeSP - 20;
				System.out.println("Enemy used skill; lose half health.");
				System.out.print("\n" + "\n");
				playersTurn();
			}
		}
	}
}
