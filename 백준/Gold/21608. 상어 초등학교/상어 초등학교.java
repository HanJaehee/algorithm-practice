import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static int[] rx = {-1, 1, 0, 0};
  static int[] ry = {0, 0, 1, -1};
  static int N = -1;
  static int[][] map;
  static Set[] fav;
  static int[] order;

  public static class Point {
    int y, x, cnt, empty;

    Point(int y, int x, int cnt, int empty) {
      this.y = y;
      this.x = x;
      this.cnt = cnt;
      this.empty = empty;
    }

    @Override
    public String toString() {
      return y + " " + x + " " + cnt + " " + empty;
    }
  }

  static List<Point> points = new ArrayList<Point>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());

    int cnt = (int) Math.pow(N, 2);

    int num;

    fav = new Set[cnt + 1];
    map = new int[cnt][cnt];
    order = new int[cnt];

    for (int i = 0; i < cnt; i++) {
      st = new StringTokenizer(br.readLine());
      num = Integer.parseInt(st.nextToken());
      order[i] = num;

      fav[num] = new HashSet<Integer>();
      for (int j = 0; j < 4; j++) {
        fav[num].add(Integer.parseInt(st.nextToken()));
      }
    }

    for (int i = 0; i < cnt; i++) {
      if (i == 0) {
        map[1][1] = order[i];
      } else {
        search(order[i]);
      }
//      println();
//      System.out.println();
    }

    System.out.println(countGood());
  }

  static void search(int student) {

    // condition 1, 3
    points = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (map[i][j] == 0) {
          points.add(countAdj(student, i, j));
        }
      }
    }

    int max = -1, maxY = 0, maxX = 0, maxEmpty = -1;
//    System.out.println("===== " + student);
    for (Point p : points) {
//      System.out.println(p);
      // condition 2
      if (max < p.cnt || (max == p.cnt && maxEmpty < p.empty)) {

        max = p.cnt;
        maxY = p.y;
        maxX = p.x;
        maxEmpty = p.empty;
      }
    }

    map[maxY][maxX] = student;
  }

  static Point countAdj(int student, int y, int x) {
    int dy, dx, cnt = 0, empty = 0;
    for (int i = 0; i < 4; i++) {
      dy = y + ry[i];
      dx = x + rx[i];

      if (dy >= 0 && dy < N && dx >= 0 && dx < N) {
        if (fav[student].contains(map[dy][dx])) {
          cnt++;
        } else if (map[dy][dx] == 0) {
          empty++;
        }
      }
    }

    return new Point(y, x, cnt, empty);
  }

  static int countGood() {
    int sum = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        sum += countScore(i, j);
      }
    }

    return sum;
  }

  static int countScore(int y, int x) {
    int dy, dx, cnt = 0;
    for (int i = 0; i < 4; i++) {
      dy = y + ry[i];
      dx = x + rx[i];

      if (dy >= 0 && dy < N && dx >= 0 && dx < N) {
        if (fav[map[y][x]].contains(map[dy][dx])) {
          cnt++;
        }
      }
    }

    if (cnt == 0) {
      return 0;
    } else if (cnt == 1) {
      return 1;
    } else if (cnt == 2) {
      return 10;
    } else if (cnt == 3) {
      return 100;
    } else {
      return 1000;
    }
  }

  static void println() {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        System.out.print(map[i][j] + " ");
      }
      System.out.println();
    }
  }
}
