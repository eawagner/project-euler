package practice.project.euler.problem.p80_89;

import practice.project.euler.Problem;

import static practice.project.euler.problem.p80_89.Problem81.*;

/*
NOTE: This problem is a more challenging version of Problem 81.

The minimal path sum in the 5 by 5 matrix below, by starting in any cell in the left column and finishing in any cell in the right column, and only moving up, down, and right, is indicated in red and bold; the sum is equal to 994.


131	673	234	103	18
201	96	342	965	150
630	803	746	422	111
537	699	497	121	956
805	732	524	37	331


Find the minimal path sum, in matrix.txt (right click and 'Save Link/Target As...'), a 31K text file containing a 80 by 80 matrix, from the left column to the right column.
 */
public class Problem82 implements Problem {
    public String getAnswer() throws Exception {
        Vertex[][] cache = new Vertex[80][];
        populateData("problem82.txt", cache);
        generateGraph(cache);

        long min = Long.MAX_VALUE;

        for (Vertex[] aCache : cache) {
            cache[0][0].reset();
            computeShortestPaths(aCache[0]);

            for (int j = 0; j < aCache.length; j++)
                if (cache[j][cache.length - 1].getMinDistance() < min)
                    min = cache[j][cache.length - 1].getMinDistance();

        }

        return Long.toString(min);
    }

    private static Vertex generateGraph(Vertex[][] cache) {
        for (int i = 0;i < cache.length;i++) {
            for (int j = 0; j< cache[i].length;j++) {
                if (i != 0)
                    cache[i][j].getEdges().add(cache[i-1][j]);
                if (i != cache.length - 1)
                    cache[i][j].getEdges().add(cache[i+1][j]);

                if (j != cache[i].length - 1)
                    cache[i][j].getEdges().add(cache[i][j+1]);
            }
        }

        return cache[0][0];
    }

}
