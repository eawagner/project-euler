package practice.project.euler.problem.p01_09;

import practice.project.euler.Problem;

/*
A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
a2 + b2 = c2

For example, 32 + 42 = 9 + 16 = 25 = 52.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.

*/
public class Problem9 implements Problem{
    public String getAnswer() {

        //Since c will always be larger than a or b then start off at 998 with c and go down

        for (int c = 998;c>0;c--)
            for (int b=1000-c-1;b>0;b--) {
                int a = 1000-c-b;

                if ((a*a) + (b*b) == (c*c))
                    return Long.toString(a*b*c);
            }

        return null;
    }
}
