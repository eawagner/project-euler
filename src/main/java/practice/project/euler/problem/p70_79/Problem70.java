package practice.project.euler.problem.p70_79;

import practice.project.euler.Problem;

import java.util.ArrayList;

import static practice.project.euler.util.PrimeUtil.getPrimes;
import static practice.project.euler.util.StringUtil.isPermutation;

/*
Euler's Totient function, φ(n) [sometimes called the phi function], is used to determine the number of positive numbers less than or equal to n which are relatively prime to n. For example, as 1, 2, 4, 5, 7, and 8, are all less than nine and relatively prime to nine, φ(9)=6.
The number 1 is considered to be relatively prime to every positive number, so φ(1)=1.

Interestingly, φ(87109)=79180, and it can be seen that 87109 is a permutation of 79180.

Find the value of n, 1 < n < 107, for which φ(n) is a permutation of n and the ratio n/φ(n) produces a minimum.

 */
public class Problem70 implements Problem{
    public String getAnswer() throws Exception {

        ArrayList<Long> primes = getPrimes(4000, new ArrayList<Long>()); //4000 choosen later after solution was found


        double leastFound = 10;
        long retVal = 0;
        //solution was based on premise that in order to minimize n/φ(n) we have to maximize φ(n).
        //This mean to include as few primes as possible.  Since no primes fit the permutation property,
        //I used 2 primes.  Reading about RSA you will find that in order to calculate the totient for 2
        //primes it is simply (p-1)(q-1) for primes q and p.
        for (int i = 0;i< primes.size() - 1;i++) {
            for (int j = i+1;j<primes.size();j++) {
                long totient = (primes.get(i) - 1) * (primes.get(j)-1);
                long num = primes.get(i) * primes.get(j);
                if (num > 10000000)
                    break;
                double ratio = (num)/(double)totient;
                if (ratio<leastFound && isPermutation(Long.toString(num), Long.toString(totient))) {
                    leastFound = ratio;
                    retVal = num;
                }
            }
        }

        return Long.toString(retVal);
    }
}
