package practice.project.euler.problem.p40_49;

import practice.project.euler.Problem;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

/*
The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some order, but it also has a rather interesting sub-string divisibility property.

Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:

    * d2d3d4=406 is divisible by 2
    * d3d4d5=063 is divisible by 3
    * d4d5d6=635 is divisible by 5
    * d5d6d7=357 is divisible by 7
    * d6d7d8=572 is divisible by 11
    * d7d8d9=728 is divisible by 13
    * d8d9d10=289 is divisible by 17

Find the sum of all 0 to 9 pandigital numbers with this property.

 */
public class Problem43 implements Problem{
    public String getAnswer() throws Exception {

        boolean [] used = new boolean[10];

        return Long.toString(getPandigitalwithStrDiv("",used, new long[] {2, 3, 5, 7, 11, 13, 17}));
    }

    private static long getPandigitalwithStrDiv(String current, boolean[] used, long[] primes) {

        //Check that the last 4 digits are divisible by correct prime during each recursion.
        //This will allow quicker exits if while constructing the number one of the lower digit combinations
        //does not satisfy the divisibility check.
        if (current.length() > 3 &&
                parseInt(current.substring(current.length() - 3)) % primes[current.length() - 4] != 0)
            return 0;

        if (current.length() == 10)
            return parseLong(current);

        long retVal = 0;
        for (int i = 0;i<10;i++)
            if (!used[i]) {
                used[i] = true;
                retVal += getPandigitalwithStrDiv(current + i, used, primes);
                used[i] = false;
            }


        return retVal;
    }
}
