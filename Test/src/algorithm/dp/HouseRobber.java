package algorithm.dp;
/**
 * 给定一个非负数组，求不相邻最大和
 * @author Nacking
 */
public class HouseRobber {
	public int rob(int[] num) {
		
		if(num == null || num.length == 0) {
			return 0;
		}
		
		int s = num[0];
		int len = num.length;
		if(len == 1) return s;
		
		int s1 = Math.max(s, num[1]);
		
		for(int i=2; i<len; i++) {
			s += num[i];
			int temp = s1;
			if(s1 < s) {
				s1 = s;
			}
			s = temp;
		}
		return s1;
	}
	
	public static void main(String[] args) {
		HouseRobber hr = new HouseRobber();
		
		int[] num = {2,1,1,2};
		System.out.println(hr.rob(num));
	}
}
