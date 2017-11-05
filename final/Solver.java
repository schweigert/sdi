class Solver extends Service {

  Request request;
  int number;

  public Solver(Request r) {
    request = r;
  }

  public void service() {

    number = 3;

    stop();
  }

  public int solution() {
    wait_death();
    return number;
  }
}
