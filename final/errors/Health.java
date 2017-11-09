class Health extends Service {
  BackEnd back_end;
  BackEnd back_end_restore;

  FrontEnd front_end;
  FrontEnd front_end_restore;

  public Health(BackEnd back, FrontEnd front){
    back_end = back;
    back_end_restore = new BackEnd(back);

    front_end = front;
    front_end_restore = new FrontEnd(front);
  }

  public void service() {
    restore_back();
    restore_front();
  }

  private void restore_back() {
    if(!back_end.isAlive()){
      print("[HEALTH] RESTORE BACKEND");
      back_end_restore.start();
      back_end = back_end_restore;
      back_end_restore = new BackEnd(back_end);
    }
  }

  private void restore_front() {
    if(!front_end.isAlive()){
      print("[HEALTH] RESTORE FRONTEND");
      front_end_restore.start();
      front_end = front_end_restore;
      front_end_restore = new FrontEnd(front_end);
    }
  }
}
