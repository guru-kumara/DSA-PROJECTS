# Graph Shortest Path using Dijkstra's Algorithm in Java 🔗📏

This project implements a **weighted undirected graph** and uses **Dijkstra's Algorithm** to compute the **shortest paths** from a source node to all other nodes. It leverages **Java collections like `HashMap`, `TreeSet`, and lists** to simulate graph traversal efficiently.

---

## ✅ Features

- Undirected weighted graph using adjacency list
- Implements **Dijkstra’s Algorithm** using a `TreeSet` (acts like a priority queue)
- Supports custom graph input using `addEdge(u, v, weight)`
- Prints shortest distances from source node to all other nodes

---

## 🧠 Algorithms & Concepts Used

- Dijkstra’s Algorithm (Greedy approach)
- Java TreeSet for priority queue behavior
- HashMap and List to store adjacency list
- Graph Representation
- Time Complexity: O((V + E) log V)

---

## 📁 File Structure

```
DSA-GRAPH-DIJKSTRA/
├── Graph.java
└── README.md


---

## 💡 Sample Graph

The graph used in this code is:


### Edges:
- 0 ↔ 1 (weight 4)  
- 0 ↔ 2 (weight 1)  
- 2 ↔ 1 (weight 2)  
- 1 ↔ 3 (weight 1)  
- 2 ↔ 3 (weight 5)  

---

## 🧪 Sample Output

Distance from 0 to 0 is 0
Distance from 0 to 1 is 3
Distance from 0 to 2 is 1
Distance from 0 to 3 is 4


---

## 🚀 How to Run

### 🧑‍💻 Compile and Run via Terminal

```bash
javac Graph.java
java Graph

⭐ Like this project?
Give it a ⭐ on GitHub

Try adding more algorithms to the graph

Connect with me on LinkedIn to share your DSA journey!
