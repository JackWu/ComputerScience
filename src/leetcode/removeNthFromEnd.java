package leetcode;

public class removeNthFromEnd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		
		ListNode ret = removeNthFromEnd(a, 2);
		
		while(ret!=null){
			System.out.print(ret.val + " ");
			ret = ret.next;
		}

	}

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
    	if(head == null)
    		return null;
    	if(n==0)
    		return head;
    	
        ListNode fast = head;
        ListNode slow = head;
        
        for(int i=0;i<n;i++) fast=fast.next;
        if(fast==null) return head.next; 
        
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        
        return head;
        
    }
}
