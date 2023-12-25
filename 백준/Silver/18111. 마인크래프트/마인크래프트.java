import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());

    int[][] map = new int[N][M];

    int min = 256;
    int max = 0;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        min = Math.min(map[i][j], min);
        max = Math.max(map[i][j], max);
      }
    }

    int time = Integer.MAX_VALUE;
    int height = 0;
    int result;

    for (int i = max; i >= min; i--) {
      result = process(map, N, M, B, i);
      if (result == -1) continue;
      if (time > result) {
        time = result;
        height = i;
      }
    }

    System.out.println(time + " " + height);
  }

  public static int process(int[][] map, int N, int M, int B, int height) {
    int delCnt = 0;
    int addCnt = 0;
    int tmp = B;

    int cnt;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] < height) {
          cnt = height - map[i][j];

          addCnt += cnt;
          tmp -= cnt;
        } else if (map[i][j] > height) {
          cnt = map[i][j] - height;
          delCnt += cnt;
          tmp += cnt;
        }
      }
    }

    if (tmp < 0) return -1;

    return (delCnt * 2) + addCnt;
  }
}
