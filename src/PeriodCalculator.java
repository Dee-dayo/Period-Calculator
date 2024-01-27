import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class PeriodCalculator {

    private Calendar oldCalendar = Calendar.getInstance();
    private Calendar newCalender = Calendar.getInstance();
    private SimpleDateFormat myFormat = new SimpleDateFormat("MMM dd");
    private int previousPeriodStartDay;
    private int previousPeriodStartMonth;
    private int noOfDayOfPreviousPeriod;
    private int averageLengthOfCycle;
    private int ovulationDay;



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
        newCalender.set(Calendar.DATE, previousPeriodStartDay + averageLengthOfCycle);
        newCalender.set(Calendar.MONTH, (previousPeriodStartMonth - 1) + 1);
        Date date = newCalender.getTime();
        return myFormat.format(date);
    }

    public String getNewEndDate(){
        newCalender.set(Calendar.DATE, (previousPeriodStartDay + averageLengthOfCycle + noOfDayOfPreviousPeriod));
        Date date = newCalender.getTime();
        return myFormat.format(date);
    }

    public String getNewOvulationDate(){
        newCalender.set(Calendar.DATE, (previousPeriodStartDay + averageLengthOfCycle + noOfDayOfPreviousPeriod + ovulationDay));
        Date date = newCalender.getTime();
        return myFormat.format(date);
    }

    public void setDaysOfPreviousPeriod(int noOfDayOfPreviousPeriod){
        this.noOfDayOfPreviousPeriod = noOfDayOfPreviousPeriod;
    }

    public int getNoOfDayOfPreviousPeriod(){
        return noOfDayOfPreviousPeriod;
    }

    public void setAverageLengthOfMenstralCycle(int averageLengthOfCycle){
        this.averageLengthOfCycle = averageLengthOfCycle;
    }

    public int getAverageLengthOfCycle(){
        return averageLengthOfCycle;
    }

    private int calculateOvulationDay() {
        int daysBeforeNextPeriod = 14;
        ovulationDay = previousPeriodStartDay + averageLengthOfCycle - daysBeforeNextPeriod;
        return ovulationDay;
    }

    public String getPreviousOvulationDay(){
        oldCalendar.set(Calendar.DATE, ovulationDay);
        Date date = oldCalendar.getTime();
        return myFormat.format(date);
    }


    public String displayPreviousCycle(){
        String display = "\n\nYour last period started on " + getPreviousStartDate() +
                "\nThe period ended on the " + getPreviousEndDate() +
                "\nYour Ovulation day is " + getPreviousOvulationDay();
        return display;
    }

    public String displayNewCycle(){
        String display = "\n\nYour next period will start on " + getNewStartDate() +
                "\nThe period will end on " + getNewEndDate() +
                "\nYour next Ovulation day is " + getNewOvulationDate();
        return display;
    }

}
