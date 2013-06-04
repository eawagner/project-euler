package practice.project.euler.problem.p30_39;

import practice.project.euler.Problem;

import static java.lang.Long.parseLong;
import static practice.project.euler.util.PrimeUtil.getNextPrime;
import static practice.project.euler.util.PrimeUtil.isPrime;

/*
The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.

Find the sum of the only eleven primes that are both truncatable from left to right and right to left.

NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.

 */
public class Problem37 implements Problem {
    public String getAnswer() throws Exception {

        int numTruncPrimes = 0;
        long currPrime = 11;
        long retVal = 0;
        while (numTruncPrimes<11) {

            String primeStr = Long.toString(currPrime);

            if (checkRight(primeStr.substring(0,primeStr.length()-1))
                    && checkLeft(primeStr.substring(1, primeStr.length()))) {

                numTruncPrimes++;
                retVal+=currPrime;
            }

            currPrime = getNextPrime(currPrime);
        }

        return Long.toString(retVal);
    }

    private boolean checkRight(String num)
    {
        if (num.length() == 0)
            return true;

        return checkRight(num.substring(0,num.length()-1)) && isPrime(parseLong(num));
    }

    private boolean checkLeft(String num)
    {
        if (num.length() == 0)
            return true;

        return checkLeft(num.substring(1, num.length())) && isPrime(parseLong(num));
    }

}
