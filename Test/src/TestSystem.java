import java.io.FileOutputStream;
import java.util.Map;
import java.util.Properties;

public class TestSystem {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// get all environment path vars of the System
		Map<String, String> env = System.getenv();
		for (String name : env.keySet()) {
			System.out.println(name + "-------->" + env.get(name));
		}
		// get the values of env that has specified
		System.out.println(System.getenv("JAVA_HOME"));
		// get all shuxing of our system
		Properties props = System.getProperties();
		// save props to the file "propts.txt"
		props.store(new FileOutputStream("props.txt"), "System Properties");
		System.out.println(System.getProperty("os.name"));
	}
}
