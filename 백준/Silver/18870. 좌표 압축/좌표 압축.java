import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());


    int num;
    int[] nums = new int[N];
    st = new StringTokenizer(br.readLine());
    List<Integer> list = new ArrayList<>();
    Set<Integer> set = new HashSet<>();

    for (int i = 0; i < N; i++) {
      num = Integer.parseInt(st.nextToken());
      nums[i] = num;
      if (set.add(num)) {
        list.add(num);
      }
    }

    list.sort(Comparator.comparingInt(a -> a));

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < list.size(); i++) {
      map.put(list.get(i), i);
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      sb.append(map.get(nums[i])).append(" ");
    }

    System.out.println(sb);
  }
}
