package algorithm.divideAndConquer;

public class findMinMaxUsingMinComparision {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {1000, 11, 445, 1, 330, 3000};
		findMinMaxUsingMinComparision x = new findMinMaxUsingMinComparision();
		x.getMinMax(arr, 0, arr.length-1);

	}
	
	pair getMinMax(int[] arr, int low, int high){
		pair minmax = this.new pair();
		pair mml = new pair();
		pair mmr = new pair();
		int mid;
		
		//case 1: only one element
		if(low==high){
			minmax.max = arr[low];
			minmax.min = arr[low];
			return minmax;
		}
		//case 2: two elements
		if(high == low+1){
			if(arr[low]>arr[high]){
				minmax.max = arr[low];
				minmax.min = arr[high];
			}else{
				minmax.max = arr[high];
				minmax.min = arr[low];
			}
			return minmax;
		}
		
		//case 3: more than 2 elements
		mid = (low+high)/2;
		mml = getMinMax(arr, low, mid);
		mmr = getMinMax(arr, mid+1, high);
		
		if(mml.min < mmr.min)
			minmax.min = mml.min;
		else
			minmax.min = mmr.min;
		
		if(mml.max>mmr.max)
			minmax.max = mml.max;
		else
			minmax.max = mmr.max;
		return minmax;
		
	}
	
	
	private class pair{
		int min;
		int max;
	}

}
