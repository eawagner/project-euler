package practice.project.euler.problem.p70_79;

import practice.project.euler.Problem;

import static practice.project.euler.util.GeneralUtil.genNumPythagoreanTrips;

/*
It turns out that 12 cm is the smallest length of wire that can be bent to form an integer sided right angle triangle in exactly one way, but there are many more examples.

12 cm: (3,4,5)
24 cm: (6,8,10)
30 cm: (5,12,13)
36 cm: (9,12,15)
40 cm: (8,15,17)
48 cm: (12,16,20)

In contrast, some lengths of wire, like 20 cm, cannot be bent to form an integer sided right angle triangle, and other lengths allow more than one solution to be found; for example, using 120 cm it is possible to form exactly three different integer sided right angle triangles.

120 cm: (30,40,50), (20,48,52), (24,45,51)

Given that L is the length of the wire, for how many values of L ≤ 1,500,000 can exactly one integer sided right angle triangle be formed?

Note: This problem has been changed recently, please check that you are using the right parameters.

 */
public class Problem75 implements Problem{
    public String getAnswer() throws Exception {


        int [] pTrips = genNumPythagoreanTrips(1500000);
        int retVal = 0;


        for (int i = 0;i<pTrips.length;i++)
            if (pTrips[i]==1)
                retVal++;

        return Integer.toString(retVal);

    }
}
