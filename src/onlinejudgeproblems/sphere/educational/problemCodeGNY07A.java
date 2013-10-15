package onlinejudgeproblems.sphere.educational;

import java.util.Scanner;

class problemCodeGNY07A {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int item_size = Integer.parseInt(in.nextLine());
		
		for(int i = 0; i < item_size; i ++){
			String next = in.nextLine();
			String[] next_items = next.split(" ");
			int misspell_index = Integer.parseInt(next_items[0]);
			String word = next_items[1];
			
			StringBuilder sb = new StringBuilder(word);
			sb.deleteCharAt(misspell_index-1);
			word = sb.toString();
			
			System.out.println(i+1 + " "+ word);
			
			
		}
		

	}

}
