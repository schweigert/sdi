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
