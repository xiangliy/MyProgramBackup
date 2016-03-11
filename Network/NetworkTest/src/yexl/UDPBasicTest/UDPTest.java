package yexl.UDPBasicTest;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPTest {

	public static void main(String[] args) throws IOException {
		DatagramSocket server = new DatagramSocket(8765);

		byte [] container = new byte[1024];
		
		DatagramPacket packet = new DatagramPacket(container, container.length);
	
		server.receive(packet);
		byte [] data = packet.getData();
		double num = convert(data);
		int len = packet.getLength();
		
		System.out.println(num);
		server.close();
	}
	
	public static double convert(byte[] data){
		
		ByteArrayInputStream bs = new ByteArrayInputStream(data);
		DataInputStream ds = new DataInputStream(bs);
		
		double num = 0;
		try {
			num = ds.readDouble();
			ds.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return num;
		
	}


}
