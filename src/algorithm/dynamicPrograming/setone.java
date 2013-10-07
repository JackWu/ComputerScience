package algorithm.dynamicPrograming;

public class setone {
	
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

}
