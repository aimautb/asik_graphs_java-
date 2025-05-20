# 📊 Assignment 4 – Graphs: BFS and Dijkstra with Vertex Objects 🌐

This project implements **Breadth-First Search (BFS)** and **Dijkstra’s Algorithm** on an edge-weighted graph using custom `Vertex` objects as nodes, moving beyond primitive types. The goal is to refactor a standard graph model to use robust `Vertex` objects and implement search algorithms that integrate seamlessly with this structure. 🚀

---

# ✨ Features

- 🟥 **Vertex class** for graph nodes
- 🕸️ **WeightedGraph** to represent an edge-weighted graph
- 🔍 **BreadthFirstSearch** for unweighted shortest path (by number of edges)
- ⚖️ **DijkstraSearch** for weighted shortest path (by total cost)
- 🛠️ **Search interface** for consistent search method signatures
- 🖥️ Example usage in the `Main` class (compatible with the original assignment)

---

# 🗂️ Class Overview

## Vertex
Represents a node in the graph.  

**Fields:**  
- `String name` – Label of the vertex  

**Methods:**  
- Constructor  
- `equals()` and `hashCode()` – Ensures proper use in `HashMap` and `HashSet`  
- `toString()` – Provides readable output  

## WeightedGraph
Represents an edge-weighted undirected graph.  

**Key Methods:**  
- `addVertex(Vertex v)` – Adds a vertex to the graph  
- `addEdge(Vertex from, Vertex to, double weight)` – Adds a weighted edge  
- `neighbors(Vertex v)` – Returns adjacent vertices and their weights  

## Search (Interface)
Defines common search methods:  
- `boolean hasPathTo(Vertex v)` – Checks if a path exists  
- `List<Vertex> pathTo(Vertex v)` – Returns the path to a vertex  

## BreadthFirstSearch
Implements the `Search` interface using BFS.  
- Finds the shortest path by number of edges (ignores weights)  

## DijkstraSearch
Implements the `Search` interface using Dijkstra’s algorithm.  
- Finds the shortest path based on total edge weights  

## Main
Builds a sample graph and demonstrates both BFS and Dijkstra algorithms.  
- Compatible with the unchanged `Main` class from the assignment  
- Prints paths and total weights where applicable 📈  

---

# 🚀 Usage

To run the project:  
1. Compile and execute the `Main` class.  
2. The program builds a sample graph and runs both BFS and Dijkstra algorithms.  
3. Results include the paths and total weights (for Dijkstra) displayed in the console.  

**Example Output:**  

BFS Path from A to D: [A, B, D]

Dijkstra Path from A to D: [A, C, D], Total Weight: 5.0


---

# 🤝 Contributing

This project is part of an educational assignment. Contributions are not expected, but feedback is always welcome! 😊 Feel free to share suggestions or insights.

---

# 👨‍💻 Credits
Developed with 💡 by [Your Name].
