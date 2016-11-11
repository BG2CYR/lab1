package lab1.lab1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class calcTest {
	private static calc test;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		test=new calc(" 2*x +3*y+2-z+5*x*z");
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testSimplify() {
		test.simplify("x=1");
		assertEquals(test.showans(),"4+3*y+4*z");
	}

	@Test
	public void testDerivative() {
		test.derivative("x");
		assertEquals(test.showans(),"2+5*z");
	}

}
