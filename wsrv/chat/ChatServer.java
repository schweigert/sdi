package chat;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface ChatServer {

	@WebMethod
	String sayHello(String name);

	@WebMethod
	void   putMsg(String txt, String usr);

	@WebMethod
	String[] getMsg();
}
