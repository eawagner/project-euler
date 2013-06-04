package practice.project.euler.problem.p01_09;

import practice.project.euler.Problem;

import static practice.project.euler.util.PrimeUtil.getNextPrime;

/*
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10 001st prime number?

*/
public class Problem7 implements Problem{
    public String getAnswer() {
        long currPrime=1;

        for (int i = 0;i<10001;i++)
            currPrime = getNextPrime(currPrime);

        return Long.toString(currPrime);
    }
}
