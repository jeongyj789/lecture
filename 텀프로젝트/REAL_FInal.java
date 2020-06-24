
import java.util.*;

	public class REAL_FInal {
		static int cal = 4;
		static int cnt = 0;

		static void quicksort(double[] data, int n) {
			quicksort(data, 0, n - 1);
		}

		static void quicksort(double[] data, int f, int t) {
			// 정렬할 필요가 없는 경우 (데이터가 1개 이하인 경우)
			if (t <= f)
				return;
			int s = partition(data, f, t);

			quicksort(data, f, s - 1);
			quicksort(data, s + 1, t);
		}

		static int partition(double[] data, int f, int t) {
			// 맨 마지막 원소를 피폿으로 잡는다.
			double pivot = data[t];
//			System.out.println(Arrays.toString(data));
//			System.out.println("피봇 :" + pivot);
			int i = f, j = t - 1;
			while (i <= j) {
				// 피폿보다 데이터가 큰 경우 뒤의 원소와 교환한다.
				if (pivot < data[i]) {
					double temp = data[i];
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

		static int find(double[] data, int f, int t, int num) {
			// num 은 재귀를 통해 30%, 20%, 10% , 11위, 6위 값을 찾음
			int s = partition(data, f, t); // 최초 pivot의 index 찾기
			if (s == num) { 
				++cnt;
				if (cnt == 3) { 
					return find(data, 0, s, 10);
				}
				if (cnt == 4) {
					return find(data, 0, s, 5);
				}
				if (cnt ==5) {
					quicksort(data, 0, num-1);
					cnt =0; // 다음 계산을 위해서 초기화
					cal =4;
					return 0;
				}
				--cal; // 20% = 30%*2/3, 10% = 20%*1/2 관계를 이용해 재귀 함수 적용
				System.out.println("num :"+num);
				return find(data, 0, s, (int) (num * (cal - 1) / cal));
			}
			if (s < num) { 
				find(data, s + 1, t, num);
			} else { 
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


		public static void value_check(double[] data, int start, int end, String loc) {

			double temp = data[start]; // temp 값 기준으로 제 구간에 속해있는지 확인
			for (int i = start + 1; i < end; i++) {
				if (data[i] < temp) {
					System.out.println(loc+" 구간 :"+(start+1)+"부터 "+end+"까지 틀림");
					return;
				}
			}
			System.out.println(loc+" 구간 :"+(start+2)+"부터 "+end+"까지 맞음");
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


	// 랜덤 데이터 생성	
			
			
//			int arr[] = {100, 500000, 1000000, 5000000, 10000000, 50000000, 100000000};
			
			for (int i = 1; i <= 10; i++) {
				int n = i*1000000;
//			for (int n:arr) {

				double data[] = new double[n];
				double data_copy[] = new double[n];

				for (int j = 0; j < n; j++) 
				{
					double x = Math.random(); // 0.0이상 1.0미만의 double 형태 난수
					x *= x;		
					data[j] = 10 + (90 * x); // 점수 데이터 생성	
					data_copy[j] = data[j]; // 배열 복사
				}
				System.out.println();
				System.out.println(n+" 개의 배열 생성 완료");
				

//		index 값 정의 (0부터 시작)
				
				int cnt_30 = (int) (n * 0.3); // 상위 30% 
				int cnt_20 = (int) (n * 0.2); // 상위 20% 
				int cnt_10 = (int) (n * 0.1); // 상위 10% 
				
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
//				System.out.println();
//				System.out.println("데이터 효율성 테스트");
//				long start = System.currentTimeMillis();
//				find(data, 0, data.length - 1, cnt_30);
//				long endTime = System.currentTimeMillis();
//				System.out.println("새로운 알고리즘 수행시간 :" + (endTime - start) / 1000.0f + "초");
				
	// 기존 알고리즘  시작
//				long start_1 = System.currentTimeMillis();
//				Arrays.sort(data_copy);
//				long endTime_1 = System.currentTimeMillis();
//				System.out.println("기존 알고리즘 수행시간 :" + (endTime_1 - start_1) / 1000.0f + "초");

	// 데이터 무결성 체크
				find(data, 0, data.length-1, cnt_30-1);
				System.out.println();
				System.out.println("데이터 무결성 체크");
				value_check(data, 0, 5, "1위부터 5위 ");
				value_check(data, 5, 10, "6위부터 10위 ");
				value_check(data, 10, (cnt_10), "10%");
				value_check(data, cnt_10-1, (cnt_20), "20%");
				value_check(data, cnt_20-1, (cnt_30), "30%");
				value_check(data, cnt_30-1, (data.length), "마지막");

	// 결과 비교작업 
				
//				System.out.println(Arrays.toString(data));
//				System.out.println(Arrays.toString(data_copy));
				

			}
		}
	}
	