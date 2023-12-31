import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int[][] map, distance;
  static boolean[][] visit;
  static int N, M;
  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, 1, -1};

  static class Point {
    int x, y, distance;

    Point(int x, int y, int distance) {
      this.x = x;
      this.y = y;
      this.distance = distance;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    distance = new int[N][M];
    visit = new boolean[N][M];

    int startX = 0, startY = 0;
    for (int i = 0; i < N; i++) {
      String[] str = br.readLine().split(" ");
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(str[j]);
        if (map[i][j] == 2) {
          startX = j;
          startY = i;
        }

        if(map[i][j] == 0) {
          distance[i][j] = 0;
        }else{
          distance[i][j] = -1;
        }
      }
    }

    bfs(startX, startY);

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        sb.append(distance[i][j]).append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }

  static void bfs(int startX, int startY) {
    Queue<Point> q = new LinkedList<>();

    distance[startY][startX] = 0;
    visit[startY][startX] = true;
    q.add(new Point(startX, startY, 1));

    while (!q.isEmpty()) {
      Point cur = q.poll();

      for (int i = 0; i < 4; i++) {
        int rx = cur.x + dx[i];
        int ry = cur.y + dy[i];

        if (rx >= 0 && rx < M && ry >= 0 && ry < N && !visit[ry][rx] && map[ry][rx] == 1) {
          distance[ry][rx] = cur.distance;
          visit[ry][rx] = true;
          q.add(new Point(rx, ry, cur.distance + 1));
        }
      }
    }
  }
}