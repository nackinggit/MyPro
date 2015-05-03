package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Pascal1 {
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> res1 = new ArrayList<Integer>(1);
		if (numRows <= 0) {
			return res;
		}
		res1.add(1);
		res.add(res1);

		if (numRows == 1) {
			return res;
		}

		List<Integer> preResi;
		List<Integer> resi;

		for (int i = 1; i < numRows; i++) {
			preResi = new ArrayList<Integer>(res.get(i - 1));
			resi = new ArrayList<Integer>(i + 1);
			int[] m = new int[i + 1];
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					m[j] = 1;
				} else {
					m[j] = preResi.get(j - 1) + preResi.get(j);
				}
				resi.add(m[j]);
			}
			res.add(resi);
		}

		return res;
	}

	public static void main(String[] args) {
		int numRows = 6;
		List<List<Integer>> generate = generate(numRows);

		for (List<Integer> list : generate) {
			System.out.println(list);
		}
	}
}
