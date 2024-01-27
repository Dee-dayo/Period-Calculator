import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PeriodCalculatorTest {

    @Test
    public void testThatTheAppExist() {
        PeriodCalculator periodCalculator = new PeriodCalculator();
        assertNotNull(periodCalculator);
    }

    @Test
    public void testThatUserCanGetLastPeriodDate(){
        PeriodCalculator periodCalculator = new PeriodCalculator();
        String date = periodCalculator.getPreviousStartDate();
        assertNotNull(date);
    }

    @Test
    public void testThatUserCanSetLastPeriodDate(){
        PeriodCalculator periodCalculator = new PeriodCalculator();
        periodCalculator.setPreviousPeriodStartDay(12);
        periodCalculator.setPreviousPeriodStartMonth(3);
        String date = periodCalculator.getPreviousStartDate();
        assertEquals("Mar 12", date);
    }

    @Test
    public void testThatUserCanSetHowLongHerPeriodLast(){
        PeriodCalculator periodCalculator = new PeriodCalculator();
        periodCalculator.setDaysOfPreviousPeriod(5);
        int dayOfPeriod = periodCalculator.getNoOfDayOfPreviousPeriod();
        assertEquals(5, dayOfPeriod);
    }

    @Test
    public void testThatUserCanSetMentalCycle(){
        PeriodCalculator periodCalculator = new PeriodCalculator();
        periodCalculator.setAverageLengthOfMenstralCycle(21);
        int menstralCycle = periodCalculator.getAverageLengthOfCycle();
        assertEquals(21, menstralCycle);
    }
}