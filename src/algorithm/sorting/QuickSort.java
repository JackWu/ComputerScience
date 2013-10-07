package algorithm.sorting;

public class QuickSort {
	
	/*
	 * Analysis: Average case O(n^2)
	 */
	
	public void quicksort(int low, int high, int[] numbers){
		
		int i = low, j = high;
		
		int pivot = numbers[low+(high-low)/2];
		
		while(i<=j){
			
			while(numbers[i]<pivot){
				i++;
			}
			while(numbers[j]>pivot){
				j--;
			}
			if(i<=j){
				exchange(i,j, numbers);
				i++;
				j--;
			}
		}
		if(low < j)
			quicksort(low, j, numbers);
		if(i < high)
			quicksort(i, high, numbers);
	}
	
	private void exchange(int i, int j, int[] numbers){
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

}
