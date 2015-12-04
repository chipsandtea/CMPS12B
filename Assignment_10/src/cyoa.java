import java.io.*;
import java.util.*;
public class cyoa {

	public static void main(String[] args) throws IOException{
		//loadAdventure(args[0]);
		testRoom();
	}
	
	public static void loadAdventure(String filename) throws IOException{
		//Adventure adv = new Adventure(filename);
		
		
	}
	
	
	public static void testRoom(){
		Room rm = new Room("testRoom");
		Scanner kb = new Scanner(System.in);
		
		//Tests adding descriptions
		rm.addDescription("Test Description 1");
		rm.addDescription("Test Description 2");
		
		//Tests adding Options
		rm.addOption("Test Option 1");
		//Tests adding Tags
		rm.addTag("option1");
		rm.addOption("Test Option 2");
		rm.addTag("option2");
		System.out.println(rm.toString());
		
		String selection = kb.next();
		
		//Tests option text retrieval
		System.out.println("[" + rm.findOptionText(selection.charAt(0)) + "]");
		
		//Tests tag retrieval
		System.out.println(rm.findOptionTag(selection.charAt(0)));
	}

}
