
/** Server.java **/

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class Server implements Chat {
   public Server() {}
   // main()
   // hello()

   public static void main(String[] args) {
      try {
         // Instancia o objeto servidor e a sua stub
         Server server = new Server();
         Chat stub = (Chat) UnicastRemoteObject.exportObject(server, 0);
         // Registra a stub no RMI Registry para que ela seja obtida pelos clientes
         Registry registry = LocateRegistry.getRegistry();
         registry.bind("Chat", stub);
         System.out.println("Servidor pronto");
      } catch (Exception ex) {
         ex.printStackTrace();
      }
   }

public String hello() throws RemoteException {
   System.out.println("Executando hello()");
   return "Hello!!!";
}
}
