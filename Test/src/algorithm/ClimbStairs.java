package algorithm;

public class ClimbStairs {
	public int climbStairs(int n) {
		int solutions = 1;
		int prevsolutions = 1;
		int nextsolutions = 0;

		while (n >= 2) {
			n--;
			nextsolutions = prevsolutions;
			prevsolutions = solutions;
			solutions = prevsolutions + nextsolutions;
		}

		return solutions;
	}
}
