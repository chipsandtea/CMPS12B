// CalcTest.java
// Calc Testing file

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class CalcTest {

	private double DELTA = 5E-6;
	// Tests push method
	@Test
	public void pushTest(){
		Calc c = new Calc();
		c.push(10);
		c.push(20);
		assertEquals(2, c.depth());
	}
	
	// Tests pop method
	@Test
	public void popTest(){
		Calc c = new Calc();
		c.push(5);
		c.push(15);
		c.push(20);
		c.pop();
		c.pop();
		c.pop();
		assertEquals(0, c.depth());
	}
	
	// Tests peek method
	@Test
	public void peekTest(){
		Calc c = new Calc();
		c.push(5);
		c.push(10);
		//System.out.println(c.peek());
		assertEquals(10, c.peek(), DELTA);
	}
	
	// Tests addition method
	@Test
	public void addTest(){
		Calc c = new Calc();
		c.push(5);
		c.push(10);
		c.add();
		//System.out.println(c.peek());
		assertEquals(15, c.peek(), DELTA);
	}
	
	// Tests subtraction method
	@Test
	public void subtractTest(){
		Calc c = new Calc();
		c.push(5);
		c.push(10);
		c.subtract();
		//System.out.println(c.peek());
		assertEquals(5, c.peek(), DELTA);
	}
	
	// Tests multiplication method
	@Test
	public void multiplyTest(){
		Calc c = new Calc();
		c.push(5);
		c.push(5);
		c.multiply();
		//System.out.println(c.peek());
		assertEquals(25, c.peek(), DELTA);
	}
	
	// Tests division method
	@Test
	public void divideTest(){
		Calc c = new Calc();
		c.push(5);
		c.push(25);
		c.divide();
		//System.out.println(c.peek());
		assertEquals(5, c.peek(), DELTA);
	}
	
	// Tests exception handling
	@Test
	public void exceptionTest(){
		Calc c = new Calc();
		c.push(5);
		c.add();
		c.subtract();
		c.multiply();
		c.divide();
	}
	
	// Computes a compound expression
	@Test
	public void compoundExpressionTest(){
		Calc c = new Calc();
		c.push(10);
		c.push(5);
		c.subtract();
		c.push(25);
		c.divide();
		c.push(-1);
		c.multiply();
		assertEquals(5, c.peek(), DELTA);
	}
	
	// Tests the accuracy of a compound expression calculation midway.
	@Test
	public void compoundExpressionCheckTest(){
		Calc c = new Calc();
		c.push(10);
		c.push(5);
		c.subtract();
		assertEquals(1, c.depth());
		assertEquals(-5, c.peek(), DELTA);
		c.push(25);
		c.divide();
		c.push(-1);
		c.multiply();
		assertEquals(5, c.peek(), DELTA);
	}
	
	// Another exception test
	@Test
	public void secondExceptionTest(){
		Calc c = new Calc();
		c.push(5);
		c.push(10);
		c.push(20);
		c.divide();
		c.multiply();
		c.add();
	}
	
	// Logarithm test
	@Test
	public void logarithmTest(){
		Calc c = new Calc();
		c.push(10);
		c.log2();
		assertEquals(3.3219280948873626, c.peek(), DELTA);
	}
	
}
