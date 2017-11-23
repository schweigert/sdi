import java.util.concurrent.Semaphore;

class Service extends Thread {

  long time, error_time;

  public static void print(String s){
    if(Tests.is_test_app) return;
    System.out.println(s);
  }

  public void run(){
    while(true){
      try {
        service();
      } catch (Exception e) {
        error();
      }
    }
  }

  protected void error() {
    time = get_time();
    stop();
  }

  protected long get_time() {
    return System.currentTimeMillis();
  }

  public void service() {}

  public boolean is_stoped(){
    return getState() == Thread.State.TERMINATED;
  }

  public void wait_death(){
    while(true){
      if(!isAlive()) return;
    }
  }

}
