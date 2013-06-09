package practice.project.euler.problem;

import practice.project.euler.Problem;

/*


The first known prime found to exceed one million digits was discovered in 1999, and is a Mersenne prime of the form 26972593−1; it contains exactly 2,098,960 digits. Subsequently other Mersenne primes, of the form 2p−1, have been found which contain more digits.

However, in 2004 there was found a massive non-Mersenne prime which contains 2,357,207 digits: 28433×27830457+1.

Find the last ten digits of this prime number.

 */
public class Problem97 implements Problem {
    @Override
    public String getAnswer() throws Exception {

        //Applying the first doubling early effectively halves the # of multiplications that need to be done.
        long result = 28433 * 2;
        int max = 7830457/2;

        for (int i = 0;i<max;i++)
            result = (result << 2) % 10000000000L;

        return Long.toString(result +1);
    }
}
