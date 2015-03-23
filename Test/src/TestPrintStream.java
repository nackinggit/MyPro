import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;


public class TestPrintStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		PrintStream ps = null;
		try{
			//define a FileOutputStream
			FileOutputStream fos = new FileOutputStream("Test.txt");
			//packaging the fos with a PrintStream
			ps = new PrintStream(fos);
			//print
			ps.println("ordinary strings");
			ps.println(new Test());
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(ps != null) {
				ps.close();
			}
		}
	}
}
