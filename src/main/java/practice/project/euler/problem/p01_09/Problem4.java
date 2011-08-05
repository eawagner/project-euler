package practice.project.euler.problem.p01_09;

import practice.project.euler.Problem;
import practice.project.euler.util.StringUtil;

/*
A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.

*/
public class Problem4 implements Problem{
    public String getAnswer() {

        long largest = 0;
        long product = 0;

        for (int a = 999;a>=100;a--)
            for (int b = 999;b>=100;b--) {
                product = a*b;
                if (product<largest)
                    break;

                if (StringUtil.isPalendrome(product))
                    largest = product;
            }


        return Long.toString(largest);  //To change body of implemented methods use File | Settings | File Templates.
    }
}
