package HashTable;

public class LL3 {
	class line {
		int line;
		line nextLine;
		public line(int l) {
			this.line = l;
			this.nextLine = null;
		}
	}
	
	public line head = null;
	public line tail = null;
	
	public void add(int l) {
		line newLine = new line(l);
		
		// check if the line has already existed in the list, if so, end the method
		line now = head;
		while(now != null) {
			if(now.line == l) {
				return;
			}
			now = now.nextLine;
		}
		
		if(head == null) 

        {    

			//if the given list is empty, making the two nodes head and tail to point to the newly created node newLine    

            head = newLine;    

            tail = newLine;    

        }    

        else 

        {    

        	//otherwise the newLine will be added after tail so that the next pointer of tail points to    the newLine   

            tail.nextLine = newLine;    

            tail = newLine;    

        }
	}
	
	public void showLine() {
		line currLine = head;
		while(currLine != null) {
			System.out.print(" " + currLine.line + " ");
			currLine = currLine.nextLine;
		}
	}

}
