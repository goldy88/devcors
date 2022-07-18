package lesson2;


public class Conditions {

    /**
     * @return true in case 'a' is greater than 'b', false otherwise.
     */
    public boolean isGreaterThan(int a, int b) {
        return a > b;
    }


    /**
     * @return 1 in case 'a' is greater than 'b', -1 if smaller, 0 if they are equal.
     */
    public int compare(int a, int b) {

        return Integer.compare(a, b);
    }

    /**
     * Method should return true in case input string corresponds to one of working days of week.
     * Comparison should be case insensitive.
     *
     * <p>hint: see String.equalsIgnoreCase method
     */
    public boolean isWorkingDay(String day) {
        if (day.equalsIgnoreCase("Monday")) {
            return true;
        } else if (day.equalsIgnoreCase("Tuesday")) {
            return true;
        } else if (day.equalsIgnoreCase("Wednesday")) {
            return true;
        } else if (day.equalsIgnoreCase("Thursday")) {
            return true;
        } else return day.equalsIgnoreCase("Friday");
    }

    /**
     * Method should return number based on which day of week is 'day'. For example 'Thursday' should retrieve 4.
     * <p>In case input is not recognized as one of days, return -1.
     * <p>Implement functionality using if statement.
     */
    public int dayOfWeekUsingIf(String day) {
        if (day.equalsIgnoreCase("Monday")) {
            return 1;
        } else if (day.equalsIgnoreCase("Tuesday")) {
            return 2;
        } else if (day.equalsIgnoreCase("Wednesday")) {
            return 3;
        } else if (day.equalsIgnoreCase("Thursday")) {
            return 4;
        } else if (day.equalsIgnoreCase("Friday")) {
            return 5;
        } else if (day.equalsIgnoreCase("Saturday")) {
            return 6;
        } else if (day.equalsIgnoreCase("Sunday")) {
            return 7;
        } else
            return -1;
    }


    /**
     * Method should return number based on which day of week is 'day'. For example 'Thursday' should retrieve 4.
     * <p>In case input is not recognized as one of days, return -1.
     * <p>Implement functionality using switch statement.
     */
    public int dayOfWeekUsingSwitch(String day) {
        switch (day) {
            case "Monday":
                return 1;
            case "Tuesday":
                return 2;
            case "Wednesday":
                return 3;
            case "Thursday":
                return 4;
            case "Friday":
                return 5;
            case "Saturday":
                return 6;
            case "Sunday":
                return 7;
            default:
                return -1;
        }
    }

    /**
     * Return factorial but only from 'factorial' to 'untilNumber'.
     * That means , that for inputs factorial = 9 and untilNumber = 5, result should be 9*8*7*6*5
     */

    public long mutatedFactorial(int factorial, int untilNumber) {
        int result = 1;
        for (int i = factorial; i >= untilNumber; i--) {
            result = result * i;
        }
        return result;
    }


}
