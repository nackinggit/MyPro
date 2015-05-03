package socketTest_Server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.util.ArrayList;
import java.util.List;

public class SocketTest {

	public static List<Socket> socketList = new ArrayList<Socket>();

	public static void main(String[] args) throws IOException {
		ServerSocketChannel serverChannel = ServerSocketChannel.open();
		serverChannel.socket().bind(new InetSocketAddress(8189));

		while (true) {
			// 启动新的线程处理连接
			Socket s = serverChannel.socket().accept();
			socketList.add(s);
			new Thread(new ServerThread(s)).start();
		}
	}
}
