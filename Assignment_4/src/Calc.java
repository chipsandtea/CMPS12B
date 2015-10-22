import java.util.*;

public class Calc {

	int top;
	double[] stack;
	int max = 100;
	
	public Calc(){
		top = 0;
		stack = new double[max];
	}
	
	public double push(int key){
		stack[top] = key;
		top++;
		return stack[top];
	}
	
	public double pop(){
		return stack[--top];
	}
	
	public double peek(){
		return stack[top-1];
	}
	
	public void add(){
		stack[top-1] = stack[top] + stack[top-1];
		top--;
	}
	
	public void subtract(){
		stack[top-1] = stack[top]-stack[top-1];
		top--;
	}
	
	public void multiply(){
		stack[top-1] = stack[top] * stack[top-1];
		top--;
	}
	
	public void divide(){
		stack[top-1] = stack[top] / stack[top-1];
		top--;
	}
	
	public int depth(){
		return top;
	}
}