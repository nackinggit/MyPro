package algorithm;

public class CountAndSay {
	public String countAndSay(int n) {
        StringBuffer sb = new StringBuffer();
        
        if(n <= 0) return null;
        
        if(n == 1) return "1";
        
        String str = countAndSay(n-1);
        
        int count = 0;
        char c = str.charAt(0);
        for(int i=0; i<str.length(); i++) {
        	if(c == str.charAt(i)) {
        		count++;
        	} else {
				sb.append(count);
				sb.append(c);
				c = str.charAt(i);
				count = 1;
			}
        }
        
        sb.append(count);
        sb.append(c);
        
        return sb.toString();
    }
	
	public static void main(String[] args) {
		CountAndSay cas = new CountAndSay();
		int n = 5;
		System.out.println(cas.countAndSay(n));
	}
}
