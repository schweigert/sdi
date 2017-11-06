class BackEnd extends Service {

  Request request;
  BackEnd restore;

  public BackEnd(){
    restore = null;
  }

  public BackEnd(BackEnd copy){
    restore = copy;
  }

  public void service() {
    deep_copy();

    if(request == null)
      request = pop_request();

    Solver solver_1 = new Solver(request);
    Solver solver_2 = new Solver(request);

    solver_1.start();
    solver_2.start();

    int r1 = solver_1.solution();
    int r2 = solver_2.solution();

    print("[BACKEND] Solution 1: "+r1);
    print("[BACKEND] Solution 2: "+r2);

    if(r1 != r2){
      push_request(request);
      stop();
    }

    request.solve(r1);

    FrontEnd.push_request(request);

    request = null;
  }

  private void deep_copy() {
    if(restore != null){
      this.request = restore.request;

      this.restore = null;
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
