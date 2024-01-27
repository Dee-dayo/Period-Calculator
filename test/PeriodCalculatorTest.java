import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PeriodCalculatorTest {

    @Test
    public void testThatTheAppExist() {
        PeriodCalculator periodCalculator = new PeriodCalculator();

        assertNotNull(periodCalculator);
    }

    @Test
    public void testThatYouCanEnterYourLastPeriodDate(){
        PeriodCalculator periodCalculator = new PeriodCalculator();
        String date = periodCalculator.getPreviousDate();

        assertEquals("Jan 01 2024", date);

    }
}