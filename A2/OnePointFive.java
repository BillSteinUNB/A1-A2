import java.util.*; 

 

class OnePointFive { 

    static class Edge implements Comparable<Edge> { 

        int src, dest, weight; 

        

        public int compareTo(Edge compareEdge) { 

            return this.weight - compareEdge.weight; 

        } 

    }; 

    

    static class subset { 

        int parent, rank; 

    }; 

    

    static int find(subset subsets[], int i) { 

        if (subsets[i].parent != i) 

            subsets[i].parent = find(subsets, subsets[i].parent); 

        return subsets[i].parent; 

    } 

    

    static void Union(subset subsets[], int x, int y) { 

        int xroot = find(subsets, x); 

        int yroot = find(subsets, y); 

        

        if (subsets[xroot].rank < subsets[yroot].rank) 

            subsets[xroot].parent = yroot; 

        else if (subsets[xroot].rank > subsets[yroot].rank) 

            subsets[yroot].parent = xroot; 

        else { 

            subsets[yroot].parent = xroot; 

            subsets[xroot].rank++; 

        } 

    } 

    

    static void KruskalMST(int V, int E, Edge edge[]) { 

        Edge result[] = new Edge[V]; 

        int e = 0; 

        int i = 0; 

        for (i = 0; i < V; i++) 

            result[i] = new Edge(); 

        

        Arrays.sort(edge); 

        

        subset subsets[] = new subset[V]; 

        for (i = 0; i < V; i++) 

            subsets[i] = new subset(); 

        

        for (int v = 0; v < V; v++) { 

            subsets[v].parent = v; 

            subsets[v].rank = 0; 

        } 

        

        i = 0; 

        

        while (e < V - 1) { 

            Edge next_edge = new Edge(); 

            next_edge = edge[i++]; 

            

            int x = find(subsets, next_edge.src); 

            int y = find(subsets, next_edge.dest); 

            

            if (x != y) { 

                result[e++] = next_edge; 

                Union(subsets, x, y); 

            } 

        } 

        

        System.out.println("Edges in the minimum spanning tree:"); 

        int minimumCost = 0; 

        for (i = 0; i < e; i++) { 

            System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight); 

            minimumCost += result[i].weight; 

        } 

        System.out.println("Minimum cost of the minimum spanning tree: " + minimumCost); 

    } 

    

    public static void main(String[] args) { 

        Scanner sc = new Scanner(System.in); 

        

        System.out.print("Enter the number of vertices: "); 

        int V = sc.nextInt(); 

        

        System.out.print("Enter the number of edges: "); 

        int E = sc.nextInt(); 

        

        Edge edge[] = new Edge[E]; 

        for (int i = 0; i < E; i++) 

            edge[i] = new Edge(); 

        

        for (int i = 0; i < E; i++) { 

            System.out.println("Enter the details of edge " + (i+1) + ":"); 

            System.out.print("Source vertex: "); 

            edge[i].src = sc.nextInt(); 

            System.out.print("Destination vertex: "); 

            edge[i].dest = sc.nextInt(); 

            System.out.print("Weight: "); 

            edge[i].weight = sc.nextInt(); 

        } 

        

        KruskalMST(V, E, edge); 

    } 

} 