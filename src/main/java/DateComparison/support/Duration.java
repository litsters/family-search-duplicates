package DateComparison.support;

/**
 * An amount of time measured in years, months, and days
 * @author Scott Woodfield
 * <pre>
 *     <b>Domain:</b><br>
 *         years  int;
 *         months int;
 *         days   int;
 *         
 *     @invariant years &ge; 0 AND years <= MAX_DURATION_YEAR AND
 *                months &ge; 0                               AND
 *                days &ge; 0 
 * </pre>
 */
public class Duration {
//Domain Implementation
	private int years;
	private int months;
	private int days;

//Constructors
	/**
	 * Constructor given years, months, and days
	 * @param years the new number of years
	 * @param months the new number of months
	 * @param days the new number of days
	 * @pre years &ge; 0 AND years <= MAX_DURATION_YEAR AND
	 *      months &ge; 0                               AND
	 *      days &ge; 0
	 * @req pre
	 * @post this.years = years AND this.months = months && this.days = days
	 */
	public Duration(int years, int months, int days) {
		assert DurationIntIntInt_Requirements(years, months, days);
		
		this.years = years;
		this.months = months;
		this.days = days;
		
		assert DurationIntIntInt_Postcondition(years, months, days) && invariant();
	}
	
	/**
	 * Constructor given years and months
	 * @param years the new number of years
	 * @param months the new number of months
	 * @pre years &ge; 0 AND years <= MAX_DURATION_YEAR AND
	 *      months &ge; 0
	 * @req pre
	 * @post this.years = years AND this.months = months && this.days = 0
	 */
	public Duration(int years, int months) {
		this(years, months, 0);
		assert DurationIntInt_Requirements(years, months);
		
		assert DurationIntInt_Postcondition(years, months) && invariant();
	}
	
	/**
	 * Constructor given only years
	 * @param years the new number of years
	 * @pre years &ge; 0 AND years <= MAX_DURATION_YEAR
	 * @req pre
	 * @post this.years = years AND this.months = 0 && this.days = 0
	 */
	public Duration(int years) {
		this(years,  0, 0);
		assert DurationInt_Requirements(years);
		
		assert DurationInt_Postcondition(years) && invariant();
	}
	
	/**
	 * Default constructor
	 * @pre None
	 * @req pre
	 * @post this.years = 0 AND this.months = 0 && this.days = 0
	 */
	public Duration() {
		this(0, 0, 0);
		assert Duration_Requirements();
		
		assert Duration_Postcondition() && invariant();
	}
	
//Queries
	/**
	 * Years getter
	 * @pre None
	 * @req pre
	 * @post result = years
	 */
	public int getYears() {
		assert getYears_Requirements() && invariant();
		
		int result = years;
		
		assert getYears_Postcondition(result) && invariant();
		return result;
	}
	
	/**
	 * Months getter
	 * @req None
	 * @pre req
	 * @post result = months
	 */
	public int getMonths() {
		assert getMonths_Requirements() && invariant();
		
		int result = months;
		
		assert getMonths_Postcondition(result) && invariant();
		return result;
	}
	
	/**
	 * Days getter
	 * @req None
	 * @pre req
	 * @post result = days
	 */
	public int getDays() {
		assert getDays_Requirements() && invariant();
		
		int result = days;
		
		assert getDays_Postcondition(result) && invariant();
		return result;
	}

	/**
	 * Returns the precision of this Duration
	 * @pre None
	 * @req pre
	 * @post days > 0 &rArr; result = Precision.DAYS AND
	 *       days = 0 AND months > 0 &rArr; result = Precision.MONTHS AND
	 *       days = 0 AND months = 0 &rArr; result = Precision.YEARS
	 */
	public Precision getPrecision() {
		assert getPrecision_Requirements() && invariant();
		
		Precision result = null;
		if(days > 0) {
			result = Precision.DAYS;
		} else if(months > 0) {
			result = Precision.MONTHS;
		} else {
			result = Precision.YEARS;
		}
		
		assert getPrecision_Postcondition(result) && invariant();
		return result;
	}
	

	/**
	 * Return the string representation of the Duration
	 * @pre None
	 * @req pre
	 * @post result = years + "/" + months + "/" + days
	 */
	public String toString() {
		assert toString_Requirements() && invariant();
		
		StringBuilder result = new StringBuilder();
		result.append(years);
		result.append("/");
		result.append(months);
		result.append("/");
		result.append(days);
		
		String response = result.toString();
		
		assert toString_Postcondition(response) && invariant();
		return result.toString();
	}
	
//Public Constants and Enumerations
	public enum Precision {YEARS, MONTHS, DAYS};
	
	public static final Duration FIVE_YEARS    = new Duration(5);
	public static final Duration ONE_YEAR      = new Duration(1);
	public static final Duration ONE_MONTH     = new Duration(0, 1, 0);
	public static final Duration ONE_WEEK      = new Duration(0, 0, 7);
	public static final Duration ONE_DAY       = new Duration(0, 0, 1);
	public static final Duration ZERO_DURATION = new Duration();
	public static final int MAX_DURATION_YEAR = YearMonthDay.MAX_YEAR - YearMonthDay.MIN_YEAR;
	
//Supporting variables constants and methods
	//Invariants, Pre-conditions, and Post-conditions
	private static boolean invariant(int years, int months, int days) {
		boolean result = years >= 0 && years <= MAX_DURATION_YEAR &&
				         months >= 0                              &&
				         days >= 0;
		
		return result;
	}
	
	private boolean invariant() {
		boolean result = invariant(years, months, days);

        return result;
    }
	
	//DurationIntIntInt Requirements, Pre-condition, and Post-condition
	private static boolean DurationIntIntInt_Requirements(int years, int months, int days) {
		boolean result = invariant(years, months, days);
		return result;	
	}
	
	public static boolean DurationIntIntInt_Precondition(int years, int months, int days) {
		boolean result = DurationIntIntInt_Requirements(years, months, days);
		return result;
	}
	
	public boolean DurationIntIntInt_Postcondition(int years, int months, int days) {
		boolean result = this.years == years &&
				         this.months == months &&
				         this.days == days;
		return result;
	}
	
	//DurationIntInt Requirements, Pre-condition, and Post-condition
	private static boolean DurationIntInt_Requirements(int years, int months) {
		boolean result = invariant(years, months, 0);
		return result;	
	}
	
	public static boolean DurationIntInt_Precondition(int years, int months) {
		boolean result = DurationIntInt_Requirements(years, months);
		return result;
	}
	
	public boolean DurationIntInt_Postcondition(int years, int months) {
		boolean result = this.years == years &&
				         this.months == months &&
				         this.days == 0;
		return result;
	}
	
	//DurationInt Requirements, Pre-condition, and Post-condition
	private static boolean DurationInt_Requirements(int years) {
		boolean result = invariant(years, 0, 0);
		return result;	
	}
	
	public static boolean DurationInt_Precondition(int years) {
		boolean result = DurationInt_Requirements(years);
		return result;
	}
	
	public boolean DurationInt_Postcondition(int years) {
		boolean result = this.years == years &&
				         this.months == 0 &&
				         this.days == 0;
		return result;
	}
	
	//DurationInt Requirements, Pre-condition, and Post-condition
	private static boolean Duration_Requirements() {
		boolean result = true;
		return result;	
	}
	
	public static boolean Duration_Precondition() {
		boolean result = Duration_Requirements();
		return result;
	}
	
	public boolean Duration_Postcondition() {
		boolean result = this.years == 0 &&
				         this.months == 0 &&
				         this.days == 0;
		return result;
	}
	
	//getYears Requirements, Pre-condition, and Post-condition
	private boolean getYears_Requirements() {
		boolean result = true;
		return result;	
	}
	
	public boolean getYears_Precondition() {
		boolean result = getYears_Requirements();
		return result;
	}
	
	public boolean getYears_Postcondition(int result) {
		boolean response = result == years;
		return response;
	}
	
	//getMonths Requirements, Pre-condition, and Post-condition
	private boolean getMonths_Requirements() {
		boolean result = true;
		return result;	
	}
	
	public boolean getMonths_Precondition() {
		boolean result = getMonths_Requirements();
		return result;
	}
	
	public boolean getMonths_Postcondition(int result) {
		boolean response = result == months;
		return response;
	}
	
	//getDays Requirements, Pre-condition, and Post-condition
	private boolean getDays_Requirements() {
		boolean result = true;
		return result;	
	}
	
	public boolean getDays_Precondition() {
		boolean result = getDays_Requirements();
		return result;
	}
	
	public boolean getDays_Postcondition(int result) {
		boolean response = result == days;
		return response;
	}
	
	//getPrecision Requirements, Pre-condition, and Post-condition
	private boolean getPrecision_Requirements() {
		boolean result = true;
		return result;	
	}
	
	public boolean getPrecision_Precondition() {
		boolean result = getPrecision_Requirements();
		return result;
	}
	
	public boolean getPrecision_Postcondition(Precision result) {
		boolean response = (days <= 0 || result == Precision.DAYS) &&
				           (days != 0 || months <= 0 || result == Precision.MONTHS) && 
				           (days != 0 || months != 0 || result == Precision.YEARS);
		return response;
	}
	
	
	//toString Requirements, Pre-condition, and Post-condition
	private boolean toString_Requirements() {
		boolean result = true;
		return result;	
	}
	
	public boolean toString_Precondition() {
		boolean result = toString_Requirements();
		return result;
	}
	
	public boolean toString_Postcondition(String result) {
		String expectedResult = years + "/" + months + "/" + days;
		boolean response = result.equals(expectedResult);
		return response;
	}
}
