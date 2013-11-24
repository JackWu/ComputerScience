package leetcode;

import java.util.ArrayList;

public class plusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] x = {9,9,9,9};
		int[] ret = plusOne(x);
		
		for(int y : ret){
			System.out.print(y + " ");
		}

	}
	
    public static int[] plusOne(int[] digits) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        boolean hasCarry = false;
        
        for(int i = digits.length-1; i >= 0; i--){
        
        	
        	if(i== digits.length-1){
        		if(checkHasCarry(digits[i])){
        			digits[i] = 0;
        			hasCarry = true;
        			continue;
        		}else{
        			digits[i] = digits[i]+1;
        			hasCarry = false;
        		}
        	}
        	if(hasCarry){
        		if(checkHasCarry(digits[i])){
        			digits[i] = 0;
        			hasCarry = true;
        		}else{
        			digits[i] = digits[i]+1;
        			hasCarry = false;
        		}
        		
        	}
        }
        
        if(hasCarry){
        	int[] newDigits = new int[digits.length+1];
        	newDigits[0]= 1;
        	int newDigitsIndex = 1;
        	for(int tempInt: digits){
        		newDigits[newDigitsIndex] = tempInt;
        		newDigitsIndex++;
        	}
	        digits = newDigits;
        }
        
        return digits;
        
    }
    
    public static boolean checkHasCarry(int x){
    	
    	if(x+1 >=10){
    		return true;
    	}else{
    		return false;
    	}
    }

}
