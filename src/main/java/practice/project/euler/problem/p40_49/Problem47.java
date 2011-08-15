package practice.project.euler.problem.p40_49;

import practice.project.euler.Problem;
import practice.project.euler.util.FactorUtil;
import practice.project.euler.util.PrimeUtil;

import java.util.Collection;

/*
The first two consecutive numbers to have two distinct prime factors are:

14 = 2 × 7
15 = 3 × 5

The first three consecutive numbers to have three distinct prime factors are:

644 = 2² × 7 × 23
645 = 3 × 5 × 43
646 = 2 × 17 × 19.

Find the first four consecutive integers to have four distinct primes factors. What is the first of these numbers?
l
 */
public class Problem47 implements Problem{
    public String getAnswer() throws Exception {

        int numConsecutive = 0;
        Collection<Long> primes = PrimeUtil.getPrimes(1000);

        //Reworked to only check a number and work its way back.  If any number was found to not have
        //4 factors then I simply jumped up another 4 and tested back until I found a combination where there
        //where four in a row.
        int num = 648;
        while (true) {

            int i = 0;
            for (i = 0;i<4;i++)
                if (FactorUtil.getPrimeFactorization(num-i,primes).size()!=4)  //will throw null if num of primes is too low
                    break;

            if (i == 4)
                return Integer.toString(num-3);

            num = num - i + 4;
        }

    }
}
