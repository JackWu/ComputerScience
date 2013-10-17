package algorithm.divideAndConquer;

public class fixedPointInAnArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int fixedPointUnsortedArray(int[] arr, int low, int high){
		if(high>=low){
			int mid = (low+high)/2;
			
			if(mid == arr[mid])
				return mid;
			else if(mid > arr[mid])
				return fixedPointUnsortedArray(arr, mid+1, high);
			else
				return fixedPointUnsortedArray(arr, low, mid-1);
		}
		return -1;
		
	}

}
