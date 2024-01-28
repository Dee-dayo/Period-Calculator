import java.util.Scanner;
public class PeriodCalculatorTester {
    public static void main(String[] args) {
        PeriodCalculator periodCalculator = new PeriodCalculator();
        Scanner input = new Scanner(System.in);

        System.out.print("What day did your last period start? ");
        int day = input.nextInt();
        periodCalculator.setPreviousPeriodStartDay(day);

        System.out.print("What month was it? ");
        int month = input.nextInt();
        periodCalculator.setPreviousPeriodStartMonth(month);

        System.out.print("How many days did your period last? ");
        int noOfPeriodDay = input.nextInt();
        periodCalculator.setDaysOfPreviousPeriod(noOfPeriodDay);

        System.out.print("How long is your average menstral cycle? ");
        int noOfCycle = input.nextInt();
        periodCalculator.setAverageLengthOfMenstrualCycle(noOfCycle);



        System.out.print(periodCalculator.displayPreviousCycle());
        System.out.print(periodCalculator.displayNewCycle());
    }
}
