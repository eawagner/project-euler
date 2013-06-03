package practice.project.euler.problem;

import practice.project.euler.Problem;
import practice.project.euler.util.GeneralUtil;

import java.io.BufferedReader;
import java.io.IOException;

import static practice.project.euler.util.GraphUtil.*;

/*
In the 5 by 5 matrix below, the minimal path sum from the top left to the bottom right, by only moving to the right and down, is indicated in bold red and is equal to 2427.


131	673	234	103	18
201	96	342	965	150
630	803	746	422	111
537	699	497	121	956
805	732	524	37	331


Find the minimal path sum, in matrix.txt (right click and 'Save Link/Target As...'), a 31K text file containing a 80 by 80 matrix, from the top left to the bottom right by only moving right and down.

 */
public class Problem81 implements Problem{
    public String getAnswer() throws Exception {
        int[][] matrix = new int[80][];
        Vertex[][] cache = new Vertex[80][];
        populateData("problem81.txt", matrix, cache);

        Vertex root = generateGraph(matrix, cache);
        computeShortestPaths(root, matrix[0][0]);

        //Get the reference to the end to grab the min distance from
        Vertex end = cache[cache.length -1][cache[cache.length-1].length-1];
        return Long.toString(end.getMinDistance());
    }

    public static void populateData(String file, int[][] matrix, Vertex[][] cache) throws IOException {
        BufferedReader reader = GeneralUtil.getResource(file);
        String line;
        int i = 0;
        while ((line = reader.readLine()) != null) {
            String[] strings = line.split(",");
            matrix[i] = new int[strings.length];
            cache[i] = new Vertex[strings.length];

            for (int j = 0;j< strings.length;j++) {
                matrix[i][j] = Integer.parseInt(strings[j]);
                cache[i][j] = new Vertex();
            }

            i++;
        }
    }

    private static Vertex generateGraph(int[][] matrix, Vertex[][] cache) {
        for (int i = 0;i < matrix.length;i++) {
            for (int j = 0; j< matrix[i].length;j++) {

                if (i != matrix.length - 1)
                    cache[i][j].getEdges().add(new Edge(cache[i+1][j], matrix[i+1][j]));

                if (j != matrix[i].length - 1)
                    cache[i][j].getEdges().add(new Edge(cache[i][j+1], matrix[i][j+1]));
            }
        }

        return cache[0][0];
    }

}
