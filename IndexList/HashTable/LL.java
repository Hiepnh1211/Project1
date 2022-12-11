package HashTable;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LL {
	class Node{
		String word;
		Node next;
		public Node(String word) {
			this.word = word;
			this.next = null;
		}
	}
	
	public Node head = null;    

    public Node tail = null;  
	
	public void insert(String word) 

    {    

        //Creating a new node   

        Node newNode = new Node(word);               

        //checking of the list is empty   

        if(head == null) 

        {    

//if the given list is empty, making the two nodes head and tail to point to the newly created node newNode    

            head = newNode;    

            tail = newNode;    

        }    

        else 

        {    

//otherwise the newNode will be added after tail so that the next pointer of tail points to    the newNode   

            tail.next = newNode;    

            tail = newNode;    

        }    
    } 
	
	public boolean check1(String w) {
		Node current = head;
//		if(head ==  null) {
//			System.out.println("List is empty");
//		}
		
		while (current != null) {
			if(current.word.equals(w.toLowerCase())){
				return true;
			}
			current = current.next;
		}
		return false;
	}
	 
    
    public void readStopW(String name, LL L) throws FileNotFoundException {
		String word = null;
		File f = new File(name);
		Scanner in = new Scanner(f);
		while(in.hasNextLine()) {
			word = in.nextLine();
			L.insert(word);
		}
    }
}
