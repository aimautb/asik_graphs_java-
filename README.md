Assignment 4 – Graphs: BFS and Dijkstra with Vertex Objects
This project implements Breadth-First Search (BFS) and Dijkstra’s Algorithm on an edge-weighted graph using custom Vertex objects instead of primitive types. The objective is to refactor a typical graph model to use full-fledged Vertex objects as graph nodes and implement search algorithms that work seamlessly with this structure.
Features

Vertex class for graph nodes
WeightedGraph to represent an edge-weighted graph
BreadthFirstSearch for unweighted shortest path (by number of edges)
DijkstraSearch for weighted shortest path (by total cost)
Common Search interface for both search types
Example usage in Main class (compatible with the original assignment)

Class Overview

VertexRepresents a node in the graph.  

Fields:  
String name – label of the vertex


Methods:  
Constructor  
equals() and hashCode() – to allow correct use in HashMap and HashSet  
toString() – for readable output




WeightedGraphRepresents an edge-weighted undirected graph.  

Key methods:  
addVertex(Vertex v)  
addEdge(Vertex from, Vertex to, double weight)  
neighbors(Vertex v) – returns adjacent vertices and weights




Search (interface)Defines the common search methods:  

boolean hasPathTo(Vertex v)  
List<Vertex> pathTo(Vertex v)




BreadthFirstSearchImplements the Search interface using BFS.  

Finds the shortest path in number of edges (ignores weights)


DijkstraSearchImplements the Search interface using Dijkstra’s algorithm.  

Finds the shortest path based on total edge weights


MainBuilds a sample graph and demonstrates both BFS and Dijkstra algorithms.  

Compatible with the unchanged Main class from the assignment  
Prints path and total weight where applicable



Usage
To run the project, compile and execute the Main class. This will build a sample graph and demonstrate the BFS and Dijkstra algorithms, printing the paths and total weights where applicable.
Contributing
This project is part of an educational assignment. Contributions are not expected, but feedback is welcome.
