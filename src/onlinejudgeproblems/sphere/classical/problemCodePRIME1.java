package onlinejudgeproblems.sphere.classical;

import java.util.BitSet;
import java.util.LinkedList;
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
			sieve(x, y);
			
			System.out.println();

		}
	}
	
    public static void sieve(int low, int upper){
        LinkedList<Integer> primes = new LinkedList<Integer>();
        BitSet nonPrimes = new BitSet(upper+1);
 
        for (int p = 2; p <= upper ; p = nonPrimes.nextClearBit(p+1)) {
            for (int i = p * p; i <= upper; i += p)
                nonPrimes.set(i);
            if(p>=low)
            	primes.add(p);
        }
        printPrime(primes);
    }
    
    public static void printPrime(LinkedList<Integer> primes){
    	for(int i = 0; i < primes.size(); i++){
    		System.out.println(primes.get(i));
    	}
    }

}
