import java.util.*;

public class OnePointOne {
    private ArrayList<ArrayList<String>> edgeList;

    public OnePointOne() {
        edgeList = new ArrayList<>();
    }

    public void addVertex(String vertex) {
        // Add a new vertex to the graph
        edgeList.add(new ArrayList<>(Arrays.asList(vertex)));
    }

    public void addEdge(String start, String end) {
        // Add a new edge to the graph
        ArrayList<String> edge = new ArrayList<>(Arrays.asList(end, start));
        ArrayList<String> backEdge = new ArrayList<>(Arrays.asList(start, end));
        edgeList.add(edge);
        edgeList.add(backEdge);
    }

    public int getVertexCount() {
        // Returns the number of vertices in the graph
        Set<String> vertices = new HashSet<>();
        for (ArrayList<String> edge : edgeList) {
            vertices.add(edge.get(0));
            vertices.add(edge.get(1));
        }
        return vertices.size();
    }

    public int getEdgeCount() {
        // Returns the number of edges in the graph
        return edgeList.size() / 2;
    }

    public int getIndegree(String vertex) {
        // Returns the indegree of a vertex
        int indegree = 0;
        for (ArrayList<String> edge : edgeList) {
            if (edge.get(0).equals(vertex)) {
                indegree++;
            }
        }
        return indegree;
    }

    public int getOutdegree(String vertex) {
        // Returns the outdegree of a vertex
        int outdegree = 0;
        for (ArrayList<String> edge : edgeList) {
            if (edge.get(1).equals(vertex)) {
                outdegree++;
            }
        }
        return outdegree;
    }

    public void removeVertex(String vertex) {
        // Remove a vertex from the graph
        ArrayList<ArrayList<String>> edgesToRemove = new ArrayList<>();
        for (ArrayList<String> edge : edgeList) {
            if (edge.contains(vertex)) {
                edgesToRemove.add(edge);
            }
        }
        for (ArrayList<String> edge : edgesToRemove) {
            edgeList.remove(edge);
        }
    }

    public void removeEdge(String start, String end) {
        // Remove an edge between two vertices
        ArrayList<ArrayList<String>> edgesToRemove = new ArrayList<>();
        for (ArrayList<String> edge : edgeList) {
            if (edge.get(0).equals(end) && edge.get(1).equals(start)) {
                edgesToRemove.add(edge);
            } else if (edge.get(0).equals(start) && edge.get(1).equals(end)) {
                edgesToRemove.add(edge);
            }
        }
        for (ArrayList<String> edge : edgesToRemove) {
            edgeList.remove(edge);
        }
    }

    public static void main(String[] args) {
        OnePointOne graph = new OnePointOne();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("C", "A");
        System.out.println("Number of vertices: " + graph.getVertexCount());
        System.out.println("Number of edges: " + graph.getEdgeCount());
        System.out.println("Indegree of A: " + graph.getIndegree("A"));
        System.out.println("Outdegree of A: " + graph.getOutdegree("A"));
        graph.removeVertex("B");
        System.out.println("Number of vertices after removing B: " + graph.getVertexCount());
    }
}
