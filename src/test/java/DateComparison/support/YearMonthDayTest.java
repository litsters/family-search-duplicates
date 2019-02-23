package DateComparison.support;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;


public class YearMonthDayTest {

	@Test
	public void testYearMonthDay() {
		YearMonthDay yearMonthDay = new YearMonthDay();
		assertTrue(yearMonthDay.getJulianDay() == 1);
	}
	
	@Test
	public void testGetLastDayOf() {
		//Invalid Input
		try{
			YearMonthDay.getLastDayOf(0, 2000);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {
			checkForFailure(e);
		}
		
		try{
			YearMonthDay.getLastDayOf(-1, -2);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {
			checkForFailure(e);
		}
		
		try{
			YearMonthDay.getLastDayOf(-155, 200);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {
			checkForFailure(e);
		}
		
		try{
			YearMonthDay.getLastDayOf(13, 2010);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {
			checkForFailure(e);
		}
		
		try{
			YearMonthDay.getLastDayOf(14, 2011);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {
			checkForFailure(e);
		}
		
		try{
			YearMonthDay.getLastDayOf(1001, 2011);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {
			checkForFailure(e);
		}
		
		try{
			YearMonthDay.getLastDayOf(YearMonthDay.DECEMBER, YearMonthDay.MIN_YEAR - 1);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {
			checkForFailure(e);
		}
		
		try{
			YearMonthDay.getLastDayOf(YearMonthDay.MIN_MONTH_OF_MIN_YEAR - 1, YearMonthDay.MIN_YEAR);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {
			checkForFailure(e);
		}
		
		try{
			YearMonthDay.getLastDayOf(YearMonthDay.JANUARY, YearMonthDay.MAX_YEAR + 1);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {
			checkForFailure(e);
		}
		
		try{
			YearMonthDay.getLastDayOf(YearMonthDay.MAX_MONTH_OF_MAX_YEAR + 1, YearMonthDay.MAX_YEAR);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {
			checkForFailure(e);
		}
		
		//Valid Input
		YearMonthDay.getLastDayOf(1, 1850);
		YearMonthDay.getLastDayOf(2, 1996);
		YearMonthDay.getLastDayOf(2, 2000);
		YearMonthDay.getLastDayOf(2, 1900);
		YearMonthDay.getLastDayOf(2, 1600);
		YearMonthDay.getLastDayOf(2, 100);
		YearMonthDay.getLastDayOf(2, 4);
		YearMonthDay.getLastDayOf(2, 1);
		YearMonthDay.getLastDayOf(2, -1);
		YearMonthDay.getLastDayOf(2, -4);
		YearMonthDay.getLastDayOf(2, -5);
		YearMonthDay.getLastDayOf(2, -100);
		YearMonthDay.getLastDayOf(2, -101);
		YearMonthDay.getLastDayOf(2, -105);
		YearMonthDay.getLastDayOf(2, -400);
		YearMonthDay.getLastDayOf(2, -401);
		YearMonthDay.getLastDayOf(2, -402);
		YearMonthDay.getLastDayOf(2, -801);
		YearMonthDay.getLastDayOf(2, -3201);
		YearMonthDay.getLastDayOf(3, -12);
		YearMonthDay.getLastDayOf(4, -1000);
		YearMonthDay.getLastDayOf(5, 1953);
		YearMonthDay.getLastDayOf(6, -4000);
		YearMonthDay.getLastDayOf(7, 1954);
		YearMonthDay.getLastDayOf(8, 2018);
		YearMonthDay.getLastDayOf(9, 1977);
		YearMonthDay.getLastDayOf(10, 1982);
		YearMonthDay.getLastDayOf(11, 1989);
		YearMonthDay.getLastDayOf(12, 1985);
		YearMonthDay.getLastDayOf(YearMonthDay.MIN_MONTH_OF_MIN_YEAR, YearMonthDay.MIN_YEAR);
		YearMonthDay.getLastDayOf(YearMonthDay.MAX_MONTH_OF_MAX_YEAR, YearMonthDay.MAX_YEAR);
	}
	
	@Test
	public void testLessThanOrEqual() {
		YearMonthDay ymd1 = new YearMonthDay(1,1,1);
		YearMonthDay ymd2 = new YearMonthDay(1,1,1);
		
		//Invalid Input
		try {
			ymd1.lessThanOrEqualTo(null);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {
			checkForFailure(e);
		}
		
		//Valid Input
		ymd1.lessThanOrEqualTo(ymd1);
		ymd1.lessThanOrEqualTo(ymd2);
		ymd2.lessThanOrEqualTo(ymd1);
		
		for(int year1 = 1; year1 < 6; year1++) {
			for(int year2 = year1; year2 < 6; year2++) {
				for(int month1 = 1; month1 <= 12; month1++) {
					for(int month2 = month1; month2 <= 12; month2++) {
						for(int day1 = 1; day1 <= YearMonthDay.getLastDayOf(month1, year1); day1++) {
							YearMonthDay ymdA = new YearMonthDay(year1, month1, day1);
							for(int day2 = day1; day2 <= YearMonthDay.getLastDayOf(month2, year2); day2++) {
								YearMonthDay ymdB = new YearMonthDay(year2, month2, day2);
								ymdA.lessThanOrEqualTo(ymdB);
								ymdB.lessThanOrEqualTo(ymdA);
							}
						}
					}
				}
			}
		}
	}

	@Test
	public void testYearMonthDayYearMonthDay() {
		//Invalid Input
		try{
			new YearMonthDay(null);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {
			checkForFailure(e);
		}
		
		//Valid Input
		
		new YearMonthDay(new YearMonthDay(1, 1, 1));
	}
	
	@Test
	public void testGetYear() {
		YearMonthDay.MIN_YMD.getYear();
		YearMonthDay.MAX_YMD.getYear();
	}
	
	@Test
	public void testGetMonth() {
		YearMonthDay.MIN_YMD.getMonth();
		YearMonthDay.MAX_YMD.getMonth();
	}
	
	@Test
	public void testGetDay() {
		YearMonthDay.MIN_YMD.getDay();
		YearMonthDay.MAX_YMD.getDay();
	}

	@Test
	public void testYearMonthDayIntIntInt() {
		//Invalid Input
		try{
			new YearMonthDay(-5000, 1, 1);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {checkForFailure(e);}
		
		try{
			new YearMonthDay(YearMonthDay.MIN_YEAR - 1, 1, 1);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {checkForFailure(e);}	
		
		try{
			new YearMonthDay(YearMonthDay.MIN_YEAR, YearMonthDay.MIN_MONTH_OF_MIN_YEAR -1 , 1);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {checkForFailure(e);}
		
		try{
			new YearMonthDay(YearMonthDay.MIN_YEAR, YearMonthDay.MIN_MONTH_OF_MIN_YEAR, 24);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {checkForFailure(e);}
		
		try{
			new YearMonthDay(-101, 2, 29);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {checkForFailure(e);}
		
		try{
			new YearMonthDay(Integer.MAX_VALUE, 1, 1);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {checkForFailure(e);}
		
		try{
			new YearMonthDay(YearMonthDay.MAX_YEAR + 1, 1, 1);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {checkForFailure(e);}
		
		try{
			new YearMonthDay(YearMonthDay.MAX_YEAR, 11, 1);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {checkForFailure(e);}
		
		try{
			new YearMonthDay(YearMonthDay.MAX_YEAR, 10, 8);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {checkForFailure(e);}
		
		try{
			new YearMonthDay(-5000, 1, 1);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {checkForFailure(e);}
		
		try{
			new YearMonthDay(0, 1, 1);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {checkForFailure(e);}
		
		try{
			new YearMonthDay(-5000, 1, 1);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {checkForFailure(e);}
		
		try{
			new YearMonthDay(1, -101, 1);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {checkForFailure(e);}
		
		try{
			new YearMonthDay(1900, -1, 1);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {checkForFailure(e);}
		
		try{
			new YearMonthDay(2000, 13, 1);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {checkForFailure(e);}
		
		try{
			new YearMonthDay(2001, 100, 1);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {checkForFailure(e);}
		
		try{
			new YearMonthDay(2002, 1, -56);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {checkForFailure(e);}
		
		try{
			new YearMonthDay(2003, 2, -1);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {checkForFailure(e);}
		
		try{
			new YearMonthDay(2004, 12, 0);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {checkForFailure(e);}
		
		try{
			new YearMonthDay(2005, 1, 32);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {checkForFailure(e);}	
		
		try{
			new YearMonthDay(2005, 2, 29);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {checkForFailure(e);}	
		
		try{
			new YearMonthDay(2005, 3, 32);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {checkForFailure(e);}	
		
		try{
			new YearMonthDay(2006, 4, 31);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {checkForFailure(e);}	
		
		try{
			new YearMonthDay(2007, 5, 32);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {checkForFailure(e);}	
		
		try{
			new YearMonthDay(2008, 6, 31);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {checkForFailure(e);}	
		
		try{
			new YearMonthDay(2009, 7, 32);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {checkForFailure(e);}		
		
		try{
			new YearMonthDay(2010, 8, 32);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {checkForFailure(e);}	
		
		try{
			new YearMonthDay(2011, 9, 31);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {checkForFailure(e);}	
		
		try{
			new YearMonthDay(2012, 10, 32);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {checkForFailure(e);}	
		
		try{
			new YearMonthDay(2013, 11, 31);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {checkForFailure(e);}	
		
		try{
			new YearMonthDay(2014, 12, 32);
			fail(JUNIT_FAIL);
		}catch(AssertionError e) {checkForFailure(e);}
		
		//Valid Input
		new YearMonthDay(YearMonthDay.MIN_YEAR,
						 YearMonthDay.MIN_MONTH_OF_MIN_YEAR, 
						 YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR);
		new YearMonthDay(YearMonthDay.MIN_YEAR,
				         YearMonthDay.MIN_MONTH_OF_MIN_YEAR, 
				         YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR + 1);		
		new YearMonthDay(YearMonthDay.MIN_YEAR,
			             YearMonthDay.MIN_MONTH_OF_MIN_YEAR, 
			             YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR + 2);
		new YearMonthDay(YearMonthDay.MIN_YEAR, YearMonthDay.MIN_MONTH_OF_MIN_YEAR + 1, 31);
		new YearMonthDay(YearMonthDay.MIN_YEAR, YearMonthDay.MIN_MONTH_OF_MIN_YEAR + 1, 30);		
		new YearMonthDay(-103, 2, 28);
		new YearMonthDay(-103, 2, 27);
		new YearMonthDay(-103, 2, 2);
		new YearMonthDay(-103, 2, 1);
		new YearMonthDay(-101, 2, 28);
		new YearMonthDay(-401, 2, 29);
		new YearMonthDay(-109, 2, 28);
		new YearMonthDay(-109, 1, 16);
		new YearMonthDay(-2, 2, 28);
		new YearMonthDay(-1, 2, 29);
		new YearMonthDay(-6, 7, 31);
		new YearMonthDay(1, 1, 1);
		new YearMonthDay(1, 1, 2);
		new YearMonthDay(1, 1, 30);
		new YearMonthDay(1, 1, 31);
		new YearMonthDay(1, 2, 28);
		new YearMonthDay(1, 5, 31);
		new YearMonthDay(1, 11, 30);
		new YearMonthDay(1, 12, 30);
		new YearMonthDay(1, 12, 31);
		new YearMonthDay(4, 2, 29);
		new YearMonthDay(2101, 1, 31);
		new YearMonthDay(2101, 2, 28);
		new YearMonthDay(2101, 3, 31);
		new YearMonthDay(2101, 4, 30);
		new YearMonthDay(2101, 5, 31);
		new YearMonthDay(2101, 6, 30);
		new YearMonthDay(2101, 7, 31);
		new YearMonthDay(2101, 8, 31);
		new YearMonthDay(2101, 9, 30);
		new YearMonthDay(2101, 10, 31);
		new YearMonthDay(2101, 11, 30);
		new YearMonthDay(2101, 12, 31);
		new YearMonthDay(2000, 2, 29);
		new YearMonthDay(3200, 2, 28);
		new YearMonthDay(YearMonthDay.MAX_YEAR,
						 YearMonthDay.MAX_MONTH_OF_MAX_YEAR,
						 YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR);
		new YearMonthDay(YearMonthDay.MAX_YEAR,
				         YearMonthDay.MAX_MONTH_OF_MAX_YEAR,
				         YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR - 1);
		new YearMonthDay(YearMonthDay.MAX_YEAR, 10, 1);
		new YearMonthDay(YearMonthDay.MAX_YEAR, 9, 30);
		new YearMonthDay(YearMonthDay.MAX_YEAR, 4, 15);
		new YearMonthDay(YearMonthDay.MAX_YEAR, 2, 28);
		new YearMonthDay(YearMonthDay.MAX_YEAR, 1, 31);
		new YearMonthDay(YearMonthDay.MAX_YEAR, 1, 30);
		new YearMonthDay(YearMonthDay.MAX_YEAR, 1, 15);
		new YearMonthDay(YearMonthDay.MAX_YEAR, 1, 2);
		new YearMonthDay(YearMonthDay.MAX_YEAR, 1, 1);
	}
	
	@Test
	public void testIncreaseBy() {
	// Test errors
		YearMonthDay ymd = new YearMonthDay(YearMonthDay.MAX_YEAR,
											YearMonthDay.MAX_MONTH_OF_MAX_YEAR,
											YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR);
	
		try{
			ymd.increaseBy(null);
			fail(JUNIT_FAIL);
		} catch(AssertionError e) {checkForFailure(e);}
		
		Duration duration = new Duration(0, 0, 1);
		try{
			ymd.increaseBy(duration);
			fail(JUNIT_FAIL);
		} catch(AssertionError e) {checkForFailure(e);}
		
		duration = new Duration(0, 1, 0);
		try{
			ymd.increaseBy(duration);
			fail(JUNIT_FAIL);
		} catch(AssertionError e) {checkForFailure(e);}
		
		duration = new Duration(1, 0, 0);
		try{
			ymd.increaseBy(duration);
			fail(JUNIT_FAIL);
		} catch(AssertionError e) {checkForFailure(e);}
		
		duration = new Duration(1, 1, 1);
		try{
			ymd.increaseBy(duration);
			fail(JUNIT_FAIL);
		} catch(AssertionError e) {checkForFailure(e);}
		
	//Normal Tests
		ymd = new YearMonthDay(2018, 10, 10);
		ymd.increaseBy(Duration.ZERO_DURATION);
		assertTrue(ymd.getYear() == 2018 && ymd.getMonth() == 10 && ymd.getDay() == 10);
		
		ymd = new YearMonthDay(2018, 10, 10);
		ymd.increaseBy(Duration.ONE_DAY);
		assertTrue(ymd.getYear() == 2018 && ymd.getMonth() == 10 && ymd.getDay() == 11);
		
		ymd = new YearMonthDay(2018, 10, 10);
		ymd.increaseBy(new Duration(0, 0, 21));
		assertTrue(ymd.getYear() == 2018 && ymd.getMonth() == 10 && ymd.getDay() == 31);
		
		ymd = new YearMonthDay(2018, 10, 10);
		ymd.increaseBy(new Duration(0, 0, 22));
		assertTrue(ymd.getYear() == 2018 && ymd.getMonth() == 11 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(2018, 10, 31);
		ymd.increaseBy(new Duration(0, 0, 30));
		assertTrue(ymd.getYear() == 2018 && ymd.getMonth() == 11 && ymd.getDay() == 30);
		
		ymd = new YearMonthDay(2018, 1, 31);
		duration = new Duration(0, 0, 30);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 2018 && ymd.getMonth() == 3 && ymd.getDay() == 2);
		
		ymd = new YearMonthDay(2016, 1, 31);
		duration = new Duration(0, 0, 30);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 2016 && ymd.getMonth() == 3 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(2016, 2, 29);
		duration = new Duration(0, 0, 30);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 2016 && ymd.getMonth() == 3 && ymd.getDay() == 30);
		
		ymd = new YearMonthDay(2016, 11, 30);
		duration = new Duration(0, 0, 30);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 2016 && ymd.getMonth() == 12 && ymd.getDay() == 30);
		
		ymd = new YearMonthDay(2016, 12, 31);
		duration = new Duration(0, 0, 30);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 2017 && ymd.getMonth() == 1 && ymd.getDay() == 30);
		
		ymd = new YearMonthDay(2016, 12, 30);
		duration = new Duration(0, 0, 30);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 2017 && ymd.getMonth() == 1 && ymd.getDay() == 29);
		
		ymd = new YearMonthDay(2016, 12, 1);
		duration = new Duration(0, 0, 30);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 2016 && ymd.getMonth() == 12 && ymd.getDay() == 31);
		
		ymd = new YearMonthDay(2016, 12, 2);
		duration = new Duration(0, 0, 30);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 2017 && ymd.getMonth() == 1 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(-1, 12, 1);
		duration = new Duration(0, 0, 30);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 12 && ymd.getDay() == 31);
		
		ymd = new YearMonthDay(-1, 12, 2);
		duration = new Duration(0, 0, 30);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(-1, 12, 31);
		duration = new Duration(0, 0, 1);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(-1, 12, 31);
		duration = new Duration(0, 0, 30);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 1 && ymd.getMonth() == 1 && ymd.getDay() == 30);
		
		ymd = new YearMonthDay(1905, 12, 31);
		duration = new Duration(2, 0, 0);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 1907 && ymd.getMonth() == 12 && ymd.getDay() == 31);
		
		ymd = new YearMonthDay(1905, 12, 31);
		duration = new Duration(2, 20, 0);
		ymd.increaseBy(duration);
		assertTrue(ymd.toString(), ymd.getYear() == 1909 && ymd.getMonth() == 8 && ymd.getDay() == 31);

		ymd = new YearMonthDay(1905, 12, 31);
		duration = new Duration(2, 20, 40);
		ymd.increaseBy(duration);
		assertTrue(ymd.toString(), ymd.getYear() == 1909 && ymd.getMonth() == 10 && ymd.getDay() == 10);

		ymd = new YearMonthDay(-1905, 12, 31);
		duration = new Duration(2, 20, 40);
		ymd.increaseBy(duration);
		assertTrue(ymd.toString(), ymd.getYear() == -1901 && ymd.getMonth() == 10 && ymd.getDay() == 10);

		ymd = new YearMonthDay(YearMonthDay.MIN_YMD);
		duration = new Duration(0, 0, 1);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == YearMonthDay.MIN_YEAR &&
				   ymd.getMonth() == YearMonthDay.MIN_MONTH_OF_MIN_YEAR &&
				   ymd.getDay() == YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR + 1);

		ymd = new YearMonthDay(YearMonthDay.MIN_YMD);
		duration = new Duration(0, 0, 30);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == YearMonthDay.MIN_YEAR && ymd.getMonth() == 12 && ymd.getDay() == YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR);

		ymd = new YearMonthDay(-50, 6, 10);
		duration = new Duration(0, 0, 20);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == -50 && ymd.getMonth() == 6 && ymd.getDay() == 30);

		ymd = new YearMonthDay(-50, 6, 10);
		duration = new Duration(0, 1, 30);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == -50 && ymd.getMonth() == 8 && ymd.getDay() == 9);

		ymd = new YearMonthDay(-50, 6, 10);
		duration = new Duration(0, 11, 30);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == -49 && ymd.getMonth() == 6 && ymd.getDay() == 9);
		
		ymd = new YearMonthDay(1960, 2, 29);
		ymd.increaseBy(Duration.ZERO_DURATION);
		assertTrue(ymd.getYear() == 1960 && ymd.getMonth() == 2 && ymd.getDay() == 29);
		
		ymd = new YearMonthDay(1960, 2, 29);
		ymd.increaseBy(Duration.ONE_DAY);
		assertTrue(ymd.getYear() == 1960 && ymd.getMonth() == 3 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(1960, 2, 29);
		duration = new Duration(0, 0, 2);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 1960 && ymd.getMonth() == 3 && ymd.getDay() == 2);
		
		ymd = new YearMonthDay(1960, 2, 28);
		ymd.increaseBy(Duration.ONE_DAY);
		assertTrue(ymd.getYear() == 1960 && ymd.getMonth() == 2 && ymd.getDay() == 29);
		
		ymd = new YearMonthDay(1960, 2, 28);
		duration = new Duration(0, 0, 2);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 1960 && ymd.getMonth() == 3 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(1961, 2, 28);
		ymd.increaseBy(Duration.ZERO_DURATION);
		assertTrue(ymd.getYear() == 1961 && ymd.getMonth() == 2 && ymd.getDay() == 28);
		
		ymd = new YearMonthDay(1961, 2, 28);
		ymd.increaseBy(Duration.ONE_DAY);
		assertTrue(ymd.getYear() == 1961 && ymd.getMonth() == 3 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(1961, 2, 28);
		duration = new Duration(0, 0, 2);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 1961 && ymd.getMonth() == 3 && ymd.getDay() == 2);
		
		ymd = new YearMonthDay(1961, 2, 27);
		ymd.increaseBy(Duration.ONE_DAY);
		assertTrue(ymd.getYear() == 1961 && ymd.getMonth() == 2 && ymd.getDay() == 28);
		
		ymd = new YearMonthDay(1961, 2, 27);
		duration = new Duration(0, 0, 2);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 1961 && ymd.getMonth() == 3 && ymd.getDay() == 1);
		
		// Test negative leap years
		ymd = new YearMonthDay(-1, 2, 1);
		duration = new Duration(0, 0, 30);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 3 && ymd.getDay() == 2);
		
		ymd = new YearMonthDay(-1, 1, 31);
		duration = new Duration(0, 0, 30);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 3 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(-1, 2, 29);
		duration = new Duration(0, 0, 1);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 3 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(-1, 2, 28);
		duration = new Duration(0, 0, 1);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 2 && ymd.getDay() == 29);
		
		ymd = new YearMonthDay(-1, 2, 15);
		duration = new Duration(0, 0, 25);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 3 && ymd.getDay() == 11);
		
		ymd = new YearMonthDay(-100, 2, 25);
		duration = new Duration(0, 0, 10);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == -100 && ymd.getMonth() == 3 && ymd.getDay() == YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR);
		
		ymd = new YearMonthDay(-101, 2, 25);
		duration = new Duration(0, 0, 10);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == -101 && ymd.getMonth() == 3 && ymd.getDay() == YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR);
		
		ymd = new YearMonthDay(-105, 2, 25);
		duration = new Duration(0, 0, 10);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == -105 && ymd.getMonth() == 3 && ymd.getDay() == 6);
		
		ymd = new YearMonthDay(-400, 2, 25);
		duration = new Duration(0, 0, 10);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == -400 && ymd.getMonth() == 3 && ymd.getDay() == YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR);
		
		ymd = new YearMonthDay(-401, 2, 25);
		duration = new Duration(0, 0, 10);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == -401 && ymd.getMonth() == 3 && ymd.getDay() == 6);
		
		ymd = new YearMonthDay(-3200, 2, 25);
		duration = new Duration(0, 0, 10);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == -3200 && ymd.getMonth() == 3 && ymd.getDay() == 7);
		
		ymd = new YearMonthDay(-3201, 2, 25);
		duration = new Duration(0, 0, 10);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == -3201 && ymd.getMonth() == 3 && ymd.getDay() == 6);
		
		// Test Normal Again
		ymd = new YearMonthDay(2001, 1, 25);
		duration = new Duration(0, 0, 10);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 2001 && ymd.getMonth() == 2 && ymd.getDay() == 4);
		
		ymd = new YearMonthDay(1928, 2, 7);
		duration = new Duration(0, 0, 10);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 1928 && ymd.getMonth() == 2 && ymd.getDay() == 17);
		
		ymd = new YearMonthDay(1899, 6, 21);
		duration = new Duration(0, 0, 10);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 1899 && ymd.getMonth() == 7 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(1881, 11, 30);
		duration = new Duration(0, 0, 10);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 1881 && ymd.getMonth() == 12 && ymd.getDay() == 10);
		
		//Test Months
		ymd = new YearMonthDay(1881, 1, 1);
		duration = new Duration(0, 1, 0);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 1881 && ymd.getMonth() == 2 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(1881, 1, 1);
		duration = new Duration(0, 2, 0);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 1881 && ymd.getMonth() == 3 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(1881, 1, 1);
		duration = new Duration(0, 10, 0);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 1881 && ymd.getMonth() == 11 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(1881, 1, 1);
		duration = new Duration(0, 11, 0);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 1881 && ymd.getMonth() == 12 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(1777, 2, 10);
		duration = new Duration(0, 1, 0);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 1777 && ymd.getMonth() == 3 && ymd.getDay() == 10);
		
		ymd = new YearMonthDay(1777, 2, 10);
		duration = new Duration(0, 2, 0);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 1777 && ymd.getMonth() == 4 && ymd.getDay() == 10);
		
		ymd = new YearMonthDay(1777, 2, 10);
		duration = new Duration(0, 5, 0);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 1777 && ymd.getMonth() == 7 && ymd.getDay() == 10);
		
		ymd = new YearMonthDay(1777, 2, 10);
		duration = new Duration(0, 10, 0);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 1777 && ymd.getMonth() == 12 && ymd.getDay() == 10);
		
		ymd = new YearMonthDay(1777, 2, 10);
		duration = new Duration(0, 11, 0);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 1778 && ymd.getMonth() == 1 && ymd.getDay() == 10);
		
		ymd = new YearMonthDay(1777, 2, 10);
		duration = new Duration(0, 11, 30);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 1778 && ymd.getMonth() == 2 && ymd.getDay() == 9);
		
		ymd = new YearMonthDay(1951, 1, 29);
		duration = new Duration(0, 1, 0);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 1951 && ymd.getMonth() == 2 && ymd.getDay() == 28);
		
		ymd = new YearMonthDay(1952, 1, 29);
		duration = new Duration(0, 1, 0);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 1952 && ymd.getMonth() == 2 && ymd.getDay() == 29);
		
		ymd = new YearMonthDay(-1, 12, 31);
		duration = new Duration(0, 1, 0);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 1 && ymd.getMonth() == 1 && ymd.getDay() == 31);
		
		ymd = new YearMonthDay(-1, 12, 31);
		duration = new Duration(0, 0, 1);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(-1, 12, 31);
		duration = new Duration(0, 0, 30);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 1 && ymd.getMonth() == 1 && ymd.getDay() == 30);
		
		ymd = new YearMonthDay(-1, 1, 1);
		duration = new Duration(0, 11, 30);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 12 && ymd.getDay() == 31);
		
		ymd = new YearMonthDay(-1, 1, 2);
		duration = new Duration(0, 11, 30);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(-1, 1, 3);
		duration = new Duration(0, 11, 30);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 1 && ymd.getMonth() == 1 && ymd.getDay() == 2);
		
		ymd = new YearMonthDay(1951, 12, 31);
		duration = new Duration(0, 11, 0);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 1952 && ymd.getMonth() == 11 && ymd.getDay() == 30);
		
		// Test years
		ymd = new YearMonthDay(1, 1, 1);
		duration = new Duration(1, 0, 0);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 2 && ymd.getMonth() == 1 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(1, 1, 1);
		duration = new Duration(2, 0, 0);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 3 && ymd.getMonth() == 1 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(1, 1, 1);
		duration = new Duration(3, 0, 0);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 4 && ymd.getMonth() == 1 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(1, 1, 1);
		duration = new Duration(4, 0, 0);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 5 && ymd.getMonth() == 1 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(1, 1, 1);
		duration = new Duration(100, 0, 0);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 101 && ymd.getMonth() == 1 && ymd.getDay() == 1);		
		
		ymd = new YearMonthDay(3, 1, 1);
		duration = new Duration(1, 0, 0);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 4 && ymd.getMonth() == 1 && ymd.getDay() == 1);	
		
		ymd = new YearMonthDay(4, 1, 1);
		duration = new Duration(1, 0, 0);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 5 && ymd.getMonth() == 1 && ymd.getDay() == 1);	
		
		ymd = new YearMonthDay(1960, 1, 1);
		duration = new Duration(1, 0, 0);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 1961 && ymd.getMonth() == 1 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(-2, 1, 1);
		duration = new Duration(2, 0, 0);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(-1, 1, 1);
		duration = new Duration(1, 0, 0);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(-10, 1, 1);
		duration = new Duration(11, 0, 0);
		ymd.increaseBy(duration);
		assertTrue(ymd.getYear() == 2 && ymd.getMonth() == 1 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(1981, 2, 28);
		ymd.increaseBy(Duration.ONE_DAY);
		YearMonthDay expectedResult = new YearMonthDay(1981,3,1);
		assertTrue(ymd.equals(expectedResult));
	}

//	@Test
//	public void testIncreaseByUsingJulianDayPerspective() {
//	// Test errors
//		YearMonthDay ymd = new YearMonthDay(YearMonthDay.MAX_YEAR,
//											YearMonthDay.MAX_MONTH_OF_MAX_YEAR,
//											YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR);
//		Duration duration = new Duration(0, 0, 1);
//	
//		try{
//			ymd.increaseByJulianDayPerspective(null);
//			fail(JUNIT_FAIL);
//		} catch(AssertionError e) {checkForFailure(e);}
//		
//		duration = new Duration(0, 0, 1);
//		try{
//			ymd.increaseByJulianDayPerspective(duration);
//			fail(JUNIT_FAIL);
//		} catch(AssertionError e) {checkForFailure(e);}
//		
//		duration = new Duration(0, 1, 0);
//		try{
//			ymd.increaseByJulianDayPerspective(duration);
//			fail(JUNIT_FAIL);
//		} catch(AssertionError e) {checkForFailure(e);}
//		
//		duration = new Duration(1, 0, 0);
//		try{
//			ymd.increaseByJulianDayPerspective(duration);
//			fail(JUNIT_FAIL);
//		} catch(AssertionError e) {checkForFailure(e);}
//		
//		duration = new Duration(1, 1, 1);
//		try{
//			ymd.increaseByJulianDayPerspective(duration);
//			fail(JUNIT_FAIL);
//		} catch(AssertionError e) {checkForFailure(e);}
//
//	//Reevaluate, Possibly redundant tests
//		//Test Years
//		ymd = new YearMonthDay(99, 1, 1);
//		ymd.increaseByJulianDayPerspective(Duration.ONE_YEAR);
//		assertTrue(ymd.toString(), ymd.getYear() == 100 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(100, 1, 1);
//		ymd.increaseByJulianDayPerspective(Duration.ONE_YEAR);
//		assertTrue(ymd.toString(), ymd.getYear() == 101 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(101, 1, 1);
//		ymd.increaseByJulianDayPerspective(Duration.ONE_YEAR);
//		assertTrue(ymd.toString(), ymd.getYear() == 102 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(399, 1, 1);
//		ymd.increaseByJulianDayPerspective(Duration.ONE_YEAR);
//		assertTrue(ymd.toString(), ymd.getYear() == 400 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(400, 1, 1);
//		ymd.increaseByJulianDayPerspective(Duration.ONE_YEAR);
//		assertTrue(ymd.toString(), ymd.getYear() == 401 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(401, 1, 1);
//		ymd.increaseByJulianDayPerspective(Duration.ONE_YEAR);
//		assertTrue(ymd.toString(), ymd.getYear() == 402 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2016, 2, 28);
//		ymd.increaseByJulianDayPerspective(Duration.ONE_YEAR);
//		assertTrue(ymd.toString(), ymd.getYear() == 2017 && ymd.getMonth() == 2 && ymd.getDay() == 28);
//		
//		ymd = new YearMonthDay(2016, 3, 1);
//		ymd.increaseByJulianDayPerspective(Duration.ONE_YEAR);
//		assertTrue(ymd.toString(), ymd.getYear() == 2017 && ymd.getMonth() == 3 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2016, 2, 29);
//		ymd.increaseByJulianDayPerspective(Duration.ONE_YEAR);
//		assertTrue(ymd.toString(), ymd.getYear() == 2017 && ymd.getMonth() == 3 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2016, 3, 1);
//		ymd.increaseByJulianDayPerspective(Duration.ONE_YEAR);
//		assertTrue(ymd.getYear() == 2017 && ymd.getMonth() == 3 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2015, 3, 1);
//		ymd.increaseByJulianDayPerspective(Duration.ONE_YEAR);
//		assertTrue(ymd.toString(), ymd.getYear() == 2016 && ymd.getMonth() == 3 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2013, 3, 1);
//		ymd.increaseByJulianDayPerspective(new Duration(4, 0, 0));
//		assertTrue(ymd.getYear() == 2017 && ymd.getMonth() == 3 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2013, 3, 1);
//		ymd.increaseByJulianDayPerspective(new Duration(3, 0, 0));
//		assertTrue(ymd.getYear() == 2016 && ymd.getMonth() == 3 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2013, 2, 28);
//		ymd.increaseByJulianDayPerspective(new Duration(3, 0, 0));
//		assertTrue(ymd.getYear() == 2016 && ymd.getMonth() == 2 && ymd.getDay() == 28);
//		
//		ymd = new YearMonthDay(2013, 2, 28);
//		ymd.increaseByJulianDayPerspective(new Duration(4, 0, 0));
//		assertTrue(ymd.getYear() == 2017 && ymd.getMonth() == 2 && ymd.getDay() == 28);
//		
//		ymd = new YearMonthDay(2014, 3, 1);
//		ymd.increaseByJulianDayPerspective(Duration.ONE_YEAR);
//		assertTrue(ymd.getYear() == 2015 && ymd.getMonth() == 3 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2017, 3, 1);
//		ymd.increaseByJulianDayPerspective(Duration.ONE_YEAR);
//		assertTrue(ymd.getYear() == 2018 && ymd.getMonth() == 3 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-1, 1, 1);
//		ymd.increaseByJulianDayPerspective(Duration.ONE_YEAR);
//		assertTrue(ymd.toString(), ymd.getYear() == 1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-2, 1, 1);
//		ymd.increaseByJulianDayPerspective(Duration.ONE_YEAR);
//		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-2, 1, 1);
//		ymd.increaseByJulianDayPerspective(new Duration(2, 0, 0));
//		assertTrue(ymd.getYear() == 1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-10, 1, 1);
//		ymd.increaseByJulianDayPerspective(new Duration(9, 0, 0));
//		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-101, 1, 1);
//		ymd.increaseByJulianDayPerspective(new Duration(5, 0, 0));
//		assertTrue(ymd.getYear() == -96 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-401, 1, 1);
//		ymd.increaseByJulianDayPerspective(new Duration(5, 0, 0));
//		assertTrue(ymd.getYear() == -396 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-3201, 1, 1);
//		ymd.increaseByJulianDayPerspective(new Duration(1, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -3200 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-4001, 1, 1);
//		ymd.increaseByJulianDayPerspective(new Duration(1, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -4000 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-9, 2, 28);
//		ymd.increaseByJulianDayPerspective(Duration.ONE_YEAR);
//		assertTrue(ymd.getYear() == -8 && ymd.getMonth() == 2 && ymd.getDay() == 28);
//		
//		ymd = new YearMonthDay(-9, 3, 1);
//		ymd.increaseByJulianDayPerspective(Duration.ONE_YEAR);
//		assertTrue(ymd.getYear() == -8 && ymd.getMonth() == 3 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-9, 2, 29);
//		ymd.increaseByJulianDayPerspective(Duration.ONE_YEAR);
//		assertTrue(ymd.getYear() == -8 && ymd.getMonth() == 3 && ymd.getDay() == 1);
//		
//		//Test Months
//		ymd = new YearMonthDay(1, 1, 1);
//		ymd.increaseByJulianDayPerspective(Duration.ONE_MONTH);
//		assertTrue(ymd.toString(), ymd.getYear() == 1 && ymd.getMonth() == 2 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(1, 11, 1);
//		ymd.increaseByJulianDayPerspective(Duration.ONE_MONTH);
//		assertTrue(ymd.toString(), ymd.getYear() == 1 && ymd.getMonth() == 12 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(1, 12, 1);
//		ymd.increaseByJulianDayPerspective(Duration.ONE_MONTH);
//		assertTrue(ymd.toString(), ymd.getYear() == 2 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(1, 1, 1);
//		ymd.increaseByJulianDayPerspective(new Duration(0, 12, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == 2 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(1, 3, 31);
//		ymd.increaseByJulianDayPerspective(Duration.ONE_MONTH);
//		assertTrue(ymd.toString(), ymd.getYear() == 1 && ymd.getMonth() == 5 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(1, 7, 31);
//		ymd.increaseByJulianDayPerspective(Duration.ONE_MONTH);
//		assertTrue(ymd.toString(), ymd.getYear() == 1 && ymd.getMonth() == 8 && ymd.getDay() == 31);
//		
//		ymd = new YearMonthDay(1, 12, 31);
//		ymd.increaseByJulianDayPerspective(Duration.ONE_MONTH);
//		assertTrue(ymd.toString(), ymd.getYear() == 2 && ymd.getMonth() == 1 && ymd.getDay() == 31);
//		
//		ymd = new YearMonthDay(-1, 12, 31);
//		ymd.increaseByJulianDayPerspective(Duration.ONE_MONTH);
//		assertTrue(ymd.toString(), ymd.getYear() == 1 && ymd.getMonth() == 1 && ymd.getDay() == 31);
//	
//		ymd = new YearMonthDay(1, 1, 28);
//		ymd.increaseByJulianDayPerspective(Duration.ONE_MONTH);
//		assertTrue(ymd.toString(), ymd.getYear() == 1 && ymd.getMonth() == 2 && ymd.getDay() == 28);
//		
//		ymd = new YearMonthDay(1, 1, 29);
//		ymd.increaseByJulianDayPerspective(Duration.ONE_MONTH);
//		assertTrue(ymd.toString(), ymd.getYear() == 1 && ymd.getMonth() == 3 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(1, 1, 30);
//		ymd.increaseByJulianDayPerspective(Duration.ONE_MONTH);
//		assertTrue(ymd.toString(), ymd.getYear() == 1 && ymd.getMonth() == 3 && ymd.getDay() == 2);
//		
//		ymd = new YearMonthDay(1, 1, 31);
//		ymd.increaseByJulianDayPerspective(Duration.ONE_MONTH);
//		assertTrue(ymd.toString(), ymd.getYear() == 1 && ymd.getMonth() == 3 && ymd.getDay() == 3);
//		
//		ymd = new YearMonthDay(1, 2, 28);
//		ymd.increaseByJulianDayPerspective(Duration.ONE_MONTH);
//		assertTrue(ymd.toString(), ymd.getYear() == 1 && ymd.getMonth() == 3 && ymd.getDay() == 28);
//		
//		ymd = new YearMonthDay(4, 2, 28);
//		ymd.increaseByJulianDayPerspective(Duration.ONE_MONTH);
//		assertTrue(ymd.toString(), ymd.getYear() == 4 && ymd.getMonth() == 3 && ymd.getDay() == 28);
//		
//		ymd = new YearMonthDay(4, 2, 29);
//		ymd.increaseByJulianDayPerspective(Duration.ONE_MONTH);
//		assertTrue(ymd.toString(), ymd.getYear() == 4 && ymd.getMonth() == 3 && ymd.getDay() == 29);
//		
//		Duration elevenMonths = new Duration(0, 11, 0);
//		ymd = new YearMonthDay(4, 1, 1);
//		ymd.increaseByJulianDayPerspective(elevenMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 4 && ymd.getMonth() == 12 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(4, 2, 1);
//		ymd.increaseByJulianDayPerspective(elevenMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 5 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(4, 3, 1);
//		ymd.increaseByJulianDayPerspective(elevenMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 5 && ymd.getMonth() == 2 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(4, 4, 1);
//		ymd.increaseByJulianDayPerspective(elevenMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 5 && ymd.getMonth() == 3 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(4, 5, 1);
//		ymd.increaseByJulianDayPerspective(elevenMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 5 && ymd.getMonth() == 4 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(4, 11, 1);
//		ymd.increaseByJulianDayPerspective(elevenMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 5 && ymd.getMonth() == 10 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(4, 12, 1);
//		ymd.increaseByJulianDayPerspective(elevenMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 5 && ymd.getMonth() == 11 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(4, 1, 1);
//		ymd.increaseByJulianDayPerspective(elevenMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 4 && ymd.getMonth() == 12 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(4, 1, 31);
//		ymd.increaseByJulianDayPerspective(elevenMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 4 && ymd.getMonth() == 12 && ymd.getDay() == 31);
//		
//		ymd = new YearMonthDay(4, 2, 29);
//		ymd.increaseByJulianDayPerspective(elevenMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 5 && ymd.getMonth() == 1 && ymd.getDay() == 29);
//		
//		ymd = new YearMonthDay(4, 3, 31);
//		ymd.increaseByJulianDayPerspective(elevenMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 5 && ymd.getMonth() == 3 && ymd.getDay() == 3);
//		
//		ymd = new YearMonthDay(4, 4, 30);
//		ymd.increaseByJulianDayPerspective(elevenMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 5 && ymd.getMonth() == 3 && ymd.getDay() == 30);
//		
//		ymd = new YearMonthDay(4, 5, 31);
//		ymd.increaseByJulianDayPerspective(elevenMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 5 && ymd.getMonth() == 5 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(4, 7, 31);
//		ymd.increaseByJulianDayPerspective(elevenMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 5 && ymd.getMonth() == 7 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(4, 8, 31);
//		ymd.increaseByJulianDayPerspective(elevenMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 5 && ymd.getMonth() == 7 && ymd.getDay() == 31);
//		
//		ymd = new YearMonthDay(4, 10, 31);
//		ymd.increaseByJulianDayPerspective(elevenMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 5 && ymd.getMonth() == 10 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(4, 11, 30);
//		ymd.increaseByJulianDayPerspective(elevenMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 5 && ymd.getMonth() == 10 && ymd.getDay() == 30);
//		
//		ymd = new YearMonthDay(4, 12, 31);
//		ymd.increaseByJulianDayPerspective(elevenMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 5 && ymd.getMonth() == 12 && ymd.getDay() == 1);
//		
//		Duration twelveMonths = new Duration(0, 12, 0);
//		ymd = new YearMonthDay(4, 1, 1);
//		ymd.increaseByJulianDayPerspective(twelveMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 5 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(4, 2, 1);
//		ymd.increaseByJulianDayPerspective(twelveMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 5 && ymd.getMonth() == 2 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(4, 3, 1);
//		ymd.increaseByJulianDayPerspective(twelveMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 5 && ymd.getMonth() == 3 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(4, 4, 1);
//		ymd.increaseByJulianDayPerspective(twelveMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 5 && ymd.getMonth() == 4 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(4, 5, 1);
//		ymd.increaseByJulianDayPerspective(twelveMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 5 && ymd.getMonth() == 5 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(4, 11, 1);
//		ymd.increaseByJulianDayPerspective(twelveMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 5 && ymd.getMonth() == 11 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(4, 12, 1);
//		ymd.increaseByJulianDayPerspective(twelveMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 5 && ymd.getMonth() == 12 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(4, 1, 1);
//		ymd.increaseByJulianDayPerspective(twelveMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 5 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(4, 1, 31);
//		ymd.increaseByJulianDayPerspective(twelveMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 5 && ymd.getMonth() == 1 && ymd.getDay() == 31);
//		
//		ymd = new YearMonthDay(3, 2, 28);
//		ymd.increaseByJulianDayPerspective(twelveMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 4 && ymd.getMonth() == 2 && ymd.getDay() == 28);
//		
//		ymd = new YearMonthDay(4, 2, 28);
//		ymd.increaseByJulianDayPerspective(twelveMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 5 && ymd.getMonth() == 2 && ymd.getDay() == 28);
//		
//		ymd = new YearMonthDay(4, 2, 29);
//		ymd.increaseByJulianDayPerspective(twelveMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 5 && ymd.getMonth() == 3 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(4, 3, 31);
//		ymd.increaseByJulianDayPerspective(twelveMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 5 && ymd.getMonth() == 3 && ymd.getDay() == 31);
//		
//		ymd = new YearMonthDay(4, 4, 30);
//		ymd.increaseByJulianDayPerspective(twelveMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 5 && ymd.getMonth() == 4 && ymd.getDay() == 30);
//		
//		ymd = new YearMonthDay(4, 5, 31);
//		ymd.increaseByJulianDayPerspective(twelveMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 5 && ymd.getMonth() == 5 && ymd.getDay() == 31);
//		
//		ymd = new YearMonthDay(4, 7, 31);
//		ymd.increaseByJulianDayPerspective(twelveMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 5 && ymd.getMonth() == 7 && ymd.getDay() == 31);
//		
//		ymd = new YearMonthDay(4, 8, 31);
//		ymd.increaseByJulianDayPerspective(twelveMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 5 && ymd.getMonth() == 8 && ymd.getDay() == 31);
//		
//		ymd = new YearMonthDay(4, 10, 31);
//		ymd.increaseByJulianDayPerspective(twelveMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 5 && ymd.getMonth() == 10 && ymd.getDay() == 31);
//		
//		ymd = new YearMonthDay(4, 11, 30);
//		ymd.increaseByJulianDayPerspective(twelveMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 5 && ymd.getMonth() == 11 && ymd.getDay() == 30);
//		
//		ymd = new YearMonthDay(4, 12, 31);
//		ymd.increaseByJulianDayPerspective(twelveMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 5 && ymd.getMonth() == 12 && ymd.getDay() == 31);
//
//		ymd = new YearMonthDay(-1, 12, 1);
//		ymd.increaseByJulianDayPerspective(twelveMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 1 && ymd.getMonth() == 12 && ymd.getDay() == 1);
//
//		ymd = new YearMonthDay(-1, 12, 31);
//		ymd.increaseByJulianDayPerspective(twelveMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 1 && ymd.getMonth() == 12 && ymd.getDay() == 31);
//
//		ymd = new YearMonthDay(-1, 1, 1);
//		ymd.increaseByJulianDayPerspective(twelveMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//
//		ymd = new YearMonthDay(-1, 1, 31);
//		ymd.increaseByJulianDayPerspective(twelveMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 1 && ymd.getMonth() == 1 && ymd.getDay() == 31);
//
//		ymd = new YearMonthDay(-1, 2, 29);
//		ymd.increaseByJulianDayPerspective(twelveMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 1 && ymd.getMonth() == 3 && ymd.getDay() == 1);
//
//		ymd = new YearMonthDay(-1, 3, 1);
//		ymd.increaseByJulianDayPerspective(twelveMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == 1 && ymd.getMonth() == 3 && ymd.getDay() == 1);
//
//		ymd = new YearMonthDay(-8, 12, 1);
//		ymd.increaseByJulianDayPerspective(twelveMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == -7 && ymd.getMonth() == 12 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-8, 1, 1);
//		ymd.increaseByJulianDayPerspective(twelveMonths);
//		assertTrue(ymd.toString(), ymd.getYear() == -7 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//
//		ymd = new YearMonthDay(-8, 1, 31);
//		ymd.increaseByJulianDayPerspective(twelveMonths);
//		assertTrue(ymd.toString(), ymd.getYear() ==-7 && ymd.getMonth() == 1 && ymd.getDay() == 31);
//
//		ymd = new YearMonthDay(-9, 2, 29);
//		ymd.increaseByJulianDayPerspective(twelveMonths);
//		assertTrue(ymd.toString(), ymd.getYear() ==-8 && ymd.getMonth() == 3 && ymd.getDay() == 1);
//
//		ymd = new YearMonthDay(-9, 3, 1);
//		ymd.increaseByJulianDayPerspective(twelveMonths);
//		assertTrue(ymd.toString(), ymd.getYear() ==-8 && ymd.getMonth() == 3 && ymd.getDay() == 1);
//
//		ymd = new YearMonthDay(-8, 3, 1);
//		ymd.increaseByJulianDayPerspective(twelveMonths);
//		assertTrue(ymd.toString(), ymd.getYear() ==-7 && ymd.getMonth() == 3 && ymd.getDay() == 1);
//
//		ymd = new YearMonthDay(-8, 2, 28);
//		ymd.increaseByJulianDayPerspective(twelveMonths);
//		assertTrue(ymd.toString(), ymd.getYear() ==-7 && ymd.getMonth() == 2 && ymd.getDay() == 28);
//
//		ymd = new YearMonthDay(1, 1, 1);
//		ymd.increaseByJulianDayPerspective(new Duration(0, 100, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == 9 && ymd.getMonth() == 5 && ymd.getDay() == 1);
//		
//	//Normal Tests
//		ymd = new YearMonthDay(2018, 10, 10);
//		ymd.increaseByJulianDayPerspective(Duration.ZERO_DURATION);
//		assertTrue(ymd.getYear() == 2018 && ymd.getMonth() == 10 && ymd.getDay() == 10);
//		
//		ymd = new YearMonthDay(2018, 10, 10);
//		ymd.increaseByJulianDayPerspective(Duration.ONE_DAY);
//		assertTrue(ymd.getYear() == 2018 && ymd.getMonth() == 10 && ymd.getDay() == 11);
//		
//		ymd = new YearMonthDay(2018, 10, 10);
//		ymd.increaseByJulianDayPerspective(new Duration(0, 0, 21));
//		assertTrue(ymd.getYear() == 2018 && ymd.getMonth() == 10 && ymd.getDay() == 31);
//		
//		ymd = new YearMonthDay(2018, 10, 10);
//		ymd.increaseByJulianDayPerspective(new Duration(0, 0, 22));
//		assertTrue(ymd.getYear() == 2018 && ymd.getMonth() == 11 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2018, 10, 31);
//		ymd.increaseByJulianDayPerspective(new Duration(0, 0, 30));
//		assertTrue(ymd.getYear() == 2018 && ymd.getMonth() == 11 && ymd.getDay() == 30);
//		
//		ymd = new YearMonthDay(2018, 1, 31);
//		duration = new Duration(0, 0, 30);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 2018 && ymd.getMonth() == 3 && ymd.getDay() == 2);
//		
//		ymd = new YearMonthDay(2016, 1, 31);
//		duration = new Duration(0, 0, 30);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 2016 && ymd.getMonth() == 3 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2016, 2, 29);
//		duration = new Duration(0, 0, 30);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.toString(), ymd.getYear() == 2016 && ymd.getMonth() == 3 && ymd.getDay() == 30);
//		
//		ymd = new YearMonthDay(2016, 11, 30);
//		duration = new Duration(0, 0, 30);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 2016 && ymd.getMonth() == 12 && ymd.getDay() == 30);
//		
//		ymd = new YearMonthDay(2016, 12, 31);
//		duration = new Duration(0, 0, 30);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 2017 && ymd.getMonth() == 1 && ymd.getDay() == 30);
//		
//		ymd = new YearMonthDay(2016, 12, 30);
//		duration = new Duration(0, 0, 30);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 2017 && ymd.getMonth() == 1 && ymd.getDay() == 29);
//		
//		ymd = new YearMonthDay(2016, 12, 1);
//		duration = new Duration(0, 0, 30);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 2016 && ymd.getMonth() == 12 && ymd.getDay() == 31);
//		
//		ymd = new YearMonthDay(2016, 12, 2);
//		duration = new Duration(0, 0, 30);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 2017 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-1, 12, 1);
//		duration = new Duration(0, 0, 30);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 12 && ymd.getDay() == 31);
//		
//		ymd = new YearMonthDay(-1, 12, 2);
//		duration = new Duration(0, 0, 30);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-1, 12, 31);
//		duration = new Duration(0, 0, 1);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-1, 12, 31);
//		duration = new Duration(0, 0, 30);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1 && ymd.getMonth() == 1 && ymd.getDay() == 30);
//		
//		ymd = new YearMonthDay(YearMonthDay.MIN_YMD);
//		duration = new Duration(0, 0, 1);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == YearMonthDay.MIN_YEAR &&
//				   ymd.getMonth() == YearMonthDay.MIN_MONTH_OF_MIN_YEAR &&
//				   ymd.getDay() == YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR + 1);
//
//		ymd = new YearMonthDay(YearMonthDay.MIN_YMD);
//		duration = new Duration(0, 0, 30);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == YearMonthDay.MIN_YEAR && ymd.getMonth() == 12 && ymd.getDay() == YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR);
//
//		ymd = new YearMonthDay(-50, 6, 10);
//		duration = new Duration(0, 0, 20);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -50 && ymd.getMonth() == 6 && ymd.getDay() == 30);
//
//		ymd = new YearMonthDay(-50, 6, 10);
//		duration = new Duration(0, 1, 30);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -50 && ymd.getMonth() == 8 && ymd.getDay() == 9);
//
//		ymd = new YearMonthDay(2015, 6, 10);
//		duration = new Duration(0, 9, 0);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.toString(), ymd.getYear() == 2016 && ymd.getMonth() == 3 && ymd.getDay() == 10);
//		
//		ymd = new YearMonthDay(1960, 2, 29);
//		ymd.increaseByJulianDayPerspective(Duration.ZERO_DURATION);
//		assertTrue(ymd.getYear() == 1960 && ymd.getMonth() == 2 && ymd.getDay() == 29);
//		
//		ymd = new YearMonthDay(1960, 2, 29);
//		ymd.increaseByJulianDayPerspective(Duration.ONE_DAY);
//		assertTrue(ymd.getYear() == 1960 && ymd.getMonth() == 3 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(1960, 2, 29);
//		duration = new Duration(0, 0, 2);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1960 && ymd.getMonth() == 3 && ymd.getDay() == 2);
//		
//		ymd = new YearMonthDay(1960, 2, 28);
//		ymd.increaseByJulianDayPerspective(Duration.ONE_DAY);
//		assertTrue(ymd.getYear() == 1960 && ymd.getMonth() == 2 && ymd.getDay() == 29);
//		
//		ymd = new YearMonthDay(1960, 2, 28);
//		duration = new Duration(0, 0, 2);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1960 && ymd.getMonth() == 3 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(1961, 2, 28);
//		ymd.increaseByJulianDayPerspective(Duration.ZERO_DURATION);
//		assertTrue(ymd.getYear() == 1961 && ymd.getMonth() == 2 && ymd.getDay() == 28);
//		
//		ymd = new YearMonthDay(1961, 2, 28);
//		ymd.increaseByJulianDayPerspective(Duration.ONE_DAY);
//		assertTrue(ymd.getYear() == 1961 && ymd.getMonth() == 3 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(1961, 2, 28);
//		duration = new Duration(0, 0, 2);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1961 && ymd.getMonth() == 3 && ymd.getDay() == 2);
//		
//		ymd = new YearMonthDay(1961, 2, 27);
//		ymd.increaseByJulianDayPerspective(Duration.ONE_DAY);
//		assertTrue(ymd.getYear() == 1961 && ymd.getMonth() == 2 && ymd.getDay() == 28);
//		
//		ymd = new YearMonthDay(1961, 2, 27);
//		duration = new Duration(0, 0, 2);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1961 && ymd.getMonth() == 3 && ymd.getDay() == 1);
//		
//		// Test negative leap years
//		ymd = new YearMonthDay(-1, 2, 1);
//		duration = new Duration(0, 0, 30);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 3 && ymd.getDay() == 2);
//		
//		ymd = new YearMonthDay(-1, 1, 31);
//		duration = new Duration(0, 0, 30);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 3 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-1, 2, 29);
//		duration = new Duration(0, 0, 1);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 3 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-1, 2, 28);
//		duration = new Duration(0, 0, 1);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 2 && ymd.getDay() == 29);
//		
//		ymd = new YearMonthDay(-1, 2, 15);
//		duration = new Duration(0, 0, 25);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 3 && ymd.getDay() == 11);
//		
//		ymd = new YearMonthDay(-100, 2, 25);
//		duration = new Duration(0, 0, 10);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -100 && ymd.getMonth() == 3 && ymd.getDay() == YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR);
//		
//		ymd = new YearMonthDay(-101, 2, 25);
//		duration = new Duration(0, 0, 10);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -101 && ymd.getMonth() == 3 && ymd.getDay() == YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR);
//		
//		ymd = new YearMonthDay(-105, 2, 25);
//		duration = new Duration(0, 0, 10);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -105 && ymd.getMonth() == 3 && ymd.getDay() == 6);
//		
//		ymd = new YearMonthDay(-400, 2, 25);
//		duration = new Duration(0, 0, 10);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -400 && ymd.getMonth() == 3 && ymd.getDay() == YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR);
//		
//		ymd = new YearMonthDay(-401, 2, 25);
//		duration = new Duration(0, 0, 10);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -401 && ymd.getMonth() == 3 && ymd.getDay() == 6);
//		
//		ymd = new YearMonthDay(-3200, 2, 25);
//		duration = new Duration(0, 0, 10);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -3200 && ymd.getMonth() == 3 && ymd.getDay() == 7);
//		
//		ymd = new YearMonthDay(-3201, 2, 25);
//		duration = new Duration(0, 0, 10);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -3201 && ymd.getMonth() == 3 && ymd.getDay() == 6);
//		
//		// Test Normal Again
//		ymd = new YearMonthDay(2001, 1, 25);
//		duration = new Duration(0, 0, 10);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 2001 && ymd.getMonth() == 2 && ymd.getDay() == 4);
//		
//		ymd = new YearMonthDay(1928, 2, 7);
//		duration = new Duration(0, 0, 10);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1928 && ymd.getMonth() == 2 && ymd.getDay() == 17);
//		
//		ymd = new YearMonthDay(1899, 6, 21);
//		duration = new Duration(0, 0, 10);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1899 && ymd.getMonth() == 7 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(1881, 11, 30);
//		duration = new Duration(0, 0, 10);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1881 && ymd.getMonth() == 12 && ymd.getDay() == 10);
//		
//		//Test Months
//		ymd = new YearMonthDay(1881, 1, 1);
//		duration = new Duration(0, 1, 0);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1881 && ymd.getMonth() == 2 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(1881, 1, 1);
//		duration = new Duration(0, 2, 0);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1881 && ymd.getMonth() == 3 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(1881, 1, 1);
//		duration = new Duration(0, 10, 0);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1881 && ymd.getMonth() == 11 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(1881, 1, 1);
//		duration = new Duration(0, 11, 0);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1881 && ymd.getMonth() == 12 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(1777, 2, 10);
//		duration = new Duration(0, 1, 0);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1777 && ymd.getMonth() == 3 && ymd.getDay() == 10);
//		
//		ymd = new YearMonthDay(1777, 2, 10);
//		duration = new Duration(0, 2, 0);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1777 && ymd.getMonth() == 4 && ymd.getDay() == 10);
//		
//		ymd = new YearMonthDay(1777, 2, 10);
//		duration = new Duration(0, 5, 0);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1777 && ymd.getMonth() == 7 && ymd.getDay() == 10);
//		
//		ymd = new YearMonthDay(1777, 2, 10);
//		duration = new Duration(0, 10, 0);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1777 && ymd.getMonth() == 12 && ymd.getDay() == 10);
//		
//		ymd = new YearMonthDay(1777, 2, 10);
//		duration = new Duration(0, 11, 0);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1778 && ymd.getMonth() == 1 && ymd.getDay() == 10);
//		
//		ymd = new YearMonthDay(1777, 2, 10);
//		duration = new Duration(0, 11, 30);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1778 && ymd.getMonth() == 2 && ymd.getDay() == 9);
//		
//		ymd = new YearMonthDay(1951, 1, 29);
//		duration = new Duration(0, 1, 0);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1951 && ymd.getMonth() == 3 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(1952, 1, 29);
//		duration = new Duration(0, 1, 0);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1952 && ymd.getMonth() == 2 && ymd.getDay() == 29);
//		
//		ymd = new YearMonthDay(-1, 12, 31);
//		duration = new Duration(0, 1, 0);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1 && ymd.getMonth() == 1 && ymd.getDay() == 31);
//		
//		ymd = new YearMonthDay(-1, 12, 31);
//		duration = new Duration(0, 0, 1);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-1, 12, 31);
//		duration = new Duration(0, 0, 30);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1 && ymd.getMonth() == 1 && ymd.getDay() == 30);
//		
//		ymd = new YearMonthDay(-1, 1, 1);
//		duration = new Duration(0, 11, 30);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 12 && ymd.getDay() == 31);
//		
//		ymd = new YearMonthDay(-1, 1, 2);
//		duration = new Duration(0, 11, 30);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-1, 1, 3);
//		duration = new Duration(0, 11, 30);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1 && ymd.getMonth() == 1 && ymd.getDay() == 2);
//		
//		ymd = new YearMonthDay(1951, 12, 31);
//		duration = new Duration(0, 11, 0);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.toString(), ymd.getYear() == 1952 && ymd.getMonth() == 12 && ymd.getDay() == 1);
//		
//		// Test years
//		ymd = new YearMonthDay(1, 1, 1);
//		duration = new Duration(1, 0, 0);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 2 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(1, 1, 1);
//		duration = new Duration(2, 0, 0);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 3 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(1, 1, 1);
//		duration = new Duration(3, 0, 0);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 4 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(1, 1, 1);
//		duration = new Duration(4, 0, 0);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 5 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(1, 1, 1);
//		duration = new Duration(100, 0, 0);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 101 && ymd.getMonth() == 1 && ymd.getDay() == 1);		
//		
//		ymd = new YearMonthDay(3, 1, 1);
//		duration = new Duration(1, 0, 0);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 4 && ymd.getMonth() == 1 && ymd.getDay() == 1);	
//		
//		ymd = new YearMonthDay(4, 1, 1);
//		duration = new Duration(1, 0, 0);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 5 && ymd.getMonth() == 1 && ymd.getDay() == 1);	
//		
//		ymd = new YearMonthDay(1960, 1, 1);
//		duration = new Duration(1, 0, 0);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1961 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-2, 1, 1);
//		duration = new Duration(2, 0, 0);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-1, 1, 1);
//		duration = new Duration(1, 0, 0);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-10, 1, 1);
//		duration = new Duration(11, 0, 0);
//		ymd.increaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 2 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//	}
	
	@Test
	public void testDecreaseBy() {
		YearMonthDay ymd = new YearMonthDay(YearMonthDay.MIN_YEAR,
											YearMonthDay.MIN_MONTH_OF_MIN_YEAR,
											YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR);
		try{
			ymd.decreaseBy(null);
			fail(JUNIT_FAIL);
		} catch(AssertionError e) {checkForFailure(e);}
		
		Duration duration = new Duration(0, 0, 1);
		try{
			ymd.decreaseBy(duration);
			fail(JUNIT_FAIL);
		} catch(AssertionError e) {checkForFailure(e);}

		duration = new Duration(0, 1, 0);
		try{
			ymd.decreaseBy(duration);
			fail(JUNIT_FAIL);
		} catch(AssertionError e) {checkForFailure(e);}
		
		duration = new Duration(1, 0, 0);
		try{
			ymd.decreaseBy(duration);
			fail(JUNIT_FAIL);
		} catch(AssertionError e) {checkForFailure(e);}
		
		duration = new Duration(1, 1, 1);
		try{
			ymd.decreaseBy(duration);
			fail(JUNIT_FAIL);
		} catch(AssertionError e) {checkForFailure(e);}
	
	//Normal Tests
		ymd = new YearMonthDay(1905, 12, 31);
		duration = new Duration(2, 0, 0);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == 1903 && ymd.getMonth() == 12 && ymd.getDay() == 31);
		
		ymd = new YearMonthDay(1905, 1, 1);
		duration = new Duration(2, 20, 0);
		ymd.decreaseBy(duration);
		assertTrue(ymd.toString(), ymd.getYear() == 1901 && ymd.getMonth() == 5 && ymd.getDay() == 1);

		ymd = new YearMonthDay(1905, 1, 1);
		duration = new Duration(2, 20, 40);
		ymd.decreaseBy(duration);
		assertTrue(ymd.toString(), ymd.getYear() == 1901 && ymd.getMonth() == 3 && ymd.getDay() == 22);

		ymd = new YearMonthDay(-1905, 1, 1);
		duration = new Duration(2, 20, 40);
		ymd.decreaseBy(duration);
		assertTrue(ymd.toString(), ymd.getYear() == -1909 && ymd.getMonth() == 3 && ymd.getDay() == 22);

		ymd = new YearMonthDay(2018, 10, 10);
		ymd.decreaseBy(Duration.ZERO_DURATION);
		assertTrue(ymd.getYear() == 2018 && ymd.getMonth() == 10 && ymd.getDay() == 10);
		
		ymd = new YearMonthDay(2018, 10, 10);
		ymd.decreaseBy(Duration.ONE_DAY);
		assertTrue(ymd.getYear() == 2018 && ymd.getMonth() == 10 && ymd.getDay() == 9);
		
		ymd = new YearMonthDay(2018, 10, 1);
		ymd.decreaseBy(new Duration(0, 0, 1));
		assertTrue(ymd.getYear() == 2018 && ymd.getMonth() == 9 && ymd.getDay() == 30);
		
		ymd = new YearMonthDay(2018, 10, 1);
		ymd.decreaseBy(new Duration(0, 0, 2));
		assertTrue(ymd.getYear() == 2018 && ymd.getMonth() == 9 && ymd.getDay() == 29);
		
		ymd = new YearMonthDay(2018, 10, 10);
		ymd.decreaseBy(new Duration(0, 0, 9));
		assertTrue(ymd.getYear() == 2018 && ymd.getMonth() == 10 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(2018, 10, 10);
		ymd.decreaseBy(new Duration(0, 0, 10));
		assertTrue(ymd.getYear() == 2018 && ymd.getMonth() == 9 && ymd.getDay() == 30);
		
		ymd = new YearMonthDay(2018, 10, 10);
		ymd.decreaseBy(new Duration(0, 0, 11));
		assertTrue(ymd.getYear() == 2018 && ymd.getMonth() == 9 && ymd.getDay() == 29);
		
		ymd = new YearMonthDay(2018, 10, 10);
		ymd.decreaseBy(new Duration(0, 0, 12));
		assertTrue(ymd.getYear() == 2018 && ymd.getMonth() == 9 && ymd.getDay() == 28);
		
		ymd = new YearMonthDay(2018, 10, 31);
		ymd.decreaseBy(new Duration(0, 0, 30));
		assertTrue(ymd.getYear() == 2018 && ymd.getMonth() == 10 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(2018, 1, 31);
		duration = new Duration(0, 0, 30);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == 2018 && ymd.getMonth() == 1 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(2018, 2, 1);
		duration = new Duration(0, 0, 31);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == 2018 && ymd.getMonth() == 1 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(2016, 1, 31);
		duration = new Duration(0, 0, 30);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == 2016 && ymd.getMonth() == 1 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(2016, 2, 29);
		duration = new Duration(0, 0, 28);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == 2016 && ymd.getMonth() == 2 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(2016, 2, 29);
		duration = new Duration(0, 0, 29);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == 2016 && ymd.getMonth() == 1 && ymd.getDay() == 31);
		
		ymd = new YearMonthDay(2016, 3, 1);
		duration = new Duration(0, 0, 1);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == 2016 && ymd.getMonth() == 2 && ymd.getDay() == 29);
		
		ymd = new YearMonthDay(2015, 3, 1);
		duration = new Duration(0, 0, 1);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == 2015 && ymd.getMonth() == 2 && ymd.getDay() == 28);
		
		ymd = new YearMonthDay(2016, 11, 1);
		duration = new Duration(0, 0, 30);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == 2016 && ymd.getMonth() == 10 && ymd.getDay() == 2);
		
		ymd = new YearMonthDay(2016, 1, 1);
		duration = new Duration(0, 0, 30);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == 2015 && ymd.getMonth() == 12 && ymd.getDay() == 2);
		
		ymd = new YearMonthDay(2016, 1, 1);
		duration = new Duration(0, 0, 1);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == 2015 && ymd.getMonth() == 12 && ymd.getDay() == 31);
		
		ymd = new YearMonthDay(2016, 4, 30);
		duration = new Duration(0, 0, 61);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == 2016 && ymd.getMonth() == 2 && ymd.getDay() == 29);
		
		ymd = new YearMonthDay(2016, 12, 31);
		duration = new Duration(0, 0, 30);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == 2016 && ymd.getMonth() == 12 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(2016, 1, 2);
		duration = new Duration(0, 0, 30);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == 2015 && ymd.getMonth() == 12 && ymd.getDay() == 3);
		
		ymd = new YearMonthDay(1, 1, 31);
		duration = new Duration(0, 0, 30);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == 1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(1, 1, 31);
		duration = new Duration(0, 0, 31);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 12 && ymd.getDay() == 31);
		
		ymd = new YearMonthDay(-1, 12, 2);
		duration = new Duration(0, 0, 30);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 11 && ymd.getDay() == 2);
		
		ymd = new YearMonthDay(1, 1, 1);
		duration = new Duration(0, 0, 1);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 12 && ymd.getDay() == 31);
		
		ymd = new YearMonthDay(1, 1, 1);
		duration = new Duration(0, 0, 31);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 12 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(YearMonthDay.MAX_YMD);
		duration = new Duration(0, 0, 1);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == YearMonthDay.MAX_YEAR && 
				   ymd.getMonth() == YearMonthDay.MAX_MONTH_OF_MAX_YEAR && 
				   ymd.getDay() == YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR - 1);

		ymd = new YearMonthDay(YearMonthDay.MAX_YMD);
		duration = new Duration(0, 0, 30);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == YearMonthDay.MAX_YEAR && 
				   ymd.getMonth() == YearMonthDay.MAX_MONTH_OF_MAX_YEAR - 1 && 
				   ymd.getDay() == 7);
		
		ymd = new YearMonthDay(-50, 6, 10);
		duration = new Duration(0, 0, 8);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == -50 && ymd.getMonth() == 6 && ymd.getDay() == 2);

		ymd = new YearMonthDay(-50, 6, 10);
		duration = new Duration(0, 1, 30);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == -50 && ymd.getMonth() == 4 && ymd.getDay() == 10);

		ymd = new YearMonthDay(-50, 6, 10);
		duration = new Duration(0, 11, 30);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == -51 && ymd.getMonth() == 6 && ymd.getDay() == 10);
		
		// Test negative leap years
		ymd = new YearMonthDay(-1, 2, 1);
		duration = new Duration(0, 0, 30);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 1 && ymd.getDay() == 2);
		
		ymd = new YearMonthDay(-1, 3, 1);
		duration = new Duration(0, 0, 1);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 2 && ymd.getDay() == 29);
		
		ymd = new YearMonthDay(-1, 3, 4);
		duration = new Duration(0, 0, 7);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 2 && ymd.getDay() == 26);
		
		ymd = new YearMonthDay(-1, 3, 1);
		duration = new Duration(0, 0, 30);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 1 && ymd.getDay() == 31);
		
		ymd = new YearMonthDay(-1, 3, 31);
		duration = new Duration(0, 0, 31);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 2 && ymd.getDay() == 29);
		
		ymd = new YearMonthDay(-1, 3, 2);
		duration = new Duration(0, 0, 1);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 3 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(-1, 3, 25);
		duration = new Duration(0, 0, 15);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 3 && ymd.getDay() == 10);
		
		ymd = new YearMonthDay(-100, 2, 10);
		duration = new Duration(0, 0, 25);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == -100 && ymd.getMonth() == 1 && ymd.getDay() == 16);
		
		ymd = new YearMonthDay(-100, 3, 10);
		duration = new Duration(0, 0, 25);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == -100 && ymd.getMonth() == 2 && ymd.getDay() == 13);
		
		ymd = new YearMonthDay(-101, 3, 10);
		duration = new Duration(0, 0, 25);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == -101 && ymd.getMonth() == 2 && ymd.getDay() == 13);
		
		ymd = new YearMonthDay(-105, 3, 10);
		duration = new Duration(0, 0, 25);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == -105 && ymd.getMonth() == 2 && ymd.getDay() == 14);
		
		ymd = new YearMonthDay(-400, 3, 10);
		duration = new Duration(0, 0, 25);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == -400 && ymd.getMonth() == 2 && ymd.getDay() == 13);
		
		ymd = new YearMonthDay(-401, 3, 10);
		duration = new Duration(0, 0, 25);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == -401 && ymd.getMonth() == 2 && ymd.getDay() == 14);
		
		ymd = new YearMonthDay(-3200, 3, 10);
		duration = new Duration(0, 0, 25);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == -3200 && ymd.getMonth() == 2 && ymd.getDay() == 13);
		
		ymd = new YearMonthDay(-3201, 3, 10);
		duration = new Duration(0, 0, 25);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == -3201 && ymd.getMonth() == 2 && ymd.getDay() == 14);
		
		// Test Normal Again
		ymd = new YearMonthDay(2001, 2, 10);
		duration = new Duration(0, 0, 25);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == 2001 && ymd.getMonth() == 1 && ymd.getDay() == 16);
		
		ymd = new YearMonthDay(1928, 2, 7);
		duration = new Duration(0, 0, 25);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == 1928 && ymd.getMonth() == 1 && ymd.getDay() == 13);
		
		ymd = new YearMonthDay(1899, 7, 1);
		duration = new Duration(0, 0, 10);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == 1899 && ymd.getMonth() == 6 && ymd.getDay() == 21);
		
		ymd = new YearMonthDay(1881, 12, 1);
		duration = new Duration(0, 0, 10);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == 1881 && ymd.getMonth() == 11 && ymd.getDay() == 21);
		
		//Test Months
		ymd = new YearMonthDay(1881, 2, 1);
		duration = new Duration(0, 1, 0);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == 1881 && ymd.getMonth() == 1 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(1881, 3, 1);
		duration = new Duration(0, 2, 0);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == 1881 && ymd.getMonth() == 1 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(1881, 11, 1);
		duration = new Duration(0, 10, 0);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == 1881 && ymd.getMonth() == 1 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(1881, 12, 1);
		duration = new Duration(0, 11, 0);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == 1881 && ymd.getMonth() == 1 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(1777, 3, 10);
		duration = new Duration(0, 1, 0);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == 1777 && ymd.getMonth() == 2 && ymd.getDay() == 10);
		
		ymd = new YearMonthDay(1777, 4, 10);
		duration = new Duration(0, 2, 0);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == 1777 && ymd.getMonth() == 2 && ymd.getDay() == 10);
		
		ymd = new YearMonthDay(1777, 7, 10);
		duration = new Duration(0, 5, 0);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == 1777 && ymd.getMonth() == 2 && ymd.getDay() == 10);
		
		ymd = new YearMonthDay(1777, 12, 10);
		duration = new Duration(0, 10, 0);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == 1777 && ymd.getMonth() == 2 && ymd.getDay() == 10);
		
		ymd = new YearMonthDay(1778, 1, 10);
		duration = new Duration(0, 11, 0);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == 1777 && ymd.getMonth() == 2 && ymd.getDay() == 10);
		
		ymd = new YearMonthDay(1778, 2, 9);
		duration = new Duration(0, 11, 30);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == 1777 && ymd.getMonth() == 2 && ymd.getDay() == 7);

		
		ymd = new YearMonthDay(1951, 3, 1);
		duration = new Duration(0, 1, 0);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == 1951 && ymd.getMonth() == 2 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(1952, 2, 29);
		duration = new Duration(0, 1, 0);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == 1952 && ymd.getMonth() == 1 && ymd.getDay() == 29);
		
		ymd = new YearMonthDay(1, 1, 31);
		duration = new Duration(0, 1, 0);
		ymd.decreaseBy(duration); //Assertion Error
		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 12 && ymd.getDay() == 31);
		
		ymd = new YearMonthDay(1, 1, 1);
		duration = new Duration(0, 0, 1);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 12 && ymd.getDay() == 31);
		
		ymd = new YearMonthDay(1, 1, 30);
		duration = new Duration(0, 0, 30);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 12 && ymd.getDay() == 31);
		
		ymd = new YearMonthDay(-1, 12, 31);
		duration = new Duration(0, 11, 30);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(1, 1, 1);
		duration = new Duration(0, 11, 30);
		ymd.decreaseBy(duration); //Assertion Error
		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 1 && ymd.getDay() == 2);
		
		ymd = new YearMonthDay(1952, 3, 1);
		duration = new Duration(0, 11, 0);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == 1951 && ymd.getMonth() == 4 && ymd.getDay() == 1);
		
		// Test years
		ymd = new YearMonthDay(2, 1, 1);
		duration = new Duration(1, 0, 0);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == 1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(101, 1, 1);
		duration = new Duration(100, 0, 0);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == 1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(1, 1, 1);
		duration = new Duration(1, 0, 0);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
		
		ymd = new YearMonthDay(2, 1, 1);
		duration = new Duration(11, 0, 0);
		ymd.decreaseBy(duration);
		assertTrue(ymd.getYear() == -10 && ymd.getMonth() == 1 && ymd.getDay() == 1);
	}


//	@Test
//	public void testDecreaseByUsingJulianDayPerspective() {	// Test errors
//
//	//TestErrors
//		YearMonthDay ymd = new YearMonthDay(YearMonthDay.MIN_YEAR,
//											YearMonthDay.MIN_MONTH_OF_MIN_YEAR,
//											YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR);
//		
//		try{
//			ymd.decreaseByJulianDayPerspective(null);
//			fail(JUNIT_FAIL);
//		} catch(AssertionError e) {checkForFailure(e);}
//		
////		Duration duration = new Duration(0, 0, 1);
////		try{
////			ymd.decreaseByJulianDayPerspective(duration);
////			fail(JUNIT_FAIL);
////		} catch(AssertionError e) {checkForFailure(e);}
////
////		duration = new Duration(0, 1, 0);
////		try{
////			ymd.decreaseByJulianDayPerspective(duration);
////			fail(JUNIT_FAIL);
////		} catch(AssertionError e) {checkForFailure(e);}
//		
//		Duration duration = new Duration(1, 0, 0);
//		try{
//			ymd.decreaseByJulianDayPerspective(duration);
//			fail(JUNIT_FAIL);
//		} catch(AssertionError e) {checkForFailure(e);}
//		
//		duration = new Duration(1, 1, 1);
//		try{
//			ymd.decreaseByJulianDayPerspective(duration);
//			fail(JUNIT_FAIL);
//		} catch(AssertionError e) {checkForFailure(e);}
//		
//	//New Tests
//		//Test Years
//		//Starting At Year 1
//		ymd = new YearMonthDay(1, 1, 1);
//		ymd.decreaseByJulianDayPerspective(Duration.ZERO_DURATION);
//		assertTrue(ymd.toString(), ymd.getYear() == 1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(1, 1, 1);
//		ymd.decreaseByJulianDayPerspective(Duration.ONE_YEAR);
//		assertTrue(ymd.toString(), ymd.getYear() == -1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(1, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(2, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -2 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(1, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(3, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -3 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(1, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(4, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -4 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(1, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(5, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -5 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(1, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(6, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -6 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(1, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(6, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -6 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//
//		//Starting At Year 2
//		ymd = new YearMonthDay(2, 1, 1);
//		ymd.decreaseByJulianDayPerspective(Duration.ZERO_DURATION);
//		assertTrue(ymd.toString(), ymd.getYear() == 2 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2, 1, 1);
//		ymd.decreaseByJulianDayPerspective(Duration.ONE_YEAR);
//		assertTrue(ymd.toString(), ymd.getYear() == 1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(2, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(3, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -2 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(5, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -4 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(6, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -5 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(9, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -8 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(10, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -9 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(12, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -11 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//
//		//Starting At Year 4
//		ymd = new YearMonthDay(4, 1, 1);
//		ymd.decreaseByJulianDayPerspective(Duration.ZERO_DURATION);
//		assertTrue(ymd.toString(), ymd.getYear() == 4 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(4, 1, 1);
//		ymd.decreaseByJulianDayPerspective(Duration.ONE_YEAR);
//		assertTrue(ymd.toString(), ymd.getYear() == 3 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(4, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(2, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == 2 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(4, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(3, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == 1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(4, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(4, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(4, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(5, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -2 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(4, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(6, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -3 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(4, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(7, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -4 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(4, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(11, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -8 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(4, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(12, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -9 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		//Starting At Year 5
//		ymd = new YearMonthDay(5, 1, 1);
//		ymd.decreaseByJulianDayPerspective(Duration.ZERO_DURATION);
//		assertTrue(ymd.toString(), ymd.getYear() == 5 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(5, 1, 1);
//		ymd.decreaseByJulianDayPerspective(Duration.ONE_YEAR);
//		assertTrue(ymd.toString(), ymd.getYear() == 4 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(5, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(2, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == 3 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(5, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(3, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == 2 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(5, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(4, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == 1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(5, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(5, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(5, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(6, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -2 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(5, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(7, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -3 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(5, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(8, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -4 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(5, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(9, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -5 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		//Starting At Year -1
//		ymd = new YearMonthDay(-1, 1, 1);
//		ymd.decreaseByJulianDayPerspective(Duration.ZERO_DURATION);
//		assertTrue(ymd.toString(), ymd.getYear() == -1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-1, 1, 1);
//		ymd.decreaseByJulianDayPerspective(Duration.ONE_YEAR);
//		assertTrue(ymd.toString(), ymd.getYear() == -2 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-1, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(2, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -3 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-1, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(3, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -4 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-1, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(4, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -5 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-1, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(5, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -6 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-1, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(6, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -7 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-1, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(7, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -8 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-1, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(8, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -9 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-1, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(12, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -13 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		//Starting At Year -2
//		ymd = new YearMonthDay(-2, 1, 1);
//		ymd.decreaseByJulianDayPerspective(Duration.ZERO_DURATION);
//		assertTrue(ymd.toString(), ymd.getYear() == -2 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-2, 1, 1);
//		ymd.decreaseByJulianDayPerspective(Duration.ONE_YEAR);
//		assertTrue(ymd.toString(), ymd.getYear() == -3 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-2, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(2, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -4 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-2, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(3, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -5 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-2, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(4, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -6 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-2, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(5, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -7 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-2, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(6, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -8 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-2, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(9, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -11 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-2, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(10, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -12 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-2, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(12, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -14 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		//Starting At Year -4
//		ymd = new YearMonthDay(-4, 1, 1);
//		ymd.decreaseByJulianDayPerspective(Duration.ZERO_DURATION);
//		assertTrue(ymd.toString(), ymd.getYear() == -4 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-4, 1, 1);
//		ymd.decreaseByJulianDayPerspective(Duration.ONE_YEAR);
//		assertTrue(ymd.toString(), ymd.getYear() == -5 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-4, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(2, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -6 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-4, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(3, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -7 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-4, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(4, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -8 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-4, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(5, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -9 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-4, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(6, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -10 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-4, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(9, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -13 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-4, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(10, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -14 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-4, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(12, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -16 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		//Starting At Year -5
//		ymd = new YearMonthDay(-5, 1, 1);
//		ymd.decreaseByJulianDayPerspective(Duration.ZERO_DURATION);
//		assertTrue(ymd.toString(), ymd.getYear() == -5 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-5, 1, 1);
//		ymd.decreaseByJulianDayPerspective(Duration.ONE_YEAR);
//		assertTrue(ymd.toString(), ymd.getYear() == -6 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-5, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(2, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -7 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-5, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(3, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -8 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-5, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(4, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -9 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-5, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(5, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -10 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-5, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(6, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -11 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-5, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(9, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -14 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-5, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(10, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -15 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-5, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(12, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -17 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2016, 1, 1);
//		ymd.decreaseByJulianDayPerspective(Duration.ONE_YEAR);
//		assertTrue(ymd.toString(), ymd.getYear() == 2015 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2016, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(2, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == 2014 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2016, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(3, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == 2013 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2016, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(4, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == 2012 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2016, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(5, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == 2011 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2017, 1, 1);
//		ymd.decreaseByJulianDayPerspective(Duration.ONE_YEAR);
//		assertTrue(ymd.toString(), ymd.getYear() == 2016 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2017, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(2, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == 2015 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2017, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(3, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == 2014 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2017, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(4, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == 2013 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2017, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(5, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == 2012 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2016, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(99, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == 1917 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2001, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(100, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == 1901 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2016, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(100, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == 1916 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//
//		ymd = new YearMonthDay(2016, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(101, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == 1915 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2017, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(99, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == 1918 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2017, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(100, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == 1917 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2017, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(101, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == 1916 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2016, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(400, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == 1616 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//
//		ymd = new YearMonthDay(2016, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(401, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == 1615 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2017, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(399, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == 1618 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2017, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(400, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == 1617 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2017, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(401, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == 1616 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//
//		ymd = new YearMonthDay(401, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(400, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == 1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//
//		ymd = new YearMonthDay(400, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(400, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//
//		ymd = new YearMonthDay(399, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(400, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -2 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//
//		ymd = new YearMonthDay(101, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(100, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == 1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//
//		ymd = new YearMonthDay(100, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(100, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//
//		ymd = new YearMonthDay(99, 1, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(100, 0, 0));
//		assertTrue(ymd.toString(), ymd.getYear() == -2 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2017, 2, 28);
//		ymd.decreaseByJulianDayPerspective(Duration.ONE_YEAR);
//		assertTrue(ymd.toString(), ymd.getYear() == 2016 && ymd.getMonth() == 2 && ymd.getDay() == 28);
//		
//		ymd = new YearMonthDay(2017, 3, 1);
//		ymd.decreaseByJulianDayPerspective(Duration.ONE_YEAR);
//		assertTrue(ymd.toString(), ymd.getYear() == 2016 && ymd.getMonth() == 3 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2016, 3, 1);
//		ymd.decreaseByJulianDayPerspective(Duration.ONE_YEAR);
//		assertTrue(ymd.toString(), ymd.getYear() == 2015 && ymd.getMonth() == 3 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2013, 3, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(4, 0, 0));
//		assertTrue(ymd.getYear() == 2009 && ymd.getMonth() == 3 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2016, 3, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(3, 0, 0));
//		assertTrue(ymd.getYear() == 2013 && ymd.getMonth() == 3 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2013, 2, 28);
//		ymd.decreaseByJulianDayPerspective(new Duration(3, 0, 0));
//		assertTrue(ymd.getYear() == 2010 && ymd.getMonth() == 2 && ymd.getDay() == 28);
//		
//		ymd = new YearMonthDay(2017, 2, 28);
//		ymd.decreaseByJulianDayPerspective(new Duration(4, 0, 0));
//		assertTrue(ymd.getYear() == 2013 && ymd.getMonth() == 2 && ymd.getDay() == 28);
//		
//		ymd = new YearMonthDay(2015, 3, 1);
//		ymd.decreaseByJulianDayPerspective(Duration.ONE_YEAR);
//		assertTrue(ymd.getYear() == 2014 && ymd.getMonth() == 3 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2018, 3, 1);
//		ymd.decreaseByJulianDayPerspective(Duration.ONE_YEAR);
//		assertTrue(ymd.getYear() == 2017 && ymd.getMonth() == 3 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-8, 2, 28);
//		ymd.decreaseByJulianDayPerspective(Duration.ONE_YEAR);
//		assertTrue(ymd.getYear() == -9 && ymd.getMonth() == 2 && ymd.getDay() == 28);
//		
//		ymd = new YearMonthDay(-8, 3, 1);
//		ymd.decreaseByJulianDayPerspective(Duration.ONE_YEAR);
//		assertTrue(ymd.getYear() == -9 && ymd.getMonth() == 3 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-9, 2, 29);
//		ymd.decreaseByJulianDayPerspective(new Duration(4, 0, 0));
//		assertTrue(ymd.getYear() == -13 && ymd.getMonth() == 2 && ymd.getDay() == 29);
//	
//	//Normal Tests
//		ymd = new YearMonthDay(2018, 10, 10);
//		ymd.decreaseByJulianDayPerspective(Duration.ZERO_DURATION);
//		assertTrue(ymd.getYear() == 2018 && ymd.getMonth() == 10 && ymd.getDay() == 10);
//		
//		ymd = new YearMonthDay(2018, 10, 10);
//		ymd.decreaseByJulianDayPerspective(Duration.ONE_DAY);
//		assertTrue(ymd.getYear() == 2018 && ymd.getMonth() == 10 && ymd.getDay() == 9);
//		
//		ymd = new YearMonthDay(2018, 10, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(0, 0, 1));
//		assertTrue(ymd.getYear() == 2018 && ymd.getMonth() == 9 && ymd.getDay() == 30);
//		
//		ymd = new YearMonthDay(2018, 10, 1);
//		ymd.decreaseByJulianDayPerspective(new Duration(0, 0, 2));
//		assertTrue(ymd.getYear() == 2018 && ymd.getMonth() == 9 && ymd.getDay() == 29);
//		
//		ymd = new YearMonthDay(2018, 10, 10);
//		ymd.decreaseByJulianDayPerspective(new Duration(0, 0, 9));
//		assertTrue(ymd.getYear() == 2018 && ymd.getMonth() == 10 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2018, 10, 10);
//		ymd.decreaseByJulianDayPerspective(new Duration(0, 0, 10));
//		assertTrue(ymd.getYear() == 2018 && ymd.getMonth() == 9 && ymd.getDay() == 30);
//		
//		ymd = new YearMonthDay(2018, 10, 10);
//		ymd.decreaseByJulianDayPerspective(new Duration(0, 0, 11));
//		assertTrue(ymd.getYear() == 2018 && ymd.getMonth() == 9 && ymd.getDay() == 29);
//		
//		ymd = new YearMonthDay(2018, 10, 10);
//		ymd.decreaseByJulianDayPerspective(new Duration(0, 0, 12));
//		assertTrue(ymd.getYear() == 2018 && ymd.getMonth() == 9 && ymd.getDay() == 28);
//		
//		ymd = new YearMonthDay(2018, 10, 31);
//		ymd.decreaseByJulianDayPerspective(new Duration(0, 0, 30));
//		assertTrue(ymd.getYear() == 2018 && ymd.getMonth() == 10 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2018, 1, 31);
//		duration = new Duration(0, 0, 30);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 2018 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2018, 2, 1);
//		duration = new Duration(0, 0, 31);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 2018 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2016, 1, 31);
//		duration = new Duration(0, 0, 30);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 2016 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2016, 2, 29);
//		duration = new Duration(0, 0, 28);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 2016 && ymd.getMonth() == 2 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2016, 2, 29);
//		duration = new Duration(0, 0, 29);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 2016 && ymd.getMonth() == 1 && ymd.getDay() == 31);
//		
//		ymd = new YearMonthDay(2016, 3, 1);
//		duration = new Duration(0, 0, 1);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 2016 && ymd.getMonth() == 2 && ymd.getDay() == 29);
//		
//		ymd = new YearMonthDay(2015, 3, 1);
//		duration = new Duration(0, 0, 1);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 2015 && ymd.getMonth() == 2 && ymd.getDay() == 28);
//		
//		ymd = new YearMonthDay(2016, 11, 1);
//		duration = new Duration(0, 0, 30);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 2016 && ymd.getMonth() == 10 && ymd.getDay() == 2);
//		
//		ymd = new YearMonthDay(2016, 1, 1);
//		duration = new Duration(0, 0, 30);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 2015 && ymd.getMonth() == 12 && ymd.getDay() == 2);
//		
//		ymd = new YearMonthDay(2016, 1, 1);
//		duration = new Duration(0, 0, 1);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 2015 && ymd.getMonth() == 12 && ymd.getDay() == 31);
//		
//		ymd = new YearMonthDay(2016, 4, 30);
//		duration = new Duration(0, 0, 61);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 2016 && ymd.getMonth() == 2 && ymd.getDay() == 29);
//		
//		ymd = new YearMonthDay(2016, 12, 31);
//		duration = new Duration(0, 0, 30);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 2016 && ymd.getMonth() == 12 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2016, 1, 2);
//		duration = new Duration(0, 0, 30);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 2015 && ymd.getMonth() == 12 && ymd.getDay() == 3);
//		
//		ymd = new YearMonthDay(1, 1, 31);
//		duration = new Duration(0, 0, 30);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(1, 1, 31);
//		duration = new Duration(0, 0, 31);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 12 && ymd.getDay() == 31);
//		
//		ymd = new YearMonthDay(-1, 12, 2);
//		duration = new Duration(0, 0, 30);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 11 && ymd.getDay() == 2);
//		
//		ymd = new YearMonthDay(1, 1, 1);
//		duration = new Duration(0, 0, 1);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 12 && ymd.getDay() == 31);
//		
//		ymd = new YearMonthDay(1, 1, 1);
//		duration = new Duration(0, 0, 31);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 12 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(YearMonthDay.MAX_YMD);
//		duration = new Duration(0, 0, 1);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == YearMonthDay.MAX_YEAR && 
//				   ymd.getMonth() == YearMonthDay.MAX_MONTH_OF_MAX_YEAR && 
//				   ymd.getDay() == YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR - 1);
//
//		ymd = new YearMonthDay(YearMonthDay.MAX_YMD);
//		duration = new Duration(0, 0, 30);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == YearMonthDay.MAX_YEAR && 
//				   ymd.getMonth() == YearMonthDay.MAX_MONTH_OF_MAX_YEAR - 1 && 
//				   ymd.getDay() == 7);
//		
//		ymd = new YearMonthDay(-50, 6, 10);
//		duration = new Duration(0, 0, 8);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -50 && ymd.getMonth() == 6 && ymd.getDay() == 2);
//
//		ymd = new YearMonthDay(-50, 6, 10);
//		duration = new Duration(0, 1, 30);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.toString(),ymd.getYear() == -50 && ymd.getMonth() == 4 && ymd.getDay() == 10);
//
//		ymd = new YearMonthDay(-50, 6, 10);
//		duration = new Duration(0, 11, 30);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -51 && ymd.getMonth() == 6 && ymd.getDay() == 10);
//		
//		// Test negative leap years
//		ymd = new YearMonthDay(-1, 2, 1);
//		duration = new Duration(0, 0, 30);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 1 && ymd.getDay() == 2);
//		
//		ymd = new YearMonthDay(-1, 3, 1);
//		duration = new Duration(0, 0, 1);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 2 && ymd.getDay() == 29);
//		
//		ymd = new YearMonthDay(-1, 3, 4);
//		duration = new Duration(0, 0, 7);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 2 && ymd.getDay() == 26);
//		
//		ymd = new YearMonthDay(-1, 3, 1);
//		duration = new Duration(0, 0, 30);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 1 && ymd.getDay() == 31);
//		
//		ymd = new YearMonthDay(-1, 3, 31);
//		duration = new Duration(0, 0, 31);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 2 && ymd.getDay() == 29);
//		
//		ymd = new YearMonthDay(-1, 3, 2);
//		duration = new Duration(0, 0, 1);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 3 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(-1, 3, 25);
//		duration = new Duration(0, 0, 15);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 3 && ymd.getDay() == 10);
//		
//		ymd = new YearMonthDay(-100, 2, 10);
//		duration = new Duration(0, 0, 25);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -100 && ymd.getMonth() == 1 && ymd.getDay() == 16);
//		
//		ymd = new YearMonthDay(-100, 3, 10);
//		duration = new Duration(0, 0, 25);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -100 && ymd.getMonth() == 2 && ymd.getDay() == 13);
//		
//		ymd = new YearMonthDay(-101, 3, 10);
//		duration = new Duration(0, 0, 25);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -101 && ymd.getMonth() == 2 && ymd.getDay() == 13);
//		
//		ymd = new YearMonthDay(-105, 3, 10);
//		duration = new Duration(0, 0, 25);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -105 && ymd.getMonth() == 2 && ymd.getDay() == 14);
//		
//		ymd = new YearMonthDay(-400, 3, 10);
//		duration = new Duration(0, 0, 25);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -400 && ymd.getMonth() == 2 && ymd.getDay() == 13);
//		
//		ymd = new YearMonthDay(-401, 3, 10);
//		duration = new Duration(0, 0, 25);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -401 && ymd.getMonth() == 2 && ymd.getDay() == 14);
//		
//		ymd = new YearMonthDay(-3200, 3, 10);
//		duration = new Duration(0, 0, 25);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -3200 && ymd.getMonth() == 2 && ymd.getDay() == 13);
//		
//		ymd = new YearMonthDay(-3201, 3, 10);
//		duration = new Duration(0, 0, 25);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -3201 && ymd.getMonth() == 2 && ymd.getDay() == 14);
//		
//		// Test Normal Again
//		ymd = new YearMonthDay(2001, 2, 10);
//		duration = new Duration(0, 0, 25);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 2001 && ymd.getMonth() == 1 && ymd.getDay() == 16);
//		
//		ymd = new YearMonthDay(1928, 2, 7);
//		duration = new Duration(0, 0, 25);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1928 && ymd.getMonth() == 1 && ymd.getDay() == 13);
//		
//		ymd = new YearMonthDay(1899, 7, 1);
//		duration = new Duration(0, 0, 10);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1899 && ymd.getMonth() == 6 && ymd.getDay() == 21);
//		
//		ymd = new YearMonthDay(1881, 12, 1);
//		duration = new Duration(0, 0, 10);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1881 && ymd.getMonth() == 11 && ymd.getDay() == 21);
//		
//		//Test Months
//		ymd = new YearMonthDay(1881, 2, 1);
//		duration = new Duration(0, 1, 0);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1881 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(1881, 3, 1);
//		duration = new Duration(0, 2, 0);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1881 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(1881, 11, 1);
//		duration = new Duration(0, 10, 0);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1881 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(1881, 12, 1);
//		duration = new Duration(0, 11, 0);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1881 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(1777, 3, 10);
//		duration = new Duration(0, 1, 0);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1777 && ymd.getMonth() == 2 && ymd.getDay() == 10);
//		
//		ymd = new YearMonthDay(1777, 4, 10);
//		duration = new Duration(0, 2, 0);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1777 && ymd.getMonth() == 2 && ymd.getDay() == 10);
//		
//		ymd = new YearMonthDay(1777, 7, 10);
//		duration = new Duration(0, 5, 0);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1777 && ymd.getMonth() == 2 && ymd.getDay() == 10);
//		
//		ymd = new YearMonthDay(1777, 12, 10);
//		duration = new Duration(0, 10, 0);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1777 && ymd.getMonth() == 2 && ymd.getDay() == 10);
//		
//		ymd = new YearMonthDay(1778, 1, 10);
//		duration = new Duration(0, 11, 0);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1777 && ymd.getMonth() == 2 && ymd.getDay() == 10);
//		
//		ymd = new YearMonthDay(1778, 2, 9);
//		duration = new Duration(0, 11, 30);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1777 && ymd.getMonth() == 2 && ymd.getDay() == 7);
//
//		
//		ymd = new YearMonthDay(1951, 3, 1);
//		duration = new Duration(0, 1, 0);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1951 && ymd.getMonth() == 2 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(1952, 2, 29);
//		duration = new Duration(0, 1, 0);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1952 && ymd.getMonth() == 1 && ymd.getDay() == 29);
//		
//		ymd = new YearMonthDay(1, 1, 31);
//		duration = new Duration(0, 1, 0);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.toString(), ymd.getYear() == -1 && ymd.getMonth() == 12 && ymd.getDay() == 31);
//		
//		ymd = new YearMonthDay(1, 1, 1);
//		duration = new Duration(0, 0, 1);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 12 && ymd.getDay() == 31);
//		
//		ymd = new YearMonthDay(1, 1, 30);
//		duration = new Duration(0, 0, 30);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 12 && ymd.getDay() == 31);
//		
//		ymd = new YearMonthDay(-1, 12, 31);
//		duration = new Duration(0, 11, 30);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(1, 1, 1);
//		duration = new Duration(0, 11, 30);
//		ymd.decreaseByJulianDayPerspective(duration); //Assertion Error
//		assertTrue(ymd.toString(), ymd.getYear() == -1 && ymd.getMonth() == 1 && ymd.getDay() == 2);
//		
//		ymd = new YearMonthDay(1952, 3, 1);
//		duration = new Duration(0, 11, 0);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.toString(), ymd.getYear() == 1951 && ymd.getMonth() == 4 && ymd.getDay() == 1);
//		
//		// Test years
//		ymd = new YearMonthDay(2, 1, 1);
//		duration = new Duration(1, 0, 0);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(101, 1, 1);
//		duration = new Duration(100, 0, 0);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == 1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(1, 1, 1);
//		duration = new Duration(1, 0, 0);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -1 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//		
//		ymd = new YearMonthDay(2, 1, 1);
//		duration = new Duration(11, 0, 0);
//		ymd.decreaseByJulianDayPerspective(duration);
//		assertTrue(ymd.getYear() == -10 && ymd.getMonth() == 1 && ymd.getDay() == 1);
//	}

	@Test
	public void testIsLeapYear() {
		//Invalid Input
		try{
			assertTrue(YearMonthDay.isLeapYear(0));
			fail(JUNIT_FAIL);
		}catch(AssertionError e){checkForFailure(e);}
		
		try{
			assertTrue(YearMonthDay.isLeapYear(-5000));
			fail(JUNIT_FAIL);
		}catch(AssertionError e){checkForFailure(e);}
		
		try{
			assertTrue(YearMonthDay.isLeapYear(YearMonthDay.MIN_YEAR - 1));
			fail(JUNIT_FAIL);
		}catch(AssertionError e){checkForFailure(e);}
		
		try{
			assertTrue(YearMonthDay.isLeapYear(YearMonthDay.MAX_YEAR + 1));
			fail(JUNIT_FAIL);
		}catch(AssertionError e){checkForFailure(e);}
		
		try{
			assertTrue(YearMonthDay.isLeapYear(YearMonthDay.MAX_YEAR + 1));
			fail(JUNIT_FAIL);
		}catch(AssertionError e){checkForFailure(e);}
		
		try{
			assertTrue(YearMonthDay.isLeapYear(1500000));
			fail(JUNIT_FAIL);
		}catch(AssertionError e){checkForFailure(e);}
		
		//Valid Input
		YearMonthDay.isLeapYear(-5);
		YearMonthDay.isLeapYear(-4);
		YearMonthDay.isLeapYear(-3);
		YearMonthDay.isLeapYear(-2);
		YearMonthDay.isLeapYear(-1);
		YearMonthDay.isLeapYear(1);
		YearMonthDay.isLeapYear(2);
		YearMonthDay.isLeapYear(3);
		YearMonthDay.isLeapYear(4);
		
		YearMonthDay.isLeapYear(15);
		YearMonthDay.isLeapYear(16);
		YearMonthDay.isLeapYear(17);
		
		YearMonthDay.isLeapYear(95);
		YearMonthDay.isLeapYear(96);
		YearMonthDay.isLeapYear(97);
		
		YearMonthDay.isLeapYear(99);
		YearMonthDay.isLeapYear(100);
		YearMonthDay.isLeapYear(101);
		
		YearMonthDay.isLeapYear(222);
		YearMonthDay.isLeapYear(316);
		YearMonthDay.isLeapYear(318);
		
		YearMonthDay.isLeapYear(399);
		YearMonthDay.isLeapYear(400);
		YearMonthDay.isLeapYear(401);
		
		YearMonthDay.isLeapYear(999);
		YearMonthDay.isLeapYear(1000);
		YearMonthDay.isLeapYear(1001);
		
		YearMonthDay.isLeapYear(1999);
		YearMonthDay.isLeapYear(2000);
		YearMonthDay.isLeapYear(2001);
		YearMonthDay.isLeapYear(3200);
		
		YearMonthDay.isLeapYear(YearMonthDay.MAX_YEAR);
		YearMonthDay.isLeapYear(YearMonthDay.MAX_YEAR - 1);
		YearMonthDay.isLeapYear(YearMonthDay.MAX_YEAR - 2);
		

		YearMonthDay.isLeapYear(-16);
		YearMonthDay.isLeapYear(-17);
		YearMonthDay.isLeapYear(-18);
		
		YearMonthDay.isLeapYear(-96);
		YearMonthDay.isLeapYear(-97);
		YearMonthDay.isLeapYear(-98);
		
		YearMonthDay.isLeapYear(-100);
		YearMonthDay.isLeapYear(-101);
		YearMonthDay.isLeapYear(-102);
		
		YearMonthDay.isLeapYear(-223);
		YearMonthDay.isLeapYear(-317);
		YearMonthDay.isLeapYear(-319);
		
		YearMonthDay.isLeapYear(-400);
		YearMonthDay.isLeapYear(-401);
		YearMonthDay.isLeapYear(-402);
		
		YearMonthDay.isLeapYear(-1000);
		YearMonthDay.isLeapYear(-1001);
		YearMonthDay.isLeapYear(-1002);
		
		YearMonthDay.isLeapYear(-2000);
		YearMonthDay.isLeapYear(-2001);
		YearMonthDay.isLeapYear(-2002);
		
		YearMonthDay.isLeapYear(-3201);
		
		YearMonthDay.isLeapYear(YearMonthDay.MIN_YEAR);
		YearMonthDay.isLeapYear(YearMonthDay.MIN_YEAR + 1);
		YearMonthDay.isLeapYear(YearMonthDay.MIN_YEAR + 2);
		YearMonthDay.isLeapYear(YearMonthDay.MIN_YEAR + 3);
		YearMonthDay.isLeapYear(YearMonthDay.MIN_YEAR + 4);
		YearMonthDay.isLeapYear(YearMonthDay.MIN_YEAR + 5);
	}

	@Test
	public void testGetJulianDay() {
		YearMonthDay.MIN_YMD.getJulianDay();
		
		YearMonthDay ymd1 = new YearMonthDay(-1,12,31);
		YearMonthDay ymd2 = new YearMonthDay(1,1,1);
		YearMonthDay ymd3 = new YearMonthDay(1,2,1);
		YearMonthDay ymd4 = new YearMonthDay(2,1,1);
		YearMonthDay ymd5 = new YearMonthDay(4,1,1);
		YearMonthDay ymd6 = new YearMonthDay(5,1,1);
		
		ymd1.getJulianDay();
		ymd2.getJulianDay();
		ymd2.getJulianDay();
		ymd3.getJulianDay();
		ymd4.getJulianDay();
		ymd5.getJulianDay();
		ymd6.getJulianDay();
		
		new YearMonthDay(2018, 8, 6).getJulianDay();
		new YearMonthDay(-1000, 3, 3).getJulianDay();
	}

	@Test
	public void testToYMD() {
		YearMonthDay ymd1 = new YearMonthDay(3200,3,1);
		int jd = ymd1.getJulianDay();
		assertTrue("ymd1 = " + ymd1.toString() + ", jd = " + YearMonthDay.toYMD(jd),
				   YearMonthDay.toYMD(jd).equals(ymd1));
		
		YearMonthDay ymd_a = new YearMonthDay(1,1,1);
		int julianDay = ymd_a.getJulianDay();
		YearMonthDay ymd_b = YearMonthDay.toYMD(julianDay);
		assertTrue(ymd_a.equals(ymd_b));
		
		ymd_a = new YearMonthDay(-1,1,1);
		julianDay = ymd_a.getJulianDay();
		ymd_b = YearMonthDay.toYMD(julianDay);
		assertTrue(ymd_a.equals(ymd_b));
		
		ymd_a = YearMonthDay.MIN_YMD;
		julianDay = ymd_a.getJulianDay();
		ymd_b = YearMonthDay.toYMD(julianDay);
		assertTrue(ymd_a.equals(ymd_b));
		
		ymd_a = YearMonthDay.MAX_YMD;
		julianDay = ymd_a.getJulianDay();
		ymd_b = YearMonthDay.toYMD(julianDay);
		assertTrue(ymd_a.equals(ymd_b));
		
		ymd_a = new YearMonthDay(1900,2,28);
		julianDay = ymd_a.getJulianDay();
		ymd_b = YearMonthDay.toYMD(julianDay);
		assertTrue(ymd_a.equals(ymd_b));
		
		ymd_a = new YearMonthDay(1904,2,29);
		julianDay = ymd_a.getJulianDay();
		ymd_b = YearMonthDay.toYMD(julianDay);
		assertTrue(ymd_a.equals(ymd_b));
		
		ymd_a = new YearMonthDay(2000,2,29);
		julianDay = ymd_a.getJulianDay();
		ymd_b = YearMonthDay.toYMD(julianDay);
		assertTrue(ymd_a.equals(ymd_b));
		
		ymd_a = new YearMonthDay(1900,2,28);
		julianDay = ymd_a.getJulianDay();
		ymd_b = YearMonthDay.toYMD(julianDay);
		assertTrue(ymd_a.equals(ymd_b));
		
		ymd_a = new YearMonthDay(1951,12,10);
		julianDay = ymd_a.getJulianDay();
		ymd_b = YearMonthDay.toYMD(julianDay);
		assertTrue(ymd_a.equals(ymd_b));
		
		ymd_a = new YearMonthDay(-3201,2,18);
		julianDay = ymd_a.getJulianDay();
		ymd_b = YearMonthDay.toYMD(julianDay);
		assertTrue(ymd_a.equals(ymd_b));
	}
	
	@Test
	public void testEquals() {
		assertTrue(YearMonthDay.MIN_YMD.equals(YearMonthDay.MIN_YMD));
		assertTrue(YearMonthDay.MAX_YMD.equals(YearMonthDay.MAX_YMD));
		assertFalse(YearMonthDay.MIN_YMD.equals(YearMonthDay.MAX_YMD));
		
		YearMonthDay ymd1 = new YearMonthDay(1,1,1);
		YearMonthDay ymd2 = new YearMonthDay(1,1,1);
		YearMonthDay ymd3 = new YearMonthDay(YearMonthDay.MIN_YEAR,11,25);
		YearMonthDay ymd4 = new YearMonthDay(-1,12,31);
		YearMonthDay ymd5 = new YearMonthDay(1,1,2);
		
		assertTrue(ymd3.equals(YearMonthDay.MIN_YMD));
		assertTrue(YearMonthDay.MIN_YMD.equals(ymd3));
		
		assertTrue(ymd1.equals(ymd2));
		assertTrue(ymd2.equals(ymd1));
		
		assertFalse(ymd1.equals(ymd5));
		assertFalse(ymd5.equals(ymd1));
		
		assertFalse(ymd1.equals(ymd4));
		assertFalse(ymd4.equals(ymd1));
	}

	@Test
	public void testToString() {
		YearMonthDay ymd = new YearMonthDay(1, 1, 1);
		assertTrue(ymd.toString().equals("1/1/1"));
		
		ymd = new YearMonthDay(2100, 1, 31);
		assertTrue(ymd.toString().equals("2100/1/31"));
		
		ymd = new YearMonthDay(-1, 1, 31);
		assertTrue(ymd.toString().equals("-1/1/31"));
		
		ymd = new YearMonthDay(-1000, 2, 28);
		assertTrue(ymd.toString().equals("-1000/2/28"));
		
		assertTrue(YearMonthDay.MIN_YMD.toString().equals("-4714/11/25"));
		
		assertTrue(YearMonthDay.MAX_YMD.toString().equals("1465002/10/7"));
	}

	@Test
	public void testYearMonthDayIntIntInt_Precondition() {
		//Lower Bound, Bad Days
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MIN_YEAR, YearMonthDay.MIN_MONTH_OF_MIN_YEAR, Integer.MIN_VALUE));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MIN_YEAR, YearMonthDay.MIN_MONTH_OF_MIN_YEAR, -100));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MIN_YEAR, YearMonthDay.MIN_MONTH_OF_MIN_YEAR, -10));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MIN_YEAR, YearMonthDay.MIN_MONTH_OF_MIN_YEAR, -1));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MIN_YEAR, YearMonthDay.MIN_MONTH_OF_MIN_YEAR, 0));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MIN_YEAR,
																   YearMonthDay.MIN_MONTH_OF_MIN_YEAR,
																   YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR + 1));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MIN_YEAR, YearMonthDay.MIN_MONTH_OF_MIN_YEAR, 31));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MIN_YEAR, YearMonthDay.MIN_MONTH_OF_MIN_YEAR, 32));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MIN_YEAR, YearMonthDay.MIN_MONTH_OF_MIN_YEAR, 101));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MIN_YEAR, YearMonthDay.MIN_MONTH_OF_MIN_YEAR, Integer.MAX_VALUE));
	
		//Lower Bound, Bad Months
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MIN_YEAR, Integer.MIN_VALUE, YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MIN_YEAR, -10099, YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MIN_YEAR, -100, YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MIN_YEAR, -11, YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MIN_YEAR, -1, YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MIN_YEAR, YearMonthDay.MIN_MONTH_OF_MIN_YEAR - 1, 1));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MIN_YEAR, 99, YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MIN_YEAR, 10001, YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MIN_YEAR, Integer.MAX_VALUE, YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR));
		
		//LowerBound, Bad Year
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(Integer.MIN_VALUE, YearMonthDay.MIN_MONTH_OF_MIN_YEAR, YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(-9999999, YearMonthDay.MIN_MONTH_OF_MIN_YEAR, YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(-1465002, YearMonthDay.MIN_MONTH_OF_MIN_YEAR, YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(-5111, YearMonthDay.MIN_MONTH_OF_MIN_YEAR, YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(-4799, YearMonthDay.MIN_MONTH_OF_MIN_YEAR, YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MIN_YEAR - 1, YearMonthDay.MIN_MONTH_OF_MIN_YEAR, YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(-12346, YearMonthDay.MIN_MONTH_OF_MIN_YEAR, YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(-4999, YearMonthDay.MIN_MONTH_OF_MIN_YEAR, YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(-4799, YearMonthDay.MIN_MONTH_OF_MIN_YEAR, YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MIN_YEAR - 1, YearMonthDay.MIN_MONTH_OF_MIN_YEAR, YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(-4724, YearMonthDay.MIN_MONTH_OF_MIN_YEAR, YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(-4814, YearMonthDay.MIN_MONTH_OF_MIN_YEAR, YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(-5714, YearMonthDay.MIN_MONTH_OF_MIN_YEAR, YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(-9999, YearMonthDay.MIN_MONTH_OF_MIN_YEAR, YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(-99999, YearMonthDay.MIN_MONTH_OF_MIN_YEAR, YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(Integer.MIN_VALUE, YearMonthDay.MIN_MONTH_OF_MIN_YEAR, YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR));

		//UpperBound, Bad Day
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MAX_YEAR, 10, Integer.MIN_VALUE));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MAX_YEAR, 10, -99876));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MAX_YEAR, 10, -1));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MAX_YEAR, 10, 0));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MAX_YEAR, 10, 32));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MAX_YEAR, 10, 100));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MAX_YEAR, 10, 45678));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MAX_YEAR, 10, 26));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MAX_YEAR, 10, 31));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MAX_YEAR, 10, 32));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MAX_YEAR, 10, 87));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MAX_YEAR, 10, 1465002));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MAX_YEAR, 10, Integer.MAX_VALUE));
		
		//Bad Day For Month
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(2004, 1, 32));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(2003, 2, 29));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(2004, 2, 30));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(2004, 2, 31));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(2004, 3, 32));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(2004, 4, 31));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(2004, 5, 32));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(2004, 6, 31));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(2004, 7, 32));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(2004, 8, 32));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(2004, 9, 31));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(2004, 10, 32));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(2004, 11, 31));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(2004, 12, 32));
		
		//UpperBound, Bad Month
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MAX_YEAR, Integer.MIN_VALUE, 7));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MAX_YEAR, YearMonthDay.MIN_YEAR, 7));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MAX_YEAR, -9, 7));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MAX_YEAR, -1, 7));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MAX_YEAR, 0, 7));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MAX_YEAR, 11, 7));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MAX_YEAR, 12, 7));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MAX_YEAR, 13, 7));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MAX_YEAR, 2018, 7));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MAX_YEAR, Integer.MAX_VALUE, 7));
		
		//UpperBound, Bad Year
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(Integer.MIN_VALUE,
																   YearMonthDay.MAX_MONTH_OF_MAX_YEAR,
																   YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(-1465002,
																   YearMonthDay.MAX_MONTH_OF_MAX_YEAR,
																   YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(0, YearMonthDay.MAX_MONTH_OF_MAX_YEAR,
																	  YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MAX_YEAR + 1,
																   YearMonthDay.MAX_MONTH_OF_MAX_YEAR,
																   YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(1466000,
																   YearMonthDay.MAX_MONTH_OF_MAX_YEAR,
																   YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(Integer.MAX_VALUE,
																   YearMonthDay.MAX_MONTH_OF_MAX_YEAR,
																   YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR));
		
		//Bad Leap Years
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(-3200, 2, 29));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(-402, 2, 29));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(-400, 2, 29)); 
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(-102, 2, 29));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(-100, 2, 29));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(-6, 2, 29));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(-4, 2, 29));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(1, 2, 29));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(5, 2, 29));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(100, 2, 29));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(1000, 2, 29));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(1900, 2, 29));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(2003, 2, 29));
		assertFalse(YearMonthDay.yearMonthDayIntIntInt_Precondition(2005, 2, 29));
		
		//Good YMD, Negative Years
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MIN_YEAR,
																  YearMonthDay.MIN_MONTH_OF_MIN_YEAR,
																  YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MIN_YEAR,
																  YearMonthDay.MIN_MONTH_OF_MIN_YEAR,
																  YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR + 1));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MIN_YEAR, YearMonthDay.MIN_MONTH_OF_MIN_YEAR + 1, 1));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MIN_YEAR, YearMonthDay.MIN_MONTH_OF_MIN_YEAR + 1, 10));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MIN_YEAR, YearMonthDay.MIN_MONTH_OF_MIN_YEAR + 1, 30));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MIN_YEAR, YearMonthDay.MIN_MONTH_OF_MIN_YEAR + 1, 31));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(-568, 1, 1));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(-568, 1, 31));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(-568, 2, 1));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(-568, 2, 28));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(-568, 3, 1));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(-568, 3, 31));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(-568, 4, 1));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(-568, 4, 30));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(-568, 5, 1));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(-568, 5, 31));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(-568, 6, 1));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(-568, 6, 30));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(-568, 7, 1));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(-568, 7, 31));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(-568, 8, 1));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(-568, 8, 31));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(-568, 9, 1));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(-568, 9, 30));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(-568, 10, 1));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(-568, 10, 31));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(-568, 11, 1));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(-568, 11, 30));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(-568, 12, 1));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(-568, 12, 31));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(-568, 3, 1));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(-568, 12, 1));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(-1, 12, 31));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(-1, 1, 1));
		
		//Good YMD, Positive Years
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(1, 1, 1));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(1, 1, 2));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(1, 12, 1));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(1, 12, 31));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(501, 7, 8));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(501, 1, 1));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(501, 1, 31));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(501, 2, 1));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(501, 2, 28));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(501, 3, 1));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(501, 3, 31));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(501, 4, 1));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(501, 4, 30));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(501, 5, 1));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(501, 5, 31));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(501, 6, 1));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(501, 6, 30));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(501, 7, 1));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(501, 7, 31));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(501, 8, 1));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(501, 8, 31));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(501, 9, 1));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(501, 9, 30));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(501, 10, 1));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(501, 10, 31));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(501, 11, 1));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(501, 11, 30));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(501, 12, 1));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(501, 12, 31));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MAX_YEAR, 1, 1));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MAX_YEAR, 1, 31));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MAX_YEAR, 2, 1));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MAX_YEAR, 2, 28));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MAX_YEAR, 9, 1));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MAX_YEAR, 9, 30));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MAX_YEAR, 10, 1));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MAX_YEAR, 10, 6));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(YearMonthDay.MAX_YEAR,
																  YearMonthDay.MAX_MONTH_OF_MAX_YEAR,
																  YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR));
		
		//Good Leap Years
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(-3201, 2, 28));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(-401, 2, 29));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(-101, 2, 28));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(-5, 2, 29));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(-1, 2, 29));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(1, 2, 28));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(4, 2, 29));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(5, 2, 28));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(100, 2, 28));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(1000, 2, 28));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(1900, 2, 28));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(2000, 2, 29));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(2016, 2, 29));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(3200, 2, 28));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(2003, 2, 28));
		assertTrue(YearMonthDay.yearMonthDayIntIntInt_Precondition(2005, 2, 28));
	}
	

	@Test
	public void testYearMonthDay_Precondition() {
		assertTrue(YearMonthDay.YearMonthDay_Precondition());
	}
	
	@Test
	public void testYearMonthDayYearMonthDay_Precondition() {
		assertFalse(YearMonthDay.YearMonthDayYearMonthDay_Precondition(null));
		YearMonthDay ymd = new YearMonthDay();
		assertTrue(YearMonthDay.YearMonthDayYearMonthDay_Precondition(ymd));
	}

	@Test
	public void testEqualsYearMonthDay_Precondition() {
		YearMonthDay ymd = new YearMonthDay();
		YearMonthDay ymd2 = new YearMonthDay(1880, 5, 5);
		assertFalse(ymd.equalsYearMonthDay_Precondition(null));
		assertTrue(ymd.equalsYearMonthDay_Precondition(ymd2));
	}
	
	@Test
	public void testIsLeapYearInt_Precondition() {
		assertFalse(YearMonthDay.isLeapYearInt_Precondition(Integer.MIN_VALUE));
		assertFalse(YearMonthDay.isLeapYearInt_Precondition(Integer.MIN_VALUE + 1));
		assertFalse(YearMonthDay.isLeapYearInt_Precondition(YearMonthDay.MIN_YEAR - 1));
		assertTrue(YearMonthDay.isLeapYearInt_Precondition(YearMonthDay.MIN_YEAR));
		assertTrue(YearMonthDay.isLeapYearInt_Precondition(YearMonthDay.MIN_YEAR + 1));
		assertTrue(YearMonthDay.isLeapYearInt_Precondition(-1));
		assertFalse(YearMonthDay.isLeapYearInt_Precondition(0));
		assertTrue(YearMonthDay.isLeapYearInt_Precondition(1));
		assertTrue(YearMonthDay.isLeapYearInt_Precondition(YearMonthDay.MAX_YEAR - 1));
		assertTrue(YearMonthDay.isLeapYearInt_Precondition(YearMonthDay.MAX_YEAR));
		assertFalse(YearMonthDay.isLeapYearInt_Precondition(YearMonthDay.MAX_YEAR + 1));
		assertFalse(YearMonthDay.isLeapYearInt_Precondition(Integer.MAX_VALUE - 1));
		assertFalse(YearMonthDay.isLeapYearInt_Precondition(Integer.MAX_VALUE));
	}
	
	@Test
	public void testGetLastDayOfIntInt_Precondition() {
//	boolean result = year >= MIN_YEAR && year <= MAX_YEAR       &&
//	month >= 1 && month <= 12                           &&
//    (year != MIN_YEAR || month >= MIN_MONTH_OF_MIN_YEAR) &&
//    (year != MAX_YEAR || month <= MAX_MONTH_OF_MAX_YEAR);
		assertFalse(YearMonthDay.getLastDayOfIntInt_Precondition(1, Integer.MIN_VALUE));
		assertFalse(YearMonthDay.getLastDayOfIntInt_Precondition(2, Integer.MIN_VALUE + 1));
		assertFalse(YearMonthDay.getLastDayOfIntInt_Precondition(3, YearMonthDay.MIN_YEAR - 1));
		
		assertTrue(YearMonthDay.getLastDayOfIntInt_Precondition(11, YearMonthDay.MIN_YEAR));
		assertTrue(YearMonthDay.getLastDayOfIntInt_Precondition(12, YearMonthDay.MIN_YEAR));
		assertTrue(YearMonthDay.getLastDayOfIntInt_Precondition(11, YearMonthDay.MIN_YEAR + 1));
		assertTrue(YearMonthDay.getLastDayOfIntInt_Precondition(6, -1));
		assertFalse(YearMonthDay.getLastDayOfIntInt_Precondition(7, 0));
		assertTrue(YearMonthDay.getLastDayOfIntInt_Precondition(8, 1));
		assertTrue(YearMonthDay.getLastDayOfIntInt_Precondition(12, YearMonthDay.MAX_YEAR - 1));
		assertTrue(YearMonthDay.getLastDayOfIntInt_Precondition(10, YearMonthDay.MAX_YEAR));

		assertFalse(YearMonthDay.getLastDayOfIntInt_Precondition(11, YearMonthDay.MAX_YEAR));
		assertFalse(YearMonthDay.getLastDayOfIntInt_Precondition(12, Integer.MAX_VALUE));
		assertFalse(YearMonthDay.getLastDayOfIntInt_Precondition(5, YearMonthDay.MAX_YEAR + 1));
		assertFalse(YearMonthDay.getLastDayOfIntInt_Precondition(12, Integer.MAX_VALUE - 1));
		assertFalse(YearMonthDay.getLastDayOfIntInt_Precondition(1, Integer.MAX_VALUE));

		assertFalse(YearMonthDay.getLastDayOfIntInt_Precondition(Integer.MIN_VALUE, 1999));
		assertFalse(YearMonthDay.getLastDayOfIntInt_Precondition(Integer.MIN_VALUE + 1, 1999));
		assertFalse(YearMonthDay.getLastDayOfIntInt_Precondition(-1023, 1999));
		assertFalse(YearMonthDay.getLastDayOfIntInt_Precondition(-1, 1999));
		assertFalse(YearMonthDay.getLastDayOfIntInt_Precondition(0, 1999));
		assertTrue(YearMonthDay.getLastDayOfIntInt_Precondition(1, 1999));
		assertTrue(YearMonthDay.getLastDayOfIntInt_Precondition(10, 1999));
		assertTrue(YearMonthDay.getLastDayOfIntInt_Precondition(11, 1999));
		assertTrue(YearMonthDay.getLastDayOfIntInt_Precondition(12, 1999));
		assertFalse(YearMonthDay.getLastDayOfIntInt_Precondition(13, 1999));
		assertFalse(YearMonthDay.getLastDayOfIntInt_Precondition(99, 1999));
		assertFalse(YearMonthDay.getLastDayOfIntInt_Precondition(Integer.MAX_VALUE -1, 1999));
		assertFalse(YearMonthDay.getLastDayOfIntInt_Precondition(Integer.MAX_VALUE, 1999));
		
		assertFalse(YearMonthDay.getLastDayOfIntInt_Precondition(YearMonthDay.MIN_MONTH_OF_MIN_YEAR -1, YearMonthDay.MIN_YEAR));
		assertFalse(YearMonthDay.getLastDayOfIntInt_Precondition(YearMonthDay.MIN_MONTH_OF_MIN_YEAR, YearMonthDay.MIN_YEAR - 1));
		assertTrue(YearMonthDay.getLastDayOfIntInt_Precondition(YearMonthDay.MIN_MONTH_OF_MIN_YEAR, YearMonthDay.MIN_YEAR));
		assertTrue(YearMonthDay.getLastDayOfIntInt_Precondition(YearMonthDay.MIN_MONTH_OF_MIN_YEAR, YearMonthDay.MIN_YEAR + 1));
		assertTrue(YearMonthDay.getLastDayOfIntInt_Precondition(YearMonthDay.MIN_MONTH_OF_MIN_YEAR + 1, YearMonthDay.MIN_YEAR));
		assertFalse(YearMonthDay.getLastDayOfIntInt_Precondition(YearMonthDay.MIN_MONTH_OF_MIN_YEAR + 1, YearMonthDay.MIN_YEAR - 1));
		
		assertFalse(YearMonthDay.getLastDayOfIntInt_Precondition(YearMonthDay.MAX_MONTH_OF_MAX_YEAR + 1, YearMonthDay.MAX_YEAR));
		assertFalse(YearMonthDay.getLastDayOfIntInt_Precondition(YearMonthDay.MAX_MONTH_OF_MAX_YEAR, YearMonthDay.MAX_YEAR + 1));
		assertTrue(YearMonthDay.getLastDayOfIntInt_Precondition(YearMonthDay.MAX_MONTH_OF_MAX_YEAR, YearMonthDay.MAX_YEAR));
		assertTrue(YearMonthDay.getLastDayOfIntInt_Precondition(YearMonthDay.MAX_MONTH_OF_MAX_YEAR, YearMonthDay.MAX_YEAR - 1));
		assertTrue(YearMonthDay.getLastDayOfIntInt_Precondition(YearMonthDay.MAX_MONTH_OF_MAX_YEAR - 1, YearMonthDay.MAX_YEAR));
		assertFalse(YearMonthDay.getLastDayOfIntInt_Precondition(YearMonthDay.MAX_MONTH_OF_MAX_YEAR + 1, YearMonthDay.MAX_YEAR + 1));	
	}
	
	@Test
	public void testGetYear_Precondition() {
		YearMonthDay ymd = new YearMonthDay(2000, 1, 1);
		assertTrue(ymd.getYear_Precondition());
	}	
	
	@Test
	public void testGetMonth_Precondition() {
		YearMonthDay ymd = new YearMonthDay(2000, 1, 1);
		assertTrue(ymd.getMonth_Precondition());
	}
	
	@Test
	public void testGetDay_Precondition() {
		YearMonthDay ymd = new YearMonthDay(2000, 1, 1);
		assertTrue(ymd.getDay_Precondition());
	}	
	
	@Test
	public void testGetJulianDay_Precondition() {
		YearMonthDay ymd = new YearMonthDay(2000, 1, 1);
		assertTrue(ymd.getJulianDay_Precondition());
	}	
	
	@Test
	public void testToYMD_Precondition() {
//			boolean  result = julianDay >= MIN_JULIAN_DAY && julianDay <= MAX_JULIAN_DAY;

		assertFalse(YearMonthDay.toYMD_Precondition(Integer.MIN_VALUE));
		assertFalse(YearMonthDay.toYMD_Precondition(Integer.MIN_VALUE + 1));
		
		assertFalse(YearMonthDay.toYMD_Precondition(YearMonthDay.MIN_JULIAN_DAY - 1));
		assertTrue(YearMonthDay.toYMD_Precondition(YearMonthDay.MIN_JULIAN_DAY));
		assertTrue(YearMonthDay.toYMD_Precondition(YearMonthDay.MIN_JULIAN_DAY + 1));
		assertFalse(YearMonthDay.toYMD_Precondition(-1010));
		assertFalse(YearMonthDay.toYMD_Precondition(-1));
		assertFalse(YearMonthDay.toYMD_Precondition(0));
		assertTrue(YearMonthDay.toYMD_Precondition(1));
		assertTrue(YearMonthDay.toYMD_Precondition(12345));
		assertTrue(YearMonthDay.toYMD_Precondition(YearMonthDay.MAX_JULIAN_DAY - 1));
		assertTrue(YearMonthDay.toYMD_Precondition(YearMonthDay.MAX_JULIAN_DAY));
		assertFalse(YearMonthDay.toYMD_Precondition(YearMonthDay.MAX_JULIAN_DAY + 1));

		assertFalse(YearMonthDay.toYMD_Precondition(Integer.MAX_VALUE));
		assertFalse(YearMonthDay.toYMD_Precondition(Integer.MAX_VALUE + 1));
	}	
	
	@Test
	public void testToString_Precondition() {
		YearMonthDay ymd = new YearMonthDay(2000, 1, 1);
		assertTrue(ymd.toString_Precondition());
	}

	@Test
	public void testLessThanOrEqualYearMonthDay_Precondition() {
		YearMonthDay ymd = new YearMonthDay();
		YearMonthDay ymd2 = new YearMonthDay(1880, 5, 5);
		assertFalse(ymd.lessThanOrEqualToYearMonthDay_Precondition(null));
		assertTrue(ymd.lessThanOrEqualToYearMonthDay_Precondition(ymd2));
	}
	
	@Test
	public void testIncreaseBy_Precondition() {
		YearMonthDay ymd =
			new YearMonthDay(YearMonthDay.MIN_YEAR,
					         YearMonthDay.MIN_MONTH_OF_MIN_YEAR,
					         YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR);
		int almostTooBigYear = 1469714;
		int almostTooBigMonth = 10;
		int almostTooBigDay = 12;
		testIncrease(ymd, almostTooBigYear, almostTooBigMonth, almostTooBigDay);
		
		ymd = new YearMonthDay(YearMonthDay.MIN_YEAR,
						       YearMonthDay.MIN_MONTH_OF_MIN_YEAR,
						       YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR + 1);
		
		almostTooBigYear = 1469714;
		almostTooBigMonth = 10;
		almostTooBigDay = 11;
		testIncrease(ymd, almostTooBigYear, almostTooBigMonth, almostTooBigDay);

		
		ymd = new YearMonthDay(YearMonthDay.MIN_YEAR,
						       YearMonthDay.MIN_MONTH_OF_MIN_YEAR + 1,
						       YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR);
		almostTooBigYear = 1469714;
		almostTooBigMonth = 9;
		almostTooBigDay = 12;
		testIncrease(ymd, almostTooBigYear, almostTooBigMonth, almostTooBigDay);
		
		ymd = new YearMonthDay(YearMonthDay.MIN_YEAR + 1,
			       YearMonthDay.MIN_MONTH_OF_MIN_YEAR,
			       YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR);
		almostTooBigYear = 1469713;
		almostTooBigMonth = 10;
		almostTooBigDay = 12;
		testIncrease(ymd, almostTooBigYear, almostTooBigMonth, almostTooBigDay);
		
		almostTooBigYear = 1465101;
		almostTooBigMonth = 5;
		almostTooBigDay = 13;
		ymd = new YearMonthDay(-100, 4, 24);
		testIncrease(ymd, almostTooBigYear, almostTooBigMonth, almostTooBigDay);
		
		almostTooBigYear = 1465001;
		almostTooBigMonth = 9;
		almostTooBigDay = 7;
		ymd = new YearMonthDay(-1, 12, 31);
		testIncrease(ymd, almostTooBigYear, almostTooBigMonth, almostTooBigDay);
		
		almostTooBigYear = 1465001;
		almostTooBigMonth = 9;
		almostTooBigDay = 6;
		ymd = new YearMonthDay(1, 1, 1);
		testIncrease(ymd, almostTooBigYear, almostTooBigMonth, almostTooBigDay);
		
		almostTooBigYear = 1464901;
		almostTooBigMonth = 9;
		almostTooBigDay = 7;
		ymd = new YearMonthDay(100, 12, 31);
		testIncrease(ymd, almostTooBigYear, almostTooBigMonth, almostTooBigDay);
		
		almostTooBigYear = 1;
		almostTooBigMonth = 0;
		almostTooBigDay = 0;
		ymd = new YearMonthDay(YearMonthDay.MAX_YEAR - 1,
    			   YearMonthDay.MAX_MONTH_OF_MAX_YEAR,
    			   YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR);
		testIncrease(ymd, almostTooBigYear, almostTooBigMonth, almostTooBigDay);
		
		almostTooBigYear = 0;
		almostTooBigMonth = 1;
		almostTooBigDay = 0;
		ymd = new YearMonthDay(YearMonthDay.MAX_YEAR,
				   			   YearMonthDay.MAX_MONTH_OF_MAX_YEAR - 1,
				   			   YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR);
		testIncrease(ymd, almostTooBigYear, almostTooBigMonth, almostTooBigDay);
		
		almostTooBigYear = 0;
		almostTooBigMonth = 0;
		almostTooBigDay = 1;
		ymd = new YearMonthDay(YearMonthDay.MAX_YEAR,
	               			   YearMonthDay.MAX_MONTH_OF_MAX_YEAR,
	            			   YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR - 1);
		testIncrease(ymd, almostTooBigYear, almostTooBigMonth, almostTooBigDay);
		
		almostTooBigYear = 0;
		almostTooBigMonth = 0;
		almostTooBigDay = 0;
		ymd = new YearMonthDay(YearMonthDay.MAX_YEAR,
				               YearMonthDay.MAX_MONTH_OF_MAX_YEAR,
				               YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR);
		testIncrease(ymd, almostTooBigYear, almostTooBigMonth, almostTooBigDay);

	}
	
	private void testIncrease(YearMonthDay ymd, int almostTooBigYear, int almostTooBigMonth, int almostTooBigDay) {
		Duration duration = new Duration(0, 0, 0);
		assertTrue(ymd.increaseBy_Precondition(duration));
		duration = new Duration(0, 0, 1);
		if(ymd.getYear() == YearMonthDay.MAX_YEAR &&
		   ymd.getMonth() == YearMonthDay.MAX_MONTH_OF_MAX_YEAR && 
		   ymd.getDay() >= YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR)
		{
			assertFalse(ymd.increaseBy_Precondition(duration));
		} else {
			assertTrue(ymd.increaseBy_Precondition(duration));
		}
		
		duration = new Duration(0, 1, 0);
		if(ymd.getYear() == YearMonthDay.MAX_YEAR &&
		   ymd.getMonth() >= YearMonthDay.MAX_MONTH_OF_MAX_YEAR)
		{
			assertFalse(ymd.increaseBy_Precondition(duration));
		} else {
			assertTrue(ymd.increaseBy_Precondition(duration));
		}
		
		duration = new Duration(1, 0, 0);
		if(ymd.getYear() >= YearMonthDay.MAX_YEAR) {
			assertFalse(ymd.increaseBy_Precondition(duration));
		} else {
			assertTrue(ymd.increaseBy_Precondition(duration));
		}
		
		duration = new Duration(1, 1, 1);
		if(ymd.getYear() >= YearMonthDay.MAX_YEAR) {	
			assertFalse(ymd.increaseBy_Precondition(duration));
		} else if(ymd.getYear() == YearMonthDay.MAX_YEAR - 1) {
			if(ymd.getMonth() >= YearMonthDay.MAX_MONTH_OF_MAX_YEAR) {
				assertFalse(ymd.increaseBy_Precondition(duration));
			} else if(ymd.getMonth() == YearMonthDay.MAX_MONTH_OF_MAX_YEAR - 1) {
				if(ymd.getDay() >= YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR) {
					assertFalse(ymd.increaseBy_Precondition(duration));
				} else {
					assertTrue(ymd.increaseBy_Precondition(duration));
				}
			} else {
				assertTrue(ymd.increaseBy_Precondition(duration));
			}
		} else {
			assertTrue(ymd.increaseBy_Precondition(duration)); 
		}
		
		if(almostTooBigYear > 0) {
			duration = new Duration(almostTooBigYear, almostTooBigMonth, almostTooBigDay);
			assertTrue(ymd.increaseBy_Precondition(duration));
			if(almostTooBigYear > 1) {
				duration = new Duration(almostTooBigYear - 1, almostTooBigMonth, almostTooBigDay);
				assertTrue(ymd.increaseBy_Precondition(duration));
				if(almostTooBigYear > 2) {
					duration = new Duration(almostTooBigYear - 2, almostTooBigMonth, almostTooBigDay);
					assertTrue(ymd.increaseBy_Precondition(duration));
					if(almostTooBigYear > 100) {
						duration = new Duration(almostTooBigYear - 100, almostTooBigMonth, almostTooBigDay);
						assertTrue(ymd.increaseBy_Precondition(duration));
					}
				}
			}
		}
		
		if(almostTooBigMonth > 0) {
			duration = new Duration(almostTooBigYear, almostTooBigMonth - 1, almostTooBigDay);
			assertTrue(ymd.increaseBy_Precondition(duration));
		}
		
		if(almostTooBigMonth > 1) {
			duration = new Duration(almostTooBigYear, almostTooBigMonth - 2, almostTooBigDay);
			assertTrue(ymd.increaseBy_Precondition(duration));
		}
		
		duration = new Duration(almostTooBigYear, 0, almostTooBigDay);
		assertTrue(ymd.increaseBy_Precondition(duration));
		
		if(almostTooBigDay > 0) {
			duration = new Duration(almostTooBigYear, almostTooBigMonth, almostTooBigDay - 1);
			assertTrue(ymd.increaseBy_Precondition(duration));
		}
		
		if(almostTooBigDay > 1) {
			duration = new Duration(almostTooBigYear, almostTooBigMonth, almostTooBigDay - 2);
			assertTrue(ymd.increaseBy_Precondition(duration));
		}
		
		duration = new Duration(almostTooBigYear, almostTooBigMonth, 0);
		assertTrue(ymd.increaseBy_Precondition(duration));
		
		duration = new Duration(almostTooBigYear + 1, almostTooBigMonth, almostTooBigDay);
		assertFalse(ymd.increaseBy_Precondition(duration));
		duration = new Duration(almostTooBigYear + 2, almostTooBigMonth, almostTooBigDay);
		assertFalse(ymd.increaseBy_Precondition(duration));
		duration = new Duration(almostTooBigYear + 1, almostTooBigMonth, almostTooBigDay);
		assertFalse(ymd.increaseBy_Precondition(duration));
		duration = new Duration(almostTooBigYear, almostTooBigMonth + 1, almostTooBigDay);
		assertFalse(ymd.increaseBy_Precondition(duration));
		duration = new Duration(almostTooBigYear, almostTooBigMonth + 2, almostTooBigDay);
		assertFalse(ymd.increaseBy_Precondition(duration));
		duration = new Duration(almostTooBigYear, Integer.MAX_VALUE, almostTooBigDay);
		assertFalse(ymd.increaseBy_Precondition(duration));
		duration = new Duration(almostTooBigYear, almostTooBigMonth, almostTooBigDay + 1);
		assertFalse(ymd.increaseBy_Precondition(duration));
		duration = new Duration(almostTooBigYear, almostTooBigMonth, almostTooBigDay + 2);
		assertFalse(ymd.increaseBy_Precondition(duration));
		duration = new Duration(almostTooBigYear, almostTooBigMonth, Integer.MAX_VALUE);
		assertFalse(ymd.increaseBy_Precondition(duration));
	}
	
	@Test
	public void testDecreaseBy_Precondition() {
		YearMonthDay ymd =
			new YearMonthDay(YearMonthDay.MAX_YEAR,
				         YearMonthDay.MAX_MONTH_OF_MAX_YEAR,
				         YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR);
		int almostTooBigYear = 1469714;
		int almostTooBigMonth = 10;
		int almostTooBigDay = 12;
		testDecrease(ymd, almostTooBigYear, almostTooBigMonth, almostTooBigDay);
		
		ymd = new YearMonthDay(YearMonthDay.MAX_YEAR,
					       YearMonthDay.MAX_MONTH_OF_MAX_YEAR,
					       YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR - 1);
		almostTooBigYear = 1469714;
		almostTooBigMonth = 10;
		almostTooBigDay = 11;
		testDecrease(ymd, almostTooBigYear, almostTooBigMonth, almostTooBigDay);

		
		ymd = new YearMonthDay(YearMonthDay.MAX_YEAR,
					       YearMonthDay.MAX_MONTH_OF_MAX_YEAR - 1,
					       YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR);
		almostTooBigYear = 1469714;
		almostTooBigMonth = 9;
		almostTooBigDay = 12;
		testDecrease(ymd, almostTooBigYear, almostTooBigMonth, almostTooBigDay);
		
		ymd = new YearMonthDay(YearMonthDay.MAX_YEAR - 1,
			       YearMonthDay.MAX_MONTH_OF_MAX_YEAR,
			       YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR);
		almostTooBigYear = 1469713;
		almostTooBigMonth = 10;
		almostTooBigDay = 12;
		testDecrease(ymd, almostTooBigYear, almostTooBigMonth, almostTooBigDay);
		
		almostTooBigYear = 4613;
		almostTooBigMonth = 4;
		almostTooBigDay = 29;
		ymd = new YearMonthDay(-100, 4, 24);
		testDecrease(ymd, almostTooBigYear, almostTooBigMonth, almostTooBigDay);
		
		almostTooBigYear = 4713;
		almostTooBigMonth = 1;
		almostTooBigDay = 5;
		ymd = new YearMonthDay(-1, 12, 31);
		testDecrease(ymd, almostTooBigYear, almostTooBigMonth, almostTooBigDay);
		
		almostTooBigYear = 4713;
		almostTooBigMonth = 1;
		almostTooBigDay = 6;
		ymd = new YearMonthDay(1, 1, 1);
		testDecrease(ymd, almostTooBigYear, almostTooBigMonth, almostTooBigDay);
		
		almostTooBigYear = 4813;
		almostTooBigMonth = 1;
		almostTooBigDay = 5;
		ymd = new YearMonthDay(100, 12, 31);
		testDecrease(ymd, almostTooBigYear, almostTooBigMonth, almostTooBigDay);
		
		almostTooBigYear = 1;
		almostTooBigMonth = 0;
		almostTooBigDay = 0;
		ymd = new YearMonthDay(YearMonthDay.MIN_YEAR + 1,
	    		   YearMonthDay.MIN_MONTH_OF_MIN_YEAR,
	    		   YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR);
		testDecrease(ymd, almostTooBigYear, almostTooBigMonth, almostTooBigDay);
		
		almostTooBigYear = 0;
		almostTooBigMonth = 1;
		almostTooBigDay = 0;
		ymd = new YearMonthDay(YearMonthDay.MIN_YEAR,
				   		   YearMonthDay.MIN_MONTH_OF_MIN_YEAR + 1,
				   		   YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR);
		testDecrease(ymd, almostTooBigYear, almostTooBigMonth, almostTooBigDay);
		
		almostTooBigYear = 0;
		almostTooBigMonth = 0;
		almostTooBigDay = 1;
		ymd = new YearMonthDay(YearMonthDay.MIN_YEAR,
		               		   YearMonthDay.MIN_MONTH_OF_MIN_YEAR,
		            		   YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR + 1);
		testDecrease(ymd, almostTooBigYear, almostTooBigMonth, almostTooBigDay);
		
		almostTooBigYear = 0;
		almostTooBigMonth = 0;
		almostTooBigDay = 0;
		ymd = new YearMonthDay(YearMonthDay.MIN_YEAR,
				               YearMonthDay.MIN_MONTH_OF_MIN_YEAR,
				               YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR);
		testDecrease(ymd, almostTooBigYear, almostTooBigMonth, almostTooBigDay);
	}
	
	private void testDecrease(YearMonthDay ymd, int almostTooSmallYear, int almostTooSmallMonth, int almostTooSmallDay) {
		Duration duration = new Duration(0, 0, 0);
		assertTrue(ymd.decreaseBy_Precondition(duration));
		duration = new Duration(0, 0, 1);
		if(ymd.getYear() == YearMonthDay.MIN_YEAR &&
		   ymd.getMonth() == YearMonthDay.MIN_MONTH_OF_MIN_YEAR && 
		   ymd.getDay() <= YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR)
		{
			assertFalse(ymd.decreaseBy_Precondition(duration));
		} else {
			assertTrue(ymd.decreaseBy_Precondition(duration));
		}
		
		duration = new Duration(0, 1, 0);
		if(ymd.getYear() == YearMonthDay.MIN_YEAR &&
		   ymd.getMonth() <= YearMonthDay.MIN_MONTH_OF_MIN_YEAR)
		{
			assertFalse(ymd.decreaseBy_Precondition(duration));
		} else {
			assertTrue(ymd.decreaseBy_Precondition(duration));
		}
		
		duration = new Duration(1, 0, 0);
		if(ymd.getYear() <= YearMonthDay.MIN_YEAR) {
			assertFalse(ymd.decreaseBy_Precondition(duration));
		} else {
			assertTrue(ymd.decreaseBy_Precondition(duration));
		}
		
		duration = new Duration(1, 1, 1);
		if(ymd.getYear() <= YearMonthDay.MIN_YEAR) {	
			assertFalse(ymd.decreaseBy_Precondition(duration));
		} else if(ymd.getYear() == YearMonthDay.MIN_YEAR + 1) {
			if(ymd.getMonth() <= YearMonthDay.MIN_MONTH_OF_MIN_YEAR) {
				assertFalse(ymd.decreaseBy_Precondition(duration));
			} else if(ymd.getMonth() == YearMonthDay.MIN_MONTH_OF_MIN_YEAR + 1) {
				if(ymd.getDay() <= YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR) {
					assertFalse(ymd.decreaseBy_Precondition(duration));
				} else {
					assertTrue(ymd.decreaseBy_Precondition(duration));
				}
			} else {
				assertTrue(ymd.decreaseBy_Precondition(duration));
			}
		} else {
			assertTrue(ymd.decreaseBy_Precondition(duration)); 
		}
		
		if(almostTooSmallYear > 0) {
			duration = new Duration(almostTooSmallYear, almostTooSmallMonth, almostTooSmallDay);
			assertTrue(ymd.decreaseBy_Precondition(duration));
			if(almostTooSmallYear > 1) {
				duration = new Duration(almostTooSmallYear - 1, almostTooSmallMonth, almostTooSmallDay);
				assertTrue(ymd.decreaseBy_Precondition(duration));
				if(almostTooSmallYear > 2) {
					duration = new Duration(almostTooSmallYear - 2, almostTooSmallMonth, almostTooSmallDay);
					assertTrue(ymd.decreaseBy_Precondition(duration));
					if(almostTooSmallYear > 100) {
						duration = new Duration(almostTooSmallYear - 100, almostTooSmallMonth, almostTooSmallDay);
						assertTrue(ymd.decreaseBy_Precondition(duration));
					}
				}
			}
		}
		
		if(almostTooSmallMonth > 0) {
			duration = new Duration(almostTooSmallYear, almostTooSmallMonth - 1, almostTooSmallDay);
			assertTrue(ymd.decreaseBy_Precondition(duration));
		}
		
		if(almostTooSmallMonth > 1) {
			duration = new Duration(almostTooSmallYear, almostTooSmallMonth - 2, almostTooSmallDay);
			assertTrue(ymd.decreaseBy_Precondition(duration));
		}
		
		duration = new Duration(almostTooSmallYear, 0, almostTooSmallDay);
		assertTrue(ymd.decreaseBy_Precondition(duration));
		
		if(almostTooSmallDay > 0) {
			duration = new Duration(almostTooSmallYear, almostTooSmallMonth, almostTooSmallDay - 1);
			assertTrue(ymd.decreaseBy_Precondition(duration));
		}
		
		if(almostTooSmallDay > 1) {
			duration = new Duration(almostTooSmallYear, almostTooSmallMonth, almostTooSmallDay - 2);
			assertTrue(ymd.decreaseBy_Precondition(duration));
		}
		
		duration = new Duration(almostTooSmallYear, almostTooSmallMonth, 0);
		assertTrue(ymd.decreaseBy_Precondition(duration));
		
		duration = new Duration(almostTooSmallYear + 1, almostTooSmallMonth, almostTooSmallDay);
		assertFalse(ymd.decreaseBy_Precondition(duration));
		duration = new Duration(almostTooSmallYear + 2, almostTooSmallMonth, almostTooSmallDay);
		assertFalse(ymd.decreaseBy_Precondition(duration));
		duration = new Duration(almostTooSmallYear, almostTooSmallMonth + 1, almostTooSmallDay);
		assertFalse(ymd.decreaseBy_Precondition(duration));
		duration = new Duration(almostTooSmallYear, almostTooSmallMonth + 2, almostTooSmallDay);
		assertFalse(ymd.decreaseBy_Precondition(duration));
		duration = new Duration(almostTooSmallYear, Duration.MAX_DURATION_YEAR, almostTooSmallDay);
		assertFalse(ymd.decreaseBy_Precondition(duration));
		duration = new Duration(almostTooSmallYear, almostTooSmallMonth, almostTooSmallDay + 1);
		assertFalse(ymd.decreaseBy_Precondition(duration));
		duration = new Duration(almostTooSmallYear, almostTooSmallMonth, almostTooSmallDay + 2);
		assertFalse(ymd.decreaseBy_Precondition(duration));
		duration = new Duration(almostTooSmallYear, almostTooSmallMonth, Integer.MAX_VALUE);
		assertFalse(ymd.decreaseBy_Precondition(duration));
	}
	
	@Test
	public void testCoverage() {
		YearMonthDay ymd = new YearMonthDay(1980, 2, 29);
		ymd.increaseBy(Duration.ONE_YEAR);
		assertTrue(ymd.toString(), ymd.equals(new YearMonthDay(1981, 2, 28)));
		
		ymd = new YearMonthDay(1980, 2, 29);
		ymd.decreaseBy(Duration.ONE_YEAR);
		assertTrue(ymd.toString(), ymd.equals(new YearMonthDay(1979, 2, 28)));
		
		ymd = new YearMonthDay(1999, 5, 31);
		ymd.decreaseBy(Duration.ONE_MONTH);
		assertTrue(ymd.toString(), ymd.equals(new YearMonthDay(1999,4,30)));
		
		assertTrue(YearMonthDay.getLastDayOf(YearMonthDay.MAX_MONTH_OF_MAX_YEAR - 1, YearMonthDay.MAX_YEAR) == 30);
	
		ymd = new YearMonthDay(1979, 2, 1);
		ymd.increaseBy(new Duration(0, 11, 0));
		YearMonthDay expectedResult = new YearMonthDay(1980, 1, 1);
		assertTrue(ymd.equals(expectedResult));	
		
		ymd = new YearMonthDay(1980, 1, 1);
		ymd.decreaseBy(new Duration(0, 11, 0));
		expectedResult = new YearMonthDay(1979, 2, 1);
		assertTrue(ymd.toString(), ymd.equals(expectedResult));
		
		ymd = new YearMonthDay(1980, 12, 10);
		ymd.decreaseBy(new Duration(0, 1, 0));
		expectedResult = new YearMonthDay(1980, 11, 10);
		assertTrue(ymd.toString(), ymd.equals(expectedResult));
		
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
