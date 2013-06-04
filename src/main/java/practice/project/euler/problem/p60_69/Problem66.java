package practice.project.euler.problem.p60_69;

import practice.project.euler.Problem;
import practice.project.euler.util.model.ContinuedFraction;

import java.math.BigInteger;

import static java.lang.Math.sqrt;
import static java.math.BigInteger.ZERO;
import static practice.project.euler.util.model.ContinuedFraction.fromSquareRoot;

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

        BigInteger maxX = ZERO;
        int retVal = 3;
        for (int d = 8;d<=1000;d++) {
            double tmp = sqrt(d);
            if (tmp == (long)tmp)
                continue;

            ContinuedFraction cf = fromSquareRoot(d);
            BigInteger x;

            if (cf.getPeriodLength() %2 == 0)
                x = cf.expand(cf.getPeriodLength() - 1).getNumerator();
            else
                x = cf.expand(cf.getPeriodLength() * 2 - 1).getNumerator();

            if (maxX.compareTo(x)<0) {
                maxX = x;
                retVal = d;
            }
        }

        return Integer.toString(retVal);

    }
}
