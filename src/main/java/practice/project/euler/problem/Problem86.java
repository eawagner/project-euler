package practice.project.euler.problem;


import practice.project.euler.Problem;
import practice.project.euler.util.GeneralUtil;

import static java.lang.Math.sqrt;

/*

A spider, S, sits in one corner of a cuboid room, measuring 6 by 5 by 3, and a fly, F, sits in the opposite corner. By travelling on the surfaces of the room the shortest "straight line" distance from S to F is 10 and the path is shown on the diagram.

However, there are up to three "shortest" path candidates for any given cuboid and the shortest route doesn't always have integer length.

By considering all cuboid rooms with integer dimensions, up to a maximum size of M by M by M, there are exactly 2060 cuboids for which the shortest route has integer length when M=100, and this is the least value of M for which the number of solutions first exceeds two thousand; the number of solutions is 1975 when M=99.

Find the least value of M such that the number of solutions first exceeds one million.

 */
public class Problem86 implements Problem {
    @Override
    public String getAnswer() throws Exception {

        int solutions = 2060;

        //Trick is to flatten the box, and then the distance simply becomes the diagonal in a right triangle.
        //After using pythagorean theorum to find the length of two of the sides, simply come up with
        //the permutations that will make that integer.
        for (int m = 100;;m++) {
            for (int n = 2; n<= (2*m); n++) {
                double sqroot = sqrt(m * m + n * n);
                if (sqroot == (int)sqroot) {
                    if (n <= m)
                        solutions += n/2;
                    else
                        solutions += 1 + (m - (n+1)/2);
                }
            }
            if (solutions > 1000000)
                return Integer.toString(m);
        }
    }
}
