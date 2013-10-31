package leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class inorderIterative {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		a.left = b;
		ArrayList<Integer> lst = inorderIterative(a);
		for(int z: lst)
			System.out.println(z);

	}
	
	public static ArrayList<Integer> inorderIterative(TreeNode root){

		ArrayList<Integer> lst = new ArrayList<Integer>();
       // Note: The Solution object is instantiated only once and is reused by each test case.
        
        if(root == null){
            return lst;
        }
        if(root.left==null && root.right==null){
            lst.add(root.val);
            return lst;
        }
		
		Stack<TreeNode> s = new Stack<TreeNode>();
		
		TreeNode current = root;
		while(true){
			if(current!=null){
				s.push(current);
				current = current.left;
			}
			else{
				if(!s.isEmpty()){
					current = s.pop();
					lst.add(current.val);
					current = current.right;
				}else{
					break;
				}
			}
		}
		return lst;
	}

}
