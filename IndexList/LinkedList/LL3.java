package LinkedList;

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
		int count = 0;
		line currLine = head;
		while(currLine != null) {
			if(count == 12){
				System.out.printf("\n%-25s%4d"," ",currLine.line);
				count = 0;
			}else{
				System.out.printf("%4d",currLine.line);
				count++;
			}
			currLine = currLine.nextLine;
		}
	}
}
