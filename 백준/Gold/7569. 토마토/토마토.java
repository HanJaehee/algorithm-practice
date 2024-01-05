import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static class Tomato {
    int z, x, y, Day;

    public Tomato(int h, int m, int n, int day) {
      z = h;
      x = m;
      y = n;
      Day = day;
    }
  }

  static Queue<Tomato> q = new LinkedList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    int H = Integer.parseInt(st.nextToken());

    int[][][] map = new int[H][N][M];


    int allTomato = 0;
    int ikTomato = 0;

    // 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
    int[] dx = {0, 0, 0, 0, 1, -1};
    int[] dy = {0, 0, 1, -1, 0, 0};
    int[] dz = {1, -1, 0, 0, 0, 0};

    for (int i = 0; i < H; i++) {
      for (int j = 0; j < N; j++) {
        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < M; k++) {
          map[i][j][k] = Integer.parseInt(st.nextToken());

          if (map[i][j][k] == 1) {
            q.add(new Tomato(i, k, j, 0));
            ikTomato++;
            allTomato++;
          } else if (map[i][j][k] == 0) {
            allTomato++;
          }
        }
      }
    }

    if (allTomato == ikTomato) {
      System.out.print(0);
      return;
    }

    int rx, ry, rz;
    int maxDay = -1;
    while (!q.isEmpty()) {
      Tomato t = q.poll();
      maxDay = Math.max(maxDay, t.Day);

      for (int i = 0; i < 6; i++) {
        rx = t.x + dx[i];
        ry = t.y + dy[i];
        rz = t.z + dz[i];

        if (rx >= 0 && rx < M && ry >= 0 && ry < N && rz >= 0 && rz < H && map[rz][ry][rx] == 0) {
          map[rz][ry][rx] = 1;
          q.add(new Tomato(rz, rx, ry, t.Day + 1));
          ikTomato++;
        }
      }
    }

    if (allTomato == ikTomato) {
      System.out.println(maxDay);
    } else {
      System.out.println(-1);
    }
  }
}
