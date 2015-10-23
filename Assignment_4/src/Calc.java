// Calc.java
// Primitive RPN Calculator

import java.util.*;

public class Calc{

	int top;
	double[] stack;
	int max = 100;
	
	public Calc(){
		top = -1;
		stack = new double[max];
	}
	
	public double push(int key){
		top++;
		stack[top] = key;
		return stack[top];
	}
	
	public double pop(){
		return stack[top--];
	}
	
	public double peek(){
		return stack[top];
	}
	
	public void add(){
		try{
			stack[top-1] = stack[top] + stack[top-1];
			top--;
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Too few items to add!");
		}
		
	}
	
	public void subtract(){
		try{
			stack[top-1] = stack[top]-stack[top-1];
			top--;
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Too few items to subtract!");
		}
		
	}
	
	public void multiply(){
		try{
			stack[top-1] = stack[top] * stack[top-1];
			top--;
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Too few items to multiply!");
		}
		
	}
	
	public void divide(){
		try{
			stack[top-1] = stack[top] / stack[top-1];
			top--;
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Too few items to divide!");
		}
		
	}
	
	public void log2(){
		stack[top] = Math.log(stack[top])/Math.log(2);
	}
	
	public int depth(){
		return top+1;
	}
}
