package practice.project.euler.problem.p20_29;

import practice.project.euler.Problem;
import practice.project.euler.util.StringUtil;

import java.math.BigInteger;

/*
n! means n × (n − 1) × ... × 3 × 2 × 1

For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

Find the sum of the digits in the number 100!

 */
public class Problem20 implements Problem{
    public String getAnswer() {

        BigInteger factorial = new BigInteger("1");

        for (int i = 2;i<101;i++)
            factorial = factorial.multiply(new BigInteger(Integer.toString(i)));

        return Integer.toString(StringUtil.getSumOfDigits(factorial.toString()));
    }
}
