package practice.project.euler.problem.p30_39;

import practice.project.euler.Problem;

/*
If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.

{20,48,52}, {24,45,51}, {30,40,50}

For which value of p ≤ 1000, is the number of solutions maximised?

 */
public class Problem39 implements Problem{
    public String getAnswer() throws Exception {

        int retVal = 3;
        int maxSol = 0;
        for (int p = 4;p<=1000;p++)
        {
            int numSol = 0;
            for (int a = 1;a<p-1;a++)
                for (int b = a;b<p-1;b++)
                {
                    int c = p - (a + b);

                    if ((a*a) + (b*b) == (c*c))
                        numSol++;

                }

            if (numSol>maxSol) {
                maxSol = numSol;
                retVal = p;
            }
        }

        return Integer.toString(retVal);
    }
}
