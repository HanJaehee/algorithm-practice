import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[][] arr = new int[N][2];

    for(int i=0; i<N ;i++){
      StringTokenizer st = new StringTokenizer(br.readLine());

      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      arr[i][0] = x;
      arr[i][1] = y;
    }

    Arrays.sort(arr, (a, b) -> {
      if(a[0] == b[0]){
        return a[1] - b[1];
      }else{
        return a[0] - b[0];
      }
    });

    StringBuilder sb = new StringBuilder();

    for(int[] num: arr){
      sb.append(num[0]).append(" ").append(num[1]).append("\n");
    }

    System.out.println(sb);
  }
}
