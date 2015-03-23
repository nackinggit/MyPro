package algorithm;

public class ReverseIntTest {
	
	public static int reverse(int x) {
		
		int ret = 0;
        while (x != 0) {
        // handle overflow/underflow
        if (Math.abs(ret) > 214748364) {
            return 0;
        }
        ret = ret * 10 + x % 10;
        x /= 10;
   }
   return ret;
		
       /*try{ 
		StringBuffer sb = new StringBuffer();
		Integer xx = new Integer(Math.abs(x));
		String s = xx.toString();
		
		if(x<0) {
			sb.append("-");
		}
		
		for(int j = s.length()-1; j>=0; j--) {
				sb.append(s.charAt(j));
			}
		
		return Integer.parseInt(sb.toString());
       } catch(NumberFormatException e) {
    	   return 0;
       }*/
    }
	
	public static void main(String[] args) {
		int x = 2147483641;
		System.out.println(reverse(x));
	}
}
