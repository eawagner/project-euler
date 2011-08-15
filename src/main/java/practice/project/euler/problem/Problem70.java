package practice.project.euler.problem;

import practice.project.euler.Problem;
import practice.project.euler.util.FactorUtil;
import practice.project.euler.util.StringUtil;

/*
Euler's Totient function, φ(n) [sometimes called the phi function], is used to determine the number of positive numbers less than or equal to n which are relatively prime to n. For example, as 1, 2, 4, 5, 7, and 8, are all less than nine and relatively prime to nine, φ(9)=6.
The number 1 is considered to be relatively prime to every positive number, so φ(1)=1.

Interestingly, φ(87109)=79180, and it can be seen that 87109 is a permutation of 79180.

Find the value of n, 1 < n < 107, for which φ(n) is a permutation of n and the ratio n/φ(n) produces a minimum.

 */
public class Problem70 implements Problem{
    public String getAnswer() throws Exception {




        double leaseFound = 10;
        int retVal = 0;
        for (int n = 2;n<10000000;n++)
        {
            long totient = FactorUtil.totientFunction(n);

            double ratio = n/(double)totient;
            if (ratio<leaseFound && StringUtil.isPermutation(Integer.toString(n), Long.toString(totient))) {
                leaseFound = ratio;
                retVal = n;
            }


        }
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
