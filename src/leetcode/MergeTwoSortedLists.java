package leetcode;

public class MergeTwoSortedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static ListNode merge(ListNode l1, ListNode l2){
		ListNode result = null;
		
		if(l1!=null&&l2!=null){
			if(l1.val<l2.val){
				result = l1;
				result.next = merge(l1.next, l2);
			}else{
				result = l2;
				result.next = merge(l1, l2.next);
			}
		}else if(l1!=null){
			result = l1;
		}else if(l2!=null){
			result = l2;
		}
		
		return result;
	}

}
