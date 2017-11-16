class FrontEndPrinter extends Service {

  public void service() {
    String str = "[FRONTEND] Request:\n";
    Request request = FrontEnd.pop_request();

    str = str+"------\n";
    str = str+"\t"+request.request_line+"\n";
    str = str+"\tSolution: "+request.solution+"\n";
    str = str+"\tTime Running: "+request.total_time+" ms\n";
    str = str+"------\n";

    print(str);
    Killer.solve();
    print("[FRONTEND] Solutions: "+  Killer.solutions);
  }

}
