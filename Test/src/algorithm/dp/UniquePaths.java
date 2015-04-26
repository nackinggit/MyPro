package algorithm.dp;
/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 3 x 7 grid. How many possible unique paths are there?

Note: m and n will be at most 100.
 * @author Nacking
 *
 */
public class UniquePaths {
	public int uniquePaths(int m, int n) {
		int[][] p = new int[m][n];	//p[i][j]为走到（i,j）位置的唯一路径的方法数 

		for(int i=0; i<p.length; i++) {
			p[i][0] = 1;
		}
		
		for(int i=0; i<p[0].length; i++) {
			p[0][i] = 1;
		}
		
		for(int i=1; i<m; i++) {
			for(int j=1; j<n; j++) {
				p[i][j] = p[i-1][j] + p[i][j-1];
			}
		}
		
		return p[m-1][n-1];
    }
	
	public static void main(String[] args) {
		UniquePaths up = new UniquePaths();
		int m=3, n=7;
		System.out.println(up.uniquePaths(m, n));
	}
}
