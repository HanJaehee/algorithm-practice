import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    Deque<Integer> q = new LinkedList<>();

    commands:
    for (int i = 0; i < T; i++) {
      String[] cmds = br.readLine().split("");

      int n = Integer.parseInt(br.readLine());

      StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

      for (int j = 0; j < n; j++) {
        q.addLast(Integer.parseInt(st.nextToken()));
      }

      boolean right = true;

      for (String cmd : cmds) {
        if (cmd.equals("R")) {
          right = !right;
        } else {
          if (q.isEmpty()) {
            System.out.println("error");
            continue commands;
          }
          if (right) {
            q.removeFirst();
          } else {
            q.removeLast();
          }
        }
      }

      dequeToString(q, right);
    }
  }

  static void dequeToString(Deque<Integer> deque, boolean right) {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    if(!deque.isEmpty()) {
      if (right) {
        sb.append(deque.removeFirst());
        while (!deque.isEmpty()) {
          sb.append(",").append(deque.removeFirst());
        }
      } else {
        sb.append(deque.removeLast());
        while (!deque.isEmpty()) {
          sb.append(",").append(deque.removeLast());
        }
      }
    }
    
    sb.append("]");
    System.out.println(sb);
  }
}
