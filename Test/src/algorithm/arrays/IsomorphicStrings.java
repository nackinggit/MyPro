package algorithm.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 * 
 * For example, Given "egg", "add", return true.
 * 
 * Given "foo", "bar", return false.
 * 
 * Given "paper", "title", return true.
 * 
 * @author Nacking
 * 
 */
public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {

		if (s.length() != t.length())
			return false;

		return _isIsomorphic(s, t) && _isIsomorphic(t, s);
	}

	private boolean _isIsomorphic(String s, String t) {
		// TODO Auto-generated method stub
		Map<Character, Character> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char cs = s.charAt(i);
			char ct = t.charAt(i);

			if (!map.containsKey(cs)) {
				map.put(cs, ct);
			} else {
				char v = map.get(cs);
				if (v != ct) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		IsomorphicStrings i = new IsomorphicStrings();
		String s = "abb";
		String t = "aaa";
		System.out.println(i.isIsomorphic(s, t));
	}
}
