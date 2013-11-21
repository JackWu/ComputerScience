package leetcode;

public class decodeWays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int numDecodings(String str) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
         int n = str.length();
          if (n == 0)
            return 0;
          int[] c = new int[n+1];
          char[] s = str.toCharArray();
          
          c[0] = 1;
          for(int i = 1; i < n; i++ ) {
            int c1 = 0;
            if (s[i-1] != '0')
              c1 = c[i-1];
            int c2 = 0;
            if (i >= 2 && (s[i-2] == '1' || s[i-2] == '2' && s[i-1] <='6'))
                c2 = c[i-2];
            c[i] = c1 + c2;
          }
        
          return c[n];
    }
    
    public int numDecodingsTwo(String s) {
        if (s.length() == 0) return 0;
	    int[] c = new int[s.length() + 1];
	    c[0] = 1;
	    if (s.charAt(0) != '0')
	     c[1] = c[0];
	    else
	     c[1] = 0;
	    for (int i = 2; i <= s.length(); i++) {
	     if (s.charAt(i - 1) == '0') {
	            c[i] = 0;
	     } else {
	            c[i] = c[i - 1];
	     }
	     if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
	            c[i] += c[i - 2];
	        }
	    }
	    return c[s.length()];
    }
}
