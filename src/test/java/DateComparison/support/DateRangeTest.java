package DateComparison.support;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;


public class DateRangeTest {
	//Pre-condition for every test is that assertions have been enabled.
	
//	@Test
//	public void testCoverage() {
//		DateRange dateRange1 = new DateRange(1950);
//		DateRange dateRange2 = new DateRange(1960);
//		Duration duration = new Duration(5, 0, 0);
//		assertTrue(dateRange1.notSameAs(dateRange2, duration) == 1.0d);
//		
//		assertFalse(dateRange1.equals(null));
//		
//		DateRange dateRange3 = new DateRange(1950, 1, 1, 1960, 12, 31);
//		assertFalse(dateRange3.equals(dateRange2));
//		
//		assertFalse(dateRange1.equals(dateRange3));
//		
//		dateRange1 = new DateRange(1950,1);
//		dateRange2 = new DateRange(1950,1,25, 1950, 2, 3);
//		assertTrue(dateRange1.sameAs(dateRange2, new Duration(0,0,10)) == 1.0d);		
//	}

	@Test
	public void testDateRange() {
		DateRange dateRange = new DateRange();
		assertTrue(dateRange.getRange() == 1);
	}

	@Test
	public void testDateRangeIntDuration() {
		DateRange dateRange;
		YearMonthDay minYMD;
		YearMonthDay maxYMD;
		
		//Invalid inputs
		try {
			dateRange = new DateRange(0);
			fail(JUNIT_FAIL);
		}catch(AssertionError e){checkForFailure(e);}
		
		try {
			dateRange = new DateRange(YearMonthDay.MIN_YEAR - 1);
			fail(JUNIT_FAIL);
		}catch(AssertionError e){checkForFailure(e);}
		
		try {
			dateRange = new DateRange(YearMonthDay.MAX_YEAR + 1);
			fail(JUNIT_FAIL);
		}catch(AssertionError e){checkForFailure(e);}
		
		try {
			dateRange = new DateRange(1951, Duration.ONE_DAY, Duration.ONE_MONTH, Duration.ONE_YEAR);
			fail(JUNIT_FAIL);
		}catch(AssertionError e){checkForFailure(e);}
		
		try {
			dateRange = new DateRange(YearMonthDay.MIN_YEAR, Duration.ONE_DAY);
			fail(JUNIT_FAIL);
		}catch(AssertionError e){checkForFailure(e);}
		
		try {
			dateRange = new DateRange(YearMonthDay.MAX_YEAR, Duration.ONE_DAY);
			fail(JUNIT_FAIL);
		}catch(AssertionError e){checkForFailure(e);}
		
		//Valid Inputs
		dateRange = new DateRange(1);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 1 && minYMD.getMonth() == 1 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 1 && maxYMD.getMonth() == 12 && maxYMD.getDay() == 31 &&
				   dateRange.getRange() == 365);
		
		dateRange = new DateRange(2);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 2 && minYMD.getMonth() == 1 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 2 && maxYMD.getMonth() == 12 && maxYMD.getDay() == 31 &&
				   dateRange.getRange() == 365);
		
		dateRange = new DateRange(4);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 4 && minYMD.getMonth() == 1 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 4 && maxYMD.getMonth() == 12 && maxYMD.getDay() == 31 &&
				   dateRange.getRange() == 366);
		
		dateRange = new DateRange(-1);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == -1 && minYMD.getMonth() == 1 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == -1 && maxYMD.getMonth() == 12 && maxYMD.getDay() == 31 &&
				   dateRange.getRange() == 366);
		
		dateRange = new DateRange(-2);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == -2 && minYMD.getMonth() == 1 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == -2 && maxYMD.getMonth() == 12 && maxYMD.getDay() == 31 &&
				   dateRange.getRange() == 365);
		
		dateRange = new DateRange(-4);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == -4 && minYMD.getMonth() == 1 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == -4 && maxYMD.getMonth() == 12 && maxYMD.getDay() == 31 &&
				   dateRange.getRange() == 365);
		
		dateRange = new DateRange(-5);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == -5 && minYMD.getMonth() == 1 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == -5 && maxYMD.getMonth() == 12 && maxYMD.getDay() == 31 &&
				   dateRange.getRange() == 366);
		
		dateRange = new DateRange(-6);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == -6 && minYMD.getMonth() == 1 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == -6 && maxYMD.getMonth() == 12 && maxYMD.getDay() == 31 &&
				   dateRange.getRange() == 365);
		
		dateRange = new DateRange(-62);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == -62 && minYMD.getMonth() == 1 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == -62 && maxYMD.getMonth() == 12 && maxYMD.getDay() == 31 &&
				   dateRange.getRange() == 365);
		
		dateRange = new DateRange(-100);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == -100 && minYMD.getMonth() == 1 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == -100 && maxYMD.getMonth() == 12 && maxYMD.getDay() == 31 &&
				   dateRange.getRange() == 365);
		
		dateRange = new DateRange(-101);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == -101 && minYMD.getMonth() == 1 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == -101 && maxYMD.getMonth() == 12 && maxYMD.getDay() == 31 &&
				   dateRange.getRange() == 365);
		
		dateRange = new DateRange(-102);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == -102 && minYMD.getMonth() == 1 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == -102 && maxYMD.getMonth() == 12 && maxYMD.getDay() == 31 &&
				   dateRange.getRange() == 365);
		
		dateRange = new DateRange(-400);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == -400 && minYMD.getMonth() == 1 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == -400 && maxYMD.getMonth() == 12 && maxYMD.getDay() == 31 &&
				   dateRange.getRange() == 365);
		
		dateRange = new DateRange(-401);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == -401 && minYMD.getMonth() == 1 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == -401 && maxYMD.getMonth() == 12 && maxYMD.getDay() == 31 &&
				   dateRange.getRange() == 366);
		
		dateRange = new DateRange(-402);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == -402 && minYMD.getMonth() == 1 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == -402 && maxYMD.getMonth() == 12 && maxYMD.getDay() == 31 &&
				   dateRange.getRange() == 365);
		
		dateRange = new DateRange(-3201);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == -3201 && minYMD.getMonth() == 1 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == -3201 && maxYMD.getMonth() == 12 && maxYMD.getDay() == 31 &&
				   dateRange.getRange() == 366);
		
		dateRange = new DateRange(-247);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == -247 && minYMD.getMonth() == 1 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == -247 && maxYMD.getMonth() == 12 && maxYMD.getDay() == 31 &&
				   dateRange.getRange() == 365);
		
		dateRange = new DateRange(4, Duration.ONE_DAY);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 3 && minYMD.getMonth() == 12 && minYMD.getDay() == 31 &&
				   maxYMD.getYear() == 5 && maxYMD.getMonth() == 1 && maxYMD.getDay() == 1 &&
				   dateRange.getRange() == 368);
		
		dateRange = new DateRange(1, Duration.ONE_DAY);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == -1 && minYMD.getMonth() == 12 && minYMD.getDay() == 31 &&
				   maxYMD.getYear() == 2 && maxYMD.getMonth() == 1 && maxYMD.getDay() == 1 &&
				   dateRange.getRange() == 367);
		
		dateRange = new DateRange(-1, Duration.ONE_DAY);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == -2 && minYMD.getMonth() == 12 && minYMD.getDay() == 31 &&
				   maxYMD.getYear() == 1 && maxYMD.getMonth() == 1 && maxYMD.getDay() == 1 &&
				   dateRange.getRange() == 368);
		
		dateRange = new DateRange(-100, Duration.ONE_MONTH);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == -101 && minYMD.getMonth() == 12 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == -99 && maxYMD.getMonth() == 1 && maxYMD.getDay() == 31 &&
				   dateRange.getRange() == 427);
		
		dateRange = new DateRange(100, Duration.ONE_YEAR);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 99 && minYMD.getMonth() == 1 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 101 && maxYMD.getMonth() == 12 && maxYMD.getDay() == 31 &&
				   dateRange.getRange() == 1095);
		
		dateRange = new DateRange(1905, new Duration(0, 1, 0));
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 1904 && minYMD.getMonth() == 12 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 1906 && maxYMD.getMonth() == 1 && maxYMD.getDay() == 31 &&
				   dateRange.getRange() == 427);
		
		dateRange = new DateRange(1905, new Duration(1, 1, 1));
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 1903 && minYMD.getMonth() == 11 && minYMD.getDay() == 30 &&
				   maxYMD.getYear() == 1907 && maxYMD.getMonth() == 2 && maxYMD.getDay() == 1 &&
				   dateRange.getRange() == 1160);
		
		dateRange = new DateRange(1905, new Duration(2, 20, 40));
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 1901 && minYMD.getMonth() == 3 && minYMD.getDay() == 22 &&
				   maxYMD.getYear() == 1909 && maxYMD.getMonth() == 10 && maxYMD.getDay() == 10 &&
				   dateRange.getRange() == 3125);
		
		dateRange = new DateRange(-1905, new Duration(2, 20, 40));
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == -1909 && minYMD.getMonth() == 3 && minYMD.getDay() == 22 &&
				   maxYMD.getYear() == -1901 && maxYMD.getMonth() == 10 && maxYMD.getDay() == 10 &&
				   dateRange.getRange() == 3124);
		
		dateRange = new DateRange(1965, Duration.ONE_DAY, Duration.ONE_WEEK);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 1964 && minYMD.getMonth() == 12 && minYMD.getDay() == 31 &&
				   maxYMD.getYear() == 1966 && maxYMD.getMonth() == 1 && maxYMD.getDay() == 7 &&
				   dateRange.getRange() == 373);
		
		dateRange = new DateRange(YearMonthDay.MAX_YEAR);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == YearMonthDay.MAX_YEAR &&
				   		minYMD.getMonth() == YearMonthDay.JANUARY &&
				   		minYMD.getDay() == YearMonthDay.FIRST_DAY_OF_ANY_MONTH &&
				   maxYMD.getYear() == YearMonthDay.MAX_YEAR &&
				   		maxYMD.getMonth() == YearMonthDay.MAX_MONTH_OF_MAX_YEAR &&
				   		maxYMD.getDay() == YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR &&
				   dateRange.getRange() == 280);
		
		dateRange = new DateRange(YearMonthDay.MIN_YEAR);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == YearMonthDay.MIN_YEAR &&
				   		minYMD.getMonth() == YearMonthDay.MIN_MONTH_OF_MIN_YEAR &&
				   		minYMD.getDay() == YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR &&
				   maxYMD.getYear() == YearMonthDay.MIN_YEAR &&
				   		maxYMD.getMonth() == YearMonthDay.DECEMBER &&
				   		maxYMD.getDay() == YearMonthDay.LAST_DAY_OF_DECEMBER &&
				   dateRange.getRange() == 37);
		
		dateRange = new DateRange(YearMonthDay.MAX_YEAR, Duration.ONE_DAY, Duration.ZERO_DURATION);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == YearMonthDay.MAX_YEAR - 1 &&
				   		minYMD.getMonth() == YearMonthDay.DECEMBER &&
				   		minYMD.getDay() == YearMonthDay.LAST_DAY_OF_DECEMBER &&
				   maxYMD.getYear() == YearMonthDay.MAX_YEAR &&
				   		maxYMD.getMonth() == YearMonthDay.MAX_MONTH_OF_MAX_YEAR &&
				   		maxYMD.getDay() == YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR &&
				   dateRange.getRange() == 281);
		
		dateRange = new DateRange(YearMonthDay.MIN_YEAR, Duration.ZERO_DURATION, Duration.ONE_DAY);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == YearMonthDay.MIN_YEAR &&
				   		minYMD.getMonth() == YearMonthDay.MIN_MONTH_OF_MIN_YEAR &&
				   		minYMD.getDay() == YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR &&
				   maxYMD.getYear() == YearMonthDay.MIN_YEAR + 1 &&
				   		maxYMD.getMonth() == YearMonthDay.JANUARY &&
				   		maxYMD.getDay() == YearMonthDay.FIRST_DAY_OF_ANY_MONTH &&
				   dateRange.getRange() == 38);
	}
	
	@Test
	public void testDateRangeIntIntDuration() {
		DateRange dateRange;
		YearMonthDay minYMD;
		YearMonthDay maxYMD;
		
		//Invalid inputs
		try {
			dateRange = new DateRange(0, 1);
			fail(JUNIT_FAIL);
		}catch(AssertionError e){checkForFailure(e);}
		
		try {
			dateRange = new DateRange(2018, -1);
			fail(JUNIT_FAIL);
		}catch(AssertionError e){checkForFailure(e);}
		
		try {
			dateRange = new DateRange(2018, -11);
			fail(JUNIT_FAIL);
		}catch(AssertionError e){checkForFailure(e);}
		
		try {
			dateRange = new DateRange(2018, 0);
			fail(JUNIT_FAIL);
		}catch(AssertionError e){checkForFailure(e);}
		
		try {
			dateRange = new DateRange(2018, 13);
			fail(JUNIT_FAIL);
		}catch(AssertionError e){checkForFailure(e);}
		
		try {
			dateRange = new DateRange(2018, 101);
			fail(JUNIT_FAIL);
		}catch(AssertionError e){checkForFailure(e);}
		
		try {
			dateRange = new DateRange(YearMonthDay.MIN_YEAR - 1, 1);
			fail(JUNIT_FAIL);
		}catch(AssertionError e){checkForFailure(e);}
		
		try {
			dateRange = new DateRange(YearMonthDay.MIN_YEAR, YearMonthDay.MIN_MONTH_OF_MIN_YEAR - 1);
			fail(JUNIT_FAIL);
		}catch(AssertionError e){checkForFailure(e);}
		
		try {
			dateRange = new DateRange(YearMonthDay.MIN_YEAR, YearMonthDay.MIN_MONTH_OF_MIN_YEAR, Duration.ONE_DAY);
			fail(JUNIT_FAIL);
		}catch(AssertionError e){checkForFailure(e);}
		
		try {
			dateRange = new DateRange(YearMonthDay.MAX_YEAR, YearMonthDay.MAX_MONTH_OF_MAX_YEAR + 1);
			fail(JUNIT_FAIL);
		}catch(AssertionError e){checkForFailure(e);}
		
		try {
			dateRange = new DateRange(YearMonthDay.MAX_YEAR, YearMonthDay.MAX_MONTH_OF_MAX_YEAR, Duration.ONE_DAY);
			fail(JUNIT_FAIL);
		}catch(AssertionError e){
			checkForFailure(e);
		}
		
		//Test Valid Inputs
		dateRange = new DateRange(1, 1);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 1 && minYMD.getMonth() == 1 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 1 && maxYMD.getMonth() == 1 && maxYMD.getDay() == 31 &&
				   dateRange.getRange() == 31);
		
		dateRange = new DateRange(1, 2);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 1 && minYMD.getMonth() == 2 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 1 && maxYMD.getMonth() == 2 && maxYMD.getDay() == 28 &&
				   dateRange.getRange() == 28);
		
		dateRange = new DateRange(1996, 2);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 1996 && minYMD.getMonth() == 2 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 1996 && maxYMD.getMonth() == 2 && maxYMD.getDay() == 29 &&
				   dateRange.getRange() == 29);
		
		dateRange = new DateRange(2000, 2);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 2000 && minYMD.getMonth() == 2 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 2000 && maxYMD.getMonth() == 2 && maxYMD.getDay() == 29 &&
				   dateRange.getRange() == 29);
		
		dateRange = new DateRange(4, 2);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 4 && minYMD.getMonth() == 2 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 4 && maxYMD.getMonth() == 2 && maxYMD.getDay() == 29 &&
				   dateRange.getRange() == 29);
		
		dateRange = new DateRange(1, 3);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 1 && minYMD.getMonth() == 3 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 1 && maxYMD.getMonth() == 3 && maxYMD.getDay() == 31 &&
				   dateRange.getRange() == 31);
		
		dateRange = new DateRange(1, 4);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 1 && minYMD.getMonth() == 4 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 1 && maxYMD.getMonth() == 4 && maxYMD.getDay() == 30 &&
				   dateRange.getRange() == 30);
		
		dateRange = new DateRange(1, 5);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 1 && minYMD.getMonth() == 5 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 1 && maxYMD.getMonth() == 5 && maxYMD.getDay() == 31 &&
				   dateRange.getRange() == 31);
		
		dateRange = new DateRange(1, 6);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 1 && minYMD.getMonth() == 6 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 1 && maxYMD.getMonth() == 6 && maxYMD.getDay() == 30 &&
				   dateRange.getRange() == 30);
		
		dateRange = new DateRange(1, 7);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 1 && minYMD.getMonth() == 7 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 1 && maxYMD.getMonth() == 7 && maxYMD.getDay() == 31 &&
				   dateRange.getRange() == 31);
		
		dateRange = new DateRange(1, 8);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 1 && minYMD.getMonth() == 8 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 1 && maxYMD.getMonth() == 8 && maxYMD.getDay() == 31 &&
				   dateRange.getRange() == 31);
		
		dateRange = new DateRange(1, 9);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 1 && minYMD.getMonth() == 9 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 1 && maxYMD.getMonth() == 9 && maxYMD.getDay() == 30 &&
				   dateRange.getRange() == 30);
		
		dateRange = new DateRange(1, 10);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 1 && minYMD.getMonth() == 10 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 1 && maxYMD.getMonth() == 10 && maxYMD.getDay() == 31 &&
				   dateRange.getRange() == 31);
		
		dateRange = new DateRange(1, 11);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 1 && minYMD.getMonth() == 11 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 1 && maxYMD.getMonth() == 11 && maxYMD.getDay() == 30 &&
				   dateRange.getRange() == 30);
		
		dateRange = new DateRange(1, 12);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 1 && minYMD.getMonth() == 12 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 1 && maxYMD.getMonth() == 12 && maxYMD.getDay() == 31 &&
				   dateRange.getRange() == 31);
		
		dateRange = new DateRange(2016, 1);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 2016 && minYMD.getMonth() == 1 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 2016 && maxYMD.getMonth() == 1 && maxYMD.getDay() == 31 &&
				   dateRange.getRange() == 31);
		
		dateRange = new DateRange(2016, 2);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 2016 && minYMD.getMonth() == 2 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 2016 && maxYMD.getMonth() == 2 && maxYMD.getDay() == 29 &&
				   dateRange.getRange() == 29);
		
		dateRange = new DateRange(2016, 3);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 2016 && minYMD.getMonth() == 3 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 2016 && maxYMD.getMonth() == 3 && maxYMD.getDay() == 31 &&
				   dateRange.getRange() == 31);
		
		dateRange = new DateRange(2000, 2);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 2000 && minYMD.getMonth() == 2 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 2000 && maxYMD.getMonth() == 2 && maxYMD.getDay() == 29 &&
				   dateRange.getRange() == 29);
		
		dateRange = new DateRange(-1, 2);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == -1 && minYMD.getMonth() == 2 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == -1 && maxYMD.getMonth() == 2 && maxYMD.getDay() == 29 &&
				   dateRange.getRange() == 29);
		
		dateRange = new DateRange(-4, 2);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == -4 && minYMD.getMonth() == 2 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == -4 && maxYMD.getMonth() == 2 && maxYMD.getDay() == 28 &&
				   dateRange.getRange() == 28);
		
		dateRange = new DateRange(2015, 2, Duration.ONE_YEAR);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 2014 && minYMD.getMonth() == 2 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 2016 && maxYMD.getMonth() == 2 && maxYMD.getDay() == 28 &&
				   dateRange.getRange() == 758);
		
		Duration duration = new Duration(1, 1, 0);
		dateRange = new DateRange(2015, 2, duration);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 2014 && minYMD.getMonth() == 1 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 2016 && maxYMD.getMonth() == 3 && maxYMD.getDay() == 28 &&
				   dateRange.getRange() == 818);
		
		duration = new Duration(1, 1, 1);
		dateRange = new DateRange(2015, 2, duration);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 2013 && minYMD.getMonth() == 12 && minYMD.getDay() == 31 &&
				   maxYMD.getYear() == 2016 && maxYMD.getMonth() == 3 && maxYMD.getDay() == 29 &&
				   dateRange.getRange() == 820);
		
		dateRange = new DateRange(2015, 2, Duration.ONE_YEAR);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 2014 && minYMD.getMonth() == 2 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 2016 && maxYMD.getMonth() == 2 && maxYMD.getDay() == 28 &&
				   dateRange.getRange() == 758);
		
		dateRange = new DateRange(-10, 2);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == -10 && minYMD.getMonth() == 2 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == -10 && maxYMD.getMonth() == 2 && maxYMD.getDay() == 28 &&
				   dateRange.getRange() == 28);
		
		dateRange = new DateRange(-10, 2, Duration.ONE_YEAR);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == -11 && minYMD.getMonth() == 2 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == -9 && maxYMD.getMonth() == 2 && maxYMD.getDay() == 28 &&
				   dateRange.getRange() == 758);
		
		duration = new Duration(1, 1, 0);
		dateRange = new DateRange(-10, 2, duration);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == -11 && minYMD.getMonth() == 1 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == -9 && maxYMD.getMonth() == 3 && maxYMD.getDay() == 28 &&
				   dateRange.getRange() == 818);
		
		duration = new Duration(1, 1, 1);
		dateRange = new DateRange(-10, 2, duration);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == -12 && minYMD.getMonth() == 12 && minYMD.getDay() == 31 &&
				   maxYMD.getYear() == -9 && maxYMD.getMonth() == 3 && maxYMD.getDay() == 29 &&
				   dateRange.getRange() == 820);
		
		dateRange = new DateRange(-10, 3, Duration.ONE_MONTH, Duration.ONE_YEAR);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == -10 && minYMD.getMonth() == 2 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == -9 && maxYMD.getMonth() == 3 && maxYMD.getDay() == 31 &&
				   dateRange.getRange() == 425);
		
		dateRange = new DateRange(YearMonthDay.MAX_YEAR, YearMonthDay.MAX_MONTH_OF_MAX_YEAR);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == YearMonthDay.MAX_YEAR &&
				   		minYMD.getMonth() ==  YearMonthDay.MAX_MONTH_OF_MAX_YEAR &&
				   		minYMD.getDay() == YearMonthDay.FIRST_DAY_OF_ANY_MONTH &&
				   maxYMD.getYear() == YearMonthDay.MAX_YEAR &&
				   		maxYMD.getMonth() == YearMonthDay.MAX_MONTH_OF_MAX_YEAR &&
				   		maxYMD.getDay() == YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR &&
				   dateRange.getRange() == YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR);
		
		dateRange = new DateRange(YearMonthDay.MAX_YEAR, YearMonthDay.MAX_MONTH_OF_MAX_YEAR, Duration.ONE_DAY, Duration.ZERO_DURATION);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == YearMonthDay.MAX_YEAR &&
				   		minYMD.getMonth() ==  YearMonthDay.MAX_MONTH_OF_MAX_YEAR - 1 &&
				   		minYMD.getDay() == YearMonthDay.getLastDayOf(YearMonthDay.MAX_MONTH_OF_MAX_YEAR - 1, YearMonthDay.MAX_YEAR) &&
				   maxYMD.getYear() == YearMonthDay.MAX_YEAR &&
				   		maxYMD.getMonth() == YearMonthDay.MAX_MONTH_OF_MAX_YEAR &&
				   		maxYMD.getDay() == YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR &&
				   dateRange.getRange() == YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR + 1);
		
		dateRange = new DateRange(YearMonthDay.MIN_YEAR, YearMonthDay.MIN_MONTH_OF_MIN_YEAR);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == YearMonthDay.MIN_YEAR &&
				   		minYMD.getMonth() ==  YearMonthDay.MIN_MONTH_OF_MIN_YEAR &&
				   		minYMD.getDay() == YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR &&
				   maxYMD.getYear() == YearMonthDay.MIN_YEAR &&
				   		maxYMD.getMonth() == YearMonthDay.MIN_MONTH_OF_MIN_YEAR &&
				   		maxYMD.getDay() == YearMonthDay.getLastDayOf(YearMonthDay.MIN_MONTH_OF_MIN_YEAR,
				   				                                     YearMonthDay.MIN_YEAR) &&
				   dateRange.getRange() == 6);
		
		dateRange = new DateRange(YearMonthDay.MIN_YEAR, YearMonthDay.MIN_MONTH_OF_MIN_YEAR, Duration.ZERO_DURATION, Duration.ONE_DAY);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == YearMonthDay.MIN_YEAR &&
				   		minYMD.getMonth() ==  YearMonthDay.MIN_MONTH_OF_MIN_YEAR &&
				   		minYMD.getDay() == YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR &&
				   maxYMD.getYear() == YearMonthDay.MIN_YEAR &&
				   		maxYMD.getMonth() == YearMonthDay.MIN_MONTH_OF_MIN_YEAR + 1 &&
				   		maxYMD.getDay() == YearMonthDay.FIRST_DAY_OF_ANY_MONTH &&
				   dateRange.getRange() == 7);
	}
	
	@Test
	public void testDateRangeIntIntIntDuration() {
		DateRange dateRange;
		YearMonthDay minYMD;
		YearMonthDay maxYMD;
		
		//Invalid inputs
		try {
			dateRange = new DateRange(0, 1, 1);
			fail(JUNIT_FAIL);
		}catch(AssertionError e){checkForFailure(e);}
		
		try {
			dateRange = new DateRange(2018, 0, 1);
			fail(JUNIT_FAIL);
		}catch(AssertionError e){checkForFailure(e);}
		
		try {
			dateRange = new DateRange(2018, -1, 1);
			fail(JUNIT_FAIL);
		}catch(AssertionError e){checkForFailure(e);}
		
		try {
			dateRange = new DateRange(2018, 6, 0);
			fail(JUNIT_FAIL);
		}catch(AssertionError e){checkForFailure(e);}
		
		try {
			dateRange = new DateRange(2018, 7, -1);
			fail(JUNIT_FAIL);
		}catch(AssertionError e){checkForFailure(e);}
		
		try {
			dateRange = new DateRange(2018, 8, -1000);
			fail(JUNIT_FAIL);
		}catch(AssertionError e){checkForFailure(e);}
		
		try {
			dateRange = new DateRange(2018, -11, 1);
			fail(JUNIT_FAIL);
		}catch(AssertionError e){checkForFailure(e);}
		
		try {
			dateRange = new DateRange(2018, 13, 22);
			fail(JUNIT_FAIL);
		}catch(AssertionError e){checkForFailure(e);}
		
		try {
			dateRange = new DateRange(2018, 101, 14);
			fail(JUNIT_FAIL);
		}catch(AssertionError e){checkForFailure(e);}
		
		try {
			dateRange = new DateRange(YearMonthDay.MIN_YEAR - 1, 1, 1);
			fail(JUNIT_FAIL);
		}catch(AssertionError e){checkForFailure(e);}
		
		try {
			dateRange = new DateRange(YearMonthDay.MIN_YEAR, YearMonthDay.MIN_MONTH_OF_MIN_YEAR - 1, 1);
			fail(JUNIT_FAIL);
		}catch(AssertionError e){checkForFailure(e);}
		
		try {
			dateRange = new DateRange(YearMonthDay.MIN_YEAR, YearMonthDay.MIN_MONTH_OF_MIN_YEAR, YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR - 1);
			fail(JUNIT_FAIL);
		}catch(AssertionError e){checkForFailure(e);}
		
		try {
			dateRange = new DateRange(YearMonthDay.MAX_YEAR + 1, 12, 31);
			fail(JUNIT_FAIL);
		}catch(AssertionError e){checkForFailure(e);}
		
		try {
			dateRange = new DateRange(YearMonthDay.MAX_YEAR, YearMonthDay.MAX_MONTH_OF_MAX_YEAR + 1, 25);
			fail(JUNIT_FAIL);
		}catch(AssertionError e){checkForFailure(e);}
		
		try {
			dateRange = new DateRange(YearMonthDay.MAX_YEAR, YearMonthDay.MAX_MONTH_OF_MAX_YEAR, YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR + 1);
			fail(JUNIT_FAIL);
		}catch(AssertionError e){checkForFailure(e);}
		
		//Valid Test Cases
		dateRange = new DateRange(2015, 7, 1);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 2015 && minYMD.getMonth() == 7 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 2015 && maxYMD.getMonth() == 7 && maxYMD.getDay() == 1 &&
				   dateRange.getRange() == 1);
		
		dateRange = new DateRange(2015, 1, 1);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 2015 && minYMD.getMonth() == 1 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 2015 && maxYMD.getMonth() == 1 && maxYMD.getDay() == 1 &&
				   dateRange.getRange() == 1);
		
		dateRange = new DateRange(2015, 1, 31);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 2015 && minYMD.getMonth() == 1 && minYMD.getDay() == 31 &&
				   maxYMD.getYear() == 2015 && maxYMD.getMonth() == 1 && maxYMD.getDay() == 31 &&
				   dateRange.getRange() == 1);
		
		dateRange = new DateRange(2015, 2, 1);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 2015 && minYMD.getMonth() == 2 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 2015 && maxYMD.getMonth() == 2 && maxYMD.getDay() == 1 &&
				   dateRange.getRange() == 1);
		
		dateRange = new DateRange(2015, 2, 28);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 2015 && minYMD.getMonth() == 2 && minYMD.getDay() == 28 &&
				   maxYMD.getYear() == 2015 && maxYMD.getMonth() == 2 && maxYMD.getDay() == 28 &&
				   dateRange.getRange() == 1);
		
		dateRange = new DateRange(2016, 2, 29);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 2016 && minYMD.getMonth() == 2 && minYMD.getDay() == 29 &&
				   maxYMD.getYear() == 2016 && maxYMD.getMonth() == 2 && maxYMD.getDay() == 29 &&
				   dateRange.getRange() == 1);
		
		dateRange = new DateRange(2015, 3, 1);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 2015 && minYMD.getMonth() == 3 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 2015 && maxYMD.getMonth() == 3 && maxYMD.getDay() == 1 &&
				   dateRange.getRange() == 1);
		
		dateRange = new DateRange(2015, 3, 31);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 2015 && minYMD.getMonth() == 3 && minYMD.getDay() == 31 &&
				   maxYMD.getYear() == 2015 && maxYMD.getMonth() == 3 && maxYMD.getDay() == 31 &&
				   dateRange.getRange() == 1);
		
		dateRange = new DateRange(2015, 4, 1);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 2015 && minYMD.getMonth() == 4 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 2015 && maxYMD.getMonth() == 4 && maxYMD.getDay() == 1 &&
				   dateRange.getRange() == 1);
		
		dateRange = new DateRange(2015, 4, 30);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 2015 && minYMD.getMonth() == 4 && minYMD.getDay() == 30 &&
				   maxYMD.getYear() == 2015 && maxYMD.getMonth() == 4 && maxYMD.getDay() == 30 &&
				   dateRange.getRange() == 1);
		
		dateRange = new DateRange(2015, 6, 1);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 2015 && minYMD.getMonth() == 6 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 2015 && maxYMD.getMonth() == 6 && maxYMD.getDay() == 1 &&
				   dateRange.getRange() == 1);
		
		dateRange = new DateRange(2015, 6, 30);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 2015 && minYMD.getMonth() == 6 && minYMD.getDay() == 30 &&
				   maxYMD.getYear() == 2015 && maxYMD.getMonth() == 6 && maxYMD.getDay() == 30 &&
				   dateRange.getRange() == 1);
		
		dateRange = new DateRange(2015, 7, 1);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 2015 && minYMD.getMonth() == 7 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 2015 && maxYMD.getMonth() == 7 && maxYMD.getDay() == 1 &&
				   dateRange.getRange() == 1);
		
		dateRange = new DateRange(2015, 7, 31);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 2015 && minYMD.getMonth() == 7 && minYMD.getDay() == 31 &&
				   maxYMD.getYear() == 2015 && maxYMD.getMonth() == 7 && maxYMD.getDay() == 31 &&
				   dateRange.getRange() == 1);
		
		dateRange = new DateRange(2015, 5, 1);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 2015 && minYMD.getMonth() == 5 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 2015 && maxYMD.getMonth() == 5 && maxYMD.getDay() == 1 &&
				   dateRange.getRange() == 1);
		
		dateRange = new DateRange(2015, 5, 31);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 2015 && minYMD.getMonth() == 5 && minYMD.getDay() == 31 &&
				   maxYMD.getYear() == 2015 && maxYMD.getMonth() == 5 && maxYMD.getDay() == 31 &&
				   dateRange.getRange() == 1);
		
		dateRange = new DateRange(2015, 8, 1);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 2015 && minYMD.getMonth() == 8 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 2015 && maxYMD.getMonth() == 8 && maxYMD.getDay() == 1 &&
				   dateRange.getRange() == 1);
		
		dateRange = new DateRange(2015, 8, 31);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 2015 && minYMD.getMonth() == 8 && minYMD.getDay() == 31 &&
				   maxYMD.getYear() == 2015 && maxYMD.getMonth() == 8 && maxYMD.getDay() == 31 &&
				   dateRange.getRange() == 1);
		
		dateRange = new DateRange(2015, 9, 1);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 2015 && minYMD.getMonth() == 9 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 2015 && maxYMD.getMonth() == 9 && maxYMD.getDay() == 1 &&
				   dateRange.getRange() == 1);
		
		dateRange = new DateRange(2015, 9, 30);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 2015 && minYMD.getMonth() == 9 && minYMD.getDay() == 30 &&
				   maxYMD.getYear() == 2015 && maxYMD.getMonth() == 9 && maxYMD.getDay() == 30 &&
				   dateRange.getRange() == 1);
		
		dateRange = new DateRange(2015, 10, 1);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 2015 && minYMD.getMonth() == 10 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 2015 && maxYMD.getMonth() == 10 && maxYMD.getDay() == 1 &&
				   dateRange.getRange() == 1);
		
		dateRange = new DateRange(2015, 10, 31);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 2015 && minYMD.getMonth() == 10 && minYMD.getDay() == 31 &&
				   maxYMD.getYear() == 2015 && maxYMD.getMonth() == 10 && maxYMD.getDay() == 31 &&
				   dateRange.getRange() == 1);
		
		dateRange = new DateRange(2015, 11, 1);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 2015 && minYMD.getMonth() == 11 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 2015 && maxYMD.getMonth() == 11 && maxYMD.getDay() == 1 &&
				   dateRange.getRange() == 1);
		
		dateRange = new DateRange(2015, 11, 30);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 2015 && minYMD.getMonth() == 11 && minYMD.getDay() == 30 &&
				   maxYMD.getYear() == 2015 && maxYMD.getMonth() == 11 && maxYMD.getDay() == 30 &&
				   dateRange.getRange() == 1);
		
		dateRange = new DateRange(2015, 12, 1);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 2015 && minYMD.getMonth() == 12 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == 2015 && maxYMD.getMonth() == 12 && maxYMD.getDay() == 1 &&
				   dateRange.getRange() == 1);
		
		dateRange = new DateRange(2015, 12, 31);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 2015 && minYMD.getMonth() == 12 && minYMD.getDay() == 31 &&
				   maxYMD.getYear() == 2015 && maxYMD.getMonth() == 12 && maxYMD.getDay() == 31 &&
				   dateRange.getRange() == 1);
		
		dateRange = new DateRange(-2001, 2, 1);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == -2001 && minYMD.getMonth() == 2 && minYMD.getDay() == 1 &&
				   maxYMD.getYear() == -2001 && maxYMD.getMonth() == 2 && maxYMD.getDay() == 1 &&
				   dateRange.getRange() == 1);
		
		dateRange = new DateRange(-2001, 2, 29);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == -2001 && minYMD.getMonth() == 2 && minYMD.getDay() == 29 &&
				   maxYMD.getYear() == -2001 && maxYMD.getMonth() == 2 && maxYMD.getDay() == 29 &&
				   dateRange.getRange() == 1);
		
		dateRange = new DateRange(1954, 7, 27, Duration.FIVE_YEARS);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == 1949 && minYMD.getMonth() == 7 && minYMD.getDay() == 27 &&
				   maxYMD.getYear() == 1959 && maxYMD.getMonth() == 7 && maxYMD.getDay() == 27 &&
				   dateRange.getRange() == 3653);
		
		dateRange = new DateRange(-1954, 7, 27, Duration.ONE_MONTH);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == -1954 && minYMD.getMonth() == 6 && minYMD.getDay() == 27 &&
				   maxYMD.getYear() == -1954 && maxYMD.getMonth() == 8 && maxYMD.getDay() == 27 &&
				   dateRange.getRange() == 62);
		
		dateRange = new DateRange(-1954, 7, 27, Duration.ONE_YEAR, Duration.ONE_WEEK);
		minYMD = dateRange.getMinYearMonthDay();
		maxYMD = dateRange.getMaxYearMonthDay();
		assertTrue(dateRange.toString(),
				   minYMD.getYear() == -1955 && minYMD.getMonth() == 7 && minYMD.getDay() == 27 &&
				   maxYMD.getYear() == -1954 && maxYMD.getMonth() == 8 && maxYMD.getDay() == 3 &&
				   dateRange.getRange() == 373);
	}

	@Test
	public void testDateRangeDateRange() {
		//Testing Invalid Inputs
		try{
			DateRange dateRange = new DateRange((DateRange)null);
			assertFalse("Error in testDateRangeDateRange(null):: dateRange cannot be null", false);
		} catch(AssertionError e) {assertTrue(true);}
		
		//Testing Valid Inputs
		DateRange dateRange1 = new DateRange();
		DateRange dateRange2 = new DateRange(1,1);
		DateRange dateRange3 = new DateRange(5, 7);
		DateRange dateRange4 = new DateRange(6,10,2);
		
		DateRange dateRange = new DateRange(dateRange1);
		assertTrue("The maxDays, maxDays, and ranges of dateRange1 and dateRange must be equal",
				   dateRange1.getMinJulianDay() == dateRange.getMinJulianDay() &&
				   dateRange1.getMaxJulianDay() == dateRange.getMaxJulianDay() &&
				   dateRange1.getRange() == dateRange.getRange());
		
		dateRange = new DateRange(dateRange2);
		assertTrue("The maxDays, maxDays, and ranges of dateRange2 and dateRange must be equal",
				   dateRange2.getMinJulianDay() == dateRange.getMinJulianDay() &&
				   dateRange2.getMaxJulianDay() == dateRange.getMaxJulianDay() &&
				   dateRange2.getRange() == dateRange.getRange());
		
		dateRange = new DateRange(dateRange3);
		assertTrue("The maxDays, maxDays, and ranges of dateRange3 and dateRange must be equal",
				   dateRange3.getMinJulianDay() == dateRange.getMinJulianDay() &&
				   dateRange3.getMaxJulianDay() == dateRange.getMaxJulianDay() &&
				   dateRange3.getRange() == dateRange.getRange());
		
		dateRange = new DateRange(dateRange4);
		assertTrue("The maxDays, maxDays, and ranges of dateRange4 and dateRange must be equal",
				   dateRange4.getMinJulianDay() == dateRange.getMinJulianDay() &&
				   dateRange4.getMaxJulianDay() == dateRange.getMaxJulianDay() &&
				   dateRange4.getRange() == dateRange.getRange());
	}
	
	@Test
	public void testDateRangeIntIntIntIntIntIntDuration() {
		//Testing Invalid Inputs
		try{
			DateRange dateRange = new DateRange(1, 1, 1, 1, 1, 1, null);
			fail(JUNIT_FAIL);
		} catch(AssertionError e) {checkForFailure(e);}
		  catch(NullPointerException n) {assertTrue(true);}
		
		try{
			DateRange dateRange = new DateRange(1, 1, 1, 1, 1, 1, Duration.ONE_DAY, null);
			fail(JUNIT_FAIL);
		} catch(AssertionError e) {checkForFailure(e);}
		
		try{
			DateRange dateRange = new DateRange(1, 1, 1, 1, 1, 1, null, null);
			fail(JUNIT_FAIL);
		} catch(AssertionError e) {checkForFailure(e);}
		
		try{
			DateRange dateRange = new DateRange(1, 1, 1, 1, 1, 1, Duration.ONE_DAY, Duration.ONE_MONTH, Duration.FIVE_YEARS);
			fail(JUNIT_FAIL);
		} catch(AssertionError e) {checkForFailure(e);}
	
		try{
			DateRange dateRange = new DateRange(2, 2, 2, 1, 1, 1);
			fail(JUNIT_FAIL);
		} catch(AssertionError e) {checkForFailure(e);}
		
		try{
			DateRange dateRange = new DateRange(1, 1, 2, 1, 1, 1);
			fail(JUNIT_FAIL);
		} catch(AssertionError e) {checkForFailure(e);}
		
		try{
			DateRange dateRange = new DateRange(1, 2, 1, 1, 1, 1);
			fail(JUNIT_FAIL);
		} catch(AssertionError e) {checkForFailure(e);}
		
		try{
			DateRange dateRange = new DateRange(1, 2, 2, 1, 1, 1);
			fail(JUNIT_FAIL);
		} catch(AssertionError e) {checkForFailure(e);}
		
		try{
			DateRange dateRange = new DateRange(2, 1, 1, 1, 1, 1);
			fail(JUNIT_FAIL);
		} catch(AssertionError e) {checkForFailure(e);}
		
		try{
			DateRange dateRange = new DateRange(2, 1, 2, 1, 1, 1);
			fail(JUNIT_FAIL);
		} catch(AssertionError e) {checkForFailure(e);}
		
		try{
			DateRange dateRange = new DateRange(2, 2, 1, 1, 1, 1);
			fail(JUNIT_FAIL);
		} catch(AssertionError e) {checkForFailure(e);}
		
		try{
			DateRange dateRange = new DateRange(1, 1, 1, 1, 0, 1);
			fail(JUNIT_FAIL);
		} catch(AssertionError e) {checkForFailure(e);}
		
		try{
			DateRange dateRange = new DateRange(1, 1, 1, 0, 1, 1);
			fail(JUNIT_FAIL);
		} catch(AssertionError e) {checkForFailure(e);}
		
		try{
			DateRange dateRange = new DateRange(1, 0, 1, 1, 1, 1);
			fail(JUNIT_FAIL);
		} catch(AssertionError e) {checkForFailure(e);}
		
		try{
			DateRange dateRange = new DateRange(0, 1, 1, 1, 1, 1);
			fail(JUNIT_FAIL);
		} catch(AssertionError e) {checkForFailure(e);}
		
		try{
			DateRange dateRange = new DateRange(0, 1, 1, 1, 0, 1);
			fail(JUNIT_FAIL);
		} catch(AssertionError e) {checkForFailure(e);}
		
		try{
			DateRange dateRange = new DateRange(0, 1, 1, 10, 6, 22);
			fail(JUNIT_FAIL);
		} catch(AssertionError e) {checkForFailure(e);}
		
		try{
			DateRange dateRange = new DateRange(1, 1, 1, 0, 6, 22);
			fail(JUNIT_FAIL);
		} catch(AssertionError e) {checkForFailure(e);}
		
		
		//Valid Input
		DateRange dateRange = new DateRange(1, 1, 1, 1, 1, 0);
		assertTrue(dateRange.getMinYearMonthDay().equals(new YearMonthDay(1, 1, 1)));
		assertTrue(dateRange.getMaxYearMonthDay().equals(new YearMonthDay(1, 1, 31)));

		dateRange = new DateRange(1, 1, 0, 1, 1, 1);
		assertTrue(dateRange.getMinYearMonthDay().equals(new YearMonthDay(1, 1, 1)));
		assertTrue(dateRange.getMaxYearMonthDay().equals(new YearMonthDay(1, 1, 1)));

		dateRange = new DateRange(0, 0, 0, 10, 6, 22);
		assertTrue(dateRange.getMinYearMonthDay().equals(new YearMonthDay(YearMonthDay.MIN_YEAR, 
																		  YearMonthDay.MIN_MONTH_OF_MIN_YEAR,
																		  YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR)));
		assertTrue(dateRange.getMaxYearMonthDay().equals(new YearMonthDay(10, 6, 22)));

		dateRange = new DateRange(1, 1, 1, 0, 0, 0);
		assertTrue(dateRange.getMinYearMonthDay().equals(new YearMonthDay(1, 1, 1)));
		assertTrue(dateRange.getMaxYearMonthDay().equals(new YearMonthDay(YearMonthDay.MAX_YEAR,
				                                                          YearMonthDay.MAX_MONTH_OF_MAX_YEAR,
				                                                          YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR)));

		dateRange = new DateRange(0, 0, 0, 0, 0, 0);
		assertTrue(dateRange.getMinYearMonthDay().equals(new YearMonthDay(YearMonthDay.MIN_YEAR, 
																		  YearMonthDay.MIN_MONTH_OF_MIN_YEAR,
																		  YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR)));
		assertTrue(dateRange.getMaxYearMonthDay().equals(new YearMonthDay(YearMonthDay.MAX_YEAR,
                                                                          YearMonthDay.MAX_MONTH_OF_MAX_YEAR,
                                                                          YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR)));

		dateRange = new DateRange(1960, 0, 0, 2000, 0, 0);
		assertTrue(dateRange.getMinYearMonthDay().equals(new YearMonthDay(1960, 1, 1)));
        assertTrue(dateRange.getMaxYearMonthDay().equals(new YearMonthDay(2000, 12, 31)));

		dateRange = new DateRange(1960, 0, 0, 2000, 1, 1);
		assertTrue(dateRange.getMinYearMonthDay().equals(new YearMonthDay(1960, 1, 1)));
		assertTrue(dateRange.getMaxYearMonthDay().equals(new YearMonthDay(2000, 1, 1)));

		dateRange = new DateRange(1960, 1, 1, 2000, 0, 0);
		assertTrue(dateRange.getMinYearMonthDay().equals(new YearMonthDay(1960, 1, 1)));
		assertTrue(dateRange.getMaxYearMonthDay().equals(new YearMonthDay(2000, 12, 31)));
	
		YearMonthDay ymd1 = new YearMonthDay(1956, 10, 26);
		YearMonthDay ymd2 = new YearMonthDay(1981, 1, 1);
		YearMonthDay ymd3 = new YearMonthDay(-5, 2, 29);
		YearMonthDay ymd4 = new YearMonthDay(1960, 1, 1);
		YearMonthDay ymd5 = new YearMonthDay(1960, 12, 31);
		YearMonthDay ymd6 = new YearMonthDay(2000, 4, 1);
		YearMonthDay ymd7 = new YearMonthDay(2000, 4, 30);
		YearMonthDay ymd8 = new YearMonthDay(2000, 1, 1);
		YearMonthDay ymd9 = new YearMonthDay(2000, 12, 31);
		YearMonthDay ymd10 = new YearMonthDay(-1001, 1, 1);
		YearMonthDay ymd11 = new YearMonthDay(-1000, 12, 31);
		
		dateRange = new DateRange(1956, 10, 26, 1981, 1, 1);
		assertTrue(dateRange.getMinYearMonthDay().equals(ymd1) &&
				   dateRange.getMaxYearMonthDay().equals(ymd2));
		
		dateRange = new DateRange(1956, 10, 26, 1956, 10, 26);
		assertTrue(dateRange.getMinYearMonthDay().equals(ymd1) &&
				   dateRange.getMaxYearMonthDay().equals(ymd1));
		
		dateRange = new DateRange(-5, 2, 29, 1960, 1, 1);
		assertTrue(dateRange.getMinYearMonthDay().equals(ymd3) &&
				   dateRange.getMaxYearMonthDay().equals(ymd4));
		
		dateRange = new DateRange(2000, 4, 1, 2000, 4, 30);
		assertTrue(dateRange.getMinYearMonthDay().equals(ymd6) &&
				   dateRange.getMaxYearMonthDay().equals(ymd7));
		
		dateRange = new DateRange(1960, 1, 1, 2000, 12, 31);
		assertTrue(dateRange.getMinYearMonthDay().equals(ymd4) &&
				   dateRange.getMaxYearMonthDay().equals(ymd9));
		
		dateRange = new DateRange(2000, 1, 1, 2000, 12, 31);
		assertTrue(dateRange.getMinYearMonthDay().equals(ymd8) &&
				   dateRange.getMaxYearMonthDay().equals(ymd9));
		
		dateRange = new DateRange(-1001, 1, 1, -1000, 12, 31);
		assertTrue(dateRange.getMinYearMonthDay().equals(ymd10) &&
				   dateRange.getMaxYearMonthDay().equals(ymd11));
		
		//Test Durations
		dateRange = new DateRange(1951, 12, 10, 1951, 12, 31, Duration.ONE_DAY);
		assertTrue(dateRange.getMinYearMonthDay().equals(new YearMonthDay(1951, 12, 9)) &&
				   dateRange.getMaxYearMonthDay().equals(new YearMonthDay(1952, 1, 1)));
		
		dateRange = new DateRange(1951, 12, 10, 1951, 12, 31, Duration.ONE_MONTH);
		assertTrue(dateRange.toString(), dateRange.getMinYearMonthDay().equals(new YearMonthDay(1951, 11, 10)) &&
				   dateRange.getMaxYearMonthDay().equals(new YearMonthDay(1952, 1, 31)));
		
		dateRange = new DateRange(1951, 12, 10, 1951, 12, 31, Duration.ONE_YEAR);
		assertTrue(dateRange.toString(), dateRange.getMinYearMonthDay().equals(new YearMonthDay(1950, 12, 10)) &&
				   dateRange.getMaxYearMonthDay().equals(new YearMonthDay(1952, 12, 31)));

		dateRange = new DateRange(1960, 3, 1, 1962, 2, 28, Duration.ONE_DAY);
		assertTrue(dateRange.toString(),
				   dateRange.getMinYearMonthDay().equals(new YearMonthDay(1960, 2, 29)) &&
				   dateRange.getMaxYearMonthDay().equals(new YearMonthDay(1962, 3, 1)));

		dateRange = new DateRange(1960, 1, 1, 1960, 1, 31, Duration.ONE_MONTH);
		assertTrue(dateRange.toString(),
				   dateRange.getMinYearMonthDay().equals(new YearMonthDay(1959, 12, 1)) &&
				   dateRange.getMaxYearMonthDay().equals(new YearMonthDay(1960, 2, 29)));
		
		dateRange = new DateRange(1951, 12, 10, 1951, 12, 31, Duration.ONE_DAY, Duration.ONE_MONTH);
		assertTrue(dateRange.getMinYearMonthDay().equals(new YearMonthDay(1951, 12, 9)) &&
				   dateRange.getMaxYearMonthDay().equals(new YearMonthDay(1952, 1, 31)));
		
		dateRange = new DateRange(YearMonthDay.MIN_YEAR,
								  YearMonthDay.MIN_MONTH_OF_MIN_YEAR,
								  YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR,
								  YearMonthDay.MIN_YEAR,
								  YearMonthDay.MIN_MONTH_OF_MIN_YEAR,
								  YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR, 
				                  Duration.ZERO_DURATION,
				                  Duration.ONE_DAY);
		assertTrue(dateRange.getMinYearMonthDay().equals(
				   		new YearMonthDay(YearMonthDay.MIN_YEAR,
				   				         YearMonthDay.MIN_MONTH_OF_MIN_YEAR,
				   				         YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR)) &&
				   dateRange.getMaxYearMonthDay().equals(
						new YearMonthDay(YearMonthDay.MIN_YEAR,
		   				         		 YearMonthDay.MIN_MONTH_OF_MIN_YEAR,
		   				         		 YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR + 1)));
		
	}

	@Test
	public void testGetMinDay() {
		//Test invalid inputs
		//	There are none
		
		//Test valid inputs
		DateRange dateRange = new DateRange(-4714, 11, 25);
		assertTrue("The result should be 1 but is " + dateRange.getMinJulianDay(), dateRange.getMinJulianDay() == 1);
	}

	@Test
	public void testGetMaxDay() {
		//Test invalid inputs
		//	There are none
		
		//Test valid inputs
		DateRange dateRange = new DateRange(-4714, 11, 25, -4714, 11, 26);
		assertTrue("The result should be 2 but is " + dateRange.getMaxJulianDay(), dateRange.getMaxJulianDay() == 2);
	}
	
	@Test
	public void testGetRange() {
		//Test invalid inputs
		//	There are none
		
		//Test valid inputs
		DateRange dateRange = new DateRange(1,3);
		assertTrue("The result should be 31 but is " + dateRange.getRange(), dateRange.getRange() == 31);
	}
	
	@Test
	public void testGetMinYearMonthDay() {
		//Test invalid inputs
		//	There are none
		
		//Test valid inputs
		DateRange dateRange = new DateRange(-4714, 11, 25);
		assertTrue(dateRange.getMinYearMonthDay().equals(YearMonthDay.MIN_YMD));
		
		dateRange = new DateRange(-4714, 11, 25, -4714, 11, 26);
		assertTrue(dateRange.getMinYearMonthDay().equals(YearMonthDay.MIN_YMD));
		
		dateRange = new DateRange(1850, 1, 1, 1851, 1, 1);
		assertTrue(dateRange.getMinYearMonthDay().equals(new YearMonthDay(1850, 1, 1)));
		
		dateRange = new DateRange(2018, 10, 2, 2018, 12, 10);
		assertTrue(dateRange.getMinYearMonthDay().equals(new YearMonthDay(2018, 10, 2)));
	}
	
	@Test
	public void testGetMaxYearMonthDay() {
		//Test invalid inputs
		//	There are none
		
		//Test valid inputs
		DateRange dateRange = new DateRange(-4714, 11, 25);
		assertTrue(dateRange.getMaxYearMonthDay().equals(YearMonthDay.MIN_YMD));
		
		dateRange = new DateRange(-4714, 11, 25, -4714, 11, 26);
		assertTrue(dateRange.getMaxYearMonthDay().equals(new YearMonthDay(-4714, 11,26)));
		
		dateRange = new DateRange(1850, 1, 1, 1851, 12, 31);
		assertTrue(dateRange.getMaxYearMonthDay().equals(new YearMonthDay(1851, 12, 31)));
		
		dateRange = new DateRange(2018, 10, 2, 2018, 12, 10);
		assertTrue(dateRange.getMaxYearMonthDay().equals(new YearMonthDay(2018, 12, 10)));
	}

	@Test
	public void testSameAs() {
		//Test Invalid Input
		DateRange dateRange = new DateRange(1999, 6, 21);
			
		try{
			dateRange.sameAs(null);
			assertFalse("In sameAs, the DateRange must not be null", false);
		} catch(AssertionError e) {assertTrue(true);}
		
		try{
			dateRange.sameAs(dateRange, Duration.ONE_DAY, Duration.ZERO_DURATION);
			assertFalse("In notSameAs, there can be at most 1 Duration but here there are 2", false);
		} catch(AssertionError e) {assertTrue(true);}
		

		//Test Valid Input
		// Eq Classes: Positive, Negative
		//             Multiyear, Year, YearMonth, YearMonthDay
		//             No overlap left, minOverlap left, some overlap left, all but one overlap left, min total
		//             overlap left, overlap, max total overlap right, all but one overlap right, some overlap
		//             right, smallest overlap right, closest no overlap , closest no over lap left, no overlap
		//             right
		//			reverse
		// Boundry Value: Min, Min -1, middle neg, 0-delta, 0 + delta, middle pos, max - 1, max
		
		assertTrue(dateRange.sameAs(dateRange) == 1.0d);
		
		DateRange middleDateRange = new DateRange(2018);
		DateRange middleDateRangeDuplicate = new DateRange(2018, 1, 1, 2018, 12, 31);
		DateRange minDateRange = new DateRange(YearMonthDay.MIN_YEAR);
		DateRange nonOverlappingNegativeDateRange = new DateRange(-201, 0, 0, -200, 0, 0);
		DateRange largestNegativeDateRange = new DateRange(-1, 1);
		DateRange smallestPositiveDateRange = new DateRange(1);
		DateRange nonOverlappingPositiveDateRange = new DateRange(1951, new Duration(5));
		DateRange justToLeftDayDateRange = new DateRange(2017, 12, 31);
		DateRange justToLeftWeekDateRange = new DateRange(2017, 12, 25, 2017, 12, 31);
		DateRange justToLeftMonthDateRange = new DateRange(2017,12);
		DateRange justToLeftYearDateRange = new DateRange(2017);
		DateRange oneDayLeftOverlapDateRange = new DateRange(2017, 12, 26, 2018, 1, 1);
		DateRange someLeftOverlapDateRange = new DateRange(2017, 12, 0, 2018, 1, 0);
		DateRange allButOneTotalOverlapLeftDateRange = new DateRange(2017, 12, 31, 2018, 3, 0, Duration.ZERO_DURATION, Duration.ONE_MONTH);
		DateRange minDayTotalOverlapDateRange = new DateRange(2018, 1, 1);
		DateRange minWeekTotalOverlapDateRange = new DateRange(2018, 1, 1, 2018, 1, 7);
		DateRange minMonthTotalOverlapDateRange = new DateRange(2018, 1);
		DateRange totalOverlappingDateRange  = new DateRange(2018, 5, 2, 2018, 6, 12);
		DateRange oneMonthTotalOverlappingDateRange = new DateRange(2018, 9);
		DateRange oneWeekTotalOverlappingDateRange = new DateRange(2018, 3, 28, 2018, 4, 3);
		DateRange oneDayTotalOverlappingDateRange = new DateRange(2018, 7, 27);
		DateRange maxMonthTotalOverlapDateRange = new DateRange(2018,12);
		DateRange maxWeekTotalOverlapDateRange = new DateRange(2018, 12, 25, 2018, 12, 31);
		DateRange maxDayTotalOverlapDateRange = new DateRange(2018, 12, 31);
		DateRange allButOneTotalOverlapRightDateRange = new DateRange(2018, 12, 0, 2019, 1, 1);
		DateRange somerightOverlapDateRange = new DateRange(2018, 11, 0, 2019, 2, 0);
		DateRange oneDayRightOverlapDateRange = new DateRange(2018, 12, 31, 2019, 5, 0);
		DateRange justToRightDayDateRange = new DateRange(2019, 1, 1);
		DateRange justToRightWeekDateRange = new DateRange(2019, 1, 1, 2019, 1, 7);
		DateRange justToRightMonthDateRange = new DateRange(2019, 1);
		DateRange justToRightYearDateRange = new DateRange(2019);
		DateRange nonOverlappingPositiveDateRangeAbove = new DateRange(1850, new Duration(5));
		DateRange maxDateRange = new DateRange(YearMonthDay.MAX_YEAR, YearMonthDay.MAX_MONTH_OF_MAX_YEAR);
		
		//Test for overlap
		assertTrue("sameAs value = " + middleDateRange.sameAs(oneDayLeftOverlapDateRange),
				   middleDateRange.sameAs(oneDayLeftOverlapDateRange) == 1.0d/7.0d);
		assertTrue(oneDayLeftOverlapDateRange.sameAs(middleDateRange) == 1.0d/7.0d);
		
		assertTrue("sameAs value = " + middleDateRange.sameAs(someLeftOverlapDateRange),
				   middleDateRange.sameAs(someLeftOverlapDateRange) == 31.0d/62.0d);
		assertTrue(someLeftOverlapDateRange.sameAs(middleDateRange) == 31.0d/62.0d);
		
		assertTrue("sameAs value = " + middleDateRange.sameAs(allButOneTotalOverlapLeftDateRange),
				   middleDateRange.sameAs(allButOneTotalOverlapLeftDateRange) == 120.0d/121.0d);
		assertTrue(allButOneTotalOverlapLeftDateRange.sameAs(middleDateRange) == 120.0d/121.0d);
		
		assertTrue("sameAs value = " + middleDateRange.sameAs(minDayTotalOverlapDateRange),
				   middleDateRange.sameAs(minDayTotalOverlapDateRange) == 1.0d/1.0d);
		assertTrue(minDayTotalOverlapDateRange.sameAs(middleDateRange) == 1.0d/1.0d);
		
		assertTrue("sameAs value = " + middleDateRange.sameAs(minWeekTotalOverlapDateRange),
				   middleDateRange.sameAs(minWeekTotalOverlapDateRange) == 7.0d/7.0d);
		assertTrue(minWeekTotalOverlapDateRange.sameAs(middleDateRange) == 7.0d/7.0d);
		
		assertTrue("sameAs value = " + middleDateRange.sameAs(minMonthTotalOverlapDateRange),
				   middleDateRange.sameAs(minMonthTotalOverlapDateRange) == 31.0d/31.0d);
		assertTrue(minMonthTotalOverlapDateRange.sameAs(middleDateRange) == 31.0d/31.0d);
		
		assertTrue("sameAs value = " + middleDateRange.sameAs(totalOverlappingDateRange),
				   middleDateRange.sameAs(totalOverlappingDateRange) == 42.0d/42.0d);
		assertTrue(totalOverlappingDateRange.sameAs(middleDateRange) == 42.0d/42.0d);
		
		assertTrue("sameAs value = " + middleDateRange.sameAs(oneMonthTotalOverlappingDateRange),
				   middleDateRange.sameAs(oneMonthTotalOverlappingDateRange) == 30.0d/30.0d);
		assertTrue(oneMonthTotalOverlappingDateRange.sameAs(middleDateRange) == 30.0d/30.0d);
		
		assertTrue("sameAs value = " + middleDateRange.sameAs(oneWeekTotalOverlappingDateRange),
				   middleDateRange.sameAs(oneWeekTotalOverlappingDateRange) == 7.0d/7.0d);
		assertTrue(oneWeekTotalOverlappingDateRange.sameAs(middleDateRange) == 7.0d/7.0d);
		
		assertTrue("sameAs value = " + middleDateRange.sameAs(oneDayTotalOverlappingDateRange),
				   middleDateRange.sameAs(oneDayTotalOverlappingDateRange) == 1.0d/1.0d);
		assertTrue(oneDayTotalOverlappingDateRange.sameAs(middleDateRange) == 1.0d/1.0d);
		
		assertTrue("sameAs value = " + middleDateRange.sameAs(maxMonthTotalOverlapDateRange),
				   middleDateRange.sameAs(maxMonthTotalOverlapDateRange) == 31.0d/31.0d);
		assertTrue(maxMonthTotalOverlapDateRange.sameAs(middleDateRange) == 31.0d/31.0d);
		
		assertTrue("sameAs value = " + middleDateRange.sameAs(maxWeekTotalOverlapDateRange),
				   middleDateRange.sameAs(maxWeekTotalOverlapDateRange) == 7.0d/7.0d);
		assertTrue(maxWeekTotalOverlapDateRange.sameAs(middleDateRange) == 7.0d/7.0d);
		
		assertTrue("sameAs value = " + middleDateRange.sameAs(maxDayTotalOverlapDateRange),
				   middleDateRange.sameAs(maxDayTotalOverlapDateRange) == 1.0d/1.0d);
		assertTrue(maxDayTotalOverlapDateRange.sameAs(middleDateRange) == 1.0d/1.0d);
		
		assertTrue("sameAs value = " + middleDateRange.sameAs(allButOneTotalOverlapRightDateRange),
				   middleDateRange.sameAs(allButOneTotalOverlapRightDateRange) == 31.0d/32.0d);
		assertTrue(allButOneTotalOverlapRightDateRange.sameAs(middleDateRange) == 31.0d/32.0d);
		
		assertTrue("sameAs value = " + middleDateRange.sameAs(somerightOverlapDateRange),
				   middleDateRange.sameAs(somerightOverlapDateRange) == 61.0d/120.0d);
		assertTrue(somerightOverlapDateRange.sameAs(middleDateRange) == 61.0d/120.0d);
		
		assertTrue("sameAs value = " + middleDateRange.sameAs(oneDayRightOverlapDateRange),
				   middleDateRange.sameAs(oneDayRightOverlapDateRange) == 1.0d/152.0d);
		assertTrue(oneDayRightOverlapDateRange.sameAs(middleDateRange) == 1.0d/152.0d);
		
		//Test for 1.0 result
		assertTrue("sameAs value = " + middleDateRange.sameAs(maxMonthTotalOverlapDateRange),
				   middleDateRange.sameAs(maxMonthTotalOverlapDateRange) == 1.0d);
		assertTrue(maxMonthTotalOverlapDateRange.sameAs(middleDateRange) == 1.0d);
		
		//Test for 0.0 result
		assertTrue("sameAs value = " + middleDateRange.sameAs(minDateRange),
				   middleDateRange.sameAs(minDateRange) == 0.0d);
		assertTrue(minDateRange.sameAs(middleDateRange) == 0.0d);
		
		assertTrue("sameAs value = " + middleDateRange.sameAs(nonOverlappingNegativeDateRange),
				   middleDateRange.sameAs(nonOverlappingNegativeDateRange) == 0.0d);
		assertTrue(nonOverlappingNegativeDateRange.sameAs(middleDateRange) == 0.0d);
		
		assertTrue("sameAs value = " + middleDateRange.sameAs(largestNegativeDateRange),
				   middleDateRange.sameAs(largestNegativeDateRange) == 0.0d);
		assertTrue(largestNegativeDateRange.sameAs(middleDateRange) == 0.0d);
		
		assertTrue("sameAs value = " + middleDateRange.sameAs(smallestPositiveDateRange),
				   middleDateRange.sameAs(smallestPositiveDateRange) == 0.0d);
		assertTrue(smallestPositiveDateRange.sameAs(middleDateRange) == 0.0d);
		
		assertTrue("sameAs value = " + middleDateRange.sameAs(nonOverlappingPositiveDateRange),
				   middleDateRange.sameAs(nonOverlappingPositiveDateRange) == 0.0d);
		assertTrue(nonOverlappingPositiveDateRange.sameAs(middleDateRange) == 0.0d);
		
		assertTrue("sameAs value = " + middleDateRange.sameAs(justToLeftDayDateRange),
				   middleDateRange.sameAs(justToLeftDayDateRange) == 0.0d);
		assertTrue(justToLeftDayDateRange.sameAs(middleDateRange) == 0.0d);
		
		assertTrue("sameAs value = " + middleDateRange.sameAs(justToLeftWeekDateRange),
				   middleDateRange.sameAs(justToLeftWeekDateRange) == 0.0d);
		assertTrue(justToLeftWeekDateRange.sameAs(middleDateRange) == 0.0d);
		
		assertTrue("sameAs value = " + middleDateRange.sameAs(justToLeftMonthDateRange),
				   middleDateRange.sameAs(justToLeftMonthDateRange) == 0.0d);
		assertTrue(justToLeftMonthDateRange.sameAs(middleDateRange) == 0.0d);
		
		assertTrue("sameAs value = " + middleDateRange.sameAs(justToLeftYearDateRange),
				   middleDateRange.sameAs(justToLeftYearDateRange) == 0.0d);
		assertTrue(justToLeftYearDateRange.sameAs(middleDateRange) == 0.0d);
		
		assertTrue("sameAs value = " + middleDateRange.sameAs(justToRightDayDateRange),
				   middleDateRange.sameAs(justToRightDayDateRange) == 0.0d);
		assertTrue(justToRightDayDateRange.sameAs(middleDateRange) == 0.0d);
		
		assertTrue("sameAs value = " + middleDateRange.sameAs(justToRightWeekDateRange),
				   middleDateRange.sameAs(justToRightWeekDateRange) == 0.0d);
		assertTrue(justToRightWeekDateRange.sameAs(middleDateRange) == 0.0d);
		
		assertTrue("sameAs value = " + middleDateRange.sameAs(justToRightMonthDateRange),
				   middleDateRange.sameAs(justToRightMonthDateRange) == 0.0d);
		assertTrue(justToRightMonthDateRange.sameAs(middleDateRange) == 0.0d);
		
		assertTrue("sameAs value = " + middleDateRange.sameAs(justToRightYearDateRange),
				   middleDateRange.sameAs(justToLeftYearDateRange) == 0.0d);
		assertTrue(justToLeftYearDateRange.sameAs(middleDateRange) == 0.0d);
		
		assertTrue("sameAs value = " + middleDateRange.sameAs(nonOverlappingPositiveDateRangeAbove),
				   middleDateRange.sameAs(nonOverlappingPositiveDateRangeAbove) == 0.0d);
		assertTrue(nonOverlappingPositiveDateRangeAbove.sameAs(middleDateRange) == 0.0d);
		
		assertTrue("sameAs value = " + middleDateRange.sameAs(maxDateRange),
				   middleDateRange.sameAs(maxDateRange) == 0.0d);
		assertTrue(maxDateRange.sameAs(middleDateRange) == 0.0d);
		
		
		
		
		
		
		
		//MoreToDo
	}

	@Test
	public void testNotSameAs() {
		//Test Invalid Input
		DateRange dateRange1 = new DateRange(1999, 6, 21);
			
		try{
			dateRange1.sameAs(null);
			assertFalse("In notSameAs, the DateRange must not be null", false);
		} catch(AssertionError e) {assertTrue(true);}
		
		try{
			dateRange1.notSameAs(dateRange1, Duration.ONE_DAY, Duration.ZERO_DURATION);
			assertFalse("In notSameAs, there can be at most 1 Duration but here there are 2", false);
		} catch(AssertionError e) {assertTrue(true);}
		
		//Test Valid Input
		assertFalse(dateRange1.notSameAs(dateRange1) > 0.0d);
		
		//MoreToDo
	}
	
	@Test
	public void testToString() {
		DateRange dateRange = new DateRange(2019, 2, 20, 2019, 2, 21);
		dateRange.toString();
	}
	
	@Test
	public void testEquals() {

		DateRange[] dateRanges = {
				new DateRange(1999, 6, 21),
				new DateRange(1999, 6, 20),
				new DateRange(1999, 6, 19),
				new DateRange(1999, 5, 21),
				new DateRange(1999, 7, 21),
				new DateRange(1998, 6, 21),
				new DateRange(2000, 6, 21),
				new DateRange(-1999, 6, 21),
				new DateRange(-2000, 6, 21)
		};
		
		try {
			dateRanges[0].equals(null);
			fail();
		} catch(AssertionError e) {checkForFailure(e);};
		
		for(int i = 0; i < dateRanges.length; i++) {
			for(int j = i; j < dateRanges.length; j++) {
				if(i == j) {
					assertTrue(dateRanges[i].equals(dateRanges[j]));
				} else {
					assertFalse("ERROR: dateRanges[" + i + "] = " + dateRanges[i] + "and\n    " +
							    "dateRanges[" + j + "] = " + dateRanges[j] + " should not be equal",
							    dateRanges[i].equals(dateRanges[j]));
				}
			}
			
		}
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
