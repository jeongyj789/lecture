import java.util.Arrays;
import java.util.*;

public class Quick_sort_semi {

	static int cal = 4;
	static int cnt = 0;

	static void quicksort(int[] data, int n) {
		quicksort(data, 0, n - 1);
	}
	static void quicksort(int[] data, int f, int t) {
		// ������ �ʿ䰡 ���� ��� (�����Ͱ� 1�� ������ ���)
		if (t <= f)
			return;
		int s = partition(data, f, t);

		quicksort(data, f, s - 1);
		quicksort(data, s + 1, t);
	}
	
	static int partition(int[] data, int f, int t) {
		// �� ������ ���Ҹ� �������� ��´�.
		int pivot = data[t];
		System.out.println(Arrays.toString(data));
		System.out.println("�Ǻ� :" + pivot);
		int i = f, j = t - 1;
		while (i <= j) {
			// �������� �����Ͱ� ū ��� ���� ���ҿ� ��ȯ�Ѵ�.
			if (pivot < data[i]) {
				int temp = data[i];
				data[i] = data[j];
				data[j] = temp;
				j--;
			} else
				i++;
		}
		// �Ǻ��� i�� �ִ� ���� ��ȯ�Ѵ�.
		data[t] = data[i];
		data[i] = pivot;
		System.out.println(Arrays.toString(data));
		return i;
	}

	static int find(int[] data, int f, int t, int num) {
		
		// 30%, 20%, 10% �� ã�� ����

		int s = partition(data, f, t);
		System.out.println("s :" + s);
		System.out.println();

		if (num == 0) {
			return 0;
		}

		if (s == num) {
			System.out.println("�Ѿ��?");
			++cnt;
			if (cnt == 3) { // 10���������� �� ����
				System.out.println("10���������� ���� "+num);
				quicksort(data, 0, num);
				System.out.println("���� ��");
			}
			--cal;
			System.out.println((int) (num * (cal-1) / cal));
			return find(data, 0, s, (int)  (num * (cal-1) / cal));
		}
		
		if (s < num) {
			System.out.println("ã�´�1 :" + s);
			find(data, s + 1, t, num);
		} else {
			System.out.println("ã�´�2 :" + s);
			find(data, f, s - 1, num);
		}
		return 0;

	}

	public static void main(String[] args) {
		// ������ ������ 1,000���� �����Ѵ�.
		Random rand = new Random();

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n]; // int�� �迭 ����
		Random r = new Random(); // ��ü����
		for (int i = 0; i < n; i++) // ���� 6���� �̱����� for��
		{
			a[i] = r.nextInt(n) + 1;
			for (int j = 0; j < i; j++) {
				if (a[i] == a[j]) {
					i--;
				}
			}
		}

		find(a, 0, a.length - 1, (int) (n * 0.3));
		System.out.println("����" + Arrays.toString(a));
		System.out.println(n + "�� 30% :" + (int) (n * 0.3));
		System.out.println(n + "�� 20% :" + (int) (n * 0.2));
		System.out.println(n + "�� 10% :" + (int) (n * 0.1));
		
		
// ��Ƽ�Ǹ� ������ ������ ������ (�����̽�) �ټ�����   
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