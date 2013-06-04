package practice.project.euler.problem.p40_49;

import practice.project.euler.Problem;

import static practice.project.euler.util.StringUtil.charToInt;

/*
An irrational decimal fraction is created by concatenating the positive integers:

0.123456789101112131415161718192021...

It can be seen that the 12th digit of the fractional part is 1.

If dn represents the nth digit of the fractional part, find the value of the following expression.

d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000

 */
public class Problem40 implements Problem{
    public String getAnswer() throws Exception {

        StringBuilder buffer = new StringBuilder(1000001);

        int num = 0;
        while (buffer.length() < 1000001)
            buffer.append(num++);

        int retVal = 1;
        for (int i = 0;i<6;i++)
            retVal *= charToInt(buffer.charAt((int) Math.pow(10, i)));

        return Integer.toString(retVal);
    }
}
