import java.util.*;
import java.io.*;

//Christopher Hsiao
//Assignment 2 - 10/13/2015
//Sorts and searches through a list of businesses for business phone numbers.
public class BusinessSearch {

	public static void main(String args[]) throws FileNotFoundException{
		try{
			args[0].equals(null);
		}catch(ArrayIndexOutOfBoundsException io){
			System.out.println("Usage: BusinessSearch businessDB");
			System.exit(0);
		}
		BufferedReader in = new BufferedReader(new FileReader(args[0]));
		
		String[] rawData;
		String[][] data;
		int size = 0;
		try {
			size = Integer.parseInt(in.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		rawData = readFile(in, size);
		data = parseData(rawData, size);
		mergeSort(data);
		
		Scanner kb = new Scanner(System.in);
		boolean keepGoing = true;
		int queries = 0;
		int failures = 0;
		String input = "";
		System.out.println("Type 'exit' to quit program.");
		while(keepGoing){
			input = kb.nextLine();
			if(input.equals("exit")){
				System.exit(0);
			}else{
				queries++;
				if(binarySearch(input, data).equals("NOT FOUND")){
					failures++;
				}
				System.out.println(binarySearch(input, data));
			}
		}
		
	}
	
	//Reads the input file and fills a 2D String array with the raw data.
	//Format: Bob's Pizza,(831)555-1212
	private static String[] readFile(BufferedReader input, int numOfB){
		String[] raw = new String[numOfB];
		for(int i = 0; i < numOfB; i++){
			try {
				raw[i] = input.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return raw;
	}
	
	//Parses through the read data and fills a 2D String array with the business name 
	//and its associated phone number.
	private static String[][] parseData(String[] raw, int numOfB){
		String[][] parsedData = new String[numOfB][2];
		for(int i = 0; i < numOfB; i++){
			int commaIndex = raw[i].indexOf(',');
			parsedData[i][0] = raw[i].substring(0, commaIndex);
			parsedData[i][1] = raw[i].substring(commaIndex+1);
			//System.out.println(parsedData[i][0] + " " + parsedData[i][1]);
		}
		return parsedData;
	}
	
	private static boolean beSwapped(String b1, String b2){
		b1 = b1.replaceAll("\\W", "");
		b1 = b1.toLowerCase();
		
		b2 = b2.replaceAll("\\W", "");
		b2 = b2.toLowerCase();
		
		//If it returns a positive integer, b1 comes after b2, and it needs to be swapped.
		if(b1.compareTo(b2) < 0){
			return true;
		}else{
			return false;
		}
	}
	
	private static String binarySearch(String business, String[][] data){
		int lower = 0;
		int upper = data.length-1;
		int current = (lower+upper)/2;
		
		while(lower <= upper){
			current = (lower+upper)/2;
			if(data[current][0].equals(business)){
				//System.out.println(data[current][1]);
				return data[current][1];
			}
			if(beSwapped(data[current][0], business)){
				lower = current+1;
			}else{
				upper = current-1;
			}
		}	
		return "NOT FOUND";
	}
	
	//Algorithm Credit to http://web.uvic.ca/~wenfeng/csc212A4.pdf
	private static String[][] mergeSort(String[][] data){
		String[][] left, right, result;
		if(data.length <= 1){
			return data;
		}else{
			int leftElements = data.length/2;
			int rightElements = leftElements;
			left = new String[leftElements][2];
			right = new String[rightElements][2];
			
			for(int i = 0; i < leftElements; i++){
				left[i][0] = data[i][0];
				left[i][1] = data[i][1];
			}
			
			for(int i = leftElements; i < data.length; i++){
				right[i - leftElements][0] = data[i][0];
				right[i - leftElements][1] = data[i][1];
			}
			
			left = mergeSort(left);
			right = mergeSort(right);
			
			int i = 0;
			int j = 0; 
			int k = 0;
			
			while(left.length != j && right.length != k){
				if(beSwapped(left[j][0], right[k][0])){
					data[i][0] = left[j][0];
					data[i][1] = left[j][1];
					i++;
					j++;
				}else{
					data[i] = right[k];
					i++;
					k++;
				}
			}
			
			while(left.length != j){
				data[i] = left[j];
				i++;
				j++;
			}
			
			while(right.length != k){
				data[i] = right[k];
				i++;
				k++;
			}
		}
		return data;
	}
	
	private static String[][] merge(String[][] left, String[][] right){
		String[][] merged = new String[left.length+right.length][2];
		for(int i = 0; i < left.length; i++){
			merged[i][0] = left[i][0];
			merged[i][1] = left[i][0];
		}
		for(int i = 0; i < right.length; i++){
			merged[i][0] = right[i][0];
			merged[i][1] = right[i][1];
		}
		return merged;
	}
}
