import java.util.*;

public class Graph {
    private Map<Integer, List<int[]>> adjList = new HashMap<>();

    public void addEdge(int u, int v, int weight) {
        adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, weight});
        adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[]{u, weight});
    }

    public void dijkstra(int src) {
        TreeSet<int[]> pq = new TreeSet<>(Comparator.comparingInt(a -> a[1]));
        Map<Integer, Integer> dist = new HashMap<>();

        for (int node : adjList.keySet()) {
            dist.put(node, Integer.MAX_VALUE);
        }
        dist.put(src, 0);
        pq.add(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.pollFirst();
            int u = current[0];

            for (int[] neighbor : adjList.getOrDefault(u, new ArrayList<>())) {
                int v = neighbor[0], weight = neighbor[1];
                if (dist.get(u) + weight < dist.get(v)) {
                    pq.remove(new int[]{v, dist.get(v)});
                    dist.put(v, dist.get(u) + weight);
                    pq.add(new int[]{v, dist.get(v)});
                }
            }
        }

        for (int node : dist.keySet()) {
            System.out.println("Distance from " + src + " to " + node + " is " + dist.get(node));
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 1);
        g.addEdge(2, 1, 2);
        g.addEdge(1, 3, 1);
        g.addEdge(2, 3, 5);

        g.dijkstra(0);
    }
}