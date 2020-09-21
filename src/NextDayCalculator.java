import java.util.Arrays;

public class NextDayCalculator {
    public static String findNextDay(int inputDay, int inputMonth, int inputYear) {
        int outputDay = 0,outputMonth=0,outputYear=0;
        int[] output={0,0,0};
        if (inputMonth  == 1 || inputMonth  == 3 || inputMonth  == 5||inputMonth  == 7 ||inputMonth  == 8||inputMonth  == 10||inputMonth  == 12) {
                output = returnLongMonth(inputDay, inputMonth, inputYear);
        }

        else if (inputMonth == 4 || inputMonth == 6 || inputMonth == 9 || inputMonth == 11){
                output = returnShortMonth(inputDay,inputMonth,inputYear);
        }

        else if (inputMonth == 2){
            if(isLeapYear(inputYear)){
                if (inputDay < 29){
                     output = calculateNormalCase(inputDay,inputMonth,inputYear);
                }
                else if (inputDay == 29)
                    output = calculateEndMonthCase(inputDay,inputMonth,inputYear);
            }
            else{
                if (inputDay < 28){
                    output = calculateNormalCase(inputDay,inputMonth,inputYear);
                }
                else if (inputDay == 28){
                    output = calculateEndMonthCase(inputDay,inputMonth,inputYear);
                }
            }
        }
        return display(output);
    }

    public static int[] returnLongMonth(int inputDay, int inputMonth, int inputYear) {
        int[] output = new int[3];
        if (inputDay != 31) {
            return output = calculateNormalCase(inputDay,inputMonth,inputYear);
        } else {
            if (inputMonth==12){
                int outputYear = inputYear + 1;
                output[0] = 1;
                output[1] = 1;
                output[2] = outputYear;
                return output;
            }
            else {
               output = calculateEndMonthCase(inputDay,inputMonth,inputYear);
               return (output);
            }
        }
    }

    public static int[] returnShortMonth(int inputDay, int inputMonth, int inputYear){
        if (inputDay!=30){
           return calculateNormalCase(inputDay,inputMonth,inputYear);
        }
        else {
            return calculateEndMonthCase(inputDay,inputMonth, inputYear);
        }
}

    public static boolean isLeapYear(int inputYear) {
        boolean isDivisibleBy4 = inputYear % 4 == 0;
        boolean isLeapYear;
        if (isDivisibleBy4) {
            boolean isDevisibleBy100 = inputYear % 100 == 0;
            if (isDevisibleBy100) {
                boolean isDevisibleBy400 = inputYear % 400 == 0;
                if (isDevisibleBy400) {
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

    public static int[] calculateEndMonthCase(int inputDay, int inputMonth, int inputYear){
        int outputDay = 1;
        int outputMonth = inputMonth + 1;
        int outputYear = inputYear;
        int[] output = {outputDay, outputMonth, outputYear};
        return output;
    }

    public static int[] calculateNormalCase(int inputDay, int inputMonth, int inputYear){
        int outputDay = inputDay + 1;
        int outputMonth = inputMonth;
        int outputYear = inputYear;
        int[] output = {outputDay, outputMonth, outputYear};
        return output;

    }
    public static String display (int[] output){
        return Arrays.toString(output);
    }
}


