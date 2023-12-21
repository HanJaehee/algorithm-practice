import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    String[] strNums = br.readLine().split(" ");

    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    int num;
    for (String strNum : strNums) {
      num = Integer.parseInt(strNum);

      max = Math.max(max, num);
      min = Math.min(min, num);
    }

    System.out.printf("%d %d", min, max);
  }
}
