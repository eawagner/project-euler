package practice.project.euler.util;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class GraphUtil {

    public static void computeShortestPaths(Vertex source, int initialweight) {


        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>(11, new Comparator<Vertex>() {
            @Override
            public int compare(Vertex o1, Vertex o2) {
                return o1.getMinDistance() < o2.getMinDistance() ? -1 : (o1.getMinDistance() == o2.getMinDistance() ? 0 : 1);
            }
        });

        source.setMinDistance(initialweight);
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Vertex current = vertexQueue.poll();
            for (Edge edge : current.getEdges()) {
                Vertex checking = edge.getTarget();
                long distanceThroughU = current.getMinDistance() + edge.getWeight();
                if (distanceThroughU < checking.getMinDistance()) {
                    vertexQueue.remove(checking);
                    checking.setMinDistance(distanceThroughU) ;
                    checking.setPrevious(current);
                    vertexQueue.add(checking);
                }
            }
        }
    }

    public static class Vertex {
        private List<Edge> edges = new ArrayList<Edge>();
        public long minDistance = Long.MAX_VALUE;
        Vertex previous;

        public List<Edge> getEdges() {
            return edges;
        }

        public long getMinDistance() {
            return minDistance;
        }

        public Vertex getPrevious() {
            return previous;
        }

        public void setMinDistance(long minDistance) {
            this.minDistance = minDistance;
        }

        public void setPrevious(Vertex previous) {
            this.previous = previous;
        }

        public void reset() {
            minDistance = Long.MAX_VALUE;
            for (Edge edge : edges)
                if (edge.getTarget().getMinDistance() != Long.MAX_VALUE)
                    edge.getTarget().reset();
        }
    }

    public static class Edge {
        private Vertex target;
        private long weight;

        public Edge(Vertex target, long weight) {
            this.target = target;
            this.weight = weight;
        }

        public Vertex getTarget() {
            return target;
        }

        public long getWeight() {
            return weight;
        }
    }

}
