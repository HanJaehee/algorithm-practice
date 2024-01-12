import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int[] rx = {-1, 1, 0, 0};
  static int[] ry = {0, 0, 1, -1};
  static int N, M, max = -1;
  static int[][] map;
  static boolean[][] visit;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    visit = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        visit[i][j] = true;
        process(j, i, 1, map[i][j]);
        visit[i][j] = false;
      }
    }

    System.out.println(max);
  }

  public static void process(int x, int y, int cnt, int sum) {
    if (cnt == 4) {
      max = Math.max(max, sum);
      return;
    }


    int dx, dy;
    for (int i = 0; i < 4; i++) {
      dx = x + rx[i];
      dy = y + ry[i];

      if (dx >= 0 && dx < M && dy >= 0 && dy < N && !visit[dy][dx]) {
        if (cnt == 2) {
          visit[dy][dx] = true;
          process(x, y, cnt + 1, sum + map[dy][dx]);
          visit[dy][dx] = false;
        }

        visit[dy][dx] = true;
        process(dx, dy, cnt + 1, sum + map[dy][dx]);
        visit[dy][dx] = false;
      }
    }
  }
}
