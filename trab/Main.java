
public class Main {

	public static void main(String[] args) {
		
		FrontEnd[] front = new FrontEnd[4];
		BackEnd[] back = new BackEnd[4];
		
		front[0] = new FrontEnd("[FRONTEND 1]");
		front[1] = new FrontEnd("[FRONTEND 2]");
		front[2] = new FrontEnd("[FRONTEND 3]");
		front[3] = new FrontEnd("[FRONTEND 4]");
		
		front[0].start();
		front[1].start();
		front[2].start();
		front[3].start();
		
		back[0] = new BackEnd("[BACKEND 1]");
		back[1] = new BackEnd("[BACKEND 2]");
		back[2] = new BackEnd("[BACKEND 3]");
		back[3] = new BackEnd("[BACKEND 4]");
		
		back[0].start();
		back[1].start();
		back[2].start();
		back[3].start();
		
		Health health = new Health(front,back);
		health.start();
	}

}
