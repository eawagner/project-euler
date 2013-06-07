package practice.project.euler.problem;


import practice.project.euler.Problem;

import static java.lang.Math.min;
import static practice.project.euler.util.FactorUtil.gcd;

/*

The points P (x1, y1) and Q (x2, y2) are plotted at integer co-ordinates and are joined to the origin, O(0,0), to form ΔOPQ.

There are exactly fourteen triangles containing a right angle that can be formed when each co-ordinate lies between 0 and 2 inclusive; that is,
0 ≤ x1, y1, x2, y2 ≤ 2.

Given that 0 ≤ x1, y1, x2, y2 ≤ 50, how many right triangles can be formed?

 */
public class Problem91 implements Problem {
    @Override
    public String getAnswer() throws Exception {

        int size = 50;
        int result = size * size * 3; //Number of triangles with a horizontal and vertical line

        //Now calculate all instances where the right angle isn't at 0,0.
        //Where x and y represent the location of the right angle and we only measure downwards
        //triangles, doubling to account for upwards triangles.
        for (int x = 1; x <= size; x++) {
            for (int y = 1; y <= size; y++) {
                long tmp = gcd(x, y);
                result += min(y * tmp / x, (size - x) * tmp / y) * 2;
            }
        }

        return Integer.toString(result);
    }
}
