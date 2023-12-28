import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());

    Queue<Integer> q = new PriorityQueue<>();

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
