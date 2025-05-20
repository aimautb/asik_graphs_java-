import java.util.*;

/**
 * Implements Dijkstra's algorithm for finding shortest paths in a weighted graph.
 * @param <V> The type of data stored in the graph vertices.
 */
public class DijkstraSearch<V> extends Search<V> {
    private final Map<Vertex<V>, Double> distTo = new HashMap<>();
    private final Map<Vertex<V>, Vertex<V>> edgeTo = new HashMap<>();

    /**
     * Initializes Dijkstra's algorithm with the graph and starting vertex.
     * @param graph The graph to search.
     * @param start The starting vertex.
     */
    public DijkstraSearch(WeightedGraph<V> graph, Vertex<V> start) {
        super(graph, start);
        dijkstra(start);
    }

    /**
     * Executes Dijkstra's algorithm starting from the specified vertex.
     * @param start The starting vertex.
     */
    private void dijkstra(Vertex<V> start) {
        PriorityQueue<Vertex<V>> pq = new PriorityQueue<>(
                Comparator.comparingDouble(v -> distTo.getOrDefault(v, Double.POSITIVE_INFINITY))
        );

        for (Vertex<V> v : graph.getAdjacencyList().keySet()) {
            distTo.put(v, Double.POSITIVE_INFINITY);
        }
        distTo.put(start, 0.0);
        pq.add(start);

        while (!pq.isEmpty()) {
            Vertex<V> current = pq.poll();
            for (Map.Entry<Vertex<V>, Double> entry : graph.getAdjacencyList().get(current).entrySet()) {
                relax(current, entry.getKey(), entry.getValue(), pq);
            }
        }
    }

    /**
     * Relaxes an edge, updating the shortest path if a better one is found.
     * @param from The source vertex.
     * @param to The destination vertex.
     * @param weight The edge weight.
     * @param pq The priority queue to update.
     */
    private void relax(Vertex<V> from, Vertex<V> to, double weight, PriorityQueue<Vertex<V>> pq) {
        double newDist = distTo.get(from) + weight;
        if (newDist < distTo.get(to)) {
            distTo.put(to, newDist);
            edgeTo.put(to, from);
            pq.remove(to);
            pq.add(to);
        }
    }

    /**
     * Returns the path from the start vertex to the destination.
     * @param destination The target vertex.
     * @return List of vertices in the shortest path.
     */
    @Override
    public List<Vertex<V>> pathTo(Vertex<V> destination) {
        List<Vertex<V>> path = new ArrayList<>();
        if (!edgeTo.containsKey(destination) && destination != start) return path;
        for (Vertex<V> v = destination; v != start; v = edgeTo.get(v)) {
            path.add(v);
        }
        path.add(start);
        Collections.reverse(path);
        return path;
    }

    /**
     * Gets the total weight of the shortest path to the destination.
     * @param destination The target vertex.
     * @return The total weight, or infinity if no path exists.
     */
    public double getPathWeight(Vertex<V> destination) {
        return distTo.getOrDefault(destination, Double.POSITIVE_INFINITY);
    }
}