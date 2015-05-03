import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * ��Ҫʵ����һ���ļ�����ӣ���ȡ���������� ����RandomAccessFile
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
			String str = new String("���¼�ʱ�У��Ѿ�������.\r\n");
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
