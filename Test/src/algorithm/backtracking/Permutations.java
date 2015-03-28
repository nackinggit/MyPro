package algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 求一个数组的全排列，效率不高
 * @author Nacking
 *
 */
public class Permutations {
	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> res = new ArrayList<>();
		
		if(num.length == 0) return null;
		
		res = realPermute(num, 0, num.length);
		
		return res;
	}
	
	private List<List<Integer>> realPermute(int[] num, int s, int e) {
		List<Integer> list = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		if(s == e) {
			for(int i=0; i<e; i++) {
				list.add(num[i]);
			}
			res.add(list);
		}
		
		for(int i = s; i < e; i++) {
			if(isSwap(num, s, i)) {
				swap(num, i, s);
				res.addAll(realPermute(num, s+1, e));
				swap(num, i, s);
			}
		}
		return res;
	}

	private boolean isSwap(int[] num,int s,int e) {
		for (int i = s; i < e; i++) {
			if (num[i] == num[e]) {
				return false;
			}
		}
		return true; 
	}
	
	private void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	public static void main(String[] args) {
		Permutations p = new Permutations();
		int num[] = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(p.permute(num).size());
	}
}
