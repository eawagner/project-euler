package practice.project.euler.problem.p70_79;

import practice.project.euler.Problem;

import java.util.ArrayList;
import java.util.List;

import static practice.project.euler.problem.p30_39.Problem31.count;
import static practice.project.euler.util.PrimeUtil.getPrimes;

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

        List<Long> primes = getPrimes(100, new ArrayList<Long>());

        for (int n = 1;;n++) {
            int total = count(n, primes.size() - 1, primes);
            if (total >= 5000)
                return Integer.toString(n);
        }

    }

}
