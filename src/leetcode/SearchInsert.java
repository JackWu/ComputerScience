package leetcode;

public class SearchInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = {0};
		
		System.out.println(searchIndex(array, 0));

	}
	
	public static int searchIndex(int[] A, int target){
		
		if(target == 0)
			return 0;
		if(A.length == 0)
			return 0;
		
		for(int i = 0; i < A.length; i ++){
			if(A[i] >= target)
				return i;
			
		}
		
		return A.length;
		
	}

}
