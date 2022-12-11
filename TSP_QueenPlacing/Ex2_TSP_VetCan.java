package TSP_QueenPlacing;
import java.util.Scanner;

public class Ex2_TSP_VetCan {
	static int[] path = new int[100];
	static int[] check = new int[100];
	static int n;
	static int cost;
	static int[] final_result = new int[100];
	static int ans = Integer.MAX_VALUE;
	
	static void Solution(int[][] graph) {
		for(int i = 0; i <= n; i++) {
			path[n] = path[0];
			
		}
		
		for(int i = 1; i < n; i++) {
			cost += graph[path[i-1]][path[i]];
		}
		
	}
	
	static void res() {
		if(cost < ans) {
			ans = cost;
			for(int i = 0; i <= n ; i++) {
				final_result[i] = path[i];
			}
		}
	}
	
	static void Try(int i, int[][] graph) {
		
		for(int v = 0; v < n; v++) {
			if(check[v] == 0) {
				path[i-1] = v;
				check[v] = 1;
				if(i == n) {
					Solution(graph);
					cost = cost + graph[path[n-1]][path[0]];
					res();
					cost = 0;
				}
				else {
					Try(i+1, graph);
				}
				check[v] = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Nhap n:");
		n = in.nextInt();
        int graph[][] = new int[n][n]; 
    	
        System.out.println("Nhap mang: ");
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			graph[i][j] = in.nextInt();
    		}
    	}
		
		check[0] = 0;
		
		long start = System.currentTimeMillis();
		Try(1, graph);
		long end = System.currentTimeMillis();
		
		System.out.print("\nMinimum length: ");
		System.out.print(ans + "\n");
		System.out.print("Path taken: ");
		for(int i = 0; i <= n; i++) {
			System.out.print(final_result[i] + " ");
		}
		
		System.out.println("\nTime: " + (end - start));
	}
}
