package nioTest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
	private final static Logger LOGGER = Logger.getLogger(Client.class
			.getName());

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			final int index = i;
			new Thread(new MyRunnable(index)).start();
		}
	}

	private static final class MyRunnable implements Runnable {

		private final int index;

		private MyRunnable(int index) {
			this.index = index;
		}

		@Override
		public void run() {
			SocketChannel socketChannel = null;

			try {
				socketChannel = SocketChannel.open();
				SocketAddress socketAddress = new InetSocketAddress(
						"localhost", 8189);
				socketChannel.connect(socketAddress);

				MyRequestObj requestObj = new MyRequestObj("request_" + index,
						"request_" + index);
				LOGGER.log(Level.INFO, requestObj.toString());
				sendData(socketChannel, requestObj);

				MyResponseObj responseObj = receiveData(socketChannel);
				LOGGER.log(Level.INFO, responseObj.toString());
			} catch (Exception e) {
				LOGGER.log(Level.SEVERE, null, e);
			} finally {
				try {
					socketChannel.close();
				} catch (Exception e) {
				}
			}
		}

		private void sendData(SocketChannel socketChannel,
				MyRequestObj requestObj) throws IOException {
			byte[] bytes = SerializeUtil.toByte(requestObj);
			ByteBuffer buffer = ByteBuffer.wrap(bytes);
			socketChannel.write(buffer);
			socketChannel.socket().shutdownOutput();
		}

		private MyResponseObj receiveData(SocketChannel socketChannel)
				throws IOException {

			MyResponseObj responseObj = null;
			ByteArrayOutputStream bout = new ByteArrayOutputStream();

			try {
				ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
				byte[] bytes;
				int count = 0;

				while ((count = socketChannel.read(buffer)) >= 0) {
					buffer.flip();
					bytes = new byte[count];
					buffer.get(bytes);
					bout.write(bytes);
					buffer.clear();
				}

				bytes = bout.toByteArray();
				Object obj = SerializeUtil.toObject(bytes);
				responseObj = (MyResponseObj) obj;
				socketChannel.socket().shutdownInput();
			} finally {
				try {
					bout.close();
				} catch (Exception e) {
				}
			}

			return responseObj;
		}
	}
}
