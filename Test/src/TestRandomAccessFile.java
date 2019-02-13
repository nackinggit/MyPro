import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 我要实现向一个文件里添加，读取，插入内容 利用RandomAccessFile
 * 
 * @author Nacking
 * 
 */
public class TestRandomAccessFile {
	public static void main(String[] args) {
		// define a obj of acf
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile("C:\\Users\\Nacking\\Desktop\\out.txt",
					"rw");
			raf.seek(raf.length());
			String str = new String("明月几时有，把酒问青天.\r\n");
			byte[] b = str.getBytes();
			raf.write(b);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (raf != null)
					raf.close();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

}
