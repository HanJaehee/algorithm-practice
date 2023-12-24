import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static class Point {
    int x, y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    List<Point> list = new ArrayList<>();
    int x, y;
    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      x = Integer.parseInt(st.nextToken());
      y = Integer.parseInt(st.nextToken());
      list.add(new Point(x, y));
    }

    list.sort((a1, a2) -> {
      if (a1.y == a2.y) {
        return a1.x - a2.x;
      } else {
        return a1.y - a2.y;
      }
    });

    StringBuilder sb = new StringBuilder();

    list.forEach(a -> sb.append(a.x).append(" ").append(a.y).append("\n"));

    System.out.println(sb);
  }
}
