import java.util.*;
import java.util.concurrent.Semaphore;

public class BackEnd extends Thread {
	
	static Semaphore semaphore = new Semaphore(1);
	static Stack list = new Stack();
		
	String name;
	
	public BackEnd(String n) {
		name = n;
	}
	
	public void run() {
		System.out.println(name+" Executando...");
		while(true){
			Request r = pop_request();
			
			if(r == null) {
				continue;
			}
			
			for(int i = 0; i < r.get_data().length; i++){
				System.out.println(name+" "+r.get_data()[i]);
			}
		}
	}
	
	public static Request pop_request() {
		try {
			semaphore.acquire();
			
			if(list.size() == 0){
				semaphore.release();
				return null;
			}
			
			Request r = (Request)list.pop();
			
			semaphore.release();
			
			return r;
		} catch(Exception e) {
			semaphore.release();
			e.printStackTrace();
			return null;
		}
	}
	
	public static void add_request(Request request) {
		try {
			semaphore.acquire();
			
			list.push(request);
			
			semaphore.release();
		} catch(Exception e) {
			semaphore.release();
			e.printStackTrace();
		}
	}
	
	public static int request_count() {
		try {
			semaphore.acquire();
			int sz = list.size();
			semaphore.release();
			
			return sz;
		} catch(Exception e) {
			semaphore.release();
			e.printStackTrace();
			
			return 0;
		}
	}
}
