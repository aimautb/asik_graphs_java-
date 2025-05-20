import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Represents a weighted graph using an adjacency list.
 * @param <V> The type of data stored in the vertices.
 */
public class WeightedGraph<V> {
    private final Map<Vertex<V>, Map<Vertex<V>, Double>> adjacencyList;

    /**
     * Initializes an empty weighted graph.
     */
    public WeightedGraph() {
        this.adjacencyList = new HashMap<>();
    }

    /**
     * Adds a vertex to the graph if it does not already exist.
     * @param vertex The vertex to add.
     */
    public void addVertex(Vertex<V> vertex) {
        adjacencyList.putIfAbsent(vertex, new HashMap<>());
    }

    /**
     * Adds a weighted edge between two vertices (undirected by default).
     * @param source The source vertex.
     * @param destination The destination vertex.
     * @param weight The weight of the edge.
     */
    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        addVertex(source);
        addVertex(destination);
        adjacencyList.get(source).put(destination, weight);
        adjacencyList.get(destination).put(source, weight); // Undirected graph
    }

    /**
     * Retrieves the adjacency list of the graph.
     * @return A map representing the graph's adjacency list.
     */
    public Map<Vertex<V>, Map<Vertex<V>, Double>> getAdjacencyList() {
        return adjacencyList;
    }

    /**
     * Gets all vertices in the graph.
     * @return A set of all vertices.
     */
    public Set<Vertex<V>> getVertices() {
        return adjacencyList.keySet();
    }
}