package algorithm;

/**
 * Í³¼ÆËØÊı
 * @author Nacking
 *
 */
public class CountPrimes {
	public int countPrimes(int n) {

		if (n <= 2)
			return 0;

		if (n <= 3)
			return 1;

		int N = (n - 2) / 2;
		boolean[] prime = new boolean[N];
		for (int i = 0; i < N; i++) {
			prime[i] = true;
		}

		double sn = Math.sqrt(n);
		for (int i = 0; (2 * i + 3) <= sn; i++) {
			if (prime[i] == true) {
				int m = 2 * i + 3;
				for (int j = i+m; j < N; j += m) {
					prime[j] = false;
				}
			}
		}

		int count = 0;
		for (int i = 0; i < N; i++) {
			if (prime[i] == true) {
				count++;
				System.out.println(2*i+3);
			}
		}

		return count + 1;
	}
	
	public static void main(String[] args) {
		CountPrimes cp = new CountPrimes();
		System.out.println(cp.countPrimes(10000));
	}
}
