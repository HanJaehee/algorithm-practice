import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[] arr = new int[N + 1];
    int[] result = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    result[1] = arr[1];

    if (N >= 2) {
      result[2] = arr[1] + arr[2];
    }

    for (int i = 3; i <= N; i++) {
      result[i] = Math.max(result[i - 2], arr[i - 1] + result[i - 3]) + arr[i];
    }

    System.out.println(result[N]);
  }
}
