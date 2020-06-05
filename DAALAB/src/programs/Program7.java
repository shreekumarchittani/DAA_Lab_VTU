package programs;

import java.util.Scanner;

public class Program7 {

	//final static int 100 = 20;
	final static int infinity = 9999;
	 static final int V = 9;
	static int n;		// No. of vertices of G
	static int a[][];	// Cost matrix
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		ReadMatrix();
		int s = 0; 		// starting vertex
		System.out.println("Enter starting vertex: ");
		s = scan.nextInt();
		dijkstra(a,s);  	// find shortest path
	}

	static void ReadMatrix() {
		a = new int[100][100];
		System.out.println("Enter the number of vertices:");
		n = scan.nextInt();
		System.out.println("Enter the cost adjacency matrix:");
		for (int i = 0; i <n; i++)
			for (int j = 0; j < n; j++)
				a[i][j] = scan.nextInt();
	}
	
	static int minDistance(int dist[], Boolean sptSet[]) 
    { 
        // Initialize min value 
        int min = Integer.MAX_VALUE, min_index = -1; 
  
        for (int v = 0; v < n; v++) 
            if (sptSet[v] == false && dist[v] <= min) { 
                min = dist[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 
	
	
	static void printSolution(int dist[]) 
    { 
        System.out.println("Vertex \t\t Distance from Source"); 
        for (int i = 0; i < n; i++) 
            System.out.println(i + " \t\t " + dist[i]); 
    } 
	
	
	

	static void dijkstra(int graph[][], int src) 
    { 
        int dist[] = new int[n]; // The output array. dist[i] will hold 
        // the shortest distance from src to i 
  
        // sptSet[i] will true if vertex i is included in shortest 
        // path tree or shortest distance from src to i is finalized 
        Boolean sptSet[] = new Boolean[n]; 
  
        // Initialize all distances as INFINITE and stpSet[] as false 
        for (int i = 0; i < n; i++) { 
            dist[i] = Integer.MAX_VALUE; 
            sptSet[i] = false; 
        } 
  
        // Distance of source vertex from itself is always 0 
        dist[src] = 0; 
  
        // Find shortest path for all vertices 
        for (int count = 0; count < n - 1; count++) { 
            // Pick the minimum distance vertex from the set of vertices 
            // not yet processed. u is always equal to src in first 
            // iteration. 
            int u = minDistance(dist, sptSet); 
  
            // Mark the picked vertex as processed 
            sptSet[u] = true; 
  
            // Update dist value of the adjacent vertices of the 
            // picked vertex. 
            for (int v = 0; v < n; v++) 
  
                // Update dist[v] only if is not in sptSet, there is an 
                // edge from u to v, and total weight of path from src to 
                // v through u is smaller than current value of dist[v] 
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) 
                    dist[v] = dist[u] + graph[u][v]; 
        } 
  
        // print the constructed distance array 
        printSolution(dist); 
    } 
}

