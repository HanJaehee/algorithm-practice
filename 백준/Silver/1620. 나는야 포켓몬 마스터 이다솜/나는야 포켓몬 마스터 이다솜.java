import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    List<String> list = new ArrayList<>();

    Map<Integer, String> intToStrMap = new HashMap<>();
    Map<String, Integer> strToIntMap = new HashMap<>();
    String str;
    for (int i = 0; i < N; i++) {
      str = br.readLine();
      intToStrMap.put(i + 1, str);
      strToIntMap.put(str, i + 1);
    }

    for (int i = 0; i < M; i++) {
      str = br.readLine();
      try {
        int num = Integer.parseInt(str);
        System.out.println(intToStrMap.get(num));
      } catch (NumberFormatException e) {
        System.out.println(strToIntMap.get(str));
      }
    }
  }
}
