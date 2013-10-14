package datastructure;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import datastructure.BTreePrinter;
import datastructure.Node;

public class TreeStructure {

	int maxDepth(Node<Integer> root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	int minDepth(Node<Integer> root) {

		if (root == null) {
			return 0;
		}

		return 1 + Math.min(minDepth(root.left), minDepth(root.right));
	}

	public boolean isBalanced(Node<Integer> root) {

		System.out.println("max: " + maxDepth(root));
		System.out.println("min: " + minDepth(root));

		return maxDepth(root) - minDepth(root) <= 1;
	}

	public Node<Integer> convertArrayToBinaryTree(List<Integer> arr,
			int leftIndex, int rightIndex) {

		if (leftIndex <= rightIndex) {

			int current = (rightIndex + leftIndex) / 2;

			Node<Integer> left = convertArrayToBinaryTree(arr, leftIndex,
					current - 1);
			Node<Integer> right = convertArrayToBinaryTree(arr, current + 1,
					rightIndex);

			Node<Integer> currentNode = new Node<Integer>(arr.get(current));
			currentNode.left = left;
			currentNode.right = right;

			return currentNode;
		}
		return null;

	}

	public void testpPintLeftNRightViewOfBT() {
		List<Integer> lst = new ArrayList<Integer>();

		for (int i = 0; i < 20; i++) {
			lst.add(i);

		}

		// System.out.println(lst.toString());

		Node<Integer> graph = convertArrayToBinaryTree(lst, 0, lst.size() - 1);

		BTreePrinter.printNode(graph);

		findPerimeter(graph);

	}

	public void printLeftNRightViewOfBT(Node<Integer> node) {
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		Node<Integer> LS = new Node<Integer>(null);
		queue.add(node);
		queue.add(LS);

		// left view and right view arrays
		ArrayList<Node<Integer>> leftView = new ArrayList<Node<Integer>>();
		ArrayList<Node<Integer>> rightView = new ArrayList<Node<Integer>>();
		leftView.add(node);

		while (!queue.isEmpty()) {
			Node<Integer> currentNode = queue.remove();
			if (currentNode.equals(LS)) {
				if (!queue.isEmpty()) {
					leftView.add(queue.peek());
					queue.add(LS);
				}
			}
			if (!queue.isEmpty() && queue.peek().equals(LS)) {
				rightView.add(currentNode);
			}
			if (currentNode.left != null) {
				queue.add(currentNode.left);
			}
			if (currentNode.right != null) {
				queue.add(currentNode.right);
			}
		}
		// print views
		printViews(leftView, rightView);
	}

	public void printViews(ArrayList<Node<Integer>> left,
			ArrayList<Node<Integer>> right) {

		System.out.println("Left View:");
		for (Node n : left) {
			System.out.print(n.data + " ");
		}
		System.out.println();
		System.out.println("Right View:");
		for (Node n : right) {
			System.out.print(n.data + " ");
		}

	}

	public static void findPerimeter(final Node root) {
		printTraversal(root, true, true);
	}

	public static void printTraversal(final Node node, boolean isLeft,
			boolean isRight) {
		// pre-order traversal
		if (node == null)
			return;

		if (isLeft || (node.left == null && node.right == null))
			System.out.print(node.data + " ");
		printTraversal(node.left, isLeft ? true : false, false);
		printTraversal(node.right, false, isRight ? true : false);
		if (isRight && !isLeft && (node.left != null || node.right != null))
			System.out.print(node.data + " ");

	}

	// Root, left, right
	public void prevOrder(Node<Integer> node) {
		if (node == null)
			return;
		System.out.print(node.data + " ");
		prevOrder(node.left);
		prevOrder(node.right);
	}

	// Left, root, right
	public void inOrder(Node<Integer> node) {
		if (node == null)
			return;

		inOrder(node.left);
		System.out.print(node.data + " ");
		inOrder(node.right);
	}

	// Left, Right Root
	public void postOrder(Node<Integer> node) {
		if (node == null)
			return;

		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + " ");

	}

	public boolean hasPathSum(Node<Integer> node, int sum) {
		// return true if we run out of tree and sum==0
		if (node == null) {
			return (sum == 0);
		} else {
			// otherwise check both subtrees
			int subSum = sum - node.data;
			return (hasPathSum(node.left, subSum) || hasPathSum(node.right,
					subSum));
		}
	}
	
	public boolean sameTree(Node<Integer> t1, Node<Integer> t2){
		
		if(t1==null&&t2==null) return true;
		
		else if(t1!=null&&t2!=null){
			return t1.data == t2.data&&(sameTree(t1.left, t2.left)&&sameTree(t1.right, t2.right));	
		}
		
		return false;
	}
	
	public void morrisTraversal(Node<Integer> root){
		
		Node<Integer> current, pre;
		
		if(root == null)
			return;
		
		current = root;
		
		while(current != null){
			if(current.left == null){
				System.out.println(current.data);
				current = current.right;
			}else{
				pre = current.left;
				while(pre.right != null && pre.right != current)
					pre = pre.right;
				
				if(pre.right == null){
					pre.right = current;
					current = current.left;
				}else{
					pre.right = null;
					System.out.println(current.data);
					current = current.right;
				}
			}
		}
		
	}
	
	public int size(Node<Integer> node){
		if(node == null){
			return 0;
		}else{
			return(size(node.left)+1 + size(node.right));
		}
	}
	
	private void doubleTree(Node<Integer> node) { 
		  Node oldLeft;

		  if (node == null) return;

		  // do the subtrees 
		  doubleTree(node.left); 
		  doubleTree(node.right);

		  // duplicate this node to its left 
		  oldLeft = node.left; 
		  node.left = new Node<Integer>(node.data); 
		  node.left.left = oldLeft; 
		} 
		 
	
	public void mirror(Node<Integer> node){
		if(node==null){
			return;
		}else{
			Node<Integer> temp;
			
			mirror(node.left);
			mirror(node.right);
			
			temp = node.left;
			node.left=node.right;
			node.right=temp;
		}
	}
	
	
	public int countTrees(int numKeys){
		if(numKeys <= 1){
			return 1;
		}else{
			int sum = 0;
			int left, right, root;
			
			for(root = 1; root<=numKeys; root++){
				left = countTrees(root-1);
				right = countTrees(numKeys - root);
				
				sum+=left*right;
			}
		return sum;

		}
		
	}
	
	private boolean isBST(Node<Integer> node) { 
		  if (node==null) return(true);

		  // do the subtrees contain values that do not 
		  // agree with the node? 
		  if (node.left!=null && maxValue(node.left) > node.data) return(false); 
		  if (node.right!=null && minValue(node.right) <= node.data) return(false);

		  // check that the subtrees themselves are ok 
		  return( isBST(node.left) && isBST(node.right) ); 
		} 
	public int minValue(Node<Integer> node){
		
		Node<Integer> current = node;
		
		while(current.left != null){
			current = current.left;
		}
		return current.data;
	}
	
	public int maxValue(Node<Integer> node){
		
		Node<Integer> current = node;
		
		while(current.right != null){
			current = current.right;
		}
		return current.data;
	}
	
	/** 
	 Tests if a tree meets the conditions to be a 
	 binary search tree (BST). Uses the efficient 
	 recursive helper. 
	*/ 
	public boolean isBST2(Node<Integer> root) { 
	 return( isBST2(root, Integer.MIN_VALUE, Integer.MAX_VALUE) ); 
	}
	/** 
	  Efficient BST helper -- Given a node, and min and max values, 
	  recurs down the tree to verify that it is a BST, and that all 
	  its nodes are within the min..max range. Works in O(n) time -- 
	  visits each node only once. 
	*/ 
	private boolean isBST2(Node<Integer> node, int min, int max) { 
	  if (node==null) { 
	    return(true); 
	  } 
	  else { 
	   // left should be in range  min...node.data 
	    boolean leftOk = isBST2(node.left, min, node.data);

	    // if the left is not ok, bail out 
	    if (!leftOk) return(false);

	    // right should be in range node.data+1..max 
	    boolean rightOk = isBST2(node.right, node.data+1, max);

	    return(rightOk); 
	  } 
	} 
	
	public void printPaths(Node<Integer> node){
		int[] paths = new int[1000];
		printPathsRecur(node, paths, 0);
	}
	
	public void printPathsRecur(Node<Integer> node, int[] path, int pathLen){
		if(node == null)
			return;
		path[pathLen] = node.data;
		pathLen++;
		
		if(node.left == null && node.right==null){
			printArray(path, pathLen);
		}else{
			printPathsRecur(node.left, path, pathLen);
			printPathsRecur(node.right, path, pathLen);
		}
	}
	
	public void printArray(int[] path, int pathLen){
		for(int i = 0; i < pathLen; i++)
			System.out.println(path[i] + " ");
		
		System.out.println();
	}
	  


}
