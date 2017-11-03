
public class Main {

	public static void main(String[] args) {
		
		FrontEnd front1 = new FrontEnd("[FRONTEND 1]");
		front1.start();
		FrontEnd front2 = new FrontEnd("[FRONTEND 2]");
		front2.start();
		FrontEnd front3 = new FrontEnd("[FRONTEND 3]");
		front3.start();
		FrontEnd front4 = new FrontEnd("[FRONTEND 4]");
		front4.start();
		
		BackEnd back1 = new BackEnd("[BACKEND 1]");
		back1.start();
		BackEnd back2 = new BackEnd("[BACKEND 2]");
		back2.start();
		BackEnd back3 = new BackEnd("[BACKEND 3]");
		back3.start();
		BackEnd back4 = new BackEnd("[BACKEND 4]");
		back4.start();
	}

}
