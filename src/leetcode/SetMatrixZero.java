package leetcode;

public class SetMatrixZero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] matrix ={{0,0,0,5}, {4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
		
		setZeros(matrix);
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j< matrix[0].length; j++){
				System.out.print(matrix[i][j]+ " ");
			}
			System.out.println();
		}

	}
	
	public static void setZeros(int[][] matrix){
		int row = matrix.length;
		int col = matrix[0].length;
		boolean firstRowZero = false, firstColZero = false;
		
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				if(matrix[i][j]==0){
					if(i==0) firstRowZero = true;
					if(j==0) firstColZero = true;
					
					matrix[0][j]=0;
					matrix[i][0]=0;
				}
			}
		}
		
		for(int i = 1; i < row; i++){
			for(int j = 1; j<col; j++){
				if(matrix[i][0]==0||matrix[0][j]==0){
					matrix[i][j]=0;
				}
			}
		}
		
		if(firstRowZero){
			for(int i = 0; i<col; i++){
				matrix[0][i] = 0;
			}
		}
		
		if(firstColZero){
			for(int i = 0; i<row; i++){
				matrix[i][0] = 0;
			}
		}
		
	}

}