import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] nums = br.readLine().split(" ");

    int a = Integer.parseInt(nums[0]);
    int b = Integer.parseInt(nums[1]);

    int gcd = gcd(a, b);

    System.out.println(gcd);
    System.out.println(a * b / gcd);
  }

  public static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    } else {
      return gcd(b, a % b);
    }
  }
}
