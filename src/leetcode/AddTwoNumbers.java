package leetcode;

import java.util.ArrayList;

public class AddTwoNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListNode a = new ListNode(0);
		ListNode b = new ListNode(1);
		
		addTwoNumbers(a, b);

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
			

		StringBuilder numOne = new StringBuilder();
		StringBuilder numTwo = new StringBuilder();

		ListNode tempOne = l1;
		ListNode tempTwo = l2;

		while (tempOne != null) {
			numOne.append(tempOne.val);
			tempOne = tempOne.next;
		}

		while (tempTwo != null) {
			numTwo.append(tempTwo.val);
			tempTwo = tempTwo.next;
		}
		

		int intOne = Integer.parseInt(numOne.toString());
		int intTwo = Integer.parseInt(numTwo.toString());

		int sum = intOne + intTwo;

		char[] sumArray = Integer.toString(sum).toCharArray();

		ListNode ret = new ListNode(sumArray[0]);
		for (int i = 1; i < sumArray.length; i++) {
			ListNode nextNode = new ListNode(sumArray[i]);
			ret.next = nextNode;
			ret = ret.next;
		}
		
		return ret;

	}
	
	

}
