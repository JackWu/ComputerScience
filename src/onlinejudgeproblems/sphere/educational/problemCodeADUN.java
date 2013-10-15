package onlinejudgeproblems.sphere.educational;

import java.math.BigInteger;
import java.util.Scanner;

class problemCodeADUN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
		
			String xStr = in.nextLine();
			String yStr = in.nextLine();
			
			if(xStr != null && yStr !=null){
				BigInteger x = new BigInteger(xStr);
				BigInteger y = new BigInteger(yStr);
	
				BigInteger sum = x.add(y);
				
				
				
				System.out.println(sum.toString());
				
			}else{
				System.exit(0);
			}
		}

		

	}

}
