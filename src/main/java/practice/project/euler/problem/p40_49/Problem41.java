package practice.project.euler.problem.p40_49;

import practice.project.euler.Problem;

import java.util.ArrayList;
import java.util.Collection;

import static java.lang.Long.parseLong;
import static practice.project.euler.util.PrimeUtil.isPrime;

/*
We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is also prime.

What is the largest n-digit pandigital prime that exists?

 */
public class Problem41 implements Problem {
    public String getAnswer() throws Exception {

        //Dropped to 7 from 9 after solution was found to speed up.
        for (int i = 7;i>0;i--) {
            String candidate = getPandigitals(i);
            if (candidate != null)
                return candidate;
        }

        return null;
    }

    private static String getPandigitals (int numDigits) {
        return generatePandigital("", new boolean[numDigits+1], numDigits);
    }

    //This generates the highest valued pandigital that is prime.
    private static String generatePandigital(String currVal, boolean used[], int numDigits) {
        if (currVal.length() == numDigits) {
            if (isPrime(parseLong(currVal)))
                return currVal;
            return null;
        }

        for (int i = numDigits;i>0;i--) {
            if (!used[i]) {
                used[i] = true;
                String curr = generatePandigital(currVal + i,used,numDigits);
                if (curr != null)
                    return curr;

                used[i] = false;
            }
        }
        return null;
    }

}
