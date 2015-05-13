package algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * string×ª»»
 * @author Nacking
 *
 */
public class ConvertString {
	public static String convert(String s) {
		if(s.isEmpty()) return s;
		
		int len = s.length();
		int start = 0, end = 1;
		Set<Character> set = new HashSet<>();
		StringBuffer sb = new StringBuffer();
		
		while(end < len) {
			set.add(s.charAt(start));
			while(end < len && !set.contains(s.charAt(end))) {
				set.add(s.charAt(end));
				end++;
			}
			if(set.size() > 1) {
				convertDifStr(s, start, end);
				start = end;
				end += 1;
				set.clear();
			}
			
			while(end < len && s.charAt(start) == s.charAt(end)) {
				end++;
			}
			if(end - start > 1) {
				convertSameStr(s,start, end);
				start = end;
				end += 1;
				set.clear();
			}

		}
		
		if(start == len - 1) {
			sb.append("!");
			sb.append(s.charAt(start) == '1' ? "!1" : s.charAt(start));
			sb.append("!");
		}
		return sb.toString();
	}
	
	private static void convertSameStr(String s, int start, int end) {
		
	}

	private static void convertDifStr(String s, int start, int end) {
		
	}

	public static void main(String[] args) {
		String s = "11AAAAAAAAAAAAAAABCDEE";
		System.out.println(convert(s));
	}
}
