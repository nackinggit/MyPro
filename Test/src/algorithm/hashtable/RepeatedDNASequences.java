package algorithm.hashtable;

import java.util.ArrayList;
import java.util.List;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
 * for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to
 * identify repeated sequences within the DNA.
 * 
 * Write a function to find all the 10-letter-long sequences (substrings) that
 * occur more than once in a DNA molecule.
 * 
 * For example, Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * 
 * Return: ["AAAAACCCCC", "CCCCCAAAAA"].
 * 
 * 
 * @author Nacking
 * 
 */
public class RepeatedDNASequences {
	private static int[] table = new int ['Z'];
	
	static {
		table['A'] = 0;
		table['C'] = 1;
		table['T'] = 2;
		table['G'] = 3;
	}
	
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> res = new ArrayList<>();
		int buckets = 1<<16;
		System.out.println(buckets);
		int[] dup = new int[buckets];
		int[] added = new int[buckets];
		
		int len = s.length();
		int c = 0;
		if(len <= 10) return res;
		
		for(int i=0; i<10; i++) {
			c = ((c << 2) | table[s.charAt(i)]) & 0xfffff;
			//System.out.println(c);
		}
		
		dup[c/32] = 1 << (c%32);
		
		for(int i=1; i <= len - 10; i++) {
			c = ((c<<2) | table[s.charAt(i+9)]) & 0xfffff;
			int b = c/32;
			int bits = 1<< (c%32);
			
			if((dup[b] & bits) != 0) {
				if((added[b] & bits ) == 0) {
					res.add(s.substring(i,i+10));
					added[b] |= bits;
				}
			}
			dup[b] |= bits;
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		
		RepeatedDNASequences r = new RepeatedDNASequences();
		
		System.out.println(r.findRepeatedDnaSequences(s));

	}
}
