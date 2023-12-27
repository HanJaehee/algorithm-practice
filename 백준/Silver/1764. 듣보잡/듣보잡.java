import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    Set<String> notHeard = new HashSet<>();

    int result = 0;
    for (int i = 0; i < N; i++) {
      notHeard.add(br.readLine());
    }

    String notSeen;
    List<String> notHeardSeen = new ArrayList<>();
    for (int i = 0; i < M; i++) {
      notSeen = br.readLine();

      if (notHeard.contains(notSeen)) {
        notHeardSeen.add(notSeen);
        result++;
      }
    }

    notHeardSeen.sort(String::compareTo);

    StringBuilder sb = new StringBuilder();

    sb.append(result).append("\n");
    notHeardSeen.forEach(a -> sb.append(a).append("\n"));

    System.out.println(sb);
  }
}
