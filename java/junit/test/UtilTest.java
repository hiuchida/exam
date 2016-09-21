package junit.test;

import junit.framework.TestCase;
import junit.Util;

public class UtilTest extends TestCase {
	public void testCase1() {
		assertFalse(Util.check("0"));
	}
	public void testCase2() {
		assertTrue(Util.check("1"));
	}
	public void testCase3() {
		assertTrue(Util.check("14"));
	}
	public void testCase4() {
		assertFalse(Util.check("15"));
	}
	public void testCase5() {
		assertFalse(Util.check("Abc"));
	}
	public void testCase6() {
		assertFalse(Util.check(""));
	}
}
