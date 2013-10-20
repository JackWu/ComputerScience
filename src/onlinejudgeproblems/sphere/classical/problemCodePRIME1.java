package onlinejudgeproblems.sphere.classical;

import java.util.Scanner;

class problemCodePRIME1 {

	/**
	 * @param args
	 */

	private static final long MEGABYTE = 1024L * 1024L;

	public static long bytesToMegabytes(long bytes) {
		return bytes / MEGABYTE;
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int data_size = Integer.parseInt(in.nextLine());

		for(int i = 0; i < data_size; i++){
			String next = in.nextLine();
			String[] next_items = next.split(" ");

			int x = Integer.parseInt(next_items[0]);
			int y = Integer.parseInt(next_items[1]);
			sieveOfEratoshenes(x, y);

		}
	}
	
	public static void sieveOfEratoshenes(int begin,int end){
		
		boolean[] booleanArray = new boolean[end+1];
		
		for(int i = 0; i<=end; i++){
			booleanArray[i] = true;
		}
		
		for(int i= 2; i*i <=end; i++){
			if(booleanArray[i]){
				for(int j = i; i*j<=end; j++)
					booleanArray[i*j] = false;
			}
		}
		for(int i = begin; i < booleanArray.length;i++){
			if(booleanArray[i])
				System.out.print(i + " ");
			else
				System.out.print("-1" + " ");
		}
		
		System.out.println();
		
	}

}
