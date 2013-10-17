package algorithm.dynamicPrograming;

public class DPQuestion {
	
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
	
	public static int knapSack(int W, int[] wt, int val[], int n){
		
		//base case
		if(n==0 || W==0){
			return 0;
		}
		
		if(wt[n-1] > W){
			return knapSack(W, wt, val, n-1);
			
		}else{
			return Math.max(val[n-1]+knapSack(W-wt[n-1], wt, val, n-1), knapSack(W, wt, val, n-1));
		}
	
	}
	
	public static int knapSackDP(int W, int[] wt, int val[], int n){
		
		
		int i, w;
		
		int[][] K = new int[n+1][W+1];
		
		for(i = 0; i <= n; i++){
			for(w = 0; w <= W; w++){
				if(i==0|| w==0){
					K[i][w] = 0;
				}
				else if(wt[i-1] <= w){
					K[i][w] = Math.max(val[i-1] + K[i-1][w-wt[i-1]], K[i-1][w]);
				} else {
					K[i][w] = K[i-1][w];
				}
				
				printGrid(K);
				
			}
		}
		
		return K[n][W];
	}
	
	public static String printGrid(int[][] grid) {
		String result = "\n";
		for (int row = 0; row < grid.length; row++) {
			for (int column = 0; column < grid[row].length; column++)
				result += grid[row][column] + " ";
			result += "\n";
		}
		
		System.out.println(result);
		return result;
	}
	
	public static void knapPackTest(){
		int val[] = { 60, 100, 120,};
		int wt[] = { 10, 20, 30};
		int W = 50;
		
		int n = val.length;
		

		System.out.println(DPQuestion.knapSackDP(W, wt, val, n));
		
	}

}
