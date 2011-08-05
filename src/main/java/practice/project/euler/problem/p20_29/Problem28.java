package practice.project.euler.problem.p20_29;

import practice.project.euler.Problem;

/*
Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:

21 22 23 24 25
20  7  8  9 10
19  6  1  2 11
18  5  4  3 12
17 16 15 14 13

It can be verified that the sum of the numbers on the diagonals is 101.

What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?

 */
public class Problem28 implements Problem{
    public String getAnswer() throws Exception {
        int sumDiag = 1;
        int side = 1;

        //trick is that the top right corner is always a square
        for (int i = 2;side<1001;i++) {
            side = 2*i -1;
            int square = side*side;
            for (int j = 0;j<4;j++)
                sumDiag += square - j*(side-1);

        }

        return Integer.toString(sumDiag);
    }
}
