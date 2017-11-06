import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class Solver extends Service {

  Request request;
  int number;

  public Solver(Request r) {
    request = r;
  }

  public void service() {
    List list = new Stack();

    for(int i = 0; i < request.data.length; i++){
      list.add(request.data[i]);
    }

    AbstractBinPacking packing = new FirstFitDecreasing(list, 10);
    number = packing.getResult();
    stop();
  }

  public int solution() {
    wait_death();
    return number;
  }
}
