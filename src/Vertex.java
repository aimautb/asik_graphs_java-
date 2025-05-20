import java.util.HashMap;
import java.util.Map;

/**
 * Represents a vertex in a weighted graph.
 * @param <V> The type of data stored in the vertex.
 */
public class Vertex<V> {
    private final V data;
    private final Map<Vertex<V>, Double> adjacentVertices;

    /**
     * Initializes a vertex with the specified data.
     * @param data The data to store in the vertex.
     */
    public Vertex(V data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }

    /**
     * Adds an adjacent vertex with a specified weight.
     * @param destination The adjacent vertex to add.
     * @param weight The weight of the edge to the adjacent vertex.
     */
    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight);
    }

    /**
     * Retrieves the map of adjacent vertices and their weights.
     * @return A map of adjacent vertices to their edge weights.
     */
    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }

    /**
     * Gets the data stored in this vertex.
     * @return The data of the vertex.
     */
    public V getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Vertex{data=" + data + "}";
    }
}