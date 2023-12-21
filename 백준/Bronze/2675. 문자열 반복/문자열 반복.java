import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      String[] strings = br.readLine().split(" ");

      System.out.println(makeString(Integer.parseInt(strings[0]), strings[1]));
    }
  }

  public static String makeString(int r, String str) {
    StringBuilder br = new StringBuilder();

    for (int i = 0; i < str.length(); i++) {
      br.append(String.valueOf(str.charAt(i)).repeat(r));
    }

    return br.toString();
  }
}
