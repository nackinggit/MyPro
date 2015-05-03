package nioTest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeUtil {
	public static byte[] toByte(Object obj) {
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(bout);
			oos.writeObject(obj);
			byte[] bytes = bout.toByteArray();
			return bytes;
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			try {
				oos.close();
			} catch (IOException e) {

			}
		}
	}

	public static Object toObject(byte[] bytes) {
		ByteArrayInputStream bin = new ByteArrayInputStream(bytes);
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(bin);
			Object obj = ois.readObject();
			return obj;
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (ClassNotFoundException e1) {
			throw new RuntimeException(e1.getMessage(), e1);
		} finally {
			try {
				ois.close();
			} catch (Exception e) {
			}
		}
	}
}
