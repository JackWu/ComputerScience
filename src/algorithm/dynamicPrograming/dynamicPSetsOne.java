package algorithm.dynamicPrograming;

public class dynamicPSetsOne {
	
	public int maxProd(int n){
		int[] val = new int[n+1];
		val[0]=val[1]=0;
		
		int maxVal = 0;
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= i/2; j++){
				maxVal = maxOfThree(maxVal, j*(i-j), j*val[i-j]);
				val[i]=maxVal;
			}
		}
		return maxVal;
	}
	
	public int maxOfThree(int x, int y, int z){

		return Math.max(Math.max(x, y), z);
	}
	
	public int longestCommonSubString(char[] strOne, char[] strTwo, int lengthOne, int lengthTwo){
		int[][] lcs = new int[lengthOne][lengthTwo];
		int result = 0;
		
		for(int i = 0; i < lengthOne; i++){
			for(int j = 0; j < lengthTwo; j++){
				if(i==0||j==0){
					lcs[i][j] = 0;
				}else if(strOne[i-1] == strTwo[j-1]){
					
					lcs[i][j] = lcs[i-1][j-1]+1;
					result = Math.max(result, lcs[i][j]);
					
				}else{
					lcs[i][j]=0;
				}
			}
		}
		
		return result;
	}
	
	public void testLongestCommonSubString(){
		String strOne = "OldSite:GeeksforGeeks.org";
		String strTwo = "NewSite:GeeksQuiz.com";
		int x = this.longestCommonSubString(strOne.toCharArray(), strTwo.toCharArray(), strOne.toCharArray().length, strTwo.toCharArray().length);
		System.out.println(x);
	}

}
