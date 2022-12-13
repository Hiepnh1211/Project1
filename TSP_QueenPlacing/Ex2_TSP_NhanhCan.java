package TSP_QueenPlacing;
import java.util.Scanner;

public class Ex2_TSP_NhanhCan {
	public static int START = 0;
	public static final int MAXC = 100;
	public static int n =0;
	public int[] x = new int[MAXC];
	public int[][] c = new int[MAXC][MAXC];
	public boolean[] d = new boolean[MAXC];
	public int[] best = new int[MAXC];
	public int total = 0;
	public int totalBest = Integer.MAX_VALUE;
	
	public void In() {
		Scanner in = new Scanner(System.in);
		System.out.print("Nhap n: ");
		n = in.nextInt();
		
		for(int i =0; i < n; i++) {
			for(int j = 0; j < n; j++) {
					c[i][j] = in.nextInt();
			}
		}
		
		for(int i = 0; i < n; i++)  {
			d[i] = false;
		}
		
		x[0] = START;
		d[START] = true;
	}

	
	public void result() {
		System.out.println();
			for(int i = 0; i < n; i++) {
				System.out.print((x[i]+1) + "->");
			}
			System.out.print((x[START]+1) + " total:" + totalBest);
		
	}
	
	public void update() {
		if(c[x[n-1]][START] > 0 && (total + c[x[n-1]][0]) < totalBest) {
			totalBest = total + c[x[n-1]][0];
			for(int i = 0; i < n; i++) {
				best[i] = x[i];
			}
		}
	}
	
	public void travel(int idx) {
		
		if(total > totalBest) {
			return;
		}
		
		for(int i=0; i<n ; i++) {
			if(d[i] == false && c[x[idx-1]][i]>0) {
				x[idx] = i;
				d[i] = true;
				total += c[x[idx-1]][i];
				
				if(idx == n-1) {
					update();
					//result();
				}else {
					travel(idx + 1);
				}
				d[i] = false;
				total -= c[x[idx-1]][i];
			}
		}
	}
	
	public static void main(String[] args) {
		Ex2_TSP_NhanhCan nc = new Ex2_TSP_NhanhCan();
		nc.In();
		nc.travel(1);
		nc.result();
	}
}
