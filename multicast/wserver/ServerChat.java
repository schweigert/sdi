import java.io.*;
import java.net.*;

public class ServerChat {

    public static void main(String args[]) throws Exception {

      // Socket e buffers
      DatagramSocket serverSocket = new DatagramSocket(3030);
      byte[] receiveData = new byte[1024];
      byte[] sendData = new byte[1024];

      while(true) {
        // Recebe as bagaça e printa na tela
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        serverSocket.receive(receivePacket);
        String sentence = new String(receivePacket.getData());
        System.out.println(sentence);
      }

    }
}
