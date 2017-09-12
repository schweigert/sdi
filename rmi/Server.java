
/** Server.java **/

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Server implements Chat {
   public Server() {}
   // main()
   // hello()

   static String[] msgs;
   static int msg_num;

   public static void main(String[] args) {

     msgs = new String[10000];
     msg_num = 0;

      try {
         // Instancia o objeto servidor e a sua stub
         Server server = new Server();
         Chat stub = (Chat) UnicastRemoteObject.exportObject(server, 0);
         // Registra a stub no RMI Registry para que ela seja obtida pelos clientes
         Registry registry = LocateRegistry.getRegistry();
         registry.bind("Chat1.0", stub);
         System.out.println("Servidor pronto");
      } catch (Exception ex) {
         ex.printStackTrace();
      }
   }

public void put(String user, String msg) throws RemoteException {

  msgs[msg_num] = user+": "+msg;
  System.out.println(msgs[msg_num]);
  msg_num++;

}

public String[] get() throws RemoteException {
  return msgs;
}

public String hello() throws RemoteException {
   System.out.println("Executando hello()");
   return "Hello!!!";
}
}
