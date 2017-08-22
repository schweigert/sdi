
import java.io.*;
import java.net.*;

public class ClientChat {

    static String username = null;

    public static void main(String args[]) throws Exception {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];


        System.out.println("Username: ");
        username = inFromUser.readLine();

        while(true){
          System.out.println("Msg: ");
          String sentence = username + ":" + inFromUser.readLine();
          sendData = sentence.getBytes();

          DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 3030);
          clientSocket.send(sendPacket);
        }
    }
}
