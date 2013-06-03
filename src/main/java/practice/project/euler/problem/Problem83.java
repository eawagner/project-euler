package practice.project.euler.problem;

import practice.project.euler.Problem;

import static practice.project.euler.problem.Problem81.populateData;
import static practice.project.euler.util.GraphUtil.*;

/*
NOTE: This problem is a significantly more challenging version of Problem 81.

In the 5 by 5 matrix below, the minimal path sum from the top left to the bottom right, by moving left, right, up, and down, is indicated in bold red and is equal to 2297.


131	673	234	103	18
201	96	342	965	150
630	803	746	422	111
537	699	497	121	956
805	732	524	37	331


Find the minimal path sum, in matrix.txt (right click and 'Save Link/Target As...'), a 31K text file containing a 80 by 80 matrix, from the top left to the bottom right by moving left, right, up, and down.
 */
public class Problem83 implements Problem {
    public String getAnswer() throws Exception {
        int[][] matrix = new int[80][];
        Vertex[][] cache = new Vertex[80][];
        populateData("problem82.txt", matrix, cache);

        generateGraph(matrix, cache);

        computeShortestPaths(cache[0][0], matrix[0][0]);

        //Get the reference to the end to grab the min distance from
        Vertex end = cache[cache.length -1][cache[cache.length-1].length-1];

        return Long.toString(end.getMinDistance());
    }

    private static Vertex generateGraph(int[][] matrix, Vertex[][] cache) {
        for (int i = 0;i < matrix.length;i++) {
            for (int j = 0; j< matrix[i].length;j++) {
                if (i != 0)
                    cache[i][j].getEdges().add(new Edge(cache[i-1][j], matrix[i-1][j]));
                if (i != matrix.length - 1)
                    cache[i][j].getEdges().add(new Edge(cache[i+1][j], matrix[i+1][j]));
                if (j != 0)
                    cache[i][j].getEdges().add(new Edge(cache[i][j-1], matrix[i][j-1]));
                if (j != matrix[i].length - 1)
                    cache[i][j].getEdges().add(new Edge(cache[i][j+1], matrix[i][j+1]));
            }
        }

        return cache[0][0];
    }
}