package chat;

import javax.xml.ws.Endpoint;

public class ChatServerPublisher {

	public static void main(String[] args) {

		System.out.println("Beginning to publish ChatService now");
		Endpoint.publish("http://127.0.0.1:9876/hw", new ChatServerImpl());
		System.out.println("Done publishing");
	}

}
