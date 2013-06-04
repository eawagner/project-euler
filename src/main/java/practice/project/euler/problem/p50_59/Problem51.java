package practice.project.euler.problem.p50_59;

import practice.project.euler.Problem;

import static java.lang.Long.parseLong;
import static practice.project.euler.util.PrimeUtil.getNextPrime;
import static practice.project.euler.util.PrimeUtil.isPrime;

/*
By replacing the 1st digit of *3, it turns out that six of the nine possible values: 13, 23, 43, 53, 73, and 83, are all prime.

By replacing the 3rd and 4th digits of 56**3 with the same digit, this 5-digit number is the first example having seven primes among the ten generated numbers, yielding the family: 56003, 56113, 56333, 56443, 56663, 56773, and 56993. Consequently 56003, being the first member of this family, is the smallest prime with this property.

Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits) with the same digit, is part of an eight prime value family.
 */
public class Problem51 implements Problem{
    public String getAnswer() throws Exception {

        long prime = getNextPrime(56003);

        while (prime < 200000) {
            String primeStr = Long.toString(prime);
            for (int i = 0;i<2;i++) {
                int numPrimes = 1;
                if (primeStr.contains(Integer.toString(i))) {
                    for (int j = 0;j<10;j++) {
                        if (j!=i) {

                            //since leading zeros are not counted simply move on from strings where the first digit is replaced.
                            if (j==0 && primeStr.indexOf(Integer.toString(i))==0)
                                continue;


                            if (isPrime(parseLong(primeStr.replace(Integer.toString(i), Integer.toString(j))))) {
                                numPrimes++;
                                if (numPrimes==8)
                                    return primeStr;
                            }
                        }
                    }
                }
            }
            prime = getNextPrime(prime);
        }
        return null;
    }
}
