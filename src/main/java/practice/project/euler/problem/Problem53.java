package practice.project.euler.problem;

import practice.project.euler.Problem;

/*
There are exactly ten ways of selecting three from five, 12345:

123, 124, 125, 134, 135, 145, 234, 235, 245, and 345

In combinatorics, we use the notation, 5C3 = 10.

In general,
nCr =
n!
r!(n−r)!
	,where r ≤ n, n! = n×(n−1)×...×3×2×1, and 0! = 1.

It is not until n = 23, that a value exceeds one-million: 23C10 = 1144066.

How many, not necessarily distinct, values of  nCr, for 1 ≤ n ≤ 100, are greater than one-million?

 */
public class Problem53 implements Problem{
    public String getAnswer() throws Exception {

        int retVal = 0;

        int [][]pascalTriangle = new int[101][101];

        for (int i = 0;i<pascalTriangle.length;i++) {
            pascalTriangle[i][0] = 1;
            pascalTriangle[i][i] = 1;
        }

        for (int i = 1;i<pascalTriangle.length;i++)
            for (int j = 1;j<=i-1;j++) {
                pascalTriangle[i][j] = pascalTriangle[i-1][j] + pascalTriangle[i-1][j-1];
                if (pascalTriangle[i][j] > 1000000) {
                    //set to 1000000 to prevent integer overflow.
                    pascalTriangle[i][j] = 1000000;
                    retVal++;
                }

            }

          //My old solution was brute force, but better solution discovered using pascal's triangle.
//        BigInteger million = new BigInteger("1000000");
//
//        for (int n = 1;n<=100;n++)
//            for (int r = 1;r<n;r++)
//                if (GeneralUtil.getFactorial(n).divide(GeneralUtil.getFactorial(r).multiply(GeneralUtil.getFactorial(n-r))).compareTo(million) >0)
//                    retVal++;

        return Integer.toString(retVal);
    }
}
