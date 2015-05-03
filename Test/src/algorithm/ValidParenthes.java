package algorithm;

import java.util.ArrayList;
import java.util.List;

public class ValidParenthes {
	public boolean isValid(String s) {
		if (s == null)
			return true;
		if (s.length() % 2 == 1)
			return false;
		int count = 0;
		char[] schar = s.toCharArray();
		if (schar[0] == ']' || schar[0] == '}' || schar[0] == ')')
			return false;
		List<Character> l = new ArrayList<>();
		int index = 0;
		for (int i = 0; count < schar.length && i < schar.length;) {
			count++;
			if (schar[i] == '(' || schar[i] == '[' || schar[i] == '{') {
				l.add(schar[i]);
				i++;
				continue;
			}

			index = i;
			int j = index;

			while (l.size() > 0 && j < schar.length) {

				if ((l.get(l.size() - 1) == '(' && schar[j] == ')')
						|| (l.get(l.size() - 1) == '[' && schar[j] == ']')
						|| (l.get(l.size() - 1) == '{' && schar[j] == '}')) {
					i++;
					j++;
					index++;
					l.remove(l.size() - 1);
				} else {
					break;
				}
			}
		}

		if (l.size() == 0)
			return true;
		else {
			return false;
		}
	}

	public static void main(String[] args) {
		ValidParenthes v = new ValidParenthes();
		String s = "[()]";
		System.out.println(v.isValid(s));
	}
}
