package practice.project.euler.problem;

import practice.project.euler.Problem;
import practice.project.euler.util.PrimeUtil;

import java.util.Stack;

import static java.lang.Math.sqrt;
import static practice.project.euler.util.FactorUtil.sumFactors;

/*

The proper divisors of a number are all the divisors excluding the number itself. For example, the proper divisors of 28 are 1, 2, 4, 7, and 14. As the sum of these divisors is equal to 28, we call it a perfect number.

Interestingly the sum of the proper divisors of 220 is 284 and the sum of the proper divisors of 284 is 220, forming a chain of two numbers. For this reason, 220 and 284 are called an amicable pair.

Perhaps less well known are longer chains. For example, starting with 12496, we form a chain of five numbers:

12496 → 14288 → 15472 → 14536 → 14264 (→ 12496 → ...)

Since this chain returns to its starting point, it is called an amicable chain.

Find the smallest member of the longest amicable chain with no element exceeding one million.

 */
public class Problem95 implements Problem {
    @Override
    public String getAnswer() throws Exception {
        boolean[] cache = new boolean[1000000 + 1];
        Stack<Long> chain = new Stack<Long>();
        Iterable<Long> primes = PrimeUtil.getPrimes((long) sqrt(1000000));

        int longestChain = 0;
        long retVal = 0;

        for (int i = 2; i<cache.length; i++) {

            if (cache[i])
                continue;

            long next = i;
            boolean ignore = false;
            while (!chain.contains(next)) {
                ignore = (next > 1000000 || cache[(int)next]);
                if (ignore)
                    break;

                chain.push(next);
                next = sumFactors(next, primes);
            }

            if (!ignore) {
                long smallest = next;
                int chainLength = 1;
                long current = chain.pop();

                //get chain information
                while (current != next) {
                    cache[(int)current] = true;
                    if (current < smallest)
                        smallest = current;

                    chainLength++;
                    current = chain.pop();
                }

                if (chainLength > longestChain) {
                    longestChain = chainLength;
                    retVal = smallest;
                }
            }

            //cache any additional values in chain.
            while (!chain.isEmpty())
                cache[chain.pop().intValue()] = true;

        }


        return Long.toString(retVal);
    }
}
