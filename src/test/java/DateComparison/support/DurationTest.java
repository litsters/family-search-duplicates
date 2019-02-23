package DateComparison.support;

import static org.junit.Assert.*;

import org.junit.Test;


public class DurationTest {	
	@Test
	public void testDurationIntIntInt() {		
		//Invalid Input
		try {
			new Duration(Duration.MAX_DURATION_YEAR + 1, 2, 3);
			fail(JUNIT_FAIL);
		} catch(AssertionError e){checkForFailure(e);}	
		
		try {
			new Duration(2000, -1, 10);
			fail(JUNIT_FAIL);
		} catch(AssertionError e){checkForFailure(e);}

		try {
			new Duration(1, 2, -1);
			fail(JUNIT_FAIL);
		} catch(AssertionError e){checkForFailure(e);}
		
		//Valid Inputs
		new Duration(0, 0, 0);
		new Duration(1850, 12, 17);
		new Duration(10, 0, 31);
		new Duration(1850, 300, 1001);
		new Duration(0, 0, 1);
		new Duration(0, 0, 4);
		new Duration(0, 0, 11);
		new Duration(0, 11, 0);
		new Duration(0, 10, 0);
		new Duration(0, 1, 0);
		new Duration(1, 0, 0);
		new Duration(2018, 0, 0);
		new Duration(Duration.MAX_DURATION_YEAR, 0, 0);
		new Duration(1, 3, 10);
		new Duration(5, 5, 11);
	}
	
	@Test
	public void testDurationIntIntInt_Precondition() {
		//True results
		assertTrue(Duration.DurationIntIntInt_Precondition(0, 0, 0));
		assertTrue(Duration.DurationIntIntInt_Precondition(0, 0, 1));
		assertTrue(Duration.DurationIntIntInt_Precondition(0, 0, 27));
		assertTrue(Duration.DurationIntIntInt_Precondition(0, 0, 28));
		assertTrue(Duration.DurationIntIntInt_Precondition(0, 0, 29));
		assertTrue(Duration.DurationIntIntInt_Precondition(0, 0, 30));
		assertTrue(Duration.DurationIntIntInt_Precondition(0, 0, 31));
		assertTrue(Duration.DurationIntIntInt_Precondition(0, 0, 32));
		assertTrue(Duration.DurationIntIntInt_Precondition(0, 0, 321));
		assertTrue(Duration.DurationIntIntInt_Precondition(0, 0, Integer.MAX_VALUE));
		assertTrue(Duration.DurationIntIntInt_Precondition(0, 1, 0));
		assertTrue(Duration.DurationIntIntInt_Precondition(0, 10, 0));
		assertTrue(Duration.DurationIntIntInt_Precondition(0, 12, 0));
		assertTrue(Duration.DurationIntIntInt_Precondition(0, 13, 0));
		assertTrue(Duration.DurationIntIntInt_Precondition(0, 772, 0));
		assertTrue(Duration.DurationIntIntInt_Precondition(0, Integer.MAX_VALUE, 0));
		assertTrue(Duration.DurationIntIntInt_Precondition(1, 0, 0));
		assertTrue(Duration.DurationIntIntInt_Precondition(2, 0, 0));
		assertTrue(Duration.DurationIntIntInt_Precondition(2018, 0, 0));
		assertTrue(Duration.DurationIntIntInt_Precondition(Duration.MAX_DURATION_YEAR - 1, 0, 0));
		assertTrue(Duration.DurationIntIntInt_Precondition(Duration.MAX_DURATION_YEAR, 0, 0));
		assertTrue(Duration.DurationIntIntInt_Precondition(Duration.MAX_DURATION_YEAR, Integer.MAX_VALUE, Integer.MAX_VALUE));
		assertTrue(Duration.DurationIntIntInt_Precondition(2018, 1, 1));
		assertTrue(Duration.DurationIntIntInt_Precondition(1999, 12, 1));
		assertTrue(Duration.DurationIntIntInt_Precondition(1802, 13, 1));
		assertTrue(Duration.DurationIntIntInt_Precondition(802, 202, 1));
		assertTrue(Duration.DurationIntIntInt_Precondition(1821, 5, 2));
		assertTrue(Duration.DurationIntIntInt_Precondition(2020, 10, 10));
		assertTrue(Duration.DurationIntIntInt_Precondition(2001, 12, 30));
		assertTrue(Duration.DurationIntIntInt_Precondition(2001, 12, 31));
		assertTrue(Duration.DurationIntIntInt_Precondition(2001, 12, 32));
		assertTrue(Duration.DurationIntIntInt_Precondition(2001, 12, 50));
		
		//False results
		assertFalse(Duration.DurationIntIntInt_Precondition(-1, 0, 0));
		assertFalse(Duration.DurationIntIntInt_Precondition(0, -1, 0));
		assertFalse(Duration.DurationIntIntInt_Precondition(0, 0, -1));
		assertFalse(Duration.DurationIntIntInt_Precondition(-1, -1, -1));
		assertFalse(Duration.DurationIntIntInt_Precondition(-1, -1, 0));
		assertFalse(Duration.DurationIntIntInt_Precondition(0, -1, -1));
		assertFalse(Duration.DurationIntIntInt_Precondition(-1, 0, -1));
		assertFalse(Duration.DurationIntIntInt_Precondition(Duration.MAX_DURATION_YEAR + 1, 0, 0));
	}

	@Test
	public void testDurationIntInt() {		
		//Invalid Input
		try {
			new Duration(-1, 1);
			fail(JUNIT_FAIL);
		} catch(AssertionError e){checkForFailure(e);}
		
		try {
			new Duration(Duration.MAX_DURATION_YEAR + 1, 2);
			fail(JUNIT_FAIL);
		} catch(AssertionError e){checkForFailure(e);}	
		
		try {
			new Duration(2000, -1);
			fail(JUNIT_FAIL);
		} catch(AssertionError e){checkForFailure(e);}

		
		//Valid Inputs		
		new Duration(1850, 12);
		new Duration(0, 0);
		new Duration(0, 1);
		new Duration(0, 2);
		new Duration(0, 7);
		new Duration(0, 10);
		new Duration(0, 11);
		new Duration(5, 6);
		new Duration(3, 0);
		new Duration(11, 0);
		new Duration(11, 1);
		new Duration(8, 2);
		new Duration(4, 7);
		new Duration(2, 10);
		new Duration(1, 11);
		new Duration(Duration.MAX_DURATION_YEAR, 11);
	}
	
	@Test
	public void testDurationIntInt_Precondition() {
		//True results
		assertTrue(Duration.DurationIntInt_Precondition(0, 1));
		assertTrue(Duration.DurationIntInt_Precondition(0, 10));
		assertTrue(Duration.DurationIntInt_Precondition(0, 12));
		assertTrue(Duration.DurationIntInt_Precondition(0, 13));
		assertTrue(Duration.DurationIntInt_Precondition(0, 772));
		assertTrue(Duration.DurationIntInt_Precondition(0, Integer.MAX_VALUE));
		assertTrue(Duration.DurationIntInt_Precondition(1, 0));
		assertTrue(Duration.DurationIntInt_Precondition(2, 0));
		assertTrue(Duration.DurationIntInt_Precondition(2018, 0));
		assertTrue(Duration.DurationIntInt_Precondition(Duration.MAX_DURATION_YEAR - 1, 0));
		assertTrue(Duration.DurationIntInt_Precondition(Duration.MAX_DURATION_YEAR, 0));
		assertTrue(Duration.DurationIntInt_Precondition(Duration.MAX_DURATION_YEAR, Integer.MAX_VALUE));
		assertTrue(Duration.DurationIntInt_Precondition(2018, 1));
		assertTrue(Duration.DurationIntInt_Precondition(1999, 12));
		assertTrue(Duration.DurationIntInt_Precondition(1802, 13));
		assertTrue(Duration.DurationIntInt_Precondition(802, 202));
		
		//False results
		assertFalse(Duration.DurationIntInt_Precondition(-1, 0));
		assertFalse(Duration.DurationIntInt_Precondition(0, -1));
		assertFalse(Duration.DurationIntInt_Precondition(-1, -1));
		assertFalse(Duration.DurationIntInt_Precondition(Duration.MAX_DURATION_YEAR + 1, 0));
	}

	@Test
	public void testDurationInt() {		
		//Invalid Input
		try {
			new Duration(-1);
			fail(JUNIT_FAIL);
		} catch(AssertionError e){checkForFailure(e);}
		
		try {
			new Duration(Duration.MAX_DURATION_YEAR + 1);
			fail(JUNIT_FAIL);
		} catch(AssertionError e){checkForFailure(e);}
		
		//Valid Inputs
		new Duration(0);
		new Duration(1);
		new Duration(5);
		new Duration(Duration.MAX_DURATION_YEAR);
		new Duration(Duration.MAX_DURATION_YEAR - 1);
	}
	
	@Test
	public void testDurationInt_Precondition() {
		//True results
		assertTrue(Duration.DurationInt_Precondition(0));
		assertTrue(Duration.DurationInt_Precondition(1));
		assertTrue(Duration.DurationInt_Precondition(2));
		assertTrue(Duration.DurationInt_Precondition(2018));
		assertTrue(Duration.DurationInt_Precondition(Duration.MAX_DURATION_YEAR - 1));
		assertTrue(Duration.DurationInt_Precondition(Duration.MAX_DURATION_YEAR));
		
		//False results
		assertFalse(Duration.DurationInt_Precondition(-1));
		assertFalse(Duration.DurationInt_Precondition(Duration.MAX_DURATION_YEAR + 1));
	}

	@Test
	public void testDuration() {
		new Duration();
	}
	
	@Test
	public void testDuration_Precondition() {
		//True results
		assertTrue(Duration.Duration_Precondition());
		
		//False results
		//None
	}

	@Test
	public void testGetYears() {
		new Duration (1, 2, 3).getYears();
	}
	
	@Test
	public void testGetYears_Precondition() {
		//True results
		assertTrue(new Duration (100, 100, 100).getYears_Precondition());
		
		//False results
		//None
	}

	@Test
	public void testGetMonths() {
		new Duration (1, 8, 3).getMonths();
	}
	
	@Test
	public void testGetMonths_Precondition() {
		//True results
		assertTrue(new Duration(1999, 12, 32).getMonths_Precondition());
		
		//False results
		//None
	}

	@Test
	public void testGetDays() {
		new Duration (1, 2, 30).getDays();
	}
	
	@Test
	public void testGetDays_Precondition() {
		//True results
		assertTrue(new Duration(1010, 3, 15).getDays_Precondition());
		
		//False results
		//None
	}
	
	@Test
	public void testGetPrecision() {
		new Duration().getPrecision();
		new Duration(0).getPrecision();		
		new Duration(0, 0).getPrecision();		
		new Duration(0, 0, 0).getPrecision();		
		new Duration(5).getPrecision();		
		new Duration(5, 0).getPrecision();		
		new Duration(5, 0, 0).getPrecision();		
		new Duration(3, 2).getPrecision();		
		new Duration(3, 2, 0).getPrecision();		
		new Duration(4, 2, 1).getPrecision();
	}

	@Test
	public void testGetPrecision_Precondition() {
		//True results
		assertTrue(new Duration(2002, 20, 1).getPrecision_Precondition());
		
		//False results
		//None
	}
	
	@Test
	public void testToString() {
		new Duration().toString();
		new Duration(0).toString();
		new Duration(0, 0).toString();
		new Duration(0, 0, 0).toString();
		new Duration(Duration.MAX_DURATION_YEAR, 0, 0).toString();
		new Duration(Duration.MAX_DURATION_YEAR, 0).toString();
		new Duration(Duration.MAX_DURATION_YEAR).toString();
		new Duration(2001).toString();
		new Duration(1850, 0).toString();
		new Duration(1850, 1).toString();
		new Duration(1850, 4).toString();
		new Duration(1850, 12).toString();
		new Duration(1850, 22).toString();
		new Duration(Duration.MAX_DURATION_YEAR,7, 0).toString();
		new Duration(1, 7, 1).toString();
		new Duration(101, 11, 2).toString();
		new Duration(201, 9, 17).toString();
		new Duration(2010, 4, 30).toString();
		new Duration(2010, 4, 31).toString();
		new Duration(2010, 4, 131).toString();
	}

	@Test
	public void testToString_Precondition() {
		//True results
		assertTrue(new Duration(2002, 20, 1).toString_Precondition());
		
		//False results
		//None
	}
	
	@Test
	public void testCoverage() {
		Duration duration = new Duration(2, 5);
		assertTrue(duration.getYears() == 2);
		assertTrue(duration.getMonths() == 5);
		assertTrue(duration.getDays() == 0);
		
		assertFalse(duration.toString().equals("5/2/0"));
		
	}

	private static final String JUNIT_FAIL = "JUnit Failure:";
	
	private void checkForFailure(AssertionError e) {
		String s = e.getMessage();
		if(s != null && s.startsWith(JUNIT_FAIL)) {
			fail();
		} else {
			assertTrue(true); //pass();
		}
	}
}
