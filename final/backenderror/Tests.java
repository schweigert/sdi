class Test {

  public static Boolean is_test_app = false;

  public static void init() {
    is_test_app = true;
  }

  public static void test_assert(boolean a){
    if(a){
      System.out.print(".");
    } else {
      System.out.print("E");
    }
  }

  public static void finish() {
    System.out.print("\n");
  }
}

public class Tests extends Test {
  public static void main(String[] args) {

    init();

    test_suit();
    test_back_quit();
    test_front_quit();
    test_solver_resolution();
    test_health();

    finish();
  }

  public static void test_suit() {
    test_assert(true);
  }

  public static void test_back_quit() {
    BackEnd back = new BackEnd();

    back.start();

    test_assert(back.isAlive());

    back.stop();
    back.wait_death();

    test_assert(!back.isAlive());
  }

  public static void test_front_quit() {
    FrontEnd front = new FrontEnd();

    front.start();

    test_assert(front.isAlive());

    front.stop();
    front.wait_death();

    test_assert(!front.isAlive());
  }

  public static void test_solver_resolution() {
    Request request = new Request();
    request.data = new int[] {9,3,2,3,10};

    Solver solver = new Solver(request);
    solver.start();

    int r = solver.solution();

    test_assert(r == 3);
  }

  public static void test_health() {
    BackEnd back = new BackEnd();
    FrontEnd front = new FrontEnd();

    back.start();
    front.start();

    Health health = new Health(back, front);
    health.start();

    test_assert(back.isAlive());
    test_assert(front.isAlive());
    test_assert(health.isAlive());

    back.stop();
    front.stop();

    back.wait_death();
    front.wait_death();

    test_assert(health.back_end != back);
  }
}
