package algorithm.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct
 * a sentence where each word is a valid dictionary word.
 * 
 * Return all such possible sentences.
 * 
 * For example, given
 * 
 * s = "catsanddog",
 * 
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * 
 * A solution is ["cats and dog", "cat sand dog"].
 * 
 * @author nanjing
 * 
 */
public class WordBreak2 {
	public List<String> wordBreak(String s, Set<String> wordDict) {
		List<String> result = new ArrayList<String>();

		for (int j = s.length() - 1; j >= 0; j--) {
			if (wordDict.contains(s.substring(j)))
				break;
			else {
				if (j == 0)
					return result;
			}
		}

		for (int i = 0; i < s.length() - 1; i++) {
			if (wordDict.contains(s.substring(0, i + 1))) {
				List<String> strs = wordBreak(s.substring(i + 1, s.length()), wordDict);
				if (strs.size() != 0) {
					for (Iterator<String> it = strs.iterator(); it.hasNext();) {
						result.add(s.substring(0, i + 1) + " " + it.next());
					}
				}
			}
		}
		
		if (wordDict.contains(s)) {
			result.add(s);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		String s = "catsanddog";
		Set<String> wordDict = new HashSet<>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		
		WordBreak2 w = new WordBreak2();
		List<String> ls = w.wordBreak(s, wordDict);
	}
}
