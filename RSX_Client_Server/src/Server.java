
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.io.IOException;
import java.net.MulticastSocket;
import java.lang.String;
public class Server {


	public static void main(String args[]) throws IOException {
		DatagramSocket server = new DatagramSocket(Integer.parseInt(args[0]));
		
		InetAddress IPAddress = InetAddress.getByName("224.0.0.1");
		
		MulticastSocket s = new MulticastSocket(7654);
		s.joinGroup(IPAddress);
		boolean b = true;
		
		while(b){
			byte[] receiveData = new byte[1024];
			/*DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			server.receive(receivePacket);
			String sentence = new String( receivePacket.getData());
			System.out.println("RECEIVED: " + sentence);
	        
	        int port = receivePacket.getPort();
	        String capitalizedSentence = sentence.toUpperCase();*/
			
			 DatagramPacket rcv = new DatagramPacket(receiveData, receiveData.length);
	         s.receive(rcv);
	         String sentence = new String( rcv.getData());
	         if(sentence.equals("close")){
	        	 s.leaveGroup(IPAddress);server.close();b=false;}
	         System.out.println("RECEIVED: " + sentence);
	        
	       
		}
		
             
		
		
		
	}
	
	
}
