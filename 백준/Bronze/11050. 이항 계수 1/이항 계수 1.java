import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] nums = br.readLine().split(" ");
    int N = Integer.parseInt(nums[0]);
    int K = Integer.parseInt(nums[1]);

    System.out.println(factorial(N) / (factorial(N - K) * factorial(K)));

  }

  public static int factorial(int n) {
    int result = 1;
    for(int i=1; i<=n; i++){
      result *= i;
    }

    return result;
  }
}
