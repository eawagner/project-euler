package practice.project.euler.problem.p70_79;

import practice.project.euler.Problem;

import static practice.project.euler.util.FactorUtil.gcd;

/*
Consider the fraction, n/d, where n and d are positive integers. If n<d and HCF(n,d)=1, it is called a reduced proper fraction.

If we list the set of reduced proper fractions for d ≤ 8 in ascending order of size, we get:

1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8

It can be seen that there are 3 fractions between 1/3 and 1/2.

How many fractions lie between 1/3 and 1/2 in the sorted set of reduced proper fractions for d ≤ 12,000?

Note: The upper limit has been changed recently.

 */
public class Problem73 implements Problem{
    public String getAnswer() throws Exception {

        long total = 0;

        for (int i = 5;i<=12000;i++) {
            long min = i/3 + 1;
            long max = i/2;
            if (i%2 ==0)
                max--;

            for (long j = min;j<=max;j++)
                if (gcd(j, i)==1)
                    total++;

        }

        return Long.toString(total);
    }
}
