import java.io.*;

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
    solution_time_in_file(request.total_time);
    Killer.solve();
    print("[FRONTEND] Solutions: "+  Killer.solutions);
  }

  private void solution_time_in_file(long recovery_time) {
    try {
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("solution_final_time.txt", true)));
      out.println(recovery_time);
      out.close();
    } catch (Exception e) {
      stop();
    }
  }

}
