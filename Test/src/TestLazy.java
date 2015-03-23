import java.text.SimpleDateFormat;
import java.util.Calendar;


public class TestLazy {
	public static void main(String[] args) {
		
		SimpleDateFormat format;
		format = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss E");
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(2009, 7, 31);
		calendar.set(Calendar.MONTH, 8);
		String str = format.format(calendar.getTime());
		
		System.out.println(str);
		
		try {
			System.out.println(format.parseObject(str));
		} catch(Exception e) {}
		
		calendar.set(Calendar.DATE, 5);
		System.out.println(calendar.getTime());
	}
}
