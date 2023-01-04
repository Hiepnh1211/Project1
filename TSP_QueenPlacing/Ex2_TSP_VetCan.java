package TSP_QueenPlacing;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Ex2_TSP_VetCan {
	static int[] path = new int[100];
	static boolean[] check = new boolean[100];
	public static int[][] graph = new int[100][100];
	static int n;
	static int cost;
	static int[] final_result = new int[100];
	static int ans = Integer.MAX_VALUE;
	public static int START = 1;

	public static void In1() {							//Method used to input the matrix from the key board
		Scanner in = new Scanner(System.in);
		System.out.print("Nhập n: ");
		n = in.nextInt();

		System.out.printf("Nhập điểm khởi đầu(từ 1 đến %d): ", n);
		START = in.nextInt();
		while(START < 0 || START > n){
			System.out.println("Thành phố không hợp lệ, mời nhập lại: ");
			START = in.nextInt();
		}

		System.out.println("Nhap mang: ");
		for(int i =0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				graph[i][j] = in.nextInt();
			}
		}
		System.out.println("Mang da nhap:");
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				System.out.print(graph[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void In2() throws IOException {
		Scanner in = new Scanner(System.in);
		String fileName = "null";
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
					graph[l][s] = Integer.parseInt(w);
					s++;
				}
			}
		}

		n = s + 1;
		System.out.println("Mảng đã nhập:");
		for(i = 0; i < s; i++){
			for(int k = 0; k < n; k++){
				System.out.print(graph[i][k] + "\t");
			}
			System.out.println();
		}
		System.out.printf("Nhập điểm khởi đầu(từ 1 đến %d): ",n);
		START = in.nextInt();
		while(START < 0 || START > n){
			System.out.println("Thành phố không hợp lệ, mời nhập lại: ");
			START = in.nextInt();
		}

	}

	public static void In3(){
		int limit = 0;
		Scanner in = new Scanner(System.in);
		System.out.println("Nhập số lượng phần tử: ");
		n = in.nextInt();
		System.out.println("Nhập giới hạn sinh ngẫu nhiên: ");
		limit = in.nextInt();

		Random rn = new Random();

		for (int i = 0; i<n; i++){
			for(int j = 0; j < n; j++){
				graph[i][j] = rn.nextInt(limit);
				while (graph[i][j] == 0){
					graph[i][j] = rn.nextInt(limit);
				}
				graph[j][i] = graph[i][j];
				if(i == j){
					graph[i][j] = 0;
				}
			}
		}
		System.out.println("Mảng đã nhập:");
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				System.out.print(graph[i][j]+ "\t");
			}
			System.out.println();
		}
		System.out.printf("Nhập điểm khởi đầu(từ 1 đến %d): ",n);
		START = in.nextInt();
		while(START < 0 || START > n){
			System.out.println("Thành phố không hợp lệ, mời nhập lại: ");
			START = in.nextInt();
		}
	}

	public static void inputMenu(){
		System.out.println("\n\nBài toán TSP sử dụng phương pháp vét cạn");
		System.out.println("--Phương thức nhập--");
		System.out.println("1. Bàn phím");
		System.out.println("2. File");
		System.out.println("3. Ngẫu nhiên");
		System.out.println("4. Exit");
		System.out.println("Your choice: ");
	}
	public static void Solution() {
		path[n] = path[0];

		for(int i = 1; i < n; i++) {
			cost += graph[path[i-1]][path[i]];
		}

	}

	public static void res() {
		if(cost < ans) {
			if(path[0] == START-1){
				ans = cost;
				for(int i = 0; i <= n ; i++) {
					final_result[i] = path[i];
				}
			}
		}
	}

	public static void Try(int i) {

		for(int v = 0; v < n; v++) {
			if(check[v] == false) {
				path[i-1] = v;
				check[v] = true;
				if(i == n) {
					Solution();
					cost = cost + graph[path[n-1]][path[0]];
					res();
					cost = 0;
				}
				else {
					Try(i+1);
				}
				check[v] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);
		int choice = 0;
		while (choice != 4) {
			inputMenu();
			choice = in.nextInt();
			while (choice < 1 || choice > 4) {
				System.out.println("Lua chon khong kha dung, moi nhap lai");
				choice = in.nextInt();
			}
			switch (choice) {
				case 1:
					In1();
					Try(1);
					System.out.print("\nPath taken: ");
					for(int i = 0; i < n; i++) {
						System.out.print((final_result[i]+1) + "->");
					}
					System.out.print(final_result[n]+1);
					System.out.print("\nMinimum length: ");
					System.out.print(ans + "\n");
					for(int i = 0; i < n; i++) {
						final_result[i] = 0;
					}
					ans = Integer.MAX_VALUE;
					n=0;
					break;
				case 2:
					In2();
					Try(1);
					System.out.print("\nPath taken: ");
					for(int i = 0; i < n; i++) {
						System.out.print((final_result[i]+1) + "->");
					}
					System.out.print(final_result[n]+1);
					System.out.print("\nMinimum length: ");
					System.out.print(ans + "\n");
					for(int i = 0; i < n; i++) {
						final_result[i] = 0;
					}
					ans = Integer.MAX_VALUE;
					n=0;
					break;
				case 3:
					In3();
					Try(1);
					System.out.print("\nPath taken: ");
					for(int i = 0; i < n; i++) {
						System.out.print((final_result[i]+1) + "->");
					}
					System.out.print(final_result[n]+1);
					System.out.print("\nMinimum length: ");
					System.out.print(ans + "\n");
					for(int i = 0; i <= n; i++) {
						final_result[i] = 0;
					}
					ans = Integer.MAX_VALUE;
					n=0;
					break;
				default:
					break;
			}
		}
	}
}



