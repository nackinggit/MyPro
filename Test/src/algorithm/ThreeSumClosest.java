package algorithm;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class ThreeSumClosest {
	public int threeSumClosest(int[] num, int target) {
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		
		for(int i=0; i<num.length; i++) {
			map.put(target-num[i], i);
		}
		
		int sum = 0;
		int i = 0;
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(i < 3) {
				i++;
				sum += num[entry.getValue()];
			}
			else {
				break;
			}
		}
		
		return sum;
    }
	
	public int threeSumClosest1(int[] num, int target) {
		int result = num[0] + num[1] + num[num.length - 1];
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1, end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
	}
	
	public static void main(String[] args) {
		int[] num = {-1, 1, 1};
		int target = 0;
		
		ThreeSumClosest tsc = new ThreeSumClosest();
		System.out.println(tsc.threeSumClosest(num, target));
	}
}
