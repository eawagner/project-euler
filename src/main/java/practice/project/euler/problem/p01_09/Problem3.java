package practice.project.euler.problem.p01_09;

import practice.project.euler.Problem;

import static java.lang.Math.sqrt;
import static practice.project.euler.util.PrimeUtil.getPrevPrime;

/*
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?
*/
public class Problem3 implements Problem{
    public String getAnswer() {
        long value = 600851475143L;
        long currCheck = (long) sqrt(value);

        while (currCheck>2) {
            currCheck = getPrevPrime(currCheck);
            if (value%currCheck==0)
                return Long.toString(currCheck);
        }

        return "2";
    }
}
