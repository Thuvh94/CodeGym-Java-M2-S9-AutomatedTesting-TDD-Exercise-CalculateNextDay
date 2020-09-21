import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NextDayCalculatorTest {

    @Test
    void findNextDayDay1Month1() {
        int thisDay = 1;
        int thisMonth = 1;
        int thisYear = 2018;
        String expected = "[2, 1, 2018]";
        String result = NextDayCalculator.findNextDay(1,1,2018);
        assertEquals(expected,result);
    }

    @Test
    void findNextDayDay31Month1() {
        int thisDay = 31;
        int thisMonth = 1;
        int thisYear = 2018;
        String expected = "[1, 2, 2018]";
        String result = NextDayCalculator.findNextDay(31,1,2018);
        assertEquals(expected,result);
    }

    @Test
    void findNextDayDay30Month4() {
        int thisDay = 30;
        int thisMonth = 4;
        int thisYear = 2018;
        String expected = "[1, 5, 2018]";
        String result = NextDayCalculator.findNextDay(30,4,2018);
        assertEquals(expected,result);
    }

    @Test
    void findNextDayDay28Month2() {
        int thisDay = 28;
        int thisMonth = 2;
        int thisYear = 2018;
        String expected = "[1, 3, 2018]";
        String result = NextDayCalculator.findNextDay(28,2,2018);
        assertEquals(expected,result);
    }

    @Test
    void findNextDayDay29Month2() {
        int thisDay = 29;
        int thisMonth = 2;
        int thisYear = 2020;
        String expected = "[1, 3, 2020]";
        String result = NextDayCalculator.findNextDay(29,2,2020);
        assertEquals(expected,result);
    }

    @Test
    void findNextDayDay31Month12() {
        int thisDay = 31;
        int thisMonth = 12;
        int thisYear = 2018;
        String expected = "[1, 1, 2019]";
        String result = NextDayCalculator.findNextDay(31,12,2018);
        assertEquals(expected,result);
    }
}