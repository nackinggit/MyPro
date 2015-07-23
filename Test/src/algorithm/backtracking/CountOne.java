package algorithm.backtracking;

public class CountOne {
	public int countDigitOne(int n) {
        if(n <= 9) return 1;
        return countDigitOne(n-1) + countOne(n);
    }
    
    public int countOne(int n) {
        int number = 0; 
        while(n > 0) {
            if(n%10 == 1) {
                number ++;
            }
            n = n/10;
        }
        return number;
    }
    
    
    public long countOne2(int n) {
    	int count = 0; 
    	int i = 1;
    	int cur = 0, high = 0, low = 0;
    	
    	while( (n/i) != 0 ) {
    		cur = (n/i) % 10;
    		low = n/(i*10);
    		high = n - (n/i)*i;
    		
    		if(cur > 1) {
    			count += (low + 1) *i;
    		}else if(cur == 0) {
    			count += low*i;
    		} else if(cur == 1) {
    			count += (low*i + high + 1);
    		}
    		
    		i *= 10;
    	}
    	
    	return count;
    }
    
    public static void main(String[] args) {
		CountOne c = new CountOne();
		System.out.println(c.countOne2(12000));
	}
}
