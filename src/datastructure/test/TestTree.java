package datastructure.test;

import java.util.ArrayList;
import java.util.List;

import datastructure.BTreePrinter;
import datastructure.Node;
import datastructure.TreeStructure;

public class TestTree {

	public static TestTree instance;

	public static TreeStructure t = new TreeStructure();;

	private TestTree() {
		instance = new TestTree();
	}

	public static Node<Integer> buildTestGraph() {
		List<Integer> lst = new ArrayList<Integer>();

		for (int i = 0; i < 15; i++) {
			lst.add(i);

		}

		// System.out.println(lst.toString());

		Node<Integer> graph = t
				.convertArrayToBinaryTree(lst, 0, lst.size() - 1);

		BTreePrinter.printNode(graph);

		return graph;
	}

	public static Node<Integer> buildCustomTestGraph() {

		Node<Integer> node1 = new Node<Integer>(1);
		Node<Integer> node2 = new Node<Integer>(2);
		Node<Integer> node3 = new Node<Integer>(3);
		Node<Integer> node4 = new Node<Integer>(4);
		Node<Integer> node5 = new Node<Integer>(5);
		Node<Integer> node6 = new Node<Integer>(6);
		Node<Integer> node7 = new Node<Integer>(7);

		node1.left = node2;
		node2.left = node3;
		node1.right = node4;
		node2.left = node5;
		node5.left = node6;
		// node6.left = node7;

		BTreePrinter.printNode(node1);

		return node1;
	}

	public static void testTraverse() {

		Node<Integer> node = TestTree.buildTestGraph();

		System.out.println("Preorder");
		t.prevOrder(node);
		System.out.println();
		System.out.println("Inorder");
		t.inOrder(node);
		System.out.println();
		System.out.println("Postorder");
		t.postOrder(node);

	}

	public void testIsBalanced() {
		
		Node<Integer> node = TestTree.buildTestGraph();

		System.out.println("Is balanced: " + t.isBalanced(node));

	}
	
	public static void testHasPathSum(){
		Node<Integer> node = TestTree.buildTestGraph();
		
		System.out.println("Has path sum = 11: " + t.hasPathSum(node, 11));
		
		
	}
	public static void testMorrisTraversal(){
		Node<Integer> node = TestTree.buildTestGraph();
		
		t.morrisTraversal(node);
	}
}
