package practice.project.euler.problem;

import practice.project.euler.Problem;
import practice.project.euler.problem.p30_39.Problem31;
import practice.project.euler.util.GeneralUtil;
import practice.project.euler.util.PrimeUtil;

import java.util.*;

/*
It is possible to write ten as the sum of primes in exactly five different ways:

7 + 3
5 + 5
5 + 3 + 2
3 + 3 + 2 + 2
2 + 2 + 2 + 2 + 2

What is the first value which can be written as the sum of primes in over five thousand different ways?

 */
public class Problem77 implements Problem{
    public String getAnswer() throws Exception {

        List<Long> primes = new ArrayList<Long>();
        PrimeUtil.getPrimes(100,primes);

        for (int n = 1;;n++) {
            int total = Problem31.count(n,primes.size()-1,primes);
            if (total >= 5000)
                return Integer.toString(n);
        }

    }

}
