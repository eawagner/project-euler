package practice.project.euler.problem.p01_09;

import practice.project.euler.Problem;

/*
The sum of the squares of the first ten natural numbers is,
12 + 22 + ... + 102 = 385

The square of the sum of the first ten natural numbers is,
(1 + 2 + ... + 10)2 = 552 = 3025

Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

*/
public class Problem6 implements Problem{
    public String getAnswer() {
        long sumOfSquares = 0;
        long sum = 0;

        for (int i = 1;i<=100;i++) {
            sumOfSquares += i*i;
            sum += i;
        }

        return Long.toString((sum*sum)-sumOfSquares);
    }
}
