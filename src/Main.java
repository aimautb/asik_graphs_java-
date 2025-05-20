import java.util.List;

/**
 * Demonstrates the usage of BFS and Dijkstra's algorithm on a weighted graph using MyGraph.
 */
public class Main {
    public static void main(String[] args) {
        // Create a directed graph
        MyGraph<String> graph = new MyGraph<>(true);

        // Initialize vertices
        Vertex<String> astana = new Vertex<>("Astana");
        Vertex<String> karaganda = new Vertex<>("Karaganda");
        Vertex<String> balkash = new Vertex<>("Balkash");
        Vertex<String> almaty = new Vertex<>("Almaty");
        Vertex<String> pavlodar = new Vertex<>("Pavlodar");
        Vertex<String> semey = new Vertex<>("Semey");
        Vertex<String> taldykorgan = new Vertex<>("Taldykorgan");
        Vertex<String> kokshetau = new Vertex<>("Kokshetau");
        Vertex<String> taraz = new Vertex<>("Taraz");

        // Add edges with weights
        graph.addEdge(astana, karaganda, 100.0);
        graph.addEdge(karaganda, balkash, 150.0);
        graph.addEdge(balkash, almaty, 200.0);
        graph.addEdge(balkash, taraz, 180.0);
        graph.addEdge(almaty, taraz, 120.0);
        graph.addEdge(almaty, taldykorgan, 250.0);
        graph.addEdge(taldykorgan, semey, 170.0);
        graph.addEdge(astana, pavlodar, 110.0);
        graph.addEdge(pavlodar, semey, 160.0);
        graph.addEdge(astana, kokshetau, 90.0);

        // Display graph structure
        System.out.println("=== Graph Structure ===");
        graph.displayGraph();

        // Demonstrate BFS
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph, astana);
        List<Vertex<String>> bfsPath = bfs.pathTo(semey);
        System.out.println("\n=== BFS from Astana to Semey ===");
        printBFSResults(bfs, bfsPath);

        // Demonstrate Dijkstra's algorithm
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph, astana);
        List<Vertex<String>> dijkstraPath = dijkstra.pathTo(semey);
        System.out.println("\n=== Dijkstra from Astana to Semey ===");
        printDijkstraResults(dijkstra, dijkstraPath);
    }

    /**
     * Prints the results of the BFS search.
     * @param bfs The BFS instance.
     * @param path The path found by BFS.
     */
    private static void printBFSResults(BreadthFirstSearch<String> bfs, List<Vertex<String>> path) {
        System.out.println("BFS Path: " + path);
        System.out.println("Edge count: " + (path.isEmpty() ? -1 : path.size() - 1));
    }

    /**
     * Prints the results of Dijkstra's algorithm.
     * @param dijkstra The Dijkstra instance.
     * @param path The path found by Dijkstra.
     */
    private static void printDijkstraResults(DijkstraSearch<String> dijkstra, List<Vertex<String>> path) {
        if (path.isEmpty()) {
            System.out.println("No path found.");
            return;
        }
        System.out.println("Dijkstra Path: " + path);
        System.out.printf("Total distance: %.1f km\n", dijkstra.getPathWeight(path.get(path.size() - 1)));
        System.out.print("Path details: ");
        for (int i = 0; i < path.size() - 1; i++) {
            Vertex<String> from = path.get(i);
            Vertex<String> to = path.get(i + 1);
            double weight = from.getAdjacentVertices().get(to);
            System.out.printf("%s -> %s (%.1f) | ", from.getData(), to.getData(), weight);
        }
        System.out.println();
    }
}