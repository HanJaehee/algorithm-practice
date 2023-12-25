import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    if (N == 1) {
      System.out.println(1);
      return;
    } else if (N == 2) {
      System.out.println(2);
      return;
    }

    long[] map = new long[N + 1];

    map[0] = 0;
    map[1] = 1;
    map[2] = 2;
    for (int i = 3; i <= N; i++) {
      map[i] = (map[i - 1] + map[i - 2]) % 10007;
    }

    System.out.println(map[N]);
  }
}
