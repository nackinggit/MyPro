package algorithm.dp;

/**
 * Follow up for "Unique Paths":
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * For example,
 * 
 * 
 * There is one obstacle in the middle of a 3x3 grid as illustrated below. [
 * [0,0,0], [0,1,0], [0,0,0] ]
 * 
 * 
 * The total number of unique paths is 2.
 * 
 * Note: m and n will be at most 100.
 * 
 * @author Nacking
 * 
 */
public class UniquePaths2 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int n = obstacleGrid[0].length;
		int[] p = new int[n]; // p[i]代表从第一个点走到第i行最后一个点的path
		p[0] = 1;

		for (int[] row : obstacleGrid) {
			for (int i = 0; i < n; i++) {
				if (row[i] == 1) {
					p[i] = 0;
				} else if (i > 0) {
					p[i] += p[i - 1];
				}
			}
		}

		return p[n - 1];
	}

	public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
		int n = obstacleGrid[0].length;
		int m = obstacleGrid.length;
		int[][] p = new int[m][n]; // p[i]代表从第一个点走到第i行最后一个点的path
		p[0][0] = obstacleGrid[0][0] ^ 1;

		for (int i = 1; i < m; i++) {
			p[i][0] = (obstacleGrid[i][0] == 1) ? 0 : p[i - 1][0];
		}

		for (int j = 1; j < n; j++) {
			p[0][j] = (obstacleGrid[0][j] == 1) ? 0 : p[0][j - 1];
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				p[i][j] = (obstacleGrid[i][j] == 1) ? 0 : p[i - 1][j]
						+ p[i][j - 1];
			}
		}

		return p[m - 1][n - 1];
	}
}
