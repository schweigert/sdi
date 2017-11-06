class FrontEnd extends RequestService {

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

}
