package algorithm.divideAndConquer;

public class minInSortedRotatedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1};
		System.out.println(findMinDup(arr, 0, arr.length-1));

	}

	static int findMin(int[] arr, int low, int high){
		if(high<low)
			return arr[0];
		if(high==low)
			return arr[low];
		int mid = low + (high - low)/2;
		
		//if (mid+1) is minimum
		if(mid < high &&arr[mid+1]<arr[mid])
			return arr[mid+1];
		//if (mid) is minimum
		if(mid>low&&arr[mid]<arr[mid-1])
			return arr[mid];
		
		if(arr[high]>arr[low])
			return findMin(arr, low, mid-1);
		return findMin(arr, mid+1, high);
	}
	
	static int findMinDup(int[] arr, int low, int high){
		if(high<low)
			return arr[0];
		if(high==low)
			return arr[low];
		int mid = low + (high - low)/2;
		//if (mid+1) is minimum
		if(mid < high &&arr[mid+1]<arr[mid])
			return arr[mid+1];
		//O(n) time
		if(arr[low] == arr[mid] && arr[high]==arr[mid])
			return Math.min(findMin(arr, low, mid-1), findMin(arr, mid+1, high));
		
		//if (mid) is minimum
		if(mid>low&&arr[mid]<arr[mid-1])
			return arr[mid];
		
		if(arr[high]>arr[low])
			return findMin(arr, low, mid-1);
		return findMin(arr, mid+1, high);
	}
}
