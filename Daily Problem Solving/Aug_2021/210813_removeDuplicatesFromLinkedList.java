import java.util.*;

class Program {
  // This is an input class. Do not edit.
  public static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
    // Write your code here.
		LinkedList head = new LinkedList(linkedList.value);
		LinkedList curr = head;
		
		while(linkedList != null){
			if(linkedList.value > curr.value){
				curr.next = new LinkedList(linkedList.value);
				curr = curr.next;
			}
			linkedList = linkedList.next;
		}
		
		
    return head;
  }
	
}
