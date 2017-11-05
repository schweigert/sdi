class BackEnd extends Service {

  Request request;

  public BackEnd(){

  }

  public void service() {
    if(request == null){
      request = new Request();
      request.get();
    }

    request = null;
  }
}
