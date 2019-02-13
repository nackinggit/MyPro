import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;

public class TestInOut {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// fis and fos
		// FileInputStream fis = null;
		// FileOutputStream fos = null;
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		// int hasRead;

		try {
			// fis = new FileInputStream("Test.txt");
			// fos = new FileOutputStream("newFile.txt");
			fr = new FileReader("Test.txt");
			fw = new FileWriter("newFile.txt");

			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			// use a bytes[] of buff to store datas
			// byte[] buff = new byte[32];
			// char[] cbuff = new char[32];
			// 从fis流中读取数据（read）到buff，并把buff传递到fos，然后fos流write buff到newFile。
			/*
			 * while((hasRead = fr.read(cbuff)) == 32) { System.out.print(new
			 * String(cbuff)); fw.write(cbuff, 0, hasRead); }
			 */
			String buffer = null;
			while ((buffer = br.readLine()) != null) {
				System.out.println(buffer);
				fw.write(buffer + "\r\n");
			}

			// System.out.print(new String(cbuff));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// if(fis != null) fis.close();
			// if(fos != null) fos.close();
			if (fr != null)
				fr.close();
			if (fw != null)
				fw.close();
			if (br != null)
				br.close();
			if (bw != null)
				bw.close();
		}
	}
}
