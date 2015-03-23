package nioTest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
	
	private final static Logger LOGGER = Logger.getLogger(Server.class.getName());
	
	public static void main(String[] args) {
		Selector selector = null;
		ServerSocketChannel serverSocketChannel = null;
		
		try {
			selector = Selector.open();
			
			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.configureBlocking(false);
			
			serverSocketChannel.socket().setReuseAddress(true);
			serverSocketChannel.socket().bind(new InetSocketAddress(8189));
			
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			
			while (selector.select() > 0) {
				Iterator<SelectionKey> it = selector.selectedKeys().iterator();
				
				while(it.hasNext()) {
					SelectionKey readyKey = it.next();
					it.remove();
					
					execute((ServerSocketChannel)readyKey.channel());
				}
			}
		} catch(ClosedChannelException ex) {
			LOGGER.log(Level.SEVERE, null, ex);
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, null, e);
		} finally {
			try {
				selector.close();
			} catch(Exception e) {}
			
			try {
				serverSocketChannel.close();
			} catch(Exception e) {}
		}
	}
	
	private static void execute(ServerSocketChannel channel) throws IOException {
		SocketChannel socketChannel = null;
		
		try {
			socketChannel = channel.accept();
			MyRequestObj requestObj = recieveData(socketChannel);
			LOGGER.log(Level.INFO, requestObj.toString());
			
			MyResponseObj responseObj = new MyResponseObj("response for " + requestObj.getName(), "response for " + requestObj.getValue());
			sendData(socketChannel, responseObj);
			LOGGER.log(Level.INFO, requestObj.toString());
		} finally {
			try {
				socketChannel.close();
			} catch(Exception e) {}
		}
	}
	
	private static MyRequestObj recieveData(SocketChannel socketChannel) throws IOException {
		MyRequestObj requestObj = null;
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
		try {
			byte[] bytes;
			int size = 0;
			while( ( size = socketChannel.read(buffer) ) >= 0 ) {
				buffer.flip();
				bytes = new byte[size];
				buffer.get(bytes);
				bout.write(bytes);
				buffer.clear();
			}
			
			bytes = bout.toByteArray();
			Object obj = SerializeUtil.toObject(bytes);
			requestObj = (MyRequestObj)obj;
		} finally {
			try {
				bout.close();
			} catch (Exception e) {}
		}
		
		return requestObj;
	}
	
	private static void sendData(SocketChannel socketChannel, MyResponseObj responseObj ) throws IOException {
		byte[] bytes = SerializeUtil.toByte(responseObj) ;
		
		ByteBuffer buffer = ByteBuffer.wrap(bytes);
		socketChannel.write(buffer);
	}
}
