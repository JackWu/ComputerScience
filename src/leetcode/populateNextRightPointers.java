package leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class populateNextRightPointers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeLinkNode a = new TreeLinkNode(1);
		TreeLinkNode b = new TreeLinkNode(2);
		TreeLinkNode c = new TreeLinkNode(3);
		a.left = b;
		a.right = c;
		connect(a);

	}
	
    public static void connect(TreeLinkNode root) {        
        if(root == null)
            return;
        if(root.left==null && root.right==null){
            root.next = null;
            return;
        }
        
        Queue<TreeLinkNode> current = new LinkedList<TreeLinkNode>();
        
        root.next = null;
        current.add(root);
        
        Queue<TreeLinkNode> next = new LinkedList<TreeLinkNode>();
        
        
        
        
        while(!current.isEmpty()){
            
            Iterator curIter = current.iterator();
            
            while(curIter.hasNext()){
                TreeLinkNode temp = (TreeLinkNode)curIter.next();
                
                
                
                if(temp.left!=null){
                    next.add(temp.left);
                }
                if(temp.right!=null){
                    next.add(temp.right);
                }
            }
            
            Iterator nextIter = next.iterator();
            
            TreeLinkNode tempNext = null;
            
            while(nextIter.hasNext()){
            
            	if(tempNext == null){
            		tempNext = (TreeLinkNode)nextIter.next();
            	}else{
            		tempNext.next = (TreeLinkNode)nextIter.next();
            		tempNext = tempNext.next;
            		
            	}
            }
            
            tempNext = null;
            
            current = next;
            next = new LinkedList<TreeLinkNode>();
        }
        
            
    }
}
