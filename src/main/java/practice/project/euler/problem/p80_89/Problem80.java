package practice.project.euler.problem.p80_89;

import practice.project.euler.Problem;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_HALF_UP;
import static practice.project.euler.util.StringUtil.getSumOfDigits;

/*
It is well known that if the square root of a natural number is not an integer, then it is irrational. The decimal expansion of such square roots is infinite without any repeating pattern at all.

The square root of two is 1.41421356237309504880..., and the digital sum of the first one hundred decimal digits is 475.

For the first one hundred natural numbers, find the total of the digital sums of the first one hundred decimal digits for all the irrational square roots.

 */
public class Problem80 implements Problem{

    BigDecimal two = new BigDecimal(2);

    public String getAnswer() throws Exception {

        long retVal = 0;
        for (int i = 2;i<=100;i++) {
            double tmp = Math.sqrt(i);
            if (tmp == (int)tmp)
                continue;

            BigDecimal s = new BigDecimal(i);
            BigDecimal prev;
            BigDecimal curr = refine(new BigDecimal(tmp), s);

            do {
                prev = curr;
                curr = refine(curr,s);
            } while(curr.compareTo(prev)!=0);

            String number = curr.toPlainString().replace(".","").substring(0,100);

            retVal += getSumOfDigits(number);
        }


        return Long.toString(retVal);
    }

    private BigDecimal refine(BigDecimal guess, BigDecimal s) {
        return s.divide(guess,101, ROUND_HALF_UP).add(guess).divide(two,101, ROUND_HALF_UP);
    }
}
