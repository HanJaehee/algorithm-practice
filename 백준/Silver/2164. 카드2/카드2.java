import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

  static Deque<Integer> q = new LinkedList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    for (int i = N; i >= 1; i--) {
      q.add(i);
    }

    while (q.size() != 1) {
      q.removeLast();
      q.addFirst(q.removeLast());
    }

    System.out.println(q.poll());

  }
}
