package practice.project.euler.problem.p30_39;

import practice.project.euler.Problem;

import static practice.project.euler.util.StringUtil.isPalendrome;

/*
The decimal number, 585 = 1001001001 (binary), is palindromic in both bases.

Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.

(Please note that the palindromic number, in either base, may not include leading zeros.)

 */
public class Problem36 implements Problem {
    public String getAnswer() throws Exception {

        int sum = 0;

        //Since there are no leading zeros that means that if it ends in 0 base 10 or base2 then we can skip it.
        //Therefore only check even numbers and quickly check if the number is divisible by 10 before checking
        //if either is a palendrome.
        for (int i = 1;i<1000000;i+=2)
            if (i%10 != 0 &&
                    isPalendrome(i) && isPalendrome(Integer.toString(i, 2)))
                sum += i;


        return Integer.toString(sum);
    }
}
