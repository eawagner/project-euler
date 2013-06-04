package practice.project.euler.problem.p10_19;

import practice.project.euler.Problem;

/*

Starting in the top left corner of a 2×2 grid, there are 6 routes (without backtracking) to the bottom right corner.

How many routes are there through a 20×20 grid?

 */
public class Problem15 implements Problem{
    private static final int CUBE_SIZE= 20;

    public String getAnswer() {
        //keep cache to prevent redundant computations of paths.
        long[][] cache = new long[CUBE_SIZE+1][CUBE_SIZE+1];

        return Long.toString(getNumPaths(CUBE_SIZE,CUBE_SIZE, cache));
    }

    private static long getNumPaths(int x, int y, long[][] cache) {
        if (x == 0 && y == 0)
            return 1;
        if (cache[x][y]>0)
            return cache[x][y];

        long numPaths = 0;
        if (x>0)
            numPaths += getNumPaths(x-1,y, cache);
        if (y>0)
            numPaths += getNumPaths(x,y-1,cache);

        cache[x][y]=numPaths;
        return numPaths;

    }
}
