package leetcode;

public class LongestSubstringWithoutRepeating {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int ret = lengthOfLongestSubstring("abcdcedf");
		
		System.out.println(ret);

	}
	
	public static int lengthOfLongestSubstring(String s){
		
		int maxLen = 0;
		int n = s.length();
		int i = 0, j = 0;
		
		char[] s_char = s.toCharArray();
		
		boolean[] exist = new boolean[256];
		
		while(j < n){
			if(exist[s_char[j]]){
				maxLen = Math.max(maxLen, j-i);
				if(s_char[i]!=s_char[j]){
					exist[s_char[j]] = false;
					i++;
				}
				i++;
				j++;
				
			}else{
				exist[s_char[j]] = true;
				j++;
			}
		}
		
		maxLen = Math.max(maxLen,n-i);
		
		return maxLen;
		
	}

}
