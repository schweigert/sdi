class RequestService extends Service {
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
