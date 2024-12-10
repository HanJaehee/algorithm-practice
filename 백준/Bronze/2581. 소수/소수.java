import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static boolean[] primes;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		primes = new boolean[M + 1];
		getPrimeNumbers();

		int minPrime = -1;
		int sumPrime = 0;

		for (int i = N; i <= M; i++) {
			 if(primes[i]){
				 sumPrime += i;
				 if (minPrime == -1) {
					 minPrime = i;
				 }
			 }
		}


		if(sumPrime == 0){
			System.out.println("-1");
		}else{
			System.out.println(sumPrime);
			System.out.println(minPrime);
		}
	}

	public static void getPrimeNumbers() {
		Arrays.fill(primes, true);

		primes[0] = primes[1] = false;

		int sqrt = (int) Math.sqrt(primes.length);
		for (int i = 2; i <= sqrt; i++) {
			if (primes[i]) {
				for (int j = 2; i * j <= primes.length-1; j++) {
					primes[i * j] = false;
				}
			}
		}
	}
}
