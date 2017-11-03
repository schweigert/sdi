
public class Main {

	public static void main(String[] args) {
		
		FrontEnd front1 = new FrontEnd("[FRONTEND 1]");
		FrontEnd front2 = new FrontEnd("[FRONTEND 2]");
		FrontEnd front3 = new FrontEnd("[FRONTEND 3]");
		FrontEnd front4 = new FrontEnd("[FRONTEND 4]");
		
		front1.start();
		front2.start();
		front3.start();
		front4.start();
		
		BackEnd back1 = new BackEnd("[BACKEND 1]");
		BackEnd back2 = new BackEnd("[BACKEND 2]");
		BackEnd back3 = new BackEnd("[BACKEND 3]");
		BackEnd back4 = new BackEnd("[BACKEND 4]");
		
		back1.start();
		back2.start();
		back3.start();
		back4.start();
	}

}
