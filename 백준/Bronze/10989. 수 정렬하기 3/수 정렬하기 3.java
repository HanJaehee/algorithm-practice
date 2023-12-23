import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] nums = br.readLine().split(" ");
    int N = Integer.parseInt(nums[0]);

    List<Integer> list = new ArrayList<>();

    int[] numCnt = new int[10001];
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());
      if (numCnt[num] == 0) {
        list.add(num);
      }
      numCnt[num]++;
    }

    Collections.sort(list);

    StringBuilder sb = new StringBuilder();

    list.forEach(a -> {
      if (numCnt[a] == 1) {
        sb.append(a).append("\n");
      } else {
        for (int i = 0; i < numCnt[a]; i++) {
          sb.append(a).append("\n");
        }
      }
    });

    System.out.println(sb);
  }
}
