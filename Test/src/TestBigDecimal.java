import java.math.BigDecimal;
/**
 * to exhibit that bigdecimal can do 
 * accurate arithmetic progress
 * @author Nacking
 *
 */

public class TestBigDecimal {
	public static void main(String[] args) {
		BigDecimal f1 = new BigDecimal("0.05");
		BigDecimal f2 = BigDecimal.valueOf(0.01);
		BigDecimal f3 = new BigDecimal(0.05);
		
		System.out.println(f1);
		System.out.println(f2);
		System.out.println(f3);
		
		System.out.println("String as params to compute:");
		System.out.println("0.05 + 0.01 = " + f1.add(f2));
		System.out.println("0.05 - 0.01 = " + f1.subtract(f2));
		System.out.println("0.05 * 0.01 = " + f1.multiply(f2));
		System.out.println("0.05 / 0.01 = " + f1.divide(f2));
		
		System.out.println("double: ");
		System.out.println("0.05 + 0.01 = " + f3.add(f2));
		System.out.println("0.05 - 0.01 = " + f3.subtract(f2));
		System.out.println("0.05 * 0.01 = " + f3.multiply(f2));
		System.out.println("0.05 / 0.01 = " + f3.divide(f2));
	}
}
