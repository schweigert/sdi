/** HelloWorld.java **/
import java.rmi.*;

public interface Chat extends Remote {
   public String hello() throws RemoteException;
   public void put(String user, String msg) throws RemoteException;
   public String[] get() throws RemoteException;
}
