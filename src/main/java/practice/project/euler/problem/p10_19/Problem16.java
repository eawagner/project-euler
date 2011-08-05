package practice.project.euler.problem.p10_19;

import practice.project.euler.Problem;
import practice.project.euler.util.StringUtil;

import java.math.BigInteger;

/*
2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 2^1000?

 */
public class Problem16 implements Problem{
    public String getAnswer() {

        String tmp = new BigInteger("2").pow(1000).toString();

        return Integer.toString(StringUtil.getSumOfDigits(tmp));
    }
}
