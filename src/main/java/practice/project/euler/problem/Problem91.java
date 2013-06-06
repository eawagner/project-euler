package practice.project.euler.problem;


import practice.project.euler.Problem;

import static java.lang.Math.min;
import static practice.project.euler.util.FactorUtil.gcd;

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
