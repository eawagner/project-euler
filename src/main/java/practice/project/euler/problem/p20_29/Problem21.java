package practice.project.euler.problem.p20_29;

import practice.project.euler.Problem;

import static practice.project.euler.util.FactorUtil.getFactors;
import static practice.project.euler.util.GeneralUtil.getSum;

/*
Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.

 */
public class Problem21 implements Problem{
    public String getAnswer() {

        long sum = 0;
        int[] cache = new int[10000];

        for (int i = 2;i<cache.length;i++) {
            if (cache[i]>0)
                continue;

            long Da = getSum(getFactors(i));
            long Db = getSum(getFactors(Da));

            if (i == Db && i != Da)
                sum += Da + Db;

            cache[i] = (int)Da;
            if (Da<cache.length)
                cache[(int)Da] = (int)Db;


        }



        return Long.toString(sum);
    }
}
