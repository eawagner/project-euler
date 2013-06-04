package practice.project.euler.problem.p30_39;

import practice.project.euler.Problem;

import static java.lang.Math.pow;
import static practice.project.euler.util.GeneralUtil.getFactorial;

/*
145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

Find the sum of all numbers which are equal to the sum of the factorial of their digits.

Note: as 1! = 1 and 2! = 2 are not sums they are not included.

 */
public class Problem34 implements Problem{
    public String getAnswer() throws Exception {

        long max = findMax();
        int retSum = 0;

        int [] cache = getDigitFactorials();

        for (int i = 10;i<=max;i++) {
            if (i == getNextItem(i,cache))
                retSum +=i;
        }

        return Long.toString(retSum);
    }

    private long findMax()
    {
        int numDigits = 1;
        long valPerDig = getFactorial(9);
        while (pow(10, numDigits) < numDigits * valPerDig)
            numDigits++;

        return numDigits*valPerDig;

    }

    public static int[] getDigitFactorials()
    {
        int [] retVal = new int[10];
        for (int i = 0;i<retVal.length;i++)
            retVal[i] = (int) getFactorial(i);

        return retVal;
    }

    public static int getNextItem(int num, int []digitFactorials) {
        int retVal = 0;
        while (num > 0) {
            retVal += digitFactorials[num%10];
            num /=10;
        }
        return retVal;
    }



}
