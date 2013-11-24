package leetcode;

import java.util.ArrayList;

public class reoderList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public void reorderList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head == null)
            return;
        if(head.next == null)
            return;
            
        ListNode temp = head;
        ArrayList<ListNode> nodeHolder = new ArrayList<ListNode>();
        while(temp!=null){
            nodeHolder.add(temp);
            temp = temp.next;
        }
        
        int frontIndex = 0;
        int rearIndex = nodeHolder.size()-1;
        
        while(frontIndex<rearIndex && rearIndex-frontIndex !=1){
            nodeHolder.get(frontIndex).next = nodeHolder.get(rearIndex);
            nodeHolder.get(rearIndex).next = nodeHolder.get(frontIndex+1);
            frontIndex++;
            rearIndex--;
            
        }
        
        nodeHolder.get(rearIndex).next=null;
        
        
        
    }

}
