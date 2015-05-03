package bufferTest;

import java.nio.ByteBuffer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BufferTest {

	public static void main(String[] args) {
		SimpleDateFormat dateFormat = (SimpleDateFormat) DateFormat
				.getInstance();
		dateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
		String newStr = "New String to write to file..."
				+ dateFormat.format(System.currentTimeMillis());
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		buffer.clear();
		buffer.put(newStr.getBytes());
		buffer.flip();
		// System.out.println(buffer.get(42));
		byte[] bytes = new byte[1024];
		buffer.get(bytes, 0, buffer.remaining());
		String curStr = new String(bytes);
		System.out.println(curStr);
		if (!buffer.hasRemaining()) {
			System.out.println("+++++++============");
		}
	}
}
