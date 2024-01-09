import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    Queue<Integer> q = new PriorityQueue<>((a1, a2) -> {
      int absA1 = Math.abs(a1);
      int absA2 = Math.abs(a2);

      if (absA1 == absA2) {
        return a1 - a2;
      } else {
        return absA1 - absA2;
      }
    });

    int num;
    for (int i = 0; i < N; i++) {
      num = Integer.parseInt(br.readLine());

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
