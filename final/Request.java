import java.util.Scanner;

class Request {
  public static Scanner scanner = new Scanner(System.in);

  int[] data;
  int solution;


  public Request () {}

  public void get() {
    data = numbers();
  }

  public void solve(int n){
    solution = n;
  }

  // Private:

  private int[] numbers() {
    String[] args = line();
    if(args.length == 0) return new int[0];

    int[] ret = new int[args.length];

    for(int i = 0; i < args.length; i++){
      ret[i] = Integer.parseInt(args[i]);
    }

    return ret;
  }

  private String[] line() {
    try {
      String l = scanner.next();
      String[] r = l.split(",");
      System.out.println("[FRONTEND] NEW REQUEST: "+l);
      return r;
    } catch(Exception e) {
      return new String[0];
    }
  }
}
