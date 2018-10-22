package TestKalkulatora;

import static org.junit.Assert.*;

import org.junit.Test;

public class KalkulatorTest {

	
	@Test
	public void addTest() {
	assertEquals(5, Kalkulator.add(-5, 10),10^(-10));
	assertEquals(-4, Kalkulator.add(1, -5),10^(-10));
	assertEquals(-15, Kalkulator.add(-5, -10),10^(-10));
	assertEquals(15, Kalkulator.add(10,5),10^(-10));
    }
	@Test
	    public void minusTest() {
	        assertEquals(-15, Kalkulator.minus(-5, 10),10^(-10));
	        assertEquals(6, Kalkulator.minus(1, -5),10^(-10));
	        assertEquals(5, Kalkulator.minus(-5, -10),10^(-10));
	        assertEquals(5, Kalkulator.minus(10,5),10^(-10));
	    }

	@Test
	    public void multipleTest() {
	        assertEquals(-50, Kalkulator.multiple(-5, 10),10^(-10));
	        assertEquals(-5, Kalkulator.multiple(1, -5),10^(-10));
	        assertEquals(50, Kalkulator.multiple(-5, -10),10^(-10));
	        assertEquals(50, Kalkulator.multiple(10,5),10^(-10));
	    }

	@Test
	    public void divideTest() {
	        assertEquals(-5, Kalkulator.divide(-50, 10),10^(-10));
	        assertEquals(-2, Kalkulator.divide(10, -5),10^(-10));
	        assertEquals(5, Kalkulator.divide(-50, -10),10^(-10));
	        assertEquals(2, Kalkulator.divide(10,5),10^(-10));
	    }
	@Test(expected = IllegalArgumentException.class)
		public void divineExceptionTest(){
			Kalkulator.divide(10,0);
		}
	
	@Test
		public void textEquationStructTest(){
		assertEquals(5, Kalkulator.textEquationStruct("+ + +++").first);
		assertEquals(4, Kalkulator.textEquationStruct("+ --+").first);
		assertEquals(2, Kalkulator.textEquationStruct("+3213+").first);
		assertEquals(4, Kalkulator.textEquationStruct("3123+2").second);
		assertEquals(5, Kalkulator.textEquationStruct("+ + ++").second);
		assertEquals(0, Kalkulator.textEquationStruct("+").second);
		assertEquals('+', Kalkulator.textEquationStruct("3123312d+dasd").third);
		assertEquals('*', Kalkulator.textEquationStruct("eqwe*123").third);
		assertEquals('/', Kalkulator.textEquationStruct("3123/0").third);
		
		
	}

}
