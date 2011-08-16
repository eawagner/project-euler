package practice.project.euler.problem.p30_39;

import practice.project.euler.Problem;
import practice.project.euler.util.FactorUtil;
import practice.project.euler.util.GeneralUtil;

/*
If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.

{20,48,52}, {24,45,51}, {30,40,50}

For which value of p ≤ 1000, is the number of solutions maximised?

 */
public class Problem39 implements Problem{
    public String getAnswer() throws Exception {

        int [] pTrips = GeneralUtil.genNumPythagoreanTrips(1000);
        int maxSol = 0;
        int retVal = 0;


        for (int i = 0;i<pTrips.length;i++)
            if (pTrips[i]>maxSol) {
                maxSol = pTrips[i];
                retVal = i;
            }

        return Integer.toString(retVal);

    }
}
