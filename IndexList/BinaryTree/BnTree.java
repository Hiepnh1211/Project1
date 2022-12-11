package BinaryTree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BnTree {
	public static int MAX_LETTER = 20;
	public static int l =1;
	
	static class Node{
		String word;
		int count = 1;
		LL3 line = new LL3();
		Node left, right;
		public Node (String w) {
			this.word = w;
			this.left = null;
			this.right = null;
		}
	}
	
	Node root;
	
	BnTree(){
		root = null;
	}
	
	BnTree(String value){
		root = new Node(value);
	}
	
	void insert(String word) { root = insertRec(root, word); }
	 
    /* A recursive function to
       insert a new key in BST */
    Node insertRec(Node root, String word)
    {
 
        /* If the tree is empty,
           return a new node */
        if (root == null) {
            root = new Node(word);
            root.line.add(l);
            return root;
        }
 
        /* Otherwise, recur down the tree */
        else if (word.toLowerCase().compareTo(root.word.toLowerCase()) < 0) {
        	root.left = insertRec(root.left, word);
        }
        else if (word.toLowerCase().compareTo(root.word.toLowerCase()) > 0) {
        	root.right = insertRec(root.right, word);
        }
            
        else if(word.toLowerCase().compareTo(word.toLowerCase()) == 0) {
        	root.count++;
        	root.line.add(l);
        }
 
        /* return the (unchanged) node pointer */
        return root;
    }
    
    void inorder() { inorderRec(root); }
    
    // A utility function to
    // do inorder traversal of 
    void inorderRec(Node root)
    {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.word + " ");
            System.out.print(root.count + " ");
            root.line.showLine();
            System.out.println();
            inorderRec(root.right);
        }
    }
    
    public static void main(String[] args) throws IOException {
    	char[] wrd = new char[MAX_LETTER];
		int i = 0;
		String w = null ;
    	
    	LL stopW  = new LL();
		stopW.readStopW("stopCase.txt", stopW);
		
		BnTree BNT = new BnTree();
		File VanBan = new File("testcase.txt");
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
		        	BNT.insert(w);
		        }
	        	
	        } 
	    }
	    System.out.println("Index List:");
	    BNT.inorder();

	}
}
