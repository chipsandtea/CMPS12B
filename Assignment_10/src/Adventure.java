import java.util.*;
import java.io.*;
public class Adventure {

	
	//Will use LinkedList implementation with possibility of multiple pointers per Room node
	Room currentRoom;
	Room firstRoom; //For restarting
	Room prevRoom; //Needed for z command (undo previous turn)
	boolean haveWon; //Will attempt to implement by running game via while loop
	
	public Adventure(String filename) throws IOException{
		parseAdventureFile(filename);
		prevRoom = null;
		
	}
	
	public void play(){
		Scanner kboard = new Scanner(System.in);
		while(!haveWon){
			playTurn(kboard);
		}
	}
	
	private void playTurn(Scanner kb){
		System.out.println(currentRoom.toString());
		String choice = kb.nextLine();
	}
	
	private void parseAdventureFile(String filename) throws IOException{
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			
			while(true){
				String line = reader.readLine();
				
				if(line == null){
					break;
				}
				
				switch(parseFileCommand(line.charAt(0))){
				case 1: makeRoom(line.substring(2)); break;
				case 2: setDescription(line.substring(2)); break;
				case 3: addOption(line.substring(2)); break;
				case 4: setTag(line.substring(2)); break;
				default: System.out.println("Invalid command!");
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Invalid file name!");
			e.printStackTrace();
		}
	}
	
	private int parseFileCommand(char key){
		switch(key){
		case 'r': return 1;
		case 'd': return 2;
		case 'o': return 3;
		case 't': return 4;
		default: return -1;
		}
	}
	
	private int parseUserCommand(char key){
		switch(key){
		case 'r': return 1;
		case 'q': return 2;
		case 'y': return 3;
		case 'z': return 4;
		default: return -1;
		}
	}
	
	private void resetGame(){
		currentRoom = firstRoom;
		
	}
	
	private void makeRoom(String key){
		Room rm = new Room(key);
		//INSERT rm INTO DATA STRUCTURE BUT IDK WAT TO USE FML
		currentRoom = rm;
	}
	
	//Adds DESCRIPTION to latest ROOM generated
	private void setDescription(String description){
		currentRoom.addDescription(description);
	}
	
	//Adds OPTION to latest ROOM generated
	private void addOption(String optionText){
		currentRoom.addOption(optionText);
	}
	
	//Adds TAG to latest OPTION parsed
	private void setTag(String tagText){
		currentRoom.addTag(tagText);
	}
}
