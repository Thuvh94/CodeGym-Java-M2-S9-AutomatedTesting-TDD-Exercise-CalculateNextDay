import java.util.Arrays;

public class NextDayCalculator {
    public static String findNextDay(int inputDay, int inputMonth, int inputYear) {
        int outputDay, outputMonth, outputYear;
        int[] output = new int[3];
        if (inputMonth == 4 || inputMonth == 6 || inputMonth == 9 || inputMonth == 11)
            output = returnShortMonth(inputDay, inputMonth, inputYear);
         else if (inputMonth == 2) {
            output = calculateFebCase(inputDay,inputMonth,inputYear);
        } else
            output = returnLongMonth(inputDay, inputMonth, inputYear);
        return display(output);
    }

    public static int[] returnLongMonth(int inputDay, int inputMonth, int inputYear) {
        int[] output = new int[3];
        if (inputDay != 31) {
            return output = calculateNormalCase(inputDay, inputMonth, inputYear);
        } else {
            if (inputMonth == 12) {
                int outputYear = inputYear + 1;
                output[0] = 1;
                output[1] = 1;
                output[2] = outputYear;
                return output;
            } else {
                output = calculateEndMonthCase(inputDay, inputMonth, inputYear);
                return (output);
            }
        }
    }

    public static int[] returnShortMonth(int inputDay, int inputMonth, int inputYear) {
        if (inputDay != 30) {
            return calculateNormalCase(inputDay, inputMonth, inputYear);
        } else {
            return calculateEndMonthCase(inputDay, inputMonth, inputYear);
        }
    }

    public static boolean isLeapYear(int inputYear) {
        boolean isDivisibleBy4 = inputYear % 4 == 0;
        boolean isLeapYear;
        if (isDivisibleBy4) {
            boolean isDivisibleBy100 = inputYear % 100 == 0;
            if (isDivisibleBy100) {
                boolean isDivisibleBy400 = inputYear % 400 == 0;
                if (isDivisibleBy400) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public static int[] calculateEndMonthCase(int inputDay, int inputMonth, int inputYear) {
        int[] output = {1, inputMonth + 1, inputYear};
        return output;
    }

    public static int[] calculateNormalCase(int inputDay, int inputMonth, int inputYear) {
        int[] output = {inputDay+1, inputMonth,inputYear};
        return output;
    }

    public static int[] calculateFebCase(int inputDay, int inputMonth, int inputYear){
        int[] output = new int[3];
        if (isLeapYear(inputYear)) {
            if (inputDay < 29) {
                output = calculateNormalCase(inputDay, inputMonth, inputYear);
            } else if (inputDay == 29)
                output = calculateEndMonthCase(inputDay, inputMonth, inputYear);
        } else {
            if (inputDay < 28) {
                output = calculateNormalCase(inputDay, inputMonth, inputYear);
            } else if (inputDay == 28) {
                output = calculateEndMonthCase(inputDay, inputMonth, inputYear);
            }
        }
        return output;
    }
    public static String display(int[] output) {
        return Arrays.toString(output);
    }
}


