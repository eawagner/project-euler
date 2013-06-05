package practice.project.euler.problem.p40_49;

import practice.project.euler.Problem;

/*
The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.

Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.

 */
public class Problem48 implements Problem{
    public String getAnswer() throws Exception {


        //Came back and reworked the solution to only keep track of the least significant digits.
        long sum = 0;
        long mod = 10000000000L;
        for (int n = 1; n < 1001; n++) {
            long tmp = n;
            for (int i = 1;i < n;i++)
                tmp = (tmp * n) % mod;

            sum = (sum + tmp) % mod;
        }

        return Long.toString(sum);

        //OLD SOLUTION
        //I was too lazy, but you really only need to keep track of the least significant digits.
        //Since the n < 1001 is small you can easily do this.  BigInt was just too easy and really fast.

//        BigInteger sum = ZERO;
//        BigInteger end = new BigInteger("1001");
//
//        for (BigInteger n = ONE; n.compareTo(end)<0; n = n.add(ONE))
//            sum = sum.add(n.pow(n.intValue()));
//
//        String sumStr = sum.toString();
//        return sumStr.substring(sumStr.length()-10,sumStr.length());
    }
}
