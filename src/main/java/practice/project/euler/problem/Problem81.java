package practice.project.euler.problem;

import practice.project.euler.Problem;
import practice.project.euler.util.GeneralUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

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
        Vertex[][] cache = new Vertex[80][];
        populateData("problem81.txt", cache);

        Vertex root = generateGraph(cache);
        computeShortestPaths(root);

        //Get the reference to the end to grab the min distance from
        Vertex end = cache[cache.length -1][cache[cache.length-1].length-1];
        return Long.toString(end.getMinDistance());
    }

    private static Vertex generateGraph(Vertex[][] cache) {
        for (int i = 0;i < cache.length;i++) {
            for (int j = 0; j< cache[i].length;j++) {

                if (i != cache.length - 1)
                    cache[i][j].getEdges().add(cache[i+1][j]);

                if (j != cache[i].length - 1)
                    cache[i][j].getEdges().add(cache[i][j+1]);
            }
        }

        return cache[0][0];
    }

    public static void populateData(String file, Vertex[][] cache) throws IOException {
        BufferedReader reader = GeneralUtil.getResource(file);
        String line;
        int i = 0;
        while ((line = reader.readLine()) != null) {
            String[] strings = line.split(",");
            cache[i] = new Vertex[strings.length];

            for (int j = 0;j< strings.length;j++) {
                cache[i][j] = new Vertex(Integer.parseInt(strings[j]));
            }

            i++;
        }
    }

    public static void computeShortestPaths(Vertex source) {


        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>(11, new Comparator<Vertex>() {
            @Override
            public int compare(Vertex o1, Vertex o2) {
                return o1.getMinDistance() < o2.getMinDistance() ? -1 : (o1.getMinDistance() == o2.getMinDistance() ? 0 : 1);
            }
        });

        source.setMinDistance(source.getWeight());
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Vertex current = vertexQueue.poll();
            for (Vertex checking : current.getEdges()) {
                long distanceThroughU = current.getMinDistance() + checking.getWeight();
                if (distanceThroughU < checking.getMinDistance()) {
                    vertexQueue.remove(checking);
                    checking.setMinDistance(distanceThroughU) ;
                    vertexQueue.add(checking);
                }
            }
        }
    }

    public static class Vertex {
        private List<Vertex> edges = new ArrayList<Vertex>();
        private int weight;
        private long minDistance = Long.MAX_VALUE;

        public Vertex(int weight) {
            this.weight = weight;
        }

        public List<Vertex> getEdges() {
            return edges;
        }

        public int getWeight() {
            return weight;
        }

        public long getMinDistance() {
            return minDistance;
        }

        public void setMinDistance(long minDistance) {
            this.minDistance = minDistance;
        }

        public void reset() {
            minDistance = Long.MAX_VALUE;
            for (Vertex edge : edges)
                if (edge.getMinDistance() != Long.MAX_VALUE)
                    edge.reset();
        }
    }

}
