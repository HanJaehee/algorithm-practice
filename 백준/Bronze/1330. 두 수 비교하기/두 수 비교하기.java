import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    String[] strNums = br.readLine().split(" ");

    int a = Integer.parseInt(strNums[0]);
    int b = Integer.parseInt(strNums[1]);

    if(a > b){
      System.out.println(">");
    }else if(a < b){
      System.out.println("<");
    }else{
      System.out.println("==");
    }
  }
}