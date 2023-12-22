import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static class Member {
    int age;
    String name;

    public Member(int age, String name) {
      this.age = age;
      this.name = name;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    List<Member> members = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int age = Integer.parseInt(st.nextToken());
      String name = st.nextToken();

      members.add(new Member(age, name));
    }

    members.sort((m1, m2) -> m1.age - m2.age);

    StringBuilder sb = new StringBuilder();
    members.forEach(member -> {
      sb.append(member.age).append(" ").append(member.name).append("\n");
    });

    System.out.println(sb);
  }
}
