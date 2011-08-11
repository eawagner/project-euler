package practice.project.euler.problem.p20_29;

import practice.project.euler.Problem;

import java.math.BigInteger;

/*
The Fibonacci sequence is defined by the recurrence relation:

    Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.

Hence the first 12 terms will be:

    F1 = 1
    F2 = 1
    F3 = 2
    F4 = 3
    F5 = 5
    F6 = 8
    F7 = 13
    F8 = 21
    F9 = 34
    F10 = 55
    F11 = 89
    F12 = 144

The 12th term, F12, is the first term to contain three digits.

What is the first term in the Fibonacci sequence to contain 1000 digits?

 */
public class Problem25 implements Problem{
    public String getAnswer() throws Exception {
        BigInteger prev = BigInteger.ONE;
        BigInteger curr = BigInteger.ONE;
        BigInteger tmp;
        int i = 2;
        while (curr.toString().length()<1000)
        {
            tmp = curr;
            curr = curr.add(prev);
            prev = tmp;
            i++;
        }


        return Integer.toString(i);
    }
}
