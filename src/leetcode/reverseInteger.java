package leetcode;

public class reverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(reverse(10));

	}
	
    public static int reverse(int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        char[] numArray = Integer.toString(x).toCharArray();
        
        int frontIndex = 0;
        int backIndex = numArray.length-1;
        
        if(x < 0){
            frontIndex++;
        }
        
        while(frontIndex <= backIndex ){
            char temp = numArray[frontIndex];
            numArray[frontIndex] = numArray[backIndex];
            numArray[backIndex] = temp;
            frontIndex++;
            backIndex--;
        }
        
        return Integer.parseInt(new String(numArray));
        
    }

}
