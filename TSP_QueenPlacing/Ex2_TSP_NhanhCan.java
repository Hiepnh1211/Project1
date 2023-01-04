package TSP_QueenPlacing;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Ex2_TSP_NhanhCan {
	public static int START = 1; 				//Starting point
	public static final int MAXC = 100; 		//Maximum amount of city
	public static int n =0; 					//Number of cities
	public int[] x = new int[MAXC]; 			//Array contains the list of cities that are visited
	public int[][] c = new int[MAXC][MAXC];		//Matrix of cities and distances(cost) between them
	public boolean[] d = new boolean[MAXC]; 	//Boolean array used to mark the visited city 
	public static int[] best = new int[MAXC];			//Array to store the best path so far
	public int total = 0;						//Total distances(cost) 
	public static int totalBest = Integer.MAX_VALUE;	//Best(Lowest) total distance(cost) so far
	
	public void In1() {							//Method used to input the matrix from the key board
		Scanner in = new Scanner(System.in);
		System.out.print("Nhập n: ");
		n = in.nextInt();

		System.out.printf("Nhập điểm khởi đầu(từ 1 đến %d): ",n);
		START = in.nextInt();
		while(START < 0 || START > n){
			System.out.println("Thành phố không hợp lệ, mời nhập lại: ");
			START = in.nextInt();
		}
		
		System.out.println("Nhập mảng: ");
		for(int i =0; i < n; i++) {
			for(int j = 0; j < n; j++) {
					c[i][j] = in.nextInt();
			}
		}
		System.out.println("Mảng đã nhập: ");
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				System.out.print(c[i][j] + "\t");
			}
			System.out.println();
		}
		
		for(int i = 0; i < n; i++)  {
			d[i] = false;
		}
		
		x[0] = START-1;							//Store the starting point of the tour to x
		d[START-1] = true;						//Mark the START city as visited
	}

	public void In2() throws IOException {
		Scanner in = new Scanner(System.in);
		String fileName = "";
		char[] wrd = new char[20];
		int s = 0;
		int i = 0;
		String w = null ;
		int l = 0;
		System.out.println("Nhập file:");
		fileName = in.next();

		File VanBan = new File(fileName);
		// Create the File Reader object
		FileReader vb = new FileReader(VanBan);
		// Create the BufferedReader object
		BufferedReader brvb = new BufferedReader(vb);

		int cha = 0;
		// Read character by character
		while((cha = brvb.read()) != -1)
		{
			// convert the integer to char
			char ch = (char) cha;
			if(ch == '\n') {
				l++;
				s=0;
			}
			if(Character.isDigit(ch)) {
				wrd[i] = (char) cha;
				i++;
			}
			else{
				w = String.valueOf(wrd, 0,i);

				//Blank w for the next input
				for(int j = 0; j < i; j++) {
					wrd[j] = '\0';
				}
				i=0;
				if(!w.isBlank()){
					c[l][s] = Integer.parseInt(w);
					s++;
				}
			}
		}
		System.out.println("Mảng đã nhập:");
		for( i = 0; i <= s; i++){
			for(int j = 0; j <= s; j++){
				System.out.print(c[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.printf("Nhập điểm khởi đầu(từ 1 đến %d): ",s+1);
		START = in.nextInt();
		while(START < 0 || START > s+1){
			System.out.println("Thành phố không hợp lệ, mời nhập lại: ");
			START = in.nextInt();
		}
		for(int k = 0; k < s; k++)  {
			d[k] = false;
		}
		x[0] = START-1;							//Store the starting point of the tour to x
		d[START-1] = true;
		n = s + 1;
	}

	public void In3(){
		int limit = 0;
		Scanner in = new Scanner(System.in);
		System.out.println("Nhập số lượng phần tử: ");
		n = in.nextInt();
		System.out.println("Nhập giới hạn sinh ngẫu nhiên: ");
		limit = in.nextInt();
		Random rn = new Random();

		for (int i = 0; i<n; i++){
			for(int j = 0; j < n; j++){
				c[i][j] = rn.nextInt(limit);
				while (c[i][j] == 0){
					c[i][j] = rn.nextInt(limit);
				}
				c[j][i] = c[i][j];
				if(i == j){
					c[i][j] = 0;
				}
			}
		}
		System.out.println("Mảng đã nhập:");
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				System.out.print(c[i][j]+ "\t");
			}
			System.out.println();
		}
		System.out.printf("Nhập điểm khởi đầu(từ 1 đến %d): ",n);
		START = in.nextInt();
		for(int j = 0; j < n; j++)  {
			d[j] = false;
		}
		x[0] = START-1;							//Store the starting point of the tour to x
		d[START-1] = true;
	}

	public static void inputMenu(){
		System.out.println("\n\nBài toán TSP sử dụng phương pháp nhánh cận");
		System.out.println("--Phương thức nhập--");
		System.out.println("1. Bàn phím");
		System.out.println("2. File");
		System.out.println("3. Ngẫu nhiên");
		System.out.println("4. Exit");
		System.out.println("Your choice: ");
	}
	
	public void result() {						//Method used to print out the result
		System.out.println("Path taken: ");
		for (int i = 0; i< n; i++){
			System.out.print((best[i] + 1) + "->");
		}
		System.out.print((best[0] + 1) +"\nTotal: " + totalBest);
		for (int i = 0; i< n; i++){
			best[i]  =0;
		}
		totalBest = Integer.MAX_VALUE;
	}
	
	public void update() {						//Method used to update the result of the better path 
		if(c[x[n-1]][START-1] > 0 && (total + c[x[n-1]][START-1]) < totalBest) {
			totalBest = total + c[x[n-1]][START-1];	//Total distances(cost) = total so far + distance(cost) from the last city to the first one
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
	
	public static void main(String[] args) throws IOException {		//Main method
		Ex2_TSP_NhanhCan nc = new Ex2_TSP_NhanhCan();
		Scanner in = new Scanner(System.in);
		int choice = 0;
		while (choice != 4){
			inputMenu();
			choice = in.nextInt();
			while(choice < 1 || choice > 4){
				System.out.println("Lựa chọn không khả dụng, mời nhập lại: ");
				choice = in.nextInt();
			}
			switch (choice){
				case 1:
					nc.In1();
					nc.travel(1);
					nc.result();
					break;
				case 2:
					nc.In2();
					nc.travel(1);
					nc.result();
					break;
				case 3:
					nc.In3();
					nc.travel(1);
					nc.result();
					break;
				default:
					break;
			}
		}

	}
}
