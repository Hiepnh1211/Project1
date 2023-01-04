package TSP_QueenPlacing;
import java.util.Scanner;

public class Ex2_Xep_hau {
	public static int n = 8;
	public static int[] x = new int[100];
	public static String[][] map = new String[100][100]; 
	public static int k = 0;
	public static int count = 0;
	
	public static void Solution() {
		System.out.print(count + " x = ( ");
		for(int i = 1; i <= n; i++) {
			System.out.print(x[i] + " ");
		}
		System.out.println(")");
		
		for(int j = 1; j <= 2*n+1; j++) {
			for(int k = 1; k <= 2*n+1; k++) {
				
				
				if(k % 2 == 0 && j % 2 == 0) {
					map[j][k] = " ";
				}
				
				else if( k % 2 == 1 && j % 2 == 0) {
					map[j][k] = "|";
				}
				
				else if(k != 1 && j != 1 && k % 2 == 1 && j % 2 == 1 && k != 2*n+1 && j != 2*n+1) {
					map[j][k] = "+";
				}
				
				else {
					map[j][k] = "-";
				}
				
			}
		}
		
		for(int i = 1; i <= 2*n+1; i++) {
			map[2*i][2*x[i]] = "Q";
		}
		
		for(int j = 1; j <= 2*n+1; j++) {
			for(int k = 1; k <= 2*n+1; k++) {
				System.out.print(map[j][k] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
		
		
			
	}
	
	public static int check(int v, int k) {
		for(int i = 1; i <= k-1; i++) {
			if(x[i] == v) {
				return 0;
			}
			if(x[i] + i == v+k) {
				return 0;
			}
			if(x[i] - i == v-k) {
				return 0;
			}
		}
		return 1;
	}
	
	public static void Try(int k) {
		for (int v = 1; v <= n; v++)
	    {
	        if (check(v,k) != 0)
	        {
	            x[k] = v;
	            if (k == n)
	            {
					count++;
	                Solution();
	            }
	            else{
	                Try(k+1);
	            }
	            
	        }
	        
	    }
	}
	
	public static void main(String[] args) {
		
		Try(1);
	}
}
