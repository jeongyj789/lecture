import java.util.Arrays;
import java.util.*;

public class Quick_sort_semi {

	static int cal = 4;
	static int cnt = 0;

	static void quicksort(int[] data, int n) {
		quicksort(data, 0, n - 1);
	}
	static void quicksort(int[] data, int f, int t) {
		// 정렬할 필요가 없는 경우 (데이터가 1개 이하인 경우)
		if (t <= f)
			return;
		int s = partition(data, f, t);

		quicksort(data, f, s - 1);
		quicksort(data, s + 1, t);
	}
	
	static int partition(int[] data, int f, int t) {
		// 맨 마지막 원소를 피폿으로 잡는다.
		int pivot = data[t];
		System.out.println(Arrays.toString(data));
		System.out.println("피봇 :" + pivot);
		int i = f, j = t - 1;
		while (i <= j) {
			// 피폿보다 데이터가 큰 경우 뒤의 원소와 교환한다.
			if (pivot < data[i]) {
				int temp = data[i];
				data[i] = data[j];
				data[j] = temp;
				j--;
			} else
				i++;
		}
		// 피봇과 i에 있는 값과 교환한다.
		data[t] = data[i];
		data[i] = pivot;
		System.out.println(Arrays.toString(data));
		return i;
	}

	static int find(int[] data, int f, int t, int num) {
		
		// 30%, 20%, 10% 값 찾고 정렬

		int s = partition(data, f, t);
		System.out.println("s :" + s);
		System.out.println();

		if (num == 0) {
			return 0;
		}

		if (s == num) {
			System.out.println("넘어가나?");
			++cnt;
			if (cnt == 3) { // 10프로전까지 퀵 정렬
				System.out.println("10프로전까지 정렬 "+num);
				quicksort(data, 0, num);
				System.out.println("정렬 끝");
			}
			--cal;
			System.out.println((int) (num * (cal-1) / cal));
			return find(data, 0, s, (int)  (num * (cal-1) / cal));
		}
		
		if (s < num) {
			System.out.println("찾는다1 :" + s);
			find(data, s + 1, t, num);
		} else {
			System.out.println("찾는다2 :" + s);
			find(data, f, s - 1, num);
		}
		return 0;

	}

	public static void main(String[] args) {
		// 랜덤한 데이터 1,000개를 생성한다.
		Random rand = new Random();

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n]; // int형 배열 선언
		Random r = new Random(); // 객체생성
		for (int i = 0; i < n; i++) // 숫자 6개를 뽑기위한 for문
		{
			a[i] = r.nextInt(n) + 1;
			for (int j = 0; j < i; j++) {
				if (a[i] == a[j]) {
					i--;
				}
			}
		}

		find(a, 0, a.length - 1, (int) (n * 0.3));
		System.out.println("최종" + Arrays.toString(a));
		System.out.println(n + "의 30% :" + (int) (n * 0.3));
		System.out.println(n + "의 20% :" + (int) (n * 0.2));
		System.out.println(n + "의 10% :" + (int) (n * 0.1));
		
		
// 파티션만 나누고 여러번 나누고 (슬라이싱) 줄세우기는   
// https://hanxxang.tistory.com/12
// https://wogh8732.tistory.com/9

//		quicksort(data, 1000);
//		Arrays.sort(temp);
//		int check = 0;
//		for(int i=0;i<1000;i++) {
//			if(data[i]!=temp[i]) check++;
//		}
//		System.out.println("Error check is "+check);

	}

}