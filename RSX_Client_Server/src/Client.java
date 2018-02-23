
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.io.IOException;
import java.lang.String;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Client {
	public static void main(String args[]) throws IOException{
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getByName(args[0]);
		boolean b =true;
		while(b){
			byte[] sendData = new byte[1024];
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String msg = br.readLine();
			sendData = msg.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, Integer.parseInt(args[1]));
			clientSocket.send(sendPacket);
			if(msg.equals("close")){
				clientSocket.close();
				b=false;
				
				
			}
			
		}
		
	}
}
