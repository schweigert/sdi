import java.io.*;
import java.net.*;

public class ServerChat {

    public static void main(String args[]) throws Exception {

      // Socket e buffers
      DatagramSocket serverSocket = new DatagramSocket(3030);
      byte[] receiveData = null;
      byte[] sendData = new byte[1024];

      DatagramPacket outPacket = null;

      DatagramSocket serverMulticast = new DatagramSocket();


      while(true) {
        // Recebe as bagaça e printa na tela
        receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        serverSocket.receive(receivePacket);
        String msg = new String(receivePacket.getData());
        System.out.println(msg);

        // Envio em Multicast
        byte[] out = msg.getBytes();

        InetAddress address = InetAddress.getByName("224.2.2.5");
        outPacket = new DatagramPacket(out, out.length, address, 4021);

        serverMulticast.send(outPacket);

      }

    }


}
