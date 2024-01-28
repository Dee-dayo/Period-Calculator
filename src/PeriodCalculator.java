import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class PeriodCalculator {

    private Calendar oldCalendar = Calendar.getInstance();
    private Calendar newCalendar = Calendar.getInstance();
    private SimpleDateFormat myFormat = new SimpleDateFormat("MMM dd");
    private int previousPeriodStartDay;
    private int previousPeriodStartMonth;
    private int noOfDayOfPreviousPeriod;
    private int averageLengthOfCycle;
    private int ovulationStartDay;
    private int ovulationEndDay;

    public void setPreviousPeriodStartDay(int previousPeriodStartDay){
        if (previousPeriodStartDay >=1 && previousPeriodStartDay <= 31) {
            this.previousPeriodStartDay = previousPeriodStartDay;
        } else {
            System.out.println("You entered a value more than the usual");
        }
    }

    public void setPreviousPeriodStartMonth (int previousPeriodStartMonth){
        if (previousPeriodStartMonth >=1 && previousPeriodStartMonth <= 12) {
            this.previousPeriodStartMonth = previousPeriodStartMonth;
        } else {
            System.out.println("You entered a value more than the usual");
        }
    }

    public String getPreviousStartDate(){
        oldCalendar.set(Calendar.DATE, previousPeriodStartDay);
        oldCalendar.set(Calendar.MONTH, previousPeriodStartMonth - 1);
        Date date = oldCalendar.getTime();
        return myFormat.format(date);
    }

    public String getPreviousEndDate(){
        oldCalendar.set(Calendar.DATE, (previousPeriodStartDay + noOfDayOfPreviousPeriod) - 1);
        Date date = oldCalendar.getTime();
        return myFormat.format(date);
    }

    public String getNewStartDate(){
        newCalendar.set(Calendar.DATE, previousPeriodStartDay + averageLengthOfCycle);
        newCalendar.set(Calendar.MONTH, (previousPeriodStartMonth - 1));
        Date date = newCalendar.getTime();
        return myFormat.format(date);
    }

    public String getNewEndDate(){
        newCalendar.set(Calendar.DATE, previousPeriodStartDay + averageLengthOfCycle);
        newCalendar.set(Calendar.MONTH, previousPeriodStartMonth - 1);
        newCalendar.add(Calendar.DATE, noOfDayOfPreviousPeriod - 1);
        Date date = newCalendar.getTime();
        return myFormat.format(date);
    }

    public String getOvulationStartDate(){
        newCalendar.set(Calendar.DATE, (previousPeriodStartDay + averageLengthOfCycle));
        newCalendar.set(Calendar.MONTH, previousPeriodStartMonth - 1);
        newCalendar.add(Calendar.DATE, (averageLengthOfCycle - 14)); // Assuming ovulation occurs 14 days before next period
        Date date = newCalendar.getTime();
        return myFormat.format(date);
    }

    public String getOvulationEndDate(){
        newCalendar.set(Calendar.DATE, (previousPeriodStartDay + averageLengthOfCycle));
        newCalendar.set(Calendar.MONTH, previousPeriodStartMonth - 1);
        newCalendar.add(Calendar.DATE, (averageLengthOfCycle - 10)); // Assuming ovulation occurs 14 days before next period and lasts for 4 days
        Date date = newCalendar.getTime();
        return myFormat.format(date);
    }

    public void setDaysOfPreviousPeriod(int noOfDayOfPreviousPeriod){
        this.noOfDayOfPreviousPeriod = noOfDayOfPreviousPeriod;
    }

    public int getNoOfDayOfPreviousPeriod(){
        return noOfDayOfPreviousPeriod;
    }

    public void setAverageLengthOfMenstrualCycle(int averageLengthOfCycle){
        this.averageLengthOfCycle = averageLengthOfCycle;
    }

    public int getAverageLengthOfCycle(){
        return averageLengthOfCycle;
    }

    public String displayPreviousCycle(){
        String display = "\n\nYour last period started on " + getPreviousStartDate() +
                "\nThe period ended on the " + getPreviousEndDate();
        return display;
    }

    public String displayNewCycle(){
        String display = "\n\nYour next period will start on " + getNewStartDate() +
                "\nThe period will end on " + getNewEndDate() +
                "\nYour ovulation period will be from " + getOvulationStartDate() + " to " + getOvulationEndDate();
        return display;
    }
}
