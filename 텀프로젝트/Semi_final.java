
import java.util.*;

	public class Semi_final {
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
//			System.out.println(Arrays.toString(data));
//			System.out.println("피봇 :" + pivot);
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
//			System.out.println(Arrays.toString(data));
//			System.out.println("pivot의 index :" + i);
//			System.out.println();

			return i;
		}

		static int find(int[] data, int f, int t, int num) {

			// 30%, 20%, 10% 값 찾고 정렬
			// num 은 재귀를 통해 30%, 20%, 10% 값을 찾음

			int s = partition(data, f, t); // 최초 pivot의 index 찾기

			if (num == 0) { // num이 0 즉 10% 까지 다 돌고 더 찾으면 끝냄
				return 0;
			}

			if (s == num) { // pivot의 index 값이 num(30%, 20%, 10%)이랑 같아질 때
//				System.out.println("넘어가나?");
				
				++cnt;
				if (cnt == 3) { // cnt ==3 즉 num이 10% 도달 했을 때, 그전 값들은 강제 줄세우기
//					System.out.println("앞부분 정렬 시작");
					quicksort(data, 0, num);
//					System.out.println(Arrays.toString(data));
//					System.out.println("앞부분 정렬 끝");
					cnt =0; // 다음 배열값 계산을 위해서 초기화
					cal =4;
					return 0;
				}

				--cal; // 20% = 30%*2/3, 10% = 20%*1/2 관계를 이용해 재귀 함수 적용
//				System.out.println(num);
//				System.out.println(cal-1);
//				System.out.println(cal);
//				System.out.println(num*(cal-1));
//				System.out.println((int) (num * (cal - 1) / cal));
				return find(data, 0, s, (int) (num * (cal - 1) / cal));

			}

			if (s < num) { // 기준값 num 보다 작은 곳에 pivot이 위치하면 뒷배열 다시 partition
//				System.out.println("기준값 " + num + "보다 작으므로 :");
				find(data, s + 1, t, num);
			} else { // 기준값 num 보다 큰 곳에 pivot이 위치하면 앞배열 다시 partition
//				System.out.println("기준값 " + num + "보다 크므로 :");
				find(data, f, s - 1, num);
			}
			return 0;

		}

		public static int[] make(int n) {

			int data[] = new int[n];
			Random rand = new Random();
			int count = 0;
			for (int i = 0; i < n; i++) // 숫자 6개를 뽑기위한 for문
			{
				data[i] = rand.nextInt(100) + 1;
			}
			return data;
		}

		
		public static void value_check(int[] data, int start, int end, String loc) {

			int temp = data[start]; // temp 값 기준으로 제 구간에 속해있는지 확인
			for (int i = start + 1; i < end; i++) {
				if (data[i] < temp) {
					System.out.println("틀림");
//					System.out.println();
					return;

				}
			}
			System.out.println(loc+" 구간까지 맞음 "+"index :"+start+"부터 "+end+"까지");
//			System.out.println();
		}

		public static void time_check(int[] data, String msg) {

			long start = System.currentTimeMillis();
			long endTime = System.currentTimeMillis();
			System.out.println(msg + " 수행시간 : " + (endTime - start) / 1000.0f + "초");

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub

			Random rand = new Random();
			Scanner sc = new Scanner(System.in);


	// 랜덤 데이터를 통한 무결성 테스트		
			

			for (int i = 1; i <= 10; i++) {
				
				int n = i * 1000000;
				
				int data[] = new int[n];
				int data_copy[] = new int[n];

				for (int j = 0; j < n; j++) 
				{
					double x = Math.random(); // 0.0이상 1.0미만의 double 형태 난수
					x *= x;		
					data[j] = 1000000 + (int) (9000000 * x); // 점수 데이터 생성	
					data_copy[j] = data[j]; // 배열 복사
				}
				System.out.println();
				System.out.println(n+" 개의 배열 생성 완료");
				

//		index 값 정의 (0부터 시작)
				
				int cnt_30 = (int) (n * 0.3) - 1; // 상위 30% 인덱스
				int cnt_20 = (int) (n * 0.2) - 1; // 상위 20% 인덱스
				int cnt_10 = (int) (n * 0.1) - 1; // 상위 10% 인덱스
				
				if (cnt_30 < 0) {
					cnt_30 = 0;
				}
				if (cnt_20 < 0) {
					cnt_20 = 0;
				}
				if (cnt_10 < 0) {
					cnt_10 = 0;
				}


	// 알고리즘 시간

				long start = System.currentTimeMillis();
				find(data, 0, data.length - 1, cnt_30);
				long endTime = System.currentTimeMillis();
				System.out.println("새로운 알고리즘 수행시간 :" + (endTime - start) / 1000.0f + "초");
	// 기존 알고리즘  시작
				long start_1 = System.currentTimeMillis();
				Arrays.sort(data_copy);
				long endTime_1 = System.currentTimeMillis();
				System.out.println("기존 알고리즘 수행시간 :" + (endTime_1 - start_1) / 1000.0f + "초");

	// 데이터 무결성 체크

				value_check(data, 0, (cnt_10+1), "10%");
				value_check(data, cnt_10+1, (cnt_20+1), "20%");
				value_check(data, cnt_20+1, (cnt_30+1), "30%");
				value_check(data, cnt_30+1, (data.length), "마지막");

	// 결과 비교작업 
				
//				System.out.println(Arrays.toString(data));
//				System.out.println(Arrays.toString(data_copy));
			}
		}

	}
