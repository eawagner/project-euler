package practice.project.euler.problem.p30_39;

import practice.project.euler.Problem;
import practice.project.euler.util.StringUtil;

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

        for (int i = 10;i<=max;i++)
        {
            String num = Integer.toString(i);

            long sum = 0;
            for (int j = 0;j<num.length();j++) {
                sum += cache[StringUtil.charToInt(num.charAt(j))];
                if (sum > i)
                    break;
            }

            if (sum == i)
                retSum +=i;
        }

        return Long.toString(retSum);
    }

    private long findMax()
    {
        int numDigits = 1;
        long valPerDig = getFactorial(9);
        while (Math.pow(10,numDigits) < numDigits * valPerDig)
            numDigits++;

        return numDigits*valPerDig;

    }

    private int[] getDigitFactorials()
    {
        int [] retVal = new int[10];
        for (int i = 0;i<retVal.length;i++)
            retVal[i] = (int)getFactorial(i);

        return retVal;
    }


    public static long getFactorial(int num)
    {
        long retVal = 1;

        for (int i= 2;i<=num;i++)
            retVal*=i;

        return retVal;
    }
}
