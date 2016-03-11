package yexl.basicTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URL;


public class InetDemo {

	public static void main(String[] args) throws IOException {
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println(addr.getHostName());
		System.out.println(addr.getHostAddress());

		addr = InetAddress.getByName("www.google.no");
		System.out.println(addr.getHostName());
		System.out.println(addr.getHostAddress());
		
		InetSocketAddress addr2 = new InetSocketAddress("127.0.0.1", 980);
		System.out.println(addr2.getHostName());
		
		URL url = new URL("http://m.finn.no/realestate/browse.html");
		
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getPort());
		System.out.println(url.getAuthority());
		System.out.println(url.getContent());
		System.out.println(url.getQuery());
		
		
		/*
		InputStream is = url.openStream();
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1 != (len = is.read(flush))){
			System.out.println(new String(flush, 0 , len));
		}
		
		is.close();
		*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("finn.html"), "utf-8"));
		String msg = null;
		while((msg = br.readLine()) != null){
			System.out.println(msg);
			bw.append(msg);
			bw.newLine();
		}
		
		bw.flush();
		
		bw.close();
		br.close();
		
	}

}
