package practice.project.euler.problem.p01_09;

import practice.project.euler.Problem;

import static java.lang.Math.pow;
import static practice.project.euler.util.PrimeUtil.getPrimes;

/*
2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

*/
public class Problem5 implements Problem{
    public String getAnswer() {
        long product = 1;

        for (Long prime : getPrimes(20))
            for (int pow = 1; pow(prime, pow)<20;pow++)
                product*=prime;

        return Long.toString(product);
    }
}
