package practice.project.euler.problem.p40_49;

import practice.project.euler.Problem;

import java.util.Collection;
import java.util.LinkedHashSet;

import static practice.project.euler.util.PrimeUtil.getPrimes;
import static practice.project.euler.util.StringUtil.isPermutation;

/*
The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways: (i) each of the three terms are prime, and, (ii) each of the 4-digit numbers are permutations of one another.

There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property, but there is one other 4-digit increasing sequence.

What 12-digit number do you form by concatenating the three terms in this sequence?

 */
public class Problem49 implements Problem{
    public String getAnswer() throws Exception {

        Collection<Long> primes = getPrimes(2202, 10000, new LinkedHashSet<Long>());

        for (long prime : primes) {
            for (int i = 1;prime + i*2<10000;i++) {
                if (primes.contains(prime+i) && primes.contains(prime+i*2) &&
                        isPermutation(Long.toString(prime), Long.toString(prime + i)) &&
                        isPermutation(Long.toString(prime), Long.toString(prime + i * 2)))
                    return Long.toString(prime) + Long.toString(prime+i) + Long.toString(prime+i*2);
            }
        }

        return null;
    }
}
