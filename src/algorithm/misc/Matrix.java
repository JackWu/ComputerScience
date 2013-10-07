package algorithm.misc;

import java.util.Random;

public class Matrix {
	
	private int[][] grid = { { 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 },
			{ 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1 },
			{ 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0 },
			{ 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1 },
			{ 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1 },
			{ 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
	
	private char[][] charGrid = null;
	
	int[] row = new int[grid.length];
	int[] col = new int[grid[0].length];
	
	
	public synchronized void initArray(int[] arr){
		for(int i = 0; i < arr.length; i++){
			arr[i]=0;
		}
	}
	
	
	public synchronized void findZero(){
		System.out.println("Before");
		
		

		System.out.println("Row: " + printArray(row));
		System.out.println("Col: " + printArray(col));
		
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid.length; j++){
				if(grid[i][j]==0){
					row[i] = 1;
					col[j] = 1;
				}
			}
		}
		
		System.out.println("After");
		
		System.out.println("Row: " + printArray(row));
		System.out.println("Col: " + printArray(col));
		
		
		
	}
	
	public void traverse(int row, int col){
		
		
		
	}
	
	public synchronized void zeroGrid(){
		
		

		
		
		
	}
	
	public void turnToZero(){
		
		int[][] temp = grid;
		
		System.out.println("Temp before: " + toString(temp));
		
		for(int i=0; i<temp.length; i++){
			for(int j=0; j<temp[0].length; j++){
				if(row[i]==1||col[j]==1){
					temp[i][j] = 0;
				}
			}
		}
		System.out.println("Temp after: " + toString(temp));
		
	}
	
	public void randomGrid(){
		
		Random randomGenerator = new Random();
		
		int zeroCounter = 0;
		
		for(int row = 0; row < grid.length; row++){
			for(int col=0; col < grid[0].length; col++){
				int ranInt = 10 + randomGenerator.nextInt(100 - 10 );
				
				if(ranInt == 0){
					zeroCounter++;
				}
				grid[row][col] = ranInt;
			}
		}
		
		while(zeroCounter < 4){
			int randomRow = randomGenerator.nextInt(grid.length);
			int randomCol = randomGenerator.nextInt(grid[0].length);
			
			int value = grid[randomRow][randomCol];
			
			if(value!=0){
				
				
				grid[randomRow][randomCol] = 0;
				 zeroCounter++;
			}

			
		}
	}
	
	public void generateBlackWhiteBoard(){
		
		charGrid = new char[50][50];
		
		Random rand = new Random();
		for(int i = 0; i < charGrid.length; i++){
			for(int j = 0; j < charGrid.length; j++){
				int randInt = rand.nextInt(100);
				if(randInt%2==0)
					charGrid[i][j] = 'O';
				else
					charGrid[i][j] = 'X';
			}
		}
		
		System.out.println(toStringChar(charGrid));
		
		
	}
	
	public void valid(int row, int col){
		
		
	}
	
	public String toString() {
		String result = "\n";
		for (int row = 0; row < grid.length; row++) {
			for (int column = 0; column < grid[row].length; column++)
				result += grid[row][column] + " ";
			result += "\n";
		}
		
		System.out.println(result);
		return result;
	}
	
	public String toString(int[][] grid) {
		String result = "\n";
		for (int row = 0; row < grid.length; row++) {
			for (int column = 0; column < grid[row].length; column++)
				if(grid[row][column]==0){
					result += "00" + " ";
				}else {
					result += grid[row][column] + " ";					
				}
			result += "\n";
		}
		return result;
	}
	
	
	public String toStringChar(char[][] grid) {
		String result = "\n";
		for (int row = 0; row < grid.length; row++) {
			for (int column = 0; column < grid[row].length; column++)
					result += grid[row][column] + " ";		
			result += "\n";
		}
		return result;
	}
	
	public String printArray(int[] arr){
		String result = "\n";
		
		for(int i = 0; i < arr.length; i++){
			result += arr[i] + " ";
		}
		
		result += "\n";
		
		return "\u001B31;1m"+result;
	}

}
