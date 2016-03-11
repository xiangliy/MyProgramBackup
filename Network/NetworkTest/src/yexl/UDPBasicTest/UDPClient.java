package yexl.UDPBasicTest;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPClient {

	public static void main(String[] args) throws IOException {
		DatagramSocket client = new DatagramSocket(8654);

		double num = 1.2345;
		byte[] data = convert(num);
		
		DatagramPacket packet = new DatagramPacket(data, data.length, new InetSocketAddress("localhost", 8765));
		
		client.send(packet);
		client.close();
	}
	
	public static byte[] convert(double num){
		byte[] data = null;
		
		ByteArrayOutputStream bs = new ByteArrayOutputStream();
		DataOutputStream ds = new DataOutputStream(bs);
		
		try {
			ds.writeDouble(num);
			ds.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		data = bs.toByteArray();
		try {
			ds.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return data;
		
	}

}
