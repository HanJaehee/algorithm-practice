import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static boolean[] primes;
	static List<Integer> primesNumbers = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		primes = new boolean[N + 1];
		getPrimeNumbers();

		if(N == 1){
			return;
		}

		while(N != 1) {
			N = primeFactorization(N);
		}
	}

	public static int primeFactorization(int N) {
		for (Integer primeNumber : primesNumbers) {
			if (N % primeNumber == 0) {
				System.out.println(primeNumber);
				return N / primeNumber;
			}
		}

		return -1;
	}

	public static void getPrimeNumbers() {
		Arrays.fill(primes, true);

		primes[0] = primes[1] = false;

		int sqrt = (int)Math.sqrt(primes.length);
		for (int i = 2; i <= sqrt; i++) {
			if (primes[i]) {
				for (int j = 2; i * j <= primes.length - 1; j++) {
					primes[i * j] = false;
				}
			}
		}

		for (int i = 2; i < primes.length; i++) {
			if (primes[i]) {
				primesNumbers.add(i);
			}
		}
	}
}
