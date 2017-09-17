package chat;

import javax.jws.WebService;

@WebService(endpointInterface = "chat.ChatServer")
public class ChatServerImpl implements ChatServer {

	public String sayHello(String name) {
		return "Hello " + name + " !, Hope you are doing well !!";
	}

	static String[] msgs = new String[10000];
	static int msg_num = 0;

	public void putMsg(String txt, String usr) {
		 String r = usr + ": " + txt;
		 System.out.println(r);
		 msgs[msg_num] = r;
		 msg_num++;
	}

	public String[] getMsg() {
		return msgs;
	}

}
