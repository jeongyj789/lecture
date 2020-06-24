
import java.util.*;

	public class REAL_FInal {
		static int cal = 4;
		static int cnt = 0;

		static void quicksort(double[] data, int n) {
			quicksort(data, 0, n - 1);
		}

		static void quicksort(double[] data, int f, int t) {
			// ������ �ʿ䰡 ���� ��� (�����Ͱ� 1�� ������ ���)
			if (t <= f)
				return;
			int s = partition(data, f, t);

			quicksort(data, f, s - 1);
			quicksort(data, s + 1, t);
		}

		static int partition(double[] data, int f, int t) {
			// �� ������ ���Ҹ� �������� ��´�.
			double pivot = data[t];
//			System.out.println(Arrays.toString(data));
//			System.out.println("�Ǻ� :" + pivot);
			int i = f, j = t - 1;
			while (i <= j) {
				// �������� �����Ͱ� ū ��� ���� ���ҿ� ��ȯ�Ѵ�.
				if (pivot < data[i]) {
					double temp = data[i];
					data[i] = data[j];
					data[j] = temp;
					j--;
				} else
					i++;
			}
			// �Ǻ��� i�� �ִ� ���� ��ȯ�Ѵ�.
			data[t] = data[i];
			data[i] = pivot;
//			System.out.println(Arrays.toString(data));
//			System.out.println("pivot�� index :" + i);
//			System.out.println();

			return i;
		}

		static int find(double[] data, int f, int t, int num) {
			// num �� ��͸� ���� 30%, 20%, 10% , 11��, 6�� ���� ã��
			int s = partition(data, f, t); // ���� pivot�� index ã��
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
					cnt =0; // ���� ����� ���ؼ� �ʱ�ȭ
					cal =4;
					return 0;
				}
				--cal; // 20% = 30%*2/3, 10% = 20%*1/2 ���踦 �̿��� ��� �Լ� ����
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
			for (int i = 0; i < n; i++) // ���� 6���� �̱����� for��
			{
				data[i] = rand.nextInt(100) + 1;
			}
			return data;
		}


		public static void value_check(double[] data, int start, int end, String loc) {

			double temp = data[start]; // temp �� �������� �� ������ �����ִ��� Ȯ��
			for (int i = start + 1; i < end; i++) {
				if (data[i] < temp) {
					System.out.println(loc+" ���� :"+(start+1)+"���� "+end+"���� Ʋ��");
					return;
				}
			}
			System.out.println(loc+" ���� :"+(start+2)+"���� "+end+"���� ����");
		}

		
		public static void time_check(int[] data, String msg) {

			long start = System.currentTimeMillis();
			long endTime = System.currentTimeMillis();
			System.out.println(msg + " ����ð� : " + (endTime - start) / 1000.0f + "��");

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub

			Random rand = new Random();
			Scanner sc = new Scanner(System.in);


	// ���� ������ ����	
			
			
//			int arr[] = {100, 500000, 1000000, 5000000, 10000000, 50000000, 100000000};
			
			for (int i = 1; i <= 10; i++) {
				int n = i*1000000;
//			for (int n:arr) {

				double data[] = new double[n];
				double data_copy[] = new double[n];

				for (int j = 0; j < n; j++) 
				{
					double x = Math.random(); // 0.0�̻� 1.0�̸��� double ���� ����
					x *= x;		
					data[j] = 10 + (90 * x); // ���� ������ ����	
					data_copy[j] = data[j]; // �迭 ����
				}
				System.out.println();
				System.out.println(n+" ���� �迭 ���� �Ϸ�");
				

//		index �� ���� (0���� ����)
				
				int cnt_30 = (int) (n * 0.3); // ���� 30% 
				int cnt_20 = (int) (n * 0.2); // ���� 20% 
				int cnt_10 = (int) (n * 0.1); // ���� 10% 
				
				if (cnt_30 < 0) {
					cnt_30 = 0;
				}
				if (cnt_20 < 0) {
					cnt_20 = 0;
				}
				if (cnt_10 < 0) {
					cnt_10 = 0;
				}


	// �˰��� �ð�
//				System.out.println();
//				System.out.println("������ ȿ���� �׽�Ʈ");
//				long start = System.currentTimeMillis();
//				find(data, 0, data.length - 1, cnt_30);
//				long endTime = System.currentTimeMillis();
//				System.out.println("���ο� �˰��� ����ð� :" + (endTime - start) / 1000.0f + "��");
				
	// ���� �˰���  ����
//				long start_1 = System.currentTimeMillis();
//				Arrays.sort(data_copy);
//				long endTime_1 = System.currentTimeMillis();
//				System.out.println("���� �˰��� ����ð� :" + (endTime_1 - start_1) / 1000.0f + "��");

	// ������ ���Ἲ üũ
				find(data, 0, data.length-1, cnt_30-1);
				System.out.println();
				System.out.println("������ ���Ἲ üũ");
				value_check(data, 0, 5, "1������ 5�� ");
				value_check(data, 5, 10, "6������ 10�� ");
				value_check(data, 10, (cnt_10), "10%");
				value_check(data, cnt_10-1, (cnt_20), "20%");
				value_check(data, cnt_20-1, (cnt_30), "30%");
				value_check(data, cnt_30-1, (data.length), "������");

	// ��� ���۾� 
				
//				System.out.println(Arrays.toString(data));
//				System.out.println(Arrays.toString(data_copy));
				

			}
		}
	}
	