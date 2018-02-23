package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.io.IOException;
import java.lang.String;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Client extends Thread{
	
	private int port;
	private String ip;
	private String user;
	public Client(String ip, int port, String user){
		this.ip=ip;
		this.port=port;
		this.user=user;
		
		
	}
	
	public void run(){
		
		DatagramSocket clientSocket=null;
		InetAddress IPAddress=null;

		MulticastSocket s=null;
		try {
			clientSocket = new DatagramSocket();
			IPAddress = InetAddress.getByName(this.ip);
			s = new MulticastSocket(7654);
			s.joinGroup(IPAddress);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		boolean b =true;
		while(b){
			
			byte[] sendData = new byte[1024];
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("");
			String msg="";
			int code = this.user.charAt(this.user.length()-1);
			
			try {
				msg += br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String tmp="";
			
			for(int i=0; i<msg.length();i++){
				int ch = msg.charAt(i)+code;
				char c =(char) ch;
				tmp+=""+c;
			}
			
			tmp = this.user +":"+tmp;
			
			sendData = tmp.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 7654);
			try {
				clientSocket.send(sendPacket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(msg.equals("close")){
				clientSocket.close();
				try {
					s.leaveGroup(IPAddress);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				b=false;
				
				
			}
			
		}
	}
}
