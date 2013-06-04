package practice.project.euler.problem.p10_19;

import practice.project.euler.Problem;

/*
You are given the following information, but you may prefer to do some research for yourself.

    * 1 Jan 1900 was a Monday.
    * Thirty days has September,
      April, June and November.
      All the rest have thirty-one,
      Saving February alone,
      Which has twenty-eight, rain or shine.
      And on leap years, twenty-nine.
    * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.

How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?

 */
public class Problem19 implements Problem{
    public String getAnswer() {
        //Could use Date class to do this very easily, but that is no fun :)
        int days = 0;
        int answer = 0;
        for (int year = 1901;year <2001;year++) {
            for (int month = 1;month<=12;month++) {
                days += getNumDays(month, year);
                //since the first was on monday(=x%7=1) don't need to do any shift to days
                //to calculate sunday(=x%7=0)
                if (days%7==0)
                    answer++;
            }
        }
        return Integer.toString(answer);
    }

    private int getNumDays(int month, int year) {

        //This switch statement could be reorganized to enable java to optimize, but
        //decided on readability over small optimization.
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
                if (year%4 == 0 && year%100 != 0) {
                    return 29;
                }
                return 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
        }
        return 0;
    }
}
