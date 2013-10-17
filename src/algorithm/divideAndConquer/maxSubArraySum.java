package algorithm.divideAndConquer;

public class maxSubArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		maxSubArrayDrive();

	}

	public static void maxSubArrayDrive(){
		int[] arr = new int[] { -2, -5, 6, -2, -3, 1, 5, -6 };
		int max[] =maxSubArraySumDivideConquer(arr, 0, arr.length-1);
		System.out.println(max[2]);
		System.out.println("max start index:" + max[0]);
		System.out.println("max end index:" + max[1]);
		
	}
	public static int[] maxSubArraySumDivideConquer(int[] arr, int l, int h) {
		if (l == h) {
			int[] result = { l, h, arr[l]};

			return result;

		}

		int m = (l + h) / 2;

		int[] result1 = maxSubArraySumDivideConquer(arr, l, m);
		int[] result2 = maxSubArraySumDivideConquer(arr, m + 1, h);
		int[] result3 = maxCrossingSum(arr, l, m, h);

		return max(result1,result2,result3);

	}

	public static int[] maxCrossingSum(int[] arr, int l, int m, int h) {

		int sum = 0;
		int left_sum = Integer.MIN_VALUE;
		int max_left = -1;
		int max_right = -1;
		for (int i = m; i >= l; i--) {
			sum = sum + arr[i];
			if (sum > left_sum) {
				left_sum = sum;
				max_left = i;
			}
		}

		sum = 0;

		int right_sum = Integer.MIN_VALUE;
		for (int i = m + 1; i <= h; i++) {
			sum = sum + arr[i];
			if (sum > right_sum) {
				right_sum = sum;
				max_right = i;
			}
		}
		int[] result = { max_left, max_right, left_sum + right_sum };
		return result;
	}

	static int[] max(int[] a, int b[]){
		return (a[2]>b[2])?a:b;
	}
	static int[] max(int a[], int[] b, int[] c){
		return max(max(a,b),c);
	}
	
	public static void Kadane(int[] inputArray) {

		int maxStartIndex = 0;
		int maxEndIndex = 0;
		int maxSum = Integer.MIN_VALUE;

		int cumulativeSum = 0;
		int maxStartIndexUntilNow = 0;

		for (int currentIndex = 0; currentIndex < inputArray.length; currentIndex++) {

			int eachArrayItem = inputArray[currentIndex];

			cumulativeSum += eachArrayItem;

			if (cumulativeSum > maxSum) {
				maxSum = cumulativeSum;
				maxStartIndex = maxStartIndexUntilNow;
				maxEndIndex = currentIndex;
			} else if (cumulativeSum < 0) {
				maxStartIndexUntilNow = currentIndex + 1;
				cumulativeSum = 0;
			}
		}

		System.out.println("Max sum         : " + maxSum);
		System.out.println("Max start index : " + maxStartIndex);
		System.out.println("Max end index   : " + maxEndIndex);
	}

}
