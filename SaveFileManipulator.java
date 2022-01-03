import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Integer;
import java.lang.Math;

/**
 * Class that manipulates the data held within a save file
 * @author Julius Quilarto and Jonah Chun
 *
 */
public class SaveFileManipulator {
	
	/**
	 * Method that reads text file in and sets information for game
	 * @param someFile game file that will have its text read in
	 * @throws FileNotFoundException
	 */
	
	public static void readFileIn(SaveFile someFile) throws FileNotFoundException {
		Scanner saveFileReader = new Scanner(someFile.getFile());
		//SaveFileManipulator.readFileIn(someFile);
		//System.out.println("There's something here");
		//x.close();
		
		String aLine = saveFileReader.nextLine();
		//System.out.println(aLine);
		String[] theLine = aLine.split(" ");
		someFile.setFighterName(theLine[0]);
		ArrayList<Integer> fighterStats = new ArrayList<Integer>();
		for(int i=1; i<=8; i++) {
			fighterStats.add(Integer.parseInt(theLine[i]));
		}
		someFile.setFighterStats(fighterStats);
		
		aLine = saveFileReader.nextLine();
		//System.out.println(aLine);
		theLine = aLine.split(" ");
		someFile.setHealerName(theLine[0]);
		ArrayList<Integer> healerStats = new ArrayList<Integer>();
		for(int i=1; i<=8; i++) {
			healerStats.add(Integer.parseInt(theLine[i]));
		}
		someFile.setHealerStats(healerStats);
		
		
		aLine = saveFileReader.nextLine();
		//System.out.println(aLine);
		theLine = aLine.split(" ");
		someFile.setWizardName(theLine[0]);
		ArrayList<Integer> wizardStats = new ArrayList<Integer>();
		for(int i=1; i<=8; i++) {
			wizardStats.add(Integer.parseInt(theLine[i]));
		}
		someFile.setWizardStats(wizardStats);
		
		
		aLine = saveFileReader.nextLine();
		//System.out.println(aLine);
		theLine = aLine.split(" ");
		someFile.setRogueName(theLine[0]);
		ArrayList<Integer> rogueStats = new ArrayList<Integer>();
		for(int i=1; i<=8; i++) {
			rogueStats.add(Integer.parseInt(theLine[i]));
		}
		someFile.setRogueStats(rogueStats);
		
		String labyrinthName = saveFileReader.nextLine();
		someFile.setLabyrinthName(labyrinthName);
		int aNum = saveFileReader.nextInt();
		someFile.setLabyrinthRoomNum(aNum);
		String labyrinthTextFile = saveFileReader.next();
		someFile.setLabyrinthTxtFile(labyrinthTextFile);
		
		
		ArrayList<String> itemList = new ArrayList<String>();
		while(saveFileReader.hasNextLine()) {
			String toAdd = saveFileReader.nextLine();
			//itemList.add(saveFileReader.nextLine());
			if(toAdd.contentEquals("")) {
				continue;
			}
			itemList.add(toAdd);
		}
		someFile.setInventory(itemList);
		saveFileReader.close();
	}
	
	/**
	 * Method that will take the information stored in the game save file and
	 * store it in the corresponding text document.
	 * @param someFile game save file that has the data that will be recorded into
	 * a text document.
	 * @throws IOException
	 */
	
	public static void saveToTxtFile(SaveFile someFile) throws IOException {
		File targetFile = someFile.getFile();
		FileWriter fw = new FileWriter(targetFile);
		PrintWriter pw = new PrintWriter(fw);
		
		pw.print(someFile.getFighterName()+" ");
		ArrayList<Integer> fighterStats = someFile.getFighterStats();
		for(Integer num : fighterStats) {
			pw.print(num + " ");
		}
		pw.print("\n");
		
		pw.print(someFile.getHealerName()+" ");
		ArrayList<Integer> healerStats = someFile.getHealerStats();
		for(Integer num : healerStats) {
			pw.print(num + " ");
		}
		pw.print("\n");
		
		pw.print(someFile.getWizardName()+" ");
		ArrayList<Integer> wizardStats = someFile.getWizardStats();
		for(Integer num : wizardStats) {
			pw.print(num + " ");
		}
		pw.print("\n");
		
		pw.print(someFile.getRogueName()+" ");
		ArrayList<Integer> rogueStats = someFile.getRogueStats();
		for(Integer num : rogueStats) {
			pw.print(num + " ");
		}
		pw.print("\n");
		
		pw.print(someFile.getLabyrinthName() + "\n");
		pw.print(someFile.getLabyrinthRoomNum() + "\n");
		pw.print(someFile.getLabyrinthTxtFile() + "\n");
		
		for(String item : someFile.getInventory()) {
			pw.println(item);
		}
		
		
		pw.close();
	}
	
	/**
	 * Method that will write information when game is created
	 * @param someFile the savefile being targeted
	 * @throws IOException
	 */
	
	public static void writeToTxtFile(SaveFile someFile) throws IOException {
		File targetFile = someFile.getFile();
		FileWriter fw = new FileWriter(targetFile);
		PrintWriter pw = new PrintWriter(fw);
		
		pw.print(someFile.getFighterName()+" ");
		ArrayList<Integer> fighterStats = someFile.getFighterStats();
		for(Integer num : fighterStats) {
			pw.print(num + " ");
		}
		pw.print("\n");
		
		pw.print(someFile.getHealerName()+" ");
		ArrayList<Integer> healerStats = someFile.getHealerStats();
		for(Integer num : healerStats) {
			pw.print(num + " ");
		}
		pw.print("\n");
		
		pw.print(someFile.getWizardName()+" ");
		ArrayList<Integer> wizardStats = someFile.getWizardStats();
		for(Integer num : wizardStats) {
			pw.print(num + " ");
		}
		pw.print("\n");
		
		pw.print(someFile.getRogueName()+" ");
		ArrayList<Integer> rogueStats = someFile.getRogueStats();
		for(Integer num : rogueStats) {
			pw.print(num + " ");
		}
		pw.print("\n");
		
		pw.print(someFile.getLabyrinthName() + "\n");
		pw.print(someFile.getLabyrinthRoomNum() + "\n");
		pw.print(someFile.getLabyrinthTxtFile() + "\n");
		
		for(String item : someFile.getInventory()) {
			pw.println(item);
		}
		
		
		pw.close();
	}
	
	/**
	 * Method that will create a new game save file
	 * @param someFile the save file being targeted that the data will go to.
	 * @param fighterName name of the fighter character
	 * @param healerName name of the healer character
	 * @param wizardName name of the wizard character
	 * @param rogueName name of the rogue character
	 * @throws IOException
	 */

	public static void createSaveFile(SaveFile someFile, String fighterName, String healerName, String wizardName,
			String rogueName) throws IOException {
		// TODO Auto-generated method stub
		
		someFile.setFighterName(fighterName);
		ArrayList<Integer> fighterStats = new ArrayList<Integer>();
		fighterStats.add(20+(int)Math.floor(10+Math.random()*20));
		fighterStats.add(100);
		fighterStats.add(20+(int)Math.floor(10+Math.random()*20));
		fighterStats.add(10+(int)Math.floor(1+Math.random()*5));
		fighterStats.add(20+(int)Math.floor(10+Math.random()*20));
		fighterStats.add(10+(int)Math.floor(1+Math.random()*5));
		fighterStats.add(15+(int)Math.floor(5+Math.random()*8));
		fighterStats.add(15+(int)Math.floor(5+Math.random()*8));
		someFile.setFighterStats(fighterStats);
		
		someFile.setHealerName(healerName);
		ArrayList<Integer> healerStats = new ArrayList<Integer>();
		healerStats.add(10+(int)Math.floor(1+Math.random()*5));
		healerStats.add(100);
		healerStats.add(10+(int)Math.floor(1+Math.random()*5));
		healerStats.add(20+(int)Math.floor(10+Math.random()*20));
		healerStats.add(10+(int)Math.floor(1+Math.random()*5));
		healerStats.add(20+(int)Math.floor(10+Math.random()*20));
		healerStats.add(20+(int)Math.floor(10+Math.random()*20));
		healerStats.add(15+(int)Math.floor(5+Math.random()*8));
		someFile.setHealerStats(healerStats);
		
		someFile.setWizardName(wizardName);
		ArrayList<Integer> wizardStats = new ArrayList<Integer>();
		wizardStats.add(10+(int)Math.floor(1+Math.random()*5));
		wizardStats.add(100);
		wizardStats.add(10+(int)Math.floor(1+Math.random()*5));
		wizardStats.add(20+(int)Math.floor(10+Math.random()*20));
		wizardStats.add(10+(int)Math.floor(1+Math.random()*5));
		wizardStats.add(15+(int)Math.floor(5+Math.random()*8));
		wizardStats.add(20+(int)Math.floor(10+Math.random()*20));
		wizardStats.add(15+(int)Math.floor(5+Math.random()*8));
		someFile.setWizardStats(wizardStats);
		
		someFile.setRogueName(rogueName);
		ArrayList<Integer> rogueStats = new ArrayList<Integer>();
		rogueStats.add(15+(int)Math.floor(5+Math.random()*8));
		rogueStats.add(100);
		rogueStats.add(15+(int)Math.floor(5+Math.random()*8));
		rogueStats.add(10+(int)Math.floor(1+Math.random()*5));
		rogueStats.add(10+(int)Math.floor(1+Math.random()*5));
		rogueStats.add(15+(int)Math.floor(5+Math.random()*8));
		rogueStats.add(20+(int)Math.floor(10+Math.random()*20));
		rogueStats.add(20+(int)Math.floor(10+Math.random()*20));
		someFile.setRogueStats(rogueStats);
		
		someFile.setLabyrinthName("testLabyrinth");
		someFile.setLabyrinthRoomNum(0);
		someFile.setLabyrinthTxtFile("testLabyrinth.txt");
		
		ArrayList<String> newItems = new ArrayList<String>();
		newItems.add("Healing Potion");
		newItems.add("Attack Potion");
		someFile.setInventory(newItems);
		
		SaveFileManipulator.writeToTxtFile(someFile);
	}
	
	/**
	 * Method that will delete all information in the text file.
	 * @param someFile game save file that will have the data of its corresponding text file
	 * deleted
	 * @throws IOException
	 */
	
	public static void deleteSaveFile(SaveFile someFile) throws IOException {
		File targetFile = someFile.getFile();
		FileWriter fw = new FileWriter(targetFile);
		PrintWriter pw = new PrintWriter(fw);
		pw.print("");
		pw.close();
	}


}
