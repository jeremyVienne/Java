package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import com.sun.nio.file.SensitivityWatchEventModifier;

import java.io.IOException;
import java.net.MulticastSocket;
import java.lang.String;

public class Server extends Thread {

	private int port;
	private String ip;

	public Server(String ip, int port) {
		this.port = port;
		this.ip = ip;

	}

	public void run() {

		DatagramSocket server = null;
		InetAddress IPAddress = null;
		MulticastSocket s = null;

		try {
			server = new DatagramSocket(this.port);
			IPAddress = InetAddress.getByName("224.0.0.1");
			s = new MulticastSocket(7654);
			s.joinGroup(IPAddress);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		boolean b = true;

		while (b) {
			byte[] receiveData = new byte[1024];
			String user = "";

			DatagramPacket rcv = new DatagramPacket(receiveData, receiveData.length);
			try {
				s.receive(rcv);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String sentence = new String(rcv.getData());
			sentence = sentence.trim();

			int pos = sentence.indexOf(":");
			if (pos >= 0) {
				user = sentence.substring(0, pos);
			} else {
				pos = 0;
			}
			if (pos != 0) {
				sentence = sentence.substring(pos);
				int code = user.charAt(user.length() - 1);
				String tmp = "";
				for (int i = 1; i < sentence.length(); i++) {
					int ch = sentence.charAt(i) - code;
					char c = (char) ch;
					tmp += c;
				}
				tmp.trim();
				System.out.println(user +":"+ tmp+"\n");
				
				if (tmp.equals("close")) {
					try {
						s.leaveGroup(IPAddress);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					server.close();
					b = false;
				}
			}
			

		}
	}

}
