package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class BinaryTreeLevelOrderTraversalII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(9);
		TreeNode c = new TreeNode(20);
		TreeNode d = new TreeNode(15);
		TreeNode e = new TreeNode(7);
		
		c.left = d;
		c.right = e;
		
		a.left = b;
		a.right = c;
		
		ArrayList<ArrayList<Integer>> ret = levelOrderBottom(a);
		
		
		for(ArrayList<Integer> x: ret){
			for(Integer y: x){
				System.out.print(y+ " ");
			}
			System.out.println();
		}
		
		
		

	}
	
    public static ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        ArrayList<TreeNode> current = new ArrayList<TreeNode>();
        ArrayList<TreeNode> next = new ArrayList<TreeNode>();
        
        current.add(root);
        
        
        
        while(!current.isEmpty()){
            
            Iterator curIter = current.iterator();
            ArrayList<Integer> curLst = new ArrayList<Integer>();
            
            while(curIter.hasNext()){
                TreeNode temp = (TreeNode)curIter.next();
                
                curLst.add(temp.val);
                
                if(temp.left!=null){
                    next.add(temp.left);
                    
                }
                if(temp.right!=null){
                    next.add(temp.right);
                }
            }
            
            current = next;
            next = new ArrayList<TreeNode>();
            result.add(curLst);
            
            
            
            
        }
        
        // sort the list
        Collections.reverse(result);  
        return result;
        
    }

}
