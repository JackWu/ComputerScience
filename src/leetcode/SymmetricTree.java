package leetcode;

public class SymmetricTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean isSymmetricTree(TreeNode root){
		
		if(root==null)return true;
		
		return isSym(root.left, root.right);
	}
	
	public static boolean isSym(TreeNode left, TreeNode right){
		if(left == null || right == null) return left == null && right == null;
		return (left.val == right.val) && isSym(left.left, right.right)&&isSym(left.right, right.left);
	}

}
