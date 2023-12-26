import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[] nums = new int[N];
    int max = -1;
    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(br.readLine());
      max = Math.max(nums[i], max);
    }

    long[] arr = new long[max];

    process(arr, max);

    for (int i = 0; i < N; i++) {
      System.out.println(arr[nums[i]-1]);
    }
  }

  public static void process(long[] arr, int n) {
    arr[0] = 1;
    if (n <= 2) {
      return;
    }
    arr[1] = 1;
    if (n == 3) {
      return;
    }
    arr[2] = 1;

    for (int i = 3; i < n; i++) {
      arr[i] = arr[i - 2] + arr[i - 3];
    }
  }
}
