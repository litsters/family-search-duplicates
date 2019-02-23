package familySearchModel.support;

import DateComparison.support.DateRange;
import DateComparison.support.Duration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormalDateConverter {
    private static final Pattern PATTERN = Pattern.compile("(/)?(A)?([+\\-])?([0-9]+)(-[0-9]+)?(-[0-9]+)?(/((A)?([+\\-])?([0-9]+)(-[0-9]+)?(-[0-9]+)?)?)?");
    private static final int NUM_GROUPS = 14;   // This is the number of groups in the regex, since groupCount() is giving the wrong value
    private static final int APPROXIMATE_INDEX = 2;
    private static final int BC_INDEX = 3;
    private static final int YEAR_INDEX = 4;
    private static final int MONTH_INDEX = 5;
    private static final int DAY_INDEX = 6;
    private static final int SECOND_DATE_INDEX = 8;
    private static final int SECOND_APPROXIMATE_INDEX = 9;
    private static final int SECOND_BC_INDEX = 10;
    private static final int SECOND_YEAR_INDEX = 11;
    private static final int SECOND_MONTH_INDEX = 12;
    private static final int SECOND_DAY_INDEX = 13;

    public DateRange convert(String formalDate){
        Matcher matcher = PATTERN.matcher(formalDate);
        if(!matcher.matches()){
            return null;
        }
        else{
            boolean approximate = matcher.group(APPROXIMATE_INDEX) != null;
            boolean bc = matcher.group(BC_INDEX) != null && matcher.group(BC_INDEX).equals("-");
            String yearString = matcher.group(YEAR_INDEX);
            String monthString = matcher.group(MONTH_INDEX) == null ? null : matcher.group(MONTH_INDEX).substring(1);
            String dayString = matcher.group(DAY_INDEX) == null ? null : matcher.group(DAY_INDEX).substring(1);

            DateRange first = handleDate(yearString, monthString, dayString, approximate, bc);

            if(matcher.group(SECOND_DATE_INDEX) != null){
                boolean secondApproximate = matcher.group(SECOND_APPROXIMATE_INDEX) != null;
                boolean secondBc = matcher.group(SECOND_BC_INDEX) != null && matcher.group(SECOND_BC_INDEX).equals("-");
                String secondYearString = matcher.group(SECOND_YEAR_INDEX);
                String secondMonthString = matcher.group(SECOND_MONTH_INDEX) == null ? null : matcher.group(SECOND_MONTH_INDEX).substring(1);
                String secondDayString = matcher.group(SECOND_DAY_INDEX) == null ? null : matcher.group(SECOND_DAY_INDEX).substring(1);

                return handleRange(yearString, monthString, dayString, approximate, bc,
                        secondYearString, secondMonthString, secondDayString, secondApproximate, secondBc);

            } else return first;
        }
    }

    private DateRange handleRange(String firstYear, String firstMonth, String firstDay, boolean firstApproximate, boolean firstBc,
                                  String secondYear, String secondMonth, String secondDay, boolean secondApproximate, boolean secondBc){
        if(firstYear == null || secondYear == null) return null;
        int year1 = Integer.parseInt(firstYear);
        int year2 = Integer.parseInt(secondYear);

        int month1, month2;
        if(firstMonth == null) month1 = 1;
        else month1 = Integer.parseInt(firstMonth);
        if(secondMonth == null) month2 = 12;
        else month2 = Integer.parseInt(secondMonth);

        int day1, day2;
        if(firstDay == null) day1 = 1;
        else day1 = Integer.parseInt(firstDay);
        if(secondDay == null) day2 = 28;
        else day2 = Integer.parseInt(secondDay);

        if(firstBc) year1 *= -1;
        if(secondBc) year2 *= -1;

        List<Duration> durationList = new ArrayList<>();
        if(firstApproximate) durationList.add(new Duration(2));
        else durationList.add(new Duration());
        if(secondApproximate) durationList.add(new Duration(2));
        else durationList.add(new Duration());
        Duration[] durations = durationList.toArray(new Duration[]{});

        return new DateRange(year1, month1, day1, year2, month2, day2, durations);
    }

    private DateRange handleDate(String yearString, String monthString, String dayString, boolean approximate, boolean bc){
        if(yearString == null) return null;     // Without the year, there is nothing to do
        int year = Integer.parseInt(yearString);
        if(monthString == null) return noMonth(year, approximate, bc);
        int month = Integer.parseInt(monthString);
        if(dayString == null) return noDay(year, month, approximate, bc);
        int day = Integer.parseInt(dayString);
        return fullInfo(year, month, day, approximate, bc);
    }

    private DateRange noMonth(int year, boolean approximate, boolean bc){
        if(bc) year *= -1;
        if(approximate) return new DateRange(year, new Duration(2));
        else return new DateRange(year, new Duration(1));
    }

    private DateRange noDay(int year, int month, boolean approximate, boolean bc){
        if(bc) year *= -1;
        if(approximate) return new DateRange(year, month, new Duration(2,1));
        else return new DateRange(year, month, new Duration(0,1));
    }

    private DateRange fullInfo(int year, int month, int day, boolean approximate, boolean bc){
        if(bc) year *= -1;
        if(approximate){
            return new DateRange(year, month, day, new Duration(2));
        } else {
            return new DateRange(year, month, day, new Duration(0));
        }
    }

    public int numDays(int month){
        switch(month){
            case 1: return 31;
            case 2: return 28;
            case 3: return 31;
            case 4: return 30;
            case 5: return 31;
            case 6: return 30;
            case 7: return 31;
            case 8: return 31;
            case 9: return 30;
            case 10: return 31;
            case 11: return 30;
            case 12: return 31;
            default: return 28;
        }
    }
}
