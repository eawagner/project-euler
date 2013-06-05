package practice.project.euler.problem.p30_39;

import practice.project.euler.Problem;

import java.util.Collection;
import java.util.LinkedHashSet;

import static java.lang.Long.parseLong;
import static practice.project.euler.util.PrimeUtil.getPrimes;

/*
The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.

There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.

How many circular primes are there below one million?

 */
public class Problem35 implements Problem{
    public String getAnswer() throws Exception {

        Collection<Long> primes = getPrimes(1000000, new LinkedHashSet<Long>());
        int retVal = 0;
        for (Long prime : primes) {
            String primeStr =prime.toString();

            boolean isCircular = true;
            for (int i = 1;isCircular && i<primeStr.length();i++) {

                primeStr = primeStr.substring(1,primeStr.length()) + primeStr.charAt(0);
                if (!primes.contains(parseLong(primeStr)))
                    isCircular = false;
            }

            if (isCircular)
                retVal++;

        }

        return Integer.toString(retVal);
    }
}
