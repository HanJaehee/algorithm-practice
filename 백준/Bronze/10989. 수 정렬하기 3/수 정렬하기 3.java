import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    
    int[] numCnt = new int[10001];
    
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());
      numCnt[num]++;
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= 10000; i++) {
      if(numCnt[i] != 0) {
        for (int j = 0; j < numCnt[i]; j++) {
          sb.append(i).append("\n");
        }
      }
    };

    System.out.println(sb);
  }
}
