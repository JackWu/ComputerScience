package leetcode;

import java.util.ArrayList;


public class MedianOfTwoSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3};
		int[] B = {1,2};
		double result = findMedianSortedArrays(A, B);
		System.out.println(result);

	}

    public static double findMedianSortedArrays(int A[], int B[]) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(A.length<=0)
            return getMedian(B);
        if(B.length<=0)
            return getMedian(A);
        
        int sizeA = A.length;
        int sizeB = B.length;
        int mergedSize = sizeA + sizeB;
        int[] merged = new int[sizeA+sizeB];
        
        int i = 0, j = 0, k = 0;
        
        while(i<A.length&&j<B.length){
            if(A[i]<= B[j]){
                merged[k++] = A[i++];
            }else{
                merged[k++] = B[j++];
            }
                
        }
        
        while(i<A.length){
            merged[k++] = A[i++];
        }
        
        while(j<B.length){
            merged[k++] = B[j++];
        }
        
        double result = getMedian(merged);
        
        return result;
        
    }
    
    private static double getMedian(int[] nums){
    	
    	ArrayList<Integer> x = new ArrayList<Integer>();
    	int z = 4444;
    	
    	
        int size = nums.length;
        double result = 0.0;
        if(size % 2 == 0){
            int medianIndex = size/2-1;
            double valueOne = (double)nums[medianIndex];
            double valueTwo = (double)nums[medianIndex+1];
            result = (valueOne+valueTwo)/2;
        }else{
            result = (double)nums[size/2];
        }
        
        return result;
    }
	
}
