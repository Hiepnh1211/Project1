package HashTable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HashM {
	public static final int MAX_LETTER = 20;
	public static int SIZE = 200;
	public static LL2[] Hash = new LL2[200];
	public static int l = 1;
	
	public int HashFunc(String w) {
		int sum = 0;
		for(int i = 0; i < w.length(); i++) {
			sum += (int)w.charAt(i);
		}
		return sum % 200;
	}
	
	public static void main(String[] args) throws IOException{
		char[] wrd = new char[MAX_LETTER];
		int i = 0;
		int key = 0;
		String w = null ; 
		
		for(int j = 0; j < SIZE; j++) {
			Hash[j] = new LL2();
		}
		HashM table = new HashM();
		LL stopW  = new LL();
		stopW.readStopW("stopW.txt", stopW);

		File VanBan = new File("VanBan.txt");
	    // Create the File Reader object
	    FileReader vb = new FileReader(VanBan);
	    // Create the BufferedReader object
	    BufferedReader brvb = new BufferedReader(vb);  
	    
	    int c = 0;             
	    // Read character by character
	    while((c = brvb.read()) != -1)
	    {
	        // convert the integer to char
	        char ch = (char) c;   
	        if(ch == '\n') {
	        	l++;
	        }
	        if(Character.isAlphabetic(ch)) {
	        	wrd[i] = (char) c;
	        	i++;
	        }
	        else{
	        	w = String.valueOf(wrd, 0,i);
	        	
	        	//Blank w for the next input
	        	for(int j = 0; j < i; j++) {
	    	    	wrd[j] = '\0';
	    	    }
	        	i=0;
	        	if(!w.isBlank() && !stopW.check1(w)) {
	        		key = table.HashFunc(w);
		        	Hash[key].insert(w,l);
		        }
	        	
	        } 
	    }
	    System.out.println("Index List: ");
	    for(int m = 0; m < SIZE; m++) {
	    	if(Hash[m].head != null) {
	    		System.out.print(m + " ");
	    		Hash[m].displaylist();
	    	}
	    }
	}
}
