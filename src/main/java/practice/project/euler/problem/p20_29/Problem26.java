package practice.project.euler.problem.p20_29;

import practice.project.euler.Problem;

/*
A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:

    1/2	= 	0.5
    1/3	= 	0.(3)
    1/4	= 	0.25
    1/5	= 	0.2
    1/6	= 	0.1(6)
    1/7	= 	0.(142857)
    1/8	= 	0.125
    1/9	= 	0.(1)
    1/10	= 	0.1

Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.

Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.

 */
public class Problem26 implements Problem{
    public String getAnswer() throws Exception {

        int maxd = 2;
        int maxlen = 0;

        for (int i = 2;i<=1000;i++)
        {
            int remainder = 1;

            //cycles will at most be as long as the divisor.
            //For non cycling numbers, the remainder will turn to zero
            for (int j = 0;j<i;j++)
                remainder=(remainder*10)%i;

            int r0 = remainder;
            int len = 0;

            //Keep taking remainders until we find the one above.  This is the length of the cycle.
            do {
                remainder=(remainder*10)%i;
                len++;
            } while (remainder!=r0);

            if (len>maxlen) {
                maxlen = len;
                maxd = i;
            }

        }

        return Integer.toString(maxd);
    }
}
