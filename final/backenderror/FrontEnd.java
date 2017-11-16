import java.io.*;
class FrontEnd extends Service {

  FrontEnd restore;

  Request request;

  public FrontEnd() {
    this.restore = null;
    this.request = null;
  }

  public FrontEnd(FrontEnd copy) {
    restore = copy;
  }

  public void service() {
    deep_copy();
    recovery_time();

    // #TODO #ERROR
    if (Config.frontend_error) {
      long i = 1/(get_time()%1000);
    }

    if(request == null)
    request = new Request();

    request.get();

    if(request.data.length > 0)
      BackEnd.push_request(request);

    request = null;
  }

  private void deep_copy() {
    if(restore != null) {
      this.request = restore.request;
    }
  }

  private void recovery_time() {
    if(restore != null){
      time = get_time();
      error_time = restore.time;
      long recovery_time = time-error_time;
      print("[RECOVERY FRONTEND TIME] "+(recovery_time)+" ms");
      recovery_time_in_file(recovery_time);
      this.restore = null;
    }
  }

  private void recovery_time_in_file(long recovery_time) {
    try {
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("frontend.txt", true)));
      out.println(recovery_time);
      out.close();
    } catch (Exception e) {
      stop();
    }
  }

    static Request[] requests = new Request[300];

    public static void push_request(Request r) {
      while(true){
        for(int i = 0; i < requests.length; i++) {
          if(requests[i] == null) {
            requests[i] = r;
            return;
          }
        }
      }
    }

    public static Request pop_request() {
      while(true){
        for(int i = 0; i < requests.length; i++) {
          if(requests[i] != null) {
            Request r = requests[i];
            requests[i] = null;
            return r;
          }
        }
      }
    }
}
