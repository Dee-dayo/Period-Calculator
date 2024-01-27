import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class PeriodCalculator {

    private Calendar calendar = Calendar.getInstance();
    private int previousDate;

    public PeriodCalculator(){
        calendar.clear();

        calendar.set(Calendar.YEAR, 2024);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DATE, 1);
    }

    public void setDay(int day){
        calendar.set(Calendar.DATE, day);
    }

    public void setMonth(int month){
        calendar.set(Calendar.MONTH, month - 1);
    }

    public void setYear(int year){
        calendar.set(Calendar.YEAR, year);
    }

    public String getPreviousDate(){
        SimpleDateFormat myFormat = new SimpleDateFormat("MMM dd yyyy");
        Date date = calendar.getTime();
        return myFormat.format(date);
    }
}
