package chat;

import java.util.Scanner;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class ChatClient {

	public static void clearScreen() {
	 System.out.print("\033[H\033[2J");
	 System.out.flush();
	}

	public static void main(String[] args) {

		try {
			Scanner sc = new Scanner(System.in);
			URL url = new URL("http://localhost:9876/hw?wsdl");
			QName qname = new QName("http://chat/",
					"ChatServerImplService");

			Service service = Service.create(url, qname);

			ChatServer server = service.getPort(ChatServer.class);
			// String name = "prasad";
			// System.out.println(server.sayHello(name));
			System.out.print("Username: ");
			String username = sc.nextLine();

			while(true){
				System.out.print(username+": ");
				String txt = sc.nextLine();

				server.putMsg(txt, username);
				clearScreen();
				String[] msgs = server.getMsg();

				for(int i = 0; i < 10000; i++){
					if(msgs[i] == null || msgs[i].equals(""))
						break;
					System.out.println(msgs[i]);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
