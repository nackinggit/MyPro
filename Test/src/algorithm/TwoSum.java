package algorithm;

import java.util.HashMap;

public class TwoSum {
	public static int[] twoSum(int[] numbers, int target) {
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0; i<numbers.length; i++) {
			int x = numbers[i];
			
			if(map.containsKey(target-x)) {
				return new int[] { map.get(target-x) + 1, i+1 };
			}
			
			map.put(x, i);
		}
		
		System.out.println("No such two argument.");
		System.exit(0);
		
		return new int[]{0,0};
	}
	
	public static void main(String[] args) {
		int[] a = {0,1,2,3,5,6,8,111,222,333,444,5556,66666};
		int target = 888;
		int[] index = twoSum(a, target);
		
		System.out.println(index[0]);
		System.out.println(index[1]);
	}
}
