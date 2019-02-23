package DateComparison.support;

//import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.fail;

/**
 * A DateRange is a range of days from a minJulianDay to a maxJulianDay.
 * Julian Days are non-negative integers where 1 equals November 25, 4714 BC in the proleptic Gregorian calendar
 * 
 * The range of days is represented by a minJulianDay and maxJulianDay, both Julian days, where minJulianDay &le; maxJulianDay.
 * If the minJulianDay = maxJulianDay then that DateRange represents a single Julian day.
 *
 * <pre>
 * Each day in a range is &ge; the minJulianDay of the range AND &le; maxJulianDay of the range.
 * <b>Domain:</b>
 *     minJulianDay int
 *     maxJulianDay int
 *     
 *     <b>Invariant</b>: 1 &le; minJulianDay &le; maxJulianDay
 * </pre>
 * 
 * To understand the semantics of the equals operation we must first understand the notion of range associated with a
 * DateRange. This notion is represented by the DateRange function int getRange(DateRange dateRange) which returns the value
 * this.maxJulianDay - this.minJulianDay + 1 for the target DateRange. Thus the range of any DateRange is &ge; 1.
 * 
 * Two date ranges are considered equal iff their corresponding minJulianDays and maxJulianDays are equal.
 * 
 * In the following informal definitions we use minRange(a, b) =  a.range <= b.range ? a : b; and
 * maxRange(a, b) = a.range > b.range ? a : b;
 * 
 * <pre>
 *	double sameAs(DateRange b)
 *			result = percent of minDateRange(this, b) that overlaps maxDateRange(this, b)
 *
 *If durations.length == 1 then the minJulianDate of this and b have been decreased by durations[0] and
 *                              the maxJulianDate of this and b have been increased by durations[0] 
 *before computing the result of sameAs(b)
 * 
 * We support the following properties 
 * 		1. sameAs(a, b) = sameAs(b, a)

 * </pre>
 * 
 * Each of these operations can have the range of the maxDateRange extended by an optional duration amount
 * 
 * A duration can also be used to define a DateRange.  There can be zero, one, or two durations used in a constructor.
 * Zero durations means the YearMonthDay is defined as specified.  If there is one duration then the minDateRange is adjusted
 * down by that duration and the maxDateRange is adjusted up by that same duration.  If there are two durations then the
 * minDateRange is adjusted down by the first duration and the maxDateRange is adjusted up by the second Duration.
 * 
 * The use of two durations is designed to allow us to define date ranges representing "after a given date" and
 * "before a given date".
 * 
 * @author Scott Woodfield
 *
 */
public class DateRange {
//Domain Implementation
	private int minJulianDay;
	private int maxJulianDay;
	
//Constructors
	//Default Constructor
	/**
	 * Default Constructor
	 * @pre None
	 * @post minJulianDay = 1 AND maxJulianDay = 1
	 */
	public DateRange() {
		assert DateRange_Requirements();
		
		minJulianDay = 1;
		maxJulianDay = 1;
		
		minYMD = YearMonthDay.toYMD(1);
		maxYMD = YearMonthDay.toYMD(1);
			
		range = 1; //maxJulianDay - minJulianDay + 1
		assert DateRange_Postcondition() && invariant();
	}
	
	//Copy Constructor
	/**
	 * The copy constructor
	 * @param dateRange the DateRange we will copy from
	 * 
	 * @pre dateRange &ne; null
	 * @post this.minJulianDay = dateRange.minJulianDay AND this.maxJulianDay = dateRange.maxJulianDay AND range = dateRange.range
	 */
	public DateRange(DateRange dateRange) {
		assert DateRangeDateRange_Requirements(dateRange);
		
		minJulianDay = dateRange.minJulianDay;
		maxJulianDay = dateRange.maxJulianDay;
		minYMD = dateRange.minYMD;
		maxYMD = dateRange.maxYMD;
		
		range = dateRange.range;
		
		assert DateRangeDateRange_Postcondition(dateRange) && invariant();
	}
	
	//Normal Constructors
	/**
	 * The constructor for a single year
	 * @param year  the new year range
	 * @param durations the durations to adjust the min and max year by
	 * @pre YearMonthDay.YearMonthDayIntIntInt_Precondition(
	 *          year,
	 *          year == YearMonthDay.MIN_YEAR ? YearMonthDay.MIN_MONTH_OF_MIN_YEAR : YearMonthDay.JANUARY,
	 *          year == YearMonthDay.MIN_YEAR ? YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR : YearMonthDay.FIRST_DAY_OF_ANY_MONTH)
	 *      AND
	 *      YearMonthDay.YearMonthDayIntIntInt_Precondition(
	 *          year,
	 *          year == YearMonthDay.MAX_YEAR ? YearMonthDay.MAX_MONTH_OF_MAX_YEAR : YearMonthDay.DECEMBER,
	 *          year == YearMonthDay.MAX_YEAR ? YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR : YearMonthDay.LAST_DAY_OF_DECEMBER)
	 *      AND
	 *      |durations| = 1 &rArr; new YearMonthDay(year,
	 *						 		  			    year == YearMonthDay.MIN_YEAR ?
	 *						 		  					    YearMonthDay.MIN_MONTH_OF_MIN_YEAR :
	 *						 		  					    YearMonthDay.JANUARY,
	 *						 		  			    year == YearMonthDay.MIN_YEAR ?
	 *						 		  					    YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR :
	 *						 		  					    YearMonthDay.FIRST_DAY_OF_ANY_MONTH).decreaseBy_Precondition(durations[0])
	 *							   AND
	 *      					   new YearMonthDay(year,
	 *						 		  			    year == YearMonthDay.MAX_YEAR ?
	 *						 		  					    YearMonthDay.MAX_MONTH_OF_MAX_YEAR :
	 *						 		  					    YearMonthDay.DECEMBER,
	 *						 		  			    year == YearMonthDay.MAX_YEAR ?
	 *						 		  					    YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR :
	 *						 		  					    YearMonthDay.LAST_DAY_OF_DECEMBER).increaseBy_Precondition(durations[0])
	 *	    AND
	 *	    |durations| = 2 &rArr; new YearMonthDay(year,
	 *						 		  			    year == YearMonthDay.MIN_YEAR ?
	 *						 		  					    YearMonthDay.MIN_MONTH_OF_MIN_YEAR :
	 *						 		  					    YearMonthDay.JANUARY,
	 *						 		  			    year == YearMonthDay.MIN_YEAR ?
	 *						 		  					    YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR :
	 *						 		  					    YearMonthDay.FIRST_DAY_OF_ANY_MONTH).decreaseBy_Precondition(durations[0])
	 *							   AND
	 *      					   new YearMonthDay(year,
	 *						 		  			    year == YearMonthDay.MAX_YEAR ?
	 *						 		  					    YearMonthDay.MAX_MONTH_OF_MAX_YEAR :
	 *						 		  					    YearMonthDay.DECEMBER,
	 *						 		  			    year == YearMonthDay.MAX_YEAR ?
	 *						 		  					    YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR :
	 *						 		  					    YearMonthDay.LAST_DAY_OF_DECEMBER).increaseBy_Precondition(durations[1])
	 *@req pre
	 *@post
	 *		|durations| = 0 &rArr;
	 *			(year == 0 &rArr; minJulianDay == new YearMonthDay(YearMonthDay.MIN_YEAR,
	 *                                                             YearMonthDay.MIN_MONTH_OF_MIN_YEAR,
	 *                                                             YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR).getJulianDay()
	 *                                                            ).getJulianDay()
	 *                            AND
	 *                            maxJulianDay == new YearMonthDay(YearMonthDay.MAX_YEAR,
	 *                                                             YearMonthDay.MAX_MONTH_OF_MAX_YEAR,
	 *                                                             YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR).getJulianDay()
	 *                                                            ).getJulianDay()
	 *          )
	 *          AND
	 *          (year != 0 &rArr; minJulianDay == new YearMonthDay(year,
	 *                                                             year == MIN_YEAR ? YearMonthDay.MIN_MONTH_OF_MIN_YEAR :
	 *                                                                                YearMonthDay.JANUARY,
	 *                                                             year == MIN_YEAR ? YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR :
	 *                                                                                YearMonthDay.FIRST_DAY_OF_ANY_MONTH
	 *                                                            ).getJulianDay()
	 *                           AND
	 *                           maxJulianDay == new YearMonthDay(year,
	 *                                                            year == MAX_YEAR ? YearMonthDay.MAX_MONTH_OF_MAX_YEAR :
	 *                                                                               YearMonthDay.DECEMBER,
	 *                                                            year == MAX_YEAR ? YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR :
	 *                                                                               YearMonthDay.LAST_DAY_OF_DECEMBER
	 *                                                           ).getJulianDay()
	 *          )
	 *      AND
	 *      |durations| = 1 &rArr;
	 *         	(year == 0 &rArr; minJulianDay == new YearMonthDay(YearMonthDay.MIN_YEAR,
	 *                                                             YearMonthDay.MIN_MONTH_OF_MIN_YEAR,
	 *                                                             YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR).getJulianDay()
	 *                                                            ).decreaseBy(durations[0]).getJulianDay()
	 *                            AND
	 *                            maxJulianDay == new YearMonthDay(YearMonthDay.MAX_YEAR,
	 *                                                             YearMonthDay.MAX_MONTH_OF_MAX_YEAR,
	 *                                                             YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR).getJulianDay()
	 *                                                            ).increaseBy(durations[0]).getJulianDay()
	 *          )
	 *          AND
	 *          (year != 0 &rArr; minJulianDay == new YearMonthDay(year,
	 *                                                             year == MIN_YEAR ? YearMonthDay.MIN_MONTH_OF_MIN_YEAR :
	 *                                                                                YearMonthDay.JANUARY,
	 *                                                             year == MIN_YEAR ? YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR :
	 *                                                                                YearMonthDay.LAST_DAY_OF_ANY_MONTH
	 *                                                            ).decreaseBy(durations[0].getJulianDay()
	 *                           AND
	 *                           maxJulianDay == new YearMonthDay(year,
	 *                                                            year == MAX_YEAR ? YearMonthDay.MAX_MONTH_OF_MAX_YEAR :
	 *                                                                               YearMonthDay.DECEMBER,
	 *                                                            year == MAX_YEAR ? YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR :
	 *                                                                               YearMonthDay.LAST_DAY_OF_DECEMBER
	 *                                                           ).increaseBy(durations[0].getJulianDay()
	 *          )
	 *      AND
	 *      |durations| = 2 &rArr;
	 *         	(year == 0 &rArr; minJulianDay == new YearMonthDay(YearMonthDay.MIN_YEAR,
	 *                                                             YearMonthDay.MIN_MONTH_OF_MIN_YEAR,
	 *                                                             YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR).getJulianDay()
	 *                                                            ).decreaseBy(durations[0]).getJulianDay()
	 *                            AND
	 *                            maxJulianDay == new YearMonthDay(YearMonthDay.MAX_YEAR,
	 *                                                             YearMonthDay.MAX_MONTH_OF_MAX_YEAR,
	 *                                                             YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR).getJulianDay()
	 *                                                            ).increaseBy(durations[0]).getJulianDay()
	 *          )
	 *          AND
	 *          (year != 0 &rArr; minJulianDay == new YearMonthDay(year,
	 *                                                             year == MIN_YEAR ? YearMonthDay.MIN_MONTH_OF_MIN_YEAR :
	 *                                                                                YearMonthDay.JANUARY,
	 *                                                             year == MIN_YEAR ? YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR :
	 *                                                                                YearMonthDay.LAST_DAY_OF_ANY_MONTH
	 *                                                            ).decreaseBy(durations[1].getJulianDay()
	 *                           AND
	 *                           maxJulianDay == new YearMonthDay(year,
	 *                                                            year == MAX_YEAR ? YearMonthDay.MAX_MONTH_OF_MAX_YEAR :
	 *                                                                               YearMonthDay.DECEMBER,
	 *                                                            year == MAX_YEAR ? YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR :
	 *                                                                               YearMonthDay.LAST_DAY_OF_DECEMBER
	 *                                                           ).increaseBy(durations[1].getJulianDay()
	 *          )
	 */
	public DateRange(int year, Duration... durations) {
		assert DateRangeIntDuration_Requirements(year, durations);
		int beginningMonth =
			year == 0 || year == YearMonthDay.MIN_YEAR ? YearMonthDay.MIN_MONTH_OF_MIN_YEAR : YearMonthDay.JANUARY;
		int beginningDay   =
			year == 0 || year == YearMonthDay.MIN_YEAR ? YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR :
				                                         YearMonthDay.FIRST_DAY_OF_ANY_MONTH;
		int endMonth = 
			year == 0 || year == YearMonthDay.MAX_YEAR ? YearMonthDay.MAX_MONTH_OF_MAX_YEAR : YearMonthDay.DECEMBER;
		int endDay   =
			year == 0 || year == YearMonthDay.MAX_YEAR ? YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR :
				                                         YearMonthDay.LAST_DAY_OF_DECEMBER;
		createDateRange(new YearMonthDay(year, beginningMonth, beginningDay),
						new YearMonthDay(year, endMonth, endDay),
			            durations);
		assert DateRangeIntDuration_Postcondition(year, durations);
	}
	
	/*
	 * @pre
	 * 		YearMonthDay.YearMonthDayIntIntInt_Precondition(
	 *          year,
	 *          month
	 *          year == YearMonthDay.MIN_YEAR  && month == MIN_MONTH_IN_MIN_YEAR ?
	 *                  YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR            :
	 *                  YearMonthDay.FIRST_DAY_OF_ANY_MONTH)
	 *      AND
	 *      YearMonthDay.YearMonthDayIntIntInt_Precondition(year, month, YearMonthDay.getLastDayOf(year, month)
	 *      AND
	 *      |durations| = 1 &rArr;
	 *      	new YearMonthDay(year,
	 *             			     month,
	           					 year == YearMonthDay.MIN_YEAR  && month == MIN_MONTH_IN_MIN_YEAR ?
	 *                  	                 YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR            :
	 *                  					 YearMonthDay.FIRST_DAY_OF_ANY_MONTH).decreaseBy_Precondition(durations[0])
	 *     		new YearMonthDay(year,
	 *						 	 month,
	 *         					 YearMonthDay.getLastDayOf(year, month)).increaseBy_Precondition(durations[0])
	 *	    AND
	 *	    |durations| = 2 &rArr;
	 *			new YearMonthDay(year,
	 *						 	 month,
	 *        					 year == YearMonthDay.MIN_YEAR  && month == MIN_MONTH_IN_MIN_YEAR ?
	 *                  	                 YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR            :
	 *                  					 YearMonthDay.FIRST_DAY_OF_ANY_MONTH).decreaseBy_Precondition(durations[0])
	 *			AND
	 *      	new YearMonthDay(year,
	 *						 	 month,
	 *						 	 YearMonthDay.getLastDayOf(year, month)).increaseBy_Precondition(durations[1])
	 */
	public DateRange(int year, int month, Duration... durations) {
		assert DateRangeIntIntDuration_Requirements(year, month, durations);
		
		int newMinYear = year == 0  || year == YearMonthDay.MIN_YEAR ? YearMonthDay.MIN_YEAR : year;
		int newMinMonth = year == 0 || year == YearMonthDay.MIN_YEAR ? YearMonthDay.MIN_MONTH_OF_MIN_YEAR :
			                                                           (month == 0 ? YearMonthDay.JANUARY : month);
		int newMinDay =  year == 0 || year == YearMonthDay.MIN_YEAR ? YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR :
            														  YearMonthDay.FIRST_DAY_OF_ANY_MONTH;
	
		int newMaxYear = year == 0  || year == YearMonthDay.MAX_YEAR ? YearMonthDay.MAX_YEAR : year;
		int newMaxMonth = year == 0 || year == YearMonthDay.MAX_YEAR ? YearMonthDay.MAX_MONTH_OF_MAX_YEAR :
			                                                           (month == 0 ? YearMonthDay.DECEMBER : month);
		int newMaxDay =  year == 0 || year == YearMonthDay.MAX_YEAR ? YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR :
            														  (month == 0 ? YearMonthDay.DECEMBER :
            															            YearMonthDay.getLastDayOf(month, year)
            														  );

		createDateRange(new YearMonthDay(newMinYear, newMinMonth, newMinDay),
						new YearMonthDay(newMaxYear, newMaxMonth, newMaxDay),
			            durations);
		assert DateRangeIntIntDuration_Postcondition(year, month, durations);
	}
	
	/*
	 * @pre
	 * 		YearMonthDay.YearMonthDayIntIntInt_Precondition(year, month, day)
	 *      AND
	 *      |durations| = 1 &rArr; new YearMonthDay(year, month, day).decreaseBy_Precondition(durations[0]) AND
	 *      					   new YearMonthDay(year, month, day).increaseBy_Precondition(durations[0])
	 *	    AND
	 *	    |durations| = 2 &rArr; new YearMonthDay(year, month, day).decreaseBy_Precondition(durations[0]) AND
	 *      					   new YearMonthDay(year, month, day).increaseBy_Precondition(durations[1])
	 */
	public DateRange(int year, int month, int day,  Duration... durations) {
		assert DateRangeIntIntIntDuration_Requirements(year, month, day, durations);
		
		int newMinYear = year == 0  || year == YearMonthDay.MIN_YEAR ? YearMonthDay.MIN_YEAR : year;
		int newMinMonth = year == 0 || year == YearMonthDay.MIN_YEAR ? YearMonthDay.MIN_MONTH_OF_MIN_YEAR :
			                                                           (month == 0 ? YearMonthDay.JANUARY : month);
		int newMinDay =  year == 0 || year == YearMonthDay.MIN_YEAR ? YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR :
            														  (month == 0 ? YearMonthDay.FIRST_DAY_OF_ANY_MONTH :
            															            (day == 0 ? YearMonthDay.FIRST_DAY_OF_ANY_MONTH :
            															            	        day
            															            )
            														  );
	
		int newMaxYear = year == 0  || year == YearMonthDay.MAX_YEAR ? YearMonthDay.MAX_YEAR : year;
		int newMaxMonth = year == 0 || year == YearMonthDay.MAX_YEAR ? YearMonthDay.MAX_MONTH_OF_MAX_YEAR :
			                                                           (month == 0 ? YearMonthDay.DECEMBER : month);
		int newMaxDay =  year == 0 || year == YearMonthDay.MAX_YEAR ? YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR :
            														  (month == 0 ? YearMonthDay.LAST_DAY_OF_DECEMBER :
            															            (day == 0 ? YearMonthDay.getLastDayOf(month, year) :
            															            	        day
            															            )
            														  );
		createDateRange(new YearMonthDay(newMinYear, newMinMonth, newMinDay),
			            new YearMonthDay(newMaxYear, newMaxMonth, newMaxDay),
			            durations);
		assert DateRangeIntIntIntDuration_Postcondition(year, month, day, durations);
	}
	
	/*
	 * @pre
	 * 		beginningYear &ne; 0 AND 
	 * 		YearMonthDay.YearMonthDayIntIntInt_Precondition(beginningYear, beginningMonth, beginningDay)
	 * 		AND
	 * 		YearMonthDay.YearMonthDayIntIntInt_Precondition(endYear, endMonth, endDay)
	 *      AND
	 *      |durations| = 1 &rArr;
	 *      	new YearMonthDay(beginningYear, beginningMonth, beginningDay).decreaseBy_Precondition(durations[0]) AND
	 *      	new YearMonthDay(endYear, endMonth, endDay).increaseBy_Precondition(durations[0])
	 *	    AND
	 *	    |durations| = 2 &rArr;
	 *			new YearMonthDay(beginningYear, beginningMonth, beginningDay).decreaseBy_Precondition(durations[0]) AND
	 *      					   new YearMonthDay(endYear, endMonth, endDay).increaseBy_Precondition(durations[1])
	 */
	public DateRange(int beginningYear, int beginningMonth, int beginningDay,
			         int endYear,       int endMonth,       int endDay,
			         Duration... durations)
	{
		assert DateRangeIntIntIntIntIntIntDuration_Requirements(beginningYear, beginningMonth, beginningDay,
																endYear,       endMonth,       endDay,
																durations);
		YearMonthDay beginningYearMonthDay =
			new YearMonthDay(beginningYear == 0 ? YearMonthDay.MIN_YEAR : beginningYear,
					         beginningYear == 0 ? YearMonthDay.MIN_MONTH_OF_MIN_YEAR :
					        	                  (beginningMonth == 0 ? YearMonthDay.JANUARY :
					        	                                         beginningMonth
					        	                  ),
					         beginningYear == 0 ? YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR :
					        		              (beginningMonth == 0 ? YearMonthDay.FIRST_DAY_OF_ANY_MONTH :
					        		            	                     (beginningDay == 0 ?
					        		            	                          YearMonthDay.FIRST_DAY_OF_ANY_MONTH :
					        		            	                          beginningDay
					        		            	                     )
					        		              )
					        );
		YearMonthDay endYearMonthDay =
			new YearMonthDay(endYear == 0 ? YearMonthDay.MAX_YEAR : endYear,
				             endYear == 0 ? YearMonthDay.MAX_MONTH_OF_MAX_YEAR :
				        	                (endMonth == 0 ? YearMonthDay.DECEMBER :
				        	                                 endMonth
				        	                ),
				             endYear == 0 ? YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR :
				        		            (endMonth == 0 ? YearMonthDay.LAST_DAY_OF_DECEMBER :
				        		            	             (endDay == 0 ?
				        		            	                  YearMonthDay.getLastDayOf(endMonth, endYear) :
				        		            	                  endDay
				        		            	             )
				        		            )
				            );
		createDateRange(beginningYearMonthDay, endYearMonthDay, durations);

		
		assert DateRangeIntIntIntIntIntIntDuration_Postcondition(beginningYear, beginningMonth, beginningDay,
																 endYear,       endMonth,       endDay,
																 durations);
	}


//Queries
	/**
	 * The minJulianDay getter
	 * @pre None
	 * @post result = minJulianDay
	 */
	public int getMinJulianDay() {
		assert getMinJulianDay_Requirements();
		int result = minJulianDay;
		assert getMinJulianDay_Postcondition(result);
		return result;
	}
	
	/**
	 * The maxJulianDay getter
	 * @pre None
	 * @post result = maxJulianDay
	 */
	public int getMaxJulianDay() {
		return maxJulianDay;
	}
	
	/**
	 * The minYearMonthDay getter
	 * @pre None
	 * @post result = minYearMonthDay
	 */
	public YearMonthDay getMinYearMonthDay(){
		assert getMinYearMonthDay_Requirements();
		
		YearMonthDay result = minYMD;
		
		assert getMinYearMonthDay_Postcondition(result);
		return result;
	}
	
	/*
	 * The maxYearMonthDay getter
	 * @pre None
	 * @post result = maxYearMonthDay
	 */
	public YearMonthDay getMaxYearMonthDay() {
		assert getMaxYearMonthDay_Requirements();
		
		YearMonthDay result = maxYMD;
		
		assert getMaxYearMonthDay_Postcondition(result);
		return result;
	}
	
	/**
	 * The range getter
	 * @pre None
	 * @post result = range
	 */
	public int getRange() {
		assert getRange_Requirements();
		
		int result = range;
		
		assert getRange_Postcondition(result);
		return result;
	}
	
	/**
	 * Compare two date ranges to see how much they overlap
	 * @param dateRange the date range we will compare to
	 * @param durations the accuracy adjustment
	 * @pre dateRange != null AND
	 *      durations.length &le; 1 AND
	 *      if durations.length = 1 then
	 *          decreasing the minJulianDay of both this and dateRange does produces a valid minJulianDay respectively AND
	 *          increasing the maxJulianDay of both this and dateRange does produces a valid minJulianDay respectively
	 * @req pre
	 * @post
	 *     minYearMonthDay.equals(maxYearMonthDay) &rArr; result = 1.0d; 								AND
	 *     this.getRange() < dateRange.getRange() &rArr;
	 *         (
	 *     	    (duration.length = 0 &rArr;
	 *     			(getMaxJulianDay() < dateRange.getMinJulianDay() &rArr; result = 0 			 AND
	 *               getMinJulianDay() > dateRange.getMaxJulianDay() &rArr; result = 0 			 AND
	 *               (getMinJulianDay() > dateRange.getMinJulianDay() AND 
	 *                getMaxJulianDay() < dateRange.getMaxJulianDay()
	 *               ) &rArr; result = 1.0d                                                      AND
	 *               getMaxJulianDay() < dateRange.getMaxJulianDay() &rArr;
	 *                   result = (getMaxJulianDay() - dateRange.getMinJulianDay() + 1) /range;  AND
	 *               getMaxJulianDay() > dateRange.getMaxJulianDay() &rArr;
	 *                   result = (dateRange.getMaxJulianDay() - getMinJulianDay() + 1) /range;
	 *             )
	 *          )	
	 *     		AND
	 *     		(duration.length = 1 &rArr;
	 *              getMinYearMonthDay().decreaseBy_Precondition(durations[0])                AND
	 *              getMaxYearMonthDay().increaseBy_Precondition(duration[0])                 AND
	 *              dateRange.getMinYearMonthDay().decreaseBy_Precondition(duration[0])       AND
	 *              dateRange.getMaxYearMonthDay().increaseBy_Precondition(duration[0])       AND
	 *              
	 *              (getMinJulianDay() > dateRange.getMinJulianDay() AND 
	 *               getMaxJulianDay() < dateRange.getMaxJulianDay()
	 *              ) &rArr; result = 1.0d
	 *                                                                                        AND
	 *              (getMaxJulianDay() < dateRange.getMaxJulianDay() &rArr;
	 *                   result = (getMaxYearMonthDay().increaseBy(duration).getJulianDay() -
	 *                             dateRange.getMinYearMonthsDay().decreaseBy(duration).getJulianDay + 1
	 *                            ) / range;
	 *               AND
	 *               getMaxJulianDay() > dateRange.getMaxJulianDay() &rArr;
	 *                   result = (dateRange.getMaxYearMonthDay().increaseBy(duration).getJulianDay() - 
	 *                             getMinYearMonthDay().decreaseBy(duration).getJulianDay() + 1) /range;
	 *              )
	 *     		)																						AND
	 *     this.getRange() >  dateRange.getRange() &rArr;
	 *         (
	 *     	    (duration.length = 0 &rArr;
	 *     			(dateRange.getMaxJulianDay() < getMinJulianDay() &rArr; result = 0 			 AND
	 *               dateRange.getMinJulianDay() > getMaxJulianDay() &rArr; result = 0 			 AND
	 *               (dateRange.getMinJulianDay() > getMinJulianDay() AND 
	 *                dateRange.getMaxJulianDay() < getMaxJulianDay()
	 *               ) &rArr; result = 1.0d                                                      AND
	 *               dateRange.getMaxJulianDay() < getMaxJulianDay() &rArr;
	 *                   result = (dateRange.getMaxJulianDay() - getMinJulianDay() + 1) /range;  AND
	 *               dateRange.getMaxJulianDay() > getMaxJulianDay() &rArr;
	 *                   result = (getMaxJulianDay() - dateRange.getMinJulianDay() + 1) /range;
	 *             )
	 *          )	
	 *     		AND
	 *     		(duration.length = 1 &rArr;
	 *              getMinYearMonthDay().decreaseBy_Precondition(durations[0])                AND
	 *              getMaxYearMonthDay().increaseBy_Precondition(duration[0])                 AND
	 *              dateRange.getMinYearMonthDay().decreaseBy_Precondition(duration[0])       AND
	 *              dateRange.getMaxYearMonthDay().increaseBy_Precondition(duration[0])       AND
	 *              
	 *              (dateRange.getMinJulianDay() > getMinJulianDay() AND 
	 *               dateRange.getMaxJulianDay() < getMaxJulianDay()
	 *              ) &rArr; result = 1.0d
	 *                                                                                        AND
	 *              (dateRange.getMaxJulianDay() < getMaxJulianDay() &rArr;
	 *                   result = (dateRange.getMaxYearMonthDay().increaseBy(duration).getJulianDay() -
	 *                             getMinYearMonthsDay().decreaseBy(duration).getJulianDay + 1
	 *                            ) / range;
	 *               AND
	 *               getMaxJulianDay() > dateRange.getMaxJulianDay() &rArr;
	 *                   result = (getMaxYearMonthDay().increaseBy(duration).getJulianDay() - 
	 *                             dateRange.getMinYearMonthDay().decreaseBy(duration).getJulianDay() + 1) /range;
	 *              )
	 *     		)
	 */
	public double sameAs(DateRange dateRange, Duration... durations) {
		assert sameAs_Requirements(dateRange, durations);
		
		DateRange minRange;
		DateRange maxRange;
		if(this.range <= dateRange.range) {
			minRange = this;
			maxRange = dateRange;
		} else {
			minRange = dateRange;
			maxRange = this;
		}
		
		Duration duration = durations.length == 0 ? null : durations[0];
		double result = intersectionSize(minRange, maxRange, duration)/minRange.range;
		
		assert sameAs_Postcondition(durations, result);

		return result;
	}
	
	/**
	 * Determines the probability this not being the same as dateRange adjusted for accuracy (represented by the duration)
	 * If there is a duration, there is only one.  We write the method signature this was so we don't have to a second method
	 * for this method when there is no accuracy adjustment.
	 * @param dateRange the date range to compare to
	 * @param duration the amount of accuracy adjustment to be made to both this and the dateRange
	 * @pre dateRange != null AND
	 *      durations.length &le; 1 AND
	 *      if durations.length = 1 then
	 *          decreasing the minJulianDay of both this and dateRange does produces a valid minJulianDay respectively AND
	 *          increasing the maxJulianDay of both this and dateRange does produces a valid minJulianDay respectively
	 * @req pre
	 * @post
	 *     result = duration.length = 0 &rArr; result = 1.0d - sameAs(dateRange) AND
	 *     result = duration.length = 1 &rArr; result = 1.0d - sameAs(dateRange, duration[0])
	 */
	public double notSameAs(DateRange dateRange, Duration... duration) {
		assert notSameAsDateRangeDuration_Requirements(dateRange, duration);
		
		double result = 0.0d;
		if(duration.length == 0) {
			result = 1.0d - sameAs(dateRange);
		} else {
			result = 1.0d - sameAs(dateRange, duration);
		}
		
		assert notSameAsDateRangeDuration_Postcondition(duration, result);
		return result;
	}
	
	/**
	 * The toString method for the DateRange
	 * @pre None
	 * @req pre
	 * @post result = "(" + minYMD + "; " + maxYMD + "; range = " + range + ")";
	 */
	public String toString() {
		assert toString_Requirements();
		
		String result = "(" + minYMD + "; " + maxYMD + "; range = " + range + ")";
		
		assert toString_Postcondition(result);
		return result;
	}
	
	/**
	 * Compares this.dateRange and dateRange for equality
	 * @pre dateRange &ne; null
	 * @req pre
	 * @post result = (minJulianDay = dateRange.minJulianDay) AND
	 *                (maxJulianDay = dateRange.maxJulianDay);
	 */
	public boolean equals(DateRange dateRange) {
		assert equalsDateRange_Requirements(dateRange);
		
		boolean result = minJulianDay == dateRange.minJulianDay && maxJulianDay == dateRange.maxJulianDay;
			
		assert equalsDateRange_Postcondition(dateRange, result);
		return result;
	}

//Commands
	
//Constants and support methods
	private YearMonthDay minYMD;
	private YearMonthDay maxYMD;
	private int range;
	
	private static double intersectionSize(DateRange smallRange, DateRange largeRange, Duration duration) {
		double result = 0.0;
		
		DateRange smallerRange = new DateRange(smallRange);
		DateRange largerRange = new DateRange(largeRange);
		
		if(smallerRange.minJulianDay < largerRange.minJulianDay) {
			int largerRangeMinJulianDay = largerRange.minJulianDay;
			if(duration != null) {
				YearMonthDay largerRangeMinYMD = new YearMonthDay(largerRange.minYMD);
				largerRangeMinYMD.decreaseBy(duration);
			    largerRangeMinJulianDay = largerRangeMinYMD.getJulianDay();
			}
			if(smallerRange.maxJulianDay >= largerRangeMinJulianDay) {
				result = (double)(Math.min(smallerRange.range, smallerRange.maxJulianDay - largerRangeMinJulianDay + 1));
			}
		} else if(smallerRange.maxJulianDay > largerRange.maxJulianDay){
			int largerRangeMaxJulianDay = largerRange.maxJulianDay;
			if(duration != null) {
				YearMonthDay largerRangeMaxYMD = new YearMonthDay(smallerRange.maxYMD);
				largerRangeMaxYMD.increaseBy(duration);
				largerRangeMaxJulianDay = largerRangeMaxYMD.getJulianDay();
			}
			if(smallerRange.minJulianDay <= largerRange.maxJulianDay) {
				result = (double)(Math.min(smallerRange.range, largerRangeMaxJulianDay - smallerRange.minJulianDay + 1));
			}
		} else {
			result = smallerRange.range;
		}
		
		return result;
	}
	
	/**
	 *We view a date range as the number of days in mathematical range r = [start date .. end date].
	 *This range is inclusive of the start date and end date.  Since it is inclusive
	 *|r| = end date - start date + 1. Thus the range from a date to itself is 1. 
	 *
	 * 
	 * @param minYMD The start date
	 * @param maxYMD The end date
	 * @param durations This is optional. The amount of time to be subtracted from the start date
	 *  and added to the end date before computing the range. There can be 0, 1, or
	 *  2 durations.  If there are none, no adjustments are made to the start and end dates.  If there is one
	 *  duration it is subtracted from the start date and added to the end date.  If there are two durations then
	 *  the first is subtracted from the start date and the second is added to the end date.
	 */
	private void createDateRange(YearMonthDay minYMD, YearMonthDay maxYMD, Duration[] durations) {
		assert minYMD != null && maxYMD != null && durations.length < 3 &&
			   (!(durations.length > 0) || durations[0] != null) && (!(durations.length == 2) || durations[1] != null);
		assert minYMD.lessThanOrEqualTo(maxYMD);
		assert invariant();
		
		this.minYMD = minYMD;
		this.maxYMD = maxYMD;
		
		adjustForDurations(durations);

		minJulianDay = this.minYMD.getJulianDay();
		maxJulianDay = this.maxYMD.getJulianDay();
		
		range = maxJulianDay - minJulianDay + 1;
	}
		
	private void adjustForDurations(Duration[] durations) {
		assert durations != null;

		if(durations.length == 1) {
			this.minYMD.decreaseBy(durations[0]);
			this.maxYMD.increaseBy(durations[0]);
		} else if(durations.length == 2) {
			this.minYMD.decreaseBy(durations[0]);
			this.maxYMD.increaseBy(durations[1]);
		}
	}
	
//Invariants, pre-conditions and post-conditions
	private boolean invariant() {
		return 0 <= minJulianDay && minJulianDay <= maxJulianDay;
	}
	
	//Pre-condition, Requirements, and Post-condition for DateRange()
	public static boolean DateRange_Precondition() {
		return true;
	}
	
	public boolean DateRange_Requirements() {
		return DateRange.DateRange_Precondition();
	}
	
	public boolean DateRange_Postcondition() {
		boolean result = minJulianDay == 1 && maxJulianDay == 1;
		
		return result;
	}
	
	//Pre-condition, Requirements, and Post-condition for DateRange(DateRange dateRange)
	public static boolean DateRangeDateRange_Precondition(DateRange dateRange) {
		return dateRange != null;
	}
	
	public boolean DateRangeDateRange_Requirements(DateRange dateRange) {
		return DateRange.DateRangeDateRange_Precondition(dateRange);
	}
	
	public boolean DateRangeDateRange_Postcondition(DateRange dateRange) {
		boolean result = minJulianDay == dateRange.minJulianDay &&
				         maxJulianDay == dateRange.maxJulianDay &&
				         getRange() == dateRange.getRange();
		
		return result;
	}

	//Pre-condition, Requirements, and Post-condition for DateRange(int year, Duration... durations)
	public static boolean DateRangeIntDuration_Precondition(int year, Duration... durations) {
		int minMonth = 
			year == YearMonthDay.MIN_YEAR ? YearMonthDay.MIN_MONTH_OF_MIN_YEAR : YearMonthDay.JANUARY;
		int minDay   =
		    year == YearMonthDay.MIN_YEAR ? YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR : YearMonthDay.FIRST_DAY_OF_ANY_MONTH;
		int maxMonth =
			year == YearMonthDay.MAX_YEAR ? YearMonthDay.MAX_MONTH_OF_MAX_YEAR : YearMonthDay.DECEMBER;
		int maxDay   =
			year == YearMonthDay.MAX_YEAR ? YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR : YearMonthDay.LAST_DAY_OF_DECEMBER;	
				 
		if(!YearMonthDay.yearMonthDayIntIntInt_Precondition(year, minMonth, minDay)) return false;
		if(!YearMonthDay.yearMonthDayIntIntInt_Precondition(year, maxMonth, maxDay)) return false;


		YearMonthDay minYearMonthDay = new YearMonthDay(year, minMonth, minDay);
		YearMonthDay maxYearMonthDay = new YearMonthDay(year, maxMonth, maxDay);

		if(durations == null || durations.length > 2)return false;
		
		boolean durationsPrecondition =
			(durations.length != 1 || (durations[0] != null &&
			                           minYearMonthDay.decreaseBy_Precondition(durations[0]) &&
			                           maxYearMonthDay.increaseBy_Precondition(durations[0])
			                          )
			)
			&&
			(durations.length != 2 || (durations[0] != null &&
					                   durations[0] != null &&
					                   minYearMonthDay.decreaseBy_Precondition(durations[0]) &&
					                   maxYearMonthDay.increaseBy_Precondition(durations[1])
					                  )
			);
		
		return durationsPrecondition;
	}
	
	public boolean DateRangeIntDuration_Requirements(int year, Duration[] durations) {
		boolean result = false;
		
		if(durations == null || durations.length > 2) return false;
		

		if(durations.length == 0) {
			result = DateRange.DateRangeIntDuration_Precondition(year);
		} else if(durations.length == 1) {
			result = DateRange.DateRangeIntDuration_Precondition(year, durations[0]);
		} else if(durations.length == 2) {
			result = DateRange.DateRangeIntDuration_Precondition(year, durations[0], durations[1]);
		}
		
		return result;
	}
	
	public boolean DateRangeIntDuration_Postcondition(int year, Duration[] durations) {
		int minYear  = year == 0 ? YearMonthDay.MIN_YEAR : year;
		int minMonth = year == 0 || year == YearMonthDay.MIN_YEAR ? YearMonthDay.MIN_MONTH_OF_MIN_YEAR : YearMonthDay.JANUARY;
		int minDay   = year == 0 || year == YearMonthDay.MIN_YEAR ? YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR :
																	YearMonthDay.FIRST_DAY_OF_ANY_MONTH;
		
		int maxYear  = year == 0 ? YearMonthDay.MAX_YEAR : year;
		int maxMonth = year == 0 || year == YearMonthDay.MAX_YEAR ? YearMonthDay.MAX_MONTH_OF_MAX_YEAR : YearMonthDay.DECEMBER;
		int maxDay   = year == 0 || year == YearMonthDay.MAX_YEAR  ? YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR :
																	 YearMonthDay.LAST_DAY_OF_DECEMBER;
		
		boolean result = false;
		YearMonthDay minYMD = null;
		YearMonthDay maxYMD = null;
		if(durations.length == 0) {
			minYMD = new YearMonthDay(minYear, minMonth, minDay);
			maxYMD = new YearMonthDay(maxYear, maxMonth, maxDay);
		} else {
			minYMD = new YearMonthDay(minYear, minMonth, minDay);
			minYMD.decreaseBy(durations[0]);
			maxYMD = new YearMonthDay(maxYear, maxMonth, maxDay);
			if(durations.length == 1) {
				maxYMD.increaseBy(durations[0]);
			} else if(durations.length == 2) {
				maxYMD.increaseBy(durations[1]);
			}

		}
		
		result = minYMD.getJulianDay() == minJulianDay &&
				 maxYMD.getJulianDay() == maxJulianDay;
		
		return result;
	}
	
	//Pre-condition, Requirements, and Post-condition for DateRange(int year, int month, Duration... durations)
	public static boolean DateRangeIntIntDuration_Precondition(int year, int month, Duration... durations) {
		int minDay   =
		    year == YearMonthDay.MIN_YEAR ? YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR : YearMonthDay.FIRST_DAY_OF_ANY_MONTH;
		int maxDay   =
			year == YearMonthDay.MAX_YEAR ? YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR : YearMonthDay.getLastDayOf(month, year);	
				 
		if(!YearMonthDay.yearMonthDayIntIntInt_Precondition(year, month, minDay)) return false;
		if(!YearMonthDay.yearMonthDayIntIntInt_Precondition(year, month, maxDay)) return false;

		YearMonthDay minYearMonthDay = new YearMonthDay(year, month, minDay);
		YearMonthDay maxYearMonthDay = new YearMonthDay(year, month, maxDay);
		
		if(durations == null || durations.length > 2)return false;
		
		boolean durationsPrecondition =
			(durations.length != 1 || (durations[0] != null &&
			                           minYearMonthDay.decreaseBy_Precondition(durations[0]) &&
			                           maxYearMonthDay.increaseBy_Precondition(durations[0])
			                          )
			)
			&&
			(durations.length != 2 || (durations[0] != null &&
					                   durations[1] != null &&
					                   minYearMonthDay.decreaseBy_Precondition(durations[0]) &&
				                       maxYearMonthDay.increaseBy_Precondition(durations[1])
				                      )
			);
		
		return durationsPrecondition;
	}
	
	public boolean DateRangeIntIntDuration_Requirements(int year, int month, Duration[] durations) {
		boolean result = false;
		
		if(durations == null || durations.length > 2) return false;
		
		if(durations.length == 0) {
			result = DateRange.DateRangeIntIntDuration_Precondition(year, month);
		} else if(durations.length == 1) {
			result = DateRange.DateRangeIntIntDuration_Precondition(year, month, durations[0]);
		} else if(durations.length == 2) {
			result = DateRange.DateRangeIntIntDuration_Precondition(year, month, durations[0], durations[1]);
		}
		
		return result;
	}
	
	public boolean DateRangeIntIntDuration_Postcondition(int year, int month, Duration[] durations) {
		int minYear  = year == 0 ? YearMonthDay.MIN_YEAR : year;
		int minMonth = year == 0 || year == YearMonthDay.MIN_YEAR? YearMonthDay.MIN_MONTH_OF_MIN_YEAR :
			                       								   (month == 0 ? YearMonthDay.JANUARY : month);
		int minDay   = year == 0 || year == YearMonthDay.MIN_YEAR ? YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR :
																	YearMonthDay.FIRST_DAY_OF_ANY_MONTH;
		
		int maxYear  = year == 0 ? YearMonthDay.MAX_YEAR : year;
		int maxMonth = year == 0 || year == YearMonthDay.MAX_YEAR ? YearMonthDay.MAX_MONTH_OF_MAX_YEAR :
																	(month == 0 ? YearMonthDay.DECEMBER : month);
		int maxDay   = year == 0 || year == YearMonthDay.MAX_YEAR  ? YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR :
																	 (month == 0 ? YearMonthDay.LAST_DAY_OF_DECEMBER :
																		           YearMonthDay.getLastDayOf(maxMonth, maxYear)
																     );
		boolean result = false;
		YearMonthDay minYMD = null;
		YearMonthDay maxYMD = null;
		if(durations.length == 0) {
			minYMD = new YearMonthDay(minYear, minMonth, minDay);
			maxYMD = new YearMonthDay(maxYear, maxMonth, maxDay);
		} else {
			minYMD = new YearMonthDay(minYear, minMonth, minDay);
			minYMD.decreaseBy(durations[0]);
			maxYMD = new YearMonthDay(maxYear, maxMonth, maxDay);
			if(durations.length == 1) {
				maxYMD.increaseBy(durations[0]);
			} else if(durations.length == 2) {
				maxYMD.increaseBy(durations[1]);
			}

		}
		
		result = minYMD.getJulianDay() == minJulianDay &&
				 maxYMD.getJulianDay() == maxJulianDay;
		
		return result;
	}
	
	//Pre-condition, Requirements, and Post-condition for DateRange(int year, int month, int day, Duration... durations)
	public static boolean DateRangeIntIntIntDuration_Precondition(int year, int month, int day, Duration... durations) {
		if(!YearMonthDay.yearMonthDayIntIntInt_Precondition(year, month, day)) return false;
		if(!YearMonthDay.yearMonthDayIntIntInt_Precondition(year, month, day)) return false;


		YearMonthDay minYearMonthDay = new YearMonthDay(year, month, day);
		YearMonthDay maxYearMonthDay = new YearMonthDay(year, month, day);
		
		if(durations == null || durations.length > 2)return false;
		
		boolean durationsPrecondition =
			(durations.length != 1 || (durations[0] != null &&
			                           minYearMonthDay.decreaseBy_Precondition(durations[0]) &&
			                           maxYearMonthDay.increaseBy_Precondition(durations[0])
			                          )
			)
			&&
			(durations.length != 2 || (durations[0] != null &&
			                           durations[1] != null &&
			                           minYearMonthDay.decreaseBy_Precondition(durations[0]) &&
				                       maxYearMonthDay.increaseBy_Precondition(durations[1])
				                      )
			);
		
		return durationsPrecondition;
	}
	
	public boolean DateRangeIntIntIntDuration_Requirements(int year, int month, int day, Duration[] durations) {
		boolean result = false;
		
		if(durations == null || durations.length > 2) return false;
		
		if(durations.length == 0) {
			result = DateRange.DateRangeIntIntIntDuration_Precondition(year, month, day);
		} else if(durations.length == 1) {
			result = DateRange.DateRangeIntIntIntDuration_Precondition(year, month, day, durations[0]);
		} else if(durations.length == 2) {
			result = DateRange.DateRangeIntIntIntDuration_Precondition(year, month, day, durations[0], durations[1]);
		}
		
		return result;
	}
	
	public boolean DateRangeIntIntIntDuration_Postcondition(int year, int month, int day, Duration[] durations) {
		int minYear  = year == 0 ? YearMonthDay.MIN_YEAR : year;
		int minMonth = year == 0 || year == YearMonthDay.MIN_YEAR? YearMonthDay.MIN_MONTH_OF_MIN_YEAR :
			                       								   (month == 0 ? YearMonthDay.JANUARY : month);
		int minDay   = year == 0 || year == YearMonthDay.MIN_YEAR ? YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR :
																	(month == 0 ? YearMonthDay.FIRST_DAY_OF_ANY_MONTH :
																		          (day == 0 ? YearMonthDay.FIRST_DAY_OF_ANY_MONTH :
																		        	          day
																		          )
																    );
		
		int maxYear  = year == 0 ? YearMonthDay.MAX_YEAR : year;
		int maxMonth = year == 0 || year == YearMonthDay.MAX_YEAR ? YearMonthDay.MAX_MONTH_OF_MAX_YEAR :
																	(month == 0 ? YearMonthDay.DECEMBER : month);
		int maxDay   = year == 0 || year == YearMonthDay.MAX_YEAR  ? YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR :
																	 (month == 0 ? YearMonthDay.LAST_DAY_OF_DECEMBER :
																		           (day == 0 ?
																		                YearMonthDay.getLastDayOf(maxMonth, maxYear) :
																		                day
																		           )
																     );
		boolean result = false;
		YearMonthDay minYMD = null;
		YearMonthDay maxYMD = null;
		if(durations.length == 0) {
			minYMD = new YearMonthDay(minYear, minMonth, minDay);
			maxYMD = new YearMonthDay(maxYear, maxMonth, maxDay);
		} else {
			minYMD = new YearMonthDay(minYear, minMonth, minDay);
			minYMD.decreaseBy(durations[0]);
			maxYMD = new YearMonthDay(maxYear, maxMonth, maxDay);
			if(durations.length == 1) {
				maxYMD.increaseBy(durations[0]);
			} else if(durations.length == 2) {
				maxYMD.increaseBy(durations[1]);
			}

		}
		
		result = minYMD.getJulianDay() == minJulianDay &&
				 maxYMD.getJulianDay() == maxJulianDay;
		
		return result;
	}

	//Pre-condition, Requirements, and Post-condition for DateRange(int beginningYear, int beginningMonth, int beginningDay,
	//                                                              int endYear,       int endMonth,       int endDay,
	//                                                              Duration... durations)
	public static boolean DateRangeIntIntIntIntIntIntDuration_Precondition(int firstYear, int firstMonth, int firstDay,
			                                                               int finalYear, int finalMonth, int finalDay,
			                                                               Duration... durations)
	{
		if(firstYear == 0 && firstMonth != 0) return false;
		if(firstMonth == 0 && firstDay != 0) return false;
		if(finalYear == 0 && finalMonth != 0) return false;
		if(finalMonth == 0 && finalDay != 0) return false;
		
		int beginningYear  = firstYear == 0 ? YearMonthDay.MIN_YEAR : firstYear;
		int beginningMonth = firstYear == 0 ? YearMonthDay.MIN_MONTH_OF_MIN_YEAR :
			                                  (firstMonth == 0 ? YearMonthDay.JANUARY :
			                                	                 firstMonth
			                                  );
		int beginningDay   = firstYear == 0 ? YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR :
			                                  (firstMonth == 0 ? YearMonthDay.FIRST_DAY_OF_ANY_MONTH :
			                                	                 (firstDay == 0 ? YearMonthDay.FIRST_DAY_OF_ANY_MONTH :
			                                	                	              firstDay
			                                	                 )
			                                  );

		int endYear  = finalYear == 0 ? YearMonthDay.MAX_YEAR : finalYear;
		int endMonth = finalYear == 0 ? YearMonthDay.MAX_MONTH_OF_MAX_YEAR :
			                            (finalMonth == 0 ? YearMonthDay.DECEMBER :
			                            	               finalMonth
			                            );

		int endDay   = finalYear == 0 ? YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR :
			                            (finalMonth == 0 ? YearMonthDay.LAST_DAY_OF_DECEMBER :
			                            	               (finalDay == 0 ? YearMonthDay.getLastDayOf(finalMonth, finalYear) :
			                            	            	                finalDay
			                            	               )
			                            );

		if(!YearMonthDay.yearMonthDayIntIntInt_Precondition(beginningYear, beginningMonth, beginningDay)) return false;
		if(!YearMonthDay.yearMonthDayIntIntInt_Precondition(endYear, endMonth, endDay)) return false;

		YearMonthDay beginningYearMonthDay = new YearMonthDay(beginningYear, beginningMonth, beginningDay);
		YearMonthDay endYearMonthDay = new YearMonthDay(endYear, endMonth, endDay);
	
		if(durations == null || durations.length > 2)return false;
		
		boolean durationsPrecondition =
			(durations.length != 1 || (durations[0] != null && 
			                           beginningYearMonthDay.decreaseBy_Precondition(durations[0]) &&
			                           endYearMonthDay.increaseBy_Precondition(durations[0])
			                          )
			)
			&&
			(durations.length != 2 || (durations[0] != null &&
			                           durations[1] != null &&
			                           beginningYearMonthDay.decreaseBy_Precondition(durations[0]) &&
				                       endYearMonthDay.increaseBy_Precondition(durations[1])
				                      )
		    );
		
		return durationsPrecondition;
	}
	
	private boolean DateRangeIntIntIntIntIntIntDuration_Requirements(int beginningYear, int beginningMonth, int beginningDay,
            												 		 int endYear,       int endMonth,       int endDay,
            												 		 Duration[] durations)
	{
		boolean result = false;
		
		if(durations == null || durations.length > 2) return false;
		
		if(durations.length == 0) {
			result = DateRange.DateRangeIntIntIntIntIntIntDuration_Precondition(beginningYear, beginningMonth, beginningDay,
				                                                                endYear,       endMonth,       endDay);
		} else if(durations.length == 1) {
			result = DateRange.DateRangeIntIntIntIntIntIntDuration_Precondition(beginningYear, beginningMonth, beginningDay,
														   				        endYear,       endMonth,       endDay,
														   				        durations[0]);
		} else if(durations.length == 2) {
			result =  DateRange.DateRangeIntIntIntIntIntIntDuration_Precondition(beginningYear, beginningMonth, beginningDay,
 				                                                                 endYear,       endMonth,       endDay,
 				                                                                 durations[0], durations[1]);
		}
		
		return result;
	}
	
	private boolean DateRangeIntIntIntIntIntIntDuration_Postcondition(int firstYear, int firstMonth, int firstDay,
            														  int lastYear,  int lastMonth,  int lastDay,
            														  Duration[] durations)
	{
		if(firstYear == 0 && firstMonth != 0) return false;
		if(firstMonth == 0 && firstDay != 0) return false;
		if(lastYear == 0 && lastMonth != 0) return false;
		if(lastMonth == 0 && lastDay != 0) return false;
		
		int beginningYear  = firstYear == 0 ? YearMonthDay.MIN_YEAR : firstYear;
		int beginningMonth = firstYear == 0 ? YearMonthDay.MIN_MONTH_OF_MIN_YEAR :
			                                  (firstMonth == 0 ? YearMonthDay.JANUARY :
			                                	                 firstMonth
			                                  );
		int beginningDay   = firstYear == 0 ? YearMonthDay.MIN_DAY_OF_MIN_MONTH_OF_MIN_YEAR :
			                                  (firstMonth == 0 ? YearMonthDay.FIRST_DAY_OF_ANY_MONTH :
			                                	                 (firstDay == 0 ? YearMonthDay.FIRST_DAY_OF_ANY_MONTH :
			                                	                	              firstDay
			                                	                 )
			                                  );

		int endYear  = lastYear == 0 ? YearMonthDay.MAX_YEAR : lastYear;
		int endMonth = lastYear == 0 ? YearMonthDay.MAX_MONTH_OF_MAX_YEAR :
			                            (lastMonth == 0 ? YearMonthDay.DECEMBER :
			                            	               lastMonth
			                            );

		int endDay   = lastYear == 0 ? YearMonthDay.MAX_DAY_OF_MAX_MONTH_OF_MAX_YEAR :
			                            (lastMonth == 0 ? YearMonthDay.LAST_DAY_OF_DECEMBER :
			                            	               (lastDay == 0 ? YearMonthDay.getLastDayOf(lastMonth, lastYear) :
			                            	            	                lastDay
			                            	               )
			                            );

		YearMonthDay beginningYMD = new YearMonthDay(beginningYear, beginningMonth, beginningDay);
		if(durations.length >= 1) {
			beginningYMD.decreaseBy(durations[0]);
		}
		
		YearMonthDay endYMD = new YearMonthDay(endYear, endMonth, endDay);
		if(durations.length == 1) {
			endYMD.increaseBy(durations[0]);
		} else if(durations.length == 2) {
			endYMD.increaseBy(durations[1]);
		}
		
		boolean result = beginningYMD.getJulianDay() == minJulianDay &&
				         endYMD.getJulianDay()       == maxJulianDay;
		
		return result;
	}
	
	//Pre-condition, Requirements, and Post-condition for getMinJulianDay()
	public static boolean getMinJulianDay_Precondition() {
		return true;
	}
	
	public boolean getMinJulianDay_Requirements( ) {
		return DateRange.getMinJulianDay_Precondition();
	}
	
	public boolean getMinJulianDay_Postcondition(int result) {
		boolean response = result == minJulianDay;
		return response;
	}

	//Pre-condition, Requirements, and Post-condition for getMaxJulianDay()
	public static boolean getMaxJulianDay_Precondition() {
		return true;
	}
	
	public boolean getMaxJulianDay_Requirements( ) {
		return DateRange.getMaxJulianDay_Precondition();
	}
	
	public boolean getMaxJulianDay_Postcondition(int result) {
		boolean response = result == maxJulianDay;
		return response;
	}
	
	//Pre-condition, Requirements, and Post-condition for getMinYearMonthDay()
	public static boolean getMinYearMonthDay_Precondition() {
		return true;
	}
	
	public boolean getMinYearMonthDay_Requirements( ) {
		return DateRange.getMinYearMonthDay_Precondition();
	}
	
	public boolean getMinYearMonthDay_Postcondition(YearMonthDay result) {
		boolean response = result.equals(minYMD);
		return response;
	}
	
	//Pre-condition, Requirements, and Post-condition for getMaxYearMonthDay()
	public static boolean getMaxYearMonthDay_Precondition() {
		return true;
	}
	
	public boolean getMaxYearMonthDay_Requirements( ) {
		return DateRange.getMaxYearMonthDay_Precondition();
	}
	
	public boolean getMaxYearMonthDay_Postcondition(YearMonthDay result) {
		boolean response = result.equals(maxYMD);
		return response;
	}
	
	//Pre-condition, Requirements, and Post-condition for getRange()
	public static boolean getRange_Precondition() {
		return true;
	}
	
	public boolean getRange_Requirements( ) {
		return DateRange.getRange_Precondition();
	}
	
	public boolean getRange_Postcondition(int result) {
		boolean response = result == range;
		return response;
	}
	
	//Pre-condition, Requirements, and Post-condition for sameAs(DateRange, Duration...)
	private static DateRange thisPrime = null;
	private static DateRange dateRangePrime = null;
	public boolean sameAs_Precondition(DateRange dateRange, Duration... durations) {
		return dateRange != null && durations.length <= 1;
	}
	
	public boolean sameAs_Requirements(DateRange dateRange, Duration[] durations) {
		boolean result = false;
		if(durations.length == 0) {
			result = sameAs_Precondition(dateRange);
		} else if(durations.length == 1) {
			result = sameAs_Precondition(dateRange, durations[0]);
		}
		
		if(result) {
			thisPrime = new DateRange(this);
			dateRangePrime = new DateRange(dateRange);
		}
		
		return result;
	}
	
	public boolean sameAs_Postcondition(Duration[] durations, double result) {
		if(thisPrime.equals(dateRangePrime))return result == 1.0d;
		
		DateRange littleDateRange = thisPrime;
		DateRange bigDateRange = dateRangePrime;

		if(thisPrime.range  > dateRangePrime.range) {
			littleDateRange = dateRangePrime;
			bigDateRange = thisPrime;
		}
		
	    if(durations.length == 1) {
	        if(littleDateRange.getMinYearMonthDay().decreaseBy_Precondition(durations[0])                                      &&
	           littleDateRange.getMaxYearMonthDay().increaseBy_Precondition(durations[0])                                      &&
	           bigDateRange.getMinYearMonthDay().decreaseBy_Precondition(durations[0])                                         &&
	           bigDateRange.getMaxYearMonthDay().increaseBy_Precondition(durations[0]))
	        {

		       littleDateRange.getMinYearMonthDay().decreaseBy(durations[0]);
		       littleDateRange.getMaxYearMonthDay().increaseBy(durations[0]);
		       bigDateRange.getMinYearMonthDay().decreaseBy(durations[0]);
		       bigDateRange.getMaxYearMonthDay().increaseBy(durations[0]);
	        } else {
	        	return false;
	        }
	    }

	    //Checking the the result is 1.0 when the little and bigDateRanges are equal is checked on the first line.
	    boolean littleDateRangeCompletelySmallerThanBigDateRange = littleDateRange.getMaxJulianDay() < bigDateRange.getMinJulianDay();
	    boolean littleDateRangeCompletelyLargerThanBigDateRange = littleDateRange.getMinJulianDay() > bigDateRange.getMaxJulianDay();
	    boolean littleDateRangeIsContainedByTheLargerDateRange = littleDateRange.getMinJulianDay() >= bigDateRange.getMinJulianDay() &&
	    	                                                     littleDateRange.getMaxJulianDay() <= bigDateRange.getMaxJulianDay();
	    boolean littleDateRangeOverlapsTheLowerBoundOfTheLargerDateRangeOnly =
	    		    littleDateRange.getMinJulianDay() < bigDateRange.getMinJulianDay() &&
	    		    littleDateRange.getMaxJulianDay() <= bigDateRange.getMaxJulianDay();
	    boolean littleDateRangeOverlapsTheUpperBoundOftheLargerDateRangeOnly = 
    		    	littleDateRange.getMaxJulianDay() > bigDateRange.getMaxJulianDay() &&
    		    	littleDateRange.getMinJulianDay() >= bigDateRange.getMinJulianDay();

		if(littleDateRangeCompletelySmallerThanBigDateRange) {return result == 0.0d;}
		if(littleDateRangeCompletelyLargerThanBigDateRange) {return result == 0.0d;}
		if(littleDateRangeIsContainedByTheLargerDateRange) {return result == 1.0d;}
		if(littleDateRangeOverlapsTheLowerBoundOfTheLargerDateRangeOnly) {
			double expectedResult = (littleDateRange.getMaxJulianDay() - bigDateRange.getMinJulianDay() + 1.0d) / littleDateRange.range;
		    return result == expectedResult;
		}
		if(littleDateRangeOverlapsTheUpperBoundOftheLargerDateRangeOnly) {
		    double expectedResult = (bigDateRange.getMaxJulianDay() - littleDateRange.getMinJulianDay() + 1.0d) / littleDateRange.range;
	        return result == expectedResult;
		}
		return false;// should be unreachable
	}
	
	//Pre-condition, Requirements, and Post-condition for notSameAs(DateRange, Duration...)
	public boolean notSameAsDateRangeDuration_Precondition(DateRange dateRange, Duration... durations) {
		return dateRange != null && durations.length <= 1;
	}
	
	public boolean notSameAsDateRangeDuration_Requirements(DateRange dateRange, Duration[] durations) {
		boolean result = false;
		if(durations.length == 0) {
			result = sameAs_Precondition(dateRange);
		} else if(durations.length == 1) {
			result = sameAs_Precondition(dateRange, durations[0]);
		}
		
		if(result) {
			thisPrime = new DateRange(this);
			dateRangePrime = new DateRange(dateRange);
		}
		
		return result;
	}
	
	public boolean notSameAsDateRangeDuration_Postcondition(Duration[] durations, double result) {

		 boolean response = false;
		 if(durations.length == 0) {
			 response = result == 1.0d - thisPrime.sameAs(dateRangePrime);
		 } else if(durations.length == 1) {
		     response = result == 1.0d - thisPrime.sameAs(dateRangePrime, durations[0]);
		 }
		 
		 return response;
	}
	
	//Pre-condition, Requirements, and Post-condition for toString())
	public boolean toString_Precondition() {
		return true;
	}
	
	public boolean toString_Requirements() {
		return toString_Precondition();
	}
	
	public boolean toString_Postcondition(String result) {

		 boolean response = result.equals("(" + minYMD + "; " + maxYMD + "; range = " + range + ")");
		 
		 return response;
	}
	
	//Pre-condition, Requirements, and Post-condition for equals(DateRange))
	public boolean equalsDateRange_Precondition(DateRange dateRange) {
		return dateRange != null;
	}
	
	public boolean equalsDateRange_Requirements(DateRange dateRange) {
		return equalsDateRange_Precondition(dateRange);
	}
	
	public boolean equalsDateRange_Postcondition(DateRange dateRange, boolean result) {

		 boolean expectedResult = (minJulianDay == dateRange.minJulianDay) &&
		                          (maxJulianDay == dateRange.maxJulianDay);
		 boolean response = result == expectedResult;
		 
		 return response;
	}
	
	public static void main(String[] args) {
	}
}
