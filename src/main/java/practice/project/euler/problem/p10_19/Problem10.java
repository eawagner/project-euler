package practice.project.euler.problem.p10_19;

import practice.project.euler.Problem;
import practice.project.euler.util.GeneralUtil;
import practice.project.euler.util.PrimeUtil;

/*
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.
 */
public class Problem10 implements Problem{
    public String getAnswer() {

        return Long.toString(GeneralUtil.getSum(PrimeUtil.getPrimes(2000000)));

    }
}
