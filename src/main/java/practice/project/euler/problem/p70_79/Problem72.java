package practice.project.euler.problem.p70_79;

import practice.project.euler.Problem;

/*
Consider the fraction, n/d, where n and d are positive integers. If n<d and HCF(n,d)=1, it is called a reduced proper fraction.

If we list the set of reduced proper fractions for d ≤ 8 in ascending order of size, we get:

1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8

It can be seen that there are 21 elements in this set.

How many elements would be contained in the set of reduced proper fractions for d ≤ 1,000,000?

 */
public class Problem72 implements Problem{
    public String getAnswer() throws Exception {
        //Found this interesting function that with a cache will perform very well
        //from http://oeis.org/A005728
        //F(n) = n * (n + 3) / 2 - SUM(k = 2 to n, F([n/k]))

        //Until I get a totient function that is fast, this is the answer at the bottom is the best I can do.
//        Collection<Long> primes = new ArrayList<Long>();
//        PrimeUtil.getPrimes(500000,primes);
//        long total = 0;
//        for (int i = 2;i<=1000000;i++)
//        {
//            total += FactorUtil.totientFunction(i,primes);
//        }

        long[] totals = new long[1000001];
        long total = 0;
        for (int i = 2;i<totals.length;i++) {
            totals[i] += i-1;
            total+=totals[i];
            for (int j = 2;j<=1000000/i;j++){
                totals[j*i] -= totals[i];
            }
        }

        return Long.toString(total);
    }

}
