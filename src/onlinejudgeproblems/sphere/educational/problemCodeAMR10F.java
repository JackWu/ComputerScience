package onlinejudgeproblems.sphere.educational;

import java.util.Scanner;

class problemCodeAMR10F {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		
		int testSize = Integer.parseInt(in.nextLine());
		
		for(int i = 0; i < testSize; i++){
			String next = in.nextLine();
			String[] next_items = next.split(" ");
			int x = Integer.parseInt(next_items[0]);
			int y = Integer.parseInt(next_items[1]);
			int z = Integer.parseInt(next_items[2]);
			int last_num  =y;
			
			for(int j = 0; j < x-1; j++){
				last_num = last_num + z;

				
			}
			int result = x*(y+last_num)/2;
			System.out.println(result);
			
			
			
		}

	}

}
