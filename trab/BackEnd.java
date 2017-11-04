
import java.util.*;
import java.util.concurrent.Semaphore;


public class BackEnd extends Thread {
	
	static Semaphore semaphore = new Semaphore(1);
	static Stack list = new Stack();
		
	String name;
	Request r;
	
	public BackEnd(String n) {
		name = n;
	}
	
	public void run() {
		System.out.println(name+" Executando...");
		
		
		
		while(true){
			r = pop_request();
			
			if(r == null) {
				continue;
			}
			
			System.out.println(name+" Resolvendo requisição...");
			
			solve(r);
			System.out.println(name+" Resolução: "+r.solution);
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
	
	private int solve(Request request) {
		List in = new ArrayList();
		
		for(int i = 0; i < request.get_data().length; i++){
			in.add(i,request.get_data()[i]);
		}
		
		AbstractBinPacking bin1, bin2, bin3;
		Random rn = new Random();
		
		if(rn.nextBoolean()){
			bin1 = new BinPackingBruteforce(in,10);
		} else {
			bin1 = new FirstFitDecreasing(in,10);
		}
		
		if(rn.nextBoolean()){
			bin2 = new BinPackingBruteforce(in,10);
		} else {
			bin2 = new FirstFitDecreasing(in,10);
		}
		
		if(rn.nextBoolean()){
			bin3 = new BinPackingBruteforce(in,10);
		} else {
			bin3 = new FirstFitDecreasing(in,10);
		}
		
		Solver solver1 = new Solver(bin1);
		Solver solver2 = new Solver(bin2);
		Solver solver3 = new Solver(bin3);
		
		solver1.start();
		solver2.start();
		solver3.start();
		
		while(true) {
			
			if (solver1.solved && solver2.solved && solver3.solved){
				int r = (solver1.solution + solver2.solution + solver3.solution)/3;
				request.solve(r);
				return r;
			}
		}
	}
}
