package algorithm.recursion;

//Overhead: multiple method invocation
public class Maze {

	private final int TRIED = 3;
	private final int PATH = 7;

	private int[][] grid = { { 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 },
			{ 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1 },
			{ 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0 },
			{ 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1 },
			{ 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1 },
			{ 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	private int rowRow = grid.length;
	private int colLen = grid[0].length;

	private int maxColIndex = colLen - 1;
	private int maxRowIndex = rowRow - 1;

	public boolean traverse(int row, int col) {

		boolean done = false;

		if (isValid(row, col)) {

			grid[row][col] = TRIED;

			if (col == maxColIndex && row == maxRowIndex) {
				done = true;
			} else {
				done = traverse(row+1, col);

				if (!done)
					done = traverse(row, col+1);
				if (!done)
					done =traverse(row -1, col);
				if (!done)
					done = traverse(row, col - 1);
			}

			if (done) {
				grid[row][col] = PATH;
			}
		}

		return done;

	}

	public boolean isValid(int row, int col) {

		boolean isValid = false;
		if (row >= 0 & row <= maxRowIndex && col >= 0 && col < grid[row].length ) {
			if (grid[row][col] == 1) {
				isValid = true;
			}
		}

		return isValid;

	}

	public String toString() {
		String result = "\n";
		for (int row = 0; row < grid.length; row++) {
			for (int column = 0; column < grid[row].length; column++)
				result += grid[row][column] + "";
			result += "\n";
		}
		return result;
	}

}
