//Carson Hake
//Richard Bowen
//Alani Johnson



import static org.junit.Assert.*;

import org.junit.Test;

public class WeirdThingTest {

	@Test
	public void test() {
		
		assertEquals("fail",5, WeirdThing.multiply(5, 6));
	}
	
	@Test
	public void test2() {
		
		assertEquals("pass", "ab", WeirdThing.cat("a", "b"));
	}
	
	@Test
	public void test3() {
		
		assertEquals("pass", "ab", WeirdThing.cat("a", "b"));
	}
	
	@Test
	public void test4() {
		
		assertEquals("fail", "a", WeirdThing.cat("a", "b"));
	}
	

}
