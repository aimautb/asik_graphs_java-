import java.util.List;

/**
 * Abstract base class for graph search algorithms.
 * @param <V> The type of data stored in the vertices.
 */
public abstract class Search<V> {
    protected final WeightedGraph<V> graph;
    protected final Vertex<V> start;

    /**
     * Initializes the search with a graph and a starting vertex.
     * @param graph The graph to search.
     * @param start The starting vertex for the search.
     */
    public Search(WeightedGraph<V> graph, Vertex<V> start) {
        this.graph = graph;
        this.start = start;
    }

    /**
     * Returns the path from the start vertex to the destination.
     * @param destination The target vertex.
     * @return A list of vertices representing the path.
     */
    public abstract List<Vertex<V>> pathTo(Vertex<V> destination);
}