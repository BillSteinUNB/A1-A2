import java.util.*;

public class OnePointTwo {
    
    public static List<Character> bfsPath(Map<Character, List<Character>> graph, char start, char end) {
        // Keep track of visited nodes and the path to each node
        Set<Character> visited = new HashSet<>();
        Map<Character, List<Character>> path = new HashMap<>();
        path.put(start, new ArrayList<>(Arrays.asList(start)));
        
        // Create a queue for BFS
        Queue<Character> queue = new LinkedList<>();
        queue.add(start);
        
        while (!queue.isEmpty()) {
            char curr = queue.poll();
            visited.add(curr);
            
            // Check if we've reached the end node
            if (curr == end) {
                return path.get(end);
            }
            
            // Traverse all the neighbors of the current node
            for (char neighbor : graph.get(curr)) {
                if (!visited.contains(neighbor)) {
                    // Add the neighbor to the visited set and the path map
                    visited.add(neighbor);
                    List<Character> newPath = new ArrayList<>(path.get(curr));
                    newPath.add(neighbor);
                    path.put(neighbor, newPath);
                    
                    // Add the neighbor to the queue for BFS
                    queue.add(neighbor);
                }
            }
        }
        
        // If we haven't found a path to the end node, return null
        return null;
    }
    
    public static void main(String[] args) {
        // Example graph
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('A', Arrays.asList('B', 'D'));
        graph.put('B', Arrays.asList('A', 'C', 'D'));
        graph.put('C', Arrays.asList('E', 'D', 'B'));
        graph.put('D', Arrays.asList('B', 'C', 'E', 'F'));
        graph.put('E', Arrays.asList('D', 'C'));
        graph.put('F', Arrays.asList('D'));
        
        // Test the bfsPath function
        System.out.println("Testing BFS algo for 2:");
        List<Character> path = bfsPath(graph, 'A', 'F');
        System.out.println(path); // Output: [A, D, C, G]
    }
}
