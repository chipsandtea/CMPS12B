import java.util.*;
public class Room {
	
	private String roomKey;
	private ArrayList<String> roomDescription;
	private ArrayList<Option> roomOptions;
	
	public Room(String key){
		roomKey = key;
		roomDescription = new ArrayList<String>();
		roomOptions = new ArrayList<Option>();
		
		
	}
	
	public void addDescription(String description){
		roomDescription.add(description);
	}
	
	public void addOption(String optionText){
		roomOptions.add(new Option(optionText));
	}
	
	public Option getOption(String tag){
		return roomOptions.get(roomOptions.indexOf(tag));
	}
	
	public void addTag(String tagText){
		roomOptions.get(roomOptions.size()-1).addTag(tagText);
	}
}
