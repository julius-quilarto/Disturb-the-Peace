import java.io.IOException;
import java.util.*;


public class theTester {

	public static SaveFile main(Scanner playerInput) throws IOException {
		// TODO Auto-generated method stub
		SaveFile someFile;
		try {
			System.out.println("Welcome to Defile the Peace: A Text-Based Role-Playing Game");
			System.out.println("This game incorporates 3 save files to save different infomration.");
			System.out.println("Enter the number 1, 2, or 3 to access that specific save file.");
			//Scanner playerInput = new Scanner(System.in);
			//SaveFile someFile;
			int theChoice = playerInput.nextInt();
			if (theChoice == 1) {
				someFile = new SaveFile("saveFile1.txt");
			}
			else if (theChoice == 2) {
				someFile = new SaveFile("saveFile2.txt");
			}
			else {
				someFile = new SaveFile("saveFile3.txt");
			}
			
			Scanner saveFileReader = new Scanner(someFile.getFile());
			
			if(saveFileReader.hasNextLine()) {
				SaveFileManipulator.readFileIn(someFile);
				
				System.out.print("Fighter: " + someFile.getFighterName()+" ");
				for (int i=0; i<someFile.getFighterStats().size(); i++) {
					System.out.print(someFile.getFighterStats().get(i)+" ");
				}
				System.out.print("\n");
				
				System.out.print("Healer: " + someFile.getHealerName()+" ");
				for (int i=0; i<someFile.getHealerStats().size(); i++) {
					System.out.print(someFile.getHealerStats().get(i)+" ");
				}
				System.out.print("\n");
				
				System.out.print("Wizard: " + someFile.getWizardName()+" ");
				for (int i=0; i<someFile.getWizardStats().size(); i++) {
					System.out.print(someFile.getWizardStats().get(i)+" ");
				}
				System.out.print("\n");
				
				System.out.print("Rogue: " + someFile.getRogueName()+" ");
				for (int i=0; i<someFile.getRogueStats().size(); i++) {
					System.out.print(someFile.getRogueStats().get(i)+" ");
				}
				System.out.print("\n");
				
				System.out.print("Labyrinth Name: " + someFile.getLabyrinthName());
				System.out.print("\n");
				System.out.print("Labyrinth Room: " + someFile.getLabyrinthRoomNum());
				System.out.print("\n");
				//System.out.print(someFile.getLabyrinthTxtFile());
				
				//System.out.print("\n");
				
				for(String item : someFile.getInventory()) {
					System.out.print(item + "\n");
					//System.out.println(someFile.getInventory().size());
				}
				
				System.out.print("Do you want to delete this save file and its data, or do you want to use this save file?"
						+ " Press 1 to delete the save file. Press 2 to use the save file.");
				theChoice = playerInput.nextInt();
				if(theChoice == 1) {
					SaveFileManipulator.deleteSaveFile(someFile);
					System.out.println("Save file and data deleted. We shall begin the story anew.");
					System.out.print("\n" + "\n");
					System.out.println("Wanted: Great Heroes");
					System.out.println("Our fair, peaceful kingdom has been attacked by villianous marauders. "
							+ "We desperately plea for the assistance of heroes in order to combat this threat"
							+ " of massive proportions. But who would rise to the challenge?");
					System.out.println("A warrior in peak physical condition. A master of combat and warfare. "
							+ "Please tell us your name (Enter the name of the fighter character now)");
					String fighterName = playerInput.next();
					System.out.println("A servant of the gods. A master of the healing arts. "
							+ "Please tell us your name (Enter the name of the healer character now)");
					String healerName = playerInput.next();
					System.out.println("A genius scholar. A master of the arcane arts. "
							+ "Please tell us your name (Enter the name of the wizard character now)");
					String wizardName = playerInput.next();
					System.out.println("Skilled and Dexterous. A master in stealth and subterfuge. "
							+ "Please tell us your name (Enter the name of the rogue character now)");
					String rogueName = playerInput.next();
					
					SaveFileManipulator.createSaveFile(someFile,fighterName,healerName,wizardName,rogueName);
					CutscenePlayer.main(playerInput, someFile, "testCutscene1.txt");
					saveFileReader.close();
					System.out.print("\n" + "\n");
					return someFile;
				}
				else {
					System.out.print("\n" + "\n");
					System.out.print("Where we last left off..." + "\n");
					saveFileReader.close();
					return someFile;
					
				}
				
				//playerInput.close();
				//CutscenePlayer.main(playerInput,someFile,"testCutscene.txt");
				//return someFile;
				
			}
			
			else {
				System.out.println("Wanted: Great Heroes");
				System.out.println("Our fair, peaceful kingdom has been attacked by villianous marauders. "
						+ "We desperately plea for the assistance of heroes in order to combat this threat"
						+ " of massive proportions. But who would rise to the challenge?");
				System.out.println("A warrior in peak physical condition. A master of combat and warfare. "
						+ "Please tell us your name (Enter the name of the fighter character now)");
				String fighterName = playerInput.next();
				System.out.println("A servant of the gods. A master of the healing arts."
						+ "Please tell us your name (Enter the name of the healer character now)");
				String healerName = playerInput.next();
				System.out.println("A genius scholar. A master of the arcane arts."
						+ "Please tell us your name (Enter the name of the wizard character now)");
				String wizardName = playerInput.next();
				System.out.println("Skilled and Dexterous. A master in stealth and subterfuge."
						+ "Please tell us your name (Enter the name of the rogue character now)");
				String rogueName = playerInput.next();
				
				SaveFileManipulator.createSaveFile(someFile,fighterName,healerName,wizardName,rogueName);
				CutscenePlayer.main(playerInput, someFile, "testCutscene1.txt");
				
				/*System.out.println(someFile.getFighterName());
				System.out.println(someFile.getHealerName());
				System.out.println(someFile.getWizardName());
				System.out.println(someFile.getRogueName());
				System.out.println(someFile.getInventory().size());
				*/
				//playerInput.close();
				saveFileReader.close();
				System.out.print("\n" + "\n");
				return someFile;
			}
		}
		
		catch(java.io.FileNotFoundException e) {
			System.out.println("FILE NOT FOUND");
			return someFile = null;
		}
		
		
		

	}

}
