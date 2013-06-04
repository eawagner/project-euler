package practice.project.euler.problem.p50_59;

import practice.project.euler.Problem;

import static practice.project.euler.util.StringUtil.isPermutation;

/*
It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.

Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.

 */
public class Problem52 implements Problem{
    public String getAnswer() throws Exception {

        //I represents the number of digits
        for (int i = 6;i<10;i++) {
            //In order to be a permutation of the number, num*6 must have the same number of digits.
            long max = (long)(Math.pow(10,i))/6;


            for (long j = (long)(Math.pow(10,i-1))+1;j<max;j++) {
                int multiplier = 2;
                for (;multiplier<=6;multiplier++) {
                    if (!isPermutation(Long.toString(j), Long.toString(j * multiplier)))
                        break;
                }

                if (multiplier >= 6)
                    return Long.toString(j);
            }
        }

        return null;
    }

}
