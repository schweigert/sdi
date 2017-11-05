import java.util.concurrent.Semaphore;

class Service extends Thread {

  public void print(String s){
    if(Tests.is_test_app) return;
    System.out.println(s);
  }

  public void run(){
    while(true){
      service();
    }
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
