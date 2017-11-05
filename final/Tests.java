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
}
