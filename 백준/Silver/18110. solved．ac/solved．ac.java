import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    List<Integer> nums = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      nums.add(Integer.parseInt(br.readLine()));
    }

    Collections.sort(nums);

    int except = (int) Math.round(N * 0.15);

    int sum = 0;
    for (int i : nums.subList(except, N - except)) {
      sum += i;
    }

    System.out.println(Math.round(sum / (double)(N - except * 2)));
  }
}
