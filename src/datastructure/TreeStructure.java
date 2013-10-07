package datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

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

}
