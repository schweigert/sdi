import java.util.Scanner;

class Request {
  public static Scanner scanner = new Scanner(System.in);

  public int[] data;

  public Request () {}

  public void get() {
    data = numbers();
  }

  // Private:

  private int[] numbers() {
    String[] args = line();
    int[] ret = new int[args.length];

    for(int i = 0; i < args.length; i++){
      ret[i] = Integer.parseInt(args[i]);
    }

    return ret;
  }

  private String[] line() {
    try {
      String[] r = scanner.next().replaceAll(" ", "").split(",");
      return r;
    } catch(Exception e) {
      return new String[0];
    }
  }
}
