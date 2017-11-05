public class App {
  public static void main(String[] args) {
    BackEnd back = new BackEnd();
    FrontEnd front = new FrontEnd();

    Health health = new Health(back, front);

    back.start();
    front.start();
    health.start();
  }
}
