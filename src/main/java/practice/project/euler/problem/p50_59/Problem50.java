package practice.project.euler.problem.p50_59;

import practice.project.euler.Problem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import static practice.project.euler.util.PrimeUtil.getPrimes;

/*
The prime 41, can be written as the sum of six consecutive primes:
41 = 2 + 3 + 5 + 7 + 11 + 13

This is the longest sum of consecutive primes that adds to a prime below one-hundred.

The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

Which prime, below one-million, can be written as the sum of the most consecutive primes?

*/
public class Problem50 implements Problem{
    public String getAnswer() throws Exception {

        List<Long> indexed = getPrimes(1000000, new ArrayList<Long>());
        Collection<Long> fastLookup = new HashSet<Long>(indexed);

        int maxChain = 0;
        long retVal = 0;
        for (int i = 0; i<indexed.size(); i++) {
            long sum = 0;
            for (int j = 0; j<indexed.size()-i; j++) {
                sum+=indexed.get(i+j);
                if (sum > 1000000)
                    break;

                if (fastLookup.contains(sum) && j>maxChain) {
                    retVal = sum;
                    maxChain = j;
                }
            }
        }

        return Long.toString(retVal);
    }




}
