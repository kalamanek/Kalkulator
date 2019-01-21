package testKalkulatora;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import kalkulator.Kalkulator;

public class KalkulatorTest {
	Kalkulator kalkulator = new Kalkulator();

	
	@Test
	public void addTest() {
		assertEquals(5, kalkulator.add(-5, 10),10^(-10));
		assertEquals(-4, kalkulator.add(1, -5),10^(-10));
		assertEquals(-15, kalkulator.add(-5, -10),10^(-10));
		assertEquals(15, kalkulator.add(10,5),10^(-10));
    }
	@Test
    public void minusTest() {
        assertEquals(-15, kalkulator.minus(-5, 10),10^(-10));
        assertEquals(6, kalkulator.minus(1, -5),10^(-10));
        assertEquals(5, kalkulator.minus(-5, -10),10^(-10));
        assertEquals(5, kalkulator.minus(10,5),10^(-10));
    }

	@Test
    public void multipleTest() {
        assertEquals(-50, kalkulator.multiple(-5, 10),10^(-10));
        assertEquals(-5, kalkulator.multiple(1, -5),10^(-10));
        assertEquals(50, kalkulator.multiple(-5, -10),10^(-10));
        assertEquals(50, kalkulator.multiple(10,5),10^(-10));
    }

	@Test
    public void divideTest() {
        assertEquals(-5, kalkulator.divide(-50, 10),10^(-10));
        assertEquals(-2, kalkulator.divide(10, -5),10^(-10));
        assertEquals(5, kalkulator.divide(-50, -10),10^(-10));
        assertEquals(2, kalkulator.divide(10,5),10^(-10));
    }
	@Test(expected = IllegalArgumentException.class)
	public void divineExceptionTest(){
		kalkulator.divide(10,0);
	}

	@Test
	public void textEquationStructTest(){
		assertEquals(5, kalkulator.textEquationStruct("+ + +++").operationAmount);
		assertEquals(4, kalkulator.textEquationStruct("+ --+").operationAmount);
		assertEquals(2, kalkulator.textEquationStruct("+3213+").operationAmount);
		assertEquals(4, kalkulator.textEquationStruct("3123+2").charOperationPosition);
		assertEquals(5, kalkulator.textEquationStruct("+ + ++").charOperationPosition);
		assertEquals(0, kalkulator.textEquationStruct("+").charOperationPosition);
		assertEquals('+', kalkulator.textEquationStruct("3123312d+dasd").operationType);
		assertEquals('*', kalkulator.textEquationStruct("eqwe*123").operationType);
		assertEquals('/', kalkulator.textEquationStruct("3123/0").operationType);
	}
	
	@Test
	public void isEquationTypeOperateTest() {
		Assert.assertTrue( kalkulator.isEquationTypeOperate("11+11"));
		Assert.assertFalse( kalkulator.isEquationTypeOperate("11+11+11"));
		Assert.assertFalse( kalkulator.isEquationTypeOperate("11+-11"));
	}

}
