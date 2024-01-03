import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    Queue<Integer> q = new PriorityQueue<>((a1, a2) -> a2 - a1);
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());
      if (num == 0) {
        if (q.isEmpty()) {
          System.out.println(0);
        } else {
          System.out.println(q.poll());
        }
      } else {
        q.add(num);
      }
    }
  }
}
