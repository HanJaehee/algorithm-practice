import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int minX = 10001;
		int minY = 10001;
		int maxX = -10001;
		int maxY = -10001;

		StringTokenizer st;
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			minX = Math.min(minX, x);
			maxX = Math.max(maxX, x);
			minY = Math.min(minY, y);
			maxY = Math.max(maxY, y);
		}

		System.out.println((maxX - minX) * (maxY - minY));
	}
}
