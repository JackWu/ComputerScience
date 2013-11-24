package leetcode;

public class hasPathSumClass {
	
    public boolean hasPathSum(TreeNode root, int sum) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if( root == null)
            return false;
        else if(sum-root.val==0&&root.left==null&&root.right==null)
            return true;
        else
            return hasPathSumSecond(root, sum);
        
    }
    
    public boolean hasPathSumSecond(TreeNode node, int sum){
    // return true if we run out of tree and sum==0
        if (node == null) {                                   // empty tree
            // choose one:
            return (sum == 0);
            //return false;
        } else if (node.left == null && node.right == null) { // leaf
            return (sum == node.val);
        //} else if (sum <= node.val) {                        // sum used up
        //    return false;
        } else {                                              // try children
            return (node.left != null  && hasPathSumSecond(node.left, sum - node.val)) ||
                   (node.right != null && hasPathSumSecond(node.right, sum - node.val));
        }
            
    }

}
