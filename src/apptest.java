
import algorithm.misc.Matrix;
import algorithm.misc.StringProblems;
import algorithm.misc.divideAndConquer;
import algorithm.recursion.Maze;
import algorithm.test.AlgTest;
import datastructure.LinkedList;
import datastructure.NodeX;
import datastructure.StackProblems;
import datastructure.TreeStructure;
import datastructure.test.TestTree;

public class apptest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "abcde";

		StringProblems.printKLengthPerm("abcde", "", s.length(), 2);
	}

	public static void testStringProblem() {
		StringProblems sp = new StringProblems();
		sp.findFirstNonRepeatTwo("sssssvba");
		System.out.println(sp.findFirstNonRepeatTwo("sssssvba"));
	}

	public static void testRotateArray() {

		String[] arr = { "a1", "a2", "a3", "a4", "b1", "b2", "b3", "b4" };
		divideAndConquer d = new divideAndConquer();
		d.rotateArrayWithDivideConquer(1, arr.length, arr);
		for (String s : arr) {
			System.out.print(s + " ");
		}
	}

	public static void testMatrix() {

		Matrix m = new Matrix();

		m.generateBlackWhiteBoard();

	}

	public static void testTree() {

		TreeStructure tree = new TreeStructure();

		// tree.testIsBalanced();

		tree.testpPintLeftNRightViewOfBT();
	}

	public static void testRecursionMaze() {
		Maze r = new Maze();

		System.out.println(r.toString());

		System.out.println(r.toString());

	}

	public static void testLinkedList() {

		LinkedList<String> lst = new LinkedList<>();
		lst.add("0");
		lst.add("1");
		lst.add("2");
		lst.add("3");
		lst.add("4");

		lst.print();

		lst.add(2, "200");

		lst.print();

		lst.add(5, "200");

		lst.add(100, "400");

	}

	public static void testNthToLast() {

		LinkedList<String> lst = new LinkedList<>();
		lst.add("0");
		lst.add("1");
		lst.add("2");
		lst.add("3");
		lst.add("4");
		lst.add("5");
		lst.add("6");
		lst.add("7");

		lst.print();

		NodeX<String> head = lst.getHead();
		lst.nthToTheLast(head, -1);

	}

	public static void testIsBalanced() {
		StackProblems p = new StackProblems();
		System.out.println(p.isBalanced(")(dkk)()"));
		System.out.println(p.isBalanced("((alf)ls)"));
	}

	public static void testTreeBothView() {
	}

}
