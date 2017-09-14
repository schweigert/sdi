/** Client.java **/
import java.rmi.registry.*;
import java.util.Scanner;

public class Client {

   public static void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
   } 

   public static void main(String[] args) {
      String host = (args.length < 1) ? null : args[0];
      try {
         // Obtém uma referência para o registro do RMI
         Registry registry = LocateRegistry.getRegistry(host);
         Scanner sc = new Scanner(System.in);
         // Obtém a stub do servidor
         Chat stub= (Chat) registry.lookup("Chat1.0");

         System.out.println("Username:");
         String username = sc.nextLine();
	 clearScreen();
         while(true){
	   System.out.print(username + ": ");
           String msg = sc.nextLine();
           stub.put(username, msg);
           String[] msgs = stub.get();
	   clearScreen();
           for(int i =0; i < 10000; i++){

             if(msgs[i] == null){
               break;
             }

             System.out.println(msgs[i]);

           }

         }



         // Chama o método do servidor e imprime a mensagem
         // String msg = stub.hello();
         // System.out.println("Mensagem do Servidor: " + msg);
      } catch (Exception ex) {
         ex.printStackTrace();
      }
   }
}
