package algorithm.dp;

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		if (grid.length == 0)
			return 0;

		int row = grid.length;
		int col = grid[0].length;
		int[][] res = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				res[i][j] = 0;
			}
		}
		res[0][0] = grid[0][0];
		for (int i = 1; i < col; i++) {
			for (int j = 0; j <= i; j++) {
				res[0][i] += grid[0][j];
			}
		}

		for (int i = 1; i < row; i++) {
			for (int j = 0; j <= i; j++) {
				res[i][0] += grid[j][0];
			}
		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				res[i][j] = Math.min(res[i - 1][j], res[i][j - 1]) + grid[i][j];
			}
		}

		return res[row - 1][col - 1];
	}
	
	public static void main(String[] args) {
		int[][] grid = {{1}};
		MinimumPathSum mps = new MinimumPathSum();
		System.out.println(mps.minPathSum(grid));
	}
}
