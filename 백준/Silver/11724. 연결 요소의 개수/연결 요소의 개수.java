import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static boolean[][] map = new boolean[1001][1001];
  static boolean[] visited = new boolean[1001];
  static int N, M;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    int start, end;
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      start = Integer.parseInt(st.nextToken());
      end = Integer.parseInt(st.nextToken());

      map[start][end] = map[end][start] = true;
    }

    int result = 0;

    for (int i = 1; i <= N; i++) {
      if (!visited[i]) {
        bfs(i);
        result++;
      }
    }

    System.out.println(result);

  }

  public static void bfs(int n) {
    Queue<Integer> q = new LinkedList<>();
    q.offer(n);
    visited[n] = true;

    while (!q.isEmpty()) {
      int current = q.poll();
      for (int i = 1; i <= 1000; i++) {
        if (!visited[i] && map[current][i]) {
          visited[i] = true;
          q.offer(i);
        }
      }
    }
  }

  public static void dfs(int n) {
    if (visited[n]) return;
    visited[n] = true;
    for (int i = 1; i <= 1000; i++) {
      if (map[n][i]) {
        dfs(i);
      }
    }
  }
}
