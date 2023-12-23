import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] nums = br.readLine().split(" ");
    int N = Integer.parseInt(nums[0]);
    int K = Integer.parseInt(nums[1]);

//    System.out.println(factorial(N) / (factorial(N - K) * factorial(K)));
    System.out.println(BC(N,K));

  }

  public static int factorial(int n) {
    if (n == 1) {
      return 1;
    } else {
      return factorial(n - 1) * n;
    }
  }

  public static int BC(int N, int K) {
    if (N == K || K == 0) {
      return 1;
    }

    return BC(N - 1, K - 1) + BC(N - 1, K);
  }
}
