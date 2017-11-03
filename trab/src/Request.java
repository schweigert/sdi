import java.util.*;
import java.util.concurrent.Semaphore;

public class Request {
	static Semaphore semaphore = new Semaphore(1);
	static Scanner s = new Scanner(System.in);
	
	private int[] data;
	
	public Request() {}
	
	public int[] get_data() {
		return data;
	}
	
	public void read() {
		try {
			semaphore.acquire();
			
			int[] r;
			String line;
			String[] lines;
			
			line = s.next();
			
			lines = line.split(",");
			r = new int[lines.length];
			
			for(int i = 0; i < lines.length; i++){
				r[i] = Integer.parseInt(lines[i]);
			}
			
			data = r;
			semaphore.release();
		} catch(Exception e) {
			semaphore.release();
			data = null;
		}
	}
}
