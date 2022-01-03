import java.util.*;
import java.io.*;

public class CaveExplorer {
	private SaveFile theSaveFile;
	private ArrayList<String> theMaps;
	private ArrayList<Cave> theCaves;
	private Cave currentCave;
	private Cave finalCave;
	private Scanner playerInput;
	private String cutsceneToPlay;
	private String currentLabyrinthName;
	private String currentLabyrinthTxtFile;
	private boolean stillPlaying;
	
	public CaveExplorer(Scanner playerInput, SaveFile theSaveFile) {
		this.stillPlaying = true;
		
		this.theMaps = new ArrayList<String>();
		this.theMaps.add("testLabyrinth.txt");
		this.theMaps.add("testLabyrinth2.txt");
		this.theMaps.add("testLabyrinth3.txt");
		this.theMaps.add("textLabyrinth4.txt");
		
		
		try {
			this.playerInput = playerInput;
			this.theSaveFile = theSaveFile;
			this.theCaves = new ArrayList<Cave>();
			Scanner readMap = new Scanner(new File(this.theSaveFile.getLabyrinthTxtFile()));
			this.currentLabyrinthName = readMap.nextLine();
			this.currentLabyrinthTxtFile = readMap.nextLine();
			this.cutsceneToPlay = readMap.nextLine();
			while(readMap.hasNextLine()) {
				String x = readMap.nextLine();
				String[] theSplitString = x.split(",");
				ArrayList<String> holder = new ArrayList<String>();
				for(String theString : theSplitString) {
					holder.add(theString);
				}
				int ID = Integer.parseInt(holder.remove(0));
				String roomName = holder.remove(0);
				ArrayList<Integer> numHolder = new ArrayList<Integer>();
				for(String num : holder) {
					numHolder.add(Integer.parseInt(num));
				}
				Cave newCave = new Cave(ID,roomName,numHolder);
				this.theCaves.add(newCave);
				
			}
			
			int startingRoom = this.theSaveFile.getLabyrinthRoomNum();
			
			this.currentCave = this.theCaves.get(startingRoom);
			this.currentCave.markVisited();
			int finalRoomIndex = this.theCaves.size()-1;
			this.finalCave = this.theCaves.get(finalRoomIndex);
			readMap.close();
			
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found");
		}	
	}
	
	public boolean showLocation() throws FileNotFoundException {
		boolean isItOver = false;
		System.out.println("You are currently in: " + this.currentLabyrinthName);
		System.out.println("You are in " + this.currentCave.getName());
		if(this.currentCave.equals(this.finalCave) && this.currentLabyrinthName.equals("The Fortress of Thine Enemy")) {
			System.out.println("You have reached the end of the labyrinth and beaten the game.");
			CutscenePlayer.main(playerInput, this.theSaveFile, this.cutsceneToPlay);
			try {
				SaveFileManipulator.deleteSaveFile(this.theSaveFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			isItOver = true;
			return isItOver;
			//int theNum = CutscenePlayer.main(this.playerInput, this.theSaveFile,this.cutsceneToPlay);
			//System.out.println(theNum);
			//String newMap = this.theMaps.get(theNum);
			//this.changeLocation(newMap);
			//this.showLocation();
		}
		
		else if(this.currentCave.equals(this.finalCave)) {
			System.out.println("You have reached the end of the labyrinth.");
			int theNum = CutscenePlayer.main(this.playerInput, this.theSaveFile,this.cutsceneToPlay);
			String newMap = this.theMaps.get(theNum);
			this.changeLocation(newMap);
			this.showLocation();
			return isItOver;
		}
		
		else {
			for(int i=0;i<this.currentCave.getConnectingCaves().size();i++) {
				int theNum = i+1;
				int theIndex = this.currentCave.getConnectingCaves().get(i);
				String theName = this.theCaves.get(theIndex).getName();
				System.out.println(theNum + ". " + theName);
			}
			System.out.println("Press a number to go down that path. Press 0 to quit and save your progress");
			return isItOver;
		}
		
	}
	
	public void moveLocation(int num) {
		int theChoice = num-1;
		if (theChoice >= this.currentCave.getConnectingCaves().size()) {
			System.out.println("Invalid number choice" + "\n");
		}
		
		else {
			int battleChance = (int)Math.floor(Math.random() * 4);
			if(battleChance == 0) {
				System.out.println("You have encountered the invaders. Prepare to Fight");
				int result = combatDriverGo.main(this.playerInput, this.theSaveFile);
				if (result == 1) {
					int theIndex = this.currentCave.getConnectingCaves().get(theChoice);
					Cave targetCave = this.theCaves.get(theIndex);
					this.currentCave = targetCave;
					this.currentCave.markVisited();
					System.out.println("Moving in path " + num + "\n");
				}
				
				else if (result == 0) {
					this.gameOverHandler();
				}
			}
			
			
			
			else {
				int theIndex = this.currentCave.getConnectingCaves().get(theChoice);
				Cave targetCave = this.theCaves.get(theIndex);
				this.currentCave = targetCave;
				this.currentCave.markVisited();
				System.out.println("Moving in path " + num + "\n");
			}
		}
		
		
		
		
	}
	
	private void changeLocation(String newMapFile) throws FileNotFoundException {
		this.theCaves.clear();
		Scanner readMap = new Scanner(new File(newMapFile));
		this.currentLabyrinthName = readMap.nextLine();
		this.currentLabyrinthTxtFile = readMap.nextLine();
		this.cutsceneToPlay = readMap.nextLine();
		while(readMap.hasNextLine()) {
			String x = readMap.nextLine();
			String[] theSplitString = x.split(",");
			ArrayList<String> holder = new ArrayList<String>();
			for(String theString : theSplitString) {
				holder.add(theString);
			}
			int ID = Integer.parseInt(holder.remove(0));
			String roomName = holder.remove(0);
			ArrayList<Integer> numHolder = new ArrayList<Integer>();
			for(String num : holder) {
				numHolder.add(Integer.parseInt(num));
			}
			Cave newCave = new Cave(ID,roomName,numHolder);
			this.theCaves.add(newCave);
		}
		this.currentCave = this.theCaves.get(0);
		this.currentCave.markVisited();
		int finalRoomIndex = this.theCaves.size()-1;
		this.finalCave = this.theCaves.get(finalRoomIndex);
		readMap.close();
	}
	
	public void saveProgress() {
		this.theSaveFile.setLabyrinthName(this.currentLabyrinthName);
		this.theSaveFile.setLabyrinthRoomNum(this.currentCave.getCaveNum());
		this.theSaveFile.setLabyrinthTxtFile(this.currentLabyrinthTxtFile);
		try {
			SaveFileManipulator.saveToTxtFile(this.theSaveFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void gameOverHandler() {
		System.out.print("\n"+"\n");
		System.out.println("You have been defeated in battle. What would you like to do?");
		System.out.println("Press 1 to try again from the beginning of the labyrinth. Press 2 to quit playing. If you quit playing, you will restart at the beginning of the labyrinth.");
		int theChoice = this.playerInput.nextInt();
		if(theChoice == 1) {
			this.currentCave = this.theCaves.get(0);
			System.out.print("\n"+"\n");
		}
		
		else if(theChoice == 2) {
			this.currentCave = this.theCaves.get(0);
			this.theSaveFile.setLabyrinthName(this.currentLabyrinthName);
			this.theSaveFile.setLabyrinthRoomNum(this.currentCave.getCaveNum());
			this.theSaveFile.setLabyrinthTxtFile(this.currentLabyrinthTxtFile);
			try {
				SaveFileManipulator.saveToTxtFile(this.theSaveFile);
				System.out.println("Remember. You are our only hope.");
				this.notPlayingAnymore();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public boolean isStillPlaying() {
		return this.stillPlaying;
	}
	
	private void notPlayingAnymore() {
		this.stillPlaying = false;
	}
}
