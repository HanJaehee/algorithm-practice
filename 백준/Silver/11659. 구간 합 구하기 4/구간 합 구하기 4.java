import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] nums = new int[N + 1];
    st = new StringTokenizer(br.readLine());

    for (int i = 1; i <= N; i++) {
      nums[i] = nums[i - 1] + Integer.parseInt(st.nextToken());
    }

    int start, end;
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      start = Integer.parseInt(st.nextToken());
      end = Integer.parseInt(st.nextToken());

      System.out.println(nums[end] - nums[start-1]);
    }
  }
}
