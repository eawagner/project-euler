package practice.project.euler.problem;

import practice.project.euler.Problem;

/*

Consider quadratic Diophantine equations of the form:

x2 – Dy2 = 1

For example, when D=13, the minimal solution in x is 6492 – 13×1802 = 1.

It can be assumed that there are no solutions in positive integers when D is square.

By finding minimal solutions in x for D = {2, 3, 5, 6, 7}, we obtain the following:

32 – 2×22 = 1
22 – 3×12 = 1
92 – 5×42 = 1
52 – 6×22 = 1
82 – 7×32 = 1

Hence, by considering minimal solutions in x for D ≤ 7, the largest x is obtained when D=5.

Find the value of D ≤ 1000 in minimal solutions of x for which the largest value of x is obtained.

 */
public class Problem66 implements Problem{
    public String getAnswer() throws Exception {

        long maxX = 0;
        int retVal = 0;
        for (int d = 2;d<=1000;d++) {
            double tmp = Math.sqrt(d);
            if (tmp == (int)tmp)
                continue;

            for (int y = 1;;y++)
            {
                double x = Math.sqrt((d * y * y) + 1);
                if (x == (long)x) {
                    if(x > maxX) {
                        maxX = (long)x;

                        retVal = d;
                    }
                    break;
                }
            }
        }


        return Long.toString(maxX);
    }
}
