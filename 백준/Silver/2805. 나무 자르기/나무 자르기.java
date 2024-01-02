import com.sun.source.tree.OpensTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N, M;
  static int[] trees;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    trees = new int[N];

    int min = 0, max = 0;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      trees[i] = Integer.parseInt(st.nextToken());

      max = Math.max(trees[i], max);
    }

    while (min < max) {
      int mid = (min + max) / 2;
      long sum = 0;
      for (int tree : trees) {
        if (tree - mid > 0) {
          sum += (tree - mid);
        }
      }

      if(sum < M){
        max = mid;
      }else{
        min = mid + 1;
      }
    }


    System.out.println(min -1);
  }
}
