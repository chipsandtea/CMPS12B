// Sum.java
// Define a class for adding numbers.

public class Sum {
	// Keep track of running total
	private int value;
	
	public Sum(){
		value = 0;
	}
	
	public int getValue(){
		return value;
	}
	
	public void add(int v){
		value += v;
	}
	
	public void reset(){
		value = 0;
	}
}
