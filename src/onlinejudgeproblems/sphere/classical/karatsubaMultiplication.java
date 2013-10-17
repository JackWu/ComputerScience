package onlinejudgeproblems.sphere.classical;

import java.math.BigInteger;
import java.util.Scanner;

class karatsubaMultiplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		
		int data_size = Integer.parseInt(in.nextLine());
		
		for(int i = 0; i < data_size; i++){
			String next = in.nextLine();
			String[] next_items = next.split(" ");
			BigInteger x = new BigInteger(next_items[0]);
			BigInteger y = new BigInteger(next_items[1]);
			System.out.println(karatsuba(x, y));
		
			
		}

	}
	public static BigInteger karatsuba(BigInteger x, BigInteger y) {
		int N = Math.max(x.bitLength(), y.bitLength());
		if(N <= 2000) return x.multiply(y);
		
		N = (N/2) + (N%2);
		BigInteger b = x.shiftRight(N);
		BigInteger a = y.subtract(b.shiftLeft(N));
        BigInteger d = y.shiftRight(N);
        BigInteger c = y.subtract(d.shiftLeft(N));

        // compute sub-expressions
        BigInteger ac    = karatsuba(a, c);
        BigInteger bd    = karatsuba(b, d);
        BigInteger abcd  = karatsuba(a.add(b), c.add(d));

        return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(N)).add(bd.shiftLeft(2*N));
			
		
		
	}

}
