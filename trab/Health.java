
public class Health extends Thread {

	FrontEnd[] fronts;
	BackEnd[] backs;
	
	public Health(FrontEnd[] f, BackEnd[] b) {
		fronts = f;
		backs = b;
	}
	
	public void run() {
		while(true){
			for(int i = 0; i < fronts.length; i++){
				Thread.State state = fronts[i].getState();
				if(state == Thread.State.TERMINATED){
					System.out.println("[HEALTH] "+fronts[i].name+" isn't working...");
				}
			}
			for(int i = 0; i < backs.length; i++){
				Thread.State state = backs[i].getState();
				if(state == Thread.State.TERMINATED){
					System.out.println("[HEALTH] "+backs[i].name+" isn't working...");
					backs[i] = new BackEnd(backs[i].name+"{Health}");
					backs[i].start();
				}
			}			
		}
	}
	
}
