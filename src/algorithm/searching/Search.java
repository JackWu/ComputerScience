package algorithm.searching;

import java.util.Arrays;
import java.util.Random;

public class Search {
	
	public int binarySearch(int key, int[] a){
		int lo = 0;
		int hi = a.length -1;
		while(lo<=hi){
			int mid = lo+(hi-lo)/2;
			if(key<a[mid]) hi = mid -1;
			else if(key> a[mid]) lo = mid +1;
			else return mid;
		}
		return -1;
	}
	
	
	//boundary case is not resolved
	public void moveZerosToBack(int[] arr, int left, int right){
		System.out.println(Arrays.toString(arr));
		if(left > right){
			System.out.println(Arrays.toString(arr));
			return;
		}
		
		while(arr[left] != 0)
			left++;
		
		while(arr[right] == 0)
			right--;
		
		int temp = arr[right];
		arr[right] = arr[left];
		arr[left] = temp;
		
		if(left < right){
		
			moveZerosToBack(arr, left+1, right-1);
		}

	}
	
	public void testMoveZerosToBack(){
		
		int[] arr = new int[101];
		int countRandomZero = 0;
		int hasZero = 0;
		Random rand = new Random();
		for(int i = 0; i < 101; i++ ){
			
			int nextInt = rand.nextInt(10);
			if(nextInt == 0)
				countRandomZero++;
			arr[i]=nextInt;
		}
		
		this.moveZerosToBack(arr, 0, arr.length-1);
		
		for(int z = arr.length -1; z >= 0; z--){
			
			if(arr[z]!=0)
				break;
			
			hasZero++;
			
		}
		
		System.out.println("has zero: " + hasZero);
		System.out.println("countRandomZero: " + countRandomZero);
	}

}
