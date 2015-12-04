
public class Option {
	//Remember tag = roomKey!!!
	private String tag;
	private String text;
	public Option(String optionText){
		text = optionText;
	}
	
	public void addTag(String tagText){
		tag = tagText;
	}
	
	public String getTag(){
		return tag;
	}
	
	public String toString(){
		return text;
	}
}
