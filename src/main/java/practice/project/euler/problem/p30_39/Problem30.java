package practice.project.euler.problem.p30_39;

import practice.project.euler.Problem;

import static java.lang.Math.pow;
import static practice.project.euler.util.StringUtil.charToInt;

/*
Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:

    1634 = 14 + 64 + 34 + 44
    8208 = 84 + 24 + 04 + 84
    9474 = 94 + 44 + 74 + 44

As 1 = 14 is not a sum it is not included.

The sum of these numbers is 1634 + 8208 + 9474 = 19316.

Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.

 */
public class Problem30 implements Problem{
    public String getAnswer() throws Exception {

        int max = findMax(5);
        int retVal = 0;
        for (int i = 2;i<max;i++){
            int sum = 0;
            String tmp = Integer.toString(i);
            for (int j = 0; j<tmp.length();j++)
                sum += (int) pow(charToInt(tmp.charAt(j)), 5);

            if (sum == i)
                retVal += i;

        }


        return Integer.toString(retVal);
    }
    /*
    To narrow search we know that at the worst the a single digit will be 9^n.
    Therefore we can try to find a number where the minimum value for a number with a certain number
    of digits exceeds 9^n * num of digits.
     */
    private int findMax(int power){
        int numDigits = 1;
        int valPerDig = (int) pow(9, power);
        while (pow(10, numDigits) < numDigits * valPerDig)
            numDigits++;

        return numDigits*valPerDig;
    }
}
