package leetcode;

public class partitionList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(1);
		//ListNode c = new ListNode(2);
		a.next = b;
		//b.next = c;
		
		ListNode current = partition(a, 1);
		while(current!=null){
			System.out.println(current.val);
			current = current.next;
		}

	}
	
    public static ListNode partition(ListNode head, int x) {
        // Note: The Solution object is instantiated only once and is reused by each test case.

    	ListNode front = null;
    	ListNode back = null;
    	ListNode current = head;
    	while(current!=null){
    		ListNode next = current.next;
    		if(current.val < x){
    			current.next = front;
    			front = current;
    		}else{
    			current.next = back;
    			back = current;
    		}
    	}
    	current = front;
    	while(current.next != null){
    		current = current.next;
    	}
    	current.next = back;
    	head = front;
        
    	return head;
        
    }
    
    public static int size(ListNode head){
    	int count = 0;
    	ListNode current = head;
    	while(current!=null){
    		count++;
    		current = current.next;
    	}
    	
    	return count;
    }
    public static int countX(ListNode head, int x){
    	int countX = 0;
    	ListNode current = head;
    	while(current!=null){
    		if(current.val == x)
    			countX++;
    		current = current.next;
    	}
    	
    	return countX;
    	
    }
    
    public static ListNode handleSizeOfTwo(ListNode head, int x){
    	ListNode current = head;
    	if(current.val > current.next.val){
    		ListNode temp = current.next;
    		current.next = null;
    		temp.next = current;
    		head = temp;
    		
    	}
    	
    	return head;
    }

}
