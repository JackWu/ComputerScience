package algorithm.misc;

public class divideAndConquer {
	
	public void rotateArray(){
	
		String[] arr = {"a1", "a2", "a3", "a4","b1","b2","b3","b4"};
		
		int n = 4;
		
		for(int i=0, j=1; i < n; i++, j+=2){
			rightRotate(arr, j, n+i);			
			
		}
		
		for(String s: arr){
			System.out.print(s+" ");
		}
		
	}
	
	public void rightRotate(String[] arr, int j, int bIndex){

		for(int i = bIndex; i > j; i--){
			String temp = arr[i];
			int previousIndex = i-1;
			arr[i] =arr[previousIndex];
			arr[previousIndex] = temp;
			
		}
	}
	
	public void rotateArrayWithDivideConquer(int left, int right, String[] arr){
		
		if(right!=left){
			
			int mid = (left+right)/2;
			
			for(int i = (left+mid)/2, j=0; i < mid; i++, j++){
				

				
				int xxxx = mid+j+1;
				
				System.out.println("i="+i+" mid="+mid+" mid+j+1=" + xxxx);
				for(String s: arr){
					System.out.print(s+" ");
				}
				
				System.out.println();
				String temp = arr[i];
				arr[i] = arr[mid+j];
				arr[mid+j] = temp;
				
				xxxx = mid+j+1;
				
				System.out.println("i="+i+" mid="+mid+" mid+j+1=" + xxxx);
				for(String s: arr){
					System.out.print(s+" ");
				}
				
				System.out.println();
			}
			
			rotateArrayWithDivideConquer(left, mid, arr);
			rotateArrayWithDivideConquer(mid+1, right, arr);
			
			
		}
		
	}
}
