package TSP_QueenPlacing;
import java.util.Scanner;

public class Ex2_TSP_NhanhCan {
	public static int START = 0; 				//Starting point
	public static final int MAXC = 100; 		//Maximum amount of city
	public static int n =0; 					//Number of cities
	public int[] x = new int[MAXC]; 			//Array contains the list of cities that are visited
	public int[][] c = new int[MAXC][MAXC];		//Matrix of cities and distances(cost) between them 
	public boolean[] d = new boolean[MAXC]; 	//Boolean array used to mark the visited city 
	public int[] best = new int[MAXC];			//Array to store the best path so far
	public int total = 0;						//Total distances(cost) 
	public int totalBest = Integer.MAX_VALUE;	//Best(Lowest) total distance(cost) so far
	
	public void In() {							//Method used to input the matrix from the key board
		Scanner in = new Scanner(System.in);
		System.out.print("Nhap n: ");
		n = in.nextInt();
		
		System.out.println("Nhap mang: ");
		for(int i =0; i < n; i++) {
			for(int j = 0; j < n; j++) {
					c[i][j] = in.nextInt();
			}
		}
		
		for(int i = 0; i < n; i++)  {
			d[i] = false;
		}
		
		x[0] = START;							//Store the starting point of the tour to x
		d[START] = true;						//Mark the START city as visited
	}

	
	public void result() {						//Method used to print out the result
		System.out.print("\nPath taken:");
			for(int i = 0; i < n; i++) {
				System.out.print((best[i] + 1) + "->");
			}
			System.out.print((best[START] + 1) + " \nTotal: " + totalBest);
		
	}
	
	public void update() {						//Method used to update the result of the better path 
		if(c[x[n-1]][START] > 0 && (total + c[x[n-1]][0]) < totalBest) {
			totalBest = total + c[x[n-1]][0];	//Total distances(cost) = total so far + distance(cost) from the last city to the first one
			for(int i = 0; i < n; i++) {
				best[i] = x[i];
			}
		}
	}
	
	public void travel(int idx) {				//Method used to backtracking 
		
		if(total > totalBest) {					//if the current total is larger than the best total so far, return
			return;
		}
		
		for(int i=0; i<n ; i++) {
			if(d[i] == false && c[x[idx-1]][i]>0) {
				x[idx] = i;
				d[i] = true;
				total += c[x[idx-1]][i];
				
				if(idx == n-1) {
					update();
				}else {
					travel(idx + 1);
				}
				d[i] = false;
				total -= c[x[idx-1]][i];
			}
		}
	}
	
	public static void main(String[] args) {		//Main method
		Ex2_TSP_NhanhCan nc = new Ex2_TSP_NhanhCan();
		nc.In();
		nc.travel(1);
		nc.result();
	}
}
