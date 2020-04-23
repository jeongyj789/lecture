
import java.util.Scanner;

public class practice_1 {
	public static void main(String[] args) {
		final int UNDEFINE = 0;
		final int PRIME = 1;
		final int NOT = 2;

		Scanner sc = new Scanner(System.in);
		int min = sc.nextInt();
		int max = sc.nextInt();

		int sum = 0;
		int minPrime = 0;
		boolean minFlg = true;

		int[] arr = new int[max + 1];
		arr[1] = NOT;
		for (int i = 2; i <= max; ++i) {
			boolean isPrime = true;
			if (arr[i] == UNDEFINE) {
				for (int j = 2; j < i; ++j)
					if (i % j == 0)
						isPrime = false;

				if (isPrime)
					arr[i] = PRIME;

				for (int j = 2 * i; j <= max; j = j + i)
					arr[j] = NOT;
			}
		}

		for (int i = min; i <= max; ++i) {
			if (arr[i] == PRIME) {
				sum += i;
				if (minFlg) {
					minPrime = i;
					minFlg = false;
				}
			}
		}

		if (sum != 0) {
			System.out.println(sum);
			System.out.println(minPrime);
		} else
			System.out.println(-1);
	}
}
