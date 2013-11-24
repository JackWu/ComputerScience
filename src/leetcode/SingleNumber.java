package leetcode;

import java.util.Hashtable;

public class SingleNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//Two repeat
	public int singleNumber(int[] x){
		
		int ret = 0;
		
		for(int i = 0; i < x.length; i++)
			ret ^= x[i];
		
		return ret;
		
	}
	//Three repeat
	public int singleNumberThree(int[] A){
	    Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();  
	    for(int i = 0; i < A.length; i++){  
	        if(table.containsKey(A[i]))  
	            table.put(A[i], table.get(A[i]) + 1);  
	        else  
	            table.put(A[i], 1);  
	    }  
	    for(int i = 0; i < A.length; i++){  
	        if(table.get(A[i]) != 3)  
	            return A[i];  
	    }  
	    
	    return 0;
		
	}
	
	//Three repeat Bit operation, no extra space
	public int singleNumberThreeBit(int[] A){
	    int ones = 0, twos = 0;  
	    int commonBitMask = 0;  
	    for(int i = 0; i < A.length; i++){  
	        twos |= (ones & A[i]);  
	        ones ^= A[i];  
	        commonBitMask = ~(ones & twos);  
	        ones &= commonBitMask;  
	        twos &= commonBitMask;  
	    }  
	    return ones; 
		
	}
	
	//Three repeat perfect solution
	public int singleNumberThreePerfect(int[] A){
	    int[] count = new int[32];  
	    int result = 0;  
	    for (int i = 0; i < 32; ++i) {  
	        count[i] = 0;  
	        for (int j = 0; j < A.length; ++j) {  
	            if (((A[j] >> i) & 1) != 0)  
	                count[i] = (count[i] + 1) % 3;  
	        }  
	        result |= (count[i] << i);  
	    }  
	    return result;
		
	}

}
