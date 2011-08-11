package practice.project.euler.problem.p50_59;

import practice.project.euler.Problem;
import practice.project.euler.util.StringUtil;

import java.math.BigInteger;

/*
A googol (10^100) is a massive number: one followed by one-hundred zeros; 100100 is almost unimaginably large: one followed by two-hundred zeros. Despite their size, the sum of the digits in each number is only 1.

Considering natural numbers of the form, ab, where a, b < 100, what is the maximum digital sum?

 */
public class Problem56 implements Problem{
    public String getAnswer() throws Exception {

        int max = 0;
        BigInteger min = new BigInteger("95");

        for (BigInteger a = new BigInteger("99");a.compareTo(min)>0;a = a.subtract(BigInteger.ONE))
            for (int b = 99;b>90;b--) {
                int sum = StringUtil.getSumOfDigits(a.pow(b).toString());
                if (sum > max)
                    max = sum;
            }


        return Integer.toString(max);
    }
}
