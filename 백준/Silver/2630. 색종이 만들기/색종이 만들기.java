import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int N, white, blue;
  static boolean[][] map;

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    map = new boolean[N][N];
    
    for (int i = 0; i < N; i++) {
      String[] str = br.readLine().split(" ");
      for (int j = 0; j < N; j++) {
        map[i][j] = str[j].equals("1");
      }
    }

    recur(0, 0, N);

    System.out.print(white + "\n" + blue);
  }

  private static void recur(int y, int x, int N) {
    if (chk(y, x, N, true)) { // 모두 파란색인지 체크
      blue++;
      return;
    }
    if (chk(y, x, N, false)) { // 모두 하얀색인지 체크
      white++;
      return;
    }

    recur(y, x, N / 2);
    recur(y + N / 2, x, N / 2);
    recur(y, x + N / 2, N / 2);
    recur(y + N / 2, x + N / 2, N / 2);
  }

  private static boolean chk(int y, int x, int N, boolean color) {
    for (int i = y; i < y + N; i++) {
      for (int j = x; j < x + N; j++) {
        if (map[i][j] != color) return false;
      }
    }
    return true;
  }
}
