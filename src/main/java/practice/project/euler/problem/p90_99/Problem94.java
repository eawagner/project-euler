package practice.project.euler.problem.p90_99;

import practice.project.euler.Problem;

import static practice.project.euler.util.GeneralUtil.isSquare;

/*

It is easily proved that no equilateral triangle exists with integral length sides and integral area. However, the almost equilateral triangle 5-5-6 has an area of 12 square units.

We shall define an almost equilateral triangle to be a triangle for which two sides are equal and the third differs by no more than one unit.

Find the sum of the perimeters of all almost equilateral triangles with integral side lengths and area and whose perimeters do not exceed one billion (1,000,000,000).

 */
public class Problem94 implements Problem {

    @Override
    public String getAnswer() throws Exception {
        /*TODO Need to optimize this more */

        int max = 1000000000 / 3;
        long total = 0;
        //To find the area, cut triangle in half down the middle and mult height by half width of triangle.
        //The triangle can when cut down the middle can be seen as a diagonally cut rectangle.
        //To make integral areas, this means half the width needs to be whole (so whole width is even,
        // so the two sides that are equal must be odd. l
        for (long i = 3; i <=max ; i+=2) {
            long square = i * i;
            long half = i /2;
            if (isSquare(square - (half * half))) {
                long perimeter = 3L * i - 1;
                total += perimeter;
                continue;
            }

            half = half + 1;
            if (isSquare(square - (half * half))) {
                long perimeter = 3L * i + 1;
                total += perimeter;
            }
        }

        return Long.toString(total);
    }
}
