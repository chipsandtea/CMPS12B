// CalcTest.java

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class CalcTest {
	/*
	@Test
	public void pushTest(){
		Calc c = new Calc();
		c.push(10);
		c.push(20);
		assertEquals(2, c.depth());
	}
	
	@Test
	public void popTest(){
		Calc c = new Calc();
		c.push(5);
		c.push(15);
		c.push(20);
		System.out.println(c.pop());
		System.out.println(c.pop());
		System.out.println(c.pop());
		assertEquals(0, c.depth());
		System.out.println("\n\n");
	}
	
	@Test
	public void peekTest(){
		Calc c = new Calc();
		c.push(5);
		c.push(10);
		System.out.println(c.peek());
		c.pop();
		System.out.println(c.peek());
		assertEquals(1, c.depth());
		System.out.println("\n\n");
	}
	*/
	@Test
	public void addTest(){
		Calc c = new Calc();
		c.push(5);
		c.push(10);
		c.add();
		System.out.println(c.peek());
	}
	
}
