
public class Solver extends Thread {

	int solution = 0;
	boolean solved = false;
	AbstractBinPacking packing;
	
	public Solver(AbstractBinPacking algo){
		packing = algo;
	}
	
	public void run () {
		solution = packing.getResult();
		solved = true;
	}
}
