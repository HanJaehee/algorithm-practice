import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
  static List<Integer> q = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());

      q.add(num);
    }


    q.sort((c1, c2) -> c1 - c2);
//    Collections.sort(q);
    StringBuilder sb = new StringBuilder();

    q.forEach(s -> sb.append(s).append("\n"));

    System.out.println(sb);
  }
}
