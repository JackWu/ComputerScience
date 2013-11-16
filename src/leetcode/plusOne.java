package leetcode;

public class plusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static int[] plusOne(int[] digits) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        boolean hasCarry = false;
        
        for(int i = digits.length-1; i >= 0; i--){
        
        	
        	if(i== digits.length-1){
        		if(digits[i]+1 == 10){
        			digits[i] = 0;
        			hasCarry = true;
        		}else{
        			digits[i] = digits[i]+1;
        			hasCarry = false;
        		}
        	}
        	if(hasCarry){
        		
        	}
        }
        
        return digits;
        
    }
    
    public static int calculate(int x, boolean hasCarry, int[] digits, int index){
    	return 0;
    }

}
