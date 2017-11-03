
public class FrontEnd extends Thread {
	
	String name;
	
	public FrontEnd(String n) {
		name = n;
	}
	
	public void run() {
		System.out.println(name+" Executando...");
		while(true){
			Request request = new Request();
			request.read();
			
			if(request.get_data() == null){
				continue;
			}
			
			
			BackEnd.add_request(request);

		}
	}
}
