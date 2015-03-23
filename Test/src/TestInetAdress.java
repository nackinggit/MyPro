import java.net.InetAddress;


public class TestInetAdress {
	public static void main(String[] args) throws Exception {
		InetAddress ip = InetAddress.getByName("www.baidu.com");
		
		System.out.println("baidu is reachable? ------> " + ip.isReachable(10000));
		System.out.println(ip.getHostAddress());
		InetAddress local = InetAddress.getByAddress(new byte[]{127,0,0,1});
		System.out.println("local is reachable? ------> " + local.isReachable(5000));
		System.out.println(local.getCanonicalHostName());
	}
}
