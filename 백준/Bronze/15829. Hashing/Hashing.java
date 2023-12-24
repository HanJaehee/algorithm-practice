import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int L = Integer.parseInt(br.readLine());

    long[] cache = new long[L];
    buildCache(cache);

    String str = br.readLine();

    long sum = 0;

    for (int i = 0; i < L; i++) {
      sum += mod(cache, str.charAt(i) - 'a' + 1, i);
    }

    System.out.println(sum);
  }

  public static void buildCache(long[] cache) {
    cache[0] = 1;
    for (int i = 1; i < cache.length; i++) {
      cache[i] = cache[i - 1] * 31;
    }
  }

  public static long mod(long[] cache, int n, int i) {
    return n * cache[i];
  }
}
