package leetcode;



public class AddTwoNumbers {

	/**
	 * @param args
	 */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (l1 == null && l2 == null)
			return null;
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

			
		//ListNode h1 = switchDirection(l1);
		//ListNode h2 = switchDirection(l2);
		
		ListNode temp1 = l1;
		ListNode temp2 = l2;
		
		ListNode ret = new ListNode(0);
		
		boolean hasCarry = calculate(temp1.val, temp2.val, ret, false);
		
		temp1 = temp1.next;
		temp2 = temp2.next;
		
		ListNode head = ret;
		
		if(temp1==null&&temp2==null){
			ListNode newNode = null;
			if(hasCarry)
				newNode = new ListNode(1);
			ret.next = newNode;
			return ret;
		}
		
		
		
		while(temp1!=null && temp2!=null){
			
			ListNode newNode = new ListNode(0);
			
			hasCarry = calculate(temp1.val, temp2.val, newNode, hasCarry);
			
			ret.next = newNode;
			ret = ret.next;
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		
		while(temp1!=null){
			ListNode newNode = new ListNode(0);
			hasCarry = calculate(temp1.val, 0, newNode , hasCarry);
			ret.next = newNode;
			ret = ret.next;
			temp1 = temp1.next;
		}
		while(temp2!=null){
			ListNode newNode = new ListNode(0);
			hasCarry = calculate(temp2.val, 0, newNode , hasCarry);
			ret.next = newNode;
			ret = ret.next;
			temp2 = temp2.next;
		}
		
		if(hasCarry){
			ListNode newNode = new ListNode(1);
			ret.next = newNode;
		}
		
		return head;
        
    }

	
    private boolean calculate(int val1, int val2, ListNode ret, boolean hasCarry){
		int sum = hasCarry?val1+val2+1:val1+val2;
		boolean hasNewCarry = false;
		if(sum>=10)
			hasNewCarry = true;
		ret.val = (sum%10);
		
		return hasNewCarry;
		
	}
}

