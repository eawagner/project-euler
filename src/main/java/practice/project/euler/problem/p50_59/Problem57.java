package practice.project.euler.problem.p50_59;

import practice.project.euler.Problem;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;

/*
It is possible to show that the square root of two can be expressed as an infinite continued fraction.

√ 2 = 1 + 1/(2 + 1/(2 + 1/(2 + ... ))) = 1.414213...

By expanding this for the first four iterations, we get:

1 + 1/2 = 3/2 = 1.5
1 + 1/(2 + 1/2) = 7/5 = 1.4
1 + 1/(2 + 1/(2 + 1/2)) = 17/12 = 1.41666...
1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...

The next three expansions are 99/70, 239/169, and 577/408, but the eighth expansion, 1393/985, is the first example where the number of digits in the numerator exceeds the number of digits in the denominator.

In the first one-thousand expansions, how many fractions contain a numerator with more digits than denominator?

 */
public class Problem57 implements Problem{
    public String getAnswer() throws Exception {

        BigInteger numerator = ONE;
        BigInteger denominator = new BigInteger("2");
        int retVal = 0;
        for (int i = 1;i<1000;i++) {
            BigInteger tmp = denominator;
            denominator = denominator.multiply(new BigInteger("2")).add(numerator);
            numerator = tmp;

            if (numerator.add(denominator).toString().length() > denominator.toString().length())
                retVal++;

        }

        return Integer.toString(retVal);
    }
}
