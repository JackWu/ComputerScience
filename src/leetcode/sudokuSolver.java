package leetcode;

public class sudokuSolver {

    public void solveSudoku(char[][] board) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
    	solverHelper(board);
        
    }
    
    boolean solverHelper(char[][] board){  
     for(int i = 0; i < 9; i++)  
     {  
       for(int j = 0; j < 9; j++)  
       {  
         if(board[i][j] == '.')  
         {  
           for(int k = 1; k <= 9; k++)  
           {  
             board[i][j] = (char)(k + '0');  
             if(isValid(board, i, j) && solverHelper(board))  
               return true;  
             board[i][j] = '.';  
           }  
           return false;  
         }  
       }  
     }  
     return true;  
   }
    
    boolean isValid(char[][] board, int i, int j) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        

    	for(int ii = i; ii<9;i++){
    		if(ii!=i&&board[ii][i]==board[i][j]){
    			return false;
    		}
    	}
    	for(int jj = j; jj<9; j++){
    		if(jj!=j&&board[i][jj]==board[i][j])
    			return false;
    	}
    	
    	for(int ii=3*(i/3); ii<3*(i/3)+3; ii++){
    		for(int jj=3*(j/3); jj<3*(j/3)+3; jj++){
    			if(i!=ii&&j!=jj&&board[i][j]==board[ii][jj]){
    				return false;
    			}
    		}
    	}
    	
    	return false;
    }

}
