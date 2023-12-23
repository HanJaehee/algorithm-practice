import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] nums = br.readLine().split(" ");
    int N = Integer.parseInt(nums[0]);
    int K = Integer.parseInt(nums[1]);

    List<Integer> list = new ArrayList<>();

    for(int i=1; i<=N; i++){
      list.add(i);
    }

    int cur = 0;

    StringBuilder sb = new StringBuilder();

    sb.append("<");
    while(N != 0){
      int idx = process(N, cur, K-1);
      if(N == 1) {
        sb.append(list.remove(idx)).append(">");
      }else{
        sb.append(list.remove(idx)).append(", ");
      }
      N -= 1;
      cur = idx;
    }

    System.out.println(sb);
  }

  public static int process(int n, int cur, int k) {
    int sum = cur + k;
    if (sum >= n) {
      return sum % n;
    } else {
      return sum;
    }
  }
}
