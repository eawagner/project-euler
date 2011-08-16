package practice.project.euler.problem.p01_09;

import practice.project.euler.Problem;
import practice.project.euler.util.FactorUtil;
import practice.project.euler.util.GeneralUtil;

/*
A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
a2 + b2 = c2

For example, 32 + 42 = 9 + 16 = 25 = 52.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.

*/
public class Problem9 implements Problem{
    public String getAnswer() {

        //euclidian algorithm for generating triplets.
        int max = (int)Math.sqrt(1000);
        for (int m = 1;m<max;m+=2)
            for (int n = m+1;n<max;n+=2) {
                int a = n*n - m*m;
                    int b = 2*m*n;
                    int c = m*m + n*n;
                    int sum = a+b+c;
                    if (sum== 1000)
                        return Integer.toString(a*b*c);
                    else if (sum > 1000)
                        break;
            }


        return null;

    }
}
