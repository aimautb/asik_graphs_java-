import java.util.*;

/**
 * Custom implementation of a weighted graph supporting directed and undirected modes.
 * Extends WeightedGraph to inherit basic graph functionality.
 * @param <V> The type of data stored in vertices.
 */
public class MyGraph<V> extends WeightedGraph<V> {
    private final Map<Vertex<V>, Set<Edge<V>>> adjacencyMap = new HashMap<>();
    private final boolean isDirected;

    /**
     * Creates an undirected graph by default.
     */
    public MyGraph() {
        this(false);
    }

    /**
     * Creates a graph with specified directionality.
     * @param isDirected True for directed graph, false for undirected.
     */
    public MyGraph(boolean isDirected) {
        this.isDirected = isDirected;
    }

    /**
     * Adds a vertex to the graph if not already present.
     * @param vertex The vertex to add.
     */
    @Override
    public void addVertex(Vertex<V> vertex) {
        super.addVertex(vertex);
        adjacencyMap.putIfAbsent(vertex, new LinkedHashSet<>());
    }

    /**
     * Adds an edge with default weight 1.0 between vertices.
     * @param source The source vertex.
     * @param destination The destination vertex.
     */
    public void addEdge(Vertex<V> source, Vertex<V> destination) {
        addEdge(source, destination, 1.0);
    }

    /**
     * Adds a weighted edge between vertices, updating weight if edge exists.
     * @param source The source vertex.
     * @param destination The destination vertex.
     * @param weight The edge weight.
     */
    @Override
    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        addVertex(source);
        addVertex(destination);

        updateOrCreateEdge(source, destination, weight);
        if (!isDirected) {
            updateOrCreateEdge(destination, source, weight);
        }
    }

    /**
     * Helper method to update or create an edge with the specified weight.
     * @param a The source vertex.
     * @param b The destination vertex.
     * @param weight The edge weight.
     */
    private void updateOrCreateEdge(Vertex<V> a, Vertex<V> b, double weight) {
        Set<Edge<V>> edges = adjacencyMap.get(a);
        edges.removeIf(e -> e.getDestination().equals(b));
        edges.add(new Edge<>(a, b, weight));
        a.getAdjacentVertices().put(b, weight);
    }

    /**
     * Updates the weight of an existing edge between vertices.
     * @param source The source vertex.
     * @param destination The destination vertex.
     * @param newWeight The new edge weight.
     * @throws IllegalArgumentException If the edge does not exist.
     */
    public void setWeight(Vertex<V> source, Vertex<V> destination, double newWeight) {
        if (!adjacencyMap.containsKey(source) || !adjacencyMap.containsKey(destination)) {
            throw new IllegalArgumentException("Vertices not in graph");
        }
        updateEdgeWeight(source, destination, newWeight);
        if (!isDirected) {
            updateEdgeWeight(destination, source, newWeight);
        }
    }

    /**
     * Helper method to update the weight of an existing edge.
     * @param a The source vertex.
     * @param b The destination vertex.
     * @param weight The new weight.
     * @throws IllegalArgumentException If the edge is not found.
     */
    private void updateEdgeWeight(Vertex<V> a, Vertex<V> b, double weight) {
        adjacencyMap.get(a).stream()
                .filter(e -> e.getDestination().equals(b))
                .findFirst()
                .ifPresentOrElse(
                        e -> {
                            e.setWeight(weight);
                            a.getAdjacentVertices().put(b, weight);
                        },
                        () -> { throw new IllegalArgumentException("Edge not found"); }
                );
    }

    /**
     * Gets the adjacency list with weights for a specific vertex.
     * @param vertex The vertex to check.
     * @return A map of adjacent vertices and their weights.
     */
    public Map<Vertex<V>, Double> getAdjacencyList(Vertex<V> vertex) {
        return new LinkedHashMap<>(vertex.getAdjacentVertices());
    }

    /**
     * Returns all vertices in the graph.
     * @return An unmodifiable set of vertices.
     */
    @Override
    public Set<Vertex<V>> getVertices() {
        return Collections.unmodifiableSet(adjacencyMap.keySet());
    }

    /**
     * Displays the graph structure in a readable format.
     */
    public void displayGraph() {
        adjacencyMap.forEach((vertex, edges) -> {
            System.out.print(vertex.getData() + " -> ");
            edges.forEach(e -> System.out.printf(
                    "%s (%.1f) ",
                    e.getDestination().getData(),
                    e.getWeight()
            ));
            System.out.println();
        });
    }

    /**
     * Internal class representing an edge in the graph.
     * @param <V> The type of data stored in vertices.
     */
    private static class Edge<V> {
        private final Vertex<V> source;
        private final Vertex<V> destination;
        private double weight;

        /**
         * Creates an edge with specified source, destination, and weight.
         * @param source The source vertex.
         * @param destination The destination vertex.
         * @param weight The edge weight.
         */
        public Edge(Vertex<V> source, Vertex<V> destination, double weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        /**
         * Gets the source vertex of the edge.
         * @return The source vertex.
         */
        public Vertex<V> getSource() { return source; }

        /**
         * Gets the destination vertex of the edge.
         * @return The destination vertex.
         */
        public Vertex<V> getDestination() { return destination; }

        /**
         * Gets the weight of the edge.
         * @return The edge weight.
         */
        public double getWeight() { return weight; }

        /**
         * Sets the weight of the edge.
         * @param weight The new weight.
         */
        public void setWeight(double weight) { this.weight = weight; }
    }
}