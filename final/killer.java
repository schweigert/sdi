class Killer extends Service {
  public static int solutions = 0;

  Health health;

  public Killer(Health h) {
    health = h;
  }

  public static synchronized void solve(){
    solutions++;
  }

  public static synchronized int get_solutions(){
    return solutions;
  }

  public void service() {
    if(Config.requests < 0){
      return;
    }

    if(get_solutions() >= Config.requests){
      print("[KILLER] ALL REQUESTS ARE FINISHED");

      health.stop();

      health.back_end.stop();
      health.back_end_restore.stop();

      health.front_end.stop();
      health.front_end_restore.stop();

      System.exit(0);
    }
  }

}
