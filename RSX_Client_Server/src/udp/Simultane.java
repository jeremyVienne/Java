package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JFrame;

import java.io.IOException;
import java.lang.String;
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class Simultane {
	
	
	public static void main(String[] args) throws IOException{
		String ip = args[0];
		int port = Integer.parseInt(args[1]);
		String user = args[2];
		
		Client c  = new Client(ip,port, user);
		Server s = new Server(ip,port);
		
		c.start();
		s.start();
	}
	
	
}
