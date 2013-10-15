package onlinejudgeproblems.sphere.educational;


import java.util.Scanner;

class problemCodeKNAPSACK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		
		String next = in.nextLine();
		String[] next_items = next.split(" ");
		int capacity = Integer.parseInt(next_items[0]);
		int data_size = Integer.parseInt(next_items[1]);
		
		int[] wt = new int[data_size];
		int[] val = new int[data_size];
		
		for(int i = 0; i < data_size; i++){
			next = in.nextLine();
			next_items = next.split(" ");
			int x_size = Integer.parseInt(next_items[0]);
			int y_val = Integer.parseInt(next_items[1]);
			wt[i] = x_size;
			val[i] = y_val;
			
		}
		


		
		System.out.println(knapSack(capacity, wt, val, data_size));
	}
	
	static int knapSack(int W, int wt[], int val[], int n){
		int i, w;
		int[][] K = new int[n+1][W+1];
		
		for( i = 0; i <=n; i++){
			for(w = 0; w <= W; w++)
			{
				if(i == 0|| w==0)
					K[i][w]=0;
				else if(wt[i-1]<=w){
					K[i][w] = Math.max(val[i-1]+K[i-1][w-wt[i-1]], K[i-1][w]);
				}
				else
					K[i][w] = K[i-1][w];
			}
		}
		
		return K[n][W];
		
	}

}
