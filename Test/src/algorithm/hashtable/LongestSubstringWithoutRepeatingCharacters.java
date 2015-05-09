package algorithm.hashtable;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        if(s.length() == 1) return 1;
        
        char[] cs = s.toCharArray();
        
        int len = cs.length;
        int max = 1, start = 0;
        Map<Character, Integer> set = new HashMap<>();
        
        for(int i = 0; i<len; i++) {
        	if(set.containsKey(cs[i])) {
        		max = Math.max(max, i-start);
        		start = Math.max(set.get(cs[i]) + 1, start);
        	}
        	set.put(cs[i], i);
        }
        
        max = Math.max(max, len-start);
        return max;
    }
	
	public static void main(String[] args) {
		String s = "abcs2abcs15";
		LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(l.lengthOfLongestSubstring(s));
	}
}
