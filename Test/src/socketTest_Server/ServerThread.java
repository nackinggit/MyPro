package socketTest_Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread implements Runnable {

	Socket s = null;
	BufferedReader reader = null;

	public ServerThread(Socket s) throws UnsupportedEncodingException,
			IOException {
		this.s = s;

		reader = new BufferedReader(new InputStreamReader(s.getInputStream(),
				"utf-8"));
	}

	@Override
	public void run() {
		while (true) {
			readFromClient();

			try {
				String content = null;
				Scanner in = new Scanner(System.in);
				if (in.hasNextLine())
					content = in.nextLine();
				in.close();

				for (Socket s : SocketTest.socketList) {
					OutputStream os = s.getOutputStream();
					os.write((content + "\n").getBytes("utf-8"));
				}
			} catch (IOException e) {
			}
		}
	}

	private void readFromClient() {

		try {
			String clientContent = reader.readLine();
			System.out.println("Client:" + clientContent);
		} catch (IOException e) {
			SocketTest.socketList.remove(s);
		}
	}

}
