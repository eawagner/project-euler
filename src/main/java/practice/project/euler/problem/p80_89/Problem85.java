package practice.project.euler.problem.p80_89;

import practice.project.euler.Problem;

import static java.lang.Math.abs;

/*


By counting carefully it can be seen that a rectangular grid measuring 3 by 2 contains eighteen rectangles:

Although there exists no rectangular grid that contains exactly two million rectangles, find the area of the grid with the nearest solution.

 */
public class Problem85 implements Problem {
    @Override
    public String getAnswer() throws Exception {

        int closest = Integer.MAX_VALUE;
        int result = 0;

        //Changed to 80 after solving and finding the solution
        //Originally, limited to first value that satisfied x*(x+1)*2/4
        //which is around 2000, but there is atleast one rectangle below 80.
        for (int x = 1; x< 80; x++) {
            for (int y = 1; y<= x; y++) {

                int diff = abs((x*(x+1)*y*(y+1)/4) - 2000000);

                if (closest > diff) {
                    result = x * y;
                    closest = diff;
                }
            }
        }


        return Integer.toString(result);
    }
}
