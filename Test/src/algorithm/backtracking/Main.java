package algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		/*Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String s = in.nextLine();
			char[] cs = s.toCharArray();
			Arrays.sort(cs);
			s = String.valueOf(cs);
			
			Set<String> ss = new HashSet<>();
			for (int i = 0; i < s.length(); i++) {
				for (int j = i + 1; j < s.length() + 1; j++) {
					String s1 = s.substring(i, j);
					if (isFib(s1)) {
						if(!ss.contains(s1))
							System.out.println(s1);
						ss.add(s1);
					}
				}
			}
		}
		in.close();*/
		
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int m = in.nextInt();
			List<Integer> n = new ArrayList<>();
			while((m/10) != 0) {
				int i = m%10;
				m = m/10;
				n.add(i);
			}
			Collections.reverse(n);
			
			for(int i=0; i<n.size(); i++) {
				int j = n.get(i);
			}
			
		}
		in.close();
	}

	/*private static boolean isFib(String s1) {

		Set<Character> s = new HashSet<>();
		for (int i = 0; i < s1.length(); i++) {
			s.add(s1.charAt(i));
		}
		int num = s.size();
		int arr[] = new int[27];
		arr[0] = arr[1] = 1;
		for (int i = 2; i < arr.length; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}

		Set<Integer> is = new HashSet<>();

		for (int i = 0; i < 100; i++) {
			is.add(arr[i]);
		}

		if (is.contains(num)) {
			return true;
		}

		return false;
	}*/
}
