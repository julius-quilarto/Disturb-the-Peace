import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class simulates a combat scene between two fighters. This
 * is a demo of the text-based RPG game that will be made in the
 * long run and will connect to more features.
 * @author jonahchun, Julius Quilarto
 * @version 11/01/2020
 *
 */
public class combatDemo {
	
	private String badName;
	
	private ArrayList<String>items;

	characterStats characterCreate;

	combatMechanics featuredNow;



	/**
	 * Initializes the fields.
	 * @param mechanic
	 * @param character
	 */
	public combatDemo(combatMechanics mechanic, characterStats character) {
		this.featuredNow = mechanic;
		this.characterCreate = character;
		this.badName = null;
		this.items = new ArrayList<String>();
	}

	/**
	 * This method generates the fighter's name and its stats.
	 * @param nameOne
	 * @param fightingSkills
	 */
	public void createCharacterNow(String nameOne, ArrayList<String>fightingSkills) {
		//character name:
		Scanner nm = new Scanner(System.in);
		System.out.println("What is the character's name?");
		nameOne = nm.next();
		System.out.println("Characters Name:" + nameOne);

		//character stats:
		ArrayList<Integer> fightingStats1 = new ArrayList<Integer>();

		fightingStats1.add(100);
		fightingStats1.add(50+(int)Math.floor(10+Math.random()*20));
		fightingStats1.add(50+(int)Math.floor(10+Math.random()*20));
		fightingStats1.add(30+(int)Math.floor(1+Math.random()*5));
		fightingStats1.add(50+(int)Math.floor(10+Math.random()*20));
		
		//int HP = fightingStats1.indexOf(0);
		//int atk = fightingStats1.indexOf(1);
		//int def = fightingStats1.indexOf(2);
		//int spd = fightingStats1.indexOf(3);
		//int acc = fightingStats1.indexOf(4);

		System.out.println(fightingStats1);

		fightingSkills = null;
		
		nm.close();
	}
	
	/**
	 * This method generates the enemy's name and its stats.
	 * @param badNamed
	 * @param badSkills
	 */
	public void generateEnemy(String badNamed, ArrayList<String>badSkills) {
		//generate name
		Scanner eu = new Scanner(System.in);
		System.out.println("What is the enemy's name?");
		badNamed = eu.next();
		System.out.println("The enemy's name is" + badNamed);
		
		//generate stats
		ArrayList<Integer> evilStats = new ArrayList<Integer>();
		
		evilStats.add(100);
		evilStats.add(40+(int)Math.floor(10+Math.random()*20));
		evilStats.add(30+(int)Math.floor(10+Math.random()*20));
		evilStats.add(60+(int)Math.floor(10+Math.random()*20));
		evilStats.add(50+(int)Math.floor(10+Math.random()*20));
		
		//int evilHP = evilStats.indexOf(0);
		//int evilAtk = evilStats.indexOf(1);
		//int evilDef = evilStats.indexOf(2);
		//int evilSpd = evilStats.indexOf(3);
		//int evilAcc = evilStats.indexOf(4);
		
		System.out.println(evilStats);
		
		badSkills = null;
		eu.close();
	}
	
	/**
	 * This methods gets the initialized ArrayList inventory
	 * and adds String items to it.
	 */
	public void generateItems() {
		System.out.println("Adding healing items to inventory.");
		this.items.add("healPotion");
		this.items.add("HealPotion");
	}
	
	/**
	 * Determines who goes first in combat using both fighters'
	 * speeds stats. Using the fighters' stats as the parameter,
	 * this method accesses and compares both speed stats and determines
	 * which value is higher. The higher value goes first. 
	 * @param fighterStats
	 * @param badStats
	 */
	public void whoseTurn(ArrayList<Integer>fighterStats, ArrayList<Integer>badStats) {
		if (fighterStats.indexOf(3) >= badStats.indexOf(3)) {
			System.out.println("The fighter goes first.");
			playersTurn(fighterStats, badStats);
		}
		else {
			System.out.println("The foe goes first.");
			foeTurn(fighterStats, badStats);
		}
	}
	
	/**
	 * Simulates what the player does on his turn, and his actions
	 * on the enemy.
	 * @param fighterStats
	 * @param badStats
	 */
	public void playersTurn(ArrayList<Integer>fighterStats, ArrayList<Integer>badStats) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("What will you do?");
		String option = scanner.nextLine();
		int goodHP = fighterStats.indexOf(0);
		int badHP = badStats.indexOf(0);
		int damage = (fighterStats.indexOf(1) - badStats.indexOf(2));
		if(option == "attack") {
			badHP = badHP - damage;
			System.out.println("You attacked. Foe took " + damage + "damage.");
			foeTurn(fighterStats, badStats);
		}
		
		if(option == "item") {
			if (this.items == null) {
				System.out.println("You have no items. What now?");
				playersTurn(fighterStats, badStats);
			}
			if (this.items.contains("healPotion")) {
				goodHP = goodHP + 50;
				System.out.println("You used a healing potion." + "HP now:" + goodHP);
				foeTurn(fighterStats, badStats);
			}
		}
		
		if (badHP == 0) {
			System.out.println("The foe is defeated. You win.");
			scanner.close();
		}
	}
	
	/**
	 * Simulates what the enemy does on his turn, and his actions
	 * on the opposing character.
	 * @param fighterStats
	 * @param badStats
	 */
	public void foeTurn(ArrayList<Integer>fighterStats, ArrayList<Integer>badStats) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("What will you do?");
		String option = scanner.nextLine();
		int userHP = badStats.indexOf(0);
		int userDef = badStats.indexOf(2);
		int targetHP = fighterStats.indexOf(0);
		int damage = (badStats.indexOf(1) - fighterStats.indexOf(2));
		if (option == "attack") {
			targetHP = targetHP - damage;
			System.out.println("The foe dealt " + damage + "damage to you.");
			playersTurn(fighterStats, badStats);
		}
		if (option == "bulk up") {
			System.out.println("The foe bulks up. Foe's defense increased.");
			userDef = userDef + 5;
			playersTurn(fighterStats, badStats);
		}
		if (targetHP == 0) {
			System.out.println("The character has been defeated. Game over");
			scanner.close();
		}
		
	}


}
