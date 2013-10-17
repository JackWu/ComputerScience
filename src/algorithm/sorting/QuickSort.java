package algorithm.sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
	
	/*
	 * Analysis: Average case O(n^2)
	 */
	
	public static void quicksort(int low, int high, int[] numbers){
		
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
	
	private static void exchange(int i, int j, int[] numbers){
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
	
	public static void quickSortTest(){
		
		int[] num = new int[50];
		Random rand = new Random();
		for(int i =0; i< num.length; i++){
			num[i] = rand.nextInt(100);
		}
		
		System.out.println(Arrays.toString(num));
		
		QuickSort.quicksort(0, num.length-1, num);
		
		System.out.println(Arrays.toString(num));
		
	}

}
