package programs;

import java.util.Scanner;

public class Program6a {
	
	static final int MAX = 20; // max. no. of objects
	static int wt[]; 	// weights 0 to n-1
	static int val[]; 	// profits 0 to n-1
	static int n; 		// no. of objects
	static int W; 		// capacity of Knapsack
	static int V[][]; 	// DP solution process - table
	static int Keep[][]; // to get objects in optimal solution

	public static void main(String args[]) {

		wt = new int[100];
		val = new int[100];
		V = new int [100][100];
		Keep = new int[100][100];
		int optsoln;
		ReadObjects();
		for (int i = 0; i <= W; i++)
			V[0][i] = 0;
		for (int i = 0; i <= n; i++)
			V[i][0] = 0;
		optsoln = Knapsack();
		System.out.println("Optimal solution = " + optsoln);
	}

	static int Knapsack() {
		int r; // remaining Knapsack capacity
		for (int i = 1; i <= n; i++)
			for (int j = 0; j <= W; j++)
				if ((wt[i] <= j) && (val[i] + V[i - 1][j - wt[i]] > V[i - 1][j])) {
					V[i][j] = val[i] + V[i - 1][j - wt[i]];
					Keep[i][j] = 1;
				} else {
					V[i][j] = V[i - 1][j];
					Keep[i][j] = 0;
				}

		// Find the objects included in the Knapsack
		r = W;
		System.out.println("Items = ");
		for (int i = n; i > 0; i--) // start from Keep[n,M]
			if (Keep[i][r] == 1) {
				System.out.print(i + " ");
				r = r - wt[i];
			}
		System.out.println();
		return V[n][W];
	}

	static void ReadObjects() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Knapsack Problem - Dynamic Programming Solution: ");
		System.out.println("Enter the max capacity of knapsack: ");
		W = scanner.nextInt();
		System.out.println("Enter number of objects:  ");
		n = scanner.nextInt();
		System.out.println("Enter Weights: ");
		for (int i = 1; i <= n; i++)
			wt[i] = scanner.nextInt();
		System.out.println("Enter Profits: ");
		for (int i = 1; i <= n; i++)
			val[i] = scanner.nextInt();
		scanner.close();
	}
}

