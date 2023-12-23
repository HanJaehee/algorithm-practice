import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

  static Deque<Integer> q = new LinkedList<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      queue(br.readLine());
    }
  }

  public static void queue(String str) throws Exception {
    String[] cmds = str.split(" ");

    String cmd = cmds[0];

    if (cmd.equals("push")) {
      int num = Integer.parseInt(cmds[1]);
      q.addLast(num);
    } else if (cmd.equals("pop")) {
      if (q.isEmpty()) {
        System.out.println(-1);
      } else {
        System.out.println(q.removeFirst());
      }
    } else if (cmd.equals("size")) {
      System.out.println(q.size());
    } else if (cmd.equals("empty")) {
      if (q.isEmpty()) {
        System.out.println(1);
      } else {
        System.out.println(0);
      }
    } else if (cmd.equals("front")) {
      if(q.isEmpty()){
        System.out.println(-1);
      }else {
        System.out.println(q.getFirst());
      }
    } else if (cmd.equals("back")) {
      if(q.isEmpty()){
        System.out.println(-1);
      }else {
        System.out.println(q.getLast());
      }
    } else {
      throw new Exception("invalid");
    }
  }
}
