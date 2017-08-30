
import java.io.*;
import java.net.*;

public class ClientChat  implements Runnable {

    static String username = null;

    public static void main(String args[]) throws Exception {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("192.168.6.21");
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];


        System.out.println("Username: ");
        username = inFromUser.readLine();

        new Thread(new ClientChat()).start();

        while(true){
          System.out.print(username + " >> ");
          String sentence = username + ":" + inFromUser.readLine();
          sendData = sentence.getBytes();

          DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 3030);
          clientSocket.send(sendPacket);
        }
    }


    public void run()
    {
      MulticastSocket socket = null;
      DatagramPacket inPacket = null;
      byte[] inBuf = new byte[256];
      try {
        //Prepare to join multicast group
        socket = new MulticastSocket(4021);
        InetAddress address = InetAddress.getByName("224.2.2.5");
        socket.joinGroup(address);

        while (true) {
          inPacket = new DatagramPacket(inBuf, inBuf.length);
          socket.receive(inPacket);
          String msg = new String(inBuf, 0, inPacket.getLength());
          String[] parts = msg.split(":");
          if(parts[0].equals(username))
            continue;
          System.out.println(parts[0]+" >> " + parts[1]);
        }
      } catch (IOException ioe) {
        System.out.println(ioe);
      }
    }
}
