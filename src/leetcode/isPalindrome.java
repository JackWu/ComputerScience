package leetcode;

public class isPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(isPalindrome("1a2"));

	}
	
    public static boolean isPalindrome(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(s ==null||s.length()<=0)
            return true;
        int frontIndex=0;
        int backIndex = s.length()-1;
        
        char[] strChar = s.toCharArray();
        
        while(frontIndex < backIndex){
            while(!Character.isLetterOrDigit(strChar[frontIndex])&&frontIndex<s.length()-1)
                frontIndex++;
            while(!Character.isLetterOrDigit(strChar[backIndex])&&backIndex>0)
                backIndex--;
            if(Character.isUpperCase(strChar[frontIndex]))
                strChar[frontIndex] = Character.toLowerCase(strChar[frontIndex]);
            if(Character.isUpperCase(strChar[backIndex]))
                strChar[backIndex] = Character.toLowerCase(strChar[backIndex]);
            if(strChar[frontIndex]!=strChar[backIndex]&&(Character.isLetterOrDigit(strChar[frontIndex])&&Character.isLetterOrDigit(strChar[backIndex]))){
                return false;
            }else{
                frontIndex++;
                backIndex--;
                
            }
        }
        return true;
        
        
    }


}
