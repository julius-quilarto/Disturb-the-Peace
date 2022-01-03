import java.util.Scanner;
import java.io.File;

public class CutscenePlayer {

	public static int main(Scanner playerInput, SaveFile chosenSaveFile, String cutsceneName) throws java.io.FileNotFoundException {
		Scanner getCutscene = new Scanner(new File(cutsceneName));
		int theNumSelect = 0;
		//Scanner playerInput = new Scanner(System.in);
		SaveFile theSaveFile = chosenSaveFile;
		SaveFileManipulator.readFileIn(theSaveFile);
		while(getCutscene.hasNextLine()) {
			String theLine = getCutscene.nextLine();
			if(theLine.equals("Fighter")) {
				System.out.print(theSaveFile.getFighterName()+": ");
				System.out.println(getCutscene.nextLine());
				String theInput = playerInput.next();
			}
			
			else if(theLine.equals("Healer")) {
				System.out.print(theSaveFile.getHealerName()+": ");
				System.out.println(getCutscene.nextLine());
				String theInput = playerInput.next();
			}
			
			else if(theLine.equals("Wizard")) {
				System.out.print(theSaveFile.getWizardName()+": ");
				System.out.println(getCutscene.nextLine());
				String theInput = playerInput.next();
			}
			
			else if(theLine.equals("Rogue")) {
				System.out.print(theSaveFile.getRogueName()+": ");
				System.out.println(getCutscene.nextLine());
				String theInput = playerInput.next();
			}
			
			else if(theLine.equals("Choice3 Fighter")) {
				System.out.println("<You will be given 3 choices. Enter in the number to make your choice.>");
				String option1 = getCutscene.nextLine();
				String option2 = getCutscene.nextLine();
				String option3 = getCutscene.nextLine();
				System.out.println("1. "+option1);
				System.out.println("2. "+option2);
				System.out.println("3. "+option3);
				int theChoice = playerInput.nextInt();
				if(theChoice == 1) {
					System.out.println(theSaveFile.getFighterName()+": "+option1);
					theNumSelect = 1;
				}
				else if(theChoice == 2) {
					System.out.println(theSaveFile.getFighterName()+": "+option2);
					theNumSelect = 2;
				}
				else {
					System.out.println(theSaveFile.getFighterName()+": "+option3);
					theNumSelect = 3;
				}
				String theInput = playerInput.next();
				
			}
			
			else {
				System.out.println(theLine);
				//System.out.println(theSaveFile.getFighterName());
				String theInput = playerInput.next();
			}
			
		}
		System.out.print("\n" + "\n");
		getCutscene.close();
		return theNumSelect;
		//playerInput.close();
	}

}
