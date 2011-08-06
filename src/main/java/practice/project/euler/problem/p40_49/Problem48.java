package practice.project.euler.problem.p40_49;

import practice.project.euler.Problem;

import java.math.BigInteger;

/*
The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.

Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.

 */
public class Problem48 implements Problem{
    public String getAnswer() throws Exception {

        //I was too lazy, but you really only need to keep track of the least significant digits.
        //Since the n < 1001 is small you can easily do this.  BigInt was just too easy and really fast.

        BigInteger sum = new BigInteger("0");
        BigInteger end = new BigInteger("1001");
        BigInteger increment = new BigInteger("1");
        for (BigInteger n = new BigInteger("1");n.compareTo(end)<0;n = n.add(increment))
            sum = sum.add(n.pow(n.intValue()));

        String sumStr = sum.toString();
        return sumStr.substring(sumStr.length()-10,sumStr.length());
    }
}
