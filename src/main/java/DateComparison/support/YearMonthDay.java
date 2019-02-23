package DateComparison.support;

/**
 * A year with an optional month and day.
 * <pre>
 * <b>Domain</b>:
 * 		year int;
 * 		month int;
 * 		day int;
 * 
 * invariant: year &ge; MIN_YEAR AND and year != 0 AND year &le; MAX_YEAR AND
 *            month &ge; 1 AND month &le; 12 AND
 *            	(year = MIN_YEAR &rArr; month &ge; MIN_MONTH_OF_MIN_YEAR) AND
 *            	(year = MAX_YEAR &rArr; month &le; MAX_MONTH_OF_MAX_YEAR) AND
 *            day &ge; 1 AND
 *            	(month = 1 OR month = 3 OR month = 5 && month = 7 OR month = 8 OR month = 10 OR month = 12) &rArr;
 *              	day &le; 31 AND
 *            	(month = 4 OR month = 6 OR month = 9 OR month = 11) &rArr; day &le; 30 AND
 *            	(getLastDayOfInt(year) AND month = 2) &rArr; day &le; 29 AND
 *            	(NOT getLastDayOfInt(year) AND month = 2) &rArr; day &le; 28 AND
 *            	((year = MIN_YEAR AND month = MIN_MONTH_OF_MIN_YEAR) &rArr; day &ge; MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR) AND
 *            	((year = MAX_YEAR AND month = MAX_MONTH_OF_MAX_YEAR) &rArr; day &le; MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR) AND
 * </pre>
 * @author Scott Woodfield
 *
 */
public class YearMonthDay {
//Domain Implementation
	private int year;
	private int month;
	private int day;
	
//Constructors
	/**
	 * Default Constructor
	 * @pre None
	 * @req pre
	 * @post year = MIN_YEAR AND month = MIN_MONTH_OF_MIN_YEAR AND day = MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR
	 */
	public YearMonthDay() {
		assert YearMonthDay_Requirements();
		
		year = MIN_YEAR;
		month = MIN_MONTH_OF_MIN_YEAR;
		day = MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR;
		
		assert YearMonthDay_Postcondition() && invariant();
	}
	
	/**
	 * The copy constructor
	 * @param yearMonthDay the YearMonthDay to be copied
	 * @pre yearMonthDay &ne; null
	 * @req pre
	 * @post year = yearMonthDay.year AND month = yearMonthDay.month && day = yearMonthDay.day
	 */
	public YearMonthDay(YearMonthDay yearMonthDay) {
		assert YearMonthDayYearMonthDay_Requirements(yearMonthDay);
		
		year = yearMonthDay.year;
		month = yearMonthDay.month;
		day = yearMonthDay.day;
		
		assert YearMonthDayYearMonthDay_Postcondition(yearMonthDay) && invariant();
	}
	
	/**
	 * The constructor
	 * @param year the new year
	 * @param month the new month
	 * @param day the new day
	 * @pre invariant(year, month, day)
	 * @req pre
     * @post None
	 */
	public YearMonthDay(int year, int month, int day) {
		assert yearMonthDayIntIntInt_Requirements(year, month, day);
		
		this.year = year;
		this.month = month;
		this.day = day;
		
		assert yearMonthDayIntIntInt_Postcondition(year, month, day) && invariant();
	}

//Queries
	/**
	 * @param ymd YearMonthDay to compare to
	 * @pre ymd != null
	 * @req pre
	 * @post result = (year = ymd.year AND month = ymd.month AND day = ymd.day);
	 */
	public boolean equals(YearMonthDay ymd) {
		assert equalsYearMonthDay_Requirements(ymd) && invariant();
		
		boolean result = year == ymd.year && month == ymd.month && day == ymd.day;
		
		assert equalsYearMonthDay_Postcondition(ymd, result) && invariant();
		return result;
	}
	
	/**
	 * Determine if this YearMonthDay is less than or equal to ymd
	 * @param ymd the YearMonthDay to compareTo
	 * @pre ymd &ne; null
	 * @req pre
	 * @post result = (year < ymd.year) OR
	 *                ((year = ymd.year) AND
	 *                 (month < ymd.month OR
	 *                  (month = ymd.month AND
	 *                   day &le; ymd.day
	 *                  )
	 *                 )
	 *                )
	 */
	public boolean lessThanOrEqualTo(YearMonthDay ymd) {
		assert lessThanOrEqualToYearMonthDay_Requirements(ymd) && invariant();
		
		boolean result = (year < ymd.year) ||
				         (year == ymd.year && month < ymd.month) ||
				         (year == ymd.year && month == ymd.month && day <= ymd.day);
		
		assert lessThanOrEqualToYearMonthDay_Postcondition(ymd, result) && invariant();
		return result;	          
	}
	
	
	/**
	 * 
	 * @param year
	 * @pre year &ne; 0 && year &ge; MIN_YEAR && year &le; MAX_YEAR
	 * @req  pre
	 * @post year > 0 &rArr; result = (year mod 4 = 0 AND (year mod 100 &ne; 0 OR year mod 400 = 0)) AND
	 *       year < 0 &rArr; result = (((-year - 1) &ne; 0) AND
	 *                                 ((-year - 1) &ne; 0 &rArr; isLeapYear(-year - 1))
	 *                                ) 
	 */
	public static boolean isLeapYear(int year) {
		assert isLeapYearInt_Requirements(year);
		
		assert year != 0 && year >= MIN_YEAR && year <= MAX_YEAR;
		
		boolean result = false;
		if(year > 0) {
			result = year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
		} else { 
			int adjustedYear = -(year + 1);
			if(adjustedYear == 0) {
				result = true;
			} else {
				result = isLeapYear(adjustedYear);
			}
		}
		
		assert(isLeapYearInt_Postcondition(year, result));
		return result;
	}
	
	/**
	 * Some months have 30 day and some have 31, some have 28 unless it is a leap year then then have 29
	 * @param month we want to know how many days are in this month of the year
	 * @param year we want to know how many days a particular months in this year has
	 * @pre year &ge; MIN_YEAR AND year &le; MAX_YEAR AND year  &ne; 0 AND
	 *      month &ge; 1 AND month &le; 12 AND
	 *      year = MIN_YEAR &rArr; month &ge; MIN_MONTH_OF_MIN_YEAR AND
	 *      year = MAX_YEAR &rArr; month &le; MAX_MONTH_OF_MAX_YEAR
	 * @req pre
	 * @post month = 1 OR 3 OR 5 OR 7 OR 8 OR 10 OR 12 &rArr; result = 31 AND
	 *       month = 4 OR 6 OR 9 OR 11 &rArr; result = 30 AND
	 *       (month = 2 AND getLastDayOfInt(year)) &rArr; result = 29 AND
	 *       (month = 2 AND &not; getLastDayOfInt(year) &rArr; result = 28
	 */
	public static int getLastDayOf(int month, int year) {
		assert getLastDayOfIntInt_Requirements(month, year);
		
		int result = 31;
		
		if(year == MAX_YEAR && month == MAX_MONTH_OF_MAX_YEAR) {
			result = MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR;
		} else {
			if(month == 4 || month == 6 || month == 9 || month == 11) {
				result = 30;
			} else if(month == 2) {
				if(YearMonthDay.isLeapYear(year)) {
					result = 29;
				} else {
					result = 28;
				}
			}
		}
		
		assert getLastDayOfIntInt_Postcondition(month, year, result);
		return result;
	}
	
	/**
	 * year getter
	 * @pre None
	 * @req pre
	 * @post result = year
	 */
	public int getYear() {
		assert getYear_Requirements() && invariant();
		
		int result = year;
		
		assert getYear_Postcondition(result) && invariant();
		return result;
	}
	
	/**
	 * month getter
	 * @pre None
	 * @req pre
	 * @post result = month
	 */
	public int getMonth() {
		assert getMonth_Requirements() && invariant();
		
		int result = month;
		
		assert getMonth_Postcondition(result) && invariant();
		return result;
	}
	
	/**
	 * day getter
	 * @pre None
	 * @req pre
	 * @post result = day
	 */
	public int getDay() {
		assert getDay_Requirements() && invariant();
		
		int result = day;
		
		assert getDay_Postcondition(result) && invariant();
		return result;
	}
	
	/**
	 * Get the Julian day number for the current year, month, and day
	 * @req None
	 * @post result = day - 32075 +
					  1461 * ((year < 0 ? year + 1 : year) + 4800 + (month - 14)/12)/4 +
					  367 * (month - 2 - (month - 14)/12 * 12)/12 -
					  3 * (((year < 0 ? year + 1 : year) + 4900 + (month - 14)/12)/100)/4;
	 */
	public int getJulianDay() {
		assert getJulianDay_Requirements() && invariant();
		
		int yearAdjustedForNoYear0 = year < 0 ? year + 1 : year;
		int result = day - 32075 +
					 1461 * (yearAdjustedForNoYear0 + 4800 + (month - 14)/12)/4 +
					 367 * (month - 2 - (month - 14)/12 * 12)/12 -
					 3 * ((yearAdjustedForNoYear0 + 4900 + (month - 14)/12)/100)/4;
		
		assert getJulianDay_Postcondition(result) && invariant();
		return result;
	}
	
	/**
	 * Converts a JulianDay to a YearMonthDay
	 * @param julianDay the julian day we are going to convert
	 * @pre MIN_JULIAN_DAY &le; julianDay &le; MAX_Julian_Day
	 * @req	pre
	 * @post result.getJulianDay() == julianDay
	 */
	public static YearMonthDay toYMD(int julianDay) {
		assert toYMD_Requirements(julianDay);
		
		int L = julianDay + 68569;
		int N = 4*L/146097;
		L = L-(146097*N+3)/4;
		int I = 4000*(L+1)/1461001;
		L = L - 1461*I/4+31;
		int J = 80*L/2447;
		int day = L-2447*J/80;
		L = J/11;
		int month = J+2-12*L;
		int year = 100*(N-49)+I+L;
		int yearAdjustedForNoYear0 = year <= 0 ? year - 1 : year;
		
		YearMonthDay result = new YearMonthDay(yearAdjustedForNoYear0, month, day);

		assert toYMD_Postcondition(julianDay, result);
		return result;
	}

	/**
	 * Creates a lexical representation of a YearMonthDay
	 * @pre None
	 * @req pre
	 * @post result = year + "/" + month + "/" + day;
	 */
	public String toString() {
		assert toString_Requirements() && invariant();
		
		StringBuilder resultStringBuilder = new StringBuilder();
		resultStringBuilder.append(year);
		resultStringBuilder.append("/");
		resultStringBuilder.append(month);
		resultStringBuilder.append("/");
		resultStringBuilder.append(day);
		
		String result = resultStringBuilder.toString();
		
		assert toString_Postcondition(result) && invariant();
		return result;
	}
	
//Commands
	/**
	 * Increase the current YearMonthDay by the duration
	 * @param duration the amount to increase this YearMonthDay by
	 * @pre the result must be &le; MAX_YMD
	 * @req pre
	 * @post newYear = year' + duration.getYears() + duration.getMonths()/MONTHS_IN_YEAR;
	 *       newYear += ((year' < 0 AND newYear &ge; 0) ? 1 : 0);
	 *       newMonth = month' + (duration.getMonths MOD MONTHS_IN_YEAR);
	 *       newYear = (newMonth > MONTHS_IN_YEAR ? (newYear + 1 = 0 ? newYear + 2 : newYear + 1) : newYear;
	 *       newMonth = (newMonth > MONTHS_IN_YEAR) ? newMonth - MONTHS_IN_YEAR : newMonth;
	 *       newDay = day' - (month' = 2 AND day' = 29 AND !isLeapYear(newYear) ? 1 : 0);
	 *       daysInMonth = DAYS_IN_MONTH[newMonth - 1] + (newMonth = 2 AND isLeapYear(newYear) ? 1 : 0);
	 *       newDay = (newDay > daysInMonth : daysInMonth ? newDay);
	 *       
	 *       year = toYMD(getJulianDay(newYear, newMonth, newDay) + duration.getDays()).getYear() AND
	 *       month = toYMD(getJulianDay(newYear, newMonth, newDay) + duration.getDays()).getMonth() AND
	 *       day = toYMD(getJulianDay(newYear, newMonth, newDay) + duration.getDays()).getDay() AND
	 *       result = this;
	 */
	public YearMonthDay increaseBy(Duration duration) {
		assert increaseBy_Requirements1(duration) && invariant();
		
		int[] newDate = computeNewYearNewMonthNewDayIncrementBy(duration);

		assert increaseBy_Requirements2(newDate[0], newDate[1], newDate[2], duration) && invariant();
		int newJulianDay = getJulianDay(newDate[0], newDate[1], newDate[2]) + duration.getDays();
		
		YearMonthDay ymd = toYMD(newJulianDay);
		
		year = ymd.year;
		month = ymd.month;
		day = ymd.day;

		YearMonthDay result = this;
		assert increaseBy_Postcondition(duration, result) && invariant();
		return result;
	}
	
//	public void increaseByUsingJulianDayPerspective(Duration duration) {
//		assert duration != null;
//		
//		int daysToAddForAdditionalYears = getDaysToAddForAdditionalYears(duration);
//		int daysToAddForAdditionalMonths = getDaysToAddForAdditionalMonths(duration);
//		int daysToAddFromDuration = duration.getDays();
//	
//		int daysToAdd = daysToAddFromDuration          + 
//				        daysToAddForAdditionalMonths   +
//				        daysToAddForAdditionalYears;
//
//		int julianDay = getJulianDay();
//		int newJulianDay = julianDay + daysToAdd;
//		YearMonthDay ymd = toYMD(newJulianDay);
//		year = ymd.year;
//		month = ymd.month;
//		day = ymd.day;
//		
//		assert(invariant(year, month, day));
//	}
	
	/**
	 * Decrease the the YearMonthDay by the specified duration
	 * @param duration the amount to decrease the YearMonthDay by
	 * @post
	 * 		int newYear = year_prime - duration.getYears() - duration.getMonths()/MONTHS_IN_YEAR;
	 *		newYear -= year_prime > 0 && newYear <= 0 ? 1 : 0;
	 *		int newMonth = month_prime - (duration.getMonths() % MONTHS_IN_YEAR);
	 *		newYear = (newMonth <= 0 ? (newYear - 1 == 0 ? newYear - 2 : newYear - 1) : newYear);
	 *		newMonth = (newMonth <= 0) ? newMonth + MONTHS_IN_YEAR : newMonth;
	 *		int newDay = day_prime - (month_prime == 2 && day_prime == 29 && !isLeapYear(newYear) ? 1 : 0);
	 *		int daysInMonth = DAYS_IN_MONTH[newMonth - 1] + (newMonth == 2 && isLeapYear(newYear) ? 1 : 0);
	 *		newDay = newDay > daysInMonth ? daysInMonth : newDay;
	 *
	 *       year = toYMD(getJulianDay(newYear, newMonth, newDay) - duration.getDays()).getYear() AND
	 *       month = toYMD(getJulianDay(newYear, newMonth, newDay) - duration.getDays()).getMonth() AND
	 *       day = toYMD(getJulianDay(newYear, newMonth, newDay) - duration.getDays()).getDay() AND
	 *       result = this;
	 */
	public YearMonthDay decreaseBy(Duration duration) {	
		assert decreaseBy_Requirements1(duration) && invariant();
		
		int[] newDate = computeNewYearNewMonthNewDayDecrementBy(duration);

		assert decreaseBy_Requirements2(newDate[0], newDate[1], newDate[2], duration) && invariant();
		int newJulianDay = getJulianDay(newDate[0], newDate[1], newDate[2]) - duration.getDays();
		
		YearMonthDay ymd = toYMD(newJulianDay);
		
		year = ymd.year;
		month = ymd.month;
		day = ymd.day;

		YearMonthDay result = this;
		assert decreaseBy_Postcondition(duration, result) && invariant();
		return result;
	}
	
	
//	public void decreaseByUsingJulianDayPerspective(Duration duration) {
//		assert duration != null;
//		
//		int daysToSubtractForAdditionalYears = getDaysToSubtractForAdditionalYears(duration);
//		int daysToSubtractForAdditionalMonths = getDaysToSubtractForAdditionalMonths(duration);
//		int daysToSubtractFromDuration = duration.getDays();
//		
//		int daysToSubtract = daysToSubtractFromDuration                              +
//				             daysToSubtractForAdditionalMonths                       +
//				             daysToSubtractForAdditionalYears;
//		
//		int currentJulianDay = getJulianDay();
//		int newJulianDay = currentJulianDay - daysToSubtract;
//		YearMonthDay ymd = toYMD(newJulianDay);
//		year = ymd.year;
//		month = ymd.month;
//		day = ymd.day;
//		
//		assert(invariant(year, month, day));
//	}

//Constants
	public static int JANUARY = 1;
	public static int DECEMBER = 12;
	public static int FIRST_DAY_OF_ANY_MONTH = 1;
	public static int LAST_DAY_OF_DECEMBER = 31;
	public static int LAST_DAY_OF_JANUARY = 31;
	
	public static final int MAX_YEAR = 1465002;
	public static final int MAX_MONTH_OF_MAX_YEAR = 10;
	public static final int MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR = 7;
	
	public static final int MIN_YEAR = -4714;
	public static final int MIN_MONTH_OF_MIN_YEAR = 11;
	public static final int MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR = 25;
	
	public static final YearMonthDay MAX_YMD = new YearMonthDay(MAX_YEAR, 
																MAX_MONTH_OF_MAX_YEAR,
																MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR);
	public static final int MAX_JULIAN_DAY = MAX_YMD.getJulianDay();
	
	public static final YearMonthDay MIN_YMD = new YearMonthDay(MIN_YEAR,
																MIN_MONTH_OF_MIN_YEAR,
																MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR);
	public static final int MIN_JULIAN_DAY = MIN_YMD.getJulianDay();
	
//Supporting constants and methods
	private static final int MONTHS_IN_YEAR = 12;
//	private static final int DAYS_IN_A_NORMAL_YEAR = 365;
	
	protected static final int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
//	private static final int[] DAYS_SINCE_JAN_1 =
//		{0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
	

	private int getJulianDay(int year, int month, int day) {
		assert (year > MIN_YEAR                                     ||
			    (year == MIN_YEAR && month > MIN_MONTH_OF_MIN_YEAR) || 
				(year == MIN_YEAR               && 
				 month == MIN_MONTH_OF_MIN_YEAR &&
				 day >= MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR
				)
			   ) &&
			   (year < MAX_YEAR                                     ||
				(year == MAX_YEAR && month < MAX_MONTH_OF_MAX_YEAR) || 
				(year == MAX_YEAR               && 
				 month == MAX_MONTH_OF_MAX_YEAR &&
			     day <= MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR
				)
			   );
				   
		int yearAdjustedForNoYear0 = year < 0 ? year + 1 : year;
		int result = day - 32075 +
					 1461 * (yearAdjustedForNoYear0 + 4800 + (month - 14)/12)/4 +
					 367 * (month - 2 - (month - 14)/12 * 12)/12 -
					 3 * ((yearAdjustedForNoYear0 + 4900 + (month - 14)/12)/100)/4;

		return result;
	}

//	private int getDaysToAddForAdditionalYears(Duration duration) {
//		int additionalYears = duration.getYears() + duration.getMonths() / MONTHS_IN_YEAR;
//		int result = additionalYears * DAYS_IN_A_NORMAL_YEAR;
//		
//		result += getNumberOfLeapDaysGoingForward(duration);
//		if(additionalYears > 0 && isLeapYear(year) && month >= 3) {
//			result--;
//		}
//		
//		int lastYear = year + duration.getYears();
//		if(lastYear == 0) {
//			lastYear++;
//		}
//		if(duration.getYears() > 0 && isLeapYear(lastYear) && month >= 3) {
//			result++;
//		}
//		
//		return result;
//	}
//
//	private int getDaysToSubtractForAdditionalYears(Duration duration) {
//		int additionalYears = duration.getYears() + duration.getMonths() / MONTHS_IN_YEAR;
//		int result = additionalYears * DAYS_IN_A_NORMAL_YEAR;
//		
//		result += getNumberOfLeapDaysGoingBackward(duration);
//		if(additionalYears > 0 && isLeapYear(year) && month >= 3) {
//			result++;
//		}
//		
//		int lastYear = year - duration.getYears();
//		if(lastYear == 0) {
//			lastYear--;
//		}
//		if(duration.getYears() > 0 && isLeapYear(lastYear) && month >= 3) {
//			result--;
//		}
//		
//		return result;
//	}
//	
//	private int getDaysToAddForAdditionalMonths(Duration duration) {
//		//We assume that getDaysToSubtractForAdditional years would have compensated for
//		//duration.month >= 12.  That is duration.month / 12 was added to duration.years
//		//to compute the number of additional Julian days for additional years.  Thus,
//		//here we assume (though we have to compute it) we only compensate for 0 to 11
//		//additional months computed by duration.getMonths() % MONTHS_IN_YEAR.
//		
//		int result = 0;
//		if(duration.getMonths() > 0) {
//			int finalMonth = month + duration.getMonths() % MONTHS_IN_YEAR;
//			if(finalMonth > MONTHS_IN_YEAR) {
//				finalMonth -= MONTHS_IN_YEAR;
//			}
//			
//			//By computing the additional months this way we don't need two arrays,
//			//one for DAYS_SINCE_JAN_1 going forward, and one going backward.
//			//This subtraction does NOT compensate for leap days.  That is done in
//			//the next step.
//			result = DAYS_SINCE_JAN_1[finalMonth -1] - DAYS_SINCE_JAN_1[month - 1];
//			int nextYear = year;
//			if(result < 0) {
//				result += 365;
//				nextYear++;
//			}
//			
//			//Again, because we are going forward at most 11 months, there will
//			//be at most one leap year.
//			if(traversedLeapYearWhileGoingForward(finalMonth, nextYear)) {
//				result++;
//			}
//		}
//		
//		return result;
//	}
//	
//	private int getDaysToSubtractForAdditionalMonths(Duration duration) {
//		//We assume that getDaysToSubtractForAdditional years would have compensated for
//		//duration.month >= 12.  That is duration.month / 12 was added to duration.years
//		//to compute the number of additional Julian days for additional years.  Thus,
//		//here we assume (though we have to compute it) we only compensate for 0 to 11
//		//additional months computed by duration.getMonths() % MONTHS_IN_YEAR.
//		int result = 0;
//		if(duration.getMonths() > 0) {
//			int earlierMonth = month - duration.getMonths() % MONTHS_IN_YEAR;
//			if(earlierMonth <= 0) {
//				earlierMonth += MONTHS_IN_YEAR;
//			}
//			
//			//By computing the additional months this way we don't need two arrays,
//			//one for DAYS_SINCE_JAN_1 going forward, and one going backward.
//			//This subtraction does NOT compensate for leap days.  That is done in
//			//the next step.
//			int newYear = year - duration.getYears() - duration.getMonths()/MONTHS_IN_YEAR;
//			result = DAYS_SINCE_JAN_1[month - 1] - DAYS_SINCE_JAN_1[earlierMonth - 1];
//			int earlierYear = newYear;
//			if(result < 0) {
//				result += 365;
//				earlierYear--;
//			}
//			if(earlierYear == 0) {
//				earlierYear--;
//			}
//
//			//Again, because we are going backward at most 11 months, there will
//			//be at most one leap year.
//			if(traversedLeapYearWhileGoingBackward(newYear, earlierMonth, earlierYear)) {
//				result++;
//			}
//		}
//		
//		return result;
//	}
//	
//	private boolean traversedLeapYearWhileGoingForward(int finalMonth, int nextYear) {
//		assert year <= nextYear;
//		
//		boolean result = false;
//		if(isLeapYear(year)) {
//			if(year == nextYear) {
//				result = month <= 2 && finalMonth >= 3;
//			} else {
//			    //Based on the pre-condition we can prove that year < nextYear.
//				//Thus the start date must occur in the first year.  We can only
//				//traverse Feb. 29 of the first Year (the leap year) if the start
//				//date is in Jan. or Feb. (of the first year)
//			    result = month <= 2;
//			}
//		} else if(isLeapYear(nextYear)) {
//			//If earlierYear = year then the previous branch (if(isLeapYear(year))
//			//would have handled the case when year == nextYear.  We need only
//			//consider when year < nextYear.
//			
//			//Based on the pre-condition we can prove that year < nextYear.
//			//Thus the start date must occur in the first year.  We can only
//			//traverse Feb. 29 of the next Year (the leap year) if the final
//			//date is after Feb. 29th (of the last year)
//			result = finalMonth >= 3;
//		}
//		return result;
//	}
//	
//	private boolean traversedLeapYearWhileGoingBackward(int newYear, int finalMonth, int earlierYear) {
//		assert earlierYear <= newYear;
//		
//		boolean result = false;
//
//		if(isLeapYear(newYear)) {
//			if(earlierYear == newYear) {
//				//True iff we go from after the leap day to before or equal to the leap day
//				//all in the same year (a leap year).
//				result = finalMonth <= 2 && month >= 3;
//			} else {
//				//Because of the pre-condition and earlierYear != year we know earlierYear < year.
//				//The result is true iff we go from any date in the start year after Feb. 29
//				//backwards past Feb. 29th to the final month which is in the earlier year.
//				result = month >= 3;
//			}
//		} else if(isLeapYear(earlierYear)) {
//			//If earlierYear = year we would have taken the previous branch (if(isLeapYear(Year)).
//			//Therefore we need only consider the case where earlierYear < year.
//			//The result is true iff we traverse Feb. 29 of the earlier year.  We start in the first year
//			//which is not a leap year so we can only traverse Feb. 29 if we go backwards through
//			//the start year, backwards through all the months after Feb of the earlier year and end in
//			//Jan. or Feb. of the earlierYear.
//			result = finalMonth <= 2;
//		}
//		
//		return result;
//	}
//
//	private int getNumberOfLeapDaysGoingForward(Duration duration) {
//		int lastYear = year + duration.getYears() + duration.getMonths() / MONTHS_IN_YEAR;
//		if(year < 0 && lastYear >= 0) {
//			lastYear++;
//		}
//		int numberOfLeap4Days = getNumberOfLeapDaysForLeapYearInterval(4, year, lastYear);
//		int numberOfLeap100Days = getNumberOfLeapDaysForLeapYearInterval(100, year, lastYear);
//		int numberOfLeap400Days = getNumberOfLeapDaysForLeapYearInterval(400, year, lastYear);
//		int numberOfLeapDays = numberOfLeap4Days - numberOfLeap100Days + numberOfLeap400Days;
//		if(year < 0 && lastYear > 0) {
//			numberOfLeapDays++;
//		}
//		
//		return numberOfLeapDays;
//	}
//	
//	private int getNumberOfLeapDaysGoingBackward(Duration duration) {
//		int earlierYear = year - duration.getYears() - duration.getMonths() / MONTHS_IN_YEAR;
//		if(year > 0 && earlierYear <= 0) {
//			earlierYear--;
//		}
//		int numberOfLeap4Days = getNumberOfLeapDaysForLeapYearInterval(4, earlierYear, year);
//		int numberOfLeap100Days = getNumberOfLeapDaysForLeapYearInterval(100, earlierYear, year);
//		int numberOfLeap400Days = getNumberOfLeapDaysForLeapYearInterval(400, earlierYear, year);
//		int numberOfLeapDays = numberOfLeap4Days - numberOfLeap100Days + numberOfLeap400Days;
//		if(year > 0 && earlierYear < 0) {
//			numberOfLeapDays++;
//		}
//		
//		return numberOfLeapDays;
//	}
//	
//	private int getNumberOfLeapDaysForLeapYearInterval(int leapYearInterval, int year1, int year2) {
//		int result = 0;
//		if(year1 < 0 && year2 > 0) {
//			result = getNumberOfLeapDays(leapYearInterval, year1, 0) +
//			         getNumberOfLeapDays(leapYearInterval, 1, year2);
//		} else {
//			result = getNumberOfLeapDays(leapYearInterval, year1, year2);
//		}
//		return result;
//	}
//	
//	/**
//	 * Computes the total number of leap days between year 1 and year 2.
//	 * @param leapYearInterval A value = 4, 100, or 400
//	 * @param year1 First year of the interval
//	 * @param year2 Second year of the interval
//	 * @pre (leapYearInterval = 4 OR leapYearInterval = 100 OR leapYearInterval = 400) AND
//	 *       year1 &lt; 0 &rArr; year2 &le; 0 AND year2 &gt; 0 &rArr; y1 &ge; 0
//	 */
//	private int getNumberOfLeapDays(int leapYearInterval, int year1, int year2) {
//		int adjustment = 1;
//		if(year1 < 0) {
//			adjustment = -1;
//		}
//		
//		int leapYears1 = year1 / leapYearInterval;
//		int leapYears2 = (year2 - adjustment) / leapYearInterval;
//		int result = leapYears2 - leapYears1;
//
//		if(year1 % leapYearInterval == 0) {
//			if(year1 > 0) {
//				result++;
//			} else {
//				result--;
//			}
//		}
//
//		return result;
//	}
	
	private int[] computeNewYearNewMonthNewDayIncrementBy(Duration duration) {
		return computeNewYearNewMonthNewDayIncrementBy(year, month, day, duration);
	}
		
	private static int[] computeNewYearNewMonthNewDayIncrementBy(int year, int month, int day, Duration duration) {
		//Compute newYear
		int newYear = year + duration.getYears() + duration.getMonths() / MONTHS_IN_YEAR;
		if(year < 0 && newYear >= 0) {
			newYear++;
		}
		
		//Partially compute newDay
		int newDay = day;
		//If this MonthDayYear represented Feb. 29th of a leap year
		//and the new year is not a leap year set the day to 28
		if(month == 2 && day == 29 && !isLeapYear(newYear)) {
			newDay = 28;
		}
		
		//Compute newMonth and adjust newYear if necessary
		int newMonth = month + duration.getMonths() % MONTHS_IN_YEAR;
		if(newMonth > MONTHS_IN_YEAR) {
			newMonth -= MONTHS_IN_YEAR;
			newYear++;
			if(newYear == 0) {
				newYear++;
			}
		}
		
		//Compute newDay
		newDay = computeNewDay(newYear, newMonth, newDay);
		
		int[] result = {newYear, newMonth, newDay};
		
		return result;
	}
	
	private int[] computeNewYearNewMonthNewDayDecrementBy(Duration duration) {
		return computeNewYearNewMonthNewDayDecrementBy(year, month, day, duration);
	}
		
	private static int[] computeNewYearNewMonthNewDayDecrementBy(int year, int month, int day, Duration duration) {
		//Process Years
		int newYear = year - duration.getYears() - duration.getMonths() / MONTHS_IN_YEAR;
		if(year > 0 && newYear <= 0) {
			newYear--;
		}
		
		//Partially compute newDay
		int newDay = day;
		//If this MonthDayYear represented Feb. 29th of a leap year
		//and the new year is not a leap year set the day to 28
		if(month == 2 && day == 29 && !isLeapYear(newYear)) {
			newDay = 28;
		}

		//Compute newMonth and adjust newYear if necessary
		int newMonth = month - duration.getMonths() % MONTHS_IN_YEAR;
		if(newMonth <= 0) {
			newMonth += MONTHS_IN_YEAR;
			newYear--;
			if(newYear == 0) {
				newYear--;
			}
		}
		
		//Compute newDay
		newDay = computeNewDay(newYear, newMonth, newDay);

		int[] result = {newYear, newMonth, newDay};
		
		return result;
	}

	private static int computeNewDay(int newYear, int newMonth, int newDay) {
		int daysInMonth = DAYS_IN_MONTH[newMonth - 1];
		if(newMonth == 2 && isLeapYear(newYear)) {
			daysInMonth++;
		}
		if(newDay > daysInMonth) {
			newDay = daysInMonth;
		}
		
		return newDay;
	}
	
//Invariants pre-conditions, and post-conditions
	private static boolean invariant(int year, int month, int day) {
		boolean result = year >= MIN_YEAR && year <= MAX_YEAR && year != 0
				         && month >= 1 && month <= 12
				         	 && (year != MIN_YEAR || month >= MIN_MONTH_OF_MIN_YEAR)
				             && (year != MAX_YEAR || month <= MAX_MONTH_OF_MAX_YEAR)
		                 && day >= 1
		                     && (!(month == 1  || month == 3 || month == 5 || month == 7 || month == 8 ||
		                      month == 10 || month == 12) || /* => */ day <= 31)
		                     && (!(month == 4 || month == 6 || month == 9 || month == 11) || /* => */ day <= 30)
		                     && (!isLeapYear(year) || month != 2 || /* => */ day <= 29)
		                     && (isLeapYear(year) || month != 2 || /* => */ day <= 28)
		                     && (year != MIN_YEAR || month != MIN_MONTH_OF_MIN_YEAR || day >= MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR)
		                     && (year != MAX_YEAR || month != MAX_MONTH_OF_MAX_YEAR || day <= MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR);
	    return result;
	}
	
	private boolean invariant() {
		boolean result = invariant(year, month, day);
		
	    return result;
	}
	
	//YearMonthDay pre-condition, requirement, and post-condition
	public static boolean YearMonthDay_Precondition() {
		boolean result = true;
		
		return result;
	}
	
	private static boolean YearMonthDay_Requirements() {
		boolean result = YearMonthDay_Precondition();
		
		return result;
	}
	
	private boolean YearMonthDay_Postcondition() {
		boolean result = year == MIN_YEAR &&
		                 month == MIN_MONTH_OF_MIN_YEAR &&
		                 day == MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR;
		
		return result;
	}
	
	//YearMonthDayYearMonthDay pre-condition, requirement, and post-condition
	public static boolean YearMonthDayYearMonthDay_Precondition(YearMonthDay yearMonthDay) {
		boolean result = yearMonthDay != null;
		
		return result;
	}
	
	private static boolean YearMonthDayYearMonthDay_Requirements(YearMonthDay yearMonthDay) {
		boolean result = YearMonthDayYearMonthDay_Precondition(yearMonthDay);
		
		return result;
	}
	
	private boolean YearMonthDayYearMonthDay_Postcondition(YearMonthDay yearMonthDay) {
		boolean result = year == yearMonthDay.year &&
		                 month == yearMonthDay.month &&
		                 day == yearMonthDay.day;
		
		return result;
	}
	
	
	//YearMonthDayIntIntInt pre-condition, requirement, and post-condition
	public static boolean yearMonthDayIntIntInt_Precondition(int year, int month, int day) {
		boolean result = invariant(year, month, day);
		
		return result;
	}
	
	private static boolean yearMonthDayIntIntInt_Requirements(int year, int month, int day) {
		boolean result = YearMonthDay.yearMonthDayIntIntInt_Precondition(year, month, day);
		
		return result;
	}
	
	private static boolean yearMonthDayIntIntInt_Postcondition(int year, int month, int day) {
		boolean result = true;
		
		return result;
	}
	
	//equalsYearMonthDay pre-condition, requirement, and post-condition
	public boolean equalsYearMonthDay_Precondition(YearMonthDay yearMonthDay) {
		boolean result = yearMonthDay != null;
		
		return result;
	}
	
	private boolean equalsYearMonthDay_Requirements(YearMonthDay yearMonthDay) {
		boolean result = equalsYearMonthDay_Precondition(yearMonthDay);
		
		return result;
	}
	
	private boolean equalsYearMonthDay_Postcondition(YearMonthDay yearMonthDay, boolean result) {
		boolean expectedResult = yearMonthDay.year == year &&
				                 yearMonthDay.month == month &&
				                 yearMonthDay.day == day;
		boolean response = result == expectedResult;
		return response;
	}
	
	//lessThanOrEqualYearMonthDay pre-condition, requirement, and post-condition
	public boolean lessThanOrEqualToYearMonthDay_Precondition(YearMonthDay yearMonthDay) {
		boolean result = yearMonthDay != null;
		
		return result;
	}
	
	private boolean lessThanOrEqualToYearMonthDay_Requirements(YearMonthDay yearMonthDay) {
		boolean result = lessThanOrEqualToYearMonthDay_Precondition(yearMonthDay);
		
		return result;
	}
	
	private boolean lessThanOrEqualToYearMonthDay_Postcondition(YearMonthDay ymd, boolean result) {
		boolean expectedResult = (year < ymd.year) ||
				                  ((year == ymd.year) &&
						           (month < ymd.month ||
						            (month == ymd.month &&
						             day <= ymd.day
						            )
						           )
						          );
		boolean response = result == expectedResult;
		return response;
	}
	
	//isLeapYearInt pre-condition, requirement, and post-condition
	public static boolean isLeapYearInt_Precondition(int year) {
		boolean result = year != 0        &&
				         year >= MIN_YEAR &&
				         year <= MAX_YEAR;
		
		return result;
	}
	
	private static boolean isLeapYearInt_Requirements(int year) {
		boolean result = YearMonthDay.isLeapYearInt_Precondition(year);
		
		return result;
	}
	
	private static boolean isLeapYearInt_Postcondition(int year, boolean result) {
		boolean expectedResult = 
		    (year <= 0 || (((year % 4) == 0) && ((year % 100) != 0 || (year % 400 == 0))))
		    &&
		    (year >= 0 || ((-year - 1) == 0 || ((((-year - 1) % 4) == 0) && (((-year - 1) % 100) != 0 || ((-year - 1) % 400 == 0)))));
		boolean response = result == expectedResult;
		return response;
	}
	
	//getLastDayOfIntInt pre-condition, requirement, and post-condition
	public static boolean getLastDayOfIntInt_Precondition(int month, int year) {
		boolean result = year >= MIN_YEAR && year <= MAX_YEAR && year != 0 &&
				month >= 1 && month <= 12                                  &&
		        (year != MIN_YEAR || month >= MIN_MONTH_OF_MIN_YEAR)       &&
		        (year != MAX_YEAR || month <= MAX_MONTH_OF_MAX_YEAR);
		
		return result;
	}
	
	private static boolean getLastDayOfIntInt_Requirements(int month, int year) {
		boolean result = YearMonthDay.getLastDayOfIntInt_Precondition(month, year);
		
		return result;
	}
	
	private static boolean getLastDayOfIntInt_Postcondition(int month, int year, int result) {
		int expectedResult = 0;
		if(year == MAX_YEAR && month == MAX_MONTH_OF_MAX_YEAR) {
			expectedResult = MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR;
		} else {
			switch(month) {
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					expectedResult = 31;
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					expectedResult = 30;
					break;
				case 2:
					if(isLeapYear(year)) {
						expectedResult = 29;
					} else {
						expectedResult = 28;
					}
					break;
			    default:
			    	expectedResult = -1;
			}
		}
		    
		boolean response = result == expectedResult;
		return response;
	}
	
	//getYear pre-condition, requirement, and post-condition
	public boolean getYear_Precondition() {
		boolean result = true;
		
		return result;
	}
	
	private boolean getYear_Requirements() {
		boolean result = getYear_Precondition();
		
		return result;
	}
	
	private boolean getYear_Postcondition(int result) {
		boolean response = result == year;
		return response;
	}
	
	//getMonth pre-condition, requirement, and post-condition
	public boolean getMonth_Precondition() {
		boolean result = true;
		
		return result;
	}
	
	private boolean getMonth_Requirements() {
		boolean result = getMonth_Precondition();
		
		return result;
	}
	
	private boolean getMonth_Postcondition(int result) {
		boolean response = result == month;
		return response;
	}
	
	//getDay pre-condition, requirement, and post-condition
	public boolean getDay_Precondition() {
		boolean result = true;
		
		return result;
	}
	
	private boolean getDay_Requirements() {
		boolean result = getDay_Precondition();
		
		return result;
	}
	
	private boolean getDay_Postcondition(int result) {
		boolean response = result == day;
		return response;
	}
	
	//getJulianDay pre-condition, requirement, and post-condition
	public boolean getJulianDay_Precondition() {
		boolean  result = true;

		return result;
	}
	
	private boolean getJulianDay_Requirements() {
		boolean result = getJulianDay_Precondition();
		
		return result;
	}
	
	private boolean getJulianDay_Postcondition(int result) {
		int expectedResult = day - 32075 +
					 1461 * ((year < 0 ? year + 1 : year) + 4800 + (month - 14)/12)/4 +
					 367 * (month - 2 - (month - 14)/12 * 12)/12 -
					 3 * (((year < 0 ? year + 1 : year) + 4900 + (month - 14)/12)/100)/4;
				
		boolean response = expectedResult == result;
		return response;
	}
	
	//toYMD pre-condition, requirement, and post-condition
	public static boolean toYMD_Precondition(int julianDay) {
		boolean  result = julianDay >= MIN_JULIAN_DAY && julianDay <= MAX_JULIAN_DAY;

		return result;
	}
	
	private static boolean toYMD_Requirements(int julianDay) {
		boolean result = YearMonthDay.toYMD_Precondition(julianDay);
		
		return result;
	}
	
	private static boolean toYMD_Postcondition(int julianDay, YearMonthDay result) {
		int expectedJulianDay = result.getJulianDay();
				
		boolean response = expectedJulianDay == julianDay;
		return response;
	}
	
	//toString pre-condition, requirement, and post-condition
	public boolean toString_Precondition() {
		boolean  result = true;

		return result;
	}
	
	private boolean toString_Requirements() {
		boolean result = toString_Precondition();
		
		return result;
	}
	
	private boolean toString_Postcondition(String result) {
		String expectedResult = year + "/" + month + "/" + day;
				
		boolean response = expectedResult.equals(result);
		return response;
	}
	
	//increaseBy pre-condition, requirement, and post-condition
	private static int year_prime;
	private static int month_prime;
	private static int day_prime;
	
	public boolean increaseBy_Precondition(Duration duration) {
		int[] newDate = computeNewYearNewMonthNewDayIncrementBy(year, month, day, duration);
		
		boolean result = invariant(newDate[0], newDate[1], newDate[2]);
		if(result) {
			int julianDay = getJulianDay(newDate[0], newDate[1], newDate[2]) + duration.getDays();
			result = toYMD_Precondition(julianDay);
		}
		
		return result;
	}
	
	private boolean increaseBy_Requirements1(Duration duration) {
		year_prime = year;
		month_prime = month;
		day_prime = day;
		
		boolean result = duration != null;
		
		return result;
	}
	
	private boolean increaseBy_Requirements2(int year, int month, int day, Duration duration) {
		boolean result = invariant(year, month, day);
		if(result) {
			int julianDay = getJulianDay(year, month, day);
			julianDay += duration.getDays();
			result = toYMD_Precondition(julianDay);
		}
		
		return result;
	}
	
	private boolean increaseBy_Postcondition(Duration duration, YearMonthDay result) {
		int newYear = year_prime + duration.getYears() + duration.getMonths()/MONTHS_IN_YEAR;
		newYear += year_prime < 0 && newYear >= 0 ? 1 : 0;
		int newMonth = month_prime + (duration.getMonths() % MONTHS_IN_YEAR);
		newYear = (newMonth > MONTHS_IN_YEAR ? (newYear + 1 == 0 ? newYear + 2 : newYear + 1) : newYear);
		newMonth = (newMonth > MONTHS_IN_YEAR) ? newMonth - MONTHS_IN_YEAR : newMonth;
		int newDay = day_prime - (month_prime == 2 && day_prime == 29 && !isLeapYear(newYear) ? 1 : 0);
		int daysInMonth = DAYS_IN_MONTH[newMonth - 1] + (newMonth == 2 && isLeapYear(newYear) ? 1 : 0);
		newDay = newDay > daysInMonth ? daysInMonth : newDay;
		YearMonthDay expectedResult = toYMD(getJulianDay(newYear, newMonth, newDay) + duration.getDays());

		boolean response = expectedResult.equals(result);
		return response;
	}
	
	//decreaseBy pre-condition, requirement, and post-condition
	public boolean decreaseBy_Precondition(Duration duration) {
		int[] newDate = computeNewYearNewMonthNewDayDecrementBy(year, month, day, duration);
		
		boolean result = invariant(newDate[0], newDate[1], newDate[2]);
		if(result) {
			int julianDay = getJulianDay(newDate[0], newDate[1], newDate[2]) - duration.getDays();
			result = toYMD_Precondition(julianDay);
		}
		
		return result;
	}
	
	private boolean decreaseBy_Requirements1(Duration duration) {
		year_prime = year;
		month_prime = month;
		day_prime = day;
		
		boolean result = duration != null;
		
		return result;
	}
	
	private boolean decreaseBy_Requirements2(int year, int month, int day, Duration duration) {
		boolean result = invariant(year, month, day);
		if(result) {
			int julianDay = getJulianDay(year, month, day);
			julianDay -= duration.getDays();
			result = toYMD_Precondition(julianDay);
		}
		
		return result;
	}
	
	private boolean decreaseBy_Postcondition(Duration duration , YearMonthDay result) {
		int newYear = year_prime - duration.getYears() - duration.getMonths()/MONTHS_IN_YEAR;
		newYear -= year_prime > 0 && newYear <= 0 ? 1 : 0;
		int newMonth = month_prime - (duration.getMonths() % MONTHS_IN_YEAR);
		newYear = (newMonth <= 0 ? (newYear - 1 == 0 ? newYear - 2 : newYear - 1) : newYear);
		newMonth = (newMonth <= 0) ? newMonth + MONTHS_IN_YEAR : newMonth;
		int newDay = day_prime - (month_prime == 2 && day_prime == 29 && !isLeapYear(newYear) ? 1 : 0);
		int daysInMonth = DAYS_IN_MONTH[newMonth - 1] + (newMonth == 2 && isLeapYear(newYear) ? 1 : 0);
		newDay = newDay > daysInMonth ? daysInMonth : newDay;
		
		YearMonthDay expectedResult = toYMD(getJulianDay(newYear, newMonth, newDay) - duration.getDays());

		boolean response = result.equals(expectedResult);

		return response;
	}
	
	public static void main(String[] args) {
		int almostTooBigYear = 4813;
		int almostTooBigMonth = 1;
		int almostTooBigDay = 5;
		YearMonthDay ymd = new YearMonthDay(100, 12, 31);

		
			try {
					Duration duration =
						new Duration(almostTooBigYear,
								     almostTooBigMonth,
								     almostTooBigDay);
					ymd.decreaseBy(duration);
			} catch(AssertionError e) {
				System.out.println("Last Year = " + almostTooBigYear);
				System.out.println("Last Month = " + almostTooBigMonth);
				System.out.println("Last Day = " + almostTooBigDay);
			}

	}
}
