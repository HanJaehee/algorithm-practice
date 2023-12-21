import java.io.*;
import java.util.Stack;

public class Main {
  static Stack<Integer> stack = new Stack<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      execute(br.readLine());
    }
  }

  public static void execute(String command) {
    String[] cmds = command.split(" ");

    String cmd = cmds[0];

    if (cmd.equals("push")) {
      stack.push(Integer.parseInt(cmds[1]));
    } else if (cmd.equals("pop")) {
      System.out.println(stack.isEmpty() ? "-1" : stack.pop());
    } else if (cmd.equals("size")) {
      System.out.println(stack.size());
    } else if (cmd.equals("empty")) {
      System.out.println(stack.isEmpty() ? "1" : "0");
    } else { // top
      System.out.println(stack.isEmpty() ? "-1" : stack.peek());
    }
  }
}