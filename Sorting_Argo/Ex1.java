package Sorting_Argo;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Ex1 {
	
//Insertion Sort
	public static void insertionSort(int[] arr) {
		for (int x = 1; x < arr.length; x++) {
			int current = arr[x];
			int y = x - 1;
			while(y >= 0 && current < arr[y]) {
				arr[y+1] = arr[y];
				y--;
			}
				arr[y+1] = current;
		}
	}
	
//Bubble Sort
	public static void bubbleSort(int[] arr) {
		int n = arr.length;
		int tmp = 0;
		for(int x=0; x < n; x++){
			for(int y=1; y < (n-x); y++){
				if(arr[y-1] > arr[y]){
					//swap elements
					tmp = arr[y-1];
					arr[y-1] = arr[y];
					arr[y] = tmp;
				}
			}
		}
	}
	
//Heap Sort 
	public static void heapSort(int arr[]){
		int n = arr.length;
		for (int x = n / 2 - 1; x >= 0; x--)
			heapify(arr, n, x);
		for (int x=n-1; x>=0; x--) {
			int tmp = arr[0];
			arr[0] = arr[x];
			arr[x] = tmp;
			heapify(arr, x, 0);
		}
	}
	static void heapify(int arr[], int n, int x){
		int largest = x;
		int L = 2*x + 1;
		int r = 2*x + 2;
		if (L < n && arr[L] > arr[largest])
			largest = L;
		if (r < n && arr[r] > arr[largest])
			largest = r;
		if (largest != x){
			int swap = arr[x];
			arr[x] = arr[largest];
			arr[largest] = swap;
			heapify(arr, n, largest);
		}
	}
	

//Selection Sort	
	public static void selectionSort(int[] arr){
		for (int x = 0; x < arr.length - 1; x++){
			int indx = x;
			for (int y = x + 1; y < arr.length; y++){
				if (arr[y] < arr[indx]){
					indx = y;
				}
			}
			int smallNumber = arr[indx];
			arr[indx] = arr[x];
			arr[x] = smallNumber;
			}
	}
	
//Merge Sort
	static void merge(int[] array,int lowval,int midval,int highval){
		int x, y ,k;
		int[] c= new int[highval-lowval+1];
		k = 0;
		x=lowval;
		y=midval+1;
		while(x<=midval && y<=highval){
			if(array[x]<=array[y]){
				c[k++] = array[x++];
			}
			else{
				c[k++] = array[y++];
			}
		}
		while(x<=midval){
			c[k++] = array[x++];
		}
		while(y<=highval){
			c[k++] = array[y++];
		}
		k=0;
			for(x = lowval; x<=highval; x++){
				array[x] = c[k++];
		}
	}
	
		static void mergeSort(int[] array,int lowval, int highval){
		if(highval-lowval+1>1){
			int midval = (lowval+highval)/2;
			mergeSort(array,lowval,midval);
			mergeSort(array,midval+1,highval);
			merge(array,lowval,midval,highval);
			}
		}
		
//Quick Sort
		public static int arrayPartition(int[] array, int start, int end) {
			int pivot = array[end];
			int i = (start - 1);
			for (int ele = start; ele < end; ele++) {
				if (array[ele] <= pivot) {
					i++;
					int swap = array[i];
					array[i] = array[ele];
					array[ele] = swap;
				}
			}
			// Swapping the elements
			int swap = array[i + 1];
			array[i + 1] = array[end];
			array[end] = swap;
			return i + 1;
		}
			public static void quickSort(int[] arrayTobeSorted, int start, int end) {
				if (start < end) {
					int pivot = arrayPartition(arrayTobeSorted, start, end);
					quickSort(arrayTobeSorted, start, pivot - 1);
					quickSort(arrayTobeSorted, pivot + 1, end);
				}
			}
		
//Main
	public static int[] Nhap() {
		int n;
		Scanner input = new Scanner(System.in);
		System.out.print("Nhap so luong phan tu mang: ");
		n = input.nextInt();
		int array[] = new int[n];
		System.out.println("Nhap mang:");
		for(int i = 0; i< n; i++) {
			array[i] = input.nextInt();
		}
		return array ;
	}
	
	public static int[] readFile(String file) {
		try {
			File f = new File(file);
			Scanner s = new Scanner(f);
			int ctr = 0;
			while(s.hasNextInt()) {
				ctr++;
				s.nextInt();
			}
			int[] arr = new int[ctr];
			Scanner s1 = new Scanner(f);
			
			for(int i = 0; i<arr.length; i++) {
				arr[i] = s1.nextInt();			
			}
			
			return arr;
			
		}catch(Exception e) {
			return null;
		}
	}
	
	public static void Menu() {
		System.out.println("---Sap xep---");
		System.out.println("1.Insertion Sort");
		System.out.println("2.Bubble Sort");
		System.out.println("3.Heap Sort");
		System.out.println("4.Selection Sort");
		System.out.println("5.Merge Sort");
		System.out.println("6.Quick Sort");
		System.out.println("7.Exit");
		System.out.print("Your choice:");
	}
	
	public static void main(String[] args) {
		int array[] = new int[10000];
		long startTime = 0;
		long endTime= 0;
		long Time = 0;
		Scanner in =  new Scanner(System.in);
//		String file = in.nextLine();
		
		int choice = 0;	
		
		
		
//		int data[] = readFile("10k.txt");
//		
//		System.out.print("Mang sau sap xep: \n");
//		startTime = System.nanoTime();
//
//		quickSort(data,0,data.length-1);
//		for(int x : data) {
//			System.out.print(x+" ");
//		}
//
//		endTime = System.nanoTime();
//		Time = endTime - startTime;
//		System.out.println("\nThat took "+Time + " nanoseconds");
		
		while(choice != 7) {
			Menu();
			choice = in.nextInt();
			
			while(choice > 6 || choice < 1) {
				System.out.print("Lua chon khong to tai! Xin nhap lai:");
				choice = in.nextInt();
			}
			
		
			switch(choice) {
			case 1:
				array = Nhap();
				
				System.out.print("Mang sau sap xep: ");
				startTime = System.nanoTime();

				insertionSort(array);
				for(int x : array) {
					System.out.print(x+" ");
				}

				endTime = System.nanoTime();
				Time = endTime - startTime;
				System.out.printf("\nThat took %d nanosaconds\n", Time);
				break;
				
			case 2:
				array = Nhap();
				
				System.out.print("Mang sau sap xep: ");
				startTime = System.nanoTime();

				bubbleSort(array);
				for(int x : array) {
					System.out.print(x+" ");
				}

				endTime = System.nanoTime();
				Time = endTime - startTime;
				System.out.printf("\nThat took %d nanosaconds\n", Time);
				break;
				
			case 3:
				array = Nhap();
				
				System.out.print("Mang sau sap xep: ");
				startTime = System.nanoTime();

				heapSort(array);
				for(int x : array) {
					System.out.print(x+" ");
				}

				endTime = System.nanoTime();
				Time = endTime - startTime;
				System.out.printf("\nThat took %d nanosaconds\n", Time);
				break;
				
			case 4:
				array = Nhap();
				
				System.out.print("Mang sau sap xep: ");
				startTime = System.nanoTime();

				selectionSort(array);
				for(int x : array) {
					System.out.print(x+" ");
				}

				endTime = System.nanoTime();
				Time = endTime - startTime;
				System.out.printf("\nThat took %d nanosaconds\n", Time);
				break;
				
			case 5:
				array = Nhap();
				
				System.out.print("Mang sau sap xep: ");
				startTime = System.nanoTime();

				mergeSort(array,0,array.length-1);
				for(int x : array) {
					System.out.print(x+" ");
				}

				endTime = System.nanoTime();
				Time = endTime - startTime;
				System.out.printf("\nThat took %d nanoseconds\n\n", Time);
				break;
				
			case 6:
				array = Nhap();
				
				System.out.print("Mang sau sap xep: ");
				startTime = System.nanoTime();

				quickSort(array,0,array.length-1);
				for(int x : array) {
					System.out.print(x+" ");
				}

				endTime = System.nanoTime();
				Time = endTime - startTime;
				System.out.printf("\nThat took %d nanosaconds\n",Time);
				break;

			default:
				break;
			}

		}
		
	}
}
