package onlinejudgeproblems.sphere.educational;

import java.math.BigInteger;
import java.util.Scanner;

class problemCodeTMUL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		
		int data_size = Integer.parseInt(in.nextLine());
		
		for(int i = 0; i < data_size; i++){
			String next = in.nextLine();
			String[] next_items = next.split(" ");
			BigInteger x = new BigInteger(next_items[0]);
			BigInteger y = new BigInteger(next_items[1]);
			System.out.println(multiply(x, y));
		
			
		}

	}
	public static String multiply(BigInteger x, BigInteger y){

		return x.multiply(y).toString();
		
		
	}

}
