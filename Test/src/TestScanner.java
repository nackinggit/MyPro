import java.util.Scanner;

public class TestScanner {
	public static void main(String[] args) {
		// define a scanner obj
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			System.out.println("the content input are:" + scanner.next());
		}
	}
}
