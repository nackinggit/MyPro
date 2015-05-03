import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class TestRedirect {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileOutputStream fos = null;
		PrintStream ps = null;
		try {

			fos = new FileOutputStream("ReDirect.txt");
			ps = new PrintStream(fos);
			System.setOut(ps);
			Scanner sc = new Scanner(System.in);
			String str = sc.next();
			ps.append(str);
		} catch (IOException e) {
			// TODO: handle exception
		} finally {
		}
	}

}
