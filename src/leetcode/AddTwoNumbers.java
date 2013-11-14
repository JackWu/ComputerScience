package leetcode;

import java.util.ArrayList;

public class AddTwoNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListNode a = new ListNode(5);
		ListNode b = new ListNode(5);
		ListNode c = new ListNode(0);
		ListNode d = new ListNode(1);
		ListNode e = new ListNode(2);
		ListNode f = new ListNode(1);
		ListNode g = new ListNode(0);
		ListNode h= new ListNode(1);
		
//		a.next = b;
//		b.next = c;
//		c.next = d;
//		
//		e.next = f;
//		f.next = g;
//		g.next = h;
		
		ListNode result = addTwoNumbers(a, b);
		while(result!=null){
			System.out.print(result.val+ " " );
			result = result.next;
		}

	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (l1 == null && l2 == null)
			return null;
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if(l1.val == 0 && l2.val == 0)
			return new ListNode(0);
			
		ListNode h1 = switchDirection(l1);
		ListNode h2 = switchDirection(l2);
		
		ListNode temp1 = h1;
		ListNode temp2 = h2;
		
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
		
		if(temp1!=null){
			
			ret.next = temp1;
			ret = ret.next;
			temp1 = temp1.next;
		}
		if(temp2!=null){
			ret.next = temp2;
			ret = ret.next;
			temp1 = temp2.next;
		}
		
		
		//ListNode newHead = switchDirection(head);
		return head;

	}
	
	private static boolean calculate(int val1, int val2, ListNode ret, boolean hasCarry){
		int sum = hasCarry?val1+val2+1:val1+val2;
		boolean hasNewCarry = false;
		if(sum>=10)
			hasNewCarry = true;
		ret.val = (sum%10);
		
		return hasNewCarry;
		
	}
	
	private static ListNode switchDirection(ListNode node){
		ArrayList<ListNode> tempList = new ArrayList<ListNode>();
		
		ListNode tempNode = node;
		
		while(tempNode!=null){
			tempList.add(tempNode);
			tempNode = tempNode.next;
		}
		
		for(int i = tempList.size()-1; i >0; i--){
			tempList.get(i).next = tempList.get(i-1);
		}
		
		tempList.get(0).next = null;
		
		return tempList.get(tempList.size()-1);
	}
	
	

}
