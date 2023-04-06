/**
 * @author BIll Stein #3714982
 */

 import java.util.*;

public class OnePointFour {
    
    // Function to find the minimum spanning tree of a graph
    public static void primMST(int[][] graph, char[] labels) {
        int numVertices = graph.length;
        int[] parent = new int[numVertices]; // To store the parent node of each vertex in the MST
        int[] key = new int[numVertices]; // To store the key (minimum weight) of each vertex
        boolean[] visited = new boolean[numVertices]; // To track which vertices have been visited
        
        // Initialize all keys to infinity and visited to false
        for (int i = 0; i < numVertices; i++) {
            key[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        
        // Set the first vertex as the starting vertex and key to 0
        key[0] = 0;
        parent[0] = -1; // The root node has no parent
        
        // Loop through all vertices
        for (int i = 0; i < numVertices - 1; i++) {
            // Find the vertex with the minimum key that has not been visited
            int minIndex = -1;
            int minKey = Integer.MAX_VALUE;
            for (int j = 0; j < numVertices; j++) {
                if (!visited[j] && key[j] < minKey) {
                    minIndex = j;
                    minKey = key[j];
                }
            }
            
            // Mark the vertex as visited
            visited[minIndex] = true;
            
            // Update the key and parent of all adjacent vertices that have not been visited
            for (int j = 0; j < numVertices; j++) {
                if (graph[minIndex][j] != 0 && !visited[j] && graph[minIndex][j] < key[j]) {
                    parent[j] = minIndex;
                    key[j] = graph[minIndex][j];
                }
            }
        }
        
        // Print the MST
        System.out.println("Minimum Spanning Tree:");
        for (int i = 1; i < numVertices; i++) {
            System.out.println(labels[parent[i]] + " - " + labels[i] + " \t" + graph[parent[i]][i]);
        }
    }
    
    public static void main(String[] args) {
        int[][] graph = {
            {0, 2, 3, 0},
            {2, 0, 1, 4},
            {3, 1, 0, 5},
            {0, 4, 5, 0}
        };
        
        char[] labels = {'A', 'B', 'C', 'D'};
        
        primMST(graph, labels);
    }
}

 