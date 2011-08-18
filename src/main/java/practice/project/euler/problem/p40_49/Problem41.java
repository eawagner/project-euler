package practice.project.euler.problem.p40_49;

import practice.project.euler.Problem;
import practice.project.euler.util.PrimeUtil;

import java.util.ArrayList;
import java.util.Collection;

/*
We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is also prime.

What is the largest n-digit pandigital prime that exists?

 */
public class Problem41 implements Problem {
    public String getAnswer() throws Exception {

        for (int i = 9;i>0;i--)
            for (String pandigital : getPandigitals(i))
                if (PrimeUtil.isPrime(Long.parseLong(pandigital)))
                    return pandigital;

        return null;
    }

    private static Collection<String> getPandigitals (int numDigits)
    {
        boolean used[] = new boolean[numDigits+1];
        Collection<String> retVal = new ArrayList<String>(); //ArrayList seems to be the fastest core java collection

        generatePandigital("",used,numDigits,retVal);
        return retVal;
    }

    //This generates the highest valued pandigitals and keeps them in order so the underlying collection
    //should maintain ordering.
    private static void generatePandigital(String currVal, boolean used[], int numDigits, Collection<String> pandigitals) {
        if (currVal.length() == numDigits) {
            pandigitals.add(currVal);
            return;
        }

        for (int i = numDigits;i>0;i--)
        {
            if (!used[i])
            {
                used[i] = true;
                generatePandigital(currVal + i,used,numDigits,pandigitals);
                used[i] = false;
            }
        }

    }

}
