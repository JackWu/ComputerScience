package algorithm.divideAndConquer;

public class maxSubArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = new int[]{-2, -5, 6, -2, -3, 1, 5, -6};
		int maxSum = maxSubArraySum(arr, 0, arr.length-1);
		System.out.println(maxSum);

	}
	
	public static int maxSubArraySum(int[] arr, int l, int h){
		if(l == h)
			return arr[l];
		
		int m = (l+h)/2;
		
		return Math.max(Math.max(maxSubArraySum(arr, l, m), maxSubArraySum(arr, m+1, h)), maxCrossingSum(arr, l, m, h));
	}
	
	public static int maxCrossingSum(int[] arr, int l, int m, int h){
		
		int sum = 0;
		int left_sum = Integer.MIN_VALUE;
		for(int i = m; i >=1; i--){
			sum = sum + arr[i];
			if(sum > left_sum)
				left_sum = sum;
		}
		
		sum = 0;
		
		int right_sum = Integer.MIN_VALUE;
		for(int i = m+1; i<=h; i++){
			sum = sum + arr[i];
			if(sum > right_sum)
				right_sum = sum;
		}
		
		return left_sum + right_sum;
	}

	
}
