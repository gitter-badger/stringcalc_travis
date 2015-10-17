package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.Test;
import org.junit.*;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() throws Exception {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() throws Exception {
		assertEquals(1, Calculator.add("1"));
		assertEquals(2, Calculator.add("2"));
	}

	@Test
	public void testTwoNumbers() throws Exception {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
	public void testMultipleNumbers() throws Exception{
    		assertEquals(6, Calculator.add("1,2,3"));
	}

	@Test
	public void testMultipleNumbersEvenMore() throws Exception{
    		assertEquals(45, Calculator.add("1,2,3,4,5,6,7,8,9"));
	}

	@Test
	public void testMixedDelimeters() throws Exception{
    		assertEquals(6, Calculator.add("1\n2,3"));
    		assertEquals(6, Calculator.add("1\n2\n3"));
	}

	@Test
	public void testCustomDelimeter() throws Exception{
    		assertEquals(3, Calculator.add("//;\n1;2"));
	}


	@Test
	public void testNegativeNumber() throws Exception{
		try{
			Calculator.add("-1,2");
		}
		catch (Exception e) {
			assertEquals("Negatives not allowed: -1",e.getMessage()); 
		}        
	}

	@Test
	public void testMultipleNegativeNumber() throws Exception{
		try{
			Calculator.add("2,-4,3,-5");
		}
		catch (Exception e) {
			assertEquals("Negatives not allowed: -4,-5",e.getMessage()); 
		}        
	}

	@Test
	public void testLongCustomDelimeter() throws Exception{
    		assertEquals(6, Calculator.add("//[***]\n1***2***3"));
	}

	@Test
	public void testLargeNumbers() throws Exception{
    		assertEquals(2, Calculator.add("1000,2"));
	}

	@Test
	public void testMultipleCustomDelimeter() throws Exception{
    		assertEquals(6, Calculator.add("//[*][%]\n1*2%3"));
	}

	@Test
	public void testMultipleLongCustomDelimeter() throws Exception{
    		assertEquals(6, Calculator.add("//[*******][%%%%%]\n1*******2%%%%%3"));
	}




}
